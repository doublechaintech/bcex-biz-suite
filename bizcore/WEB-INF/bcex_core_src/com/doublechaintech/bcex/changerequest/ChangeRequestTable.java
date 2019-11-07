
package com.doublechaintech.bcex.changerequest;
import com.doublechaintech.bcex.AccessKey;


public class ChangeRequestTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="change_request_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_REMOTE_IP = "remote_ip";
	static final String COLUMN_REQUEST_TYPE = "request_type";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_CREATE_TIME, COLUMN_REMOTE_IP, COLUMN_REQUEST_TYPE, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_CREATE_TIME, COLUMN_REMOTE_IP, COLUMN_REQUEST_TYPE, COLUMN_PLATFORM
		};
	
	
}


