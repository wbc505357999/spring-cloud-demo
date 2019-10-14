package org.badger.oauth.base.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础mapper
 *
 * @author wubc
 * @version 1.0
 * @date 2019/1/21 16:19
 */
public interface BaseMapper<T> extends Mapper<T>, IdsMapper<T>, MySqlMapper<T>, ConditionMapper<T> {
}
