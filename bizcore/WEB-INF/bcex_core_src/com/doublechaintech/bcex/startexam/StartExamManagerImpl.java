
package com.doublechaintech.bcex.startexam;

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
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.changerequest.CandidateChangeRequest;
import com.doublechaintech.bcex.wechatuser.CandidateWechatUser;







public class StartExamManagerImpl extends CustomBcexCheckerManager implements StartExamManager {
	
	private static final String SERVICE_TYPE = "StartExam";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws StartExamManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new StartExamManagerException(message);

	}
	
	

 	protected StartExam saveStartExam(BcexUserContext userContext, StartExam startExam, String [] tokensExpr) throws Exception{	
 		//return getStartExamDAO().save(startExam, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveStartExam(userContext, startExam, tokens);
 	}
 	
 	protected StartExam saveStartExamDetail(BcexUserContext userContext, StartExam startExam) throws Exception{	

 		
 		return saveStartExam(userContext, startExam, allTokens());
 	}
 	
 	public StartExam loadStartExam(BcexUserContext userContext, String startExamId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).throwExceptionIfHasErrors( StartExamManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		StartExam startExam = loadStartExam( userContext, startExamId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,startExam, tokens);
 	}
 	
 	
 	 public StartExam searchStartExam(BcexUserContext userContext, String startExamId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).throwExceptionIfHasErrors( StartExamManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		StartExam startExam = loadStartExam( userContext, startExamId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,startExam, tokens);
 	}
 	
 	

 	protected StartExam present(BcexUserContext userContext, StartExam startExam, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,startExam,tokens);
		
		
		StartExam  startExamToPresent = startExamDaoOf(userContext).present(startExam, tokens);
		
		List<BaseEntity> entityListToNaming = startExamToPresent.collectRefercencesFromLists();
		startExamDaoOf(userContext).alias(entityListToNaming);
		
		return  startExamToPresent;
		
		
	}
 
 	
 	
 	public StartExam loadStartExamDetail(BcexUserContext userContext, String startExamId) throws Exception{	
 		StartExam startExam = loadStartExam( userContext, startExamId, allTokens());
 		return present(userContext,startExam, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String startExamId) throws Exception{	
 		StartExam startExam = loadStartExam( userContext, startExamId, viewTokens());
 		return present(userContext,startExam, allTokens());
		
 	}
 	protected StartExam saveStartExam(BcexUserContext userContext, StartExam startExam, Map<String,Object>tokens) throws Exception{	
 		return startExamDaoOf(userContext).save(startExam, tokens);
 	}
 	protected StartExam loadStartExam(BcexUserContext userContext, String startExamId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).throwExceptionIfHasErrors( StartExamManagerException.class);

 
 		return startExamDaoOf(userContext).load(startExamId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, StartExam startExam, Map<String, Object> tokens){
		super.addActions(userContext, startExam, tokens);
		
		addAction(userContext, startExam, tokens,"@create","createStartExam","createStartExam/","main","primary");
		addAction(userContext, startExam, tokens,"@update","updateStartExam","updateStartExam/"+startExam.getId()+"/","main","primary");
		addAction(userContext, startExam, tokens,"@copy","cloneStartExam","cloneStartExam/"+startExam.getId()+"/","main","primary");
		
		addAction(userContext, startExam, tokens,"start_exam.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+startExam.getId()+"/","main","primary");
		addAction(userContext, startExam, tokens,"start_exam.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+startExam.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, StartExam startExam, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public StartExam createStartExam(BcexUserContext userContext,String nickName, String userId, String changeRequestId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNickNameOfStartExam(nickName);
	
		checkerOf(userContext).throwExceptionIfHasErrors(StartExamManagerException.class);


		StartExam startExam=createNewStartExam();	

		startExam.setNickName(nickName);
			
		WechatUser user = loadWechatUser(userContext, userId,emptyOptions());
		startExam.setUser(user);
		
		
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		startExam.setChangeRequest(changeRequest);
		
		

		startExam = saveStartExam(userContext, startExam, emptyOptions());
		
		onNewInstanceCreated(userContext, startExam);
		return startExam;

		
	}
	protected StartExam createNewStartExam() 
	{
		
		return new StartExam();		
	}
	
	protected void checkParamsForUpdatingStartExam(BcexUserContext userContext,String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam( startExamVersion);
		

		if(StartExam.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfStartExam(parseString(newValueExpr));
		}		

				

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(StartExamManagerException.class);
	
		
	}
	
	
	
	public StartExam clone(BcexUserContext userContext, String fromStartExamId) throws Exception{
		
		return startExamDaoOf(userContext).clone(fromStartExamId, this.allTokens());
	}
	
	public StartExam internalSaveStartExam(BcexUserContext userContext, StartExam startExam) throws Exception 
	{
		return internalSaveStartExam(userContext, startExam, allTokens());

	}
	public StartExam internalSaveStartExam(BcexUserContext userContext, StartExam startExam, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingStartExam(userContext, startExamId, startExamVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(startExam){ 
			//will be good when the startExam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StartExam.
			if (startExam.isChanged()){
			
			}
			startExam = saveStartExam(userContext, startExam, options);
			return startExam;
			
		}

	}
	
	public StartExam updateStartExam(BcexUserContext userContext,String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStartExam(userContext, startExamId, startExamVersion, property, newValueExpr, tokensExpr);
		
		
		
		StartExam startExam = loadStartExam(userContext, startExamId, allTokens());
		if(startExam.getVersion() != startExamVersion){
			String message = "The target version("+startExam.getVersion()+") is not equals to version("+startExamVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(startExam){ 
			//will be good when the startExam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StartExam.
			
			startExam.changeProperty(property, newValueExpr);
			startExam = saveStartExam(userContext, startExam, tokens().done());
			return present(userContext,startExam, mergedAllTokens(tokensExpr));
			//return saveStartExam(userContext, startExam, tokens().done());
		}

	}
	
	public StartExam updateStartExamProperty(BcexUserContext userContext,String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingStartExam(userContext, startExamId, startExamVersion, property, newValueExpr, tokensExpr);
		
		StartExam startExam = loadStartExam(userContext, startExamId, allTokens());
		if(startExam.getVersion() != startExamVersion){
			String message = "The target version("+startExam.getVersion()+") is not equals to version("+startExamVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(startExam){ 
			//will be good when the startExam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to StartExam.
			
			startExam.changeProperty(property, newValueExpr);
			
			startExam = saveStartExam(userContext, startExam, tokens().done());
			return present(userContext,startExam, mergedAllTokens(tokensExpr));
			//return saveStartExam(userContext, startExam, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected StartExamTokens tokens(){
		return StartExamTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return StartExamTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return StartExamTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherUser(BcexUserContext userContext, String startExamId, String anotherUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfStartExam(startExamId);
 		checkerOf(userContext).checkIdOfWechatUser(anotherUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(StartExamManagerException.class);
 		
 	}
 	public StartExam transferToAnotherUser(BcexUserContext userContext, String startExamId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, startExamId,anotherUserId);
 
		StartExam startExam = loadStartExam(userContext, startExamId, allTokens());	
		synchronized(startExam){
			//will be good when the startExam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			WechatUser user = loadWechatUser(userContext, anotherUserId, emptyOptions());		
			startExam.updateUser(user);		
			startExam = saveStartExam(userContext, startExam, emptyOptions());
			
			return present(userContext,startExam, allTokens());
			
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
		SmartList<WechatUser> candidateList = wechatUserDaoOf(userContext).requestCandidateWechatUserForStartExam(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherChangeRequest(BcexUserContext userContext, String startExamId, String anotherChangeRequestId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfStartExam(startExamId);
 		checkerOf(userContext).checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(StartExamManagerException.class);
 		
 	}
 	public StartExam transferToAnotherChangeRequest(BcexUserContext userContext, String startExamId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, startExamId,anotherChangeRequestId);
 
		StartExam startExam = loadStartExam(userContext, startExamId, allTokens());	
		synchronized(startExam){
			//will be good when the startExam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			startExam.updateChangeRequest(changeRequest);		
			startExam = saveStartExam(userContext, startExam, emptyOptions());
			
			return present(userContext,startExam, allTokens());
			
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
		SmartList<ChangeRequest> candidateList = changeRequestDaoOf(userContext).requestCandidateChangeRequestForStartExam(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String startExamId, int startExamVersion) throws Exception {
		//deleteInternal(userContext, startExamId, startExamVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String startExamId, int startExamVersion) throws Exception{
			
		startExamDaoOf(userContext).delete(startExamId, startExamVersion);
	}
	
	public StartExam forgetByAll(BcexUserContext userContext, String startExamId, int startExamVersion) throws Exception {
		return forgetByAllInternal(userContext, startExamId, startExamVersion);		
	}
	protected StartExam forgetByAllInternal(BcexUserContext userContext,
			String startExamId, int startExamVersion) throws Exception{
			
		return startExamDaoOf(userContext).disconnectFromAll(startExamId, startExamVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new StartExamManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return startExamDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, StartExam newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


