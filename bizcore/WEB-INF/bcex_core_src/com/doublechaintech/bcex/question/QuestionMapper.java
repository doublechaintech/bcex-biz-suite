
package com.doublechaintech.bcex.question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;

public class QuestionMapper extends BaseRowMapper<Question>{
	
	protected Question internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Question question = getQuestion();		
		 		
 		setId(question, rs, rowNumber); 		
 		setTopic(question, rs, rowNumber); 		
 		setLevel(question, rs, rowNumber); 		
 		setOptionA(question, rs, rowNumber); 		
 		setOptionB(question, rs, rowNumber); 		
 		setOptionC(question, rs, rowNumber); 		
 		setOptionD(question, rs, rowNumber); 		
 		setOptionE(question, rs, rowNumber); 		
 		setRightAnswer(question, rs, rowNumber); 		
 		setPlatform(question, rs, rowNumber); 		
 		setVersion(question, rs, rowNumber);

		return question;
	}
	
	protected Question getQuestion(){
		return new Question();
	}		
		
	protected void setId(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(QuestionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setId(id);
	}
		
	protected void setTopic(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String topic = rs.getString(QuestionTable.COLUMN_TOPIC);
		if(topic == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setTopic(topic);
	}
		
	protected void setLevel(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String level = rs.getString(QuestionTable.COLUMN_LEVEL);
		if(level == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setLevel(level);
	}
		
	protected void setOptionA(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String optionA = rs.getString(QuestionTable.COLUMN_OPTION_A);
		if(optionA == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setOptionA(optionA);
	}
		
	protected void setOptionB(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String optionB = rs.getString(QuestionTable.COLUMN_OPTION_B);
		if(optionB == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setOptionB(optionB);
	}
		
	protected void setOptionC(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String optionC = rs.getString(QuestionTable.COLUMN_OPTION_C);
		if(optionC == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setOptionC(optionC);
	}
		
	protected void setOptionD(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String optionD = rs.getString(QuestionTable.COLUMN_OPTION_D);
		if(optionD == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setOptionD(optionD);
	}
		
	protected void setOptionE(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String optionE = rs.getString(QuestionTable.COLUMN_OPTION_E);
		if(optionE == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setOptionE(optionE);
	}
		
	protected void setRightAnswer(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String rightAnswer = rs.getString(QuestionTable.COLUMN_RIGHT_ANSWER);
		if(rightAnswer == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setRightAnswer(rightAnswer);
	}
		 		
 	protected void setPlatform(Question question, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(QuestionTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = question.getPlatform();
 		if( platform != null ){
 			//if the root object 'question' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		question.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(Question question, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(QuestionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		question.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


