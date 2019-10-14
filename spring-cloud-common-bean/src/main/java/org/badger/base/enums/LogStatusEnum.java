package org.badger.base.enums;

/**
 * 日志类型枚举
 *
 * @author wubc
 * @version 1.0
 * @date 2019/6/27 11:21
 */
public enum LogStatusEnum implements EnumValue{

    /**
     * 成功
     */
    SUCCESS(200, "成功"),

    /**
     * 错误
     */
    ERROR(202, "错误");

    private final int code;
    private final String name;

    LogStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }
}
