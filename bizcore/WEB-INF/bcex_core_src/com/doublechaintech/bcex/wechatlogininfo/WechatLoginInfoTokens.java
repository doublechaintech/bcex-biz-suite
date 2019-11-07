
package com.doublechaintech.bcex.wechatlogininfo;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class WechatLoginInfoTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatLoginInfo";
	
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
	protected WechatLoginInfoTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatLoginInfoTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatLoginInfoTokens tokens = new WechatLoginInfoTokens(options);
		return tokens;
		
	}
	protected WechatLoginInfoTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WechatLoginInfoTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WechatLoginInfoTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WechatLoginInfoTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static WechatLoginInfoTokens start(){
		return new WechatLoginInfoTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static WechatLoginInfoTokens allTokens(){
		
		return start()
			.withWechatUser();
	
	}
	public static WechatLoginInfoTokens withoutListsTokens(){
		
		return start()
			.withWechatUser();
	
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
	
	public WechatLoginInfoTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String WECHATUSER = "wechatUser";
	public String getWechatUser(){
		return WECHATUSER;
	}
	public WechatLoginInfoTokens withWechatUser(){		
		addSimpleOptions(WECHATUSER);
		return this;
	}
	
	
	
	public  WechatLoginInfoTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

