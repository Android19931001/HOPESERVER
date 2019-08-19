package com.hope.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author wangning
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication extends WebSecurityConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(EurekaApplication.class, args).getEnvironment();
        String hostName = environment.getProperty("eureka.instance.hostname");
        logger.info("\n--------------------------------------------------------\nEureka local address : {}\n" +
                "--------------------------------------------------------\n", "http://" + hostName + ":4670");
    }

    /**
     * eureka添加安全认证之后默认开启了scrf，需要手动关闭
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.csrf().disable();
        //注意：为了可以使用 http://${user}:${password}@${host}:${port}/eureka/ 这种方式登录,所以必须是httpBasic,
        // 如果是form方式,不能使用url格式登录
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
