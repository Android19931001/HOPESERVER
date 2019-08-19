package com.hope.gateway;

import com.hope.gateway.utils.YmlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import utils.StartUtils;

/**
 * @author wangning
 */
@SpringBootApplication
@EnableConfigurationProperties({YmlConfig.class})
public class GatewayApplication {

    private static Logger logger = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        Environment environment = SpringApplication.run(GatewayApplication.class, args).getEnvironment();
        StartUtils.logApplicationInfo(logger, environment);
    }

}
