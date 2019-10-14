package org.badger.oauth.entity;

import lombok.Data;
import org.badger.oauth.base.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * User实体类
 *
 * @author baichuan.wu
 * @version 1.0
 * @date 2019/04/08  14:11:48
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Data
@Table(name = "sys_user")
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /**
     *
     */
    @Column(name = "account")
    private String account;

    /**
     * 用户名
     */
    @Column(name = "name")
    private String name;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 头像
     */
    @Column(name = "head_url")
    private String headUrl;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 状态 0:禁用，1:正常
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 创建用户id
     */
    @Column(name = "create_user_id")
    private Long createUserId;

    /**
     * 是否允许
     */
    @Column(name = "is_enable")
    private Boolean isEnable;

    /**
     * 是否锁定帐号
     */
    @Column(name = "is_locked")
    private Boolean isLocked;

    /**
     * 是否是超级管理员
     */
    @Column(name = "is_admin")
    private Boolean isAdmin;

    /**
     *
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 登录时间
     */
    @Column(name = "last_login_time")
    private Date lastLoginTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 用户角色
     */
    private Set<String> roles;

    /**
     * 用户权限
     */
    private Set<String> authorities;


}
