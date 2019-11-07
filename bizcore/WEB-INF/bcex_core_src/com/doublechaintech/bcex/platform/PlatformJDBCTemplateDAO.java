
package com.doublechaintech.bcex.platform;

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


import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.examstatus.ExamStatusDAO;
import com.doublechaintech.bcex.question.QuestionDAO;
import com.doublechaintech.bcex.examranking.ExamRankingDAO;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PlatformJDBCTemplateDAO extends BcexBaseDAOImpl implements PlatformDAO{


			
		
	
  	private  ChangeRequestTypeDAO  changeRequestTypeDAO;
 	public void setChangeRequestTypeDAO(ChangeRequestTypeDAO pChangeRequestTypeDAO){
 	
 		if(pChangeRequestTypeDAO == null){
 			throw new IllegalStateException("Do not try to set changeRequestTypeDAO to null.");
 		}
	 	this.changeRequestTypeDAO = pChangeRequestTypeDAO;
 	}
 	public ChangeRequestTypeDAO getChangeRequestTypeDAO(){
 		if(this.changeRequestTypeDAO == null){
 			throw new IllegalStateException("The changeRequestTypeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.changeRequestTypeDAO;
 	}	
 	
			
		
	
  	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO pChangeRequestDAO){
 	
 		if(pChangeRequestDAO == null){
 			throw new IllegalStateException("Do not try to set changeRequestDAO to null.");
 		}
	 	this.changeRequestDAO = pChangeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
 		if(this.changeRequestDAO == null){
 			throw new IllegalStateException("The changeRequestDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.changeRequestDAO;
 	}	
 	
			
		
	
  	private  ExamStatusDAO  examStatusDAO;
 	public void setExamStatusDAO(ExamStatusDAO pExamStatusDAO){
 	
 		if(pExamStatusDAO == null){
 			throw new IllegalStateException("Do not try to set examStatusDAO to null.");
 		}
	 	this.examStatusDAO = pExamStatusDAO;
 	}
 	public ExamStatusDAO getExamStatusDAO(){
 		if(this.examStatusDAO == null){
 			throw new IllegalStateException("The examStatusDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.examStatusDAO;
 	}	
 	
			
		
	
  	private  QuestionDAO  questionDAO;
 	public void setQuestionDAO(QuestionDAO pQuestionDAO){
 	
 		if(pQuestionDAO == null){
 			throw new IllegalStateException("Do not try to set questionDAO to null.");
 		}
	 	this.questionDAO = pQuestionDAO;
 	}
 	public QuestionDAO getQuestionDAO(){
 		if(this.questionDAO == null){
 			throw new IllegalStateException("The questionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.questionDAO;
 	}	
 	
			
		
	
  	private  ExamRankingDAO  examRankingDAO;
 	public void setExamRankingDAO(ExamRankingDAO pExamRankingDAO){
 	
 		if(pExamRankingDAO == null){
 			throw new IllegalStateException("Do not try to set examRankingDAO to null.");
 		}
	 	this.examRankingDAO = pExamRankingDAO;
 	}
 	public ExamRankingDAO getExamRankingDAO(){
 		if(this.examRankingDAO == null){
 			throw new IllegalStateException("The examRankingDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.examRankingDAO;
 	}	
 	
			
		
	
  	private  WechatUserDAO  wechatUserDAO;
 	public void setWechatUserDAO(WechatUserDAO pWechatUserDAO){
 	
 		if(pWechatUserDAO == null){
 			throw new IllegalStateException("Do not try to set wechatUserDAO to null.");
 		}
	 	this.wechatUserDAO = pWechatUserDAO;
 	}
 	public WechatUserDAO getWechatUserDAO(){
 		if(this.wechatUserDAO == null){
 			throw new IllegalStateException("The wechatUserDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.wechatUserDAO;
 	}	
 	
			
		

	
	/*
	protected Platform load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(accessKey, options);
	}
	*/
	
	public SmartList<Platform> loadAll() {
	    return this.loadAll(getPlatformMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Platform load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPlatform(PlatformTable.withId(id), options);
	}
	
	
	
	public Platform save(Platform platform,Map<String,Object> options){
		
		String methodName="save(Platform platform,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(platform, methodName, "platform");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPlatform(platform,options);
	}
	public Platform clone(String platformId, Map<String,Object> options) throws Exception{
	
		return clone(PlatformTable.withId(platformId),options);
	}
	
	protected Platform clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String platformId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Platform newPlatform = loadInternalPlatform(accessKey, options);
		newPlatform.setVersion(0);
		
		
 		
 		if(isSaveChangeRequestTypeListEnabled(options)){
 			for(ChangeRequestType item: newPlatform.getChangeRequestTypeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveChangeRequestListEnabled(options)){
 			for(ChangeRequest item: newPlatform.getChangeRequestList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveExamStatusListEnabled(options)){
 			for(ExamStatus item: newPlatform.getExamStatusList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveQuestionListEnabled(options)){
 			for(Question item: newPlatform.getQuestionList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveExamRankingListEnabled(options)){
 			for(ExamRanking item: newPlatform.getExamRankingList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWechatUserListEnabled(options)){
 			for(WechatUser item: newPlatform.getWechatUserList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPlatform(newPlatform,options);
		
		return newPlatform;
	}
	
	
	
	

	protected void throwIfHasException(String platformId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PlatformVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PlatformNotFoundException(
					"The " + this.getTableName() + "(" + platformId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String platformId, int version) throws Exception{
	
		String methodName="delete(String platformId, int version)";
		assertMethodArgumentNotNull(platformId, methodName, "platformId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{platformId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(platformId,version);
		}
		
	
	}
	
	
	
	
	

	public Platform disconnectFromAll(String platformId, int version) throws Exception{
	
		
		Platform platform = loadInternalPlatform(PlatformTable.withId(platformId), emptyOptions());
		platform.clearFromAll();
		this.savePlatform(platform);
		return platform;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PlatformTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "platform";
	}
	@Override
	protected String getBeanName() {
		
		return "platform";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PlatformTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractChangeRequestTypeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.CHANGE_REQUEST_TYPE_LIST);
 	}
 	protected boolean isAnalyzeChangeRequestTypeListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeChangeRequestTypeListEnabled();
 	}
	
	protected boolean isSaveChangeRequestTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.CHANGE_REQUEST_TYPE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractChangeRequestListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.CHANGE_REQUEST_LIST);
 	}
 	protected boolean isAnalyzeChangeRequestListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeChangeRequestListEnabled();
 	}
	
	protected boolean isSaveChangeRequestListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.CHANGE_REQUEST_LIST);
		
 	}
 	
		
	
	protected boolean isExtractExamStatusListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.EXAM_STATUS_LIST);
 	}
 	protected boolean isAnalyzeExamStatusListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeExamStatusListEnabled();
 	}
	
	protected boolean isSaveExamStatusListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.EXAM_STATUS_LIST);
		
 	}
 	
		
	
	protected boolean isExtractQuestionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.QUESTION_LIST);
 	}
 	protected boolean isAnalyzeQuestionListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeQuestionListEnabled();
 	}
	
	protected boolean isSaveQuestionListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.QUESTION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractExamRankingListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.EXAM_RANKING_LIST);
 	}
 	protected boolean isAnalyzeExamRankingListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeExamRankingListEnabled();
 	}
	
	protected boolean isSaveExamRankingListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.EXAM_RANKING_LIST);
		
 	}
 	
		
	
	protected boolean isExtractWechatUserListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PlatformTokens.WECHAT_USER_LIST);
 	}
 	protected boolean isAnalyzeWechatUserListEnabled(Map<String,Object> options){		 		
 		return PlatformTokens.of(options).analyzeWechatUserListEnabled();
 	}
	
	protected boolean isSaveWechatUserListEnabled(Map<String,Object> options){
		return checkOptions(options, PlatformTokens.WECHAT_USER_LIST);
		
 	}
 	
		

	

	protected PlatformMapper getPlatformMapper(){
		return new PlatformMapper();
	}

	
	
	protected Platform extractPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Platform platform = loadSingleObject(accessKey, getPlatformMapper());
			return platform;
		}catch(EmptyResultDataAccessException e){
			throw new PlatformNotFoundException("Platform("+accessKey+") is not found!");
		}

	}

	
	

	protected Platform loadInternalPlatform(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Platform platform = extractPlatform(accessKey, loadOptions);

		
		if(isExtractChangeRequestTypeListEnabled(loadOptions)){
	 		extractChangeRequestTypeList(platform, loadOptions);
 		}	
 		if(isAnalyzeChangeRequestTypeListEnabled(loadOptions)){
	 		analyzeChangeRequestTypeList(platform, loadOptions);
 		}
 		
		
		if(isExtractChangeRequestListEnabled(loadOptions)){
	 		extractChangeRequestList(platform, loadOptions);
 		}	
 		if(isAnalyzeChangeRequestListEnabled(loadOptions)){
	 		analyzeChangeRequestList(platform, loadOptions);
 		}
 		
		
		if(isExtractExamStatusListEnabled(loadOptions)){
	 		extractExamStatusList(platform, loadOptions);
 		}	
 		if(isAnalyzeExamStatusListEnabled(loadOptions)){
	 		analyzeExamStatusList(platform, loadOptions);
 		}
 		
		
		if(isExtractQuestionListEnabled(loadOptions)){
	 		extractQuestionList(platform, loadOptions);
 		}	
 		if(isAnalyzeQuestionListEnabled(loadOptions)){
	 		analyzeQuestionList(platform, loadOptions);
 		}
 		
		
		if(isExtractExamRankingListEnabled(loadOptions)){
	 		extractExamRankingList(platform, loadOptions);
 		}	
 		if(isAnalyzeExamRankingListEnabled(loadOptions)){
	 		analyzeExamRankingList(platform, loadOptions);
 		}
 		
		
		if(isExtractWechatUserListEnabled(loadOptions)){
	 		extractWechatUserList(platform, loadOptions);
 		}	
 		if(isAnalyzeWechatUserListEnabled(loadOptions)){
	 		analyzeWechatUserList(platform, loadOptions);
 		}
 		
		
		return platform;
		
	}

	
		
	protected void enhanceChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractChangeRequestTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ChangeRequestType> changeRequestTypeList = getChangeRequestTypeDAO().findChangeRequestTypeByPlatform(platform.getId(),options);
		if(changeRequestTypeList != null){
			enhanceChangeRequestTypeList(changeRequestTypeList,options);
			platform.setChangeRequestTypeList(changeRequestTypeList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeChangeRequestTypeList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ChangeRequestType> changeRequestTypeList = platform.getChangeRequestTypeList();
		if(changeRequestTypeList != null){
			getChangeRequestTypeDAO().analyzeChangeRequestTypeByPlatform(changeRequestTypeList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractChangeRequestList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = getChangeRequestDAO().findChangeRequestByPlatform(platform.getId(),options);
		if(changeRequestList != null){
			enhanceChangeRequestList(changeRequestList,options);
			platform.setChangeRequestList(changeRequestList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeChangeRequestList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();
		if(changeRequestList != null){
			getChangeRequestDAO().analyzeChangeRequestByPlatform(changeRequestList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceExamStatusList(SmartList<ExamStatus> examStatusList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractExamStatusList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ExamStatus> examStatusList = getExamStatusDAO().findExamStatusByPlatform(platform.getId(),options);
		if(examStatusList != null){
			enhanceExamStatusList(examStatusList,options);
			platform.setExamStatusList(examStatusList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeExamStatusList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ExamStatus> examStatusList = platform.getExamStatusList();
		if(examStatusList != null){
			getExamStatusDAO().analyzeExamStatusByPlatform(examStatusList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceQuestionList(SmartList<Question> questionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractQuestionList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Question> questionList = getQuestionDAO().findQuestionByPlatform(platform.getId(),options);
		if(questionList != null){
			enhanceQuestionList(questionList,options);
			platform.setQuestionList(questionList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeQuestionList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<Question> questionList = platform.getQuestionList();
		if(questionList != null){
			getQuestionDAO().analyzeQuestionByPlatform(questionList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceExamRankingList(SmartList<ExamRanking> examRankingList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractExamRankingList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ExamRanking> examRankingList = getExamRankingDAO().findExamRankingByPlatform(platform.getId(),options);
		if(examRankingList != null){
			enhanceExamRankingList(examRankingList,options);
			platform.setExamRankingList(examRankingList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeExamRankingList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<ExamRanking> examRankingList = platform.getExamRankingList();
		if(examRankingList != null){
			getExamRankingDAO().analyzeExamRankingByPlatform(examRankingList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
	protected void enhanceWechatUserList(SmartList<WechatUser> wechatUserList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Platform extractWechatUserList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<WechatUser> wechatUserList = getWechatUserDAO().findWechatUserByPlatform(platform.getId(),options);
		if(wechatUserList != null){
			enhanceWechatUserList(wechatUserList,options);
			platform.setWechatUserList(wechatUserList);
		}
		
		return platform;
	
	}	
	
	protected Platform analyzeWechatUserList(Platform platform, Map<String,Object> options){
		
		
		if(platform == null){
			return null;
		}
		if(platform.getId() == null){
			return platform;
		}

		
		
		SmartList<WechatUser> wechatUserList = platform.getWechatUserList();
		if(wechatUserList != null){
			getWechatUserDAO().analyzeWechatUserByPlatform(wechatUserList, platform.getId(), options);
			
		}
		
		return platform;
	
	}	
	
		
		
 	
		
		
		

	

	protected Platform savePlatform(Platform  platform){
		
		if(!platform.isChanged()){
			return platform;
		}
		
		
		String SQL=this.getSavePlatformSQL(platform);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePlatformParameters(platform);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		platform.incVersion();
		return platform;
	
	}
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPlatformList(platformList);
		
		batchPlatformCreate((List<Platform>)lists[CREATE_LIST_INDEX]);
		
		batchPlatformUpdate((List<Platform>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Platform platform:platformList){
			if(platform.isChanged()){
				platform.incVersion();
			}
			
		
		}
		
		
		return platformList;
	}

	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options){
		
		
		super.removeList(platformList, options);
		
		return platformList;
		
		
	}
	
	protected List<Object[]> preparePlatformBatchCreateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			Object [] parameters = preparePlatformCreateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePlatformBatchUpdateArgs(List<Platform> platformList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Platform platform:platformList ){
			if(!platform.isChanged()){
				continue;
			}
			Object [] parameters = preparePlatformUpdateParameters(platform);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPlatformCreate(List<Platform> platformList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePlatformBatchCreateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPlatformUpdate(List<Platform> platformList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePlatformBatchUpdateArgs(platformList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPlatformList(List<Platform> platformList){
		
		List<Platform> platformCreateList=new ArrayList<Platform>();
		List<Platform> platformUpdateList=new ArrayList<Platform>();
		
		for(Platform platform: platformList){
			if(isUpdateRequest(platform)){
				platformUpdateList.add( platform);
				continue;
			}
			platformCreateList.add(platform);
		}
		
		return new Object[]{platformCreateList,platformUpdateList};
	}
	
	protected boolean isUpdateRequest(Platform platform){
 		return platform.getVersion() > 0;
 	}
 	protected String getSavePlatformSQL(Platform platform){
 		if(isUpdateRequest(platform)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePlatformParameters(Platform platform){
 		if(isUpdateRequest(platform) ){
 			return preparePlatformUpdateParameters(platform);
 		}
 		return preparePlatformCreateParameters(platform);
 	}
 	protected Object[] preparePlatformUpdateParameters(Platform platform){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = platform.getName();
 		parameters[1] = platform.getDescription();		
 		parameters[2] = platform.nextVersion();
 		parameters[3] = platform.getId();
 		parameters[4] = platform.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePlatformCreateParameters(Platform platform){
		Object[] parameters = new Object[3];
		String newPlatformId=getNextId();
		platform.setId(newPlatformId);
		parameters[0] =  platform.getId();
 
 		parameters[1] = platform.getName();
 		parameters[2] = platform.getDescription();		
 				
 		return parameters;
 	}
 	
	protected Platform saveInternalPlatform(Platform platform, Map<String,Object> options){
		
		savePlatform(platform);

		
		if(isSaveChangeRequestTypeListEnabled(options)){
	 		saveChangeRequestTypeList(platform, options);
	 		//removeChangeRequestTypeList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveChangeRequestListEnabled(options)){
	 		saveChangeRequestList(platform, options);
	 		//removeChangeRequestList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveExamStatusListEnabled(options)){
	 		saveExamStatusList(platform, options);
	 		//removeExamStatusList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveQuestionListEnabled(options)){
	 		saveQuestionList(platform, options);
	 		//removeQuestionList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveExamRankingListEnabled(options)){
	 		saveExamRankingList(platform, options);
	 		//removeExamRankingList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveWechatUserListEnabled(options)){
	 		saveWechatUserList(platform, options);
	 		//removeWechatUserList(platform, options);
	 		//Not delete the record
	 		
 		}		
		
		return platform;
		
	}
	
	
	
	//======================================================================================
	

	
	public Platform planToRemoveChangeRequestTypeList(Platform platform, String changeRequestTypeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequestType.PLATFORM_PROPERTY, platform.getId());
		key.put(ChangeRequestType.ID_PROPERTY, changeRequestTypeIds);
		
		SmartList<ChangeRequestType> externalChangeRequestTypeList = getChangeRequestTypeDAO().
				findChangeRequestTypeWithKey(key, options);
		if(externalChangeRequestTypeList == null){
			return platform;
		}
		if(externalChangeRequestTypeList.isEmpty()){
			return platform;
		}
		
		for(ChangeRequestType changeRequestTypeItem: externalChangeRequestTypeList){

			changeRequestTypeItem.clearFromAll();
		}
		
		
		SmartList<ChangeRequestType> changeRequestTypeList = platform.getChangeRequestTypeList();		
		changeRequestTypeList.addAllToRemoveList(externalChangeRequestTypeList);
		return platform;	
	
	}


	public Platform planToRemoveChangeRequestList(Platform platform, String changeRequestIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.PLATFORM_PROPERTY, platform.getId());
		key.put(ChangeRequest.ID_PROPERTY, changeRequestIds);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return platform;
		}
		if(externalChangeRequestList.isEmpty()){
			return platform;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){

			changeRequestItem.clearFromAll();
		}
		
		
		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return platform;	
	
	}


	//disconnect Platform with request_type in ChangeRequest
	public Platform planToRemoveChangeRequestListWithRequestType(Platform platform, String requestTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.PLATFORM_PROPERTY, platform.getId());
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, requestTypeId);
		
		SmartList<ChangeRequest> externalChangeRequestList = getChangeRequestDAO().
				findChangeRequestWithKey(key, options);
		if(externalChangeRequestList == null){
			return platform;
		}
		if(externalChangeRequestList.isEmpty()){
			return platform;
		}
		
		for(ChangeRequest changeRequestItem: externalChangeRequestList){
			changeRequestItem.clearRequestType();
			changeRequestItem.clearPlatform();
			
		}
		
		
		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();		
		changeRequestList.addAllToRemoveList(externalChangeRequestList);
		return platform;
	}
	
	public int countChangeRequestListWithRequestType(String platformId, String requestTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.PLATFORM_PROPERTY, platformId);
		key.put(ChangeRequest.REQUEST_TYPE_PROPERTY, requestTypeId);
		
		int count = getChangeRequestDAO().countChangeRequestWithKey(key, options);
		return count;
	}
	
	public Platform planToRemoveExamStatusList(Platform platform, String examStatusIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExamStatus.PLATFORM_PROPERTY, platform.getId());
		key.put(ExamStatus.ID_PROPERTY, examStatusIds);
		
		SmartList<ExamStatus> externalExamStatusList = getExamStatusDAO().
				findExamStatusWithKey(key, options);
		if(externalExamStatusList == null){
			return platform;
		}
		if(externalExamStatusList.isEmpty()){
			return platform;
		}
		
		for(ExamStatus examStatusItem: externalExamStatusList){

			examStatusItem.clearFromAll();
		}
		
		
		SmartList<ExamStatus> examStatusList = platform.getExamStatusList();		
		examStatusList.addAllToRemoveList(externalExamStatusList);
		return platform;	
	
	}


	public Platform planToRemoveQuestionList(Platform platform, String questionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Question.PLATFORM_PROPERTY, platform.getId());
		key.put(Question.ID_PROPERTY, questionIds);
		
		SmartList<Question> externalQuestionList = getQuestionDAO().
				findQuestionWithKey(key, options);
		if(externalQuestionList == null){
			return platform;
		}
		if(externalQuestionList.isEmpty()){
			return platform;
		}
		
		for(Question questionItem: externalQuestionList){

			questionItem.clearFromAll();
		}
		
		
		SmartList<Question> questionList = platform.getQuestionList();		
		questionList.addAllToRemoveList(externalQuestionList);
		return platform;	
	
	}


	public Platform planToRemoveExamRankingList(Platform platform, String examRankingIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExamRanking.PLATFORM_PROPERTY, platform.getId());
		key.put(ExamRanking.ID_PROPERTY, examRankingIds);
		
		SmartList<ExamRanking> externalExamRankingList = getExamRankingDAO().
				findExamRankingWithKey(key, options);
		if(externalExamRankingList == null){
			return platform;
		}
		if(externalExamRankingList.isEmpty()){
			return platform;
		}
		
		for(ExamRanking examRankingItem: externalExamRankingList){

			examRankingItem.clearFromAll();
		}
		
		
		SmartList<ExamRanking> examRankingList = platform.getExamRankingList();		
		examRankingList.addAllToRemoveList(externalExamRankingList);
		return platform;	
	
	}


	public Platform planToRemoveWechatUserList(Platform platform, String wechatUserIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatUser.PLATFORM_PROPERTY, platform.getId());
		key.put(WechatUser.ID_PROPERTY, wechatUserIds);
		
		SmartList<WechatUser> externalWechatUserList = getWechatUserDAO().
				findWechatUserWithKey(key, options);
		if(externalWechatUserList == null){
			return platform;
		}
		if(externalWechatUserList.isEmpty()){
			return platform;
		}
		
		for(WechatUser wechatUserItem: externalWechatUserList){

			wechatUserItem.clearFromAll();
		}
		
		
		SmartList<WechatUser> wechatUserList = platform.getWechatUserList();		
		wechatUserList.addAllToRemoveList(externalWechatUserList);
		return platform;	
	
	}



		
	protected Platform saveChangeRequestTypeList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<ChangeRequestType> changeRequestTypeList = platform.getChangeRequestTypeList();
		if(changeRequestTypeList == null){
			//null list means nothing
			return platform;
		}
		SmartList<ChangeRequestType> mergedUpdateChangeRequestTypeList = new SmartList<ChangeRequestType>();
		
		
		mergedUpdateChangeRequestTypeList.addAll(changeRequestTypeList); 
		if(changeRequestTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChangeRequestTypeList.addAll(changeRequestTypeList.getToRemoveList());
			changeRequestTypeList.removeAll(changeRequestTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChangeRequestTypeDAO().saveChangeRequestTypeList(mergedUpdateChangeRequestTypeList,options);
		
		if(changeRequestTypeList.getToRemoveList() != null){
			changeRequestTypeList.removeAll(changeRequestTypeList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeChangeRequestTypeList(Platform platform, Map<String,Object> options){
	
	
		SmartList<ChangeRequestType> changeRequestTypeList = platform.getChangeRequestTypeList();
		if(changeRequestTypeList == null){
			return platform;
		}	
	
		SmartList<ChangeRequestType> toRemoveChangeRequestTypeList = changeRequestTypeList.getToRemoveList();
		
		if(toRemoveChangeRequestTypeList == null){
			return platform;
		}
		if(toRemoveChangeRequestTypeList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChangeRequestTypeDAO().removeChangeRequestTypeList(toRemoveChangeRequestTypeList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveChangeRequestList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();
		if(changeRequestList == null){
			//null list means nothing
			return platform;
		}
		SmartList<ChangeRequest> mergedUpdateChangeRequestList = new SmartList<ChangeRequest>();
		
		
		mergedUpdateChangeRequestList.addAll(changeRequestList); 
		if(changeRequestList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateChangeRequestList.addAll(changeRequestList.getToRemoveList());
			changeRequestList.removeAll(changeRequestList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getChangeRequestDAO().saveChangeRequestList(mergedUpdateChangeRequestList,options);
		
		if(changeRequestList.getToRemoveList() != null){
			changeRequestList.removeAll(changeRequestList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeChangeRequestList(Platform platform, Map<String,Object> options){
	
	
		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();
		if(changeRequestList == null){
			return platform;
		}	
	
		SmartList<ChangeRequest> toRemoveChangeRequestList = changeRequestList.getToRemoveList();
		
		if(toRemoveChangeRequestList == null){
			return platform;
		}
		if(toRemoveChangeRequestList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getChangeRequestDAO().removeChangeRequestList(toRemoveChangeRequestList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveExamStatusList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<ExamStatus> examStatusList = platform.getExamStatusList();
		if(examStatusList == null){
			//null list means nothing
			return platform;
		}
		SmartList<ExamStatus> mergedUpdateExamStatusList = new SmartList<ExamStatus>();
		
		
		mergedUpdateExamStatusList.addAll(examStatusList); 
		if(examStatusList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExamStatusList.addAll(examStatusList.getToRemoveList());
			examStatusList.removeAll(examStatusList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExamStatusDAO().saveExamStatusList(mergedUpdateExamStatusList,options);
		
		if(examStatusList.getToRemoveList() != null){
			examStatusList.removeAll(examStatusList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeExamStatusList(Platform platform, Map<String,Object> options){
	
	
		SmartList<ExamStatus> examStatusList = platform.getExamStatusList();
		if(examStatusList == null){
			return platform;
		}	
	
		SmartList<ExamStatus> toRemoveExamStatusList = examStatusList.getToRemoveList();
		
		if(toRemoveExamStatusList == null){
			return platform;
		}
		if(toRemoveExamStatusList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExamStatusDAO().removeExamStatusList(toRemoveExamStatusList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveQuestionList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<Question> questionList = platform.getQuestionList();
		if(questionList == null){
			//null list means nothing
			return platform;
		}
		SmartList<Question> mergedUpdateQuestionList = new SmartList<Question>();
		
		
		mergedUpdateQuestionList.addAll(questionList); 
		if(questionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateQuestionList.addAll(questionList.getToRemoveList());
			questionList.removeAll(questionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getQuestionDAO().saveQuestionList(mergedUpdateQuestionList,options);
		
		if(questionList.getToRemoveList() != null){
			questionList.removeAll(questionList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeQuestionList(Platform platform, Map<String,Object> options){
	
	
		SmartList<Question> questionList = platform.getQuestionList();
		if(questionList == null){
			return platform;
		}	
	
		SmartList<Question> toRemoveQuestionList = questionList.getToRemoveList();
		
		if(toRemoveQuestionList == null){
			return platform;
		}
		if(toRemoveQuestionList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getQuestionDAO().removeQuestionList(toRemoveQuestionList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveExamRankingList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<ExamRanking> examRankingList = platform.getExamRankingList();
		if(examRankingList == null){
			//null list means nothing
			return platform;
		}
		SmartList<ExamRanking> mergedUpdateExamRankingList = new SmartList<ExamRanking>();
		
		
		mergedUpdateExamRankingList.addAll(examRankingList); 
		if(examRankingList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExamRankingList.addAll(examRankingList.getToRemoveList());
			examRankingList.removeAll(examRankingList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExamRankingDAO().saveExamRankingList(mergedUpdateExamRankingList,options);
		
		if(examRankingList.getToRemoveList() != null){
			examRankingList.removeAll(examRankingList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeExamRankingList(Platform platform, Map<String,Object> options){
	
	
		SmartList<ExamRanking> examRankingList = platform.getExamRankingList();
		if(examRankingList == null){
			return platform;
		}	
	
		SmartList<ExamRanking> toRemoveExamRankingList = examRankingList.getToRemoveList();
		
		if(toRemoveExamRankingList == null){
			return platform;
		}
		if(toRemoveExamRankingList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExamRankingDAO().removeExamRankingList(toRemoveExamRankingList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		
	protected Platform saveWechatUserList(Platform platform, Map<String,Object> options){
		
		
		
		
		SmartList<WechatUser> wechatUserList = platform.getWechatUserList();
		if(wechatUserList == null){
			//null list means nothing
			return platform;
		}
		SmartList<WechatUser> mergedUpdateWechatUserList = new SmartList<WechatUser>();
		
		
		mergedUpdateWechatUserList.addAll(wechatUserList); 
		if(wechatUserList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWechatUserList.addAll(wechatUserList.getToRemoveList());
			wechatUserList.removeAll(wechatUserList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getWechatUserDAO().saveWechatUserList(mergedUpdateWechatUserList,options);
		
		if(wechatUserList.getToRemoveList() != null){
			wechatUserList.removeAll(wechatUserList.getToRemoveList());
		}
		
		
		return platform;
	
	}
	
	protected Platform removeWechatUserList(Platform platform, Map<String,Object> options){
	
	
		SmartList<WechatUser> wechatUserList = platform.getWechatUserList();
		if(wechatUserList == null){
			return platform;
		}	
	
		SmartList<WechatUser> toRemoveWechatUserList = wechatUserList.getToRemoveList();
		
		if(toRemoveWechatUserList == null){
			return platform;
		}
		if(toRemoveWechatUserList.isEmpty()){
			return platform;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWechatUserDAO().removeWechatUserList(toRemoveWechatUserList,options);
		
		return platform;
	
	}
	
	

 	
 	
	
	
	
		

	public Platform present(Platform platform,Map<String, Object> options){
	
		presentChangeRequestTypeList(platform,options);
		presentChangeRequestList(platform,options);
		presentExamStatusList(platform,options);
		presentQuestionList(platform,options);
		presentExamRankingList(platform,options);
		presentWechatUserList(platform,options);

		return platform;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentChangeRequestTypeList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<ChangeRequestType> changeRequestTypeList = platform.getChangeRequestTypeList();		
				SmartList<ChangeRequestType> newList= presentSubList(platform.getId(),
				changeRequestTypeList,
				options,
				getChangeRequestTypeDAO()::countChangeRequestTypeByPlatform,
				getChangeRequestTypeDAO()::findChangeRequestTypeByPlatform
				);

		
		platform.setChangeRequestTypeList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentChangeRequestList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<ChangeRequest> changeRequestList = platform.getChangeRequestList();		
				SmartList<ChangeRequest> newList= presentSubList(platform.getId(),
				changeRequestList,
				options,
				getChangeRequestDAO()::countChangeRequestByPlatform,
				getChangeRequestDAO()::findChangeRequestByPlatform
				);

		
		platform.setChangeRequestList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentExamStatusList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<ExamStatus> examStatusList = platform.getExamStatusList();		
				SmartList<ExamStatus> newList= presentSubList(platform.getId(),
				examStatusList,
				options,
				getExamStatusDAO()::countExamStatusByPlatform,
				getExamStatusDAO()::findExamStatusByPlatform
				);

		
		platform.setExamStatusList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentQuestionList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<Question> questionList = platform.getQuestionList();		
				SmartList<Question> newList= presentSubList(platform.getId(),
				questionList,
				options,
				getQuestionDAO()::countQuestionByPlatform,
				getQuestionDAO()::findQuestionByPlatform
				);

		
		platform.setQuestionList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentExamRankingList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<ExamRanking> examRankingList = platform.getExamRankingList();		
				SmartList<ExamRanking> newList= presentSubList(platform.getId(),
				examRankingList,
				options,
				getExamRankingDAO()::countExamRankingByPlatform,
				getExamRankingDAO()::findExamRankingByPlatform
				);

		
		platform.setExamRankingList(newList);
		

		return platform;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Platform presentWechatUserList(
			Platform platform,
			Map<String, Object> options) {

		SmartList<WechatUser> wechatUserList = platform.getWechatUserList();		
				SmartList<WechatUser> newList= presentSubList(platform.getId(),
				wechatUserList,
				options,
				getWechatUserDAO()::countWechatUserByPlatform,
				getWechatUserDAO()::findWechatUserByPlatform
				);

		
		platform.setWechatUserList(newList);
		

		return platform;
	}			
		

	
    public SmartList<Platform> requestCandidatePlatformForChangeRequestType(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForChangeRequest(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForExamStatus(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForExamRanking(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		
    public SmartList<Platform> requestCandidatePlatformForWechatUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PlatformTable.COLUMN_NAME, filterKey, pageNo, pageSize, getPlatformMapper());
    }
		

	protected String getTableName(){
		return PlatformTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Platform> platformList) {		
		this.enhanceListInternal(platformList, this.getPlatformMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequestType的platform的ChangeRequestTypeList
	public SmartList<ChangeRequestType> loadOurChangeRequestTypeList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequestType.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChangeRequestType> loadedObjs = userContext.getDAOGroup().getChangeRequestTypeDAO().findChangeRequestTypeWithKey(key, options);
		Map<String, List<ChangeRequestType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChangeRequestType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChangeRequestType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChangeRequestTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的platform的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ChangeRequest.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ChangeRequest> loadedObjs = userContext.getDAOGroup().getChangeRequestDAO().findChangeRequestWithKey(key, options);
		Map<String, List<ChangeRequest>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ChangeRequest> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ChangeRequest> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setChangeRequestList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ExamStatus的platform的ExamStatusList
	public SmartList<ExamStatus> loadOurExamStatusList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExamStatus.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ExamStatus> loadedObjs = userContext.getDAOGroup().getExamStatusDAO().findExamStatusWithKey(key, options);
		Map<String, List<ExamStatus>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ExamStatus> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ExamStatus> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExamStatusList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Question的platform的QuestionList
	public SmartList<Question> loadOurQuestionList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Question.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Question> loadedObjs = userContext.getDAOGroup().getQuestionDAO().findQuestionWithKey(key, options);
		Map<String, List<Question>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Question> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Question> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setQuestionList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ExamRanking的platform的ExamRankingList
	public SmartList<ExamRanking> loadOurExamRankingList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ExamRanking.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ExamRanking> loadedObjs = userContext.getDAOGroup().getExamRankingDAO().findExamRankingWithKey(key, options);
		Map<String, List<ExamRanking>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ExamRanking> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ExamRanking> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExamRankingList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:WechatUser的platform的WechatUserList
	public SmartList<WechatUser> loadOurWechatUserList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatUser.PLATFORM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<WechatUser> loadedObjs = userContext.getDAOGroup().getWechatUserDAO().findWechatUserWithKey(key, options);
		Map<String, List<WechatUser>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPlatform().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<WechatUser> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<WechatUser> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWechatUserList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Platform> platformList = ownerEntity.collectRefsWithType(Platform.INTERNAL_TYPE);
		this.enhanceList(platformList);
		
	}
	
	@Override
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPlatformMapper());

	}
	@Override
	public int countPlatformWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Platform> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPlatformMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplateObject().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = (String) data.get("id");
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplateObject().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplateObject().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplateObject().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplateObject().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplateObject().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplateObject().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplateObject().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplateObject().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplateObject().execute(sql);
	}


}


