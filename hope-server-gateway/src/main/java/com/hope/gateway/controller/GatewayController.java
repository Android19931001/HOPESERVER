package com.hope.gateway.controller;

import com.hope.gateway.utils.YmlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangning
 */
@RestController
public class GatewayController {
//
//    @Autowired
//    YmlConfig ymlConfig;
//
//    @Bean
//    public RouteLocator hopeRouteLocator(RouteLocatorBuilder locatorBuilder) {
//        return locatorBuilder.routes()
//                .route(p -> p
//                        .path("/interface")
//                        .filters(f -> {
//                                    f.stripPrefix(1);
//                                    f.addRequestHeader(ymlConfig.getHopeheaderkey(), ymlConfig.getHopeheadervalue());
//                                    return f;
//                                }
//                        )
//                        .uri("http://localhost:4672"))
//                .build();
////        return locatorBuilder
////                .routes()
////                .route("hope_path",
////                        r -> r.path("/interface")
////                                .uri("http://localhost:4672/interface/getOmCustCashBaseById/FJ-YF-19-000071"))
////                .build();
//    }
}
