package com.doublechaintech.bcex.wechatuser;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class WechatUserSerializer extends BcexObjectPlainCustomSerializer<WechatUser>{

	@Override
	public void serialize(WechatUser wechatUser, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatUser, provider);
		
	}
}


