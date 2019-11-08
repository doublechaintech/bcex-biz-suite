
package com.doublechaintech.bcex.wechatuser;

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


import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfo;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.faultanswer.FaultAnswerDAO;
import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfoDAO;
import com.doublechaintech.bcex.startexam.StartExamDAO;
import com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class WechatUserJDBCTemplateDAO extends BcexBaseDAOImpl implements WechatUserDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
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
 	
			
		
	
  	private  WechatLoginInfoDAO  wechatLoginInfoDAO;
 	public void setWechatLoginInfoDAO(WechatLoginInfoDAO pWechatLoginInfoDAO){
 	
 		if(pWechatLoginInfoDAO == null){
 			throw new IllegalStateException("Do not try to set wechatLoginInfoDAO to null.");
 		}
	 	this.wechatLoginInfoDAO = pWechatLoginInfoDAO;
 	}
 	public WechatLoginInfoDAO getWechatLoginInfoDAO(){
 		if(this.wechatLoginInfoDAO == null){
 			throw new IllegalStateException("The wechatLoginInfoDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.wechatLoginInfoDAO;
 	}	
 	
			
		
	
  	private  ExamDAO  examDAO;
 	public void setExamDAO(ExamDAO pExamDAO){
 	
 		if(pExamDAO == null){
 			throw new IllegalStateException("Do not try to set examDAO to null.");
 		}
	 	this.examDAO = pExamDAO;
 	}
 	public ExamDAO getExamDAO(){
 		if(this.examDAO == null){
 			throw new IllegalStateException("The examDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.examDAO;
 	}	
 	
			
		
	
  	private  FaultAnswerDAO  faultAnswerDAO;
 	public void setFaultAnswerDAO(FaultAnswerDAO pFaultAnswerDAO){
 	
 		if(pFaultAnswerDAO == null){
 			throw new IllegalStateException("Do not try to set faultAnswerDAO to null.");
 		}
	 	this.faultAnswerDAO = pFaultAnswerDAO;
 	}
 	public FaultAnswerDAO getFaultAnswerDAO(){
 		if(this.faultAnswerDAO == null){
 			throw new IllegalStateException("The faultAnswerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.faultAnswerDAO;
 	}	
 	
			
		

	
	/*
	protected WechatUser load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatUser(accessKey, options);
	}
	*/
	
	public SmartList<WechatUser> loadAll() {
	    return this.loadAll(getWechatUserMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public WechatUser load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatUser(WechatUserTable.withId(id), options);
	}
	
	
	
	public WechatUser save(WechatUser wechatUser,Map<String,Object> options){
		
		String methodName="save(WechatUser wechatUser,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(wechatUser, methodName, "wechatUser");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWechatUser(wechatUser,options);
	}
	public WechatUser clone(String wechatUserId, Map<String,Object> options) throws Exception{
	
		return clone(WechatUserTable.withId(wechatUserId),options);
	}
	
	protected WechatUser clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String wechatUserId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		WechatUser newWechatUser = loadInternalWechatUser(accessKey, options);
		newWechatUser.setVersion(0);
		
		
 		
 		if(isSaveStartExamListEnabled(options)){
 			for(StartExam item: newWechatUser.getStartExamList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveAnswerQuestionListEnabled(options)){
 			for(AnswerQuestion item: newWechatUser.getAnswerQuestionList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWechatLoginInfoListEnabled(options)){
 			for(WechatLoginInfo item: newWechatUser.getWechatLoginInfoList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveExamListEnabled(options)){
 			for(Exam item: newWechatUser.getExamList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFaultAnswerListEnabled(options)){
 			for(FaultAnswer item: newWechatUser.getFaultAnswerList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalWechatUser(newWechatUser,options);
		
		return newWechatUser;
	}
	
	
	
	

	protected void throwIfHasException(String wechatUserId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatUserVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatUserNotFoundException(
					"The " + this.getTableName() + "(" + wechatUserId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String wechatUserId, int version) throws Exception{
	
		String methodName="delete(String wechatUserId, int version)";
		assertMethodArgumentNotNull(wechatUserId, methodName, "wechatUserId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatUserId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatUserId,version);
		}
		
	
	}
	
	
	
	
	

	public WechatUser disconnectFromAll(String wechatUserId, int version) throws Exception{
	
		
		WechatUser wechatUser = loadInternalWechatUser(WechatUserTable.withId(wechatUserId), emptyOptions());
		wechatUser.clearFromAll();
		this.saveWechatUser(wechatUser);
		return wechatUser;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return WechatUserTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "wechat_user";
	}
	@Override
	protected String getBeanName() {
		
		return "wechatUser";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WechatUserTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WechatUserTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WechatUserTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractStartExamListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WechatUserTokens.START_EXAM_LIST);
 	}
 	protected boolean isAnalyzeStartExamListEnabled(Map<String,Object> options){		 		
 		return WechatUserTokens.of(options).analyzeStartExamListEnabled();
 	}
	
	protected boolean isSaveStartExamListEnabled(Map<String,Object> options){
		return checkOptions(options, WechatUserTokens.START_EXAM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractAnswerQuestionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WechatUserTokens.ANSWER_QUESTION_LIST);
 	}
 	protected boolean isAnalyzeAnswerQuestionListEnabled(Map<String,Object> options){		 		
 		return WechatUserTokens.of(options).analyzeAnswerQuestionListEnabled();
 	}
	
	protected boolean isSaveAnswerQuestionListEnabled(Map<String,Object> options){
		return checkOptions(options, WechatUserTokens.ANSWER_QUESTION_LIST);
		
 	}
 	
		
	
	protected boolean isExtractWechatLoginInfoListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WechatUserTokens.WECHAT_LOGIN_INFO_LIST);
 	}
 	protected boolean isAnalyzeWechatLoginInfoListEnabled(Map<String,Object> options){		 		
 		return WechatUserTokens.of(options).analyzeWechatLoginInfoListEnabled();
 	}
	
	protected boolean isSaveWechatLoginInfoListEnabled(Map<String,Object> options){
		return checkOptions(options, WechatUserTokens.WECHAT_LOGIN_INFO_LIST);
		
 	}
 	
		
	
	protected boolean isExtractExamListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WechatUserTokens.EXAM_LIST);
 	}
 	protected boolean isAnalyzeExamListEnabled(Map<String,Object> options){		 		
 		return WechatUserTokens.of(options).analyzeExamListEnabled();
 	}
	
	protected boolean isSaveExamListEnabled(Map<String,Object> options){
		return checkOptions(options, WechatUserTokens.EXAM_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFaultAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,WechatUserTokens.FAULT_ANSWER_LIST);
 	}
 	protected boolean isAnalyzeFaultAnswerListEnabled(Map<String,Object> options){		 		
 		return WechatUserTokens.of(options).analyzeFaultAnswerListEnabled();
 	}
	
	protected boolean isSaveFaultAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, WechatUserTokens.FAULT_ANSWER_LIST);
		
 	}
 	
		

	

	protected WechatUserMapper getWechatUserMapper(){
		return new WechatUserMapper();
	}

	
	
	protected WechatUser extractWechatUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatUser wechatUser = loadSingleObject(accessKey, getWechatUserMapper());
			return wechatUser;
		}catch(EmptyResultDataAccessException e){
			throw new WechatUserNotFoundException("WechatUser("+accessKey+") is not found!");
		}

	}

	
	

	protected WechatUser loadInternalWechatUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WechatUser wechatUser = extractWechatUser(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(wechatUser, loadOptions);
 		}
 
		
		if(isExtractStartExamListEnabled(loadOptions)){
	 		extractStartExamList(wechatUser, loadOptions);
 		}	
 		if(isAnalyzeStartExamListEnabled(loadOptions)){
	 		analyzeStartExamList(wechatUser, loadOptions);
 		}
 		
		
		if(isExtractAnswerQuestionListEnabled(loadOptions)){
	 		extractAnswerQuestionList(wechatUser, loadOptions);
 		}	
 		if(isAnalyzeAnswerQuestionListEnabled(loadOptions)){
	 		analyzeAnswerQuestionList(wechatUser, loadOptions);
 		}
 		
		
		if(isExtractWechatLoginInfoListEnabled(loadOptions)){
	 		extractWechatLoginInfoList(wechatUser, loadOptions);
 		}	
 		if(isAnalyzeWechatLoginInfoListEnabled(loadOptions)){
	 		analyzeWechatLoginInfoList(wechatUser, loadOptions);
 		}
 		
		
		if(isExtractExamListEnabled(loadOptions)){
	 		extractExamList(wechatUser, loadOptions);
 		}	
 		if(isAnalyzeExamListEnabled(loadOptions)){
	 		analyzeExamList(wechatUser, loadOptions);
 		}
 		
		
		if(isExtractFaultAnswerListEnabled(loadOptions)){
	 		extractFaultAnswerList(wechatUser, loadOptions);
 		}	
 		if(isAnalyzeFaultAnswerListEnabled(loadOptions)){
	 		analyzeFaultAnswerList(wechatUser, loadOptions);
 		}
 		
		
		return wechatUser;
		
	}

	 

 	protected WechatUser extractPlatform(WechatUser wechatUser, Map<String,Object> options) throws Exception{

		if(wechatUser.getPlatform() == null){
			return wechatUser;
		}
		String platformId = wechatUser.getPlatform().getId();
		if( platformId == null){
			return wechatUser;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			wechatUser.setPlatform(platform);
		}
		
 		
 		return wechatUser;
 	}
 		
 
		
	protected void enhanceStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected WechatUser extractStartExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<StartExam> startExamList = getStartExamDAO().findStartExamByUser(wechatUser.getId(),options);
		if(startExamList != null){
			enhanceStartExamList(startExamList,options);
			wechatUser.setStartExamList(startExamList);
		}
		
		return wechatUser;
	
	}	
	
	protected WechatUser analyzeStartExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<StartExam> startExamList = wechatUser.getStartExamList();
		if(startExamList != null){
			getStartExamDAO().analyzeStartExamByUser(startExamList, wechatUser.getId(), options);
			
		}
		
		return wechatUser;
	
	}	
	
		
	protected void enhanceAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected WechatUser extractAnswerQuestionList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = getAnswerQuestionDAO().findAnswerQuestionByUser(wechatUser.getId(),options);
		if(answerQuestionList != null){
			enhanceAnswerQuestionList(answerQuestionList,options);
			wechatUser.setAnswerQuestionList(answerQuestionList);
		}
		
		return wechatUser;
	
	}	
	
	protected WechatUser analyzeAnswerQuestionList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();
		if(answerQuestionList != null){
			getAnswerQuestionDAO().analyzeAnswerQuestionByUser(answerQuestionList, wechatUser.getId(), options);
			
		}
		
		return wechatUser;
	
	}	
	
		
	protected void enhanceWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected WechatUser extractWechatLoginInfoList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = getWechatLoginInfoDAO().findWechatLoginInfoByWechatUser(wechatUser.getId(),options);
		if(wechatLoginInfoList != null){
			enhanceWechatLoginInfoList(wechatLoginInfoList,options);
			wechatUser.setWechatLoginInfoList(wechatLoginInfoList);
		}
		
		return wechatUser;
	
	}	
	
	protected WechatUser analyzeWechatLoginInfoList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();
		if(wechatLoginInfoList != null){
			getWechatLoginInfoDAO().analyzeWechatLoginInfoByWechatUser(wechatLoginInfoList, wechatUser.getId(), options);
			
		}
		
		return wechatUser;
	
	}	
	
		
	protected void enhanceExamList(SmartList<Exam> examList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected WechatUser extractExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<Exam> examList = getExamDAO().findExamByUser(wechatUser.getId(),options);
		if(examList != null){
			enhanceExamList(examList,options);
			wechatUser.setExamList(examList);
		}
		
		return wechatUser;
	
	}	
	
	protected WechatUser analyzeExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<Exam> examList = wechatUser.getExamList();
		if(examList != null){
			getExamDAO().analyzeExamByUser(examList, wechatUser.getId(), options);
			
		}
		
		return wechatUser;
	
	}	
	
		
	protected void enhanceFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected WechatUser extractFaultAnswerList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = getFaultAnswerDAO().findFaultAnswerByUser(wechatUser.getId(),options);
		if(faultAnswerList != null){
			enhanceFaultAnswerList(faultAnswerList,options);
			wechatUser.setFaultAnswerList(faultAnswerList);
		}
		
		return wechatUser;
	
	}	
	
	protected WechatUser analyzeFaultAnswerList(WechatUser wechatUser, Map<String,Object> options){
		
		
		if(wechatUser == null){
			return null;
		}
		if(wechatUser.getId() == null){
			return wechatUser;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();
		if(faultAnswerList != null){
			getFaultAnswerDAO().analyzeFaultAnswerByUser(faultAnswerList, wechatUser.getId(), options);
			
		}
		
		return wechatUser;
	
	}	
	
		
		
  	
 	public SmartList<WechatUser> findWechatUserByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<WechatUser> resultList = queryWith(WechatUserTable.COLUMN_PLATFORM, platformId, options, getWechatUserMapper());
		// analyzeWechatUserByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<WechatUser> findWechatUserByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<WechatUser> resultList =  queryWithRange(WechatUserTable.COLUMN_PLATFORM, platformId, options, getWechatUserMapper(), start, count);
 		//analyzeWechatUserByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeWechatUserByPlatform(SmartList<WechatUser> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatUser.PLATFORM_PROPERTY, platformId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//WechatUser.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("微信用户");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(WechatUser.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatUser.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWechatUserByPlatform(String platformId,Map<String,Object> options){

 		return countWith(WechatUserTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatUserByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatUserTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected WechatUser saveWechatUser(WechatUser  wechatUser){
		
		if(!wechatUser.isChanged()){
			return wechatUser;
		}
		
		
		String SQL=this.getSaveWechatUserSQL(wechatUser);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatUserParameters(wechatUser);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		wechatUser.incVersion();
		return wechatUser;
	
	}
	public SmartList<WechatUser> saveWechatUserList(SmartList<WechatUser> wechatUserList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatUserList(wechatUserList);
		
		batchWechatUserCreate((List<WechatUser>)lists[CREATE_LIST_INDEX]);
		
		batchWechatUserUpdate((List<WechatUser>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(WechatUser wechatUser:wechatUserList){
			if(wechatUser.isChanged()){
				wechatUser.incVersion();
			}
			
		
		}
		
		
		return wechatUserList;
	}

	public SmartList<WechatUser> removeWechatUserList(SmartList<WechatUser> wechatUserList,Map<String,Object> options){
		
		
		super.removeList(wechatUserList, options);
		
		return wechatUserList;
		
		
	}
	
	protected List<Object[]> prepareWechatUserBatchCreateArgs(List<WechatUser> wechatUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatUser wechatUser:wechatUserList ){
			Object [] parameters = prepareWechatUserCreateParameters(wechatUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWechatUserBatchUpdateArgs(List<WechatUser> wechatUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatUser wechatUser:wechatUserList ){
			if(!wechatUser.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatUserUpdateParameters(wechatUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWechatUserCreate(List<WechatUser> wechatUserList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatUserBatchCreateArgs(wechatUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWechatUserUpdate(List<WechatUser> wechatUserList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatUserBatchUpdateArgs(wechatUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWechatUserList(List<WechatUser> wechatUserList){
		
		List<WechatUser> wechatUserCreateList=new ArrayList<WechatUser>();
		List<WechatUser> wechatUserUpdateList=new ArrayList<WechatUser>();
		
		for(WechatUser wechatUser: wechatUserList){
			if(isUpdateRequest(wechatUser)){
				wechatUserUpdateList.add( wechatUser);
				continue;
			}
			wechatUserCreateList.add(wechatUser);
		}
		
		return new Object[]{wechatUserCreateList,wechatUserUpdateList};
	}
	
	protected boolean isUpdateRequest(WechatUser wechatUser){
 		return wechatUser.getVersion() > 0;
 	}
 	protected String getSaveWechatUserSQL(WechatUser wechatUser){
 		if(isUpdateRequest(wechatUser)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWechatUserParameters(WechatUser wechatUser){
 		if(isUpdateRequest(wechatUser) ){
 			return prepareWechatUserUpdateParameters(wechatUser);
 		}
 		return prepareWechatUserCreateParameters(wechatUser);
 	}
 	protected Object[] prepareWechatUserUpdateParameters(WechatUser wechatUser){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = wechatUser.getName();
 		parameters[1] = wechatUser.getAvarta();
 		parameters[2] = wechatUser.getCreateTime();
 		parameters[3] = wechatUser.getUserType(); 	
 		if(wechatUser.getPlatform() != null){
 			parameters[4] = wechatUser.getPlatform().getId();
 		}
 		
 		parameters[5] = wechatUser.nextVersion();
 		parameters[6] = wechatUser.getId();
 		parameters[7] = wechatUser.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWechatUserCreateParameters(WechatUser wechatUser){
		Object[] parameters = new Object[6];
		String newWechatUserId=getNextId();
		wechatUser.setId(newWechatUserId);
		parameters[0] =  wechatUser.getId();
 
 		parameters[1] = wechatUser.getName();
 		parameters[2] = wechatUser.getAvarta();
 		parameters[3] = wechatUser.getCreateTime();
 		parameters[4] = wechatUser.getUserType(); 	
 		if(wechatUser.getPlatform() != null){
 			parameters[5] = wechatUser.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected WechatUser saveInternalWechatUser(WechatUser wechatUser, Map<String,Object> options){
		
		saveWechatUser(wechatUser);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(wechatUser, options);
 		}
 
		
		if(isSaveStartExamListEnabled(options)){
	 		saveStartExamList(wechatUser, options);
	 		//removeStartExamList(wechatUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveAnswerQuestionListEnabled(options)){
	 		saveAnswerQuestionList(wechatUser, options);
	 		//removeAnswerQuestionList(wechatUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveWechatLoginInfoListEnabled(options)){
	 		saveWechatLoginInfoList(wechatUser, options);
	 		//removeWechatLoginInfoList(wechatUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveExamListEnabled(options)){
	 		saveExamList(wechatUser, options);
	 		//removeExamList(wechatUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFaultAnswerListEnabled(options)){
	 		saveFaultAnswerList(wechatUser, options);
	 		//removeFaultAnswerList(wechatUser, options);
	 		//Not delete the record
	 		
 		}		
		
		return wechatUser;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected WechatUser savePlatform(WechatUser wechatUser, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(wechatUser.getPlatform() == null){
 			return wechatUser;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(wechatUser.getPlatform(),options);
 		return wechatUser;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public WechatUser planToRemoveStartExamList(WechatUser wechatUser, String startExamIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.USER_PROPERTY, wechatUser.getId());
		key.put(StartExam.ID_PROPERTY, startExamIds);
		
		SmartList<StartExam> externalStartExamList = getStartExamDAO().
				findStartExamWithKey(key, options);
		if(externalStartExamList == null){
			return wechatUser;
		}
		if(externalStartExamList.isEmpty()){
			return wechatUser;
		}
		
		for(StartExam startExamItem: externalStartExamList){

			startExamItem.clearFromAll();
		}
		
		
		SmartList<StartExam> startExamList = wechatUser.getStartExamList();		
		startExamList.addAllToRemoveList(externalStartExamList);
		return wechatUser;	
	
	}


	//disconnect WechatUser with change_request in StartExam
	public WechatUser planToRemoveStartExamListWithChangeRequest(WechatUser wechatUser, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.USER_PROPERTY, wechatUser.getId());
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		SmartList<StartExam> externalStartExamList = getStartExamDAO().
				findStartExamWithKey(key, options);
		if(externalStartExamList == null){
			return wechatUser;
		}
		if(externalStartExamList.isEmpty()){
			return wechatUser;
		}
		
		for(StartExam startExamItem: externalStartExamList){
			startExamItem.clearChangeRequest();
			startExamItem.clearUser();
			
		}
		
		
		SmartList<StartExam> startExamList = wechatUser.getStartExamList();		
		startExamList.addAllToRemoveList(externalStartExamList);
		return wechatUser;
	}
	
	public int countStartExamListWithChangeRequest(String wechatUserId, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.USER_PROPERTY, wechatUserId);
		key.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		int count = getStartExamDAO().countStartExamWithKey(key, options);
		return count;
	}
	
	public WechatUser planToRemoveAnswerQuestionList(WechatUser wechatUser, String answerQuestionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, wechatUser.getId());
		key.put(AnswerQuestion.ID_PROPERTY, answerQuestionIds);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return wechatUser;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return wechatUser;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){

			answerQuestionItem.clearFromAll();
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return wechatUser;	
	
	}


	//disconnect WechatUser with user_answer in AnswerQuestion
	public WechatUser planToRemoveAnswerQuestionListWithUserAnswer(WechatUser wechatUser, String userAnswerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, wechatUser.getId());
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return wechatUser;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return wechatUser;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearUserAnswer();
			answerQuestionItem.clearUser();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return wechatUser;
	}
	
	public int countAnswerQuestionListWithUserAnswer(String wechatUserId, String userAnswerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, wechatUserId);
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	
	//disconnect WechatUser with change_request in AnswerQuestion
	public WechatUser planToRemoveAnswerQuestionListWithChangeRequest(WechatUser wechatUser, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, wechatUser.getId());
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return wechatUser;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return wechatUser;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearChangeRequest();
			answerQuestionItem.clearUser();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return wechatUser;
	}
	
	public int countAnswerQuestionListWithChangeRequest(String wechatUserId, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, wechatUserId);
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	
	public WechatUser planToRemoveWechatLoginInfoList(WechatUser wechatUser, String wechatLoginInfoIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUser.getId());
		key.put(WechatLoginInfo.ID_PROPERTY, wechatLoginInfoIds);
		
		SmartList<WechatLoginInfo> externalWechatLoginInfoList = getWechatLoginInfoDAO().
				findWechatLoginInfoWithKey(key, options);
		if(externalWechatLoginInfoList == null){
			return wechatUser;
		}
		if(externalWechatLoginInfoList.isEmpty()){
			return wechatUser;
		}
		
		for(WechatLoginInfo wechatLoginInfoItem: externalWechatLoginInfoList){

			wechatLoginInfoItem.clearFromAll();
		}
		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();		
		wechatLoginInfoList.addAllToRemoveList(externalWechatLoginInfoList);
		return wechatUser;	
	
	}


	//disconnect WechatUser with app_id in WechatLoginInfo
	public WechatUser planToRemoveWechatLoginInfoListWithAppId(WechatUser wechatUser, String appIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUser.getId());
		key.put(WechatLoginInfo.APP_ID_PROPERTY, appIdId);
		
		SmartList<WechatLoginInfo> externalWechatLoginInfoList = getWechatLoginInfoDAO().
				findWechatLoginInfoWithKey(key, options);
		if(externalWechatLoginInfoList == null){
			return wechatUser;
		}
		if(externalWechatLoginInfoList.isEmpty()){
			return wechatUser;
		}
		
		for(WechatLoginInfo wechatLoginInfoItem: externalWechatLoginInfoList){
			wechatLoginInfoItem.clearAppId();
			wechatLoginInfoItem.clearWechatUser();
			
		}
		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();		
		wechatLoginInfoList.addAllToRemoveList(externalWechatLoginInfoList);
		return wechatUser;
	}
	
	public int countWechatLoginInfoListWithAppId(String wechatUserId, String appIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUserId);
		key.put(WechatLoginInfo.APP_ID_PROPERTY, appIdId);
		
		int count = getWechatLoginInfoDAO().countWechatLoginInfoWithKey(key, options);
		return count;
	}
	
	//disconnect WechatUser with open_id in WechatLoginInfo
	public WechatUser planToRemoveWechatLoginInfoListWithOpenId(WechatUser wechatUser, String openIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUser.getId());
		key.put(WechatLoginInfo.OPEN_ID_PROPERTY, openIdId);
		
		SmartList<WechatLoginInfo> externalWechatLoginInfoList = getWechatLoginInfoDAO().
				findWechatLoginInfoWithKey(key, options);
		if(externalWechatLoginInfoList == null){
			return wechatUser;
		}
		if(externalWechatLoginInfoList.isEmpty()){
			return wechatUser;
		}
		
		for(WechatLoginInfo wechatLoginInfoItem: externalWechatLoginInfoList){
			wechatLoginInfoItem.clearOpenId();
			wechatLoginInfoItem.clearWechatUser();
			
		}
		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();		
		wechatLoginInfoList.addAllToRemoveList(externalWechatLoginInfoList);
		return wechatUser;
	}
	
	public int countWechatLoginInfoListWithOpenId(String wechatUserId, String openIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUserId);
		key.put(WechatLoginInfo.OPEN_ID_PROPERTY, openIdId);
		
		int count = getWechatLoginInfoDAO().countWechatLoginInfoWithKey(key, options);
		return count;
	}
	
	public WechatUser planToRemoveExamList(WechatUser wechatUser, String examIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.USER_PROPERTY, wechatUser.getId());
		key.put(Exam.ID_PROPERTY, examIds);
		
		SmartList<Exam> externalExamList = getExamDAO().
				findExamWithKey(key, options);
		if(externalExamList == null){
			return wechatUser;
		}
		if(externalExamList.isEmpty()){
			return wechatUser;
		}
		
		for(Exam examItem: externalExamList){

			examItem.clearFromAll();
		}
		
		
		SmartList<Exam> examList = wechatUser.getExamList();		
		examList.addAllToRemoveList(externalExamList);
		return wechatUser;	
	
	}


	//disconnect WechatUser with status in Exam
	public WechatUser planToRemoveExamListWithStatus(WechatUser wechatUser, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.USER_PROPERTY, wechatUser.getId());
		key.put(Exam.STATUS_PROPERTY, statusId);
		
		SmartList<Exam> externalExamList = getExamDAO().
				findExamWithKey(key, options);
		if(externalExamList == null){
			return wechatUser;
		}
		if(externalExamList.isEmpty()){
			return wechatUser;
		}
		
		for(Exam examItem: externalExamList){
			examItem.clearStatus();
			examItem.clearUser();
			
		}
		
		
		SmartList<Exam> examList = wechatUser.getExamList();		
		examList.addAllToRemoveList(externalExamList);
		return wechatUser;
	}
	
	public int countExamListWithStatus(String wechatUserId, String statusId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.USER_PROPERTY, wechatUserId);
		key.put(Exam.STATUS_PROPERTY, statusId);
		
		int count = getExamDAO().countExamWithKey(key, options);
		return count;
	}
	
	public WechatUser planToRemoveFaultAnswerList(WechatUser wechatUser, String faultAnswerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.USER_PROPERTY, wechatUser.getId());
		key.put(FaultAnswer.ID_PROPERTY, faultAnswerIds);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return wechatUser;
		}
		if(externalFaultAnswerList.isEmpty()){
			return wechatUser;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){

			faultAnswerItem.clearFromAll();
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return wechatUser;	
	
	}


	//disconnect WechatUser with exam in FaultAnswer
	public WechatUser planToRemoveFaultAnswerListWithExam(WechatUser wechatUser, String examId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.USER_PROPERTY, wechatUser.getId());
		key.put(FaultAnswer.EXAM_PROPERTY, examId);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return wechatUser;
		}
		if(externalFaultAnswerList.isEmpty()){
			return wechatUser;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){
			faultAnswerItem.clearExam();
			faultAnswerItem.clearUser();
			
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return wechatUser;
	}
	
	public int countFaultAnswerListWithExam(String wechatUserId, String examId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.USER_PROPERTY, wechatUserId);
		key.put(FaultAnswer.EXAM_PROPERTY, examId);
		
		int count = getFaultAnswerDAO().countFaultAnswerWithKey(key, options);
		return count;
	}
	

		
	protected WechatUser saveStartExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		
		
		SmartList<StartExam> startExamList = wechatUser.getStartExamList();
		if(startExamList == null){
			//null list means nothing
			return wechatUser;
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
		
		
		return wechatUser;
	
	}
	
	protected WechatUser removeStartExamList(WechatUser wechatUser, Map<String,Object> options){
	
	
		SmartList<StartExam> startExamList = wechatUser.getStartExamList();
		if(startExamList == null){
			return wechatUser;
		}	
	
		SmartList<StartExam> toRemoveStartExamList = startExamList.getToRemoveList();
		
		if(toRemoveStartExamList == null){
			return wechatUser;
		}
		if(toRemoveStartExamList.isEmpty()){
			return wechatUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getStartExamDAO().removeStartExamList(toRemoveStartExamList,options);
		
		return wechatUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected WechatUser saveAnswerQuestionList(WechatUser wechatUser, Map<String,Object> options){
		
		
		
		
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();
		if(answerQuestionList == null){
			//null list means nothing
			return wechatUser;
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
		
		
		return wechatUser;
	
	}
	
	protected WechatUser removeAnswerQuestionList(WechatUser wechatUser, Map<String,Object> options){
	
	
		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();
		if(answerQuestionList == null){
			return wechatUser;
		}	
	
		SmartList<AnswerQuestion> toRemoveAnswerQuestionList = answerQuestionList.getToRemoveList();
		
		if(toRemoveAnswerQuestionList == null){
			return wechatUser;
		}
		if(toRemoveAnswerQuestionList.isEmpty()){
			return wechatUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAnswerQuestionDAO().removeAnswerQuestionList(toRemoveAnswerQuestionList,options);
		
		return wechatUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected WechatUser saveWechatLoginInfoList(WechatUser wechatUser, Map<String,Object> options){
		
		
		
		
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();
		if(wechatLoginInfoList == null){
			//null list means nothing
			return wechatUser;
		}
		SmartList<WechatLoginInfo> mergedUpdateWechatLoginInfoList = new SmartList<WechatLoginInfo>();
		
		
		mergedUpdateWechatLoginInfoList.addAll(wechatLoginInfoList); 
		if(wechatLoginInfoList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWechatLoginInfoList.addAll(wechatLoginInfoList.getToRemoveList());
			wechatLoginInfoList.removeAll(wechatLoginInfoList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getWechatLoginInfoDAO().saveWechatLoginInfoList(mergedUpdateWechatLoginInfoList,options);
		
		if(wechatLoginInfoList.getToRemoveList() != null){
			wechatLoginInfoList.removeAll(wechatLoginInfoList.getToRemoveList());
		}
		
		
		return wechatUser;
	
	}
	
	protected WechatUser removeWechatLoginInfoList(WechatUser wechatUser, Map<String,Object> options){
	
	
		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();
		if(wechatLoginInfoList == null){
			return wechatUser;
		}	
	
		SmartList<WechatLoginInfo> toRemoveWechatLoginInfoList = wechatLoginInfoList.getToRemoveList();
		
		if(toRemoveWechatLoginInfoList == null){
			return wechatUser;
		}
		if(toRemoveWechatLoginInfoList.isEmpty()){
			return wechatUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWechatLoginInfoDAO().removeWechatLoginInfoList(toRemoveWechatLoginInfoList,options);
		
		return wechatUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected WechatUser saveExamList(WechatUser wechatUser, Map<String,Object> options){
		
		
		
		
		SmartList<Exam> examList = wechatUser.getExamList();
		if(examList == null){
			//null list means nothing
			return wechatUser;
		}
		SmartList<Exam> mergedUpdateExamList = new SmartList<Exam>();
		
		
		mergedUpdateExamList.addAll(examList); 
		if(examList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExamList.addAll(examList.getToRemoveList());
			examList.removeAll(examList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExamDAO().saveExamList(mergedUpdateExamList,options);
		
		if(examList.getToRemoveList() != null){
			examList.removeAll(examList.getToRemoveList());
		}
		
		
		return wechatUser;
	
	}
	
	protected WechatUser removeExamList(WechatUser wechatUser, Map<String,Object> options){
	
	
		SmartList<Exam> examList = wechatUser.getExamList();
		if(examList == null){
			return wechatUser;
		}	
	
		SmartList<Exam> toRemoveExamList = examList.getToRemoveList();
		
		if(toRemoveExamList == null){
			return wechatUser;
		}
		if(toRemoveExamList.isEmpty()){
			return wechatUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExamDAO().removeExamList(toRemoveExamList,options);
		
		return wechatUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected WechatUser saveFaultAnswerList(WechatUser wechatUser, Map<String,Object> options){
		
		
		
		
		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();
		if(faultAnswerList == null){
			//null list means nothing
			return wechatUser;
		}
		SmartList<FaultAnswer> mergedUpdateFaultAnswerList = new SmartList<FaultAnswer>();
		
		
		mergedUpdateFaultAnswerList.addAll(faultAnswerList); 
		if(faultAnswerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFaultAnswerList.addAll(faultAnswerList.getToRemoveList());
			faultAnswerList.removeAll(faultAnswerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFaultAnswerDAO().saveFaultAnswerList(mergedUpdateFaultAnswerList,options);
		
		if(faultAnswerList.getToRemoveList() != null){
			faultAnswerList.removeAll(faultAnswerList.getToRemoveList());
		}
		
		
		return wechatUser;
	
	}
	
	protected WechatUser removeFaultAnswerList(WechatUser wechatUser, Map<String,Object> options){
	
	
		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();
		if(faultAnswerList == null){
			return wechatUser;
		}	
	
		SmartList<FaultAnswer> toRemoveFaultAnswerList = faultAnswerList.getToRemoveList();
		
		if(toRemoveFaultAnswerList == null){
			return wechatUser;
		}
		if(toRemoveFaultAnswerList.isEmpty()){
			return wechatUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFaultAnswerDAO().removeFaultAnswerList(toRemoveFaultAnswerList,options);
		
		return wechatUser;
	
	}
	
	

 	
 	
	
	
	
		

	public WechatUser present(WechatUser wechatUser,Map<String, Object> options){
	
		presentStartExamList(wechatUser,options);
		presentAnswerQuestionList(wechatUser,options);
		presentWechatLoginInfoList(wechatUser,options);
		presentExamList(wechatUser,options);
		presentFaultAnswerList(wechatUser,options);

		return wechatUser;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected WechatUser presentStartExamList(
			WechatUser wechatUser,
			Map<String, Object> options) {

		SmartList<StartExam> startExamList = wechatUser.getStartExamList();		
				SmartList<StartExam> newList= presentSubList(wechatUser.getId(),
				startExamList,
				options,
				getStartExamDAO()::countStartExamByUser,
				getStartExamDAO()::findStartExamByUser
				);

		
		wechatUser.setStartExamList(newList);
		

		return wechatUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected WechatUser presentAnswerQuestionList(
			WechatUser wechatUser,
			Map<String, Object> options) {

		SmartList<AnswerQuestion> answerQuestionList = wechatUser.getAnswerQuestionList();		
				SmartList<AnswerQuestion> newList= presentSubList(wechatUser.getId(),
				answerQuestionList,
				options,
				getAnswerQuestionDAO()::countAnswerQuestionByUser,
				getAnswerQuestionDAO()::findAnswerQuestionByUser
				);

		
		wechatUser.setAnswerQuestionList(newList);
		

		return wechatUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected WechatUser presentWechatLoginInfoList(
			WechatUser wechatUser,
			Map<String, Object> options) {

		SmartList<WechatLoginInfo> wechatLoginInfoList = wechatUser.getWechatLoginInfoList();		
				SmartList<WechatLoginInfo> newList= presentSubList(wechatUser.getId(),
				wechatLoginInfoList,
				options,
				getWechatLoginInfoDAO()::countWechatLoginInfoByWechatUser,
				getWechatLoginInfoDAO()::findWechatLoginInfoByWechatUser
				);

		
		wechatUser.setWechatLoginInfoList(newList);
		

		return wechatUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected WechatUser presentExamList(
			WechatUser wechatUser,
			Map<String, Object> options) {

		SmartList<Exam> examList = wechatUser.getExamList();		
				SmartList<Exam> newList= presentSubList(wechatUser.getId(),
				examList,
				options,
				getExamDAO()::countExamByUser,
				getExamDAO()::findExamByUser
				);

		
		wechatUser.setExamList(newList);
		

		return wechatUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected WechatUser presentFaultAnswerList(
			WechatUser wechatUser,
			Map<String, Object> options) {

		SmartList<FaultAnswer> faultAnswerList = wechatUser.getFaultAnswerList();		
				SmartList<FaultAnswer> newList= presentSubList(wechatUser.getId(),
				faultAnswerList,
				options,
				getFaultAnswerDAO()::countFaultAnswerByUser,
				getFaultAnswerDAO()::findFaultAnswerByUser
				);

		
		wechatUser.setFaultAnswerList(newList);
		

		return wechatUser;
	}			
		

	
    public SmartList<WechatUser> requestCandidateWechatUserForStartExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WechatUserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getWechatUserMapper());
    }
		
    public SmartList<WechatUser> requestCandidateWechatUserForAnswerQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WechatUserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getWechatUserMapper());
    }
		
    public SmartList<WechatUser> requestCandidateWechatUserForWechatLoginInfo(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WechatUserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getWechatUserMapper());
    }
		
    public SmartList<WechatUser> requestCandidateWechatUserForExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WechatUserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getWechatUserMapper());
    }
		
    public SmartList<WechatUser> requestCandidateWechatUserForFaultAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(WechatUserTable.COLUMN_NAME, filterKey, pageNo, pageSize, getWechatUserMapper());
    }
		

	protected String getTableName(){
		return WechatUserTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<WechatUser> wechatUserList) {		
		this.enhanceListInternal(wechatUserList, this.getWechatUserMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:StartExam的user的StartExamList
	public SmartList<StartExam> loadOurStartExamList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(StartExam.USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<StartExam> loadedObjs = userContext.getDAOGroup().getStartExamDAO().findStartExamWithKey(key, options);
		Map<String, List<StartExam>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUser().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:AnswerQuestion的user的AnswerQuestionList
	public SmartList<AnswerQuestion> loadOurAnswerQuestionList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AnswerQuestion> loadedObjs = userContext.getDAOGroup().getAnswerQuestionDAO().findAnswerQuestionWithKey(key, options);
		Map<String, List<AnswerQuestion>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUser().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:WechatLoginInfo的wechatUser的WechatLoginInfoList
	public SmartList<WechatLoginInfo> loadOurWechatLoginInfoList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatLoginInfo.WECHAT_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<WechatLoginInfo> loadedObjs = userContext.getDAOGroup().getWechatLoginInfoDAO().findWechatLoginInfoWithKey(key, options);
		Map<String, List<WechatLoginInfo>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getWechatUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<WechatLoginInfo> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<WechatLoginInfo> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWechatLoginInfoList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:Exam的user的ExamList
	public SmartList<Exam> loadOurExamList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Exam> loadedObjs = userContext.getDAOGroup().getExamDAO().findExamWithKey(key, options);
		Map<String, List<Exam>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Exam> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Exam> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExamList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:FaultAnswer的user的FaultAnswerList
	public SmartList<FaultAnswer> loadOurFaultAnswerList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<FaultAnswer> loadedObjs = userContext.getDAOGroup().getFaultAnswerDAO().findFaultAnswerWithKey(key, options);
		Map<String, List<FaultAnswer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<FaultAnswer> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<FaultAnswer> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setFaultAnswerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatUser> wechatUserList = ownerEntity.collectRefsWithType(WechatUser.INTERNAL_TYPE);
		this.enhanceList(wechatUserList);
		
	}
	
	@Override
	public SmartList<WechatUser> findWechatUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getWechatUserMapper());

	}
	@Override
	public int countWechatUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<WechatUser> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatUserMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


