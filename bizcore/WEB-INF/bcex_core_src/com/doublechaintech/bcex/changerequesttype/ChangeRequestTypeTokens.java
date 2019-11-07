
package com.doublechaintech.bcex.changerequesttype;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class ChangeRequestTypeTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="changeRequestType";
	
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
	protected ChangeRequestTypeTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChangeRequestTypeTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChangeRequestTypeTokens tokens = new ChangeRequestTypeTokens(options);
		return tokens;
		
	}
	protected ChangeRequestTypeTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChangeRequestTypeTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChangeRequestTypeTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChangeRequestTypeTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChangeRequestTypeTokens start(){
		return new ChangeRequestTypeTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChangeRequestTypeTokens allTokens(){
		
		return start()
			.withPlatform()
			.withChangeRequestList();
	
	}
	public static ChangeRequestTypeTokens withoutListsTokens(){
		
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
	
	public ChangeRequestTypeTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ChangeRequestTypeTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String CHANGE_REQUEST_LIST = "changeRequestList";
	public String getChangeRequestList(){
		return CHANGE_REQUEST_LIST;
	}
	public ChangeRequestTypeTokens withChangeRequestList(){		
		addSimpleOptions(CHANGE_REQUEST_LIST);
		return this;
	}
	public ChangeRequestTypeTokens analyzeChangeRequestList(){		
		addSimpleOptions(CHANGE_REQUEST_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChangeRequestListEnabled(){		
		
		if(checkOptions(this.options(), CHANGE_REQUEST_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChangeRequestTypeTokens extractMoreFromChangeRequestList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANGE_REQUEST_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int changeRequestListSortCounter = 0;
	public ChangeRequestTypeTokens sortChangeRequestListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSortCounter++, field, descOrAsc);
		return this;
	}
	private int changeRequestListSearchCounter = 0;
	public ChangeRequestTypeTokens searchChangeRequestListWith(String field, String verb, String value){		
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ChangeRequestTypeTokens searchAllTextOfChangeRequestList(String verb, String value){	
		String field = "id|name|remoteIp";
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTypeTokens rowsPerPageOfChangeRequestList(int rowsPerPage){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChangeRequestTypeTokens currentPageNumberOfChangeRequestList(int currentPageNumber){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChangeRequestTypeTokens retainColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RetainColumns",columns);
		return this;
	}
	public ChangeRequestTypeTokens excludeColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ChangeRequestTypeTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfChangeRequestList(verb, value);	
		return this;
	}
}

