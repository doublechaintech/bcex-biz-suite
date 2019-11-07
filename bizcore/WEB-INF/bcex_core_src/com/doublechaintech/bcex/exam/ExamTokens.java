
package com.doublechaintech.bcex.exam;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class ExamTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="exam";
	
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
	protected ExamTokens(){
		//ensure not initialized outside the class
	}
	public  static  ExamTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ExamTokens tokens = new ExamTokens(options);
		return tokens;
		
	}
	protected ExamTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ExamTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ExamTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ExamTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ExamTokens start(){
		return new ExamTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ExamTokens allTokens(){
		
		return start()
			.withStatus()
			.withUser()
			.withUserAnswerList()
			.withFaultAnswerList();
	
	}
	public static ExamTokens withoutListsTokens(){
		
		return start()
			.withStatus()
			.withUser();
	
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
	
	public ExamTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String STATUS = "status";
	public String getStatus(){
		return STATUS;
	}
	public ExamTokens withStatus(){		
		addSimpleOptions(STATUS);
		return this;
	}
	
	
	protected static final String USER = "user";
	public String getUser(){
		return USER;
	}
	public ExamTokens withUser(){		
		addSimpleOptions(USER);
		return this;
	}
	
	
	protected static final String USER_ANSWER_LIST = "userAnswerList";
	public String getUserAnswerList(){
		return USER_ANSWER_LIST;
	}
	public ExamTokens withUserAnswerList(){		
		addSimpleOptions(USER_ANSWER_LIST);
		return this;
	}
	public ExamTokens analyzeUserAnswerList(){		
		addSimpleOptions(USER_ANSWER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeUserAnswerListEnabled(){		
		
		if(checkOptions(this.options(), USER_ANSWER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ExamTokens extractMoreFromUserAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userAnswerListSortCounter = 0;
	public ExamTokens sortUserAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ANSWER_LIST,userAnswerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAnswerListSearchCounter = 0;
	public ExamTokens searchUserAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ANSWER_LIST,userAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ExamTokens searchAllTextOfUserAnswerList(String verb, String value){	
		String field = "id|topic|userSelect";
		addSearchMoreOptions(USER_ANSWER_LIST,userAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExamTokens rowsPerPageOfUserAnswerList(int rowsPerPage){		
		addSimpleOptions(USER_ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ExamTokens currentPageNumberOfUserAnswerList(int currentPageNumber){		
		addSimpleOptions(USER_ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ExamTokens retainColumnsOfUserAnswerList(String[] columns){		
		addSimpleOptions(USER_ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public ExamTokens excludeColumnsOfUserAnswerList(String[] columns){		
		addSimpleOptions(USER_ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FAULT_ANSWER_LIST = "faultAnswerList";
	public String getFaultAnswerList(){
		return FAULT_ANSWER_LIST;
	}
	public ExamTokens withFaultAnswerList(){		
		addSimpleOptions(FAULT_ANSWER_LIST);
		return this;
	}
	public ExamTokens analyzeFaultAnswerList(){		
		addSimpleOptions(FAULT_ANSWER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeFaultAnswerListEnabled(){		
		
		if(checkOptions(this.options(), FAULT_ANSWER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ExamTokens extractMoreFromFaultAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(FAULT_ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int faultAnswerListSortCounter = 0;
	public ExamTokens sortFaultAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int faultAnswerListSearchCounter = 0;
	public ExamTokens searchFaultAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ExamTokens searchAllTextOfFaultAnswerList(String verb, String value){	
		String field = "id|topic|yourAnswer|rightAnswer";
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExamTokens rowsPerPageOfFaultAnswerList(int rowsPerPage){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ExamTokens currentPageNumberOfFaultAnswerList(int currentPageNumber){		
		addSimpleOptions(FAULT_ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ExamTokens retainColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public ExamTokens excludeColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ExamTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfUserAnswerList(verb, value);	
		searchAllTextOfFaultAnswerList(verb, value);	
		return this;
	}
}

