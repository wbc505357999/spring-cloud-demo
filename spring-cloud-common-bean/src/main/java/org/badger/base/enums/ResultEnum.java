package org.badger.base.enums;

/**
 * 状态枚举 启用:1,禁用:0
 *
 * @author wubc
 * @version V1.0
 * @date 2018年9月4日 下午5:59:34
 */
public enum ResultEnum implements EnumValue {
    /**
     * 操作成功
     */
    OPERATE_SUCCESS(200, 200, "success"),
    /**
     * 操作失败
     */
    OPERATE_FAILURE(201, 201, "failure"),
    /**
     * 操作错误
     */
    OPERATE_ERROR(202, 202, "error"),
    /**
     * token过期
     */
    TOKEN_EXPIRED(203, 203, "token expried"),
    /**
     * token错误
     */
    TOKEN_ERROR(204, 204, "token error");

    private final int status;
    private final int code;
    private final String name;

    ResultEnum(final int status, final int code, final String name) {
        this.status = status;
        this.code = code;
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
