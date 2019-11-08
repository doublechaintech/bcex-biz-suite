
package com.doublechaintech.bcex.answerquestion;

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

import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.changerequest.CandidateChangeRequest;
import com.doublechaintech.bcex.useranswer.CandidateUserAnswer;
import com.doublechaintech.bcex.wechatuser.CandidateWechatUser;







public class AnswerQuestionManagerImpl extends CustomBcexCheckerManager implements AnswerQuestionManager {
	
	private static final String SERVICE_TYPE = "AnswerQuestion";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws AnswerQuestionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new AnswerQuestionManagerException(message);

	}
	
	

 	protected AnswerQuestion saveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion, String [] tokensExpr) throws Exception{	
 		//return getAnswerQuestionDAO().save(answerQuestion, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveAnswerQuestion(userContext, answerQuestion, tokens);
 	}
 	
 	protected AnswerQuestion saveAnswerQuestionDetail(BcexUserContext userContext, AnswerQuestion answerQuestion) throws Exception{	

 		
 		return saveAnswerQuestion(userContext, answerQuestion, allTokens());
 	}
 	
 	public AnswerQuestion loadAnswerQuestion(BcexUserContext userContext, String answerQuestionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerQuestionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		AnswerQuestion answerQuestion = loadAnswerQuestion( userContext, answerQuestionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,answerQuestion, tokens);
 	}
 	
 	
 	 public AnswerQuestion searchAnswerQuestion(BcexUserContext userContext, String answerQuestionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerQuestionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		AnswerQuestion answerQuestion = loadAnswerQuestion( userContext, answerQuestionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,answerQuestion, tokens);
 	}
 	
 	

 	protected AnswerQuestion present(BcexUserContext userContext, AnswerQuestion answerQuestion, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,answerQuestion,tokens);
		
		
		AnswerQuestion  answerQuestionToPresent = answerQuestionDaoOf(userContext).present(answerQuestion, tokens);
		
		List<BaseEntity> entityListToNaming = answerQuestionToPresent.collectRefercencesFromLists();
		answerQuestionDaoOf(userContext).alias(entityListToNaming);
		
		return  answerQuestionToPresent;
		
		
	}
 
 	
 	
 	public AnswerQuestion loadAnswerQuestionDetail(BcexUserContext userContext, String answerQuestionId) throws Exception{	
 		AnswerQuestion answerQuestion = loadAnswerQuestion( userContext, answerQuestionId, allTokens());
 		return present(userContext,answerQuestion, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String answerQuestionId) throws Exception{	
 		AnswerQuestion answerQuestion = loadAnswerQuestion( userContext, answerQuestionId, viewTokens());
 		return present(userContext,answerQuestion, allTokens());
		
 	}
 	protected AnswerQuestion saveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion, Map<String,Object>tokens) throws Exception{	
 		return answerQuestionDaoOf(userContext).save(answerQuestion, tokens);
 	}
 	protected AnswerQuestion loadAnswerQuestion(BcexUserContext userContext, String answerQuestionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).throwExceptionIfHasErrors( AnswerQuestionManagerException.class);

 
 		return answerQuestionDaoOf(userContext).load(answerQuestionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, AnswerQuestion answerQuestion, Map<String, Object> tokens){
		super.addActions(userContext, answerQuestion, tokens);
		
		addAction(userContext, answerQuestion, tokens,"@create","createAnswerQuestion","createAnswerQuestion/","main","primary");
		addAction(userContext, answerQuestion, tokens,"@update","updateAnswerQuestion","updateAnswerQuestion/"+answerQuestion.getId()+"/","main","primary");
		addAction(userContext, answerQuestion, tokens,"@copy","cloneAnswerQuestion","cloneAnswerQuestion/"+answerQuestion.getId()+"/","main","primary");
		
		addAction(userContext, answerQuestion, tokens,"answer_question.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+answerQuestion.getId()+"/","main","primary");
		addAction(userContext, answerQuestion, tokens,"answer_question.transfer_to_user_answer","transferToAnotherUserAnswer","transferToAnotherUserAnswer/"+answerQuestion.getId()+"/","main","primary");
		addAction(userContext, answerQuestion, tokens,"answer_question.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+answerQuestion.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, AnswerQuestion answerQuestion, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public AnswerQuestion createAnswerQuestion(BcexUserContext userContext,String nickName, String userId, String userAnswerId, String answer, String changeRequestId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNickNameOfAnswerQuestion(nickName);
		checkerOf(userContext).checkAnswerOfAnswerQuestion(answer);
	
		checkerOf(userContext).throwExceptionIfHasErrors(AnswerQuestionManagerException.class);


		AnswerQuestion answerQuestion=createNewAnswerQuestion();	

		answerQuestion.setNickName(nickName);
			
		WechatUser user = loadWechatUser(userContext, userId,emptyOptions());
		answerQuestion.setUser(user);
		
		
			
		UserAnswer userAnswer = loadUserAnswer(userContext, userAnswerId,emptyOptions());
		answerQuestion.setUserAnswer(userAnswer);
		
		
		answerQuestion.setAnswer(answer);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		answerQuestion.setChangeRequest(changeRequest);
		
		

		answerQuestion = saveAnswerQuestion(userContext, answerQuestion, emptyOptions());
		
		onNewInstanceCreated(userContext, answerQuestion);
		return answerQuestion;

		
	}
	protected AnswerQuestion createNewAnswerQuestion() 
	{
		
		return new AnswerQuestion();		
	}
	
	protected void checkParamsForUpdatingAnswerQuestion(BcexUserContext userContext,String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion( answerQuestionVersion);
		

		if(AnswerQuestion.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfAnswerQuestion(parseString(newValueExpr));
		}		

				

		
		if(AnswerQuestion.ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkAnswerOfAnswerQuestion(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(AnswerQuestionManagerException.class);
	
		
	}
	
	
	
	public AnswerQuestion clone(BcexUserContext userContext, String fromAnswerQuestionId) throws Exception{
		
		return answerQuestionDaoOf(userContext).clone(fromAnswerQuestionId, this.allTokens());
	}
	
	public AnswerQuestion internalSaveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion) throws Exception 
	{
		return internalSaveAnswerQuestion(userContext, answerQuestion, allTokens());

	}
	public AnswerQuestion internalSaveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingAnswerQuestion(userContext, answerQuestionId, answerQuestionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(answerQuestion){ 
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AnswerQuestion.
			if (answerQuestion.isChanged()){
			
			}
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, options);
			return answerQuestion;
			
		}

	}
	
	public AnswerQuestion updateAnswerQuestion(BcexUserContext userContext,String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAnswerQuestion(userContext, answerQuestionId, answerQuestionVersion, property, newValueExpr, tokensExpr);
		
		
		
		AnswerQuestion answerQuestion = loadAnswerQuestion(userContext, answerQuestionId, allTokens());
		if(answerQuestion.getVersion() != answerQuestionVersion){
			String message = "The target version("+answerQuestion.getVersion()+") is not equals to version("+answerQuestionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(answerQuestion){ 
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AnswerQuestion.
			
			answerQuestion.changeProperty(property, newValueExpr);
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, tokens().done());
			return present(userContext,answerQuestion, mergedAllTokens(tokensExpr));
			//return saveAnswerQuestion(userContext, answerQuestion, tokens().done());
		}

	}
	
	public AnswerQuestion updateAnswerQuestionProperty(BcexUserContext userContext,String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingAnswerQuestion(userContext, answerQuestionId, answerQuestionVersion, property, newValueExpr, tokensExpr);
		
		AnswerQuestion answerQuestion = loadAnswerQuestion(userContext, answerQuestionId, allTokens());
		if(answerQuestion.getVersion() != answerQuestionVersion){
			String message = "The target version("+answerQuestion.getVersion()+") is not equals to version("+answerQuestionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(answerQuestion){ 
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to AnswerQuestion.
			
			answerQuestion.changeProperty(property, newValueExpr);
			
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, tokens().done());
			return present(userContext,answerQuestion, mergedAllTokens(tokensExpr));
			//return saveAnswerQuestion(userContext, answerQuestion, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected AnswerQuestionTokens tokens(){
		return AnswerQuestionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return AnswerQuestionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return AnswerQuestionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(BcexUserContext userContext, String answerQuestionId, String anotherUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
 		checkerOf(userContext).checkIdOfWechatUser(anotherUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AnswerQuestionManagerException.class);
 		
 	}
 	public AnswerQuestion transferToAnotherUser(BcexUserContext userContext, String answerQuestionId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, answerQuestionId,anotherUserId);
 
		AnswerQuestion answerQuestion = loadAnswerQuestion(userContext, answerQuestionId, allTokens());	
		synchronized(answerQuestion){
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			WechatUser user = loadWechatUser(userContext, anotherUserId, emptyOptions());		
			answerQuestion.updateUser(user);		
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, emptyOptions());
			
			return present(userContext,answerQuestion, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWechatUser requestCandidateUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWechatUser result = new CandidateWechatUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<WechatUser> candidateList = wechatUserDaoOf(userContext).requestCandidateWechatUserForAnswerQuestion(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherUserAnswer(BcexUserContext userContext, String answerQuestionId, String anotherUserAnswerId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
 		checkerOf(userContext).checkIdOfUserAnswer(anotherUserAnswerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AnswerQuestionManagerException.class);
 		
 	}
 	public AnswerQuestion transferToAnotherUserAnswer(BcexUserContext userContext, String answerQuestionId, String anotherUserAnswerId) throws Exception
 	{
 		checkParamsForTransferingAnotherUserAnswer(userContext, answerQuestionId,anotherUserAnswerId);
 
		AnswerQuestion answerQuestion = loadAnswerQuestion(userContext, answerQuestionId, allTokens());	
		synchronized(answerQuestion){
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserAnswer userAnswer = loadUserAnswer(userContext, anotherUserAnswerId, emptyOptions());		
			answerQuestion.updateUserAnswer(userAnswer);		
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, emptyOptions());
			
			return present(userContext,answerQuestion, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserAnswer requestCandidateUserAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserAnswer result = new CandidateUserAnswer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("topic");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserAnswer> candidateList = userAnswerDaoOf(userContext).requestCandidateUserAnswerForAnswerQuestion(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChangeRequest(BcexUserContext userContext, String answerQuestionId, String anotherChangeRequestId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
 		checkerOf(userContext).checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(AnswerQuestionManagerException.class);
 		
 	}
 	public AnswerQuestion transferToAnotherChangeRequest(BcexUserContext userContext, String answerQuestionId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, answerQuestionId,anotherChangeRequestId);
 
		AnswerQuestion answerQuestion = loadAnswerQuestion(userContext, answerQuestionId, allTokens());	
		synchronized(answerQuestion){
			//will be good when the answerQuestion loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			answerQuestion.updateChangeRequest(changeRequest);		
			answerQuestion = saveAnswerQuestion(userContext, answerQuestion, emptyOptions());
			
			return present(userContext,answerQuestion, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateChangeRequest requestCandidateChangeRequest(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChangeRequest result = new CandidateChangeRequest();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChangeRequest> candidateList = changeRequestDaoOf(userContext).requestCandidateChangeRequestForAnswerQuestion(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ChangeRequest loadChangeRequest(BcexUserContext userContext, String newChangeRequestId, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestDaoOf(userContext).load(newChangeRequestId, options);
 	}
 	
 	
 	
	
	 	
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return wechatUserDaoOf(userContext).load(newUserId, options);
 	}
 	
 	
 	
	
	 	
 	protected UserAnswer loadUserAnswer(BcexUserContext userContext, String newUserAnswerId, Map<String,Object> options) throws Exception
 	{
		
 		return userAnswerDaoOf(userContext).load(newUserAnswerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String answerQuestionId, int answerQuestionVersion) throws Exception {
		//deleteInternal(userContext, answerQuestionId, answerQuestionVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String answerQuestionId, int answerQuestionVersion) throws Exception{
			
		answerQuestionDaoOf(userContext).delete(answerQuestionId, answerQuestionVersion);
	}
	
	public AnswerQuestion forgetByAll(BcexUserContext userContext, String answerQuestionId, int answerQuestionVersion) throws Exception {
		return forgetByAllInternal(userContext, answerQuestionId, answerQuestionVersion);		
	}
	protected AnswerQuestion forgetByAllInternal(BcexUserContext userContext,
			String answerQuestionId, int answerQuestionVersion) throws Exception{
			
		return answerQuestionDaoOf(userContext).disconnectFromAll(answerQuestionId, answerQuestionVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new AnswerQuestionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return answerQuestionDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, AnswerQuestion newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


