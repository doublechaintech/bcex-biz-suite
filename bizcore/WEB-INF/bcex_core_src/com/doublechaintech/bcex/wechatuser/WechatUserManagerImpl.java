
package com.doublechaintech.bcex.wechatuser;

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

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.platform.CandidatePlatform;

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;






public class WechatUserManagerImpl extends CustomBcexCheckerManager implements WechatUserManager {
	
	private static final String SERVICE_TYPE = "WechatUser";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws WechatUserManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new WechatUserManagerException(message);

	}
	
	

 	protected WechatUser saveWechatUser(BcexUserContext userContext, WechatUser wechatUser, String [] tokensExpr) throws Exception{	
 		//return getWechatUserDAO().save(wechatUser, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatUser(userContext, wechatUser, tokens);
 	}
 	
 	protected WechatUser saveWechatUserDetail(BcexUserContext userContext, WechatUser wechatUser) throws Exception{	

 		
 		return saveWechatUser(userContext, wechatUser, allTokens());
 	}
 	
 	public WechatUser loadWechatUser(BcexUserContext userContext, String wechatUserId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatUser, tokens);
 	}
 	
 	
 	 public WechatUser searchWechatUser(BcexUserContext userContext, String wechatUserId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatUser, tokens);
 	}
 	
 	

 	protected WechatUser present(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatUser,tokens);
		
		
		WechatUser  wechatUserToPresent = wechatUserDaoOf(userContext).present(wechatUser, tokens);
		
		List<BaseEntity> entityListToNaming = wechatUserToPresent.collectRefercencesFromLists();
		wechatUserDaoOf(userContext).alias(entityListToNaming);
		
		return  wechatUserToPresent;
		
		
	}
 
 	
 	
 	public WechatUser loadWechatUserDetail(BcexUserContext userContext, String wechatUserId) throws Exception{	
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, allTokens());
 		return present(userContext,wechatUser, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String wechatUserId) throws Exception{	
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, viewTokens());
 		return present(userContext,wechatUser, allTokens());
		
 	}
 	protected WechatUser saveWechatUser(BcexUserContext userContext, WechatUser wechatUser, Map<String,Object>tokens) throws Exception{	
 		return wechatUserDaoOf(userContext).save(wechatUser, tokens);
 	}
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String wechatUserId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 
 		return wechatUserDaoOf(userContext).load(wechatUserId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens){
		super.addActions(userContext, wechatUser, tokens);
		
		addAction(userContext, wechatUser, tokens,"@create","createWechatUser","createWechatUser/","main","primary");
		addAction(userContext, wechatUser, tokens,"@update","updateWechatUser","updateWechatUser/"+wechatUser.getId()+"/","main","primary");
		addAction(userContext, wechatUser, tokens,"@copy","cloneWechatUser","cloneWechatUser/"+wechatUser.getId()+"/","main","primary");
		
		addAction(userContext, wechatUser, tokens,"wechat_user.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+wechatUser.getId()+"/","main","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addAnswerQuestion","addAnswerQuestion","addAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeAnswerQuestion","removeAnswerQuestion","removeAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateAnswerQuestion","updateAnswerQuestion","updateAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyAnswerQuestionFrom","copyAnswerQuestionFrom","copyAnswerQuestionFrom/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addExam","addExam","addExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeExam","removeExam","removeExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateExam","updateExam","updateExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyExamFrom","copyExamFrom","copyExamFrom/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addFaultAnswer","addFaultAnswer","addFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeFaultAnswer","removeFaultAnswer","removeFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateFaultAnswer","updateFaultAnswer","updateFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyFaultAnswerFrom","copyFaultAnswerFrom","copyFaultAnswerFrom/"+wechatUser.getId()+"/","faultAnswerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public WechatUser createWechatUser(BcexUserContext userContext,String name, String avarta, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfWechatUser(name);
		checkerOf(userContext).checkAvartaOfWechatUser(avarta);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);


		WechatUser wechatUser=createNewWechatUser();	

		wechatUser.setName(name);
		wechatUser.setAvarta(avarta);
		wechatUser.setCreateTime(userContext.now());
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		wechatUser.setPlatform(platform);
		
		

		wechatUser = saveWechatUser(userContext, wechatUser, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatUser);
		return wechatUser;

		
	}
	protected WechatUser createNewWechatUser() 
	{
		
		return new WechatUser();		
	}
	
	protected void checkParamsForUpdatingWechatUser(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkVersionOfWechatUser( wechatUserVersion);
		

		if(WechatUser.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfWechatUser(parseString(newValueExpr));
		}
		if(WechatUser.AVARTA_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvartaOfWechatUser(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
		
	}
	
	
	
	public WechatUser clone(BcexUserContext userContext, String fromWechatUserId) throws Exception{
		
		return wechatUserDaoOf(userContext).clone(fromWechatUserId, this.allTokens());
	}
	
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser) throws Exception 
	{
		return internalSaveWechatUser(userContext, wechatUser, allTokens());

	}
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			if (wechatUser.isChanged()){
			
			}
			wechatUser = saveWechatUser(userContext, wechatUser, options);
			return wechatUser;
			
		}

	}
	
	public WechatUser updateWechatUser(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		if(wechatUser.getVersion() != wechatUserVersion){
			String message = "The target version("+wechatUser.getVersion()+") is not equals to version("+wechatUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			
			wechatUser.changeProperty(property, newValueExpr);
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			//return saveWechatUser(userContext, wechatUser, tokens().done());
		}

	}
	
	public WechatUser updateWechatUserProperty(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		if(wechatUser.getVersion() != wechatUserVersion){
			String message = "The target version("+wechatUser.getVersion()+") is not equals to version("+wechatUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			
			wechatUser.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			//return saveWechatUser(userContext, wechatUser, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WechatUserTokens tokens(){
		return WechatUserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatUserTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAnswerQuestionListWith("id","desc")
		.sortExamListWith("id","desc")
		.sortFaultAnswerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatUserTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String wechatUserId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
 		
 	}
 	public WechatUser transferToAnotherPlatform(BcexUserContext userContext, String wechatUserId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, wechatUserId,anotherPlatformId);
 
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());	
		synchronized(wechatUser){
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			wechatUser.updatePlatform(platform);		
			wechatUser = saveWechatUser(userContext, wechatUser, emptyOptions());
			
			return present(userContext,wechatUser, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForWechatUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(BcexUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String wechatUserId, int wechatUserVersion) throws Exception {
		//deleteInternal(userContext, wechatUserId, wechatUserVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String wechatUserId, int wechatUserVersion) throws Exception{
			
		wechatUserDaoOf(userContext).delete(wechatUserId, wechatUserVersion);
	}
	
	public WechatUser forgetByAll(BcexUserContext userContext, String wechatUserId, int wechatUserVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatUserId, wechatUserVersion);		
	}
	protected WechatUser forgetByAllInternal(BcexUserContext userContext,
			String wechatUserId, int wechatUserVersion) throws Exception{
			
		return wechatUserDaoOf(userContext).disconnectFromAll(wechatUserId, wechatUserVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatUserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return wechatUserDaoOf(userContext).deleteAll();
	}


	//disconnect WechatUser with question in AnswerQuestion
	protected WechatUser breakWithAnswerQuestionByQuestion(BcexUserContext userContext, String wechatUserId, String questionId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionListWithQuestion(wechatUser, questionId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with change_request in AnswerQuestion
	protected WechatUser breakWithAnswerQuestionByChangeRequest(BcexUserContext userContext, String wechatUserId, String changeRequestId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionListWithChangeRequest(wechatUser, changeRequestId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with status in Exam
	protected WechatUser breakWithExamByStatus(BcexUserContext userContext, String wechatUserId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveExamListWithStatus(wechatUser, statusId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with exam in FaultAnswer
	protected WechatUser breakWithFaultAnswerByExam(BcexUserContext userContext, String wechatUserId, String examId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveFaultAnswerListWithExam(wechatUser, examId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
				return wechatUser;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAnswerQuestion(BcexUserContext userContext, String wechatUserId, String nickName, String questionId, String answer, String changeRequestId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkNickNameOfAnswerQuestion(nickName);
		
		checkerOf(userContext).checkQuestionIdOfAnswerQuestion(questionId);
		
		checkerOf(userContext).checkAnswerOfAnswerQuestion(answer);
		
		checkerOf(userContext).checkChangeRequestIdOfAnswerQuestion(changeRequestId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addAnswerQuestion(BcexUserContext userContext, String wechatUserId, String nickName, String questionId, String answer, String changeRequestId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAnswerQuestion(userContext,wechatUserId,nickName, questionId, answer, changeRequestId,tokensExpr);
		
		AnswerQuestion answerQuestion = createAnswerQuestion(userContext,nickName, questionId, answer, changeRequestId);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addAnswerQuestion( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, answerQuestion);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAnswerQuestionProperties(BcexUserContext userContext, String wechatUserId,String id,String nickName,String answer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(id);
		
		checkerOf(userContext).checkNickNameOfAnswerQuestion( nickName);
		checkerOf(userContext).checkAnswerOfAnswerQuestion( answer);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateAnswerQuestionProperties(BcexUserContext userContext, String wechatUserId, String id,String nickName,String answer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAnswerQuestionProperties(userContext,wechatUserId,id,nickName,answer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAnswerQuestionListList()
				.searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getAnswerQuestionList().isEmpty()){
			throw new WechatUserManagerException("AnswerQuestion is NOT FOUND with id: '"+id+"'");
		}
		
		AnswerQuestion item = wechatUserToUpdate.getAnswerQuestionList().first();
		
		item.updateNickName( nickName );
		item.updateAnswer( answer );

		
		//checkParamsForAddingAnswerQuestion(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withAnswerQuestionList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AnswerQuestion createAnswerQuestion(BcexUserContext userContext, String nickName, String questionId, String answer, String changeRequestId) throws Exception{

		AnswerQuestion answerQuestion = new AnswerQuestion();
		
		
		answerQuestion.setNickName(nickName);		
		Question  question = new Question();
		question.setId(questionId);		
		answerQuestion.setQuestion(question);		
		answerQuestion.setAnswer(answer);		
		ChangeRequest  changeRequest = new ChangeRequest();
		changeRequest.setId(changeRequestId);		
		answerQuestion.setChangeRequest(changeRequest);
	
		
		return answerQuestion;
	
		
	}
	
	protected AnswerQuestion createIndexedAnswerQuestion(String id, int version){

		AnswerQuestion answerQuestion = new AnswerQuestion();
		answerQuestion.setId(id);
		answerQuestion.setVersion(version);
		return answerQuestion;			
		
	}
	
	protected void checkParamsForRemovingAnswerQuestionList(BcexUserContext userContext, String wechatUserId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String answerQuestionIdItem: answerQuestionIds){
			checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeAnswerQuestionList(BcexUserContext userContext, String wechatUserId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAnswerQuestionList(userContext, wechatUserId,  answerQuestionIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionList(wechatUser, answerQuestionIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				deleteRelationListInGraph(userContext, wechatUser.getAnswerQuestionList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAnswerQuestion(userContext,wechatUserId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeAnswerQuestion( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			deleteRelationInGraph(userContext, answerQuestion);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyAnswerQuestionFrom(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAnswerQuestion(userContext,wechatUserId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyAnswerQuestionFrom( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, (AnswerQuestion)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		

		if(AnswerQuestion.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfAnswerQuestion(parseString(newValueExpr));
		}
		
		if(AnswerQuestion.ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkAnswerOfAnswerQuestion(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAnswerQuestion(userContext, wechatUserId, answerQuestionId, answerQuestionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAnswerQuestionList().searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "eq", answerQuestionId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeAnswerQuestion( answerQuestion );	
			//make changes to AcceleraterAccount.
			AnswerQuestion answerQuestionIndex = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		
			AnswerQuestion answerQuestion = wechatUser.findTheAnswerQuestion(answerQuestionIndex);
			if(answerQuestion == null){
				throw new WechatUserManagerException(answerQuestion+" is NOT FOUND" );
			}
			
			answerQuestion.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingExam(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkNameOfExam(name);
		
		checkerOf(userContext).checkStatusIdOfExam(statusId);
		
		checkerOf(userContext).checkScoreOfExam(score);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addExam(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExam(userContext,wechatUserId,name, statusId, score,tokensExpr);
		
		Exam exam = createExam(userContext,name, statusId, score);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addExam( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, exam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExamProperties(BcexUserContext userContext, String wechatUserId,String id,String name,int score,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfExam(id);
		
		checkerOf(userContext).checkNameOfExam( name);
		checkerOf(userContext).checkScoreOfExam( score);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateExamProperties(BcexUserContext userContext, String wechatUserId, String id,String name,int score, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExamProperties(userContext,wechatUserId,id,name,score,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExamListList()
				.searchExamListWith(Exam.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getExamList().isEmpty()){
			throw new WechatUserManagerException("Exam is NOT FOUND with id: '"+id+"'");
		}
		
		Exam item = wechatUserToUpdate.getExamList().first();
		
		item.updateName( name );
		item.updateScore( score );

		
		//checkParamsForAddingExam(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withExamList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Exam createExam(BcexUserContext userContext, String name, String statusId, int score) throws Exception{

		Exam exam = new Exam();
		
		
		exam.setName(name);		
		exam.setCreateTime(userContext.now());		
		ExamStatus  status = new ExamStatus();
		status.setId(statusId);		
		exam.setStatus(status);		
		exam.setScore(score);
	
		
		return exam;
	
		
	}
	
	protected Exam createIndexedExam(String id, int version){

		Exam exam = new Exam();
		exam.setId(id);
		exam.setVersion(version);
		return exam;			
		
	}
	
	protected void checkParamsForRemovingExamList(BcexUserContext userContext, String wechatUserId, 
			String examIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String examIdItem: examIds){
			checkerOf(userContext).checkIdOfExam(examIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeExamList(BcexUserContext userContext, String wechatUserId, 
			String examIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExamList(userContext, wechatUserId,  examIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveExamList(wechatUser, examIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
				deleteRelationListInGraph(userContext, wechatUser.getExamList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExam(userContext,wechatUserId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeExam( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			deleteRelationInGraph(userContext, exam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyExamFrom(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExam(userContext,wechatUserId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyExamFrom( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, (Exam)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		

		if(Exam.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExam(parseString(newValueExpr));
		}
		
		if(Exam.SCORE_PROPERTY.equals(property)){
			checkerOf(userContext).checkScoreOfExam(parseInt(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExam(userContext, wechatUserId, examId, examVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExamList().searchExamListWith(Exam.ID_PROPERTY, "eq", examId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeExam( exam );	
			//make changes to AcceleraterAccount.
			Exam examIndex = createIndexedExam(examId, examVersion);
		
			Exam exam = wechatUser.findTheExam(examIndex);
			if(exam == null){
				throw new WechatUserManagerException(exam+" is NOT FOUND" );
			}
			
			exam.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFaultAnswer(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String examId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkTopicOfFaultAnswer(topic);
		
		checkerOf(userContext).checkYourAnswerOfFaultAnswer(yourAnswer);
		
		checkerOf(userContext).checkRightAnswerOfFaultAnswer(rightAnswer);
		
		checkerOf(userContext).checkExamIdOfFaultAnswer(examId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addFaultAnswer(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String examId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFaultAnswer(userContext,wechatUserId,topic, yourAnswer, rightAnswer, examId,tokensExpr);
		
		FaultAnswer faultAnswer = createFaultAnswer(userContext,topic, yourAnswer, rightAnswer, examId);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addFaultAnswer( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, faultAnswer);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFaultAnswerProperties(BcexUserContext userContext, String wechatUserId,String id,String topic,String yourAnswer,String rightAnswer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(id);
		
		checkerOf(userContext).checkTopicOfFaultAnswer( topic);
		checkerOf(userContext).checkYourAnswerOfFaultAnswer( yourAnswer);
		checkerOf(userContext).checkRightAnswerOfFaultAnswer( rightAnswer);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateFaultAnswerProperties(BcexUserContext userContext, String wechatUserId, String id,String topic,String yourAnswer,String rightAnswer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFaultAnswerProperties(userContext,wechatUserId,id,topic,yourAnswer,rightAnswer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFaultAnswerListList()
				.searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getFaultAnswerList().isEmpty()){
			throw new WechatUserManagerException("FaultAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		FaultAnswer item = wechatUserToUpdate.getFaultAnswerList().first();
		
		item.updateTopic( topic );
		item.updateYourAnswer( yourAnswer );
		item.updateRightAnswer( rightAnswer );

		
		//checkParamsForAddingFaultAnswer(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withFaultAnswerList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FaultAnswer createFaultAnswer(BcexUserContext userContext, String topic, String yourAnswer, String rightAnswer, String examId) throws Exception{

		FaultAnswer faultAnswer = new FaultAnswer();
		
		
		faultAnswer.setTopic(topic);		
		faultAnswer.setYourAnswer(yourAnswer);		
		faultAnswer.setRightAnswer(rightAnswer);		
		faultAnswer.setCreateTime(userContext.now());		
		Exam  exam = new Exam();
		exam.setId(examId);		
		faultAnswer.setExam(exam);
	
		
		return faultAnswer;
	
		
	}
	
	protected FaultAnswer createIndexedFaultAnswer(String id, int version){

		FaultAnswer faultAnswer = new FaultAnswer();
		faultAnswer.setId(id);
		faultAnswer.setVersion(version);
		return faultAnswer;			
		
	}
	
	protected void checkParamsForRemovingFaultAnswerList(BcexUserContext userContext, String wechatUserId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String faultAnswerIdItem: faultAnswerIds){
			checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeFaultAnswerList(BcexUserContext userContext, String wechatUserId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFaultAnswerList(userContext, wechatUserId,  faultAnswerIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveFaultAnswerList(wechatUser, faultAnswerIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
				deleteRelationListInGraph(userContext, wechatUser.getFaultAnswerList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFaultAnswer(userContext,wechatUserId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeFaultAnswer( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			deleteRelationInGraph(userContext, faultAnswer);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyFaultAnswerFrom(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFaultAnswer(userContext,wechatUserId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyFaultAnswerFrom( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, (FaultAnswer)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		

		if(FaultAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfFaultAnswer(parseString(newValueExpr));
		}
		
		if(FaultAnswer.YOUR_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkYourAnswerOfFaultAnswer(parseString(newValueExpr));
		}
		
		if(FaultAnswer.RIGHT_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkRightAnswerOfFaultAnswer(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFaultAnswer(userContext, wechatUserId, faultAnswerId, faultAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFaultAnswerList().searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "eq", faultAnswerId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeFaultAnswer( faultAnswer );	
			//make changes to AcceleraterAccount.
			FaultAnswer faultAnswerIndex = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		
			FaultAnswer faultAnswer = wechatUser.findTheFaultAnswer(faultAnswerIndex);
			if(faultAnswer == null){
				throw new WechatUserManagerException(faultAnswer+" is NOT FOUND" );
			}
			
			faultAnswer.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, WechatUser newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


