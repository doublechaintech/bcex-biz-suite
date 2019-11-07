package com.doublechaintech.bcex.registeration;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class RegisterationSerializer extends BcexObjectPlainCustomSerializer<Registeration>{

	@Override
	public void serialize(Registeration registeration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, registeration, provider);
		
	}
}


