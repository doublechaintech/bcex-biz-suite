
package com.doublechaintech.bcex.platform;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class PlatformTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="platform";
	
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
	protected PlatformTokens(){
		//ensure not initialized outside the class
	}
	public  static  PlatformTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		PlatformTokens tokens = new PlatformTokens(options);
		return tokens;
		
	}
	protected PlatformTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public PlatformTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PlatformTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PlatformTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PlatformTokens start(){
		return new PlatformTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PlatformTokens allTokens(){
		
		return start()
			.withChangeRequestTypeList()
			.withChangeRequestList()
			.withExamStatusList()
			.withQuestionList()
			.withExamRankingList()
			.withWechatUserList();
	
	}
	public static PlatformTokens withoutListsTokens(){
		
		return start();
	
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
	
	public PlatformTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String CHANGE_REQUEST_TYPE_LIST = "changeRequestTypeList";
	public String getChangeRequestTypeList(){
		return CHANGE_REQUEST_TYPE_LIST;
	}
	public PlatformTokens withChangeRequestTypeList(){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST);
		return this;
	}
	public PlatformTokens analyzeChangeRequestTypeList(){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeChangeRequestTypeListEnabled(){		
		
		if(checkOptions(this.options(), CHANGE_REQUEST_TYPE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromChangeRequestTypeList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int changeRequestTypeListSortCounter = 0;
	public PlatformTokens sortChangeRequestTypeListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSortCounter++, field, descOrAsc);
		return this;
	}
	private int changeRequestTypeListSearchCounter = 0;
	public PlatformTokens searchChangeRequestTypeListWith(String field, String verb, String value){		
		addSearchMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfChangeRequestTypeList(String verb, String value){	
		String field = "id|name|code|icon";
		addSearchMoreOptions(CHANGE_REQUEST_TYPE_LIST,changeRequestTypeListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfChangeRequestTypeList(int rowsPerPage){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfChangeRequestTypeList(int currentPageNumber){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfChangeRequestTypeList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfChangeRequestTypeList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_TYPE_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String CHANGE_REQUEST_LIST = "changeRequestList";
	public String getChangeRequestList(){
		return CHANGE_REQUEST_LIST;
	}
	public PlatformTokens withChangeRequestList(){		
		addSimpleOptions(CHANGE_REQUEST_LIST);
		return this;
	}
	public PlatformTokens analyzeChangeRequestList(){		
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
	public PlatformTokens extractMoreFromChangeRequestList(String idsSeperatedWithComma){		
		addSimpleOptions(CHANGE_REQUEST_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int changeRequestListSortCounter = 0;
	public PlatformTokens sortChangeRequestListWith(String field, String descOrAsc){		
		addSortMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSortCounter++, field, descOrAsc);
		return this;
	}
	private int changeRequestListSearchCounter = 0;
	public PlatformTokens searchChangeRequestListWith(String field, String verb, String value){		
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfChangeRequestList(String verb, String value){	
		String field = "id|name|remoteIp";
		addSearchMoreOptions(CHANGE_REQUEST_LIST,changeRequestListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfChangeRequestList(int rowsPerPage){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfChangeRequestList(int currentPageNumber){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfChangeRequestList(String[] columns){		
		addSimpleOptions(CHANGE_REQUEST_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EXAM_STATUS_LIST = "examStatusList";
	public String getExamStatusList(){
		return EXAM_STATUS_LIST;
	}
	public PlatformTokens withExamStatusList(){		
		addSimpleOptions(EXAM_STATUS_LIST);
		return this;
	}
	public PlatformTokens analyzeExamStatusList(){		
		addSimpleOptions(EXAM_STATUS_LIST+".anaylze");
		return this;
	}
	public boolean analyzeExamStatusListEnabled(){		
		
		if(checkOptions(this.options(), EXAM_STATUS_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromExamStatusList(String idsSeperatedWithComma){		
		addSimpleOptions(EXAM_STATUS_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int examStatusListSortCounter = 0;
	public PlatformTokens sortExamStatusListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXAM_STATUS_LIST,examStatusListSortCounter++, field, descOrAsc);
		return this;
	}
	private int examStatusListSearchCounter = 0;
	public PlatformTokens searchExamStatusListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXAM_STATUS_LIST,examStatusListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfExamStatusList(String verb, String value){	
		String field = "id|name|code";
		addSearchMoreOptions(EXAM_STATUS_LIST,examStatusListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfExamStatusList(int rowsPerPage){		
		addSimpleOptions(EXAM_STATUS_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfExamStatusList(int currentPageNumber){		
		addSimpleOptions(EXAM_STATUS_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfExamStatusList(String[] columns){		
		addSimpleOptions(EXAM_STATUS_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfExamStatusList(String[] columns){		
		addSimpleOptions(EXAM_STATUS_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String QUESTION_LIST = "questionList";
	public String getQuestionList(){
		return QUESTION_LIST;
	}
	public PlatformTokens withQuestionList(){		
		addSimpleOptions(QUESTION_LIST);
		return this;
	}
	public PlatformTokens analyzeQuestionList(){		
		addSimpleOptions(QUESTION_LIST+".anaylze");
		return this;
	}
	public boolean analyzeQuestionListEnabled(){		
		
		if(checkOptions(this.options(), QUESTION_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromQuestionList(String idsSeperatedWithComma){		
		addSimpleOptions(QUESTION_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int questionListSortCounter = 0;
	public PlatformTokens sortQuestionListWith(String field, String descOrAsc){		
		addSortMoreOptions(QUESTION_LIST,questionListSortCounter++, field, descOrAsc);
		return this;
	}
	private int questionListSearchCounter = 0;
	public PlatformTokens searchQuestionListWith(String field, String verb, String value){		
		addSearchMoreOptions(QUESTION_LIST,questionListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfQuestionList(String verb, String value){	
		String field = "id|topic|level|optionA|optionB|optionC|optionD|optionE|rightAnswer";
		addSearchMoreOptions(QUESTION_LIST,questionListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfQuestionList(int rowsPerPage){		
		addSimpleOptions(QUESTION_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfQuestionList(int currentPageNumber){		
		addSimpleOptions(QUESTION_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfQuestionList(String[] columns){		
		addSimpleOptions(QUESTION_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfQuestionList(String[] columns){		
		addSimpleOptions(QUESTION_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String EXAM_RANKING_LIST = "examRankingList";
	public String getExamRankingList(){
		return EXAM_RANKING_LIST;
	}
	public PlatformTokens withExamRankingList(){		
		addSimpleOptions(EXAM_RANKING_LIST);
		return this;
	}
	public PlatformTokens analyzeExamRankingList(){		
		addSimpleOptions(EXAM_RANKING_LIST+".anaylze");
		return this;
	}
	public boolean analyzeExamRankingListEnabled(){		
		
		if(checkOptions(this.options(), EXAM_RANKING_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromExamRankingList(String idsSeperatedWithComma){		
		addSimpleOptions(EXAM_RANKING_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int examRankingListSortCounter = 0;
	public PlatformTokens sortExamRankingListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXAM_RANKING_LIST,examRankingListSortCounter++, field, descOrAsc);
		return this;
	}
	private int examRankingListSearchCounter = 0;
	public PlatformTokens searchExamRankingListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXAM_RANKING_LIST,examRankingListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfExamRankingList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(EXAM_RANKING_LIST,examRankingListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfExamRankingList(int rowsPerPage){		
		addSimpleOptions(EXAM_RANKING_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfExamRankingList(int currentPageNumber){		
		addSimpleOptions(EXAM_RANKING_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfExamRankingList(String[] columns){		
		addSimpleOptions(EXAM_RANKING_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfExamRankingList(String[] columns){		
		addSimpleOptions(EXAM_RANKING_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	protected static final String WECHAT_USER_LIST = "wechatUserList";
	public String getWechatUserList(){
		return WECHAT_USER_LIST;
	}
	public PlatformTokens withWechatUserList(){		
		addSimpleOptions(WECHAT_USER_LIST);
		return this;
	}
	public PlatformTokens analyzeWechatUserList(){		
		addSimpleOptions(WECHAT_USER_LIST+".anaylze");
		return this;
	}
	public boolean analyzeWechatUserListEnabled(){		
		
		if(checkOptions(this.options(), WECHAT_USER_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public PlatformTokens extractMoreFromWechatUserList(String idsSeperatedWithComma){		
		addSimpleOptions(WECHAT_USER_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int wechatUserListSortCounter = 0;
	public PlatformTokens sortWechatUserListWith(String field, String descOrAsc){		
		addSortMoreOptions(WECHAT_USER_LIST,wechatUserListSortCounter++, field, descOrAsc);
		return this;
	}
	private int wechatUserListSearchCounter = 0;
	public PlatformTokens searchWechatUserListWith(String field, String verb, String value){		
		addSearchMoreOptions(WECHAT_USER_LIST,wechatUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	public PlatformTokens searchAllTextOfWechatUserList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(WECHAT_USER_LIST,wechatUserListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public PlatformTokens rowsPerPageOfWechatUserList(int rowsPerPage){		
		addSimpleOptions(WECHAT_USER_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public PlatformTokens currentPageNumberOfWechatUserList(int currentPageNumber){		
		addSimpleOptions(WECHAT_USER_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public PlatformTokens retainColumnsOfWechatUserList(String[] columns){		
		addSimpleOptions(WECHAT_USER_LIST+"RetainColumns",columns);
		return this;
	}
	public PlatformTokens excludeColumnsOfWechatUserList(String[] columns){		
		addSimpleOptions(WECHAT_USER_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  PlatformTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfChangeRequestTypeList(verb, value);	
		searchAllTextOfChangeRequestList(verb, value);	
		searchAllTextOfExamStatusList(verb, value);	
		searchAllTextOfQuestionList(verb, value);	
		searchAllTextOfExamRankingList(verb, value);	
		searchAllTextOfWechatUserList(verb, value);	
		return this;
	}
}

