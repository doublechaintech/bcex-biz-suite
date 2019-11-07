
package com.doublechaintech.bcex.faultanswer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.exam.Exam;

public class FaultAnswerMapper extends BaseRowMapper<FaultAnswer>{
	
	protected FaultAnswer internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FaultAnswer faultAnswer = getFaultAnswer();		
		 		
 		setId(faultAnswer, rs, rowNumber); 		
 		setTopic(faultAnswer, rs, rowNumber); 		
 		setYourAnswer(faultAnswer, rs, rowNumber); 		
 		setRightAnswer(faultAnswer, rs, rowNumber); 		
 		setCreateTime(faultAnswer, rs, rowNumber); 		
 		setUser(faultAnswer, rs, rowNumber); 		
 		setExam(faultAnswer, rs, rowNumber); 		
 		setVersion(faultAnswer, rs, rowNumber);

		return faultAnswer;
	}
	
	protected FaultAnswer getFaultAnswer(){
		return new FaultAnswer();
	}		
		
	protected void setId(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(FaultAnswerTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setId(id);
	}
		
	protected void setTopic(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String topic = rs.getString(FaultAnswerTable.COLUMN_TOPIC);
		if(topic == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setTopic(topic);
	}
		
	protected void setYourAnswer(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String yourAnswer = rs.getString(FaultAnswerTable.COLUMN_YOUR_ANSWER);
		if(yourAnswer == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setYourAnswer(yourAnswer);
	}
		
	protected void setRightAnswer(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String rightAnswer = rs.getString(FaultAnswerTable.COLUMN_RIGHT_ANSWER);
		if(rightAnswer == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setRightAnswer(rightAnswer);
	}
		
	protected void setCreateTime(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(FaultAnswerTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setCreateTime(convertToDateTime(createTime));
	}
		 		
 	protected void setUser(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
 		String wechatUserId = rs.getString(FaultAnswerTable.COLUMN_USER);
 		if( wechatUserId == null){
 			return;
 		}
 		if( wechatUserId.isEmpty()){
 			return;
 		}
 		WechatUser wechatUser = faultAnswer.getUser();
 		if( wechatUser != null ){
 			//if the root object 'faultAnswer' already have the property, just set the id for it;
 			wechatUser.setId(wechatUserId);
 			
 			return;
 		}
 		faultAnswer.setUser(createEmptyUser(wechatUserId));
 	}
 	 		
 	protected void setExam(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
 		String examId = rs.getString(FaultAnswerTable.COLUMN_EXAM);
 		if( examId == null){
 			return;
 		}
 		if( examId.isEmpty()){
 			return;
 		}
 		Exam exam = faultAnswer.getExam();
 		if( exam != null ){
 			//if the root object 'faultAnswer' already have the property, just set the id for it;
 			exam.setId(examId);
 			
 			return;
 		}
 		faultAnswer.setExam(createEmptyExam(examId));
 	}
 	
	protected void setVersion(FaultAnswer faultAnswer, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(FaultAnswerTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		faultAnswer.setVersion(version);
	}
		
		

 	protected WechatUser  createEmptyUser(String wechatUserId){
 		WechatUser wechatUser = new WechatUser();
 		wechatUser.setId(wechatUserId);
 		wechatUser.setVersion(Integer.MAX_VALUE);
 		return wechatUser;
 	}
 	
 	protected Exam  createEmptyExam(String examId){
 		Exam exam = new Exam();
 		exam.setId(examId);
 		exam.setVersion(Integer.MAX_VALUE);
 		return exam;
 	}
 	
}


