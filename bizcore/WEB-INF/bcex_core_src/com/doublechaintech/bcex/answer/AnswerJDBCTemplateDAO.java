
package com.doublechaintech.bcex.answer;

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


import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.question.QuestionDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class AnswerJDBCTemplateDAO extends BcexBaseDAOImpl implements AnswerDAO{
 
 	
 	private  QuestionDAO  questionDAO;
 	public void setQuestionDAO(QuestionDAO questionDAO){
	 	this.questionDAO = questionDAO;
 	}
 	public QuestionDAO getQuestionDAO(){
	 	return this.questionDAO;
 	}


			
		

	
	/*
	protected Answer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalAnswer(accessKey, options);
	}
	*/
	
	public SmartList<Answer> loadAll() {
	    return this.loadAll(getAnswerMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Answer load(String id,Map<String,Object> options) throws Exception{
		return loadInternalAnswer(AnswerTable.withId(id), options);
	}
	
	
	
	public Answer save(Answer answer,Map<String,Object> options){
		
		String methodName="save(Answer answer,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(answer, methodName, "answer");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalAnswer(answer,options);
	}
	public Answer clone(String answerId, Map<String,Object> options) throws Exception{
	
		return clone(AnswerTable.withId(answerId),options);
	}
	
	protected Answer clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String answerId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Answer newAnswer = loadInternalAnswer(accessKey, options);
		newAnswer.setVersion(0);
		
		

		
		saveInternalAnswer(newAnswer,options);
		
		return newAnswer;
	}
	
	
	
	

	protected void throwIfHasException(String answerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new AnswerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new AnswerNotFoundException(
					"The " + this.getTableName() + "(" + answerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String answerId, int version) throws Exception{
	
		String methodName="delete(String answerId, int version)";
		assertMethodArgumentNotNull(answerId, methodName, "answerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{answerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(answerId,version);
		}
		
	
	}
	
	
	
	
	

	public Answer disconnectFromAll(String answerId, int version) throws Exception{
	
		
		Answer answer = loadInternalAnswer(AnswerTable.withId(answerId), emptyOptions());
		answer.clearFromAll();
		this.saveAnswer(answer);
		return answer;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return AnswerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "answer";
	}
	@Override
	protected String getBeanName() {
		
		return "answer";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return AnswerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractQuestionEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, AnswerTokens.QUESTION);
 	}

 	protected boolean isSaveQuestionEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, AnswerTokens.QUESTION);
 	}
 	

 	
 
		

	

	protected AnswerMapper getAnswerMapper(){
		return new AnswerMapper();
	}

	
	
	protected Answer extractAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Answer answer = loadSingleObject(accessKey, getAnswerMapper());
			return answer;
		}catch(EmptyResultDataAccessException e){
			throw new AnswerNotFoundException("Answer("+accessKey+") is not found!");
		}

	}

	
	

	protected Answer loadInternalAnswer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Answer answer = extractAnswer(accessKey, loadOptions);
 	
 		if(isExtractQuestionEnabled(loadOptions)){
	 		extractQuestion(answer, loadOptions);
 		}
 
		
		return answer;
		
	}

	 

 	protected Answer extractQuestion(Answer answer, Map<String,Object> options) throws Exception{

		if(answer.getQuestion() == null){
			return answer;
		}
		String questionId = answer.getQuestion().getId();
		if( questionId == null){
			return answer;
		}
		Question question = getQuestionDAO().load(questionId,options);
		if(question != null){
			answer.setQuestion(question);
		}
		
 		
 		return answer;
 	}
 		
 
		
		
  	
 	public SmartList<Answer> findAnswerByQuestion(String questionId,Map<String,Object> options){
 	
  		SmartList<Answer> resultList = queryWith(AnswerTable.COLUMN_QUESTION, questionId, options, getAnswerMapper());
		// analyzeAnswerByQuestion(resultList, questionId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Answer> findAnswerByQuestion(String questionId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Answer> resultList =  queryWithRange(AnswerTable.COLUMN_QUESTION, questionId, options, getAnswerMapper(), start, count);
 		//analyzeAnswerByQuestion(resultList, questionId, options);
 		return resultList;
 		
 	}
 	public void analyzeAnswerByQuestion(SmartList<Answer> resultList, String questionId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countAnswerByQuestion(String questionId,Map<String,Object> options){

 		return countWith(AnswerTable.COLUMN_QUESTION, questionId, options);
 	}
 	@Override
	public Map<String, Integer> countAnswerByQuestionIds(String[] ids, Map<String, Object> options) {
		return countWithIds(AnswerTable.COLUMN_QUESTION, ids, options);
	}
 	
 	
		
		
		

	

	protected Answer saveAnswer(Answer  answer){
		
		if(!answer.isChanged()){
			return answer;
		}
		
		
		String SQL=this.getSaveAnswerSQL(answer);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveAnswerParameters(answer);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		answer.incVersion();
		return answer;
	
	}
	public SmartList<Answer> saveAnswerList(SmartList<Answer> answerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitAnswerList(answerList);
		
		batchAnswerCreate((List<Answer>)lists[CREATE_LIST_INDEX]);
		
		batchAnswerUpdate((List<Answer>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Answer answer:answerList){
			if(answer.isChanged()){
				answer.incVersion();
			}
			
		
		}
		
		
		return answerList;
	}

	public SmartList<Answer> removeAnswerList(SmartList<Answer> answerList,Map<String,Object> options){
		
		
		super.removeList(answerList, options);
		
		return answerList;
		
		
	}
	
	protected List<Object[]> prepareAnswerBatchCreateArgs(List<Answer> answerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Answer answer:answerList ){
			Object [] parameters = prepareAnswerCreateParameters(answer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareAnswerBatchUpdateArgs(List<Answer> answerList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Answer answer:answerList ){
			if(!answer.isChanged()){
				continue;
			}
			Object [] parameters = prepareAnswerUpdateParameters(answer);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchAnswerCreate(List<Answer> answerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareAnswerBatchCreateArgs(answerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchAnswerUpdate(List<Answer> answerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareAnswerBatchUpdateArgs(answerList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitAnswerList(List<Answer> answerList){
		
		List<Answer> answerCreateList=new ArrayList<Answer>();
		List<Answer> answerUpdateList=new ArrayList<Answer>();
		
		for(Answer answer: answerList){
			if(isUpdateRequest(answer)){
				answerUpdateList.add( answer);
				continue;
			}
			answerCreateList.add(answer);
		}
		
		return new Object[]{answerCreateList,answerUpdateList};
	}
	
	protected boolean isUpdateRequest(Answer answer){
 		return answer.getVersion() > 0;
 	}
 	protected String getSaveAnswerSQL(Answer answer){
 		if(isUpdateRequest(answer)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveAnswerParameters(Answer answer){
 		if(isUpdateRequest(answer) ){
 			return prepareAnswerUpdateParameters(answer);
 		}
 		return prepareAnswerCreateParameters(answer);
 	}
 	protected Object[] prepareAnswerUpdateParameters(Answer answer){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = answer.getTitle();
 		parameters[1] = answer.getComment(); 	
 		if(answer.getQuestion() != null){
 			parameters[2] = answer.getQuestion().getId();
 		}
 		
 		parameters[3] = answer.nextVersion();
 		parameters[4] = answer.getId();
 		parameters[5] = answer.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareAnswerCreateParameters(Answer answer){
		Object[] parameters = new Object[4];
		String newAnswerId=getNextId();
		answer.setId(newAnswerId);
		parameters[0] =  answer.getId();
 
 		parameters[1] = answer.getTitle();
 		parameters[2] = answer.getComment(); 	
 		if(answer.getQuestion() != null){
 			parameters[3] = answer.getQuestion().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Answer saveInternalAnswer(Answer answer, Map<String,Object> options){
		
		saveAnswer(answer);
 	
 		if(isSaveQuestionEnabled(options)){
	 		saveQuestion(answer, options);
 		}
 
		
		return answer;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Answer saveQuestion(Answer answer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(answer.getQuestion() == null){
 			return answer;//do nothing when it is null
 		}
 		
 		getQuestionDAO().save(answer.getQuestion(),options);
 		return answer;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Answer present(Answer answer,Map<String, Object> options){
	

		return answer;
	
	}
		

	

	protected String getTableName(){
		return AnswerTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Answer> answerList) {		
		this.enhanceListInternal(answerList, this.getAnswerMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Answer> answerList = ownerEntity.collectRefsWithType(Answer.INTERNAL_TYPE);
		this.enhanceList(answerList);
		
	}
	
	@Override
	public SmartList<Answer> findAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getAnswerMapper());

	}
	@Override
	public int countAnswerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Answer> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getAnswerMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


