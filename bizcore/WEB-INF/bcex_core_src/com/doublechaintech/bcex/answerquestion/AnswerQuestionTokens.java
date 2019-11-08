
package com.doublechaintech.bcex.answerquestion;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class AnswerQuestionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="answerQuestion";
	
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
	protected AnswerQuestionTokens(){
		//ensure not initialized outside the class
	}
	public  static  AnswerQuestionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		AnswerQuestionTokens tokens = new AnswerQuestionTokens(options);
		return tokens;
		
	}
	protected AnswerQuestionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public AnswerQuestionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static AnswerQuestionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected AnswerQuestionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static AnswerQuestionTokens start(){
		return new AnswerQuestionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static AnswerQuestionTokens allTokens(){
		
		return start()
			.withUser()
			.withUserAnswer()
			.withChangeRequest();
	
	}
	public static AnswerQuestionTokens withoutListsTokens(){
		
		return start()
			.withUser()
			.withUserAnswer()
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
	
	public AnswerQuestionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public AnswerQuestionTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String USERANSWER = "userAnswer";
	public String getUserAnswer(){
		return USERANSWER;
	}
	public AnswerQuestionTokens withUserAnswer(){		
		addSimpleOptions(USERANSWER);
		return this;
	}
	
	
	protected static final String CHANGEREQUEST = "changeRequest";
	public String getChangeRequest(){
		return CHANGEREQUEST;
	}
	public AnswerQuestionTokens withChangeRequest(){		
		addSimpleOptions(CHANGEREQUEST);
		return this;
	}
	
	
	
	public  AnswerQuestionTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

