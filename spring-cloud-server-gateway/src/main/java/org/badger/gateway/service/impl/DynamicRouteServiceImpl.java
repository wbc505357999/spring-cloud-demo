package org.badger.gateway.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import org.badger.gateway.model.GatewayPredicateDefinition;
import org.badger.gateway.model.GatewayRouteDefinition;
import org.badger.gateway.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 13:17
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Service
public class DynamicRouteServiceImpl implements DynamicRouteService, ApplicationEventPublisherAware {
    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public String add(RouteDefinition definition) {
        routeDefinitionWriter.save(Mono.just(definition)).subscribe();
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        return "success";
    }

    @Override
    public String update(RouteDefinition definition) {
        try {
            this.routeDefinitionWriter.delete(Mono.just(definition.getId()));
        } catch (Exception e) {
            return "update fail,not find route  routeId: " + definition.getId();
        }
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            return "success";
        } catch (Exception e) {
            return "update route  fail";
        }
    }

    @Override
    public Mono<ResponseEntity<Object>> delete(String id) {
        return this.routeDefinitionWriter.delete(Mono.just(id))
                .then(Mono.defer(() -> Mono.just(ResponseEntity.ok().build())))
                .onErrorResume(t -> t instanceof NotFoundException, t -> Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * spring:
     cloud:
     gateway:
     routes: #当访问http://localhost:8080/baidu,直接转发到https://www.baidu.com/
     - id: baidu_route
     uri: http://baidu.com:80/
     predicates:
     - Path=/baidu
     * @param args
     */

    public static void main(String[] args) {
        GatewayRouteDefinition definition = new GatewayRouteDefinition();
        GatewayPredicateDefinition predicate = new GatewayPredicateDefinition();
        Map<String, String> predicateParams = new HashMap<>(8);
        definition.setId("jd_route");
        predicate.setName("Path");
        predicateParams.put("pattern", "/jd");
        predicate.setArgs(predicateParams);
        definition.setPredicates(Arrays.asList(predicate));
        String uri="http://www.jd.com";
        //URI uri = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
        definition.setUri(uri);
        System.out.println("definition:"+ JSON.toJSONString(definition));

        RouteDefinition definition1 = new RouteDefinition();
        PredicateDefinition predicate1 = new PredicateDefinition();
        Map<String, String> predicateParams1 = new HashMap<>(8);
        definition1.setId("baidu_route");
        predicate1.setName("Path");
        predicateParams1.put("pattern", "/baidu");
        predicate1.setArgs(predicateParams1);
        definition1.setPredicates(Arrays.asList(predicate1));
        URI uri1 = UriComponentsBuilder.fromHttpUrl("http://www.baidu.com").build().toUri();
        definition1.setUri(uri1);
        System.out.println("definition1："+JSON.toJSONString(definition1));
    }

}
