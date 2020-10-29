package com.hope.server;

import com.hope.server.utils.YmlConfig;
import com.server.service.utils.StartUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;

/**
 * @author wangning
 */
@SpringBootApplication
@EnableConfigurationProperties({YmlConfig.class})
public class GatewayApplication {


    public static void main(String[] args) {
        Environment environment = SpringApplication
                .run(GatewayApplication.class, args)
                .getEnvironment();
        StartUtils.logApplicationInfo(environment);
    }

}
