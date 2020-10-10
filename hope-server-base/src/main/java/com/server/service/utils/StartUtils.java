package com.server.service.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author wangning
 */
@Slf4j
public class StartUtils {

    /**
     * 打印应用相关信息
     */
    public static void logApplicationInfo(Environment environment) {
        String protocol = "http";
        if (null != environment.getProperty("server.ssl.key-store")) {
            protocol = "https";
        }
        try {
            String serverPort = environment.getProperty("server.port");
            String address = InetAddress.getLocalHost().getHostAddress();
            log.info("\n-----------------------The request url is-----------------------" +
                            "\n\tLocalAdd: {}://localhost:{}\n\tExternal: {}://{}:{}" +
                            "\n-----------------------The server is start-----------------------"
                    , protocol, serverPort, protocol, address, serverPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
