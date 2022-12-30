package com.server.service;

import com.server.service.utils.StartUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;

/**
 * @author wangning
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceApplication {


    public static void main(String[] args) {
        Environment environment = SpringApplication.run(ServiceApplication.class, args).getEnvironment();
        StartUtils.logApplicationInfo(environment);
    }

}
