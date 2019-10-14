package org.badger.oauth.constant;

/**
 * @author 吴佰川（baichuan.wu@ucarinc.com）
 * @version 1.0 2019/1/25 10:57 by 吴佰川（baichuan.wu@ucarinc.com）创建
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public class AuthConstant {
    // token有效期，默认12小时
    public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 60 * 60 * 12;
    // token有效期，默认7天
    public static final int REFRESH_TOKEN_VALIDITY_SECONDS = 60 * 60 * 24 * 7;
}
