package com.hope.server.utils;

import org.slf4j.Logger;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * @author wangning
 */
public class StartUtils {

    /**
     * 打印应用相关信息
     */
    public static void logApplicationInfo(Logger logger, Environment environment) {
        String protocol = "http";
        if (null != environment.getProperty("server.ssl.key-store")) {
            protocol = "https";
        }
        try {
            String serverPort = environment.getProperty("server.port");
            String address = InetAddress.getLocalHost().getHostAddress();
            /*logger.info("\n-----------------------The request url is-----------------------" +
                            "\n\tLocal: {}://localhost:{}\n\tExternal: {}://{}:{}" +
                            "\n-----------------------The server is start-----------------------"
                    , protocol, serverPort, protocol, address, serverPort);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印微服务应用相关信息
     */
    public static void logAppInfoWithHostName(Logger logger, Environment environment) {
        String protocol = "http";
        if (null != environment.getProperty("server.ssl.key-store")) {
            protocol = "https";
        }
        try {
            String serverPort = environment.getProperty("server.port");
            String hostName = environment.getProperty("server.instance.hostname");
            String address = InetAddress.getLocalHost().getHostAddress();
            /*logger.info("\n-----------------------The request url is-----------------------" +
                            "\n\tserver: {}://{}:{}/server/\n " + "\n---------------------- - The server is start---------------------- - "
                    , protocol, hostName, serverPort);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
