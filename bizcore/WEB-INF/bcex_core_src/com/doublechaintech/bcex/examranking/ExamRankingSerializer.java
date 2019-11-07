package com.doublechaintech.bcex.examranking;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.bcex.BcexObjectPlainCustomSerializer;
public class ExamRankingSerializer extends BcexObjectPlainCustomSerializer<ExamRanking>{

	@Override
	public void serialize(ExamRanking examRanking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, examRanking, provider);
		
	}
}


