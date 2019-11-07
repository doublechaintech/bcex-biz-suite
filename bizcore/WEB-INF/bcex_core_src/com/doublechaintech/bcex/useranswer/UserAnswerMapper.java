
package com.doublechaintech.bcex.useranswer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;

public class UserAnswerMapper extends BaseRowMapper<UserAnswer>{
	
	protected UserAnswer internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		UserAnswer userAnswer = getUserAnswer();		
		 		
 		setId(userAnswer, rs, rowNumber); 		
 		setTopic(userAnswer, rs, rowNumber); 		
 		setUserSelect(userAnswer, rs, rowNumber); 		
 		setQuestion(userAnswer, rs, rowNumber); 		
 		setExam(userAnswer, rs, rowNumber); 		
 		setVersion(userAnswer, rs, rowNumber);

		return userAnswer;
	}
	
	protected UserAnswer getUserAnswer(){
		return new UserAnswer();
	}		
		
	protected void setId(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(UserAnswerTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAnswer.setId(id);
	}
		
	protected void setTopic(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String topic = rs.getString(UserAnswerTable.COLUMN_TOPIC);
		if(topic == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAnswer.setTopic(topic);
	}
		
	protected void setUserSelect(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String userSelect = rs.getString(UserAnswerTable.COLUMN_USER_SELECT);
		if(userSelect == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAnswer.setUserSelect(userSelect);
	}
		 		
 	protected void setQuestion(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
 		String questionId = rs.getString(UserAnswerTable.COLUMN_QUESTION);
 		if( questionId == null){
 			return;
 		}
 		if( questionId.isEmpty()){
 			return;
 		}
 		Question question = userAnswer.getQuestion();
 		if( question != null ){
 			//if the root object 'userAnswer' already have the property, just set the id for it;
 			question.setId(questionId);
 			
 			return;
 		}
 		userAnswer.setQuestion(createEmptyQuestion(questionId));
 	}
 	 		
 	protected void setExam(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
 		String examId = rs.getString(UserAnswerTable.COLUMN_EXAM);
 		if( examId == null){
 			return;
 		}
 		if( examId.isEmpty()){
 			return;
 		}
 		Exam exam = userAnswer.getExam();
 		if( exam != null ){
 			//if the root object 'userAnswer' already have the property, just set the id for it;
 			exam.setId(examId);
 			
 			return;
 		}
 		userAnswer.setExam(createEmptyExam(examId));
 	}
 	
	protected void setVersion(UserAnswer userAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(UserAnswerTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		userAnswer.setVersion(version);
	}
		
		

 	protected Question  createEmptyQuestion(String questionId){
 		Question question = new Question();
 		question.setId(questionId);
 		question.setVersion(Integer.MAX_VALUE);
 		return question;
 	}
 	
 	protected Exam  createEmptyExam(String examId){
 		Exam exam = new Exam();
 		exam.setId(examId);
 		exam.setVersion(Integer.MAX_VALUE);
 		return exam;
 	}
 	
}


