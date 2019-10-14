package org.badger.oauth.base.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.badger.oauth.base.bean.Page;
import org.badger.oauth.base.entity.BaseEntity;
import org.badger.oauth.base.mapper.BaseMapper;
import org.badger.oauth.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基础service实现类
 *
 * @author wubc
 * @version 1.0
 * @date 2019/1/21 17:23
 */
public abstract class BaseServiceImpl<PK, T extends BaseEntity> implements BaseService<PK, T> {
    @Autowired
    protected BaseMapper<T> baseMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(T record) {
        return baseMapper.delete(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(PK id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(T record) {
        return baseMapper.deleteByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByCondition(Condition condition) {
        return baseMapper.deleteByCondition(condition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByExample(Example example) {
        return baseMapper.deleteByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIds(String ids) {
        return baseMapper.deleteByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUseGeneratedKeys(T record) {
        return baseMapper.insertUseGeneratedKeys(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertList(List<T> recordList) {
        return baseMapper.insertList(recordList);
    }

    @Override
    public T selectOne(T record) {
        return baseMapper.selectOne(record);
    }

    @Override
    public T selectByPrimaryKey(PK id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(T record) {
        return baseMapper.selectByPrimaryKey(record);
    }

    @Override
    public T selectOneByExample(Example example) {
        return baseMapper.selectOneByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByExample(T record, Example example) {
        return baseMapper.updateByExample(record, example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByExampleSelective(T record, Example example) {
        return baseMapper.updateByExampleSelective(record, example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByCondition(T record, Object condition) {
        return baseMapper.updateByCondition(record, condition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByConditionSelective(T record, Object condition) {
        return baseMapper.updateByConditionSelective(record, condition);
    }

    @Override
    public int selectCount(T record) {
        return baseMapper.selectCount(record);
    }

    @Override
    public int selectCountByCondition(Condition condition) {
        return baseMapper.selectCountByCondition(condition);
    }

    @Override
    public int selectCountByExample(Example example) {
        return baseMapper.selectCountByExample(example);
    }

    @Override
    public List<T> select(T record) {
        return baseMapper.select(record);
    }

    @Override
    public List<T> selectByIds(String ids) {
        return baseMapper.selectByIds(ids);
    }

    @Override
    public List<T> selectByCondition(Condition condition) {
        return baseMapper.selectByCondition(condition);
    }

    @Override
    public List<T> selectByExample(Example example) {
        return baseMapper.selectByExample(example);
    }

    @Override
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return baseMapper.selectByRowBounds(record, rowBounds);
    }

    @Override
    public List<T> selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public List<T> selectList(int pageNum, int pageSize) {
        return this.selectList(null, pageNum, pageSize);
    }

    @Override
    public List<T> selectList(T record, int pageNum, int pageSize) {
        return this.selectList(record, new RowBounds((pageNum - 1) * pageSize, pageSize));
    }

    @Override
    public List<T> selectList(T record, RowBounds rowBounds) {
        return baseMapper.selectByRowBounds(record, rowBounds);
    }

    @Override
    public Page<T> selectPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(selectAll());
        return new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Page<T> selectPage(int pageNum, int pageSize, boolean count) {
        PageHelper.startPage(pageNum, pageSize, count);
        PageInfo<T> pageInfo = new PageInfo<>(selectAll());
        return new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Page<T> selectPage(T record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<T> pageInfo = new PageInfo<>(select(record));
        return new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public Page<T> selectPage(T record, int pageNum, int pageSize, boolean count) {
        PageHelper.startPage(pageNum, pageSize, count);
        PageInfo<T> pageInfo = new PageInfo<>(select(record));
        return new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getList(), pageInfo.getTotal());
    }

    @Override
    public PageInfo<T> selectPageInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(selectAll());
    }

    @Override
    public PageInfo<T> selectPageInfo(int pageNum, int pageSize, boolean count) {
        PageHelper.startPage(pageNum, pageSize, count);
        return new PageInfo<>(selectAll());
    }

    @Override
    public PageInfo<T> selectPageInfo(T record, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(select(record));
    }

    @Override
    public PageInfo<T> selectPageInfo(T record, int pageNum, int pageSize, boolean count) {
        PageHelper.startPage(pageNum, pageSize, count);
        return new PageInfo<>(select(record));
    }
}
