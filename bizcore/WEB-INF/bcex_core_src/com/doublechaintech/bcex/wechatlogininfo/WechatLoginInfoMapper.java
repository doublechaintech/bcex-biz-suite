
package com.doublechaintech.bcex.wechatlogininfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BaseRowMapper;
import com.doublechaintech.bcex.wechatuser.WechatUser;

public class WechatLoginInfoMapper extends BaseRowMapper<WechatLoginInfo>{
	
	protected WechatLoginInfo internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		WechatLoginInfo wechatLoginInfo = getWechatLoginInfo();		
		 		
 		setId(wechatLoginInfo, rs, rowNumber); 		
 		setWechatUser(wechatLoginInfo, rs, rowNumber); 		
 		setAppId(wechatLoginInfo, rs, rowNumber); 		
 		setOpenId(wechatLoginInfo, rs, rowNumber); 		
 		setSessionKey(wechatLoginInfo, rs, rowNumber); 		
 		setLastUpdateTime(wechatLoginInfo, rs, rowNumber); 		
 		setVersion(wechatLoginInfo, rs, rowNumber);

		return wechatLoginInfo;
	}
	
	protected WechatLoginInfo getWechatLoginInfo(){
		return new WechatLoginInfo();
	}		
		
	protected void setId(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(WechatLoginInfoTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setId(id);
	}
		 		
 	protected void setWechatUser(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
 		String wechatUserId = rs.getString(WechatLoginInfoTable.COLUMN_WECHAT_USER);
 		if( wechatUserId == null){
 			return;
 		}
 		if( wechatUserId.isEmpty()){
 			return;
 		}
 		WechatUser wechatUser = wechatLoginInfo.getWechatUser();
 		if( wechatUser != null ){
 			//if the root object 'wechatLoginInfo' already have the property, just set the id for it;
 			wechatUser.setId(wechatUserId);
 			
 			return;
 		}
 		wechatLoginInfo.setWechatUser(createEmptyWechatUser(wechatUserId));
 	}
 	
	protected void setAppId(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String appId = rs.getString(WechatLoginInfoTable.COLUMN_APP_ID);
		if(appId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setAppId(appId);
	}
		
	protected void setOpenId(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String openId = rs.getString(WechatLoginInfoTable.COLUMN_OPEN_ID);
		if(openId == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setOpenId(openId);
	}
		
	protected void setSessionKey(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String sessionKey = rs.getString(WechatLoginInfoTable.COLUMN_SESSION_KEY);
		if(sessionKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setSessionKey(sessionKey);
	}
		
	protected void setLastUpdateTime(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date lastUpdateTime = rs.getTimestamp(WechatLoginInfoTable.COLUMN_LAST_UPDATE_TIME);
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(WechatLoginInfo wechatLoginInfo, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(WechatLoginInfoTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		wechatLoginInfo.setVersion(version);
	}
		
		

 	protected WechatUser  createEmptyWechatUser(String wechatUserId){
 		WechatUser wechatUser = new WechatUser();
 		wechatUser.setId(wechatUserId);
 		wechatUser.setVersion(Integer.MAX_VALUE);
 		return wechatUser;
 	}
 	
}


