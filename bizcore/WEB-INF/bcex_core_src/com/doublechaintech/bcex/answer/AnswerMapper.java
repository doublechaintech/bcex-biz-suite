
package com.doublechaintech.bcex.answer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.question.Question;

public class AnswerMapper extends BaseRowMapper<Answer>{
	
	protected Answer internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Answer answer = getAnswer();		
		 		
 		setId(answer, rs, rowNumber); 		
 		setTitle(answer, rs, rowNumber); 		
 		setComment(answer, rs, rowNumber); 		
 		setQuestion(answer, rs, rowNumber); 		
 		setVersion(answer, rs, rowNumber);

		return answer;
	}
	
	protected Answer getAnswer(){
		return new Answer();
	}		
		
	protected void setId(Answer answer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AnswerTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		answer.setId(id);
	}
		
	protected void setTitle(Answer answer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(AnswerTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		answer.setTitle(title);
	}
		
	protected void setComment(Answer answer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comment = rs.getString(AnswerTable.COLUMN_COMMENT);
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		answer.setComment(comment);
	}
		 		
 	protected void setQuestion(Answer answer, ResultSet rs, int rowNumber) throws SQLException{
 		String questionId = rs.getString(AnswerTable.COLUMN_QUESTION);
 		if( questionId == null){
 			return;
 		}
 		if( questionId.isEmpty()){
 			return;
 		}
 		Question question = answer.getQuestion();
 		if( question != null ){
 			//if the root object 'answer' already have the property, just set the id for it;
 			question.setId(questionId);
 			
 			return;
 		}
 		answer.setQuestion(createEmptyQuestion(questionId));
 	}
 	
	protected void setVersion(Answer answer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AnswerTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		answer.setVersion(version);
	}
		
		

 	protected Question  createEmptyQuestion(String questionId){
 		Question question = new Question();
 		question.setId(questionId);
 		question.setVersion(Integer.MAX_VALUE);
 		return question;
 	}
 	
}


