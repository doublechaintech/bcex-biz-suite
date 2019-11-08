
package com.doublechaintech.bcex.answerquestion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

public class AnswerQuestionMapper extends BaseRowMapper<AnswerQuestion>{
	
	protected AnswerQuestion internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AnswerQuestion answerQuestion = getAnswerQuestion();		
		 		
 		setId(answerQuestion, rs, rowNumber); 		
 		setNickName(answerQuestion, rs, rowNumber); 		
 		setUser(answerQuestion, rs, rowNumber); 		
 		setUserAnswer(answerQuestion, rs, rowNumber); 		
 		setAnswer(answerQuestion, rs, rowNumber); 		
 		setChangeRequest(answerQuestion, rs, rowNumber); 		
 		setVersion(answerQuestion, rs, rowNumber);

		return answerQuestion;
	}
	
	protected AnswerQuestion getAnswerQuestion(){
		return new AnswerQuestion();
	}		
		
	protected void setId(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AnswerQuestionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		answerQuestion.setId(id);
	}
		
	protected void setNickName(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String nickName = rs.getString(AnswerQuestionTable.COLUMN_NICK_NAME);
		if(nickName == null){
			//do nothing when nothing found in database
			return;
		}
		
		answerQuestion.setNickName(nickName);
	}
		 		
 	protected void setUser(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
 		String wechatUserId = rs.getString(AnswerQuestionTable.COLUMN_USER);
 		if( wechatUserId == null){
 			return;
 		}
 		if( wechatUserId.isEmpty()){
 			return;
 		}
 		WechatUser wechatUser = answerQuestion.getUser();
 		if( wechatUser != null ){
 			//if the root object 'answerQuestion' already have the property, just set the id for it;
 			wechatUser.setId(wechatUserId);
 			
 			return;
 		}
 		answerQuestion.setUser(createEmptyUser(wechatUserId));
 	}
 	 		
 	protected void setUserAnswer(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
 		String userAnswerId = rs.getString(AnswerQuestionTable.COLUMN_USER_ANSWER);
 		if( userAnswerId == null){
 			return;
 		}
 		if( userAnswerId.isEmpty()){
 			return;
 		}
 		UserAnswer userAnswer = answerQuestion.getUserAnswer();
 		if( userAnswer != null ){
 			//if the root object 'answerQuestion' already have the property, just set the id for it;
 			userAnswer.setId(userAnswerId);
 			
 			return;
 		}
 		answerQuestion.setUserAnswer(createEmptyUserAnswer(userAnswerId));
 	}
 	
	protected void setAnswer(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String answer = rs.getString(AnswerQuestionTable.COLUMN_ANSWER);
		if(answer == null){
			//do nothing when nothing found in database
			return;
		}
		
		answerQuestion.setAnswer(answer);
	}
		 		
 	protected void setChangeRequest(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestId = rs.getString(AnswerQuestionTable.COLUMN_CHANGE_REQUEST);
 		if( changeRequestId == null){
 			return;
 		}
 		if( changeRequestId.isEmpty()){
 			return;
 		}
 		ChangeRequest changeRequest = answerQuestion.getChangeRequest();
 		if( changeRequest != null ){
 			//if the root object 'answerQuestion' already have the property, just set the id for it;
 			changeRequest.setId(changeRequestId);
 			
 			return;
 		}
 		answerQuestion.setChangeRequest(createEmptyChangeRequest(changeRequestId));
 	}
 	
	protected void setVersion(AnswerQuestion answerQuestion, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AnswerQuestionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		answerQuestion.setVersion(version);
	}
		
		

 	protected WechatUser  createEmptyUser(String wechatUserId){
 		WechatUser wechatUser = new WechatUser();
 		wechatUser.setId(wechatUserId);
 		wechatUser.setVersion(Integer.MAX_VALUE);
 		return wechatUser;
 	}
 	
 	protected UserAnswer  createEmptyUserAnswer(String userAnswerId){
 		UserAnswer userAnswer = new UserAnswer();
 		userAnswer.setId(userAnswerId);
 		userAnswer.setVersion(Integer.MAX_VALUE);
 		return userAnswer;
 	}
 	
 	protected ChangeRequest  createEmptyChangeRequest(String changeRequestId){
 		ChangeRequest changeRequest = new ChangeRequest();
 		changeRequest.setId(changeRequestId);
 		changeRequest.setVersion(Integer.MAX_VALUE);
 		return changeRequest;
 	}
 	
}


