package org.badger.gateway.service;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface DynamicRouteService {
    /**
     * 增加路由
     *
     * @param definition
     * @return java.lang.String
     */
    String add(RouteDefinition definition);
    /**
     * 更新路由
     *
     * @param definition
     * @return java.lang.String
     */
    String update(RouteDefinition definition);
    /**
     * 删除路由
     *
     * @param id
     * @return reactor.core.publisher.Mono<org.springframework.http.ResponseEntity<java.lang.Object>>
     */
    Mono<ResponseEntity<Object>> delete(String id);
}
