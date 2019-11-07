package com.doublechaintech.bcex.answer;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class AnswerSerializer extends BcexObjectPlainCustomSerializer<Answer>{

	@Override
	public void serialize(Answer answer, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, answer, provider);
		
	}
}


