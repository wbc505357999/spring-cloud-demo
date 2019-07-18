package org.badger.gateway.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 14:03
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Configuration
@ConfigurationProperties(prefix = "micro.framework.gateway")
public class GatewayProperties {
    private Nacos nacos;

    public Nacos getNacos() {
        return nacos;
    }

    public void setNacos(Nacos nacos) {
        this.nacos = nacos;
    }

    /**
     * nacos配置
     */
    public static class Nacos {
        private String address;

        private String dataId;

        private String group = "DEFAULT_GROUP";

        private Long timeout = 5000L;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getDataId() {
            return dataId;
        }

        public void setDataId(String dataId) {
            this.dataId = dataId;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public Long getTimeout() {
            return timeout;
        }

        public void setTimeout(Long timeout) {
            this.timeout = timeout;
        }
    }

}
