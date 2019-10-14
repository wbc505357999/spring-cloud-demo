package org.badger.oauth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.badger.oauth.base.mapper.BaseMapper;
import org.badger.oauth.entity.User;

/**
 * User接口类
 *
 * @author baichuan.wu
 * @version 1.0
 * @date 2019/04/08  14:11:48
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    int selectTest();
}
