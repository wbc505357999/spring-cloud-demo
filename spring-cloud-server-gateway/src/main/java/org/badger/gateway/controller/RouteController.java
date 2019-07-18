package org.badger.gateway.controller;

import org.badger.gateway.model.GatewayFilterDefinition;
import org.badger.gateway.model.GatewayPredicateDefinition;
import org.badger.gateway.model.GatewayRouteDefinition;
import org.badger.gateway.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由
 *
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 13:20
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@RestController
@RequestMapping("/route/")
public class RouteController {
    @Autowired
    private DynamicRouteService dynamicRouteService;
    @Autowired
    private RouteDefinitionLocator routeDefinitionLocator;

    /**
     * 获取网关所有的路由信息
     *
     * @return reactor.core.publisher.Flux<org.springframework.cloud.gateway.route.RouteDefinition>
     */
    @RequestMapping("list")
    public Flux<RouteDefinition> getRouteDefinitions() {
        return routeDefinitionLocator.getRouteDefinitions();
    }

    /**
     * 增加路由
     *
     * @param gwdefinition
     * @return java.lang.String
     */
    @PostMapping("add")
    public String add(@RequestBody GatewayRouteDefinition gwdefinition) {
        try {
            RouteDefinition definition = assembleRouteDefinition(gwdefinition);
            return this.dynamicRouteService.add(definition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "succss";
    }

    /**
     * 删除路由
     *
     * @param id
     * @return reactor.core.publisher.Mono<org.springframework.http.ResponseEntity               <               java.lang.Object>>
     */
    @DeleteMapping("delete/{id}")
    public Mono<ResponseEntity<Object>> delete(@PathVariable String id) {
        return this.dynamicRouteService.delete(id);
    }

    /**
     * 更新路由
     *
     * @param gwdefinition
     * @return java.lang.String
     */
    @PostMapping("update")
    public String update(@RequestBody GatewayRouteDefinition gwdefinition) {
        RouteDefinition definition = assembleRouteDefinition(gwdefinition);
        return this.dynamicRouteService.update(definition);
    }

    private RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gwdefinition) {
        RouteDefinition definition = new RouteDefinition();
        // ID
        definition.setId(gwdefinition.getId());
        // Predicates
        List<PredicateDefinition> pdList = new ArrayList<>();
        for (GatewayPredicateDefinition gpDefinition : gwdefinition.getPredicates()) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        definition.setPredicates(pdList);
        // Filters
        List<FilterDefinition> fdList = new ArrayList<>();
        for (GatewayFilterDefinition gfDefinition : gwdefinition.getFilters()) {
            FilterDefinition filter = new FilterDefinition();
            filter.setArgs(gfDefinition.getArgs());
            filter.setName(gfDefinition.getName());
            fdList.add(filter);
        }
        definition.setFilters(fdList);
        // URI
        URI uri = UriComponentsBuilder.fromUriString(gwdefinition.getUri()).build().toUri();
        definition.setUri(uri);
        return definition;
    }

}
