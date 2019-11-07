
package com.doublechaintech.bcex.changerequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;

public class ChangeRequestMapper extends BaseRowMapper<ChangeRequest>{
	
	protected ChangeRequest internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ChangeRequest changeRequest = getChangeRequest();		
		 		
 		setId(changeRequest, rs, rowNumber); 		
 		setName(changeRequest, rs, rowNumber); 		
 		setCreateTime(changeRequest, rs, rowNumber); 		
 		setRemoteIp(changeRequest, rs, rowNumber); 		
 		setRequestType(changeRequest, rs, rowNumber); 		
 		setPlatform(changeRequest, rs, rowNumber); 		
 		setVersion(changeRequest, rs, rowNumber);

		return changeRequest;
	}
	
	protected ChangeRequest getChangeRequest(){
		return new ChangeRequest();
	}		
		
	protected void setId(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(ChangeRequestTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequest.setId(id);
	}
		
	protected void setName(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(ChangeRequestTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequest.setName(name);
	}
		
	protected void setCreateTime(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(ChangeRequestTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequest.setCreateTime(convertToDateTime(createTime));
	}
		
	protected void setRemoteIp(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String remoteIp = rs.getString(ChangeRequestTable.COLUMN_REMOTE_IP);
		if(remoteIp == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequest.setRemoteIp(remoteIp);
	}
		 		
 	protected void setRequestType(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
 		String changeRequestTypeId = rs.getString(ChangeRequestTable.COLUMN_REQUEST_TYPE);
 		if( changeRequestTypeId == null){
 			return;
 		}
 		if( changeRequestTypeId.isEmpty()){
 			return;
 		}
 		ChangeRequestType changeRequestType = changeRequest.getRequestType();
 		if( changeRequestType != null ){
 			//if the root object 'changeRequest' already have the property, just set the id for it;
 			changeRequestType.setId(changeRequestTypeId);
 			
 			return;
 		}
 		changeRequest.setRequestType(createEmptyRequestType(changeRequestTypeId));
 	}
 	 		
 	protected void setPlatform(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(ChangeRequestTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = changeRequest.getPlatform();
 		if( platform != null ){
 			//if the root object 'changeRequest' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		changeRequest.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(ChangeRequest changeRequest, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(ChangeRequestTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		changeRequest.setVersion(version);
	}
		
		

 	protected ChangeRequestType  createEmptyRequestType(String changeRequestTypeId){
 		ChangeRequestType changeRequestType = new ChangeRequestType();
 		changeRequestType.setId(changeRequestTypeId);
 		changeRequestType.setVersion(Integer.MAX_VALUE);
 		return changeRequestType;
 	}
 	
 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


