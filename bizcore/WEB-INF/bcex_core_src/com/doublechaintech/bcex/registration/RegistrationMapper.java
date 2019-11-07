
package com.doublechaintech.bcex.registration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.changerequest.ChangeRequest;

public class RegistrationMapper extends BaseRowMapper<Registration>{
	
	protected Registration internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Registration registration = getRegistration();		
		 		
 		setId(registration, rs, rowNumber); 		
 		setNickName(registration, rs, rowNumber); 		
 		setAvatar(registration, rs, rowNumber); 		
 		setChangeRequest(registration, rs, rowNumber); 		
 		setVersion(registration, rs, rowNumber);

		return registration;
	}
	
	protected Registration getRegistration(){
		return new Registration();
	}		
		
	protected void setId(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(RegistrationTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setId(id);
	}
		
	protected void setNickName(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String nickName = rs.getString(RegistrationTable.COLUMN_NICK_NAME);
		if(nickName == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setNickName(nickName);
	}
		
	protected void setAvatar(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String avatar = rs.getString(RegistrationTable.COLUMN_AVATAR);
		if(avatar == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setAvatar(avatar);
	}
		 		
 	protected void setChangeRequest(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestId = rs.getString(RegistrationTable.COLUMN_CHANGE_REQUEST);
 		if( changeRequestId == null){
 			return;
 		}
 		if( changeRequestId.isEmpty()){
 			return;
 		}
 		ChangeRequest changeRequest = registration.getChangeRequest();
 		if( changeRequest != null ){
 			//if the root object 'registration' already have the property, just set the id for it;
 			changeRequest.setId(changeRequestId);
 			
 			return;
 		}
 		registration.setChangeRequest(createEmptyChangeRequest(changeRequestId));
 	}
 	
	protected void setVersion(Registration registration, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(RegistrationTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		registration.setVersion(version);
	}
		
		

 	protected ChangeRequest  createEmptyChangeRequest(String changeRequestId){
 		ChangeRequest changeRequest = new ChangeRequest();
 		changeRequest.setId(changeRequestId);
 		changeRequest.setVersion(Integer.MAX_VALUE);
 		return changeRequest;
 	}
 	
}


