package org.badger.oauth.oauth.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.badger.base.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/4/10 11:22
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Component
public class Oauth2LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String message;
        response.setContentType("application/json;charset=UTF-8");
        if (exception instanceof BadCredentialsException) {
            message = "用户名或密码错误";
            response.getWriter().write(objectMapper.writeValueAsString(Result.failure(message)));
        }
    }
}
