
package com.doublechaintech.bcex.answer;
import com.doublechaintech.bcex.AccessKey;


public class AnswerTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="answer_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_TITLE = "title";
	static final String COLUMN_COMMENT = "comment";
	static final String COLUMN_QUESTION = "question";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID, 
		COLUMN_TITLE, COLUMN_COMMENT, COLUMN_QUESTION, 
		COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {
		COLUMN_TITLE, COLUMN_COMMENT, COLUMN_QUESTION
		};
	
	
}


