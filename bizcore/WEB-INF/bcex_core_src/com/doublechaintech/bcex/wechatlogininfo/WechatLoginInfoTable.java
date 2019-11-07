
package com.doublechaintech.bcex.wechatlogininfo;
import com.doublechaintech.bcex.AccessKey;


public class WechatLoginInfoTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="wechat_login_info_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_WECHAT_USER = "wechat_user";
	static final String COLUMN_APP_ID = "app_id";
	static final String COLUMN_OPEN_ID = "open_id";
	static final String COLUMN_SESSION_KEY = "session_key";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_WECHAT_USER, COLUMN_APP_ID, COLUMN_OPEN_ID, COLUMN_SESSION_KEY, COLUMN_LAST_UPDATE_TIME, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_WECHAT_USER, COLUMN_APP_ID, COLUMN_OPEN_ID, COLUMN_SESSION_KEY, COLUMN_LAST_UPDATE_TIME
		};
	
	
}


