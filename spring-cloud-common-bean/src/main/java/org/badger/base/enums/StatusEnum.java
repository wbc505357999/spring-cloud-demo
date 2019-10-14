package org.badger.base.enums;

/**
 * 状态枚举 启用:1,禁用:0
 *
 * @author wubc
 * @version V1.0
 * @date 2018年9月4日 下午5:59:34
 */
public enum StatusEnum implements EnumValue {

    /**
     * 禁用
     */
    DISABLE(0, "禁用"),
    /**
     * 启用
     */
    ENABLE(1, "启用");

    /**
     * 枚举值
     */
    private final int code;

    /**
     * 描述
     */
    private final String name;

    StatusEnum(final int code, final String name) {
        this.code = code;
        this.name = name;
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
