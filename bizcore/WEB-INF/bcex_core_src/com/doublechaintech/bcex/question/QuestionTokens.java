
package com.doublechaintech.bcex.question;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class QuestionTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="question";
	
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
	protected QuestionTokens(){
		//ensure not initialized outside the class
	}
	public  static  QuestionTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		QuestionTokens tokens = new QuestionTokens(options);
		return tokens;
		
	}
	protected QuestionTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public QuestionTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static QuestionTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected QuestionTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static QuestionTokens start(){
		return new QuestionTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static QuestionTokens allTokens(){
		
		return start()
			.withPlatform()
			.withAnswerList()
			.withUserAnswerList()
			.withFaultAnswerList();
	
	}
	public static QuestionTokens withoutListsTokens(){
		
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
	
	public QuestionTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public QuestionTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String ANSWER_LIST = "answerList";
	public String getAnswerList(){
		return ANSWER_LIST;
	}
	public QuestionTokens withAnswerList(){		
		addSimpleOptions(ANSWER_LIST);
		return this;
	}
	public QuestionTokens analyzeAnswerList(){		
		addSimpleOptions(ANSWER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAnswerListEnabled(){		
		
		if(checkOptions(this.options(), ANSWER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public QuestionTokens extractMoreFromAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int answerListSortCounter = 0;
	public QuestionTokens sortAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(ANSWER_LIST,answerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int answerListSearchCounter = 0;
	public QuestionTokens searchAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(ANSWER_LIST,answerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public QuestionTokens searchAllTextOfAnswerList(String verb, String value){	
		String field = "id|title|comment";
		addSearchMoreOptions(ANSWER_LIST,answerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public QuestionTokens rowsPerPageOfAnswerList(int rowsPerPage){		
		addSimpleOptions(ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public QuestionTokens currentPageNumberOfAnswerList(int currentPageNumber){		
		addSimpleOptions(ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public QuestionTokens retainColumnsOfAnswerList(String[] columns){		
		addSimpleOptions(ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public QuestionTokens excludeColumnsOfAnswerList(String[] columns){		
		addSimpleOptions(ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String USER_ANSWER_LIST = "userAnswerList";
	public String getUserAnswerList(){
		return USER_ANSWER_LIST;
	}
	public QuestionTokens withUserAnswerList(){		
		addSimpleOptions(USER_ANSWER_LIST);
		return this;
	}
	public QuestionTokens analyzeUserAnswerList(){		
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
	public QuestionTokens extractMoreFromUserAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(USER_ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int userAnswerListSortCounter = 0;
	public QuestionTokens sortUserAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(USER_ANSWER_LIST,userAnswerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int userAnswerListSearchCounter = 0;
	public QuestionTokens searchUserAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(USER_ANSWER_LIST,userAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public QuestionTokens searchAllTextOfUserAnswerList(String verb, String value){	
		String field = "id|topic|userSelect";
		addSearchMoreOptions(USER_ANSWER_LIST,userAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public QuestionTokens rowsPerPageOfUserAnswerList(int rowsPerPage){		
		addSimpleOptions(USER_ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public QuestionTokens currentPageNumberOfUserAnswerList(int currentPageNumber){		
		addSimpleOptions(USER_ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public QuestionTokens retainColumnsOfUserAnswerList(String[] columns){		
		addSimpleOptions(USER_ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public QuestionTokens excludeColumnsOfUserAnswerList(String[] columns){		
		addSimpleOptions(USER_ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FAULT_ANSWER_LIST = "faultAnswerList";
	public String getFaultAnswerList(){
		return FAULT_ANSWER_LIST;
	}
	public QuestionTokens withFaultAnswerList(){		
		addSimpleOptions(FAULT_ANSWER_LIST);
		return this;
	}
	public QuestionTokens analyzeFaultAnswerList(){		
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
	public QuestionTokens extractMoreFromFaultAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(FAULT_ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int faultAnswerListSortCounter = 0;
	public QuestionTokens sortFaultAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int faultAnswerListSearchCounter = 0;
	public QuestionTokens searchFaultAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public QuestionTokens searchAllTextOfFaultAnswerList(String verb, String value){	
		String field = "id|topic|yourAnswer|rightAnswer";
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public QuestionTokens rowsPerPageOfFaultAnswerList(int rowsPerPage){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public QuestionTokens currentPageNumberOfFaultAnswerList(int currentPageNumber){		
		addSimpleOptions(FAULT_ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public QuestionTokens retainColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public QuestionTokens excludeColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  QuestionTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfAnswerList(verb, value);	
		searchAllTextOfUserAnswerList(verb, value);	
		searchAllTextOfFaultAnswerList(verb, value);	
		return this;
	}
}

