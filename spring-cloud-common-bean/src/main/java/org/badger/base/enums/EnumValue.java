package org.badger.base.enums;

/**
 * Enum的公用实现接口,通过实现这个接口，使Enum的通用操作中实现"索引"-"名字"的使用方式
 *
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0
 * @date 2019/6/27 14:09
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public interface EnumValue {

    /**
     * 获取code
     *
     * @return Enum中定义的code
     */
    int getCode();

    /**
     * 获取名称
     *
     * @return Enum中定义的名字
     */
    String getName();

}
