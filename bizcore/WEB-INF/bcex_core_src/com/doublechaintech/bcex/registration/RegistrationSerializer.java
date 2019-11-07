package com.doublechaintech.bcex.registration;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class RegistrationSerializer extends BcexObjectPlainCustomSerializer<Registration>{

	@Override
	public void serialize(Registration registration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, registration, provider);
		
	}
}


