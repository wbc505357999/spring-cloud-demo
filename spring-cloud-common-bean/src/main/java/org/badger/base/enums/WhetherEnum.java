package org.badger.base.enums;

/**
 * 是否枚举 是:1,否:0
 *
 * @author wubc
 * @version V1.0
 * @date 2018年9月4日 下午5:59:42
 */
public enum WhetherEnum implements EnumValue {

    /**
     * 否
     */
    NO(0, "否"),
    /**
     * 是
     */
    YES(1, "是");

    /**
     * 枚举值
     */
    private final int code;

    /**
     * 描述
     */
    private final String name;

    WhetherEnum(final int code, final String name) {
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
