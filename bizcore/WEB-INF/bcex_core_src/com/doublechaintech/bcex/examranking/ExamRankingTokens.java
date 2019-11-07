
package com.doublechaintech.bcex.examranking;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class ExamRankingTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="examRanking";
	
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
	protected ExamRankingTokens(){
		//ensure not initialized outside the class
	}
	public  static  ExamRankingTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ExamRankingTokens tokens = new ExamRankingTokens(options);
		return tokens;
		
	}
	protected ExamRankingTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ExamRankingTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ExamRankingTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ExamRankingTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ExamRankingTokens start(){
		return new ExamRankingTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ExamRankingTokens allTokens(){
		
		return start()
			.withPlatform();
	
	}
	public static ExamRankingTokens withoutListsTokens(){
		
		return start()
			.withPlatform();
	
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
	
	public ExamRankingTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ExamRankingTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	
	public  ExamRankingTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

