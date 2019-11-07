
package com.doublechaintech.bcex.useranswer;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BaseEntity;


import com.doublechaintech.bcex.Message;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;

import com.doublechaintech.bcex.BcexUserContext;
//import com.doublechaintech.bcex.BaseManagerImpl;
import com.doublechaintech.bcex.BcexCheckerManager;
import com.doublechaintech.bcex.CustomBcexCheckerManager;

import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.question.CandidateQuestion;
import com.doublechaintech.bcex.exam.CandidateExam;







public class UserAnswerManagerImpl extends CustomBcexCheckerManager implements UserAnswerManager {
	
	private static final String SERVICE_TYPE = "UserAnswer";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws UserAnswerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new UserAnswerManagerException(message);

	}
	
	

 	protected UserAnswer saveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer, String [] tokensExpr) throws Exception{	
 		//return getUserAnswerDAO().save(userAnswer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveUserAnswer(userContext, userAnswer, tokens);
 	}
 	
 	protected UserAnswer saveUserAnswerDetail(BcexUserContext userContext, UserAnswer userAnswer) throws Exception{	

 		
 		return saveUserAnswer(userContext, userAnswer, allTokens());
 	}
 	
 	public UserAnswer loadUserAnswer(BcexUserContext userContext, String userAnswerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAnswerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		UserAnswer userAnswer = loadUserAnswer( userContext, userAnswerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAnswer, tokens);
 	}
 	
 	
 	 public UserAnswer searchUserAnswer(BcexUserContext userContext, String userAnswerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAnswerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		UserAnswer userAnswer = loadUserAnswer( userContext, userAnswerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,userAnswer, tokens);
 	}
 	
 	

 	protected UserAnswer present(BcexUserContext userContext, UserAnswer userAnswer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,userAnswer,tokens);
		
		
		UserAnswer  userAnswerToPresent = userAnswerDaoOf(userContext).present(userAnswer, tokens);
		
		List<BaseEntity> entityListToNaming = userAnswerToPresent.collectRefercencesFromLists();
		userAnswerDaoOf(userContext).alias(entityListToNaming);
		
		return  userAnswerToPresent;
		
		
	}
 
 	
 	
 	public UserAnswer loadUserAnswerDetail(BcexUserContext userContext, String userAnswerId) throws Exception{	
 		UserAnswer userAnswer = loadUserAnswer( userContext, userAnswerId, allTokens());
 		return present(userContext,userAnswer, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String userAnswerId) throws Exception{	
 		UserAnswer userAnswer = loadUserAnswer( userContext, userAnswerId, viewTokens());
 		return present(userContext,userAnswer, allTokens());
		
 	}
 	protected UserAnswer saveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer, Map<String,Object>tokens) throws Exception{	
 		return userAnswerDaoOf(userContext).save(userAnswer, tokens);
 	}
 	protected UserAnswer loadUserAnswer(BcexUserContext userContext, String userAnswerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( UserAnswerManagerException.class);

 
 		return userAnswerDaoOf(userContext).load(userAnswerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, UserAnswer userAnswer, Map<String, Object> tokens){
		super.addActions(userContext, userAnswer, tokens);
		
		addAction(userContext, userAnswer, tokens,"@create","createUserAnswer","createUserAnswer/","main","primary");
		addAction(userContext, userAnswer, tokens,"@update","updateUserAnswer","updateUserAnswer/"+userAnswer.getId()+"/","main","primary");
		addAction(userContext, userAnswer, tokens,"@copy","cloneUserAnswer","cloneUserAnswer/"+userAnswer.getId()+"/","main","primary");
		
		addAction(userContext, userAnswer, tokens,"user_answer.transfer_to_question","transferToAnotherQuestion","transferToAnotherQuestion/"+userAnswer.getId()+"/","main","primary");
		addAction(userContext, userAnswer, tokens,"user_answer.transfer_to_exam","transferToAnotherExam","transferToAnotherExam/"+userAnswer.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, UserAnswer userAnswer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public UserAnswer createUserAnswer(BcexUserContext userContext,String topic, String userSelect, String questionId, String examId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTopicOfUserAnswer(topic);
		checkerOf(userContext).checkUserSelectOfUserAnswer(userSelect);
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAnswerManagerException.class);


		UserAnswer userAnswer=createNewUserAnswer();	

		userAnswer.setTopic(topic);
		userAnswer.setUserSelect(userSelect);
			
		Question question = loadQuestion(userContext, questionId,emptyOptions());
		userAnswer.setQuestion(question);
		
		
			
		Exam exam = loadExam(userContext, examId,emptyOptions());
		userAnswer.setExam(exam);
		
		

		userAnswer = saveUserAnswer(userContext, userAnswer, emptyOptions());
		
		onNewInstanceCreated(userContext, userAnswer);
		return userAnswer;

		
	}
	protected UserAnswer createNewUserAnswer() 
	{
		
		return new UserAnswer();		
	}
	
	protected void checkParamsForUpdatingUserAnswer(BcexUserContext userContext,String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer( userAnswerVersion);
		

		if(UserAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfUserAnswer(parseString(newValueExpr));
		}
		if(UserAnswer.USER_SELECT_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserSelectOfUserAnswer(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(UserAnswerManagerException.class);
	
		
	}
	
	
	
	public UserAnswer clone(BcexUserContext userContext, String fromUserAnswerId) throws Exception{
		
		return userAnswerDaoOf(userContext).clone(fromUserAnswerId, this.allTokens());
	}
	
	public UserAnswer internalSaveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer) throws Exception 
	{
		return internalSaveUserAnswer(userContext, userAnswer, allTokens());

	}
	public UserAnswer internalSaveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingUserAnswer(userContext, userAnswerId, userAnswerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(userAnswer){ 
			//will be good when the userAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAnswer.
			if (userAnswer.isChanged()){
			
			}
			userAnswer = saveUserAnswer(userContext, userAnswer, options);
			return userAnswer;
			
		}

	}
	
	public UserAnswer updateUserAnswer(BcexUserContext userContext,String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserAnswer(userContext, userAnswerId, userAnswerVersion, property, newValueExpr, tokensExpr);
		
		
		
		UserAnswer userAnswer = loadUserAnswer(userContext, userAnswerId, allTokens());
		if(userAnswer.getVersion() != userAnswerVersion){
			String message = "The target version("+userAnswer.getVersion()+") is not equals to version("+userAnswerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAnswer){ 
			//will be good when the userAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAnswer.
			
			userAnswer.changeProperty(property, newValueExpr);
			userAnswer = saveUserAnswer(userContext, userAnswer, tokens().done());
			return present(userContext,userAnswer, mergedAllTokens(tokensExpr));
			//return saveUserAnswer(userContext, userAnswer, tokens().done());
		}

	}
	
	public UserAnswer updateUserAnswerProperty(BcexUserContext userContext,String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingUserAnswer(userContext, userAnswerId, userAnswerVersion, property, newValueExpr, tokensExpr);
		
		UserAnswer userAnswer = loadUserAnswer(userContext, userAnswerId, allTokens());
		if(userAnswer.getVersion() != userAnswerVersion){
			String message = "The target version("+userAnswer.getVersion()+") is not equals to version("+userAnswerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(userAnswer){ 
			//will be good when the userAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to UserAnswer.
			
			userAnswer.changeProperty(property, newValueExpr);
			
			userAnswer = saveUserAnswer(userContext, userAnswer, tokens().done());
			return present(userContext,userAnswer, mergedAllTokens(tokensExpr));
			//return saveUserAnswer(userContext, userAnswer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected UserAnswerTokens tokens(){
		return UserAnswerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return UserAnswerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return UserAnswerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherQuestion(BcexUserContext userContext, String userAnswerId, String anotherQuestionId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
 		checkerOf(userContext).checkIdOfQuestion(anotherQuestionId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAnswerManagerException.class);
 		
 	}
 	public UserAnswer transferToAnotherQuestion(BcexUserContext userContext, String userAnswerId, String anotherQuestionId) throws Exception
 	{
 		checkParamsForTransferingAnotherQuestion(userContext, userAnswerId,anotherQuestionId);
 
		UserAnswer userAnswer = loadUserAnswer(userContext, userAnswerId, allTokens());	
		synchronized(userAnswer){
			//will be good when the userAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Question question = loadQuestion(userContext, anotherQuestionId, emptyOptions());		
			userAnswer.updateQuestion(question);		
			userAnswer = saveUserAnswer(userContext, userAnswer, emptyOptions());
			
			return present(userContext,userAnswer, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateQuestion requestCandidateQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateQuestion result = new CandidateQuestion();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("topic");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Question> candidateList = questionDaoOf(userContext).requestCandidateQuestionForUserAnswer(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherExam(BcexUserContext userContext, String userAnswerId, String anotherExamId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
 		checkerOf(userContext).checkIdOfExam(anotherExamId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(UserAnswerManagerException.class);
 		
 	}
 	public UserAnswer transferToAnotherExam(BcexUserContext userContext, String userAnswerId, String anotherExamId) throws Exception
 	{
 		checkParamsForTransferingAnotherExam(userContext, userAnswerId,anotherExamId);
 
		UserAnswer userAnswer = loadUserAnswer(userContext, userAnswerId, allTokens());	
		synchronized(userAnswer){
			//will be good when the userAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Exam exam = loadExam(userContext, anotherExamId, emptyOptions());		
			userAnswer.updateExam(exam);		
			userAnswer = saveUserAnswer(userContext, userAnswer, emptyOptions());
			
			return present(userContext,userAnswer, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateExam requestCandidateExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateExam result = new CandidateExam();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Exam> candidateList = examDaoOf(userContext).requestCandidateExamForUserAnswer(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Question loadQuestion(BcexUserContext userContext, String newQuestionId, Map<String,Object> options) throws Exception
 	{
		
 		return questionDaoOf(userContext).load(newQuestionId, options);
 	}
 	
 	
 	
	
	 	
 	protected Exam loadExam(BcexUserContext userContext, String newExamId, Map<String,Object> options) throws Exception
 	{
		
 		return examDaoOf(userContext).load(newExamId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String userAnswerId, int userAnswerVersion) throws Exception {
		//deleteInternal(userContext, userAnswerId, userAnswerVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String userAnswerId, int userAnswerVersion) throws Exception{
			
		userAnswerDaoOf(userContext).delete(userAnswerId, userAnswerVersion);
	}
	
	public UserAnswer forgetByAll(BcexUserContext userContext, String userAnswerId, int userAnswerVersion) throws Exception {
		return forgetByAllInternal(userContext, userAnswerId, userAnswerVersion);		
	}
	protected UserAnswer forgetByAllInternal(BcexUserContext userContext,
			String userAnswerId, int userAnswerVersion) throws Exception{
			
		return userAnswerDaoOf(userContext).disconnectFromAll(userAnswerId, userAnswerVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new UserAnswerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return userAnswerDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, UserAnswer newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


