
package com.doublechaintech.bcex.useranswer;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class UserAnswerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="userAnswer";
	
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
	protected UserAnswerTokens(){
		//ensure not initialized outside the class
	}
	public  static  UserAnswerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		UserAnswerTokens tokens = new UserAnswerTokens(options);
		return tokens;
		
	}
	protected UserAnswerTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public UserAnswerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static UserAnswerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected UserAnswerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static UserAnswerTokens start(){
		return new UserAnswerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static UserAnswerTokens allTokens(){
		
		return start()
			.withQuestion()
			.withExam();
	
	}
	public static UserAnswerTokens withoutListsTokens(){
		
		return start()
			.withQuestion()
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
	
	public UserAnswerTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String QUESTION = "question";
	public String getQuestion(){
		return QUESTION;
	}
	public UserAnswerTokens withQuestion(){		
		addSimpleOptions(QUESTION);
		return this;
	}
	
	
	protected static final String EXAM = "exam";
	public String getExam(){
		return EXAM;
	}
	public UserAnswerTokens withExam(){		
		addSimpleOptions(EXAM);
		return this;
	}
	
	
	
	public  UserAnswerTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

