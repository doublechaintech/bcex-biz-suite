
package com.doublechaintech.bcex.registration;
import com.doublechaintech.bcex.AccessKey;


public class RegistrationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="registration_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NICK_NAME = "nick_name";
	static final String COLUMN_AVATAR = "avatar";
	static final String COLUMN_CHANGE_REQUEST = "change_request";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NICK_NAME, COLUMN_AVATAR, COLUMN_CHANGE_REQUEST, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_NICK_NAME, COLUMN_AVATAR, COLUMN_CHANGE_REQUEST
		};
	
	
}


