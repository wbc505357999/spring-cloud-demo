package org.badger.oauth.service.impl;

import org.badger.oauth.base.service.impl.BaseServiceImpl;
import org.badger.oauth.entity.User;
import org.badger.oauth.mapper.UserMapper;
import org.badger.oauth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User接口实现类
 *
 * @author baichuan.wu
 * @version 1.0
 * @date null
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<Long, User> implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserMapper userMapper;

    @Override
    public String test() {
        throw new RuntimeException("测试");
    }
}
