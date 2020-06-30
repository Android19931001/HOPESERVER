package com.hope.server.config;

import com.hope.server.filter.HopeGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class HopeFilterConfig {

    @Bean
    public RouteLocator hopeRequestLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/*")
                        .filters(f -> f.filter(new HopeGatewayFilter())
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("/**")
                        .order(0)
                        .id("hope_filter_router")
                )
                .build();
    }
}
