package com.hope.gateway.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author wangning
 */
@Component
@ConfigurationProperties(prefix = "hope.header")
@PropertySource("classpath:config/application.yml")
public class YmlConfig {

    private String hopeheaderkey;

    private String hopeheadervalue;

    public String getHopeheaderkey() {
        return hopeheaderkey;
    }

    public void setHopeheaderkey(String hopeheaderkey) {
        this.hopeheaderkey = hopeheaderkey;
    }

    public String getHopeheadervalue() {
        return hopeheadervalue;
    }

    public void setHopeheadervalue(String hopeheadervalue) {
        this.hopeheadervalue = hopeheadervalue;
    }
}
