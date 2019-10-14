package org.badger.oauth.service.impl;

import org.badger.oauth.entity.User;
import org.badger.oauth.oauth.Oauth2User;
import org.badger.oauth.service.OauthUserDetailsService;
import org.badger.oauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户详情
 *
 * @author wubc
 * @version 1.0
 * @date 2019/1/25 14:02
 */
@Service
public class OauthUserDetailsServiceImpl implements OauthUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(OauthUserDetailsServiceImpl.class);
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        User query = new User();
        query.setAccount(account);
        User user = userService.selectOne(query);
        if (user == null) {
            throw new UsernameNotFoundException("用户" + account + "不存在");
        }
        logger.info("userDetail:{}", user.toString());
        // 用户权限
        Set<String> permessions = new HashSet<>();
        permessions.add("test1");
        // 用户角色
        Set<String> authorities = new HashSet<>();
        authorities.add("admin");
        return new Oauth2User(account, user.getUserId(), user.getAccount(), user.getName(), user.getPassword(), user.getIsAdmin(), !user.getIsLocked(), true, user.getIsEnable(), true, authorities, permessions);
    }

}
