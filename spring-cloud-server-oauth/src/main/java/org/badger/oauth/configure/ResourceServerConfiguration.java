package org.badger.oauth.configure;

import org.badger.oauth.oauth.Oauth2AuthenticationEntryPoint;
import org.badger.oauth.oauth.handler.Oauth2AccessDeniedHandler;
import org.badger.oauth.oauth.handler.Oauth2LoginFailureHandler;
import org.badger.oauth.oauth.handler.Oauth2LoginSuccessHandler;
import org.badger.oauth.oauth.handler.Oauth2LogoutSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/4/8 16:23
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private Logger logger = LoggerFactory.getLogger(org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration.class);

    @Autowired
    private Oauth2AuthenticationEntryPoint oauth2AuthenticationEntryPoint;
    @Autowired
    private Oauth2AccessDeniedHandler oauth2AccessDeniedHandler;
    @Autowired
    private Oauth2LoginSuccessHandler oauth2LoginSuccessHandler;
    @Autowired
    private Oauth2LoginFailureHandler oauth2LoginFailureHandler;
    @Autowired
    public Oauth2LogoutSuccessHandler oauth2LogoutSuccessHandler;

    /**
     * 1:
     * 请求授权:
     * spring security 使用以下匹配器来匹配请求路劲：
     * antMatchers:使用ant风格的路劲匹配
     * regexMatchers:使用正则表达式匹配路劲
     * anyRequest:匹配所有请求路劲
     * 在匹配了请求路劲后，需要针对当前用户的信息对请求路劲进行安全处理。
     * 2:定制登录行为。
     * formLogin()方法定制登录操作
     * loginPage()方法定制登录页面访问地址
     * defaultSuccessUrl()登录成功后转向的页面
     * permitAll()
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .successHandler(oauth2LoginSuccessHandler)
                .failureHandler(oauth2LoginFailureHandler)
                .permitAll()
            .and()
                //配置用户无权限登录过滤器
                .exceptionHandling()
                .authenticationEntryPoint(oauth2AuthenticationEntryPoint)
                // 配置用户无权限登录过滤器
                .accessDeniedHandler(oauth2AccessDeniedHandler)
            .and()
                .logout()
                .permitAll()
                .logoutUrl("/oauth/logout")
                .logoutSuccessHandler(oauth2LogoutSuccessHandler)
            .and()
                .authorizeRequests()
                .antMatchers("/", "/oauth/**", "/v2/api-docs", "/actuator/**", "/login", "/demo/**").permitAll()
                .antMatchers("/api/**")
                .authenticated()
            //除上述URL,都需要登录用户
            .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
            .and()
                .csrf().disable();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(new Oauth2AuthenticationEntryPoint());
    }
}
