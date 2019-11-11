
package com.doublechaintech.bcex.question;

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


import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;

import com.doublechaintech.bcex.faultanswer.FaultAnswerDAO;
import com.doublechaintech.bcex.useranswer.UserAnswerDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.answer.AnswerDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class QuestionJDBCTemplateDAO extends BcexBaseDAOImpl implements QuestionDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  AnswerDAO  answerDAO;
 	public void setAnswerDAO(AnswerDAO pAnswerDAO){
 	
 		if(pAnswerDAO == null){
 			throw new IllegalStateException("Do not try to set answerDAO to null.");
 		}
	 	this.answerDAO = pAnswerDAO;
 	}
 	public AnswerDAO getAnswerDAO(){
 		if(this.answerDAO == null){
 			throw new IllegalStateException("The answerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.answerDAO;
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
	protected Question load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalQuestion(accessKey, options);
	}
	*/
	
	public SmartList<Question> loadAll() {
	    return this.loadAll(getQuestionMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Question load(String id,Map<String,Object> options) throws Exception{
		return loadInternalQuestion(QuestionTable.withId(id), options);
	}
	
	
	
	public Question save(Question question,Map<String,Object> options){
		
		String methodName="save(Question question,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(question, methodName, "question");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalQuestion(question,options);
	}
	public Question clone(String questionId, Map<String,Object> options) throws Exception{
	
		return clone(QuestionTable.withId(questionId),options);
	}
	
	protected Question clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String questionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Question newQuestion = loadInternalQuestion(accessKey, options);
		newQuestion.setVersion(0);
		
		
 		
 		if(isSaveAnswerListEnabled(options)){
 			for(Answer item: newQuestion.getAnswerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveUserAnswerListEnabled(options)){
 			for(UserAnswer item: newQuestion.getUserAnswerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFaultAnswerListEnabled(options)){
 			for(FaultAnswer item: newQuestion.getFaultAnswerList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalQuestion(newQuestion,options);
		
		return newQuestion;
	}
	
	
	
	

	protected void throwIfHasException(String questionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new QuestionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new QuestionNotFoundException(
					"The " + this.getTableName() + "(" + questionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String questionId, int version) throws Exception{
	
		String methodName="delete(String questionId, int version)";
		assertMethodArgumentNotNull(questionId, methodName, "questionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{questionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(questionId,version);
		}
		
	
	}
	
	
	
	
	

	public Question disconnectFromAll(String questionId, int version) throws Exception{
	
		
		Question question = loadInternalQuestion(QuestionTable.withId(questionId), emptyOptions());
		question.clearFromAll();
		this.saveQuestion(question);
		return question;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return QuestionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "question";
	}
	@Override
	protected String getBeanName() {
		
		return "question";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return QuestionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, QuestionTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, QuestionTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,QuestionTokens.ANSWER_LIST);
 	}
 	protected boolean isAnalyzeAnswerListEnabled(Map<String,Object> options){		 		
 		return QuestionTokens.of(options).analyzeAnswerListEnabled();
 	}
	
	protected boolean isSaveAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, QuestionTokens.ANSWER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractUserAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,QuestionTokens.USER_ANSWER_LIST);
 	}
 	protected boolean isAnalyzeUserAnswerListEnabled(Map<String,Object> options){		 		
 		return QuestionTokens.of(options).analyzeUserAnswerListEnabled();
 	}
	
	protected boolean isSaveUserAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, QuestionTokens.USER_ANSWER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFaultAnswerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,QuestionTokens.FAULT_ANSWER_LIST);
 	}
 	protected boolean isAnalyzeFaultAnswerListEnabled(Map<String,Object> options){		 		
 		return QuestionTokens.of(options).analyzeFaultAnswerListEnabled();
 	}
	
	protected boolean isSaveFaultAnswerListEnabled(Map<String,Object> options){
		return checkOptions(options, QuestionTokens.FAULT_ANSWER_LIST);
		
 	}
 	
		

	

	protected QuestionMapper getQuestionMapper(){
		return new QuestionMapper();
	}

	
	
	protected Question extractQuestion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Question question = loadSingleObject(accessKey, getQuestionMapper());
			return question;
		}catch(EmptyResultDataAccessException e){
			throw new QuestionNotFoundException("Question("+accessKey+") is not found!");
		}

	}

	
	

	protected Question loadInternalQuestion(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Question question = extractQuestion(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(question, loadOptions);
 		}
 
		
		if(isExtractAnswerListEnabled(loadOptions)){
	 		extractAnswerList(question, loadOptions);
 		}	
 		if(isAnalyzeAnswerListEnabled(loadOptions)){
	 		analyzeAnswerList(question, loadOptions);
 		}
 		
		
		if(isExtractUserAnswerListEnabled(loadOptions)){
	 		extractUserAnswerList(question, loadOptions);
 		}	
 		if(isAnalyzeUserAnswerListEnabled(loadOptions)){
	 		analyzeUserAnswerList(question, loadOptions);
 		}
 		
		
		if(isExtractFaultAnswerListEnabled(loadOptions)){
	 		extractFaultAnswerList(question, loadOptions);
 		}	
 		if(isAnalyzeFaultAnswerListEnabled(loadOptions)){
	 		analyzeFaultAnswerList(question, loadOptions);
 		}
 		
		
		return question;
		
	}

	 

 	protected Question extractPlatform(Question question, Map<String,Object> options) throws Exception{

		if(question.getPlatform() == null){
			return question;
		}
		String platformId = question.getPlatform().getId();
		if( platformId == null){
			return question;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			question.setPlatform(platform);
		}
		
 		
 		return question;
 	}
 		
 
		
	protected void enhanceAnswerList(SmartList<Answer> answerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Question extractAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<Answer> answerList = getAnswerDAO().findAnswerByQuestion(question.getId(),options);
		if(answerList != null){
			enhanceAnswerList(answerList,options);
			question.setAnswerList(answerList);
		}
		
		return question;
	
	}	
	
	protected Question analyzeAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<Answer> answerList = question.getAnswerList();
		if(answerList != null){
			getAnswerDAO().analyzeAnswerByQuestion(answerList, question.getId(), options);
			
		}
		
		return question;
	
	}	
	
		
	protected void enhanceUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Question extractUserAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<UserAnswer> userAnswerList = getUserAnswerDAO().findUserAnswerByQuestion(question.getId(),options);
		if(userAnswerList != null){
			enhanceUserAnswerList(userAnswerList,options);
			question.setUserAnswerList(userAnswerList);
		}
		
		return question;
	
	}	
	
	protected Question analyzeUserAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();
		if(userAnswerList != null){
			getUserAnswerDAO().analyzeUserAnswerByQuestion(userAnswerList, question.getId(), options);
			
		}
		
		return question;
	
	}	
	
		
	protected void enhanceFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected Question extractFaultAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = getFaultAnswerDAO().findFaultAnswerByQuestion(question.getId(),options);
		if(faultAnswerList != null){
			enhanceFaultAnswerList(faultAnswerList,options);
			question.setFaultAnswerList(faultAnswerList);
		}
		
		return question;
	
	}	
	
	protected Question analyzeFaultAnswerList(Question question, Map<String,Object> options){
		
		
		if(question == null){
			return null;
		}
		if(question.getId() == null){
			return question;
		}

		
		
		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();
		if(faultAnswerList != null){
			getFaultAnswerDAO().analyzeFaultAnswerByQuestion(faultAnswerList, question.getId(), options);
			
		}
		
		return question;
	
	}	
	
		
		
  	
 	public SmartList<Question> findQuestionByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<Question> resultList = queryWith(QuestionTable.COLUMN_PLATFORM, platformId, options, getQuestionMapper());
		// analyzeQuestionByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Question> findQuestionByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Question> resultList =  queryWithRange(QuestionTable.COLUMN_PLATFORM, platformId, options, getQuestionMapper(), start, count);
 		//analyzeQuestionByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeQuestionByPlatform(SmartList<Question> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countQuestionByPlatform(String platformId,Map<String,Object> options){

 		return countWith(QuestionTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countQuestionByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(QuestionTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected Question saveQuestion(Question  question){
		
		if(!question.isChanged()){
			return question;
		}
		
		
		String SQL=this.getSaveQuestionSQL(question);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveQuestionParameters(question);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		question.incVersion();
		return question;
	
	}
	public SmartList<Question> saveQuestionList(SmartList<Question> questionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitQuestionList(questionList);
		
		batchQuestionCreate((List<Question>)lists[CREATE_LIST_INDEX]);
		
		batchQuestionUpdate((List<Question>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Question question:questionList){
			if(question.isChanged()){
				question.incVersion();
			}
			
		
		}
		
		
		return questionList;
	}

	public SmartList<Question> removeQuestionList(SmartList<Question> questionList,Map<String,Object> options){
		
		
		super.removeList(questionList, options);
		
		return questionList;
		
		
	}
	
	protected List<Object[]> prepareQuestionBatchCreateArgs(List<Question> questionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Question question:questionList ){
			Object [] parameters = prepareQuestionCreateParameters(question);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareQuestionBatchUpdateArgs(List<Question> questionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Question question:questionList ){
			if(!question.isChanged()){
				continue;
			}
			Object [] parameters = prepareQuestionUpdateParameters(question);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchQuestionCreate(List<Question> questionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareQuestionBatchCreateArgs(questionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchQuestionUpdate(List<Question> questionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareQuestionBatchUpdateArgs(questionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitQuestionList(List<Question> questionList){
		
		List<Question> questionCreateList=new ArrayList<Question>();
		List<Question> questionUpdateList=new ArrayList<Question>();
		
		for(Question question: questionList){
			if(isUpdateRequest(question)){
				questionUpdateList.add( question);
				continue;
			}
			questionCreateList.add(question);
		}
		
		return new Object[]{questionCreateList,questionUpdateList};
	}
	
	protected boolean isUpdateRequest(Question question){
 		return question.getVersion() > 0;
 	}
 	protected String getSaveQuestionSQL(Question question){
 		if(isUpdateRequest(question)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveQuestionParameters(Question question){
 		if(isUpdateRequest(question) ){
 			return prepareQuestionUpdateParameters(question);
 		}
 		return prepareQuestionCreateParameters(question);
 	}
 	protected Object[] prepareQuestionUpdateParameters(Question question){
 		Object[] parameters = new Object[12];
 
 		parameters[0] = question.getTopic();
 		parameters[1] = question.getLevel();
 		parameters[2] = question.getOptionA();
 		parameters[3] = question.getOptionB();
 		parameters[4] = question.getOptionC();
 		parameters[5] = question.getOptionD();
 		parameters[6] = question.getOptionE();
 		parameters[7] = question.getRightAnswer(); 	
 		if(question.getPlatform() != null){
 			parameters[8] = question.getPlatform().getId();
 		}
 		
 		parameters[9] = question.nextVersion();
 		parameters[10] = question.getId();
 		parameters[11] = question.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareQuestionCreateParameters(Question question){
		Object[] parameters = new Object[10];
		String newQuestionId=getNextId();
		question.setId(newQuestionId);
		parameters[0] =  question.getId();
 
 		parameters[1] = question.getTopic();
 		parameters[2] = question.getLevel();
 		parameters[3] = question.getOptionA();
 		parameters[4] = question.getOptionB();
 		parameters[5] = question.getOptionC();
 		parameters[6] = question.getOptionD();
 		parameters[7] = question.getOptionE();
 		parameters[8] = question.getRightAnswer(); 	
 		if(question.getPlatform() != null){
 			parameters[9] = question.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Question saveInternalQuestion(Question question, Map<String,Object> options){
		
		saveQuestion(question);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(question, options);
 		}
 
		
		if(isSaveAnswerListEnabled(options)){
	 		saveAnswerList(question, options);
	 		//removeAnswerList(question, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveUserAnswerListEnabled(options)){
	 		saveUserAnswerList(question, options);
	 		//removeUserAnswerList(question, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFaultAnswerListEnabled(options)){
	 		saveFaultAnswerList(question, options);
	 		//removeFaultAnswerList(question, options);
	 		//Not delete the record
	 		
 		}		
		
		return question;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Question savePlatform(Question question, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(question.getPlatform() == null){
 			return question;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(question.getPlatform(),options);
 		return question;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public Question planToRemoveAnswerList(Question question, String answerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Answer.QUESTION_PROPERTY, question.getId());
		key.put(Answer.ID_PROPERTY, answerIds);
		
		SmartList<Answer> externalAnswerList = getAnswerDAO().
				findAnswerWithKey(key, options);
		if(externalAnswerList == null){
			return question;
		}
		if(externalAnswerList.isEmpty()){
			return question;
		}
		
		for(Answer answerItem: externalAnswerList){

			answerItem.clearFromAll();
		}
		
		
		SmartList<Answer> answerList = question.getAnswerList();		
		answerList.addAllToRemoveList(externalAnswerList);
		return question;	
	
	}


	public Question planToRemoveUserAnswerList(Question question, String userAnswerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.QUESTION_PROPERTY, question.getId());
		key.put(UserAnswer.ID_PROPERTY, userAnswerIds);
		
		SmartList<UserAnswer> externalUserAnswerList = getUserAnswerDAO().
				findUserAnswerWithKey(key, options);
		if(externalUserAnswerList == null){
			return question;
		}
		if(externalUserAnswerList.isEmpty()){
			return question;
		}
		
		for(UserAnswer userAnswerItem: externalUserAnswerList){

			userAnswerItem.clearFromAll();
		}
		
		
		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();		
		userAnswerList.addAllToRemoveList(externalUserAnswerList);
		return question;	
	
	}


	//disconnect Question with exam in UserAnswer
	public Question planToRemoveUserAnswerListWithExam(Question question, String examId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.QUESTION_PROPERTY, question.getId());
		key.put(UserAnswer.EXAM_PROPERTY, examId);
		
		SmartList<UserAnswer> externalUserAnswerList = getUserAnswerDAO().
				findUserAnswerWithKey(key, options);
		if(externalUserAnswerList == null){
			return question;
		}
		if(externalUserAnswerList.isEmpty()){
			return question;
		}
		
		for(UserAnswer userAnswerItem: externalUserAnswerList){
			userAnswerItem.clearExam();
			userAnswerItem.clearQuestion();
			
		}
		
		
		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();		
		userAnswerList.addAllToRemoveList(externalUserAnswerList);
		return question;
	}
	
	public int countUserAnswerListWithExam(String questionId, String examId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.QUESTION_PROPERTY, questionId);
		key.put(UserAnswer.EXAM_PROPERTY, examId);
		
		int count = getUserAnswerDAO().countUserAnswerWithKey(key, options);
		return count;
	}
	
	public Question planToRemoveFaultAnswerList(Question question, String faultAnswerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.QUESTION_PROPERTY, question.getId());
		key.put(FaultAnswer.ID_PROPERTY, faultAnswerIds);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return question;
		}
		if(externalFaultAnswerList.isEmpty()){
			return question;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){

			faultAnswerItem.clearFromAll();
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return question;	
	
	}


	//disconnect Question with user in FaultAnswer
	public Question planToRemoveFaultAnswerListWithUser(Question question, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.QUESTION_PROPERTY, question.getId());
		key.put(FaultAnswer.USER_PROPERTY, userId);
		
		SmartList<FaultAnswer> externalFaultAnswerList = getFaultAnswerDAO().
				findFaultAnswerWithKey(key, options);
		if(externalFaultAnswerList == null){
			return question;
		}
		if(externalFaultAnswerList.isEmpty()){
			return question;
		}
		
		for(FaultAnswer faultAnswerItem: externalFaultAnswerList){
			faultAnswerItem.clearUser();
			faultAnswerItem.clearQuestion();
			
		}
		
		
		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();		
		faultAnswerList.addAllToRemoveList(externalFaultAnswerList);
		return question;
	}
	
	public int countFaultAnswerListWithUser(String questionId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.QUESTION_PROPERTY, questionId);
		key.put(FaultAnswer.USER_PROPERTY, userId);
		
		int count = getFaultAnswerDAO().countFaultAnswerWithKey(key, options);
		return count;
	}
	

		
	protected Question saveAnswerList(Question question, Map<String,Object> options){
		
		
		
		
		SmartList<Answer> answerList = question.getAnswerList();
		if(answerList == null){
			//null list means nothing
			return question;
		}
		SmartList<Answer> mergedUpdateAnswerList = new SmartList<Answer>();
		
		
		mergedUpdateAnswerList.addAll(answerList); 
		if(answerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateAnswerList.addAll(answerList.getToRemoveList());
			answerList.removeAll(answerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getAnswerDAO().saveAnswerList(mergedUpdateAnswerList,options);
		
		if(answerList.getToRemoveList() != null){
			answerList.removeAll(answerList.getToRemoveList());
		}
		
		
		return question;
	
	}
	
	protected Question removeAnswerList(Question question, Map<String,Object> options){
	
	
		SmartList<Answer> answerList = question.getAnswerList();
		if(answerList == null){
			return question;
		}	
	
		SmartList<Answer> toRemoveAnswerList = answerList.getToRemoveList();
		
		if(toRemoveAnswerList == null){
			return question;
		}
		if(toRemoveAnswerList.isEmpty()){
			return question;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAnswerDAO().removeAnswerList(toRemoveAnswerList,options);
		
		return question;
	
	}
	
	

 	
 	
	
	
	
		
	protected Question saveUserAnswerList(Question question, Map<String,Object> options){
		
		
		
		
		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();
		if(userAnswerList == null){
			//null list means nothing
			return question;
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
		
		
		return question;
	
	}
	
	protected Question removeUserAnswerList(Question question, Map<String,Object> options){
	
	
		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();
		if(userAnswerList == null){
			return question;
		}	
	
		SmartList<UserAnswer> toRemoveUserAnswerList = userAnswerList.getToRemoveList();
		
		if(toRemoveUserAnswerList == null){
			return question;
		}
		if(toRemoveUserAnswerList.isEmpty()){
			return question;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAnswerDAO().removeUserAnswerList(toRemoveUserAnswerList,options);
		
		return question;
	
	}
	
	

 	
 	
	
	
	
		
	protected Question saveFaultAnswerList(Question question, Map<String,Object> options){
		
		
		
		
		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();
		if(faultAnswerList == null){
			//null list means nothing
			return question;
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
		
		
		return question;
	
	}
	
	protected Question removeFaultAnswerList(Question question, Map<String,Object> options){
	
	
		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();
		if(faultAnswerList == null){
			return question;
		}	
	
		SmartList<FaultAnswer> toRemoveFaultAnswerList = faultAnswerList.getToRemoveList();
		
		if(toRemoveFaultAnswerList == null){
			return question;
		}
		if(toRemoveFaultAnswerList.isEmpty()){
			return question;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFaultAnswerDAO().removeFaultAnswerList(toRemoveFaultAnswerList,options);
		
		return question;
	
	}
	
	

 	
 	
	
	
	
		

	public Question present(Question question,Map<String, Object> options){
	
		presentAnswerList(question,options);
		presentUserAnswerList(question,options);
		presentFaultAnswerList(question,options);

		return question;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected Question presentAnswerList(
			Question question,
			Map<String, Object> options) {

		SmartList<Answer> answerList = question.getAnswerList();		
				SmartList<Answer> newList= presentSubList(question.getId(),
				answerList,
				options,
				getAnswerDAO()::countAnswerByQuestion,
				getAnswerDAO()::findAnswerByQuestion
				);

		
		question.setAnswerList(newList);
		

		return question;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Question presentUserAnswerList(
			Question question,
			Map<String, Object> options) {

		SmartList<UserAnswer> userAnswerList = question.getUserAnswerList();		
				SmartList<UserAnswer> newList= presentSubList(question.getId(),
				userAnswerList,
				options,
				getUserAnswerDAO()::countUserAnswerByQuestion,
				getUserAnswerDAO()::findUserAnswerByQuestion
				);

		
		question.setUserAnswerList(newList);
		

		return question;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected Question presentFaultAnswerList(
			Question question,
			Map<String, Object> options) {

		SmartList<FaultAnswer> faultAnswerList = question.getFaultAnswerList();		
				SmartList<FaultAnswer> newList= presentSubList(question.getId(),
				faultAnswerList,
				options,
				getFaultAnswerDAO()::countFaultAnswerByQuestion,
				getFaultAnswerDAO()::findFaultAnswerByQuestion
				);

		
		question.setFaultAnswerList(newList);
		

		return question;
	}			
		

	
    public SmartList<Question> requestCandidateQuestionForAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(QuestionTable.COLUMN_TOPIC, filterKey, pageNo, pageSize, getQuestionMapper());
    }
		
    public SmartList<Question> requestCandidateQuestionForUserAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(QuestionTable.COLUMN_TOPIC, filterKey, pageNo, pageSize, getQuestionMapper());
    }
		
    public SmartList<Question> requestCandidateQuestionForFaultAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(QuestionTable.COLUMN_TOPIC, filterKey, pageNo, pageSize, getQuestionMapper());
    }
		

	protected String getTableName(){
		return QuestionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Question> questionList) {		
		this.enhanceListInternal(questionList, this.getQuestionMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Answer的question的AnswerList
	public SmartList<Answer> loadOurAnswerList(BcexUserContext userContext, List<Question> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Answer.QUESTION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Answer> loadedObjs = userContext.getDAOGroup().getAnswerDAO().findAnswerWithKey(key, options);
		Map<String, List<Answer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getQuestion().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Answer> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Answer> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setAnswerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:UserAnswer的question的UserAnswerList
	public SmartList<UserAnswer> loadOurUserAnswerList(BcexUserContext userContext, List<Question> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserAnswer.QUESTION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<UserAnswer> loadedObjs = userContext.getDAOGroup().getUserAnswerDAO().findUserAnswerWithKey(key, options);
		Map<String, List<UserAnswer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getQuestion().getId()));
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
	
	// 需要一个加载引用我的对象的enhance方法:FaultAnswer的question的FaultAnswerList
	public SmartList<FaultAnswer> loadOurFaultAnswerList(BcexUserContext userContext, List<Question> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FaultAnswer.QUESTION_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<FaultAnswer> loadedObjs = userContext.getDAOGroup().getFaultAnswerDAO().findFaultAnswerWithKey(key, options);
		Map<String, List<FaultAnswer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getQuestion().getId()));
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
		List<Question> questionList = ownerEntity.collectRefsWithType(Question.INTERNAL_TYPE);
		this.enhanceList(questionList);
		
	}
	
	@Override
	public SmartList<Question> findQuestionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getQuestionMapper());

	}
	@Override
	public int countQuestionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countQuestionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Question> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getQuestionMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


