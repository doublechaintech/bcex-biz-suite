package com.doublechaintech.bcex.wechatlogininfo;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class WechatLoginInfoSerializer extends BcexObjectPlainCustomSerializer<WechatLoginInfo>{

	@Override
	public void serialize(WechatLoginInfo wechatLoginInfo, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatLoginInfo, provider);
		
	}
}


