
package com.doublechaintech.bcex.faultanswer;
import com.doublechaintech.bcex.AccessKey;


public class FaultAnswerTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="fault_answer_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TOPIC = "topic";
	static final String COLUMN_YOUR_ANSWER = "your_answer";
	static final String COLUMN_RIGHT_ANSWER = "right_answer";
	static final String COLUMN_CREATE_TIME = "create_time";
	static final String COLUMN_USER = "user";
	static final String COLUMN_EXAM = "exam";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TOPIC, COLUMN_YOUR_ANSWER, COLUMN_RIGHT_ANSWER, COLUMN_CREATE_TIME, COLUMN_USER, COLUMN_EXAM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_TOPIC, COLUMN_YOUR_ANSWER, COLUMN_RIGHT_ANSWER, COLUMN_CREATE_TIME, COLUMN_USER, COLUMN_EXAM
		};
	
	
}


