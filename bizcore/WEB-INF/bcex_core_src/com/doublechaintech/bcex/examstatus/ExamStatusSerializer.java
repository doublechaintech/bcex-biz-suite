package com.doublechaintech.bcex.examstatus;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class ExamStatusSerializer extends BcexObjectPlainCustomSerializer<ExamStatus>{

	@Override
	public void serialize(ExamStatus examStatus, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, examStatus, provider);
		
	}
}


