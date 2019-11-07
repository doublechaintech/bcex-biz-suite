
package com.doublechaintech.bcex.exam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.wechatuser.WechatUser;

public class ExamMapper extends BaseRowMapper<Exam>{
	
	protected Exam internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Exam exam = getExam();		
		 		
 		setId(exam, rs, rowNumber); 		
 		setName(exam, rs, rowNumber); 		
 		setCreateTime(exam, rs, rowNumber); 		
 		setStatus(exam, rs, rowNumber); 		
 		setUser(exam, rs, rowNumber); 		
 		setScore(exam, rs, rowNumber); 		
 		setVersion(exam, rs, rowNumber);

		return exam;
	}
	
	protected Exam getExam(){
		return new Exam();
	}		
		
	protected void setId(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ExamTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		exam.setId(id);
	}
		
	protected void setName(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ExamTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		exam.setName(name);
	}
		
	protected void setCreateTime(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(ExamTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		exam.setCreateTime(convertToDateTime(createTime));
	}
		 		
 	protected void setStatus(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
 		String examStatusId = rs.getString(ExamTable.COLUMN_STATUS);
 		if( examStatusId == null){
 			return;
 		}
 		if( examStatusId.isEmpty()){
 			return;
 		}
 		ExamStatus examStatus = exam.getStatus();
 		if( examStatus != null ){
 			//if the root object 'exam' already have the property, just set the id for it;
 			examStatus.setId(examStatusId);
 			
 			return;
 		}
 		exam.setStatus(createEmptyStatus(examStatusId));
 	}
 	 		
 	protected void setUser(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
 		String wechatUserId = rs.getString(ExamTable.COLUMN_USER);
 		if( wechatUserId == null){
 			return;
 		}
 		if( wechatUserId.isEmpty()){
 			return;
 		}
 		WechatUser wechatUser = exam.getUser();
 		if( wechatUser != null ){
 			//if the root object 'exam' already have the property, just set the id for it;
 			wechatUser.setId(wechatUserId);
 			
 			return;
 		}
 		exam.setUser(createEmptyUser(wechatUserId));
 	}
 	
	protected void setScore(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer score = rs.getInt(ExamTable.COLUMN_SCORE);
		if(score == null){
			//do nothing when nothing found in database
			return;
		}
		
		exam.setScore(score);
	}
		
	protected void setVersion(Exam exam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ExamTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		exam.setVersion(version);
	}
		
		

 	protected ExamStatus  createEmptyStatus(String examStatusId){
 		ExamStatus examStatus = new ExamStatus();
 		examStatus.setId(examStatusId);
 		examStatus.setVersion(Integer.MAX_VALUE);
 		return examStatus;
 	}
 	
 	protected WechatUser  createEmptyUser(String wechatUserId){
 		WechatUser wechatUser = new WechatUser();
 		wechatUser.setId(wechatUserId);
 		wechatUser.setVersion(Integer.MAX_VALUE);
 		return wechatUser;
 	}
 	
}


