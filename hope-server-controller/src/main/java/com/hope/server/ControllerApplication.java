package com.hope.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import com.server.service.utils.StartUtils;

/**
 * @author wangning
 */

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ControllerApplication {


    public static void main(String[] args) {
        Environment environment = SpringApplication.run(ControllerApplication.class, args).getEnvironment();
        StartUtils.logApplicationInfo(environment);
    }

}
