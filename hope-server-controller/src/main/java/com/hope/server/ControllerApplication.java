package com.hope.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import com.hope.server.utils.StartUtils;

/**
 * @author wangning
 */

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ControllerApplication {

    private static Logger logger = LoggerFactory.getLogger(ControllerApplication.class);

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(ControllerApplication.class, args).getEnvironment();
        StartUtils.logApplicationInfo(logger, environment);
    }

}