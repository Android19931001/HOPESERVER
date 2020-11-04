package com.hope.server;

import com.hope.server.utils.PropertiesQuery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import com.server.service.utils.StartUtils;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wangning
 */

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableTransactionManagement
@EnableConfigurationProperties({PropertiesQuery.class})
public class ControllerApplication {

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(ControllerApplication.class, args).getEnvironment();
        StartUtils.logApplicationInfo(environment);
    }

}
