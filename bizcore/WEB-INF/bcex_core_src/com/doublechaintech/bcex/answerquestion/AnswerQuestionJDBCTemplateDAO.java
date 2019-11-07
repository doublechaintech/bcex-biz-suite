
package com.doublechaintech.bcex.answerquestion;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BcexBaseDAOImpl;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.AccessKey;
import com.doublechaintech.bcex.DateKey;
import com.doublechaintech.bcex.StatsInfo;
import com.doublechaintech.bcex.StatsItem;

import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;


import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.question.QuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class AnswerQuestionJDBCTemplateDAO extends BcexBaseDAOImpl implements AnswerQuestionDAO{
 
 	
 	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO changeRequestDAO){
	 	this.changeRequestDAO = changeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
	 	return this.changeRequestDAO;
 	}
 
 	
 	private  WechatUserDAO  wechatUserDAO;
 	public void setWechatUserDAO(WechatUserDAO wechatUserDAO){
	 	this.wechatUserDAO = wechatUserDAO;
 	}
 	public WechatUserDAO getWechatUserDAO(){
	 	return this.wechatUserDAO;
 	}
 
 	
 	private  QuestionDAO  questionDAO;
 	public void setQuestionDAO(QuestionDAO questionDAO){
	 	this.questionDAO = questionDAO;
 	}
 	public QuestionDAO getQuestionDAO(){
	 	return this.questionDAO;
 	}


			
		

	
	/*
	protected AnswerQuestion load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAnswerQuestion(accessKey, options);
	}
	*/
	
	public SmartList<AnswerQuestion> loadAll() {
	    return this.loadAll(getAnswerQuestionMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public AnswerQuestion load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAnswerQuestion(AnswerQuestionTable.withId(id), options);
	}
	
	
	
	public AnswerQuestion save(AnswerQuestion answerQuestion,Map<String,Object> options){
		
		String methodName="save(AnswerQuestion answerQuestion,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(answerQuestion, methodName, "answerQuestion");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAnswerQuestion(answerQuestion,options);
	}
	public AnswerQuestion clone(String answerQuestionId, Map<String,Object> options) throws Exception{
	
		return clone(AnswerQuestionTable.withId(answerQuestionId),options);
	}
	
	protected AnswerQuestion clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String answerQuestionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		AnswerQuestion newAnswerQuestion = loadInternalAnswerQuestion(accessKey, options);
		newAnswerQuestion.setVersion(0);
		
		

		
		saveInternalAnswerQuestion(newAnswerQuestion,options);
		
		return newAnswerQuestion;
	}
	
	
	
	

	protected void throwIfHasException(String answerQuestionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AnswerQuestionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AnswerQuestionNotFoundException(
					"The " + this.getTableName() + "(" + answerQuestionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String answerQuestionId, int version) throws Exception{
	
		String methodName="delete(String answerQuestionId, int version)";
		assertMethodArgumentNotNull(answerQuestionId, methodName, "answerQuestionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{answerQuestionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(answerQuestionId,version);
		}
		
	
	}
	
	
	
	
	

	public AnswerQuestion disconnectFromAll(String answerQuestionId, int version) throws Exception{
	
		
		AnswerQuestion answerQuestion = loadInternalAnswerQuestion(AnswerQuestionTable.withId(answerQuestionId), emptyOptions());
		answerQuestion.clearFromAll();
		this.saveAnswerQuestion(answerQuestion);
		return answerQuestion;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AnswerQuestionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "answer_question";
	}
	@Override
	protected String getBeanName() {
		
		return "answerQuestion";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AnswerQuestionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AnswerQuestionTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AnswerQuestionTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractQuestionEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AnswerQuestionTokens.QUESTION);
 	}

 	protected boolean isSaveQuestionEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AnswerQuestionTokens.QUESTION);
 	}
 	

 	
  

 	protected boolean isExtractChangeRequestEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AnswerQuestionTokens.CHANGEREQUEST);
 	}

 	protected boolean isSaveChangeRequestEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AnswerQuestionTokens.CHANGEREQUEST);
 	}
 	

 	
 
		

	

	protected AnswerQuestionMapper getAnswerQuestionMapper(){
		return new AnswerQuestionMapper();
	}

	
	
	protected AnswerQuestion extractAnswerQuestion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			AnswerQuestion answerQuestion = loadSingleObject(accessKey, getAnswerQuestionMapper());
			return answerQuestion;
		}catch(EmptyResultDataAccessException e){
			throw new AnswerQuestionNotFoundException("AnswerQuestion("+accessKey+") is not found!");
		}

	}

	
	

	protected AnswerQuestion loadInternalAnswerQuestion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		AnswerQuestion answerQuestion = extractAnswerQuestion(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(answerQuestion, loadOptions);
 		}
  	
 		if(isExtractQuestionEnabled(loadOptions)){
	 		extractQuestion(answerQuestion, loadOptions);
 		}
  	
 		if(isExtractChangeRequestEnabled(loadOptions)){
	 		extractChangeRequest(answerQuestion, loadOptions);
 		}
 
		
		return answerQuestion;
		
	}

	 

 	protected AnswerQuestion extractUser(AnswerQuestion answerQuestion, Map<String,Object> options) throws Exception{

		if(answerQuestion.getUser() == null){
			return answerQuestion;
		}
		String userId = answerQuestion.getUser().getId();
		if( userId == null){
			return answerQuestion;
		}
		WechatUser user = getWechatUserDAO().load(userId,options);
		if(user != null){
			answerQuestion.setUser(user);
		}
		
 		
 		return answerQuestion;
 	}
 		
  

 	protected AnswerQuestion extractQuestion(AnswerQuestion answerQuestion, Map<String,Object> options) throws Exception{

		if(answerQuestion.getQuestion() == null){
			return answerQuestion;
		}
		String questionId = answerQuestion.getQuestion().getId();
		if( questionId == null){
			return answerQuestion;
		}
		Question question = getQuestionDAO().load(questionId,options);
		if(question != null){
			answerQuestion.setQuestion(question);
		}
		
 		
 		return answerQuestion;
 	}
 		
  

 	protected AnswerQuestion extractChangeRequest(AnswerQuestion answerQuestion, Map<String,Object> options) throws Exception{

		if(answerQuestion.getChangeRequest() == null){
			return answerQuestion;
		}
		String changeRequestId = answerQuestion.getChangeRequest().getId();
		if( changeRequestId == null){
			return answerQuestion;
		}
		ChangeRequest changeRequest = getChangeRequestDAO().load(changeRequestId,options);
		if(changeRequest != null){
			answerQuestion.setChangeRequest(changeRequest);
		}
		
 		
 		return answerQuestion;
 	}
 		
 
		
		
  	
 	public SmartList<AnswerQuestion> findAnswerQuestionByUser(String wechatUserId,Map<String,Object> options){
 	
  		SmartList<AnswerQuestion> resultList = queryWith(AnswerQuestionTable.COLUMN_USER, wechatUserId, options, getAnswerQuestionMapper());
		// analyzeAnswerQuestionByUser(resultList, wechatUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AnswerQuestion> findAnswerQuestionByUser(String wechatUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AnswerQuestion> resultList =  queryWithRange(AnswerQuestionTable.COLUMN_USER, wechatUserId, options, getAnswerQuestionMapper(), start, count);
 		//analyzeAnswerQuestionByUser(resultList, wechatUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeAnswerQuestionByUser(SmartList<AnswerQuestion> resultList, String wechatUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AnswerQuestion.USER_PROPERTY, wechatUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAnswerQuestionByUser(String wechatUserId,Map<String,Object> options){

 		return countWith(AnswerQuestionTable.COLUMN_USER, wechatUserId, options);
 	}
 	@Override
	public Map<String, Integer> countAnswerQuestionByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AnswerQuestionTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<AnswerQuestion> findAnswerQuestionByQuestion(String questionId,Map<String,Object> options){
 	
  		SmartList<AnswerQuestion> resultList = queryWith(AnswerQuestionTable.COLUMN_QUESTION, questionId, options, getAnswerQuestionMapper());
		// analyzeAnswerQuestionByQuestion(resultList, questionId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AnswerQuestion> findAnswerQuestionByQuestion(String questionId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AnswerQuestion> resultList =  queryWithRange(AnswerQuestionTable.COLUMN_QUESTION, questionId, options, getAnswerQuestionMapper(), start, count);
 		//analyzeAnswerQuestionByQuestion(resultList, questionId, options);
 		return resultList;
 		
 	}
 	public void analyzeAnswerQuestionByQuestion(SmartList<AnswerQuestion> resultList, String questionId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AnswerQuestion.QUESTION_PROPERTY, questionId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAnswerQuestionByQuestion(String questionId,Map<String,Object> options){

 		return countWith(AnswerQuestionTable.COLUMN_QUESTION, questionId, options);
 	}
 	@Override
	public Map<String, Integer> countAnswerQuestionByQuestionIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AnswerQuestionTable.COLUMN_QUESTION, ids, options);
	}
 	
  	
 	public SmartList<AnswerQuestion> findAnswerQuestionByChangeRequest(String changeRequestId,Map<String,Object> options){
 	
  		SmartList<AnswerQuestion> resultList = queryWith(AnswerQuestionTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getAnswerQuestionMapper());
		// analyzeAnswerQuestionByChangeRequest(resultList, changeRequestId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<AnswerQuestion> findAnswerQuestionByChangeRequest(String changeRequestId, int start, int count,Map<String,Object> options){
 		
 		SmartList<AnswerQuestion> resultList =  queryWithRange(AnswerQuestionTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getAnswerQuestionMapper(), start, count);
 		//analyzeAnswerQuestionByChangeRequest(resultList, changeRequestId, options);
 		return resultList;
 		
 	}
 	public void analyzeAnswerQuestionByChangeRequest(SmartList<AnswerQuestion> resultList, String changeRequestId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countAnswerQuestionByChangeRequest(String changeRequestId,Map<String,Object> options){

 		return countWith(AnswerQuestionTable.COLUMN_CHANGE_REQUEST, changeRequestId, options);
 	}
 	@Override
	public Map<String, Integer> countAnswerQuestionByChangeRequestIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AnswerQuestionTable.COLUMN_CHANGE_REQUEST, ids, options);
	}
 	
 	
		
		
		

	

	protected AnswerQuestion saveAnswerQuestion(AnswerQuestion  answerQuestion){
		
		if(!answerQuestion.isChanged()){
			return answerQuestion;
		}
		
		
		String SQL=this.getSaveAnswerQuestionSQL(answerQuestion);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAnswerQuestionParameters(answerQuestion);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		answerQuestion.incVersion();
		return answerQuestion;
	
	}
	public SmartList<AnswerQuestion> saveAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAnswerQuestionList(answerQuestionList);
		
		batchAnswerQuestionCreate((List<AnswerQuestion>)lists[CREATE_LIST_INDEX]);
		
		batchAnswerQuestionUpdate((List<AnswerQuestion>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(AnswerQuestion answerQuestion:answerQuestionList){
			if(answerQuestion.isChanged()){
				answerQuestion.incVersion();
			}
			
		
		}
		
		
		return answerQuestionList;
	}

	public SmartList<AnswerQuestion> removeAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options){
		
		
		super.removeList(answerQuestionList, options);
		
		return answerQuestionList;
		
		
	}
	
	protected List<Object[]> prepareAnswerQuestionBatchCreateArgs(List<AnswerQuestion> answerQuestionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AnswerQuestion answerQuestion:answerQuestionList ){
			Object [] parameters = prepareAnswerQuestionCreateParameters(answerQuestion);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAnswerQuestionBatchUpdateArgs(List<AnswerQuestion> answerQuestionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(AnswerQuestion answerQuestion:answerQuestionList ){
			if(!answerQuestion.isChanged()){
				continue;
			}
			Object [] parameters = prepareAnswerQuestionUpdateParameters(answerQuestion);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAnswerQuestionCreate(List<AnswerQuestion> answerQuestionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAnswerQuestionBatchCreateArgs(answerQuestionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAnswerQuestionUpdate(List<AnswerQuestion> answerQuestionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAnswerQuestionBatchUpdateArgs(answerQuestionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAnswerQuestionList(List<AnswerQuestion> answerQuestionList){
		
		List<AnswerQuestion> answerQuestionCreateList=new ArrayList<AnswerQuestion>();
		List<AnswerQuestion> answerQuestionUpdateList=new ArrayList<AnswerQuestion>();
		
		for(AnswerQuestion answerQuestion: answerQuestionList){
			if(isUpdateRequest(answerQuestion)){
				answerQuestionUpdateList.add( answerQuestion);
				continue;
			}
			answerQuestionCreateList.add(answerQuestion);
		}
		
		return new Object[]{answerQuestionCreateList,answerQuestionUpdateList};
	}
	
	protected boolean isUpdateRequest(AnswerQuestion answerQuestion){
 		return answerQuestion.getVersion() > 0;
 	}
 	protected String getSaveAnswerQuestionSQL(AnswerQuestion answerQuestion){
 		if(isUpdateRequest(answerQuestion)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAnswerQuestionParameters(AnswerQuestion answerQuestion){
 		if(isUpdateRequest(answerQuestion) ){
 			return prepareAnswerQuestionUpdateParameters(answerQuestion);
 		}
 		return prepareAnswerQuestionCreateParameters(answerQuestion);
 	}
 	protected Object[] prepareAnswerQuestionUpdateParameters(AnswerQuestion answerQuestion){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = answerQuestion.getNickName(); 	
 		if(answerQuestion.getUser() != null){
 			parameters[1] = answerQuestion.getUser().getId();
 		}
  	
 		if(answerQuestion.getQuestion() != null){
 			parameters[2] = answerQuestion.getQuestion().getId();
 		}
 
 		parameters[3] = answerQuestion.getAnswer(); 	
 		if(answerQuestion.getChangeRequest() != null){
 			parameters[4] = answerQuestion.getChangeRequest().getId();
 		}
 		
 		parameters[5] = answerQuestion.nextVersion();
 		parameters[6] = answerQuestion.getId();
 		parameters[7] = answerQuestion.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAnswerQuestionCreateParameters(AnswerQuestion answerQuestion){
		Object[] parameters = new Object[6];
		String newAnswerQuestionId=getNextId();
		answerQuestion.setId(newAnswerQuestionId);
		parameters[0] =  answerQuestion.getId();
 
 		parameters[1] = answerQuestion.getNickName(); 	
 		if(answerQuestion.getUser() != null){
 			parameters[2] = answerQuestion.getUser().getId();
 		
 		}
 		 	
 		if(answerQuestion.getQuestion() != null){
 			parameters[3] = answerQuestion.getQuestion().getId();
 		
 		}
 		
 		parameters[4] = answerQuestion.getAnswer(); 	
 		if(answerQuestion.getChangeRequest() != null){
 			parameters[5] = answerQuestion.getChangeRequest().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected AnswerQuestion saveInternalAnswerQuestion(AnswerQuestion answerQuestion, Map<String,Object> options){
		
		saveAnswerQuestion(answerQuestion);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(answerQuestion, options);
 		}
  	
 		if(isSaveQuestionEnabled(options)){
	 		saveQuestion(answerQuestion, options);
 		}
  	
 		if(isSaveChangeRequestEnabled(options)){
	 		saveChangeRequest(answerQuestion, options);
 		}
 
		
		return answerQuestion;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected AnswerQuestion saveUser(AnswerQuestion answerQuestion, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(answerQuestion.getUser() == null){
 			return answerQuestion;//do nothing when it is null
 		}
 		
 		getWechatUserDAO().save(answerQuestion.getUser(),options);
 		return answerQuestion;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AnswerQuestion saveQuestion(AnswerQuestion answerQuestion, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(answerQuestion.getQuestion() == null){
 			return answerQuestion;//do nothing when it is null
 		}
 		
 		getQuestionDAO().save(answerQuestion.getQuestion(),options);
 		return answerQuestion;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected AnswerQuestion saveChangeRequest(AnswerQuestion answerQuestion, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(answerQuestion.getChangeRequest() == null){
 			return answerQuestion;//do nothing when it is null
 		}
 		
 		getChangeRequestDAO().save(answerQuestion.getChangeRequest(),options);
 		return answerQuestion;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public AnswerQuestion present(AnswerQuestion answerQuestion,Map<String, Object> options){
	

		return answerQuestion;
	
	}
		

	

	protected String getTableName(){
		return AnswerQuestionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<AnswerQuestion> answerQuestionList) {		
		this.enhanceListInternal(answerQuestionList, this.getAnswerQuestionMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<AnswerQuestion> answerQuestionList = ownerEntity.collectRefsWithType(AnswerQuestion.INTERNAL_TYPE);
		this.enhanceList(answerQuestionList);
		
	}
	
	@Override
	public SmartList<AnswerQuestion> findAnswerQuestionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAnswerQuestionMapper());

	}
	@Override
	public int countAnswerQuestionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAnswerQuestionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<AnswerQuestion> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAnswerQuestionMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


