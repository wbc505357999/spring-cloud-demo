package org.badger.gateway.configuration;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import org.badger.gateway.properties.GatewayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.alibaba.nacos.NacosConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 14:11
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Configuration
@EnableConfigurationProperties({GatewayProperties.class})
public class GatewayConfiguration {
    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Bean
    @ConditionalOnMissingBean
    public NacosConfigService nacosConfigService() throws NacosException {
        Properties properties = new Properties();
        properties.put("serverAddr", nacosConfigProperties.getServerAddr());
        return new NacosConfigService(properties);
    }
}
