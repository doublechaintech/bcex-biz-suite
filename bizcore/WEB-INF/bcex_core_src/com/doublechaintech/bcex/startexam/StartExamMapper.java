
package com.doublechaintech.bcex.startexam;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.wechatuser.WechatUser;

public class StartExamMapper extends BaseRowMapper<StartExam>{
	
	protected StartExam internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		StartExam startExam = getStartExam();		
		 		
 		setId(startExam, rs, rowNumber); 		
 		setNickName(startExam, rs, rowNumber); 		
 		setUser(startExam, rs, rowNumber); 		
 		setChangeRequest(startExam, rs, rowNumber); 		
 		setVersion(startExam, rs, rowNumber);

		return startExam;
	}
	
	protected StartExam getStartExam(){
		return new StartExam();
	}		
		
	protected void setId(StartExam startExam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(StartExamTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		startExam.setId(id);
	}
		
	protected void setNickName(StartExam startExam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String nickName = rs.getString(StartExamTable.COLUMN_NICK_NAME);
		if(nickName == null){
			//do nothing when nothing found in database
			return;
		}
		
		startExam.setNickName(nickName);
	}
		 		
 	protected void setUser(StartExam startExam, ResultSet rs, int rowNumber) throws SQLException{
 		String wechatUserId = rs.getString(StartExamTable.COLUMN_USER);
 		if( wechatUserId == null){
 			return;
 		}
 		if( wechatUserId.isEmpty()){
 			return;
 		}
 		WechatUser wechatUser = startExam.getUser();
 		if( wechatUser != null ){
 			//if the root object 'startExam' already have the property, just set the id for it;
 			wechatUser.setId(wechatUserId);
 			
 			return;
 		}
 		startExam.setUser(createEmptyUser(wechatUserId));
 	}
 	 		
 	protected void setChangeRequest(StartExam startExam, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestId = rs.getString(StartExamTable.COLUMN_CHANGE_REQUEST);
 		if( changeRequestId == null){
 			return;
 		}
 		if( changeRequestId.isEmpty()){
 			return;
 		}
 		ChangeRequest changeRequest = startExam.getChangeRequest();
 		if( changeRequest != null ){
 			//if the root object 'startExam' already have the property, just set the id for it;
 			changeRequest.setId(changeRequestId);
 			
 			return;
 		}
 		startExam.setChangeRequest(createEmptyChangeRequest(changeRequestId));
 	}
 	
	protected void setVersion(StartExam startExam, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(StartExamTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		startExam.setVersion(version);
	}
		
		

 	protected WechatUser  createEmptyUser(String wechatUserId){
 		WechatUser wechatUser = new WechatUser();
 		wechatUser.setId(wechatUserId);
 		wechatUser.setVersion(Integer.MAX_VALUE);
 		return wechatUser;
 	}
 	
 	protected ChangeRequest  createEmptyChangeRequest(String changeRequestId){
 		ChangeRequest changeRequest = new ChangeRequest();
 		changeRequest.setId(changeRequestId);
 		changeRequest.setVersion(Integer.MAX_VALUE);
 		return changeRequest;
 	}
 	
}


