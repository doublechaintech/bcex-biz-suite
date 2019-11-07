
package com.doublechaintech.bcex.exam;

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
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.faultanswer.FaultAnswerDAO;
import com.doublechaintech.bcex.useranswer.UserAnswerDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.examstatus.ExamStatusDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ExamJDBCTemplateDAO extends BcexBaseDAOImpl implements ExamDAO{
 
 	
 	private  WechatUserDAO  wechatUserDAO;
 	public void setWechatUserDAO(WechatUserDAO wechatUserDAO){
	 	this.wechatUserDAO = wechatUserDAO;
 	}
 	public WechatUserDAO getWechatUserDAO(){
	 	return this.wechatUserDAO;
 	}
 
 	
 	private  ExamStatusDAO  examStatusDAO;
 	public void setExamStatusDAO(ExamStatusDAO examStatusDAO){
	 	this.examStatusDAO = examStatusDAO;
 	}
 	public ExamStatusDAO getExamStatusDAO(){
	 	return this.examStatusDAO;
 	}


			
		
	
  	private  UserAnswerDAO  userAnswerDAO;
 	public void setUserAnswerDAO(UserAnswerDAO pUserAnswerDAO){
 	
 		if(pUserAnswerDAO == null){
 			throw new IllegalStateException("Do not try to set userAnswerDAO to null.");
 		}
	 	this.userAnswerDAO = pUserAnswerDAO;
 	}
 	public UserAnswerDAO getUserAnswerDAO(){
 		if(this.userAnswerDAO == null){
 			throw new IllegalStateException("The userAnswerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAnswerDAO;
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
	protected Exam load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalExam(accessKey, options);
	}
	*/
	
	public SmartList<Exam> loadAll() {
	    return this.loadAll(getExamMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Exam load(String id,Map<String,Object> options) throws Exception{
		return loadInternalExam(ExamTable.withId(id), options);
	}
	
	
	
	public Exam save(Exam exam,Map<String,Object> options){
		
		String methodName="save(Exam exam,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(exam, methodName, "exam");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalExam(exam,options);
	}
	public Exam clone(String examId, Map<String,Object> options) throws Exception{
	
		return clone(ExamTable.withId(examId),options);
	}
	
	protected Exam clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String examId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Exam newExam = loadInternalExam(accessKey, options);
		newExam.setVersion(0);
		
		
 		
 		if(isSaveUserAnswerListEnabled(options)){
 			for(UserAnswer item: newExam.getUserAnswerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFaultAnswerListEnabled(options)){
 			for(FaultAnswer item: newExam.getFaultAnswerList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalExam(newExam,options);
		
		return newExam;
	}
	
	
	
	

	protected void throwIfHasException(String examId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ExamVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ExamNotFoundException(
					"The " + this.getTableName() + "(" + examId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String examId, int version) throws Exception{
	
		String methodName="delete(String examId, int version)";
		assertMethodArgumentNotNull(examId, methodName, "examId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{examId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(examId,version);
		}
		
	
	}
	
	
	
	
	

	public Exam disconnectFromAll(String examId, int version) throws Exception{
	
		
		Exam exam = loadInternalExam(ExamTable.withId(examId), emptyOptions());
		exam.clearFromAll();
		this.saveExam(exam);
		return exam;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ExamTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "exam";
	}
	@Override
	protected String getBeanName() {
		
		return "exam";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ExamTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractStatusEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExamTokens.STATUS);
 	}

 	protected boolean isSaveStatusEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExamTokens.STATUS);
 	}
 	

 	
  

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExamTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExamTokens.USER);
 	}
 	

 	
 
		
	
	protected boolean isExtractUserAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ExamTokens.USER_ANSWER_LIST);
 	}
 	protected boolean isAnalyzeUserAnswerListEnabled(Map<String,Object> options){		 		
 		return ExamTokens.of(options).analyzeUserAnswerListEnabled();
 	}
	
	protected boolean isSaveUserAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, ExamTokens.USER_ANSWER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFaultAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ExamTokens.FAULT_ANSWER_LIST);
 	}
 	protected boolean isAnalyzeFaultAnswerListEnabled(Map<String,Object> options){		 		
 		return ExamTokens.of(options).analyzeFaultAnswerListEnabled();
 	}
	
	protected boolean isSaveFaultAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, ExamTokens.FAULT_ANSWER_LIST);
		
 	}
 	
		

	

	protected ExamMapper getExamMapper(){
		return new ExamMapper();
	}

	
	
	protected Exam extractExam(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Exam exam = loadSingleObject(accessKey, getExamMapper());
			return exam;
		}catch(EmptyResultDataAccessException e){
			throw new ExamNotFoundException("Exam("+accessKey+") is not found!");
		}

	}

	
	

	protected Exam loadInternalExam(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Exam exam = extractExam(accessKey, loadOptions);
 	
 		if(isExtractStatusEnabled(loadOptions)){
	 		extractStatus(exam, loadOptions);
 		}
  	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(exam, loadOptions);
 		}
 
		
		if(isExtractUserAnswerListEnabled(loadOptions)){
	 		extractUserAnswerList(exam, loadOptions);
 		}	
 		if(isAnalyzeUserAnswerListEnabled(loadOptions)){
	 		analyzeUserAnswerList(exam, loadOptions);
 		}
 		
		
		if(isExtractFaultAnswerListEnabled(loadOptions)){
	 		extractFaultAnswerList(exam, loadOptions);
 		}	
 		if(isAnalyzeFaultAnswerListEnabled(loadOptions)){
	 		analyzeFaultAnswerList(exam, loadOptions);
 		}
 		
		
		return exam;
		
	}

	 

 	protected Exam extractStatus(Exam exam, Map<String,Object> options) throws Exception{

		if(exam.getStatus() == null){
			return exam;
		}
		String statusId = exam.getStatus().getId();
		if( statusId == null){
			return exam;
		}
		ExamStatus status = getExamStatusDAO().load(statusId,options);
		if(status != null){
			exam.setStatus(status);
		}
		
 		
 		return exam;
 	}
 		
  

 	protected Exam extractUser(Exam exam, Map<String,Object> options) throws Exception{

		if(exam.getUser() == null){
			return exam;
		}
		String userId = exam.getUser().getId();
		if( userId == null){
			return exam;
		}
		WechatUser user = getWechatUserDAO().load(userId,options);
		if(user != null){
			exam.setUser(user);
		}
		
 		
 		return exam;
 	}
 		
 
		
	protected void enhanceUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Exam extractUserAnswerList(Exam exam, Map<String,Object> options){
		
		
		if(exam == null){
			return null;
		}
		if(exam.getId() == null){
			return exam;
		}

		
		
		SmartList<UserAnswer> userAnswerList = getUserAnswerDAO().findUserAnswerByExam(exam.getId(),options);
		if(userAnswerList != null){
			enhanceUserAnswerList(userAnswerList,options);
			exam.setUserAnswerList(userAnswerList);
		}
		
		return exam;
	
	}	
	
	protected Exam analyzeUserAnswerList(Exam exam, Map<String,Object> options){
		
		
		if(exam == null){
			return null;
		}
		if(exam.getId() == null){
			return exam;
		}

		
		
		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();
		if(userAnswerList != null){
			getUserAnswerDAO().analyzeUserAnswerByExam(userAnswerList, exam.getId(), options);
			
		}
		
		return exam;
	
	}	
	
		
	protected void enhanceFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Exam extractFaultAnswerList(Exam exam, Map<String,Object> options){
		
		
		if(exam == null){
			return null;
		}
		if(exam.getId() == null){
			return exam;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = getFaultAnswerDAO().findFaultAnswerByExam(exam.getId(),options);
		if(faultAnswerList != null){
			enhanceFaultAnswerList(faultAnswerList,options);
			exam.setFaultAnswerList(faultAnswerList);
		}
		
		return exam;
	
	}	
	
	protected Exam analyzeFaultAnswerList(Exam exam, Map<String,Object> options){
		
		
		if(exam == null){
			return null;
		}
		if(exam.getId() == null){
			return exam;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();
		if(faultAnswerList != null){
			getFaultAnswerDAO().analyzeFaultAnswerByExam(faultAnswerList, exam.getId(), options);
			
		}
		
		return exam;
	
	}	
	
		
		
  	
 	public SmartList<Exam> findExamByStatus(String examStatusId,Map<String,Object> options){
 	
  		SmartList<Exam> resultList = queryWith(ExamTable.COLUMN_STATUS, examStatusId, options, getExamMapper());
		// analyzeExamByStatus(resultList, examStatusId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Exam> findExamByStatus(String examStatusId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Exam> resultList =  queryWithRange(ExamTable.COLUMN_STATUS, examStatusId, options, getExamMapper(), start, count);
 		//analyzeExamByStatus(resultList, examStatusId, options);
 		return resultList;
 		
 	}
 	public void analyzeExamByStatus(SmartList<Exam> resultList, String examStatusId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Exam.STATUS_PROPERTY, examStatusId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Exam.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("考试");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Exam.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Exam.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countExamByStatus(String examStatusId,Map<String,Object> options){

 		return countWith(ExamTable.COLUMN_STATUS, examStatusId, options);
 	}
 	@Override
	public Map<String, Integer> countExamByStatusIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExamTable.COLUMN_STATUS, ids, options);
	}
 	
  	
 	public SmartList<Exam> findExamByUser(String wechatUserId,Map<String,Object> options){
 	
  		SmartList<Exam> resultList = queryWith(ExamTable.COLUMN_USER, wechatUserId, options, getExamMapper());
		// analyzeExamByUser(resultList, wechatUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Exam> findExamByUser(String wechatUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Exam> resultList =  queryWithRange(ExamTable.COLUMN_USER, wechatUserId, options, getExamMapper(), start, count);
 		//analyzeExamByUser(resultList, wechatUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeExamByUser(SmartList<Exam> resultList, String wechatUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(Exam.USER_PROPERTY, wechatUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem createTimeStatsItem = new StatsItem();
		//Exam.CREATE_TIME_PROPERTY
		createTimeStatsItem.setDisplayName("考试");
		createTimeStatsItem.setInternalName(formatKeyForDateLine(Exam.CREATE_TIME_PROPERTY));
		createTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(Exam.CREATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(createTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countExamByUser(String wechatUserId,Map<String,Object> options){

 		return countWith(ExamTable.COLUMN_USER, wechatUserId, options);
 	}
 	@Override
	public Map<String, Integer> countExamByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExamTable.COLUMN_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected Exam saveExam(Exam  exam){
		
		if(!exam.isChanged()){
			return exam;
		}
		
		
		String SQL=this.getSaveExamSQL(exam);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveExamParameters(exam);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		exam.incVersion();
		return exam;
	
	}
	public SmartList<Exam> saveExamList(SmartList<Exam> examList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitExamList(examList);
		
		batchExamCreate((List<Exam>)lists[CREATE_LIST_INDEX]);
		
		batchExamUpdate((List<Exam>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Exam exam:examList){
			if(exam.isChanged()){
				exam.incVersion();
			}
			
		
		}
		
		
		return examList;
	}

	public SmartList<Exam> removeExamList(SmartList<Exam> examList,Map<String,Object> options){
		
		
		super.removeList(examList, options);
		
		return examList;
		
		
	}
	
	protected List<Object[]> prepareExamBatchCreateArgs(List<Exam> examList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Exam exam:examList ){
			Object [] parameters = prepareExamCreateParameters(exam);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareExamBatchUpdateArgs(List<Exam> examList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Exam exam:examList ){
			if(!exam.isChanged()){
				continue;
			}
			Object [] parameters = prepareExamUpdateParameters(exam);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchExamCreate(List<Exam> examList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareExamBatchCreateArgs(examList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchExamUpdate(List<Exam> examList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareExamBatchUpdateArgs(examList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitExamList(List<Exam> examList){
		
		List<Exam> examCreateList=new ArrayList<Exam>();
		List<Exam> examUpdateList=new ArrayList<Exam>();
		
		for(Exam exam: examList){
			if(isUpdateRequest(exam)){
				examUpdateList.add( exam);
				continue;
			}
			examCreateList.add(exam);
		}
		
		return new Object[]{examCreateList,examUpdateList};
	}
	
	protected boolean isUpdateRequest(Exam exam){
 		return exam.getVersion() > 0;
 	}
 	protected String getSaveExamSQL(Exam exam){
 		if(isUpdateRequest(exam)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveExamParameters(Exam exam){
 		if(isUpdateRequest(exam) ){
 			return prepareExamUpdateParameters(exam);
 		}
 		return prepareExamCreateParameters(exam);
 	}
 	protected Object[] prepareExamUpdateParameters(Exam exam){
 		Object[] parameters = new Object[8];
 
 		parameters[0] = exam.getName();
 		parameters[1] = exam.getCreateTime(); 	
 		if(exam.getStatus() != null){
 			parameters[2] = exam.getStatus().getId();
 		}
  	
 		if(exam.getUser() != null){
 			parameters[3] = exam.getUser().getId();
 		}
 
 		parameters[4] = exam.getScore();		
 		parameters[5] = exam.nextVersion();
 		parameters[6] = exam.getId();
 		parameters[7] = exam.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareExamCreateParameters(Exam exam){
		Object[] parameters = new Object[6];
		String newExamId=getNextId();
		exam.setId(newExamId);
		parameters[0] =  exam.getId();
 
 		parameters[1] = exam.getName();
 		parameters[2] = exam.getCreateTime(); 	
 		if(exam.getStatus() != null){
 			parameters[3] = exam.getStatus().getId();
 		
 		}
 		 	
 		if(exam.getUser() != null){
 			parameters[4] = exam.getUser().getId();
 		
 		}
 		
 		parameters[5] = exam.getScore();		
 				
 		return parameters;
 	}
 	
	protected Exam saveInternalExam(Exam exam, Map<String,Object> options){
		
		saveExam(exam);
 	
 		if(isSaveStatusEnabled(options)){
	 		saveStatus(exam, options);
 		}
  	
 		if(isSaveUserEnabled(options)){
	 		saveUser(exam, options);
 		}
 
		
		if(isSaveUserAnswerListEnabled(options)){
	 		saveUserAnswerList(exam, options);
	 		//removeUserAnswerList(exam, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFaultAnswerListEnabled(options)){
	 		saveFaultAnswerList(exam, options);
	 		//removeFaultAnswerList(exam, options);
	 		//Not delete the record
	 		
 		}		
		
		return exam;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Exam saveStatus(Exam exam, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(exam.getStatus() == null){
 			return exam;//do nothing when it is null
 		}
 		
 		getExamStatusDAO().save(exam.getStatus(),options);
 		return exam;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected Exam saveUser(Exam exam, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(exam.getUser() == null){
 			return exam;//do nothing when it is null
 		}
 		
 		getWechatUserDAO().save(exam.getUser(),options);
 		return exam;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Exam planToRemoveUserAnswerList(Exam exam, String userAnswerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.EXAM_PROPERTY, exam.getId());
		key.put(UserAnswer.ID_PROPERTY, userAnswerIds);
		
		SmartList<UserAnswer> externalUserAnswerList = getUserAnswerDAO().
				findUserAnswerWithKey(key, options);
		if(externalUserAnswerList == null){
			return exam;
		}
		if(externalUserAnswerList.isEmpty()){
			return exam;
		}
		
		for(UserAnswer userAnswerItem: externalUserAnswerList){

			userAnswerItem.clearFromAll();
		}
		
		
		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();		
		userAnswerList.addAllToRemoveList(externalUserAnswerList);
		return exam;	
	
	}


	//disconnect Exam with question in UserAnswer
	public Exam planToRemoveUserAnswerListWithQuestion(Exam exam, String questionId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.EXAM_PROPERTY, exam.getId());
		key.put(UserAnswer.QUESTION_PROPERTY, questionId);
		
		SmartList<UserAnswer> externalUserAnswerList = getUserAnswerDAO().
				findUserAnswerWithKey(key, options);
		if(externalUserAnswerList == null){
			return exam;
		}
		if(externalUserAnswerList.isEmpty()){
			return exam;
		}
		
		for(UserAnswer userAnswerItem: externalUserAnswerList){
			userAnswerItem.clearQuestion();
			userAnswerItem.clearExam();
			
		}
		
		
		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();		
		userAnswerList.addAllToRemoveList(externalUserAnswerList);
		return exam;
	}
	
	public int countUserAnswerListWithQuestion(String examId, String questionId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.EXAM_PROPERTY, examId);
		key.put(UserAnswer.QUESTION_PROPERTY, questionId);
		
		int count = getUserAnswerDAO().countUserAnswerWithKey(key, options);
		return count;
	}
	
	public Exam planToRemoveFaultAnswerList(Exam exam, String faultAnswerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.EXAM_PROPERTY, exam.getId());
		key.put(FaultAnswer.ID_PROPERTY, faultAnswerIds);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return exam;
		}
		if(externalFaultAnswerList.isEmpty()){
			return exam;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){

			faultAnswerItem.clearFromAll();
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return exam;	
	
	}


	//disconnect Exam with user in FaultAnswer
	public Exam planToRemoveFaultAnswerListWithUser(Exam exam, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.EXAM_PROPERTY, exam.getId());
		key.put(FaultAnswer.USER_PROPERTY, userId);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return exam;
		}
		if(externalFaultAnswerList.isEmpty()){
			return exam;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){
			faultAnswerItem.clearUser();
			faultAnswerItem.clearExam();
			
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return exam;
	}
	
	public int countFaultAnswerListWithUser(String examId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.EXAM_PROPERTY, examId);
		key.put(FaultAnswer.USER_PROPERTY, userId);
		
		int count = getFaultAnswerDAO().countFaultAnswerWithKey(key, options);
		return count;
	}
	

		
	protected Exam saveUserAnswerList(Exam exam, Map<String,Object> options){
		
		
		
		
		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();
		if(userAnswerList == null){
			//null list means nothing
			return exam;
		}
		SmartList<UserAnswer> mergedUpdateUserAnswerList = new SmartList<UserAnswer>();
		
		
		mergedUpdateUserAnswerList.addAll(userAnswerList); 
		if(userAnswerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAnswerList.addAll(userAnswerList.getToRemoveList());
			userAnswerList.removeAll(userAnswerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAnswerDAO().saveUserAnswerList(mergedUpdateUserAnswerList,options);
		
		if(userAnswerList.getToRemoveList() != null){
			userAnswerList.removeAll(userAnswerList.getToRemoveList());
		}
		
		
		return exam;
	
	}
	
	protected Exam removeUserAnswerList(Exam exam, Map<String,Object> options){
	
	
		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();
		if(userAnswerList == null){
			return exam;
		}	
	
		SmartList<UserAnswer> toRemoveUserAnswerList = userAnswerList.getToRemoveList();
		
		if(toRemoveUserAnswerList == null){
			return exam;
		}
		if(toRemoveUserAnswerList.isEmpty()){
			return exam;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAnswerDAO().removeUserAnswerList(toRemoveUserAnswerList,options);
		
		return exam;
	
	}
	
	

 	
 	
	
	
	
		
	protected Exam saveFaultAnswerList(Exam exam, Map<String,Object> options){
		
		
		
		
		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();
		if(faultAnswerList == null){
			//null list means nothing
			return exam;
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
		
		
		return exam;
	
	}
	
	protected Exam removeFaultAnswerList(Exam exam, Map<String,Object> options){
	
	
		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();
		if(faultAnswerList == null){
			return exam;
		}	
	
		SmartList<FaultAnswer> toRemoveFaultAnswerList = faultAnswerList.getToRemoveList();
		
		if(toRemoveFaultAnswerList == null){
			return exam;
		}
		if(toRemoveFaultAnswerList.isEmpty()){
			return exam;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFaultAnswerDAO().removeFaultAnswerList(toRemoveFaultAnswerList,options);
		
		return exam;
	
	}
	
	

 	
 	
	
	
	
		

	public Exam present(Exam exam,Map<String, Object> options){
	
		presentUserAnswerList(exam,options);
		presentFaultAnswerList(exam,options);

		return exam;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Exam presentUserAnswerList(
			Exam exam,
			Map<String, Object> options) {

		SmartList<UserAnswer> userAnswerList = exam.getUserAnswerList();		
				SmartList<UserAnswer> newList= presentSubList(exam.getId(),
				userAnswerList,
				options,
				getUserAnswerDAO()::countUserAnswerByExam,
				getUserAnswerDAO()::findUserAnswerByExam
				);

		
		exam.setUserAnswerList(newList);
		

		return exam;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Exam presentFaultAnswerList(
			Exam exam,
			Map<String, Object> options) {

		SmartList<FaultAnswer> faultAnswerList = exam.getFaultAnswerList();		
				SmartList<FaultAnswer> newList= presentSubList(exam.getId(),
				faultAnswerList,
				options,
				getFaultAnswerDAO()::countFaultAnswerByExam,
				getFaultAnswerDAO()::findFaultAnswerByExam
				);

		
		exam.setFaultAnswerList(newList);
		

		return exam;
	}			
		

	
    public SmartList<Exam> requestCandidateExamForUserAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ExamTable.COLUMN_NAME, filterKey, pageNo, pageSize, getExamMapper());
    }
		
    public SmartList<Exam> requestCandidateExamForFaultAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ExamTable.COLUMN_NAME, filterKey, pageNo, pageSize, getExamMapper());
    }
		

	protected String getTableName(){
		return ExamTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Exam> examList) {		
		this.enhanceListInternal(examList, this.getExamMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:UserAnswer的exam的UserAnswerList
	public SmartList<UserAnswer> loadOurUserAnswerList(BcexUserContext userContext, List<Exam> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.EXAM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<UserAnswer> loadedObjs = userContext.getDAOGroup().getUserAnswerDAO().findUserAnswerWithKey(key, options);
		Map<String, List<UserAnswer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getExam().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<UserAnswer> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<UserAnswer> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setUserAnswerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:FaultAnswer的exam的FaultAnswerList
	public SmartList<FaultAnswer> loadOurFaultAnswerList(BcexUserContext userContext, List<Exam> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.EXAM_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<FaultAnswer> loadedObjs = userContext.getDAOGroup().getFaultAnswerDAO().findFaultAnswerWithKey(key, options);
		Map<String, List<FaultAnswer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getExam().getId()));
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
		List<Exam> examList = ownerEntity.collectRefsWithType(Exam.INTERNAL_TYPE);
		this.enhanceList(examList);
		
	}
	
	@Override
	public SmartList<Exam> findExamWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getExamMapper());

	}
	@Override
	public int countExamWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countExamWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Exam> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getExamMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


