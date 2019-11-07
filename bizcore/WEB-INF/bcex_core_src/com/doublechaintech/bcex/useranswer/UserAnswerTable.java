
package com.doublechaintech.bcex.useranswer;
import com.doublechaintech.bcex.AccessKey;


public class UserAnswerTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="user_answer_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TOPIC = "topic";
	static final String COLUMN_USER_SELECT = "user_select";
	static final String COLUMN_QUESTION = "question";
	static final String COLUMN_EXAM = "exam";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TOPIC, COLUMN_USER_SELECT, COLUMN_QUESTION, COLUMN_EXAM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_TOPIC, COLUMN_USER_SELECT, COLUMN_QUESTION, COLUMN_EXAM
		};
	
	
}


