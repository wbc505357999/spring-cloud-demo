package org.badger.oauth.base.service;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.badger.oauth.base.bean.Page;
import org.badger.oauth.base.entity.BaseEntity;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基础service接口
 *
 * @author wubc
 * @version 1.0
 * @date 2019/1/21 17:22
 */
public interface BaseService<PK, T extends BaseEntity> {

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record 实体
     * @return int
     */
    int delete(T record);

    /**
     * 根据id删除
     *
     * @param id 主键
     * @return int
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 根据id删除
     *
     * @param record 实体
     * @return int
     */
    int deleteByPrimaryKey(T record);

    /**
     * 根据条件删除数据
     *
     * @param condition 条件
     * @return int
     */
    int deleteByCondition(Condition condition);

    /**
     * 根据Example条件删除数据，返回删除的条数
     *
     * @param example Example条件
     * @return int
     */
    int deleteByExample(Example example);

    /**
     * 根据主键@Id进行删除，多个Id以逗号,分割
     *
     * @param ids 多条id字符串
     * @return int
     */
    int deleteByIds(String ids);

    /**
     * 保存一个实体，null属性也会保存
     *
     * @param record 实体
     * @return int
     */
    int insert(T record);

    /**
     * 保存一个实体，null属性不会保存
     *
     * @param record 实体
     * @return int
     */
    int insertSelective(T record);

    /**
     * 插入数据，限制为实体包含`id`属性并且必须为自增列，实体配置的主键策略无效
     *
     * @param record 实体
     * @return int
     */
    int insertUseGeneratedKeys(T record);

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     *
     * @param recordList 实体列表
     * @return int
     */
    int insertList(List<T> recordList);


    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param record 实体
     * @return T
     */
    T selectOne(T record);

    /**
     * 根据id查询
     *
     * @param id 主键id
     * @return T
     */
    T selectByPrimaryKey(PK id);

    /**
     * 根据实体参数查询唯一
     *
     * @param record 实体
     * @return T
     */
    T selectByPrimaryKey(T record);

    /**
     * 根据Example条件进行查询，若有多条数据则抛出异常
     *
     * @param example 条件
     * @return T
     */
    T selectOneByExample(Example example);

    /**
     * 根据id更新实体
     *
     * @param record 实体
     * @return int
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record 实体
     * @return int
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据Example条件更新实体`record`包含的全部属性，null值会被更新，返回更新的条数
     *
     * @param record  实体
     * @param example 条件
     * @return int
     */
    int updateByExample(T record, Example example);

    /**
     * 据Example条件更新实体`record`包含的不是null的属性值，返回更新的条数
     *
     * @param record  实体
     * @param example Example条件
     * @return int
     */
    int updateByExampleSelective(T record, Example example);

    /**
     * 根据Condition条件更新实体`record`包含的全部属性，null值会被更新，返回更新的条数
     *
     * @param record    实体
     * @param condition Condition条件
     * @return int
     */
    int updateByCondition(T record, Object condition);

    /**
     * 根据Condition条件更新实体`record`包含的全部属性，null值会被更新，返回更新的条数
     *
     * @param record    实体
     * @param condition Condition条件
     * @return int
     */
    int updateByConditionSelective(T record, Object condition);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param record 实体
     * @return int
     */
    int selectCount(T record);

    /**
     * 根据条件统计数据
     *
     * @param condition 条件
     * @return java.util.List<T>
     */
    int selectCountByCondition(Condition condition);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example 条件
     * @return java.util.List<T>
     */
    int selectCountByExample(Example example);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param record 实体
     * @return java.util.List<T>
     */
    List<T> select(T record);

    /**
     * 根据主键@Id进行查询，多个Id以逗号,分割
     *
     * @param ids 多条id字符串
     * @return java.util.List<T>
     */
    List<T> selectByIds(String ids);

    /**
     * 根据条件查询列表
     *
     * @param condition 条件
     * @return java.util.List<T>
     */
    List<T> selectByCondition(Condition condition);

    /**
     * 根据Example条件进行查询
     *
     * @param example 条件
     * @return java.util.List<T>
     */
    List<T> selectByExample(Example example);

    /**
     * 根据实体分页查询
     *
     * @param record    实体
     * @param rowBounds 分页参数
     * @return java.util.List<T>
     */
    List<T> selectByRowBounds(T record, RowBounds rowBounds);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     *
     * @return java.util.List<T>
     */
    List<T> selectAll();

    /**
     * 分页查询
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @return java.util.List<T>
     */
    List<T> selectList(int pageNum, int pageSize);

    /**
     * 分页查询
     *
     * @param record   实体
     * @param pageNum  页码
     * @param pageSize 页数
     * @return java.util.List<T>
     */
    List<T> selectList(T record, int pageNum, int pageSize);

    /**
     * 分页查询
     *
     * @param record    实体
     * @param rowBounds
     * @return java.util.List<T>
     */
    List<T> selectList(T record, RowBounds rowBounds);

    /**
     * 查询分页信息
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @return java.util.List<T>
     */
    Page<T> selectPage(int pageNum, int pageSize);

    /**
     * 查询分页信息
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @param count    是否统计总数
     * @return java.util.List<T>
     */
    Page<T> selectPage(int pageNum, int pageSize, boolean count);

    /**
     * 查询分页信息
     *
     * @param record   实体
     * @param pageNum  页码
     * @param pageSize 页数
     * @return com.github.pagehelper.PageInfo<T>
     */
    Page<T> selectPage(T record, int pageNum, int pageSize);

    /**
     * 查询分页信息
     *
     * @param record   实体
     * @param pageNum  页码
     * @param pageSize 页数
     * @param count    是否统计总数
     * @return com.github.pagehelper.PageInfo<T>
     */
    Page<T> selectPage(T record, int pageNum, int pageSize, boolean count);

    /**
     * 查询分页信息
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @return java.util.List<T>
     */
    PageInfo<T> selectPageInfo(int pageNum, int pageSize);

    /**
     * 查询分页信息
     *
     * @param pageNum  页码
     * @param pageSize 页数
     * @param count    是否统计总数
     * @return java.util.List<T>
     */
    PageInfo<T> selectPageInfo(int pageNum, int pageSize, boolean count);

    /**
     * 查询分页信息
     *
     * @param record   实体
     * @param pageNum  页码
     * @param pageSize 页数
     * @return com.github.pagehelper.PageInfo<T>
     */
    PageInfo<T> selectPageInfo(T record, int pageNum, int pageSize);

    /**
     * 查询分页信息
     *
     * @param record   实体
     * @param pageNum  页码
     * @param pageSize 页数
     * @param count    是否统计总数
     * @return com.github.pagehelper.PageInfo<T>
     */
    PageInfo<T> selectPageInfo(T record, int pageNum, int pageSize, boolean count);

}
