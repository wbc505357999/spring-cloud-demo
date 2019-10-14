package org.badger.base.enums;

/**
 * 环境枚举
 *
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/6/27 14:01
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public enum EnvironmentEnum implements EnumValue {
    /**
     * 开发环境
     */
    DEV(1, "dev", "开发环境"),
    /**
     * 测试1环境
     */
    TEST(2, "test", "测试1环境"),

    /**
     * 测试2环境
     */
    TEST2(4, "test2", "测试2环境"),
    /**
     * 测试3环境
     */
    TEST3(5, "test3", "测试3环境"),
    /**
     * 预生产环境
     */
    PRE(6, "pre", "预生产环境"),
    /**
     * 性能测试环境
     */
    PERF(7, "perf", "性能测试环境"),
    /**
     * 生产环境
     */
    PROD(8, "prod", "生产环境");

    private int code;

    private String name;

    private String description;


    EnvironmentEnum(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public static EnvironmentEnum getEnvEnum(int code) {
        for (EnvironmentEnum envEnum : EnvironmentEnum.values()) {
            if (envEnum.getCode() == (code)) {
                return envEnum;
            }
        }
        throw new IllegalArgumentException("Illegal Argument env:" + code);
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
