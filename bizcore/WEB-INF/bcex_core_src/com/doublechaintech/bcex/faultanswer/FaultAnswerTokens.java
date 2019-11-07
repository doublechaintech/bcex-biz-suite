
package com.doublechaintech.bcex.faultanswer;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class FaultAnswerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="faultAnswer";
	
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
	protected FaultAnswerTokens(){
		//ensure not initialized outside the class
	}
	public  static  FaultAnswerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		FaultAnswerTokens tokens = new FaultAnswerTokens(options);
		return tokens;
		
	}
	protected FaultAnswerTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public FaultAnswerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static FaultAnswerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected FaultAnswerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static FaultAnswerTokens start(){
		return new FaultAnswerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static FaultAnswerTokens allTokens(){
		
		return start()
			.withUser()
			.withExam();
	
	}
	public static FaultAnswerTokens withoutListsTokens(){
		
		return start()
			.withUser()
			.withExam();
	
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
	
	public FaultAnswerTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public FaultAnswerTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String EXAM = "exam";
	public String getExam(){
		return EXAM;
	}
	public FaultAnswerTokens withExam(){		
		addSimpleOptions(EXAM);
		return this;
	}
	
	
	
	public  FaultAnswerTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

