package com.doublechaintech.bcex.useranswer;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class UserAnswerSerializer extends BcexObjectPlainCustomSerializer<UserAnswer>{

	@Override
	public void serialize(UserAnswer userAnswer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userAnswer, provider);
		
	}
}


