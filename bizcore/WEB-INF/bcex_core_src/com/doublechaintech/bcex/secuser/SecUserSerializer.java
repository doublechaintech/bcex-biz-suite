package com.doublechaintech.bcex.secuser;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class SecUserSerializer extends BcexObjectPlainCustomSerializer<SecUser>{

	@Override
	public void serialize(SecUser secUser, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, secUser, provider);
		
	}
}


