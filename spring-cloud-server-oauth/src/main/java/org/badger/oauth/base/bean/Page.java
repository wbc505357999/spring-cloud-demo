package org.badger.oauth.base.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author 吴佰川(baichuan.wu @ ucarinc.com)
 * @version 1.0
 * @date 2019/4/3 18:20
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 默认当前页码
     */
    private final static int DEFAULT_PAGE_NO = 1;

    /**
     * 默认查询记录数
     */
    private final static int DEFAULT_PAGE_SIZE = 15;

    /**
     * 查询对象
     * 参数类型:输入
     */
    private T object;

    /**
     * 页码
     * 参数类型:输入
     */
    private int pageNum = DEFAULT_PAGE_NO;

    /**
     * 每页记录数
     * 参数类型:输入
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 记录总数
     * 参数类型:输出
     */
    private long total;

    /**
     * 记录结果集
     */
    private List<T> list;

    public Page(int pageNum, int pageSize, List<T> list, long total) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.list = list;
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    /**
     * 下一页
     *
     * @return
     */
    public int nextPageNo() {
        return hasNextPage() ? (pageNum + 1) : pageNum;
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public boolean hasNextPage() {
        return (lastPageNo() == pageNum) ? false : true;
    }

    /**
     * 最后一页
     *
     * @return
     */
    public int lastPageNo() {
        return (int) total / pageSize + ((total % pageSize != 0) ? 1 : 0);
    }

    public int getTotalPage() {
        return (int) total / pageSize + ((total % pageSize != 0) ? 1 : 0);
    }

}
