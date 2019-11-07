
package com.doublechaintech.bcex.examstatus;
import com.doublechaintech.bcex.CommonTokens;
import java.util.Map;
public class ExamStatusTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="examStatus";
	
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
	protected ExamStatusTokens(){
		//ensure not initialized outside the class
	}
	public  static  ExamStatusTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		ExamStatusTokens tokens = new ExamStatusTokens(options);
		return tokens;
		
	}
	protected ExamStatusTokens(Map<String,Object> options){
		this.options = options;
	}
	
	public ExamStatusTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static ExamStatusTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected ExamStatusTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static ExamStatusTokens start(){
		return new ExamStatusTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static ExamStatusTokens allTokens(){
		
		return start()
			.withPlatform()
			.withExamList();
	
	}
	public static ExamStatusTokens withoutListsTokens(){
		
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
	
	public ExamStatusTokens analyzeAllLists(){		
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String PLATFORM = "platform";
	public String getPlatform(){
		return PLATFORM;
	}
	public ExamStatusTokens withPlatform(){		
		addSimpleOptions(PLATFORM);
		return this;
	}
	
	
	protected static final String EXAM_LIST = "examList";
	public String getExamList(){
		return EXAM_LIST;
	}
	public ExamStatusTokens withExamList(){		
		addSimpleOptions(EXAM_LIST);
		return this;
	}
	public ExamStatusTokens analyzeExamList(){		
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
	public ExamStatusTokens extractMoreFromExamList(String idsSeperatedWithComma){		
		addSimpleOptions(EXAM_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}
	
	
	
	
	private int examListSortCounter = 0;
	public ExamStatusTokens sortExamListWith(String field, String descOrAsc){		
		addSortMoreOptions(EXAM_LIST,examListSortCounter++, field, descOrAsc);
		return this;
	}
	private int examListSearchCounter = 0;
	public ExamStatusTokens searchExamListWith(String field, String verb, String value){		
		addSearchMoreOptions(EXAM_LIST,examListSearchCounter++, field, verb, value);
		return this;
	}
	
	public ExamStatusTokens searchAllTextOfExamList(String verb, String value){	
		String field = "id|name";
		addSearchMoreOptions(EXAM_LIST,examListSearchCounter++, field, verb, value);
		return this;
	}
	
	
	
	public ExamStatusTokens rowsPerPageOfExamList(int rowsPerPage){		
		addSimpleOptions(EXAM_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public ExamStatusTokens currentPageNumberOfExamList(int currentPageNumber){		
		addSimpleOptions(EXAM_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public ExamStatusTokens retainColumnsOfExamList(String[] columns){		
		addSimpleOptions(EXAM_LIST+"RetainColumns",columns);
		return this;
	}
	public ExamStatusTokens excludeColumnsOfExamList(String[] columns){		
		addSimpleOptions(EXAM_LIST+"ExcludeColumns",columns);
		return this;
	}
	
	
		
	
	public  ExamStatusTokens searchEntireObjectText(String verb, String value){
		
		searchAllTextOfExamList(verb, value);	
		return this;
	}
}

