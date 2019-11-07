package com.doublechaintech.bcex.formfieldmessage;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class FormFieldMessageSerializer extends BcexObjectPlainCustomSerializer<FormFieldMessage>{

	@Override
	public void serialize(FormFieldMessage formFieldMessage, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formFieldMessage, provider);
		
	}
}


