package com.hope.server.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author wangning
 */
@Slf4j
public class HopeGatewayFilter implements GatewayFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put("requestTime", System.currentTimeMillis());
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute("requestTime");
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ": " + (System.currentTimeMillis() - startTime) + "ms");
                    }
                }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
