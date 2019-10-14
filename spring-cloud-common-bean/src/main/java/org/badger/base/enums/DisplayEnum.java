package org.badger.base.enums;

/**
 * 显示/隐藏枚举
 *
 * @author wubc
 * @version V1.0
 * @date 2018年9月4日 下午5:59:19
 */
public enum DisplayEnum implements EnumValue {

    /**
     * 隐藏
     */
    HIDDEN(0, "隐藏"),
    /**
     * 显示
     */
    VISIBLE(1, "显示");

    /**
     * 枚举值
     */
    private final int code;

    /**
     * 描述
     */
    private final String name;

    DisplayEnum(final int code, final String name) {
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
