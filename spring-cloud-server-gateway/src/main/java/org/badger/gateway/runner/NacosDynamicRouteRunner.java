package org.badger.gateway.runner;

import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.badger.gateway.properties.GatewayProperties;
import org.badger.gateway.service.DynamicRouteService;
import org.badger.gateway.util.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 13:51
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Component
public class NacosDynamicRouteRunner implements CommandLineRunner {
    @Autowired
    private GatewayProperties gatewayProperties;
    @Autowired
    private DynamicRouteService dynamicRouteService;
    @Autowired
    private NacosConfigService nacosConfigService;

    @Override
    public void run(String... args) throws Exception {
        dynamicRouteByNacosListener();
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener() {
        String dataId = gatewayProperties.getNacos().getDataId();
        String group = gatewayProperties.getNacos().getGroup();
        Long timeout = gatewayProperties.getNacos().getTimeout();
        try {
           // String content = nacosConfigService.getConfig(dataId, group, timeout);
            //System.out.println(content);
            nacosConfigService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    List<RouteDefinition> list = JacksonUtil.jsonToList(configInfo, RouteDefinition.class);
                    for (RouteDefinition routeDefinition : list) {
                        dynamicRouteService.update(routeDefinition);
                    }
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            //todo 提醒:异常自行处理此处省略
        }
    }
}
