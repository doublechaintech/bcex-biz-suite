
package com.doublechaintech.bcex.answer;

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

import com.doublechaintech.bcex.question.CandidateQuestion;







public class AnswerManagerImpl extends CustomBcexCheckerManager implements AnswerManager {
	
	private static final String SERVICE_TYPE = "Answer";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AnswerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AnswerManagerException(message);

	}
	
	

 	protected Answer saveAnswer(BcexUserContext userContext, Answer answer, String [] tokensExpr) throws Exception{	
 		//return getAnswerDAO().save(answer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAnswer(userContext, answer, tokens);
 	}
 	
 	protected Answer saveAnswerDetail(BcexUserContext userContext, Answer answer) throws Exception{	

 		
 		return saveAnswer(userContext, answer, allTokens());
 	}
 	
 	public Answer loadAnswer(BcexUserContext userContext, String answerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Answer answer = loadAnswer( userContext, answerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,answer, tokens);
 	}
 	
 	
 	 public Answer searchAnswer(BcexUserContext userContext, String answerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Answer answer = loadAnswer( userContext, answerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,answer, tokens);
 	}
 	
 	

 	protected Answer present(BcexUserContext userContext, Answer answer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,answer,tokens);
		
		
		Answer  answerToPresent = answerDaoOf(userContext).present(answer, tokens);
		
		List<BaseEntity> entityListToNaming = answerToPresent.collectRefercencesFromLists();
		answerDaoOf(userContext).alias(entityListToNaming);
		
		return  answerToPresent;
		
		
	}
 
 	
 	
 	public Answer loadAnswerDetail(BcexUserContext userContext, String answerId) throws Exception{	
 		Answer answer = loadAnswer( userContext, answerId, allTokens());
 		return present(userContext,answer, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String answerId) throws Exception{	
 		Answer answer = loadAnswer( userContext, answerId, viewTokens());
 		return present(userContext,answer, allTokens());
		
 	}
 	protected Answer saveAnswer(BcexUserContext userContext, Answer answer, Map<String,Object>tokens) throws Exception{	
 		return answerDaoOf(userContext).save(answer, tokens);
 	}
 	protected Answer loadAnswer(BcexUserContext userContext, String answerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerManagerException.class);

 
 		return answerDaoOf(userContext).load(answerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Answer answer, Map<String, Object> tokens){
		super.addActions(userContext, answer, tokens);
		
		addAction(userContext, answer, tokens,"@create","createAnswer","createAnswer/","main","primary");
		addAction(userContext, answer, tokens,"@update","updateAnswer","updateAnswer/"+answer.getId()+"/","main","primary");
		addAction(userContext, answer, tokens,"@copy","cloneAnswer","cloneAnswer/"+answer.getId()+"/","main","primary");
		
		addAction(userContext, answer, tokens,"answer.transfer_to_question","transferToAnotherQuestion","transferToAnotherQuestion/"+answer.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Answer answer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Answer createAnswer(BcexUserContext userContext,String title, String comment, String questionId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTitleOfAnswer(title);
		checkerOf(userContext).checkCommentOfAnswer(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AnswerManagerException.class);


		Answer answer=createNewAnswer();	

		answer.setTitle(title);
		answer.setComment(comment);
			
		Question question = loadQuestion(userContext, questionId,emptyOptions());
		answer.setQuestion(question);
		
		

		answer = saveAnswer(userContext, answer, emptyOptions());
		
		onNewInstanceCreated(userContext, answer);
		return answer;

		
	}
	protected Answer createNewAnswer() 
	{
		
		return new Answer();		
	}
	
	protected void checkParamsForUpdatingAnswer(BcexUserContext userContext,String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).checkVersionOfAnswer( answerVersion);
		

		if(Answer.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfAnswer(parseString(newValueExpr));
		}
		if(Answer.COMMENT_PROPERTY.equals(property)){
			checkerOf(userContext).checkCommentOfAnswer(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AnswerManagerException.class);
	
		
	}
	
	
	
	public Answer clone(BcexUserContext userContext, String fromAnswerId) throws Exception{
		
		return answerDaoOf(userContext).clone(fromAnswerId, this.allTokens());
	}
	
	public Answer internalSaveAnswer(BcexUserContext userContext, Answer answer) throws Exception 
	{
		return internalSaveAnswer(userContext, answer, allTokens());

	}
	public Answer internalSaveAnswer(BcexUserContext userContext, Answer answer, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAnswer(userContext, answerId, answerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(answer){ 
			//will be good when the answer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Answer.
			if (answer.isChanged()){
			
			}
			answer = saveAnswer(userContext, answer, options);
			return answer;
			
		}

	}
	
	public Answer updateAnswer(BcexUserContext userContext,String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAnswer(userContext, answerId, answerVersion, property, newValueExpr, tokensExpr);
		
		
		
		Answer answer = loadAnswer(userContext, answerId, allTokens());
		if(answer.getVersion() != answerVersion){
			String message = "The target version("+answer.getVersion()+") is not equals to version("+answerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(answer){ 
			//will be good when the answer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Answer.
			
			answer.changeProperty(property, newValueExpr);
			answer = saveAnswer(userContext, answer, tokens().done());
			return present(userContext,answer, mergedAllTokens(tokensExpr));
			//return saveAnswer(userContext, answer, tokens().done());
		}

	}
	
	public Answer updateAnswerProperty(BcexUserContext userContext,String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAnswer(userContext, answerId, answerVersion, property, newValueExpr, tokensExpr);
		
		Answer answer = loadAnswer(userContext, answerId, allTokens());
		if(answer.getVersion() != answerVersion){
			String message = "The target version("+answer.getVersion()+") is not equals to version("+answerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(answer){ 
			//will be good when the answer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Answer.
			
			answer.changeProperty(property, newValueExpr);
			
			answer = saveAnswer(userContext, answer, tokens().done());
			return present(userContext,answer, mergedAllTokens(tokensExpr));
			//return saveAnswer(userContext, answer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AnswerTokens tokens(){
		return AnswerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AnswerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AnswerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherQuestion(BcexUserContext userContext, String answerId, String anotherQuestionId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfAnswer(answerId);
 		checkerOf(userContext).checkIdOfQuestion(anotherQuestionId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AnswerManagerException.class);
 		
 	}
 	public Answer transferToAnotherQuestion(BcexUserContext userContext, String answerId, String anotherQuestionId) throws Exception
 	{
 		checkParamsForTransferingAnotherQuestion(userContext, answerId,anotherQuestionId);
 
		Answer answer = loadAnswer(userContext, answerId, allTokens());	
		synchronized(answer){
			//will be good when the answer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Question question = loadQuestion(userContext, anotherQuestionId, emptyOptions());		
			answer.updateQuestion(question);		
			answer = saveAnswer(userContext, answer, emptyOptions());
			
			return present(userContext,answer, allTokens());
			
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
		SmartList<Question> candidateList = questionDaoOf(userContext).requestCandidateQuestionForAnswer(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String answerId, int answerVersion) throws Exception {
		//deleteInternal(userContext, answerId, answerVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String answerId, int answerVersion) throws Exception{
			
		answerDaoOf(userContext).delete(answerId, answerVersion);
	}
	
	public Answer forgetByAll(BcexUserContext userContext, String answerId, int answerVersion) throws Exception {
		return forgetByAllInternal(userContext, answerId, answerVersion);		
	}
	protected Answer forgetByAllInternal(BcexUserContext userContext,
			String answerId, int answerVersion) throws Exception{
			
		return answerDaoOf(userContext).disconnectFromAll(answerId, answerVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AnswerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return answerDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, Answer newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


