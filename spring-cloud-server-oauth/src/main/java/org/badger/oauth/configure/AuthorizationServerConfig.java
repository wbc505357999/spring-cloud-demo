package org.badger.oauth.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/7/18 16:33
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
}
