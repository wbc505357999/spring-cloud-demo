package org.badger.oauth.service;

import org.badger.oauth.base.service.BaseService;
import org.badger.oauth.entity.User;

/**
 * User接口类
 *
 * @author baichuan.wu
 * @version 1.0
 * @date null
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public interface UserService extends BaseService<Long, User> {
    String test();
}
