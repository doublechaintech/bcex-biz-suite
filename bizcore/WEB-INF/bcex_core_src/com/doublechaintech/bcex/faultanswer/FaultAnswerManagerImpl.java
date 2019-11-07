
package com.doublechaintech.bcex.faultanswer;

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

import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.wechatuser.CandidateWechatUser;
import com.doublechaintech.bcex.exam.CandidateExam;







public class FaultAnswerManagerImpl extends CustomBcexCheckerManager implements FaultAnswerManager {
	
	private static final String SERVICE_TYPE = "FaultAnswer";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FaultAnswerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FaultAnswerManagerException(message);

	}
	
	

 	protected FaultAnswer saveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer, String [] tokensExpr) throws Exception{	
 		//return getFaultAnswerDAO().save(faultAnswer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFaultAnswer(userContext, faultAnswer, tokens);
 	}
 	
 	protected FaultAnswer saveFaultAnswerDetail(BcexUserContext userContext, FaultAnswer faultAnswer) throws Exception{	

 		
 		return saveFaultAnswer(userContext, faultAnswer, allTokens());
 	}
 	
 	public FaultAnswer loadFaultAnswer(BcexUserContext userContext, String faultAnswerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( FaultAnswerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FaultAnswer faultAnswer = loadFaultAnswer( userContext, faultAnswerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,faultAnswer, tokens);
 	}
 	
 	
 	 public FaultAnswer searchFaultAnswer(BcexUserContext userContext, String faultAnswerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( FaultAnswerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FaultAnswer faultAnswer = loadFaultAnswer( userContext, faultAnswerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,faultAnswer, tokens);
 	}
 	
 	

 	protected FaultAnswer present(BcexUserContext userContext, FaultAnswer faultAnswer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,faultAnswer,tokens);
		
		
		FaultAnswer  faultAnswerToPresent = faultAnswerDaoOf(userContext).present(faultAnswer, tokens);
		
		List<BaseEntity> entityListToNaming = faultAnswerToPresent.collectRefercencesFromLists();
		faultAnswerDaoOf(userContext).alias(entityListToNaming);
		
		return  faultAnswerToPresent;
		
		
	}
 
 	
 	
 	public FaultAnswer loadFaultAnswerDetail(BcexUserContext userContext, String faultAnswerId) throws Exception{	
 		FaultAnswer faultAnswer = loadFaultAnswer( userContext, faultAnswerId, allTokens());
 		return present(userContext,faultAnswer, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String faultAnswerId) throws Exception{	
 		FaultAnswer faultAnswer = loadFaultAnswer( userContext, faultAnswerId, viewTokens());
 		return present(userContext,faultAnswer, allTokens());
		
 	}
 	protected FaultAnswer saveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer, Map<String,Object>tokens) throws Exception{	
 		return faultAnswerDaoOf(userContext).save(faultAnswer, tokens);
 	}
 	protected FaultAnswer loadFaultAnswer(BcexUserContext userContext, String faultAnswerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).throwExceptionIfHasErrors( FaultAnswerManagerException.class);

 
 		return faultAnswerDaoOf(userContext).load(faultAnswerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FaultAnswer faultAnswer, Map<String, Object> tokens){
		super.addActions(userContext, faultAnswer, tokens);
		
		addAction(userContext, faultAnswer, tokens,"@create","createFaultAnswer","createFaultAnswer/","main","primary");
		addAction(userContext, faultAnswer, tokens,"@update","updateFaultAnswer","updateFaultAnswer/"+faultAnswer.getId()+"/","main","primary");
		addAction(userContext, faultAnswer, tokens,"@copy","cloneFaultAnswer","cloneFaultAnswer/"+faultAnswer.getId()+"/","main","primary");
		
		addAction(userContext, faultAnswer, tokens,"fault_answer.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+faultAnswer.getId()+"/","main","primary");
		addAction(userContext, faultAnswer, tokens,"fault_answer.transfer_to_exam","transferToAnotherExam","transferToAnotherExam/"+faultAnswer.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FaultAnswer faultAnswer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FaultAnswer createFaultAnswer(BcexUserContext userContext,String topic, String yourAnswer, String rightAnswer, String userId, String examId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTopicOfFaultAnswer(topic);
		checkerOf(userContext).checkYourAnswerOfFaultAnswer(yourAnswer);
		checkerOf(userContext).checkRightAnswerOfFaultAnswer(rightAnswer);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FaultAnswerManagerException.class);


		FaultAnswer faultAnswer=createNewFaultAnswer();	

		faultAnswer.setTopic(topic);
		faultAnswer.setYourAnswer(yourAnswer);
		faultAnswer.setRightAnswer(rightAnswer);
		faultAnswer.setCreateTime(userContext.now());
			
		WechatUser user = loadWechatUser(userContext, userId,emptyOptions());
		faultAnswer.setUser(user);
		
		
			
		Exam exam = loadExam(userContext, examId,emptyOptions());
		faultAnswer.setExam(exam);
		
		

		faultAnswer = saveFaultAnswer(userContext, faultAnswer, emptyOptions());
		
		onNewInstanceCreated(userContext, faultAnswer);
		return faultAnswer;

		
	}
	protected FaultAnswer createNewFaultAnswer() 
	{
		
		return new FaultAnswer();		
	}
	
	protected void checkParamsForUpdatingFaultAnswer(BcexUserContext userContext,String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer( faultAnswerVersion);
		

		if(FaultAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfFaultAnswer(parseString(newValueExpr));
		}
		if(FaultAnswer.YOUR_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkYourAnswerOfFaultAnswer(parseString(newValueExpr));
		}
		if(FaultAnswer.RIGHT_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkRightAnswerOfFaultAnswer(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FaultAnswerManagerException.class);
	
		
	}
	
	
	
	public FaultAnswer clone(BcexUserContext userContext, String fromFaultAnswerId) throws Exception{
		
		return faultAnswerDaoOf(userContext).clone(fromFaultAnswerId, this.allTokens());
	}
	
	public FaultAnswer internalSaveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer) throws Exception 
	{
		return internalSaveFaultAnswer(userContext, faultAnswer, allTokens());

	}
	public FaultAnswer internalSaveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFaultAnswer(userContext, faultAnswerId, faultAnswerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(faultAnswer){ 
			//will be good when the faultAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FaultAnswer.
			if (faultAnswer.isChanged()){
			
			}
			faultAnswer = saveFaultAnswer(userContext, faultAnswer, options);
			return faultAnswer;
			
		}

	}
	
	public FaultAnswer updateFaultAnswer(BcexUserContext userContext,String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFaultAnswer(userContext, faultAnswerId, faultAnswerVersion, property, newValueExpr, tokensExpr);
		
		
		
		FaultAnswer faultAnswer = loadFaultAnswer(userContext, faultAnswerId, allTokens());
		if(faultAnswer.getVersion() != faultAnswerVersion){
			String message = "The target version("+faultAnswer.getVersion()+") is not equals to version("+faultAnswerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(faultAnswer){ 
			//will be good when the faultAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FaultAnswer.
			
			faultAnswer.changeProperty(property, newValueExpr);
			faultAnswer = saveFaultAnswer(userContext, faultAnswer, tokens().done());
			return present(userContext,faultAnswer, mergedAllTokens(tokensExpr));
			//return saveFaultAnswer(userContext, faultAnswer, tokens().done());
		}

	}
	
	public FaultAnswer updateFaultAnswerProperty(BcexUserContext userContext,String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFaultAnswer(userContext, faultAnswerId, faultAnswerVersion, property, newValueExpr, tokensExpr);
		
		FaultAnswer faultAnswer = loadFaultAnswer(userContext, faultAnswerId, allTokens());
		if(faultAnswer.getVersion() != faultAnswerVersion){
			String message = "The target version("+faultAnswer.getVersion()+") is not equals to version("+faultAnswerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(faultAnswer){ 
			//will be good when the faultAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FaultAnswer.
			
			faultAnswer.changeProperty(property, newValueExpr);
			
			faultAnswer = saveFaultAnswer(userContext, faultAnswer, tokens().done());
			return present(userContext,faultAnswer, mergedAllTokens(tokensExpr));
			//return saveFaultAnswer(userContext, faultAnswer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FaultAnswerTokens tokens(){
		return FaultAnswerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FaultAnswerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FaultAnswerTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(BcexUserContext userContext, String faultAnswerId, String anotherUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
 		checkerOf(userContext).checkIdOfWechatUser(anotherUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FaultAnswerManagerException.class);
 		
 	}
 	public FaultAnswer transferToAnotherUser(BcexUserContext userContext, String faultAnswerId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, faultAnswerId,anotherUserId);
 
		FaultAnswer faultAnswer = loadFaultAnswer(userContext, faultAnswerId, allTokens());	
		synchronized(faultAnswer){
			//will be good when the faultAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			WechatUser user = loadWechatUser(userContext, anotherUserId, emptyOptions());		
			faultAnswer.updateUser(user);		
			faultAnswer = saveFaultAnswer(userContext, faultAnswer, emptyOptions());
			
			return present(userContext,faultAnswer, allTokens());
			
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
		SmartList<WechatUser> candidateList = wechatUserDaoOf(userContext).requestCandidateWechatUserForFaultAnswer(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherExam(BcexUserContext userContext, String faultAnswerId, String anotherExamId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
 		checkerOf(userContext).checkIdOfExam(anotherExamId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FaultAnswerManagerException.class);
 		
 	}
 	public FaultAnswer transferToAnotherExam(BcexUserContext userContext, String faultAnswerId, String anotherExamId) throws Exception
 	{
 		checkParamsForTransferingAnotherExam(userContext, faultAnswerId,anotherExamId);
 
		FaultAnswer faultAnswer = loadFaultAnswer(userContext, faultAnswerId, allTokens());	
		synchronized(faultAnswer){
			//will be good when the faultAnswer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Exam exam = loadExam(userContext, anotherExamId, emptyOptions());		
			faultAnswer.updateExam(exam);		
			faultAnswer = saveFaultAnswer(userContext, faultAnswer, emptyOptions());
			
			return present(userContext,faultAnswer, allTokens());
			
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
		SmartList<Exam> candidateList = examDaoOf(userContext).requestCandidateExamForFaultAnswer(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return wechatUserDaoOf(userContext).load(newUserId, options);
 	}
 	
 	
 	
	
	 	
 	protected Exam loadExam(BcexUserContext userContext, String newExamId, Map<String,Object> options) throws Exception
 	{
		
 		return examDaoOf(userContext).load(newExamId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String faultAnswerId, int faultAnswerVersion) throws Exception {
		//deleteInternal(userContext, faultAnswerId, faultAnswerVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String faultAnswerId, int faultAnswerVersion) throws Exception{
			
		faultAnswerDaoOf(userContext).delete(faultAnswerId, faultAnswerVersion);
	}
	
	public FaultAnswer forgetByAll(BcexUserContext userContext, String faultAnswerId, int faultAnswerVersion) throws Exception {
		return forgetByAllInternal(userContext, faultAnswerId, faultAnswerVersion);		
	}
	protected FaultAnswer forgetByAllInternal(BcexUserContext userContext,
			String faultAnswerId, int faultAnswerVersion) throws Exception{
			
		return faultAnswerDaoOf(userContext).disconnectFromAll(faultAnswerId, faultAnswerVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FaultAnswerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return faultAnswerDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, FaultAnswer newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


