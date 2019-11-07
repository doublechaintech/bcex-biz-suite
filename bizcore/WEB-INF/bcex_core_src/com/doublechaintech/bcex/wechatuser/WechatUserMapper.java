
package com.doublechaintech.bcex.wechatuser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.platform.Platform;

public class WechatUserMapper extends BaseRowMapper<WechatUser>{
	
	protected WechatUser internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatUser wechatUser = getWechatUser();		
		 		
 		setId(wechatUser, rs, rowNumber); 		
 		setName(wechatUser, rs, rowNumber); 		
 		setAvarta(wechatUser, rs, rowNumber); 		
 		setCreateTime(wechatUser, rs, rowNumber); 		
 		setPlatform(wechatUser, rs, rowNumber); 		
 		setVersion(wechatUser, rs, rowNumber);

		return wechatUser;
	}
	
	protected WechatUser getWechatUser(){
		return new WechatUser();
	}		
		
	protected void setId(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(WechatUserTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatUser.setId(id);
	}
		
	protected void setName(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(WechatUserTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatUser.setName(name);
	}
		
	protected void setAvarta(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String avarta = rs.getString(WechatUserTable.COLUMN_AVARTA);
		if(avarta == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatUser.setAvarta(avarta);
	}
		
	protected void setCreateTime(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date createTime = rs.getTimestamp(WechatUserTable.COLUMN_CREATE_TIME);
		if(createTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatUser.setCreateTime(convertToDateTime(createTime));
	}
		 		
 	protected void setPlatform(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
 		String platformId = rs.getString(WechatUserTable.COLUMN_PLATFORM);
 		if( platformId == null){
 			return;
 		}
 		if( platformId.isEmpty()){
 			return;
 		}
 		Platform platform = wechatUser.getPlatform();
 		if( platform != null ){
 			//if the root object 'wechatUser' already have the property, just set the id for it;
 			platform.setId(platformId);
 			
 			return;
 		}
 		wechatUser.setPlatform(createEmptyPlatform(platformId));
 	}
 	
	protected void setVersion(WechatUser wechatUser, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(WechatUserTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatUser.setVersion(version);
	}
		
		

 	protected Platform  createEmptyPlatform(String platformId){
 		Platform platform = new Platform();
 		platform.setId(platformId);
 		platform.setVersion(Integer.MAX_VALUE);
 		return platform;
 	}
 	
}


