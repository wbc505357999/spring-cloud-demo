package org.badger.oauth.oauth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0 2019/1/25 11:24 by 吴佰川（baichuan.wu@ucarinc.com）创建
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public class Oauth2User implements UserDetails {
    private static final long serialVersionUID = -123308657146774881L;
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户账户
     */
    private String account;
    /**
     * 登录名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 是否超级管理员
     */
    private boolean isAdmin;

    /**
     * 用户菜单权限
     */
    private Set<String> permessions;

    /**
     * 用户角色权限
     */
    private Set<String> authorities;

    /**
     * 是否已锁定
     */
    private boolean accountNonLocked;
    /**
     * 是否已过期
     */
    private boolean accountNonExpired;
    /**
     * 是否启用
     */
    private boolean isEnabled;
    /**
     * 密码是否已过期
     */
    private boolean credentialsNonExpired;
    /**
     * 认证客户端ID
     */
    private String authAppId;
    /**
     * 认证中心ID,适用于区分多用户源,多认证中心
     */
    private String authCenterId;

    /**
     * 只是客户端模式.不包含用户信息
     *
     * @return
     */
    public Boolean onlyClient() {
        return authAppId != null && userId == null;
    }

    public Oauth2User(String authCenterId, Long userId, String account, String username, String password, boolean isAdmin, boolean accountNonLocked, boolean accountNonExpired, boolean isEnabled, boolean credentialsNonExpired, Set<String> authorities, Set<String> permessions) {
        this.authCenterId = authCenterId;
        this.userId = userId;
        this.account = account;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.accountNonLocked = accountNonLocked;
        this.accountNonExpired = accountNonExpired;
        this.isEnabled = isEnabled;
        this.credentialsNonExpired = credentialsNonExpired;
        this.authorities = authorities;
        this.permessions = permessions;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities == null) {
            return Collections.EMPTY_LIST;
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils
                .collectionToCommaDelimitedString(authorities));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        isAdmin = isAdmin;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = isEnabled;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public String getAuthAppId() {
        return authAppId;
    }

    public void setAuthAppId(String authAppId) {
        this.authAppId = authAppId;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public String getAuthCenterId() {
        return authCenterId;
    }

    public void setAuthCenterId(String authCenterId) {
        this.authCenterId = authCenterId;
    }

    public Set<String> getPermessions() {
        return permessions;
    }

    public void setPermessions(Set<String> permessions) {
        this.permessions = permessions;
    }
}
