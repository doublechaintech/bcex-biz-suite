package com.doublechaintech.bcex.startexam;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class StartExamSerializer extends BcexObjectPlainCustomSerializer<StartExam>{

	@Override
	public void serialize(StartExam startExam, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, startExam, provider);
		
	}
}


