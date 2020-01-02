package com.hope.server.controller;

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
