
package com.doublechaintech.bcex.exam;
import com.doublechaintech.bcex.AccessKey;


public class ExamTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="exam_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_STATUS = "status";
	static final String COLUMN_USER = "user";
	static final String COLUMN_SCORE = "score";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_NAME, COLUMN_CREATE_TIME, COLUMN_STATUS, COLUMN_USER, COLUMN_SCORE, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_NAME, COLUMN_CREATE_TIME, COLUMN_STATUS, COLUMN_USER, COLUMN_SCORE
		};
	
	
}


