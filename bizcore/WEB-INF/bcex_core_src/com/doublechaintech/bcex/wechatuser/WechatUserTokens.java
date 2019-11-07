
package com.doublechaintech.bcex.wechatuser;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class WechatUserTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="wechatUser";
	
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
	protected WechatUserTokens(){
		//ensure not initialized outside the class
	}
	public  static  WechatUserTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WechatUserTokens tokens = new WechatUserTokens(options);
		return tokens;
		
	}
	protected WechatUserTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public WechatUserTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static WechatUserTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected WechatUserTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static WechatUserTokens start(){
		return new WechatUserTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static WechatUserTokens allTokens(){
		
		return start()
			.withPlatform()
			.withAnswerQuestionList()
			.withExamList()
			.withFaultAnswerList();
	
	}
	public static WechatUserTokens withoutListsTokens(){
		
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
	
	public WechatUserTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public WechatUserTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String ANSWER_QUESTION_LIST = "answerQuestionList";
	public String getAnswerQuestionList(){
		return ANSWER_QUESTION_LIST;
	}
	public WechatUserTokens withAnswerQuestionList(){		
		addSimpleOptions(ANSWER_QUESTION_LIST);
		return this;
	}
	public WechatUserTokens analyzeAnswerQuestionList(){		
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
	public WechatUserTokens extractMoreFromAnswerQuestionList(String idsSeperatedWithComma){		
		addSimpleOptions(ANSWER_QUESTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int answerQuestionListSortCounter = 0;
	public WechatUserTokens sortAnswerQuestionListWith(String field, String descOrAsc){		
		addSortMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int answerQuestionListSearchCounter = 0;
	public WechatUserTokens searchAnswerQuestionListWith(String field, String verb, String value){		
		addSearchMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public WechatUserTokens searchAllTextOfAnswerQuestionList(String verb, String value){	
		String field = "id|nickName|answer";
		addSearchMoreOptions(ANSWER_QUESTION_LIST,answerQuestionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public WechatUserTokens rowsPerPageOfAnswerQuestionList(int rowsPerPage){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WechatUserTokens currentPageNumberOfAnswerQuestionList(int currentPageNumber){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WechatUserTokens retainColumnsOfAnswerQuestionList(String[] columns){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"RetainColumns",columns);
		return this;
	}
	public WechatUserTokens excludeColumnsOfAnswerQuestionList(String[] columns){		
		addSimpleOptions(ANSWER_QUESTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EXAM_LIST = "examList";
	public String getExamList(){
		return EXAM_LIST;
	}
	public WechatUserTokens withExamList(){		
		addSimpleOptions(EXAM_LIST);
		return this;
	}
	public WechatUserTokens analyzeExamList(){		
		addSimpleOptions(EXAM_LIST+".anaylze");
		return this;
	}
	public boolean analyzeExamListEnabled(){		
		
		if(checkOptions(this.options(), EXAM_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WechatUserTokens extractMoreFromExamList(String idsSeperatedWithComma){		
		addSimpleOptions(EXAM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int examListSortCounter = 0;
	public WechatUserTokens sortExamListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXAM_LIST,examListSortCounter++, field, descOrAsc);
		return this;
	}
	private int examListSearchCounter = 0;
	public WechatUserTokens searchExamListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXAM_LIST,examListSearchCounter++, field, verb, value);
		return this;
	}
	
	public WechatUserTokens searchAllTextOfExamList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(EXAM_LIST,examListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public WechatUserTokens rowsPerPageOfExamList(int rowsPerPage){		
		addSimpleOptions(EXAM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WechatUserTokens currentPageNumberOfExamList(int currentPageNumber){		
		addSimpleOptions(EXAM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WechatUserTokens retainColumnsOfExamList(String[] columns){		
		addSimpleOptions(EXAM_LIST+"RetainColumns",columns);
		return this;
	}
	public WechatUserTokens excludeColumnsOfExamList(String[] columns){		
		addSimpleOptions(EXAM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String FAULT_ANSWER_LIST = "faultAnswerList";
	public String getFaultAnswerList(){
		return FAULT_ANSWER_LIST;
	}
	public WechatUserTokens withFaultAnswerList(){		
		addSimpleOptions(FAULT_ANSWER_LIST);
		return this;
	}
	public WechatUserTokens analyzeFaultAnswerList(){		
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
	public WechatUserTokens extractMoreFromFaultAnswerList(String idsSeperatedWithComma){		
		addSimpleOptions(FAULT_ANSWER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int faultAnswerListSortCounter = 0;
	public WechatUserTokens sortFaultAnswerListWith(String field, String descOrAsc){		
		addSortMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSortCounter++, field, descOrAsc);
		return this;
	}
	private int faultAnswerListSearchCounter = 0;
	public WechatUserTokens searchFaultAnswerListWith(String field, String verb, String value){		
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	public WechatUserTokens searchAllTextOfFaultAnswerList(String verb, String value){	
		String field = "id|topic|yourAnswer|rightAnswer";
		addSearchMoreOptions(FAULT_ANSWER_LIST,faultAnswerListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public WechatUserTokens rowsPerPageOfFaultAnswerList(int rowsPerPage){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WechatUserTokens currentPageNumberOfFaultAnswerList(int currentPageNumber){		
		addSimpleOptions(FAULT_ANSWER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WechatUserTokens retainColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"RetainColumns",columns);
		return this;
	}
	public WechatUserTokens excludeColumnsOfFaultAnswerList(String[] columns){		
		addSimpleOptions(FAULT_ANSWER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  WechatUserTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfAnswerQuestionList(verb, value);	
		searchAllTextOfExamList(verb, value);	
		searchAllTextOfFaultAnswerList(verb, value);	
		return this;
	}
}

