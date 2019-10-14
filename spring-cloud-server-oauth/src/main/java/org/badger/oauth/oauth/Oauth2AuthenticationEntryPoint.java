package org.badger.oauth.oauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hikari.common.base.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义Token异常信息
 *
 * @author 吴佰川(baichuan.wu @ ucarinc.com)
 * @version 1.0
 * @date 2019/4/8 17:04
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Component
public class Oauth2AuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        // 401无权限
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        objectMapper.writeValue(response.getOutputStream(), Result.failure(authException.getMessage()));
    }
}
