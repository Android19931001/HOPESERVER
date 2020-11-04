package com.hope.server.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangning
 */
@Data
@ConfigurationProperties(prefix = "properties",ignoreUnknownFields = false)
public class PropertiesQuery {
    private String filePath;
}
