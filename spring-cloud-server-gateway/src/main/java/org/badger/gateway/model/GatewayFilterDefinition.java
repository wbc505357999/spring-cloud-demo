package org.badger.gateway.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 过滤器定义模型
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 13:21
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public class GatewayFilterDefinition implements Serializable {
    /**
     * Filter Name
     */
    private String name;
    /**
     * 对应的路由规则
     */
    private Map<String, String> args = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
