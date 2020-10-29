package com.hope.server.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.RequestPath;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.*;

/**
 * @author wangning
 */
@Slf4j
@Component
public class RequestFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        RequestPath requestPath = exchange.getRequest().getPath();
        Map headerMap = this.getAllHeadersRequest(exchange.getRequest());
        Map parameterMap = this.getAllParametersRequest(exchange.getRequest());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }


    /**
     * 获取全部参数
     *
     * @param * @param request
     * @return java.util.Map
     * @author wangning
     * @date 2020/10/14
     */
    private Map getAllParametersRequest(ServerHttpRequest request) {
        log.info("getAllParametersRequest开始............");
        Map map = new LinkedHashMap();
        MultiValueMap<String, String> paramNames = request.getQueryParams();
        Iterator it = paramNames.keySet().iterator();
        while (it.hasNext()) {
            String paramName = (String) it.next();

            List<String> paramValues = paramNames.get(paramName);
            if (paramValues.size() >= 1) {
                String paramValue = paramValues.get(0);
                log.info("request参数：" + paramName + ",值：" + paramValue);
                map.put(paramName, paramValue);
            }
        }
        return map;
    }

    /**
     * 获取头部数据
     *
     * @param * @param request
     * @return java.util.Map
     * @author wangning
     * @date 2020/10/14
     */
    private Map getAllHeadersRequest(ServerHttpRequest request) {
        log.info("getAllHeadersRequest开始............");
        Map map = new LinkedHashMap();
        HttpHeaders headers = request.getHeaders();
        Iterator it = headers.keySet().iterator();
        while (it.hasNext()) {
            String keyName = (String) it.next();

            List<String> headValues = headers.get(keyName);
            if (headValues.size() >= 1) {
                String keyValue = headValues.get(0);
                log.info("request header的key：" + keyName + ",值：" + keyValue);
                map.put(keyName, keyValue);
            }
        }
        return map;
    }
}
