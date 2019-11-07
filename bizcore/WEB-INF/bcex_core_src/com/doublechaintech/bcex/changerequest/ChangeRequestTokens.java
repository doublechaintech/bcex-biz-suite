
package com.doublechaintech.bcex.changerequest;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class ChangeRequestTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="changeRequest";
	
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
	protected ChangeRequestTokens(){
		//ensure not initialized outside the class
	}
	public  static  ChangeRequestTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ChangeRequestTokens tokens = new ChangeRequestTokens(options);
		return tokens;
		
	}
	protected ChangeRequestTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ChangeRequestTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ChangeRequestTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ChangeRequestTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ChangeRequestTokens start(){
		return new ChangeRequestTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ChangeRequestTokens allTokens(){
		
		return start()
			.withRequestType()
			.withPlatform()
			.withRegisterationList()
			.withStartExamList()
			.withAnswerQuestionList();
	
	}
	public static ChangeRequestTokens withoutListsTokens(){
		
		return start()
			.withRequestType()
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
	
	public ChangeRequestTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String REQUESTTYPE = "requestType";
	public String getRequestType(){
		return REQUESTTYPE;
	}
	public ChangeRequestTokens withRequestType(){		
		addSimpleOptions(REQUESTTYPE);
		return this;
	}
	
	
	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ChangeRequestTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String REGISTERATION_LIST = "registerationList";
	public String getRegisterationList(){
		return REGISTERATION_LIST;
	}
	public ChangeRequestTokens withRegisterationList(){		
		addSimpleOptions(REGISTERATION_LIST);
		return this;
	}
	public ChangeRequestTokens analyzeRegisterationList(){		
		addSimpleOptions(REGISTERATION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeRegisterationListEnabled(){		
		
		if(checkOptions(this.options(), REGISTERATION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChangeRequestTokens extractMoreFromRegisterationList(String idsSeperatedWithComma){		
		addSimpleOptions(REGISTERATION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int registerationListSortCounter = 0;
	public ChangeRequestTokens sortRegisterationListWith(String field, String descOrAsc){		
		addSortMoreOptions(REGISTERATION_LIST,registerationListSortCounter++, field, descOrAsc);
		return this;
	}
	private int registerationListSearchCounter = 0;
	public ChangeRequestTokens searchRegisterationListWith(String field, String verb, String value){		
		addSearchMoreOptions(REGISTERATION_LIST,registerationListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ChangeRequestTokens searchAllTextOfRegisterationList(String verb, String value){	
		String field = "id|nickName";
		addSearchMoreOptions(REGISTERATION_LIST,registerationListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTokens rowsPerPageOfRegisterationList(int rowsPerPage){		
		addSimpleOptions(REGISTERATION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChangeRequestTokens currentPageNumberOfRegisterationList(int currentPageNumber){		
		addSimpleOptions(REGISTERATION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChangeRequestTokens retainColumnsOfRegisterationList(String[] columns){		
		addSimpleOptions(REGISTERATION_LIST+"RetainColumns",columns);
		return this;
	}
	public ChangeRequestTokens excludeColumnsOfRegisterationList(String[] columns){		
		addSimpleOptions(REGISTERATION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String START_EXAM_LIST = "startExamList";
	public String getStartExamList(){
		return START_EXAM_LIST;
	}
	public ChangeRequestTokens withStartExamList(){		
		addSimpleOptions(START_EXAM_LIST);
		return this;
	}
	public ChangeRequestTokens analyzeStartExamList(){		
		addSimpleOptions(START_EXAM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeStartExamListEnabled(){		
		
		if(checkOptions(this.options(), START_EXAM_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChangeRequestTokens extractMoreFromStartExamList(String idsSeperatedWithComma){		
		addSimpleOptions(START_EXAM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int startExamListSortCounter = 0;
	public ChangeRequestTokens sortStartExamListWith(String field, String descOrAsc){		
		addSortMoreOptions(START_EXAM_LIST,startExamListSortCounter++, field, descOrAsc);
		return this;
	}
	private int startExamListSearchCounter = 0;
	public ChangeRequestTokens searchStartExamListWith(String field, String verb, String value){		
		addSearchMoreOptions(START_EXAM_LIST,startExamListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ChangeRequestTokens searchAllTextOfStartExamList(String verb, String value){	
		String field = "id|nickName";
		addSearchMoreOptions(START_EXAM_LIST,startExamListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTokens rowsPerPageOfStartExamList(int rowsPerPage){		
		addSimpleOptions(START_EXAM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChangeRequestTokens currentPageNumberOfStartExamList(int currentPageNumber){		
		addSimpleOptions(START_EXAM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChangeRequestTokens retainColumnsOfStartExamList(String[] columns){		
		addSimpleOptions(START_EXAM_LIST+"RetainColumns",columns);
		return this;
	}
	public ChangeRequestTokens excludeColumnsOfStartExamList(String[] columns){		
		addSimpleOptions(START_EXAM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String ANSWER_QUESTION_LIST = "answerQuestionList";
	public String getAnswerQuestionList(){
		return ANSWER_QUESTION_LIST;
	}
	public ChangeRequestTokens withAnswerQuestionList(){		
		addSimpleOptions(ANSWER_QUESTION_LIST);
		return this;
	}
	public ChangeRequestTokens analyzeAnswerQuestionList(){		
		addSimpleOptions(ANSWER_QUESTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeAnswerQuestionListEnabled(){		
		
		if(checkOptions(this.options(), ANSWER_QUESTION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public ChangeRequestTokens extractMoreFromAnswerQuestionList(String idsSeperatedWithComma){		
		addSimpleOptions(ANSWER_QUESTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int answerQuestionListSortCounter = 0;
	public ChangeRequestTokens sortAnswerQuestionListWith(String field, String descOrAsc){		
		addSortMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int answerQuestionListSearchCounter = 0;
	public ChangeRequestTokens searchAnswerQuestionListWith(String field, String verb, String value){		
		addSearchMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ChangeRequestTokens searchAllTextOfAnswerQuestionList(String verb, String value){	
		String field = "id|nickName|answer";
		addSearchMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ChangeRequestTokens rowsPerPageOfAnswerQuestionList(int rowsPerPage){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ChangeRequestTokens currentPageNumberOfAnswerQuestionList(int currentPageNumber){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ChangeRequestTokens retainColumnsOfAnswerQuestionList(String[] columns){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"RetainColumns",columns);
		return this;
	}
	public ChangeRequestTokens excludeColumnsOfAnswerQuestionList(String[] columns){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ChangeRequestTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfRegisterationList(verb, value);	
		searchAllTextOfStartExamList(verb, value);	
		searchAllTextOfAnswerQuestionList(verb, value);	
		return this;
	}
}

