package com.doublechaintech.bcex.formaction;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class FormActionSerializer extends BcexObjectPlainCustomSerializer<FormAction>{

	@Override
	public void serialize(FormAction formAction, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formAction, provider);
		
	}
}


