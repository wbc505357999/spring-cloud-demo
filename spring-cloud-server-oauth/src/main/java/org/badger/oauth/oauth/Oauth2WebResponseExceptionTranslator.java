package org.badger.oauth.oauth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * 自定义异常转换类
 *
 * @author wubc
 * @version 1.0
 * @date 2019/1/25 11:01
 */
@Component
public class Oauth2WebResponseExceptionTranslator implements WebResponseExceptionTranslator {
    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) {
        if (e instanceof InvalidGrantException) {
            return ResponseEntity.status(200).body(new Oauth2Exception("用户名或密码不正确"));
        } else {
            OAuth2Exception oAuth2Exception = (OAuth2Exception) e;
            return ResponseEntity.status(oAuth2Exception.getHttpErrorCode()).body(new Oauth2Exception(oAuth2Exception.getMessage()));
        }
    }
}
