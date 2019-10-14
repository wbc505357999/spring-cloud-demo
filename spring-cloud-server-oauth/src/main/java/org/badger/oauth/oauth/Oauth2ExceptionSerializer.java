package org.badger.oauth.oauth;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.hikari.common.base.bean.Result;
import com.hikari.common.exception.Oauth2Exception;

import java.io.IOException;

/**
 * 自定义序列化
 *
 * @author 吴佰川(baichuan.wu @ ucarinc.com)
 * @version 1.0
 * @date 2019/4/8 17:13
 * @copyright www.ucarinc.com All Rights Reserved.
 */
public class Oauth2ExceptionSerializer extends StdSerializer<Oauth2Exception> {
    public Oauth2ExceptionSerializer() {
        super(Oauth2Exception.class);
    }

    @Override
    public void serialize(Oauth2Exception value, JsonGenerator gen, SerializerProvider provider)
            throws IOException {
        gen.writeObject(Result.failure(value.getMessage()));
    }
}
