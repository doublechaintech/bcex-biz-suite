
package com.doublechaintech.bcex.useranswer;

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


import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.question.QuestionDAO;
import com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class UserAnswerJDBCTemplateDAO extends BcexBaseDAOImpl implements UserAnswerDAO{
 
 	
 	private  QuestionDAO  questionDAO;
 	public void setQuestionDAO(QuestionDAO questionDAO){
	 	this.questionDAO = questionDAO;
 	}
 	public QuestionDAO getQuestionDAO(){
	 	return this.questionDAO;
 	}
 
 	
 	private  ExamDAO  examDAO;
 	public void setExamDAO(ExamDAO examDAO){
	 	this.examDAO = examDAO;
 	}
 	public ExamDAO getExamDAO(){
	 	return this.examDAO;
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
	protected UserAnswer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalUserAnswer(accessKey, options);
	}
	*/
	
	public SmartList<UserAnswer> loadAll() {
	    return this.loadAll(getUserAnswerMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public UserAnswer load(String id,Map<String,Object> options) throws Exception{
		return loadInternalUserAnswer(UserAnswerTable.withId(id), options);
	}
	
	
	
	public UserAnswer save(UserAnswer userAnswer,Map<String,Object> options){
		
		String methodName="save(UserAnswer userAnswer,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(userAnswer, methodName, "userAnswer");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalUserAnswer(userAnswer,options);
	}
	public UserAnswer clone(String userAnswerId, Map<String,Object> options) throws Exception{
	
		return clone(UserAnswerTable.withId(userAnswerId),options);
	}
	
	protected UserAnswer clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String userAnswerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		UserAnswer newUserAnswer = loadInternalUserAnswer(accessKey, options);
		newUserAnswer.setVersion(0);
		
		
 		
 		if(isSaveAnswerQuestionListEnabled(options)){
 			for(AnswerQuestion item: newUserAnswer.getAnswerQuestionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalUserAnswer(newUserAnswer,options);
		
		return newUserAnswer;
	}
	
	
	
	

	protected void throwIfHasException(String userAnswerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new UserAnswerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new UserAnswerNotFoundException(
					"The " + this.getTableName() + "(" + userAnswerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String userAnswerId, int version) throws Exception{
	
		String methodName="delete(String userAnswerId, int version)";
		assertMethodArgumentNotNull(userAnswerId, methodName, "userAnswerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{userAnswerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(userAnswerId,version);
		}
		
	
	}
	
	
	
	
	

	public UserAnswer disconnectFromAll(String userAnswerId, int version) throws Exception{
	
		
		UserAnswer userAnswer = loadInternalUserAnswer(UserAnswerTable.withId(userAnswerId), emptyOptions());
		userAnswer.clearFromAll();
		this.saveUserAnswer(userAnswer);
		return userAnswer;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return UserAnswerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "user_answer";
	}
	@Override
	protected String getBeanName() {
		
		return "userAnswer";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return UserAnswerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractQuestionEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAnswerTokens.QUESTION);
 	}

 	protected boolean isSaveQuestionEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAnswerTokens.QUESTION);
 	}
 	

 	
  

 	protected boolean isExtractExamEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, UserAnswerTokens.EXAM);
 	}

 	protected boolean isSaveExamEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, UserAnswerTokens.EXAM);
 	}
 	

 	
 
		
	
	protected boolean isExtractAnswerQuestionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,UserAnswerTokens.ANSWER_QUESTION_LIST);
 	}
 	protected boolean isAnalyzeAnswerQuestionListEnabled(Map<String,Object> options){		 		
 		return UserAnswerTokens.of(options).analyzeAnswerQuestionListEnabled();
 	}
	
	protected boolean isSaveAnswerQuestionListEnabled(Map<String,Object> options){
		return checkOptions(options, UserAnswerTokens.ANSWER_QUESTION_LIST);
		
 	}
 	
		

	

	protected UserAnswerMapper getUserAnswerMapper(){
		return new UserAnswerMapper();
	}

	
	
	protected UserAnswer extractUserAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			UserAnswer userAnswer = loadSingleObject(accessKey, getUserAnswerMapper());
			return userAnswer;
		}catch(EmptyResultDataAccessException e){
			throw new UserAnswerNotFoundException("UserAnswer("+accessKey+") is not found!");
		}

	}

	
	

	protected UserAnswer loadInternalUserAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		UserAnswer userAnswer = extractUserAnswer(accessKey, loadOptions);
 	
 		if(isExtractQuestionEnabled(loadOptions)){
	 		extractQuestion(userAnswer, loadOptions);
 		}
  	
 		if(isExtractExamEnabled(loadOptions)){
	 		extractExam(userAnswer, loadOptions);
 		}
 
		
		if(isExtractAnswerQuestionListEnabled(loadOptions)){
	 		extractAnswerQuestionList(userAnswer, loadOptions);
 		}	
 		if(isAnalyzeAnswerQuestionListEnabled(loadOptions)){
	 		analyzeAnswerQuestionList(userAnswer, loadOptions);
 		}
 		
		
		return userAnswer;
		
	}

	 

 	protected UserAnswer extractQuestion(UserAnswer userAnswer, Map<String,Object> options) throws Exception{

		if(userAnswer.getQuestion() == null){
			return userAnswer;
		}
		String questionId = userAnswer.getQuestion().getId();
		if( questionId == null){
			return userAnswer;
		}
		Question question = getQuestionDAO().load(questionId,options);
		if(question != null){
			userAnswer.setQuestion(question);
		}
		
 		
 		return userAnswer;
 	}
 		
  

 	protected UserAnswer extractExam(UserAnswer userAnswer, Map<String,Object> options) throws Exception{

		if(userAnswer.getExam() == null){
			return userAnswer;
		}
		String examId = userAnswer.getExam().getId();
		if( examId == null){
			return userAnswer;
		}
		Exam exam = getExamDAO().load(examId,options);
		if(exam != null){
			userAnswer.setExam(exam);
		}
		
 		
 		return userAnswer;
 	}
 		
 
		
	protected void enhanceAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected UserAnswer extractAnswerQuestionList(UserAnswer userAnswer, Map<String,Object> options){
		
		
		if(userAnswer == null){
			return null;
		}
		if(userAnswer.getId() == null){
			return userAnswer;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = getAnswerQuestionDAO().findAnswerQuestionByUserAnswer(userAnswer.getId(),options);
		if(answerQuestionList != null){
			enhanceAnswerQuestionList(answerQuestionList,options);
			userAnswer.setAnswerQuestionList(answerQuestionList);
		}
		
		return userAnswer;
	
	}	
	
	protected UserAnswer analyzeAnswerQuestionList(UserAnswer userAnswer, Map<String,Object> options){
		
		
		if(userAnswer == null){
			return null;
		}
		if(userAnswer.getId() == null){
			return userAnswer;
		}

		
		
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();
		if(answerQuestionList != null){
			getAnswerQuestionDAO().analyzeAnswerQuestionByUserAnswer(answerQuestionList, userAnswer.getId(), options);
			
		}
		
		return userAnswer;
	
	}	
	
		
		
  	
 	public SmartList<UserAnswer> findUserAnswerByQuestion(String questionId,Map<String,Object> options){
 	
  		SmartList<UserAnswer> resultList = queryWith(UserAnswerTable.COLUMN_QUESTION, questionId, options, getUserAnswerMapper());
		// analyzeUserAnswerByQuestion(resultList, questionId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserAnswer> findUserAnswerByQuestion(String questionId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserAnswer> resultList =  queryWithRange(UserAnswerTable.COLUMN_QUESTION, questionId, options, getUserAnswerMapper(), start, count);
 		//analyzeUserAnswerByQuestion(resultList, questionId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserAnswerByQuestion(SmartList<UserAnswer> resultList, String questionId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserAnswer.QUESTION_PROPERTY, questionId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserAnswerByQuestion(String questionId,Map<String,Object> options){

 		return countWith(UserAnswerTable.COLUMN_QUESTION, questionId, options);
 	}
 	@Override
	public Map<String, Integer> countUserAnswerByQuestionIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserAnswerTable.COLUMN_QUESTION, ids, options);
	}
 	
  	
 	public SmartList<UserAnswer> findUserAnswerByExam(String examId,Map<String,Object> options){
 	
  		SmartList<UserAnswer> resultList = queryWith(UserAnswerTable.COLUMN_EXAM, examId, options, getUserAnswerMapper());
		// analyzeUserAnswerByExam(resultList, examId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<UserAnswer> findUserAnswerByExam(String examId, int start, int count,Map<String,Object> options){
 		
 		SmartList<UserAnswer> resultList =  queryWithRange(UserAnswerTable.COLUMN_EXAM, examId, options, getUserAnswerMapper(), start, count);
 		//analyzeUserAnswerByExam(resultList, examId, options);
 		return resultList;
 		
 	}
 	public void analyzeUserAnswerByExam(SmartList<UserAnswer> resultList, String examId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(UserAnswer.EXAM_PROPERTY, examId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countUserAnswerByExam(String examId,Map<String,Object> options){

 		return countWith(UserAnswerTable.COLUMN_EXAM, examId, options);
 	}
 	@Override
	public Map<String, Integer> countUserAnswerByExamIds(String[] ids, Map<String, Object> options) {
		return countWithIds(UserAnswerTable.COLUMN_EXAM, ids, options);
	}
 	
 	
		
		
		

	

	protected UserAnswer saveUserAnswer(UserAnswer  userAnswer){
		
		if(!userAnswer.isChanged()){
			return userAnswer;
		}
		
		
		String SQL=this.getSaveUserAnswerSQL(userAnswer);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveUserAnswerParameters(userAnswer);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		userAnswer.incVersion();
		return userAnswer;
	
	}
	public SmartList<UserAnswer> saveUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitUserAnswerList(userAnswerList);
		
		batchUserAnswerCreate((List<UserAnswer>)lists[CREATE_LIST_INDEX]);
		
		batchUserAnswerUpdate((List<UserAnswer>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(UserAnswer userAnswer:userAnswerList){
			if(userAnswer.isChanged()){
				userAnswer.incVersion();
			}
			
		
		}
		
		
		return userAnswerList;
	}

	public SmartList<UserAnswer> removeUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options){
		
		
		super.removeList(userAnswerList, options);
		
		return userAnswerList;
		
		
	}
	
	protected List<Object[]> prepareUserAnswerBatchCreateArgs(List<UserAnswer> userAnswerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserAnswer userAnswer:userAnswerList ){
			Object [] parameters = prepareUserAnswerCreateParameters(userAnswer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareUserAnswerBatchUpdateArgs(List<UserAnswer> userAnswerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(UserAnswer userAnswer:userAnswerList ){
			if(!userAnswer.isChanged()){
				continue;
			}
			Object [] parameters = prepareUserAnswerUpdateParameters(userAnswer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchUserAnswerCreate(List<UserAnswer> userAnswerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareUserAnswerBatchCreateArgs(userAnswerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUserAnswerUpdate(List<UserAnswer> userAnswerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareUserAnswerBatchUpdateArgs(userAnswerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitUserAnswerList(List<UserAnswer> userAnswerList){
		
		List<UserAnswer> userAnswerCreateList=new ArrayList<UserAnswer>();
		List<UserAnswer> userAnswerUpdateList=new ArrayList<UserAnswer>();
		
		for(UserAnswer userAnswer: userAnswerList){
			if(isUpdateRequest(userAnswer)){
				userAnswerUpdateList.add( userAnswer);
				continue;
			}
			userAnswerCreateList.add(userAnswer);
		}
		
		return new Object[]{userAnswerCreateList,userAnswerUpdateList};
	}
	
	protected boolean isUpdateRequest(UserAnswer userAnswer){
 		return userAnswer.getVersion() > 0;
 	}
 	protected String getSaveUserAnswerSQL(UserAnswer userAnswer){
 		if(isUpdateRequest(userAnswer)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveUserAnswerParameters(UserAnswer userAnswer){
 		if(isUpdateRequest(userAnswer) ){
 			return prepareUserAnswerUpdateParameters(userAnswer);
 		}
 		return prepareUserAnswerCreateParameters(userAnswer);
 	}
 	protected Object[] prepareUserAnswerUpdateParameters(UserAnswer userAnswer){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = userAnswer.getTopic();
 		parameters[1] = userAnswer.getUserSelect(); 	
 		if(userAnswer.getQuestion() != null){
 			parameters[2] = userAnswer.getQuestion().getId();
 		}
  	
 		if(userAnswer.getExam() != null){
 			parameters[3] = userAnswer.getExam().getId();
 		}
 		
 		parameters[4] = userAnswer.nextVersion();
 		parameters[5] = userAnswer.getId();
 		parameters[6] = userAnswer.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareUserAnswerCreateParameters(UserAnswer userAnswer){
		Object[] parameters = new Object[5];
		String newUserAnswerId=getNextId();
		userAnswer.setId(newUserAnswerId);
		parameters[0] =  userAnswer.getId();
 
 		parameters[1] = userAnswer.getTopic();
 		parameters[2] = userAnswer.getUserSelect(); 	
 		if(userAnswer.getQuestion() != null){
 			parameters[3] = userAnswer.getQuestion().getId();
 		
 		}
 		 	
 		if(userAnswer.getExam() != null){
 			parameters[4] = userAnswer.getExam().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected UserAnswer saveInternalUserAnswer(UserAnswer userAnswer, Map<String,Object> options){
		
		saveUserAnswer(userAnswer);
 	
 		if(isSaveQuestionEnabled(options)){
	 		saveQuestion(userAnswer, options);
 		}
  	
 		if(isSaveExamEnabled(options)){
	 		saveExam(userAnswer, options);
 		}
 
		
		if(isSaveAnswerQuestionListEnabled(options)){
	 		saveAnswerQuestionList(userAnswer, options);
	 		//removeAnswerQuestionList(userAnswer, options);
	 		//Not delete the record
	 		
 		}		
		
		return userAnswer;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected UserAnswer saveQuestion(UserAnswer userAnswer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userAnswer.getQuestion() == null){
 			return userAnswer;//do nothing when it is null
 		}
 		
 		getQuestionDAO().save(userAnswer.getQuestion(),options);
 		return userAnswer;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected UserAnswer saveExam(UserAnswer userAnswer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(userAnswer.getExam() == null){
 			return userAnswer;//do nothing when it is null
 		}
 		
 		getExamDAO().save(userAnswer.getExam(),options);
 		return userAnswer;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public UserAnswer planToRemoveAnswerQuestionList(UserAnswer userAnswer, String answerQuestionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswer.getId());
		key.put(AnswerQuestion.ID_PROPERTY, answerQuestionIds);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return userAnswer;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return userAnswer;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){

			answerQuestionItem.clearFromAll();
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return userAnswer;	
	
	}


	//disconnect UserAnswer with user in AnswerQuestion
	public UserAnswer planToRemoveAnswerQuestionListWithUser(UserAnswer userAnswer, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswer.getId());
		key.put(AnswerQuestion.USER_PROPERTY, userId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return userAnswer;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return userAnswer;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearUser();
			answerQuestionItem.clearUserAnswer();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return userAnswer;
	}
	
	public int countAnswerQuestionListWithUser(String userAnswerId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		key.put(AnswerQuestion.USER_PROPERTY, userId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	
	//disconnect UserAnswer with change_request in AnswerQuestion
	public UserAnswer planToRemoveAnswerQuestionListWithChangeRequest(UserAnswer userAnswer, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswer.getId());
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		SmartList<AnswerQuestion> externalAnswerQuestionList = getAnswerQuestionDAO().
				findAnswerQuestionWithKey(key, options);
		if(externalAnswerQuestionList == null){
			return userAnswer;
		}
		if(externalAnswerQuestionList.isEmpty()){
			return userAnswer;
		}
		
		for(AnswerQuestion answerQuestionItem: externalAnswerQuestionList){
			answerQuestionItem.clearChangeRequest();
			answerQuestionItem.clearUserAnswer();
			
		}
		
		
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();		
		answerQuestionList.addAllToRemoveList(externalAnswerQuestionList);
		return userAnswer;
	}
	
	public int countAnswerQuestionListWithChangeRequest(String userAnswerId, String changeRequestId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, userAnswerId);
		key.put(AnswerQuestion.CHANGE_REQUEST_PROPERTY, changeRequestId);
		
		int count = getAnswerQuestionDAO().countAnswerQuestionWithKey(key, options);
		return count;
	}
	

		
	protected UserAnswer saveAnswerQuestionList(UserAnswer userAnswer, Map<String,Object> options){
		
		
		
		
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();
		if(answerQuestionList == null){
			//null list means nothing
			return userAnswer;
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
		
		
		return userAnswer;
	
	}
	
	protected UserAnswer removeAnswerQuestionList(UserAnswer userAnswer, Map<String,Object> options){
	
	
		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();
		if(answerQuestionList == null){
			return userAnswer;
		}	
	
		SmartList<AnswerQuestion> toRemoveAnswerQuestionList = answerQuestionList.getToRemoveList();
		
		if(toRemoveAnswerQuestionList == null){
			return userAnswer;
		}
		if(toRemoveAnswerQuestionList.isEmpty()){
			return userAnswer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getAnswerQuestionDAO().removeAnswerQuestionList(toRemoveAnswerQuestionList,options);
		
		return userAnswer;
	
	}
	
	

 	
 	
	
	
	
		

	public UserAnswer present(UserAnswer userAnswer,Map<String, Object> options){
	
		presentAnswerQuestionList(userAnswer,options);

		return userAnswer;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected UserAnswer presentAnswerQuestionList(
			UserAnswer userAnswer,
			Map<String, Object> options) {

		SmartList<AnswerQuestion> answerQuestionList = userAnswer.getAnswerQuestionList();		
				SmartList<AnswerQuestion> newList= presentSubList(userAnswer.getId(),
				answerQuestionList,
				options,
				getAnswerQuestionDAO()::countAnswerQuestionByUserAnswer,
				getAnswerQuestionDAO()::findAnswerQuestionByUserAnswer
				);

		
		userAnswer.setAnswerQuestionList(newList);
		

		return userAnswer;
	}			
		

	
    public SmartList<UserAnswer> requestCandidateUserAnswerForAnswerQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(UserAnswerTable.COLUMN_TOPIC, filterKey, pageNo, pageSize, getUserAnswerMapper());
    }
		

	protected String getTableName(){
		return UserAnswerTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<UserAnswer> userAnswerList) {		
		this.enhanceListInternal(userAnswerList, this.getUserAnswerMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:AnswerQuestion的userAnswer的AnswerQuestionList
	public SmartList<AnswerQuestion> loadOurAnswerQuestionList(BcexUserContext userContext, List<UserAnswer> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(AnswerQuestion.USER_ANSWER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<AnswerQuestion> loadedObjs = userContext.getDAOGroup().getAnswerQuestionDAO().findAnswerQuestionWithKey(key, options);
		Map<String, List<AnswerQuestion>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getUserAnswer().getId()));
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
		List<UserAnswer> userAnswerList = ownerEntity.collectRefsWithType(UserAnswer.INTERNAL_TYPE);
		this.enhanceList(userAnswerList);
		
	}
	
	@Override
	public SmartList<UserAnswer> findUserAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getUserAnswerMapper());

	}
	@Override
	public int countUserAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countUserAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<UserAnswer> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getUserAnswerMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


