
package com.doublechaintech.bcex.startexam;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class StartExamTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="startExam";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected StartExamTokens(){
		//ensure not initialized outside the class
	}
	public  static  StartExamTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		StartExamTokens tokens = new StartExamTokens(options);
		return tokens;
		
	}
	protected StartExamTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public StartExamTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static StartExamTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected StartExamTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static StartExamTokens start(){
		return new StartExamTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static StartExamTokens allTokens(){
		
		return start()
			.withUser()
			.withChangeRequest();
	
	}
	public static StartExamTokens withoutListsTokens(){
		
		return start()
			.withUser()
			.withChangeRequest();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}
	
	public StartExamTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public StartExamTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String CHANGEREQUEST = "changeRequest";
	public String getChangeRequest(){
		return CHANGEREQUEST;
	}
	public StartExamTokens withChangeRequest(){		
		addSimpleOptions(CHANGEREQUEST);
		return this;
	}
	
	
	
	public  StartExamTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

