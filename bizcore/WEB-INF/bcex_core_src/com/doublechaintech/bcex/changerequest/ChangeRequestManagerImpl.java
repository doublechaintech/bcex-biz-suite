
package com.doublechaintech.bcex.changerequest;

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
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.registration.Registration;

import com.doublechaintech.bcex.platform.CandidatePlatform;
import com.doublechaintech.bcex.changerequesttype.CandidateChangeRequestType;

import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;






public class ChangeRequestManagerImpl extends CustomBcexCheckerManager implements ChangeRequestManager {
	
	private static final String SERVICE_TYPE = "ChangeRequest";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ChangeRequestManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ChangeRequestManagerException(message);

	}
	
	

 	protected ChangeRequest saveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest, String [] tokensExpr) throws Exception{	
 		//return getChangeRequestDAO().save(changeRequest, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveChangeRequest(userContext, changeRequest, tokens);
 	}
 	
 	protected ChangeRequest saveChangeRequestDetail(BcexUserContext userContext, ChangeRequest changeRequest) throws Exception{	

 		
 		return saveChangeRequest(userContext, changeRequest, allTokens());
 	}
 	
 	public ChangeRequest loadChangeRequest(BcexUserContext userContext, String changeRequestId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequest, tokens);
 	}
 	
 	
 	 public ChangeRequest searchChangeRequest(BcexUserContext userContext, String changeRequestId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,changeRequest, tokens);
 	}
 	
 	

 	protected ChangeRequest present(BcexUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,changeRequest,tokens);
		
		
		ChangeRequest  changeRequestToPresent = changeRequestDaoOf(userContext).present(changeRequest, tokens);
		
		List<BaseEntity> entityListToNaming = changeRequestToPresent.collectRefercencesFromLists();
		changeRequestDaoOf(userContext).alias(entityListToNaming);
		
		return  changeRequestToPresent;
		
		
	}
 
 	
 	
 	public ChangeRequest loadChangeRequestDetail(BcexUserContext userContext, String changeRequestId) throws Exception{	
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, allTokens());
 		return present(userContext,changeRequest, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String changeRequestId) throws Exception{	
 		ChangeRequest changeRequest = loadChangeRequest( userContext, changeRequestId, viewTokens());
 		return present(userContext,changeRequest, allTokens());
		
 	}
 	protected ChangeRequest saveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest, Map<String,Object>tokens) throws Exception{	
 		return changeRequestDaoOf(userContext).save(changeRequest, tokens);
 	}
 	protected ChangeRequest loadChangeRequest(BcexUserContext userContext, String changeRequestId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).throwExceptionIfHasErrors( ChangeRequestManagerException.class);

 
 		return changeRequestDaoOf(userContext).load(changeRequestId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens){
		super.addActions(userContext, changeRequest, tokens);
		
		addAction(userContext, changeRequest, tokens,"@create","createChangeRequest","createChangeRequest/","main","primary");
		addAction(userContext, changeRequest, tokens,"@update","updateChangeRequest","updateChangeRequest/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"@copy","cloneChangeRequest","cloneChangeRequest/"+changeRequest.getId()+"/","main","primary");
		
		addAction(userContext, changeRequest, tokens,"change_request.transfer_to_request_type","transferToAnotherRequestType","transferToAnotherRequestType/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"change_request.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+changeRequest.getId()+"/","main","primary");
		addAction(userContext, changeRequest, tokens,"change_request.addRegistration","addRegistration","addRegistration/"+changeRequest.getId()+"/","registrationList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.removeRegistration","removeRegistration","removeRegistration/"+changeRequest.getId()+"/","registrationList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.updateRegistration","updateRegistration","updateRegistration/"+changeRequest.getId()+"/","registrationList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.copyRegistrationFrom","copyRegistrationFrom","copyRegistrationFrom/"+changeRequest.getId()+"/","registrationList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.addStartExam","addStartExam","addStartExam/"+changeRequest.getId()+"/","startExamList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.removeStartExam","removeStartExam","removeStartExam/"+changeRequest.getId()+"/","startExamList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.updateStartExam","updateStartExam","updateStartExam/"+changeRequest.getId()+"/","startExamList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.copyStartExamFrom","copyStartExamFrom","copyStartExamFrom/"+changeRequest.getId()+"/","startExamList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.addAnswerQuestion","addAnswerQuestion","addAnswerQuestion/"+changeRequest.getId()+"/","answerQuestionList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.removeAnswerQuestion","removeAnswerQuestion","removeAnswerQuestion/"+changeRequest.getId()+"/","answerQuestionList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.updateAnswerQuestion","updateAnswerQuestion","updateAnswerQuestion/"+changeRequest.getId()+"/","answerQuestionList","primary");
		addAction(userContext, changeRequest, tokens,"change_request.copyAnswerQuestionFrom","copyAnswerQuestionFrom","copyAnswerQuestionFrom/"+changeRequest.getId()+"/","answerQuestionList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ChangeRequest changeRequest, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ChangeRequest createChangeRequest(BcexUserContext userContext,String name, String requestTypeId, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfChangeRequest(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);


		ChangeRequest changeRequest=createNewChangeRequest();	

		changeRequest.setName(name);
		changeRequest.setCreateTime(userContext.now());
		changeRequest.setRemoteIp(userContext.getRemoteIP());
			
		ChangeRequestType requestType = loadChangeRequestType(userContext, requestTypeId,emptyOptions());
		changeRequest.setRequestType(requestType);
		
		
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		changeRequest.setPlatform(platform);
		
		

		changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
		
		onNewInstanceCreated(userContext, changeRequest);
		return changeRequest;

		
	}
	protected ChangeRequest createNewChangeRequest() 
	{
		
		return new ChangeRequest();		
	}
	
	protected void checkParamsForUpdatingChangeRequest(BcexUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest( changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequest(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
		
	}
	
	
	
	public ChangeRequest clone(BcexUserContext userContext, String fromChangeRequestId) throws Exception{
		
		return changeRequestDaoOf(userContext).clone(fromChangeRequestId, this.allTokens());
	}
	
	public ChangeRequest internalSaveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest) throws Exception 
	{
		return internalSaveChangeRequest(userContext, changeRequest, allTokens());

	}
	public ChangeRequest internalSaveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			if (changeRequest.isChanged()){
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			}
			changeRequest = saveChangeRequest(userContext, changeRequest, options);
			return changeRequest;
			
		}

	}
	
	public ChangeRequest updateChangeRequest(BcexUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		if(changeRequest.getVersion() != changeRequestVersion){
			String message = "The target version("+changeRequest.getVersion()+") is not equals to version("+changeRequestVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			//return saveChangeRequest(userContext, changeRequest, tokens().done());
		}

	}
	
	public ChangeRequest updateChangeRequestProperty(BcexUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingChangeRequest(userContext, changeRequestId, changeRequestVersion, property, newValueExpr, tokensExpr);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		if(changeRequest.getVersion() != changeRequestVersion){
			String message = "The target version("+changeRequest.getVersion()+") is not equals to version("+changeRequestVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(changeRequest){ 
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ChangeRequest.
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			//return saveChangeRequest(userContext, changeRequest, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ChangeRequestTokens tokens(){
		return ChangeRequestTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ChangeRequestTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortRegistrationListWith("id","desc")
		.sortStartExamListWith("id","desc")
		.sortAnswerQuestionListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ChangeRequestTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherRequestType(BcexUserContext userContext, String changeRequestId, String anotherRequestTypeId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkIdOfChangeRequestType(anotherRequestTypeId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}
 	public ChangeRequest transferToAnotherRequestType(BcexUserContext userContext, String changeRequestId, String anotherRequestTypeId) throws Exception
 	{
 		checkParamsForTransferingAnotherRequestType(userContext, changeRequestId,anotherRequestTypeId);
 
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequestType requestType = loadChangeRequestType(userContext, anotherRequestTypeId, emptyOptions());		
			changeRequest.updateRequestType(requestType);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherRequestTypeWithCode(BcexUserContext userContext, String changeRequestId, String anotherCode) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkCodeOfChangeRequestType( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}

 	public ChangeRequest transferToAnotherRequestTypeWithCode(BcexUserContext userContext, String changeRequestId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherRequestTypeWithCode(userContext, changeRequestId,anotherCode);
 		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequestType requestType = loadChangeRequestTypeWithCode(userContext, anotherCode, emptyOptions());		
			changeRequest.updateRequestType(requestType);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateChangeRequestType requestCandidateRequestType(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateChangeRequestType result = new CandidateChangeRequestType();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ChangeRequestType> candidateList = changeRequestTypeDaoOf(userContext).requestCandidateChangeRequestTypeForChangeRequest(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String changeRequestId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
 		
 	}
 	public ChangeRequest transferToAnotherPlatform(BcexUserContext userContext, String changeRequestId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, changeRequestId,anotherPlatformId);
 
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());	
		synchronized(changeRequest){
			//will be good when the changeRequest loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			changeRequest.updatePlatform(platform);		
			changeRequest = saveChangeRequest(userContext, changeRequest, emptyOptions());
			
			return present(userContext,changeRequest, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForChangeRequest(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected ChangeRequestType loadChangeRequestType(BcexUserContext userContext, String newRequestTypeId, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestTypeDaoOf(userContext).load(newRequestTypeId, options);
 	}
 	
 	protected ChangeRequestType loadChangeRequestTypeWithCode(BcexUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{
		
 		return changeRequestTypeDaoOf(userContext).loadByCode(newCode, options);
 	}
 	
 	
 	
 	
	
	 	
 	protected Platform loadPlatform(BcexUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String changeRequestId, int changeRequestVersion) throws Exception {
		//deleteInternal(userContext, changeRequestId, changeRequestVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String changeRequestId, int changeRequestVersion) throws Exception{
			
		changeRequestDaoOf(userContext).delete(changeRequestId, changeRequestVersion);
	}
	
	public ChangeRequest forgetByAll(BcexUserContext userContext, String changeRequestId, int changeRequestVersion) throws Exception {
		return forgetByAllInternal(userContext, changeRequestId, changeRequestVersion);		
	}
	protected ChangeRequest forgetByAllInternal(BcexUserContext userContext,
			String changeRequestId, int changeRequestVersion) throws Exception{
			
		return changeRequestDaoOf(userContext).disconnectFromAll(changeRequestId, changeRequestVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ChangeRequestManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return changeRequestDaoOf(userContext).deleteAll();
	}


	//disconnect ChangeRequest with user in AnswerQuestion
	protected ChangeRequest breakWithAnswerQuestionByUser(BcexUserContext userContext, String changeRequestId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());

			synchronized(changeRequest){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				changeRequestDaoOf(userContext).planToRemoveAnswerQuestionListWithUser(changeRequest, userId, this.emptyOptions());

				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
				return changeRequest;
			}
	}
	//disconnect ChangeRequest with question in AnswerQuestion
	protected ChangeRequest breakWithAnswerQuestionByQuestion(BcexUserContext userContext, String changeRequestId, String questionId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());

			synchronized(changeRequest){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				changeRequestDaoOf(userContext).planToRemoveAnswerQuestionListWithQuestion(changeRequest, questionId, this.emptyOptions());

				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
				return changeRequest;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingRegistration(BcexUserContext userContext, String changeRequestId, String nickName, String avatar,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);

		
		checkerOf(userContext).checkNickNameOfRegistration(nickName);
		
		checkerOf(userContext).checkAvatarOfRegistration(avatar);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);

	
	}
	public  ChangeRequest addRegistration(BcexUserContext userContext, String changeRequestId, String nickName, String avatar, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingRegistration(userContext,changeRequestId,nickName, avatar,tokensExpr);
		
		Registration registration = createRegistration(userContext,nickName, avatar);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.addRegistration( registration );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withRegistrationList().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, registration);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingRegistrationProperties(BcexUserContext userContext, String changeRequestId,String id,String nickName,String avatar,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfRegistration(id);
		
		checkerOf(userContext).checkNickNameOfRegistration( nickName);
		checkerOf(userContext).checkAvatarOfRegistration( avatar);

		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest updateRegistrationProperties(BcexUserContext userContext, String changeRequestId, String id,String nickName,String avatar, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingRegistrationProperties(userContext,changeRequestId,id,nickName,avatar,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withRegistrationListList()
				.searchRegistrationListWith(Registration.ID_PROPERTY, "is", id).done();
		
		ChangeRequest changeRequestToUpdate = loadChangeRequest(userContext, changeRequestId, options);
		
		if(changeRequestToUpdate.getRegistrationList().isEmpty()){
			throw new ChangeRequestManagerException("Registration is NOT FOUND with id: '"+id+"'");
		}
		
		Registration item = changeRequestToUpdate.getRegistrationList().first();
		
		item.updateNickName( nickName );
		item.updateAvatar( avatar );

		
		//checkParamsForAddingRegistration(userContext,changeRequestId,name, code, used,tokensExpr);
		ChangeRequest changeRequest = saveChangeRequest(userContext, changeRequestToUpdate, tokens().withRegistrationList().done());
		synchronized(changeRequest){ 
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Registration createRegistration(BcexUserContext userContext, String nickName, String avatar) throws Exception{

		Registration registration = new Registration();
		
		
		registration.setNickName(nickName);		
		registration.setAvatar(avatar);
	
		
		return registration;
	
		
	}
	
	protected Registration createIndexedRegistration(String id, int version){

		Registration registration = new Registration();
		registration.setId(id);
		registration.setVersion(version);
		return registration;			
		
	}
	
	protected void checkParamsForRemovingRegistrationList(BcexUserContext userContext, String changeRequestId, 
			String registrationIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		for(String registrationIdItem: registrationIds){
			checkerOf(userContext).checkIdOfRegistration(registrationIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest removeRegistrationList(BcexUserContext userContext, String changeRequestId, 
			String registrationIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingRegistrationList(userContext, changeRequestId,  registrationIds, tokensExpr);
			
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
			synchronized(changeRequest){ 
				//Will be good when the changeRequest loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				changeRequestDaoOf(userContext).planToRemoveRegistrationList(changeRequest, registrationIds, allTokens());
				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withRegistrationList().done());
				deleteRelationListInGraph(userContext, changeRequest.getRegistrationList());
				return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingRegistration(BcexUserContext userContext, String changeRequestId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).checkVersionOfRegistration(registrationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest removeRegistration(BcexUserContext userContext, String changeRequestId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingRegistration(userContext,changeRequestId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistration(registrationId, registrationVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.removeRegistration( registration );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withRegistrationList().done());
			deleteRelationInGraph(userContext, registration);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingRegistration(BcexUserContext userContext, String changeRequestId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).checkVersionOfRegistration(registrationVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest copyRegistrationFrom(BcexUserContext userContext, String changeRequestId, 
		String registrationId, int registrationVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingRegistration(userContext,changeRequestId, registrationId, registrationVersion,tokensExpr);
		
		Registration registration = createIndexedRegistration(registrationId, registrationVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			changeRequest.copyRegistrationFrom( registration );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withRegistrationList().done());
			
			userContext.getManagerGroup().getRegistrationManager().onNewInstanceCreated(userContext, (Registration)changeRequest.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingRegistration(BcexUserContext userContext, String changeRequestId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).checkVersionOfRegistration(registrationVersion);
		

		if(Registration.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfRegistration(parseString(newValueExpr));
		}
		
		if(Registration.AVATAR_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvatarOfRegistration(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	
	public  ChangeRequest updateRegistration(BcexUserContext userContext, String changeRequestId, String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingRegistration(userContext, changeRequestId, registrationId, registrationVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withRegistrationList().searchRegistrationListWith(Registration.ID_PROPERTY, "eq", registrationId).done();
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, loadTokens);
		
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequest.removeRegistration( registration );	
			//make changes to AcceleraterAccount.
			Registration registrationIndex = createIndexedRegistration(registrationId, registrationVersion);
		
			Registration registration = changeRequest.findTheRegistration(registrationIndex);
			if(registration == null){
				throw new ChangeRequestManagerException(registration+" is NOT FOUND" );
			}
			
			registration.changeProperty(property, newValueExpr);
			
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withRegistrationList().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingStartExam(BcexUserContext userContext, String changeRequestId, String nickName,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);

		
		checkerOf(userContext).checkNickNameOfStartExam(nickName);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);

	
	}
	public  ChangeRequest addStartExam(BcexUserContext userContext, String changeRequestId, String nickName, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStartExam(userContext,changeRequestId,nickName,tokensExpr);
		
		StartExam startExam = createStartExam(userContext,nickName);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.addStartExam( startExam );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withStartExamList().done());
			
			userContext.getManagerGroup().getStartExamManager().onNewInstanceCreated(userContext, startExam);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingStartExamProperties(BcexUserContext userContext, String changeRequestId,String id,String nickName,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfStartExam(id);
		
		checkerOf(userContext).checkNickNameOfStartExam( nickName);

		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest updateStartExamProperties(BcexUserContext userContext, String changeRequestId, String id,String nickName, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingStartExamProperties(userContext,changeRequestId,id,nickName,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withStartExamListList()
				.searchStartExamListWith(StartExam.ID_PROPERTY, "is", id).done();
		
		ChangeRequest changeRequestToUpdate = loadChangeRequest(userContext, changeRequestId, options);
		
		if(changeRequestToUpdate.getStartExamList().isEmpty()){
			throw new ChangeRequestManagerException("StartExam is NOT FOUND with id: '"+id+"'");
		}
		
		StartExam item = changeRequestToUpdate.getStartExamList().first();
		
		item.updateNickName( nickName );

		
		//checkParamsForAddingStartExam(userContext,changeRequestId,name, code, used,tokensExpr);
		ChangeRequest changeRequest = saveChangeRequest(userContext, changeRequestToUpdate, tokens().withStartExamList().done());
		synchronized(changeRequest){ 
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected StartExam createStartExam(BcexUserContext userContext, String nickName) throws Exception{

		StartExam startExam = new StartExam();
		
		
		startExam.setNickName(nickName);
	
		
		return startExam;
	
		
	}
	
	protected StartExam createIndexedStartExam(String id, int version){

		StartExam startExam = new StartExam();
		startExam.setId(id);
		startExam.setVersion(version);
		return startExam;			
		
	}
	
	protected void checkParamsForRemovingStartExamList(BcexUserContext userContext, String changeRequestId, 
			String startExamIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		for(String startExamIdItem: startExamIds){
			checkerOf(userContext).checkIdOfStartExam(startExamIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest removeStartExamList(BcexUserContext userContext, String changeRequestId, 
			String startExamIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingStartExamList(userContext, changeRequestId,  startExamIds, tokensExpr);
			
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
			synchronized(changeRequest){ 
				//Will be good when the changeRequest loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				changeRequestDaoOf(userContext).planToRemoveStartExamList(changeRequest, startExamIds, allTokens());
				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withStartExamList().done());
				deleteRelationListInGraph(userContext, changeRequest.getStartExamList());
				return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingStartExam(BcexUserContext userContext, String changeRequestId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest removeStartExam(BcexUserContext userContext, String changeRequestId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingStartExam(userContext,changeRequestId, startExamId, startExamVersion,tokensExpr);
		
		StartExam startExam = createIndexedStartExam(startExamId, startExamVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.removeStartExam( startExam );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withStartExamList().done());
			deleteRelationInGraph(userContext, startExam);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingStartExam(BcexUserContext userContext, String changeRequestId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest copyStartExamFrom(BcexUserContext userContext, String changeRequestId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingStartExam(userContext,changeRequestId, startExamId, startExamVersion,tokensExpr);
		
		StartExam startExam = createIndexedStartExam(startExamId, startExamVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			changeRequest.copyStartExamFrom( startExam );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withStartExamList().done());
			
			userContext.getManagerGroup().getStartExamManager().onNewInstanceCreated(userContext, (StartExam)changeRequest.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingStartExam(BcexUserContext userContext, String changeRequestId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		

		if(StartExam.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfStartExam(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	
	public  ChangeRequest updateStartExam(BcexUserContext userContext, String changeRequestId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingStartExam(userContext, changeRequestId, startExamId, startExamVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withStartExamList().searchStartExamListWith(StartExam.ID_PROPERTY, "eq", startExamId).done();
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, loadTokens);
		
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequest.removeStartExam( startExam );	
			//make changes to AcceleraterAccount.
			StartExam startExamIndex = createIndexedStartExam(startExamId, startExamVersion);
		
			StartExam startExam = changeRequest.findTheStartExam(startExamIndex);
			if(startExam == null){
				throw new ChangeRequestManagerException(startExam+" is NOT FOUND" );
			}
			
			startExam.changeProperty(property, newValueExpr);
			
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withStartExamList().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingAnswerQuestion(BcexUserContext userContext, String changeRequestId, String nickName, String userId, String questionId, String answer,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);

		
		checkerOf(userContext).checkNickNameOfAnswerQuestion(nickName);
		
		checkerOf(userContext).checkUserIdOfAnswerQuestion(userId);
		
		checkerOf(userContext).checkQuestionIdOfAnswerQuestion(questionId);
		
		checkerOf(userContext).checkAnswerOfAnswerQuestion(answer);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);

	
	}
	public  ChangeRequest addAnswerQuestion(BcexUserContext userContext, String changeRequestId, String nickName, String userId, String questionId, String answer, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAnswerQuestion(userContext,changeRequestId,nickName, userId, questionId, answer,tokensExpr);
		
		AnswerQuestion answerQuestion = createAnswerQuestion(userContext,nickName, userId, questionId, answer);
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.addAnswerQuestion( answerQuestion );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, answerQuestion);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAnswerQuestionProperties(BcexUserContext userContext, String changeRequestId,String id,String nickName,String answer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfAnswerQuestion(id);
		
		checkerOf(userContext).checkNickNameOfAnswerQuestion( nickName);
		checkerOf(userContext).checkAnswerOfAnswerQuestion( answer);

		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest updateAnswerQuestionProperties(BcexUserContext userContext, String changeRequestId, String id,String nickName,String answer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAnswerQuestionProperties(userContext,changeRequestId,id,nickName,answer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAnswerQuestionListList()
				.searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "is", id).done();
		
		ChangeRequest changeRequestToUpdate = loadChangeRequest(userContext, changeRequestId, options);
		
		if(changeRequestToUpdate.getAnswerQuestionList().isEmpty()){
			throw new ChangeRequestManagerException("AnswerQuestion is NOT FOUND with id: '"+id+"'");
		}
		
		AnswerQuestion item = changeRequestToUpdate.getAnswerQuestionList().first();
		
		item.updateNickName( nickName );
		item.updateAnswer( answer );

		
		//checkParamsForAddingAnswerQuestion(userContext,changeRequestId,name, code, used,tokensExpr);
		ChangeRequest changeRequest = saveChangeRequest(userContext, changeRequestToUpdate, tokens().withAnswerQuestionList().done());
		synchronized(changeRequest){ 
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AnswerQuestion createAnswerQuestion(BcexUserContext userContext, String nickName, String userId, String questionId, String answer) throws Exception{

		AnswerQuestion answerQuestion = new AnswerQuestion();
		
		
		answerQuestion.setNickName(nickName);		
		WechatUser  user = new WechatUser();
		user.setId(userId);		
		answerQuestion.setUser(user);		
		Question  question = new Question();
		question.setId(questionId);		
		answerQuestion.setQuestion(question);		
		answerQuestion.setAnswer(answer);
	
		
		return answerQuestion;
	
		
	}
	
	protected AnswerQuestion createIndexedAnswerQuestion(String id, int version){

		AnswerQuestion answerQuestion = new AnswerQuestion();
		answerQuestion.setId(id);
		answerQuestion.setVersion(version);
		return answerQuestion;			
		
	}
	
	protected void checkParamsForRemovingAnswerQuestionList(BcexUserContext userContext, String changeRequestId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		for(String answerQuestionIdItem: answerQuestionIds){
			checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
		
	}
	public  ChangeRequest removeAnswerQuestionList(BcexUserContext userContext, String changeRequestId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAnswerQuestionList(userContext, changeRequestId,  answerQuestionIds, tokensExpr);
			
			
			ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
			synchronized(changeRequest){ 
				//Will be good when the changeRequest loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				changeRequestDaoOf(userContext).planToRemoveAnswerQuestionList(changeRequest, answerQuestionIds, allTokens());
				changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
				deleteRelationListInGraph(userContext, changeRequest.getAnswerQuestionList());
				return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAnswerQuestion(BcexUserContext userContext, String changeRequestId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest removeAnswerQuestion(BcexUserContext userContext, String changeRequestId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAnswerQuestion(userContext,changeRequestId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			changeRequest.removeAnswerQuestion( answerQuestion );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
			deleteRelationInGraph(userContext, answerQuestion);
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAnswerQuestion(BcexUserContext userContext, String changeRequestId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfChangeRequest( changeRequestId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	public  ChangeRequest copyAnswerQuestionFrom(BcexUserContext userContext, String changeRequestId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAnswerQuestion(userContext,changeRequestId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, allTokens());
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			changeRequest.copyAnswerQuestionFrom( answerQuestion );		
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, (AnswerQuestion)changeRequest.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAnswerQuestion(BcexUserContext userContext, String changeRequestId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		

		if(AnswerQuestion.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfAnswerQuestion(parseString(newValueExpr));
		}
		
		if(AnswerQuestion.ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkAnswerOfAnswerQuestion(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ChangeRequestManagerException.class);
	
	}
	
	public  ChangeRequest updateAnswerQuestion(BcexUserContext userContext, String changeRequestId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAnswerQuestion(userContext, changeRequestId, answerQuestionId, answerQuestionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAnswerQuestionList().searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "eq", answerQuestionId).done();
		
		
		
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId, loadTokens);
		
		synchronized(changeRequest){ 
			//Will be good when the changeRequest loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//changeRequest.removeAnswerQuestion( answerQuestion );	
			//make changes to AcceleraterAccount.
			AnswerQuestion answerQuestionIndex = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		
			AnswerQuestion answerQuestion = changeRequest.findTheAnswerQuestion(answerQuestionIndex);
			if(answerQuestion == null){
				throw new ChangeRequestManagerException(answerQuestion+" is NOT FOUND" );
			}
			
			answerQuestion.changeProperty(property, newValueExpr);
			
			changeRequest = saveChangeRequest(userContext, changeRequest, tokens().withAnswerQuestionList().done());
			return present(userContext,changeRequest, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, ChangeRequest newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


