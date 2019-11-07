
package com.doublechaintech.bcex.question;
import com.doublechaintech.bcex.AccessKey;


public class QuestionTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="question_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TOPIC = "topic";
	static final String COLUMN_LEVEL = "level";
	static final String COLUMN_OPTION_A = "option_a";
	static final String COLUMN_OPTION_B = "option_b";
	static final String COLUMN_OPTION_C = "option_c";
	static final String COLUMN_OPTION_D = "option_d";
	static final String COLUMN_OPTION_E = "option_e";
	static final String COLUMN_RIGHT_ANSWER = "right_answer";
	static final String COLUMN_PLATFORM = "platform";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TOPIC, COLUMN_LEVEL, COLUMN_OPTION_A, COLUMN_OPTION_B, COLUMN_OPTION_C, COLUMN_OPTION_D, COLUMN_OPTION_E, COLUMN_RIGHT_ANSWER, COLUMN_PLATFORM, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_TOPIC, COLUMN_LEVEL, COLUMN_OPTION_A, COLUMN_OPTION_B, COLUMN_OPTION_C, COLUMN_OPTION_D, COLUMN_OPTION_E, COLUMN_RIGHT_ANSWER, COLUMN_PLATFORM
		};
	
	
}


