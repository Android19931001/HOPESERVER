package com.hope.server;

import com.server.service.utils.YmlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import com.server.service.utils.StartUtils;

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
