
package com.doublechaintech.bcex.answer;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class AnswerTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="answer";
	
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
	protected AnswerTokens(){
		//ensure not initialized outside the class
	}
	public  static  AnswerTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		AnswerTokens tokens = new AnswerTokens(options);
		return tokens;
		
	}
	protected AnswerTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public AnswerTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AnswerTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AnswerTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AnswerTokens start(){
		return new AnswerTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AnswerTokens allTokens(){
		
		return start()
			.withQuestion();
	
	}
	public static AnswerTokens withoutListsTokens(){
		
		return start()
			.withQuestion();
	
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
	
	public AnswerTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String QUESTION = "question";
	public String getQuestion(){
		return QUESTION;
	}
	public AnswerTokens withQuestion(){		
		addSimpleOptions(QUESTION);
		return this;
	}
	
	
	
	public  AnswerTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

