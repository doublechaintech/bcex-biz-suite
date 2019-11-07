
package com.doublechaintech.bcex.changerequesttype;
import com.doublechaintech.bcex.AccessKey;


public class ChangeRequestTypeTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	
	public static AccessKey withCode(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_CODE);
		accessKey.setValue(value);
		return accessKey;
	}
	 

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="change_request_type_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CODE = "code";
	static final String COLUMN_ICON = "icon";
	static final String COLUMN_DISPLAY_ORDER = "display_order";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_CODE, COLUMN_ICON, COLUMN_DISPLAY_ORDER, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_CODE, COLUMN_ICON, COLUMN_DISPLAY_ORDER, COLUMN_PLATFORM
		};
	
	
}


