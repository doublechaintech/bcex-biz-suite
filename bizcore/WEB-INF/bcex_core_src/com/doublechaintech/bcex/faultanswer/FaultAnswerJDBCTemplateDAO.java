
package com.doublechaintech.bcex.faultanswer;

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


import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.question.QuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class FaultAnswerJDBCTemplateDAO extends BcexBaseDAOImpl implements FaultAnswerDAO{
 
 	
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
	protected FaultAnswer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFaultAnswer(accessKey, options);
	}
	*/
	
	public SmartList<FaultAnswer> loadAll() {
	    return this.loadAll(getFaultAnswerMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FaultAnswer load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFaultAnswer(FaultAnswerTable.withId(id), options);
	}
	
	
	
	public FaultAnswer save(FaultAnswer faultAnswer,Map<String,Object> options){
		
		String methodName="save(FaultAnswer faultAnswer,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(faultAnswer, methodName, "faultAnswer");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFaultAnswer(faultAnswer,options);
	}
	public FaultAnswer clone(String faultAnswerId, Map<String,Object> options) throws Exception{
	
		return clone(FaultAnswerTable.withId(faultAnswerId),options);
	}
	
	protected FaultAnswer clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String faultAnswerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FaultAnswer newFaultAnswer = loadInternalFaultAnswer(accessKey, options);
		newFaultAnswer.setVersion(0);
		
		

		
		saveInternalFaultAnswer(newFaultAnswer,options);
		
		return newFaultAnswer;
	}
	
	
	
	

	protected void throwIfHasException(String faultAnswerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FaultAnswerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FaultAnswerNotFoundException(
					"The " + this.getTableName() + "(" + faultAnswerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String faultAnswerId, int version) throws Exception{
	
		String methodName="delete(String faultAnswerId, int version)";
		assertMethodArgumentNotNull(faultAnswerId, methodName, "faultAnswerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{faultAnswerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(faultAnswerId,version);
		}
		
	
	}
	
	
	
	
	

	public FaultAnswer disconnectFromAll(String faultAnswerId, int version) throws Exception{
	
		
		FaultAnswer faultAnswer = loadInternalFaultAnswer(FaultAnswerTable.withId(faultAnswerId), emptyOptions());
		faultAnswer.clearFromAll();
		this.saveFaultAnswer(faultAnswer);
		return faultAnswer;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FaultAnswerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "fault_answer";
	}
	@Override
	protected String getBeanName() {
		
		return "faultAnswer";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FaultAnswerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FaultAnswerTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FaultAnswerTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractQuestionEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FaultAnswerTokens.QUESTION);
 	}

 	protected boolean isSaveQuestionEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FaultAnswerTokens.QUESTION);
 	}
 	

 	
 
		

	

	protected FaultAnswerMapper getFaultAnswerMapper(){
		return new FaultAnswerMapper();
	}

	
	
	protected FaultAnswer extractFaultAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FaultAnswer faultAnswer = loadSingleObject(accessKey, getFaultAnswerMapper());
			return faultAnswer;
		}catch(EmptyResultDataAccessException e){
			throw new FaultAnswerNotFoundException("FaultAnswer("+accessKey+") is not found!");
		}

	}

	
	

	protected FaultAnswer loadInternalFaultAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FaultAnswer faultAnswer = extractFaultAnswer(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(faultAnswer, loadOptions);
 		}
  	
 		if(isExtractQuestionEnabled(loadOptions)){
	 		extractQuestion(faultAnswer, loadOptions);
 		}
 
		
		return faultAnswer;
		
	}

	 

 	protected FaultAnswer extractUser(FaultAnswer faultAnswer, Map<String,Object> options) throws Exception{

		if(faultAnswer.getUser() == null){
			return faultAnswer;
		}
		String userId = faultAnswer.getUser().getId();
		if( userId == null){
			return faultAnswer;
		}
		WechatUser user = getWechatUserDAO().load(userId,options);
		if(user != null){
			faultAnswer.setUser(user);
		}
		
 		
 		return faultAnswer;
 	}
 		
  

 	protected FaultAnswer extractQuestion(FaultAnswer faultAnswer, Map<String,Object> options) throws Exception{

		if(faultAnswer.getQuestion() == null){
			return faultAnswer;
		}
		String questionId = faultAnswer.getQuestion().getId();
		if( questionId == null){
			return faultAnswer;
		}
		Question question = getQuestionDAO().load(questionId,options);
		if(question != null){
			faultAnswer.setQuestion(question);
		}
		
 		
 		return faultAnswer;
 	}
 		
 
		
		
  	
 	public SmartList<FaultAnswer> findFaultAnswerByUser(String wechatUserId,Map<String,Object> options){
 	
  		SmartList<FaultAnswer> resultList = queryWith(FaultAnswerTable.COLUMN_USER, wechatUserId, options, getFaultAnswerMapper());
		// analyzeFaultAnswerByUser(resultList, wechatUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FaultAnswer> findFaultAnswerByUser(String wechatUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FaultAnswer> resultList =  queryWithRange(FaultAnswerTable.COLUMN_USER, wechatUserId, options, getFaultAnswerMapper(), start, count);
 		//analyzeFaultAnswerByUser(resultList, wechatUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeFaultAnswerByUser(SmartList<FaultAnswer> resultList, String wechatUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(FaultAnswer.USER_PROPERTY, wechatUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//FaultAnswer.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("错误的答案");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(FaultAnswer.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(FaultAnswer.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countFaultAnswerByUser(String wechatUserId,Map<String,Object> options){

 		return countWith(FaultAnswerTable.COLUMN_USER, wechatUserId, options);
 	}
 	@Override
	public Map<String, Integer> countFaultAnswerByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FaultAnswerTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<FaultAnswer> findFaultAnswerByQuestion(String questionId,Map<String,Object> options){
 	
  		SmartList<FaultAnswer> resultList = queryWith(FaultAnswerTable.COLUMN_QUESTION, questionId, options, getFaultAnswerMapper());
		// analyzeFaultAnswerByQuestion(resultList, questionId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FaultAnswer> findFaultAnswerByQuestion(String questionId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FaultAnswer> resultList =  queryWithRange(FaultAnswerTable.COLUMN_QUESTION, questionId, options, getFaultAnswerMapper(), start, count);
 		//analyzeFaultAnswerByQuestion(resultList, questionId, options);
 		return resultList;
 		
 	}
 	public void analyzeFaultAnswerByQuestion(SmartList<FaultAnswer> resultList, String questionId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(FaultAnswer.QUESTION_PROPERTY, questionId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//FaultAnswer.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("错误的答案");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(FaultAnswer.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(FaultAnswer.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countFaultAnswerByQuestion(String questionId,Map<String,Object> options){

 		return countWith(FaultAnswerTable.COLUMN_QUESTION, questionId, options);
 	}
 	@Override
	public Map<String, Integer> countFaultAnswerByQuestionIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FaultAnswerTable.COLUMN_QUESTION, ids, options);
	}
 	
 	
		
		
		

	

	protected FaultAnswer saveFaultAnswer(FaultAnswer  faultAnswer){
		
		if(!faultAnswer.isChanged()){
			return faultAnswer;
		}
		
		
		String SQL=this.getSaveFaultAnswerSQL(faultAnswer);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFaultAnswerParameters(faultAnswer);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		faultAnswer.incVersion();
		return faultAnswer;
	
	}
	public SmartList<FaultAnswer> saveFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFaultAnswerList(faultAnswerList);
		
		batchFaultAnswerCreate((List<FaultAnswer>)lists[CREATE_LIST_INDEX]);
		
		batchFaultAnswerUpdate((List<FaultAnswer>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FaultAnswer faultAnswer:faultAnswerList){
			if(faultAnswer.isChanged()){
				faultAnswer.incVersion();
			}
			
		
		}
		
		
		return faultAnswerList;
	}

	public SmartList<FaultAnswer> removeFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options){
		
		
		super.removeList(faultAnswerList, options);
		
		return faultAnswerList;
		
		
	}
	
	protected List<Object[]> prepareFaultAnswerBatchCreateArgs(List<FaultAnswer> faultAnswerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FaultAnswer faultAnswer:faultAnswerList ){
			Object [] parameters = prepareFaultAnswerCreateParameters(faultAnswer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFaultAnswerBatchUpdateArgs(List<FaultAnswer> faultAnswerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FaultAnswer faultAnswer:faultAnswerList ){
			if(!faultAnswer.isChanged()){
				continue;
			}
			Object [] parameters = prepareFaultAnswerUpdateParameters(faultAnswer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFaultAnswerCreate(List<FaultAnswer> faultAnswerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFaultAnswerBatchCreateArgs(faultAnswerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFaultAnswerUpdate(List<FaultAnswer> faultAnswerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFaultAnswerBatchUpdateArgs(faultAnswerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFaultAnswerList(List<FaultAnswer> faultAnswerList){
		
		List<FaultAnswer> faultAnswerCreateList=new ArrayList<FaultAnswer>();
		List<FaultAnswer> faultAnswerUpdateList=new ArrayList<FaultAnswer>();
		
		for(FaultAnswer faultAnswer: faultAnswerList){
			if(isUpdateRequest(faultAnswer)){
				faultAnswerUpdateList.add( faultAnswer);
				continue;
			}
			faultAnswerCreateList.add(faultAnswer);
		}
		
		return new Object[]{faultAnswerCreateList,faultAnswerUpdateList};
	}
	
	protected boolean isUpdateRequest(FaultAnswer faultAnswer){
 		return faultAnswer.getVersion() > 0;
 	}
 	protected String getSaveFaultAnswerSQL(FaultAnswer faultAnswer){
 		if(isUpdateRequest(faultAnswer)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFaultAnswerParameters(FaultAnswer faultAnswer){
 		if(isUpdateRequest(faultAnswer) ){
 			return prepareFaultAnswerUpdateParameters(faultAnswer);
 		}
 		return prepareFaultAnswerCreateParameters(faultAnswer);
 	}
 	protected Object[] prepareFaultAnswerUpdateParameters(FaultAnswer faultAnswer){
 		Object[] parameters = new Object[10];
 
 		parameters[0] = faultAnswer.getTopic();
 		parameters[1] = faultAnswer.getYourAnswer();
 		parameters[2] = faultAnswer.getRightAnswer();
 		parameters[3] = faultAnswer.getCreateTime(); 	
 		if(faultAnswer.getUser() != null){
 			parameters[4] = faultAnswer.getUser().getId();
 		}
  	
 		if(faultAnswer.getQuestion() != null){
 			parameters[5] = faultAnswer.getQuestion().getId();
 		}
 
 		parameters[6] = faultAnswer.getFaultTimes();		
 		parameters[7] = faultAnswer.nextVersion();
 		parameters[8] = faultAnswer.getId();
 		parameters[9] = faultAnswer.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFaultAnswerCreateParameters(FaultAnswer faultAnswer){
		Object[] parameters = new Object[8];
		String newFaultAnswerId=getNextId();
		faultAnswer.setId(newFaultAnswerId);
		parameters[0] =  faultAnswer.getId();
 
 		parameters[1] = faultAnswer.getTopic();
 		parameters[2] = faultAnswer.getYourAnswer();
 		parameters[3] = faultAnswer.getRightAnswer();
 		parameters[4] = faultAnswer.getCreateTime(); 	
 		if(faultAnswer.getUser() != null){
 			parameters[5] = faultAnswer.getUser().getId();
 		
 		}
 		 	
 		if(faultAnswer.getQuestion() != null){
 			parameters[6] = faultAnswer.getQuestion().getId();
 		
 		}
 		
 		parameters[7] = faultAnswer.getFaultTimes();		
 				
 		return parameters;
 	}
 	
	protected FaultAnswer saveInternalFaultAnswer(FaultAnswer faultAnswer, Map<String,Object> options){
		
		saveFaultAnswer(faultAnswer);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(faultAnswer, options);
 		}
  	
 		if(isSaveQuestionEnabled(options)){
	 		saveQuestion(faultAnswer, options);
 		}
 
		
		return faultAnswer;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FaultAnswer saveUser(FaultAnswer faultAnswer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(faultAnswer.getUser() == null){
 			return faultAnswer;//do nothing when it is null
 		}
 		
 		getWechatUserDAO().save(faultAnswer.getUser(),options);
 		return faultAnswer;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected FaultAnswer saveQuestion(FaultAnswer faultAnswer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(faultAnswer.getQuestion() == null){
 			return faultAnswer;//do nothing when it is null
 		}
 		
 		getQuestionDAO().save(faultAnswer.getQuestion(),options);
 		return faultAnswer;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public FaultAnswer present(FaultAnswer faultAnswer,Map<String, Object> options){
	

		return faultAnswer;
	
	}
		

	

	protected String getTableName(){
		return FaultAnswerTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FaultAnswer> faultAnswerList) {		
		this.enhanceListInternal(faultAnswerList, this.getFaultAnswerMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FaultAnswer> faultAnswerList = ownerEntity.collectRefsWithType(FaultAnswer.INTERNAL_TYPE);
		this.enhanceList(faultAnswerList);
		
	}
	
	@Override
	public SmartList<FaultAnswer> findFaultAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFaultAnswerMapper());

	}
	@Override
	public int countFaultAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFaultAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FaultAnswer> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFaultAnswerMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


