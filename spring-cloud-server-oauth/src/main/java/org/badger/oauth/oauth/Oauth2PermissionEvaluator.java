package org.badger.oauth.oauth;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/4/9 16:12
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Component
public class Oauth2PermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        Oauth2User user = (Oauth2User) authentication.getPrincipal();
        if (user.getIsAdmin()) {
            return true;
        } else if (user.getPermessions().contains(permission)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
