
package com.doublechaintech.bcex.changerequest;

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


import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.registration.Registration;

import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.registration.RegistrationDAO;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeDAO;
import com.doublechaintech.bcex.startexam.StartExamDAO;
import com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ChangeRequestJDBCTemplateDAO extends BcexBaseDAOImpl implements ChangeRequestDAO{
 
 	
 	private  ChangeRequestTypeDAO  changeRequestTypeDAO;
 	public void setChangeRequestTypeDAO(ChangeRequestTypeDAO changeRequestTypeDAO){
	 	this.changeRequestTypeDAO = changeRequestTypeDAO;
 	}
 	public ChangeRequestTypeDAO getChangeRequestTypeDAO(){
	 	return this.changeRequestTypeDAO;
 	}
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  RegistrationDAO  registrationDAO;
 	public void setRegistrationDAO(RegistrationDAO pRegistrationDAO){
 	
 		if(pRegistrationDAO == null){
 			throw new IllegalStateException("Do not try to set registrationDAO to null.");
 		}
	 	this.registrationDAO = pRegistrationDAO;
 	}
 	public RegistrationDAO getRegistrationDAO(){
 		if(this.registrationDAO == null){
 			throw new IllegalStateException("The registrationDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.registrationDAO;
 	}	
 	
			
		
	
  	private  StartExamDAO  startExamDAO;
 	public void setStartExamDAO(StartExamDAO pStartExamDAO){
 	
 		if(pStartExamDAO == null){
 			throw new IllegalStateException("Do not try to set startExamDAO to null.");
 		}
	 	this.startExamDAO = pStartExamDAO;
 	}
 	public StartExamDAO getStartExamDAO(){
 		if(this.startExamDAO == null){
 			throw new IllegalStateException("The startExamDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.startExamDAO;
 	}	
 	
			
		
	
  	private  AnswerQuestionDAO  answerQuestionDAO;
 	public void setAnswerQuestionDAO(AnswerQuestionDAO pAnswerQuestionDAO){
 	
 		if(pAnswerQuestionDAO == null){
 			throw new IllegalStateException("Do not try to set answerQuestionDAO to null.");
 		}
	 	this.answerQuestionDAO = pAnswerQuestionDAO;
 	}
 	public AnswerQuestionDAO getAnswerQuestionDAO(){
 		if(this.answerQuestionDAO == null){
 			throw new IllegalStateException("The answerQuestionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.answerQuestionDAO;
 	}	
 	
			
		

	
	/*
	protected ChangeRequest load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequest(accessKey, options);
	}
	*/
	
	public SmartList<ChangeRequest> loadAll() {
	    return this.loadAll(getChangeRequestMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ChangeRequest load(String id,Map<String,Object> options) throws Exception{
		return loadInternalChangeRequest(ChangeRequestTable.withId(id), options);
	}
	
	
	
	public ChangeRequest save(ChangeRequest changeRequest,Map<String,Object> options){
		
		String methodName="save(ChangeRequest changeRequest,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(changeRequest, methodName, "changeRequest");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalChangeRequest(changeRequest,options);
	}
	public ChangeRequest clone(String changeRequestId, Map<String,Object> options) throws Exception{
	
		return clone(ChangeRequestTable.withId(changeRequestId),options);
	}
	
	protected ChangeRequest clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String changeRequestId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ChangeRequest newChangeRequest = loadInternalChangeRequest(accessKey, options);
		newChangeRequest.setVersion(0);
		
		
 		
 		if(isSaveRegistrationListEnabled(options)){
 			for(Registration item: newChangeRequest.getRegistrationList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveStartExamListEnabled(options)){
 			for(StartExam item: newChangeRequest.getStartExamList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAnswerQuestionListEnabled(options)){
 			for(AnswerQuestion item: newChangeRequest.getAnswerQuestionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalChangeRequest(newChangeRequest,options);
		
		return newChangeRequest;
	}
	
	
	
	

	protected void throwIfHasException(String changeRequestId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ChangeRequestVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ChangeRequestNotFoundException(
					"The " + this.getTableName() + "(" + changeRequestId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String changeRequestId, int version) throws Exception{
	
		String methodName="delete(String changeRequestId, int version)";
		assertMethodArgumentNotNull(changeRequestId, methodName, "changeRequestId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{changeRequestId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(changeRequestId,version);
		}
		
	
	}
	
	
	
	
	

	public ChangeRequest disconnectFromAll(String changeRequestId, int version) throws Exception{
	
		
		ChangeRequest changeRequest = loadInternalChangeRequest(ChangeRequestTable.withId(changeRequestId), emptyOptions());
		changeRequest.clearFromAll();
		this.saveChangeRequest(changeRequest);
		return changeRequest;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ChangeRequestTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "change_request";
	}
	@Override
	protected String getBeanName() {
		
		return "changeRequest";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ChangeRequestTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractRequestTypeEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChangeRequestTokens.REQUESTTYPE);
 	}

 	protected boolean isSaveRequestTypeEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChangeRequestTokens.REQUESTTYPE);
 	}
 	

 	
  

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ChangeRequestTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ChangeRequestTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractRegistrationListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChangeRequestTokens.REGISTRATION_LIST);
 	}
 	protected boolean isAnalyzeRegistrationListEnabled(Map<String,Object> options){		 		
 		return ChangeRequestTokens.of(options).analyzeRegistrationListEnabled();
 	}
	
	protected boolean isSaveRegistrationListEnabled(Map<String,Object> options){
		return checkOptions(options, ChangeRequestTokens.REGISTRATION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractStartExamListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChangeRequestTokens.START_EXAM_LIST);
 	}
 	protected boolean isAnalyzeStartExamListEnabled(Map<String,Object> options){		 		
 		return ChangeRequestTokens.of(options).analyzeStartExamListEnabled();
 	}
	
	protected boolean isSaveStartExamListEnabled(Map<String,Object> options){
		return checkOptions(options, ChangeRequestTokens.START_EXAM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractAnswerQuestionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ChangeRequestTokens.ANSWER_QUESTION_LIST);
 	}
 	protected boolean isAnalyzeAnswerQuestionListEnabled(Map<String,Object> options){		 		
 		return ChangeRequestTokens.of(options).analyzeAnswerQuestionListEnabled();
 	}
	
	protected boolean isSaveAnswerQuestionListEnabled(Map<String,Object> options){
		return checkOptions(options, ChangeRequestTokens.ANSWER_QUESTION_LIST);
		
 	}
 	
		

	

	protected ChangeRequestMapper getChangeRequestMapper(){
		return new ChangeRequestMapper();
	}

	
	
	protected ChangeRequest extractChangeRequest(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ChangeRequest changeRequest = loadSingleObject(accessKey, getChangeRequestMapper());
			return changeRequest;
		}catch(EmptyResultDataAccessException e){
			throw new ChangeRequestNotFoundException("ChangeRequest("+accessKey+") is not found!");
		}

	}

	
	

	protected ChangeRequest loadInternalChangeRequest(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ChangeRequest changeRequest = extractChangeRequest(accessKey, loadOptions);
 	
 		if(isExtractRequestTypeEnabled(loadOptions)){
	 		extractRequestType(changeRequest, loadOptions);
 		}
  	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(changeRequest, loadOptions);
 		}
 
		
		if(isExtractRegistrationListEnabled(loadOptions)){
	 		extractRegistrationList(changeRequest, loadOptions);
 		}	
 		if(isAnalyzeRegistrationListEnabled(loadOptions)){
	 		analyzeRegistrationList(changeRequest, loadOptions);
 		}
 		
		
		if(isExtractStartExamListEnabled(loadOptions)){
	 		extractStartExamList(changeRequest, loadOptions);
 		}	
 		if(isAnalyzeStartExamListEnabled(loadOptions)){
	 		analyzeStartExamList(changeRequest, loadOptions);
 		}
 		
		
		if(isExtractAnswerQuestionListEnabled(loadOptions)){
	 		extractAnswerQuestionList(changeRequest, loadOptions);
 		}	
 		if(isAnalyzeAnswerQuestionListEnabled(loadOptions)){
	 		analyzeAnswerQuestionList(changeRequest, loadOptions);
 		}
 		
		
		return changeRequest;
		
	}

	 

 	protected ChangeRequest extractRequestType(ChangeRequest changeRequest, Map<String,Object> options) throws Exception{

		if(changeRequest.getRequestType() == null){
			return changeRequest;
		}
		String requestTypeId = changeRequest.getRequestType().getId();
		if( requestTypeId == null){
			return changeRequest;
		}
		ChangeRequestType requestType = getChangeRequestTypeDAO().load(requestTypeId,options);
		if(requestType != null){
			changeRequest.setRequestType(requestType);
		}
		
 		
 		return changeRequest;
 	}
 		
  

 	protected ChangeRequest extractPlatform(ChangeRequest changeRequest, Map<String,Object> options) throws Exception{

		if(changeRequest.getPlatform() == null){
			return changeRequest;
		}
		String platformId = changeRequest.getPlatform().getId();
		if( platformId == null){
			return changeRequest;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			changeRequest.setPlatform(platform);
		}
		
 		
 		return changeRequest;
 	}
 		
 
		
	protected void enhanceRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChangeRequest extractRegistrationList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<Registration> registrationList = getRegistrationDAO().findRegistrationByChangeRequest(changeRequest.getId(),options);
		if(registrationList != null){
			enhanceRegistrationList(registrationList,options);
			changeRequest.setRegistrationList(registrationList);
		}
		
		return changeRequest;
	
	}	
	
	protected ChangeRequest analyzeRegistrationList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<Registration> registrationList = changeRequest.getRegistrationList();
		if(registrationList != null){
			getRegistrationDAO().analyzeRegistrationByChangeRequest(registrationList, changeRequest.getId(), options);
			
		}
		
		return changeRequest;
	
	}	
	
		
	protected void enhanceStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChangeRequest extractStartExamList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<StartExam> startExamList = getStartExamDAO().findStartExamByChangeRequest(changeRequest.getId(),options);
		if(startExamList != null){
			enhanceStartExamList(startExamList,options);
			changeRequest.setStartExamList(startExamList);
		}
		
		return changeRequest;
	
	}	
	
	protected ChangeRequest analyzeStartExamList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<StartExam> startExamList = changeRequest.getStartExamList();
		if(startExamList != null){
			getStartExamDAO().analyzeStartExamByChangeRequest(startExamList, changeRequest.getId(), options);
			
		}
		
		return changeRequest;
	
	}	
	
		
	protected void enhanceAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ChangeRequest extractAnswerQuestionList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = getAnswerQuestionDAO().findAnswerQuestionByChangeRequest(changeRequest.getId(),options);
		if(answerQuestionList != null){
			enhanceAnswerQuestionList(answerQuestionList,options);
			changeRequest.setAnswerQuestionList(answerQuestionList);
		}
		
		return changeRequest;
	
	}	
	
	protected ChangeRequest analyzeAnswerQuestionList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		if(changeRequest == null){
			return null;
		}
		if(changeRequest.getId() == null){
			return changeRequest;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();
		if(answerQuestionList != null){
			getAnswerQuestionDAO().analyzeAnswerQuestionByChangeRequest(answerQuestionList, changeRequest.getId(), options);
			
		}
		
		return changeRequest;
	
	}	
	
		
		
  	
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId,Map<String,Object> options){
 	
  		SmartList<ChangeRequest> resultList = queryWith(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options, getChangeRequestMapper());
		// analyzeChangeRequestByRequestType(resultList, changeRequestTypeId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChangeRequest> resultList =  queryWithRange(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options, getChangeRequestMapper(), start, count);
 		//analyzeChangeRequestByRequestType(resultList, changeRequestTypeId, options);
 		return resultList;
 		
 	}
 	public void analyzeChangeRequestByRequestType(SmartList<ChangeRequest> resultList, String changeRequestTypeId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChangeRequest.REQUEST_TYPE_PROPERTY, changeRequestTypeId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ChangeRequest.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("变更请求");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ChangeRequest.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ChangeRequest.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChangeRequestByRequestType(String changeRequestTypeId,Map<String,Object> options){

 		return countWith(ChangeRequestTable.COLUMN_REQUEST_TYPE, changeRequestTypeId, options);
 	}
 	@Override
	public Map<String, Integer> countChangeRequestByRequestTypeIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChangeRequestTable.COLUMN_REQUEST_TYPE, ids, options);
	}
 	
  	
 	public SmartList<ChangeRequest> findChangeRequestByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<ChangeRequest> resultList = queryWith(ChangeRequestTable.COLUMN_PLATFORM, platformId, options, getChangeRequestMapper());
		// analyzeChangeRequestByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ChangeRequest> findChangeRequestByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ChangeRequest> resultList =  queryWithRange(ChangeRequestTable.COLUMN_PLATFORM, platformId, options, getChangeRequestMapper(), start, count);
 		//analyzeChangeRequestByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeChangeRequestByPlatform(SmartList<ChangeRequest> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(ChangeRequest.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//ChangeRequest.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("变更请求");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(ChangeRequest.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(ChangeRequest.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countChangeRequestByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ChangeRequestTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countChangeRequestByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ChangeRequestTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected ChangeRequest saveChangeRequest(ChangeRequest  changeRequest){
		
		if(!changeRequest.isChanged()){
			return changeRequest;
		}
		
		
		String SQL=this.getSaveChangeRequestSQL(changeRequest);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveChangeRequestParameters(changeRequest);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		changeRequest.incVersion();
		return changeRequest;
	
	}
	public SmartList<ChangeRequest> saveChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitChangeRequestList(changeRequestList);
		
		batchChangeRequestCreate((List<ChangeRequest>)lists[CREATE_LIST_INDEX]);
		
		batchChangeRequestUpdate((List<ChangeRequest>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ChangeRequest changeRequest:changeRequestList){
			if(changeRequest.isChanged()){
				changeRequest.incVersion();
			}
			
		
		}
		
		
		return changeRequestList;
	}

	public SmartList<ChangeRequest> removeChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		
		
		super.removeList(changeRequestList, options);
		
		return changeRequestList;
		
		
	}
	
	protected List<Object[]> prepareChangeRequestBatchCreateArgs(List<ChangeRequest> changeRequestList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequest changeRequest:changeRequestList ){
			Object [] parameters = prepareChangeRequestCreateParameters(changeRequest);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareChangeRequestBatchUpdateArgs(List<ChangeRequest> changeRequestList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ChangeRequest changeRequest:changeRequestList ){
			if(!changeRequest.isChanged()){
				continue;
			}
			Object [] parameters = prepareChangeRequestUpdateParameters(changeRequest);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchChangeRequestCreate(List<ChangeRequest> changeRequestList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareChangeRequestBatchCreateArgs(changeRequestList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchChangeRequestUpdate(List<ChangeRequest> changeRequestList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareChangeRequestBatchUpdateArgs(changeRequestList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitChangeRequestList(List<ChangeRequest> changeRequestList){
		
		List<ChangeRequest> changeRequestCreateList=new ArrayList<ChangeRequest>();
		List<ChangeRequest> changeRequestUpdateList=new ArrayList<ChangeRequest>();
		
		for(ChangeRequest changeRequest: changeRequestList){
			if(isUpdateRequest(changeRequest)){
				changeRequestUpdateList.add( changeRequest);
				continue;
			}
			changeRequestCreateList.add(changeRequest);
		}
		
		return new Object[]{changeRequestCreateList,changeRequestUpdateList};
	}
	
	protected boolean isUpdateRequest(ChangeRequest changeRequest){
 		return changeRequest.getVersion() > 0;
 	}
 	protected String getSaveChangeRequestSQL(ChangeRequest changeRequest){
 		if(isUpdateRequest(changeRequest)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveChangeRequestParameters(ChangeRequest changeRequest){
 		if(isUpdateRequest(changeRequest) ){
 			return prepareChangeRequestUpdateParameters(changeRequest);
 		}
 		return prepareChangeRequestCreateParameters(changeRequest);
 	}
 	protected Object[] prepareChangeRequestUpdateParameters(ChangeRequest changeRequest){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = changeRequest.getName();
 		parameters[1] = changeRequest.getCreateTime();
 		parameters[2] = changeRequest.getRemoteIp(); 	
 		if(changeRequest.getRequestType() != null){
 			parameters[3] = changeRequest.getRequestType().getId();
 		}
  	
 		if(changeRequest.getPlatform() != null){
 			parameters[4] = changeRequest.getPlatform().getId();
 		}
 		
 		parameters[5] = changeRequest.nextVersion();
 		parameters[6] = changeRequest.getId();
 		parameters[7] = changeRequest.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareChangeRequestCreateParameters(ChangeRequest changeRequest){
		Object[] parameters = new Object[6];
		String newChangeRequestId=getNextId();
		changeRequest.setId(newChangeRequestId);
		parameters[0] =  changeRequest.getId();
 
 		parameters[1] = changeRequest.getName();
 		parameters[2] = changeRequest.getCreateTime();
 		parameters[3] = changeRequest.getRemoteIp(); 	
 		if(changeRequest.getRequestType() != null){
 			parameters[4] = changeRequest.getRequestType().getId();
 		
 		}
 		 	
 		if(changeRequest.getPlatform() != null){
 			parameters[5] = changeRequest.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ChangeRequest saveInternalChangeRequest(ChangeRequest changeRequest, Map<String,Object> options){
		
		saveChangeRequest(changeRequest);
 	
 		if(isSaveRequestTypeEnabled(options)){
	 		saveRequestType(changeRequest, options);
 		}
  	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(changeRequest, options);
 		}
 
		
		if(isSaveRegistrationListEnabled(options)){
	 		saveRegistrationList(changeRequest, options);
	 		//removeRegistrationList(changeRequest, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveStartExamListEnabled(options)){
	 		saveStartExamList(changeRequest, options);
	 		//removeStartExamList(changeRequest, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveAnswerQuestionListEnabled(options)){
	 		saveAnswerQuestionList(changeRequest, options);
	 		//removeAnswerQuestionList(changeRequest, options);
	 		//Not delete the record
	 		
 		}		
		
		return changeRequest;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ChangeRequest saveRequestType(ChangeRequest changeRequest, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(changeRequest.getRequestType() == null){
 			return changeRequest;//do nothing when it is null
 		}
 		
 		getChangeRequestTypeDAO().save(changeRequest.getRequestType(),options);
 		return changeRequest;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected ChangeRequest savePlatform(ChangeRequest changeRequest, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(changeRequest.getPlatform() == null){
 			return changeRequest;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(changeRequest.getPlatform(),options);
 		return changeRequest;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ChangeRequest planToRemoveRegistrationList(ChangeRequest changeRequest, String registrationIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(Registration.ID_PROPERTY, registrationIds);
		
		SmartList<Registration> externalRegistrationList = getRegistrationDAO().
				findRegistrationWithKey(key, options);
		if(externalRegistrationList == null){
			return changeRequest;
		}
		if(externalRegistrationList.isEmpty()){
			return changeRequest;
		}
		
		for(Registration registrationItem: externalRegistrationList){

			registrationItem.clearFromAll();
		}
		
		
		SmartList<Registration> registrationList = changeRequest.getRegistrationList();		
		registrationList.addAllToRemoveList(externalRegistrationList);
		return changeRequest;	
	
	}


	public ChangeRequest planToRemoveStartExamList(ChangeRequest changeRequest, String startExamIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(StartExam.ID_PROPERTY, startExamIds);
		
		SmartList<StartExam> externalStartExamList = getStartExamDAO().
				findStartExamWithKey(key, options);
		if(externalStartExamList == null){
			return changeRequest;
		}
		if(externalStartExamList.isEmpty()){
			return changeRequest;
		}
		
		for(StartExam startExamItem: externalStartExamList){

			startExamItem.clearFromAll();
		}
		
		
		SmartList<StartExam> startExamList = changeRequest.getStartExamList();		
		startExamList.addAllToRemoveList(externalStartExamList);
		return changeRequest;	
	
	}


	//disconnect ChangeRequest with user in StartExam
	public ChangeRequest planToRemoveStartExamListWithUser(ChangeRequest changeRequest, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(StartExam.USER_PROPERTY, userId);
		
		SmartList<StartExam> externalStartExamList = getStartExamDAO().
				findStartExamWithKey(key, options);
		if(externalStartExamList == null){
			return changeRequest;
		}
		if(externalStartExamList.isEmpty()){
			return changeRequest;
		}
		
		for(StartExam startExamItem: externalStartExamList){
			startExamItem.clearUser();
			startExamItem.clearChangeRequest();
			
		}
		
		
		SmartList<StartExam> startExamList = changeRequest.getStartExamList();		
		startExamList.addAllToRemoveList(externalStartExamList);
		return changeRequest;
	}
	
	public int countStartExamListWithUser(String changeRequestId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequestId);
		key.put(StartExam.USER_PROPERTY, userId);
		
		int count = getStartExamDAO().countStartExamWithKey(key, options);
		return count;
	}
	
	public ChangeRequest planToRemoveAnswerQuestionList(ChangeRequest changeRequest, String answerQuestionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(AnswerQuestion.ID_PROPERTY, answerQuestionIds);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return changeRequest;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return changeRequest;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){

			answerQuestionItem.clearFromAll();
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return changeRequest;	
	
	}


	//disconnect ChangeRequest with user in AnswerQuestion
	public ChangeRequest planToRemoveAnswerQuestionListWithUser(ChangeRequest changeRequest, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(AnswerQuestion.USER_PROPERTY, userId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return changeRequest;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return changeRequest;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearUser();
			answerQuestionItem.clearChangeRequest();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return changeRequest;
	}
	
	public int countAnswerQuestionListWithUser(String changeRequestId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		key.put(AnswerQuestion.USER_PROPERTY, userId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	
	//disconnect ChangeRequest with user_answer in AnswerQuestion
	public ChangeRequest planToRemoveAnswerQuestionListWithUserAnswer(ChangeRequest changeRequest, String userAnswerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequest.getId());
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return changeRequest;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return changeRequest;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearUserAnswer();
			answerQuestionItem.clearChangeRequest();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return changeRequest;
	}
	
	public int countAnswerQuestionListWithUserAnswer(String changeRequestId, String userAnswerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	

		
	protected ChangeRequest saveRegistrationList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		
		
		SmartList<Registration> registrationList = changeRequest.getRegistrationList();
		if(registrationList == null){
			//null list means nothing
			return changeRequest;
		}
		SmartList<Registration> mergedUpdateRegistrationList = new SmartList<Registration>();
		
		
		mergedUpdateRegistrationList.addAll(registrationList); 
		if(registrationList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRegistrationList.addAll(registrationList.getToRemoveList());
			registrationList.removeAll(registrationList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRegistrationDAO().saveRegistrationList(mergedUpdateRegistrationList,options);
		
		if(registrationList.getToRemoveList() != null){
			registrationList.removeAll(registrationList.getToRemoveList());
		}
		
		
		return changeRequest;
	
	}
	
	protected ChangeRequest removeRegistrationList(ChangeRequest changeRequest, Map<String,Object> options){
	
	
		SmartList<Registration> registrationList = changeRequest.getRegistrationList();
		if(registrationList == null){
			return changeRequest;
		}	
	
		SmartList<Registration> toRemoveRegistrationList = registrationList.getToRemoveList();
		
		if(toRemoveRegistrationList == null){
			return changeRequest;
		}
		if(toRemoveRegistrationList.isEmpty()){
			return changeRequest;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRegistrationDAO().removeRegistrationList(toRemoveRegistrationList,options);
		
		return changeRequest;
	
	}
	
	

 	
 	
	
	
	
		
	protected ChangeRequest saveStartExamList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		
		
		SmartList<StartExam> startExamList = changeRequest.getStartExamList();
		if(startExamList == null){
			//null list means nothing
			return changeRequest;
		}
		SmartList<StartExam> mergedUpdateStartExamList = new SmartList<StartExam>();
		
		
		mergedUpdateStartExamList.addAll(startExamList); 
		if(startExamList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateStartExamList.addAll(startExamList.getToRemoveList());
			startExamList.removeAll(startExamList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getStartExamDAO().saveStartExamList(mergedUpdateStartExamList,options);
		
		if(startExamList.getToRemoveList() != null){
			startExamList.removeAll(startExamList.getToRemoveList());
		}
		
		
		return changeRequest;
	
	}
	
	protected ChangeRequest removeStartExamList(ChangeRequest changeRequest, Map<String,Object> options){
	
	
		SmartList<StartExam> startExamList = changeRequest.getStartExamList();
		if(startExamList == null){
			return changeRequest;
		}	
	
		SmartList<StartExam> toRemoveStartExamList = startExamList.getToRemoveList();
		
		if(toRemoveStartExamList == null){
			return changeRequest;
		}
		if(toRemoveStartExamList.isEmpty()){
			return changeRequest;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getStartExamDAO().removeStartExamList(toRemoveStartExamList,options);
		
		return changeRequest;
	
	}
	
	

 	
 	
	
	
	
		
	protected ChangeRequest saveAnswerQuestionList(ChangeRequest changeRequest, Map<String,Object> options){
		
		
		
		
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();
		if(answerQuestionList == null){
			//null list means nothing
			return changeRequest;
		}
		SmartList<AnswerQuestion> mergedUpdateAnswerQuestionList = new SmartList<AnswerQuestion>();
		
		
		mergedUpdateAnswerQuestionList.addAll(answerQuestionList); 
		if(answerQuestionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAnswerQuestionList.addAll(answerQuestionList.getToRemoveList());
			answerQuestionList.removeAll(answerQuestionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getAnswerQuestionDAO().saveAnswerQuestionList(mergedUpdateAnswerQuestionList,options);
		
		if(answerQuestionList.getToRemoveList() != null){
			answerQuestionList.removeAll(answerQuestionList.getToRemoveList());
		}
		
		
		return changeRequest;
	
	}
	
	protected ChangeRequest removeAnswerQuestionList(ChangeRequest changeRequest, Map<String,Object> options){
	
	
		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();
		if(answerQuestionList == null){
			return changeRequest;
		}	
	
		SmartList<AnswerQuestion> toRemoveAnswerQuestionList = answerQuestionList.getToRemoveList();
		
		if(toRemoveAnswerQuestionList == null){
			return changeRequest;
		}
		if(toRemoveAnswerQuestionList.isEmpty()){
			return changeRequest;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAnswerQuestionDAO().removeAnswerQuestionList(toRemoveAnswerQuestionList,options);
		
		return changeRequest;
	
	}
	
	

 	
 	
	
	
	
		

	public ChangeRequest present(ChangeRequest changeRequest,Map<String, Object> options){
	
		presentRegistrationList(changeRequest,options);
		presentStartExamList(changeRequest,options);
		presentAnswerQuestionList(changeRequest,options);

		return changeRequest;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ChangeRequest presentRegistrationList(
			ChangeRequest changeRequest,
			Map<String, Object> options) {

		SmartList<Registration> registrationList = changeRequest.getRegistrationList();		
				SmartList<Registration> newList= presentSubList(changeRequest.getId(),
				registrationList,
				options,
				getRegistrationDAO()::countRegistrationByChangeRequest,
				getRegistrationDAO()::findRegistrationByChangeRequest
				);

		
		changeRequest.setRegistrationList(newList);
		

		return changeRequest;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ChangeRequest presentStartExamList(
			ChangeRequest changeRequest,
			Map<String, Object> options) {

		SmartList<StartExam> startExamList = changeRequest.getStartExamList();		
				SmartList<StartExam> newList= presentSubList(changeRequest.getId(),
				startExamList,
				options,
				getStartExamDAO()::countStartExamByChangeRequest,
				getStartExamDAO()::findStartExamByChangeRequest
				);

		
		changeRequest.setStartExamList(newList);
		

		return changeRequest;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected ChangeRequest presentAnswerQuestionList(
			ChangeRequest changeRequest,
			Map<String, Object> options) {

		SmartList<AnswerQuestion> answerQuestionList = changeRequest.getAnswerQuestionList();		
				SmartList<AnswerQuestion> newList= presentSubList(changeRequest.getId(),
				answerQuestionList,
				options,
				getAnswerQuestionDAO()::countAnswerQuestionByChangeRequest,
				getAnswerQuestionDAO()::findAnswerQuestionByChangeRequest
				);

		
		changeRequest.setAnswerQuestionList(newList);
		

		return changeRequest;
	}			
		

	
    public SmartList<ChangeRequest> requestCandidateChangeRequestForRegistration(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChangeRequestTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChangeRequestMapper());
    }
		
    public SmartList<ChangeRequest> requestCandidateChangeRequestForStartExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChangeRequestTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChangeRequestMapper());
    }
		
    public SmartList<ChangeRequest> requestCandidateChangeRequestForAnswerQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ChangeRequestTable.COLUMN_NAME, filterKey, pageNo, pageSize, getChangeRequestMapper());
    }
		

	protected String getTableName(){
		return ChangeRequestTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ChangeRequest> changeRequestList) {		
		this.enhanceListInternal(changeRequestList, this.getChangeRequestMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Registration的changeRequest的RegistrationList
	public SmartList<Registration> loadOurRegistrationList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Registration.CHANGE_REQUEST_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Registration> loadedObjs = userContext.getDAOGroup().getRegistrationDAO().findRegistrationWithKey(key, options);
		Map<String, List<Registration>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChangeRequest().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Registration> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Registration> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRegistrationList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:StartExam的changeRequest的StartExamList
	public SmartList<StartExam> loadOurStartExamList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<StartExam> loadedObjs = userContext.getDAOGroup().getStartExamDAO().findStartExamWithKey(key, options);
		Map<String, List<StartExam>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChangeRequest().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<StartExam> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<StartExam> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setStartExamList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:AnswerQuestion的changeRequest的AnswerQuestionList
	public SmartList<AnswerQuestion> loadOurAnswerQuestionList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AnswerQuestion> loadedObjs = userContext.getDAOGroup().getAnswerQuestionDAO().findAnswerQuestionWithKey(key, options);
		Map<String, List<AnswerQuestion>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getChangeRequest().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<AnswerQuestion> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<AnswerQuestion> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAnswerQuestionList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ChangeRequest> changeRequestList = ownerEntity.collectRefsWithType(ChangeRequest.INTERNAL_TYPE);
		this.enhanceList(changeRequestList);
		
	}
	
	@Override
	public SmartList<ChangeRequest> findChangeRequestWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getChangeRequestMapper());

	}
	@Override
	public int countChangeRequestWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countChangeRequestWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ChangeRequest> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getChangeRequestMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


