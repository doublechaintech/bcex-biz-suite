
package com.doublechaintech.bcex.registeration;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class RegisterationTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="registeration";
	
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
	protected RegisterationTokens(){
		//ensure not initialized outside the class
	}
	public  static  RegisterationTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		RegisterationTokens tokens = new RegisterationTokens(options);
		return tokens;
		
	}
	protected RegisterationTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public RegisterationTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static RegisterationTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected RegisterationTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static RegisterationTokens start(){
		return new RegisterationTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static RegisterationTokens allTokens(){
		
		return start()
			.withChangeRequest();
	
	}
	public static RegisterationTokens withoutListsTokens(){
		
		return start()
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
	
	public RegisterationTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANGEREQUEST = "changeRequest";
	public String getChangeRequest(){
		return CHANGEREQUEST;
	}
	public RegisterationTokens withChangeRequest(){		
		addSimpleOptions(CHANGEREQUEST);
		return this;
	}
	
	
	
	public  RegisterationTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

