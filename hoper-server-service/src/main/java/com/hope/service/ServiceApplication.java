package com.hope.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import utils.StartUtils;

/**
 * @author wangning
 */
@SpringBootApplication
//@EnableEurekaClient
public class ServiceApplication {

//    private static Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(ServiceApplication.class, args).getEnvironment();
        /*StartUtils.logApplicationInfo(logger, environment);*/
    }

}
