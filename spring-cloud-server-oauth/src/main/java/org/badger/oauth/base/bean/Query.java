package org.badger.oauth.base.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 公共查询参数（分页/排序）
 *
 * @author 吴佰川(baichuan.wu @ ucarinc.com)
 * @version 1.0
 * @date 2019/4/3 18:07
 * @copyright www.ucarinc.com All Rights Reserved.
 */
@Data
public class Query implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 分页大小，默认10
     */
    private Integer pageSize = 10;

    /**
     * 偏移量
     */
    private Integer offset;

    /**
     * 偏移数
     */
    private Integer limit;

    public Integer getPageNum() {
        if (this.pageNum == null || this.pageNum < 1) {
            this.pageNum = 1;
        }
        return pageNum;
    }

    public Integer getPageSize() {
        if (this.pageSize == null || this.pageSize < 1) {
            this.pageSize = 10;
        }
        return pageSize;
    }

    public Integer getOffset() {
        return (this.getPageNum() - 1) * getPageSize();
    }

    public Integer getLimit() {
        return getPageSize();
    }

}
