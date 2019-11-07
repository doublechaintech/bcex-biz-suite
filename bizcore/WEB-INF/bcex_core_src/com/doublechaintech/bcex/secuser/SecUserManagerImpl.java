
package com.doublechaintech.bcex.secuser;

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

import com.doublechaintech.bcex.userapp.UserApp;
import com.doublechaintech.bcex.secuserblocking.SecUserBlocking;
import com.doublechaintech.bcex.userdomain.UserDomain;
import com.doublechaintech.bcex.loginhistory.LoginHistory;

import com.doublechaintech.bcex.secuserblocking.CandidateSecUserBlocking;
import com.doublechaintech.bcex.userdomain.CandidateUserDomain;

import com.doublechaintech.bcex.secuser.SecUser;






public class SecUserManagerImpl extends CustomBcexCheckerManager implements SecUserManager {
	
	private static final String SERVICE_TYPE = "SecUser";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws SecUserManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new SecUserManagerException(message);

	}
	
	

 	protected SecUser saveSecUser(BcexUserContext userContext, SecUser secUser, String [] tokensExpr) throws Exception{	
 		//return getSecUserDAO().save(secUser, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveSecUser(userContext, secUser, tokens);
 	}
 	
 	protected SecUser saveSecUserDetail(BcexUserContext userContext, SecUser secUser) throws Exception{	

 		
 		return saveSecUser(userContext, secUser, allTokens());
 	}
 	
 	public SecUser loadSecUser(BcexUserContext userContext, String secUserId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}
 	
 	
 	 public SecUser searchSecUser(BcexUserContext userContext, String secUserId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		SecUser secUser = loadSecUser( userContext, secUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,secUser, tokens);
 	}
 	
 	

 	protected SecUser present(BcexUserContext userContext, SecUser secUser, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,secUser,tokens);
		
		
		SecUser  secUserToPresent = secUserDaoOf(userContext).present(secUser, tokens);
		
		List<BaseEntity> entityListToNaming = secUserToPresent.collectRefercencesFromLists();
		secUserDaoOf(userContext).alias(entityListToNaming);
		
		return  secUserToPresent;
		
		
	}
 
 	
 	
 	public SecUser loadSecUserDetail(BcexUserContext userContext, String secUserId) throws Exception{	
 		SecUser secUser = loadSecUser( userContext, secUserId, allTokens());
 		return present(userContext,secUser, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String secUserId) throws Exception{	
 		SecUser secUser = loadSecUser( userContext, secUserId, viewTokens());
 		return present(userContext,secUser, allTokens());
		
 	}
 	protected SecUser saveSecUser(BcexUserContext userContext, SecUser secUser, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).save(secUser, tokens);
 	}
 	protected SecUser loadSecUser(BcexUserContext userContext, String secUserId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( SecUserManagerException.class);

 
 		return secUserDaoOf(userContext).load(secUserId, tokens);
 	}

	
	

	public SecUser loadSecUserWithLogin(BcexUserContext userContext, String login, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByLogin(login, tokens);
 	}

	 
	

	public SecUser loadSecUserWithEmail(BcexUserContext userContext, String email, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByEmail(email, tokens);
 	}

	 
	

	public SecUser loadSecUserWithMobile(BcexUserContext userContext, String mobile, Map<String,Object>tokens) throws Exception{	
 		return secUserDaoOf(userContext).loadByMobile(mobile, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, SecUser secUser, Map<String, Object> tokens){
		super.addActions(userContext, secUser, tokens);
		
		addAction(userContext, secUser, tokens,"@create","createSecUser","createSecUser/","main","primary");
		addAction(userContext, secUser, tokens,"@update","updateSecUser","updateSecUser/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"@copy","cloneSecUser","cloneSecUser/"+secUser.getId()+"/","main","primary");
		
		addAction(userContext, secUser, tokens,"sec_user.transfer_to_domain","transferToAnotherDomain","transferToAnotherDomain/"+secUser.getId()+"/","main","primary");
		addAction(userContext, secUser, tokens,"sec_user.block","block","blockActionForm/"+secUser.getId()+"/","main","danger");
		addAction(userContext, secUser, tokens,"sec_user.addUserApp","addUserApp","addUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeUserApp","removeUserApp","removeUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateUserApp","updateUserApp","updateUserApp/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyUserAppFrom","copyUserAppFrom","copyUserAppFrom/"+secUser.getId()+"/","userAppList","primary");
		addAction(userContext, secUser, tokens,"sec_user.addLoginHistory","addLoginHistory","addLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.removeLoginHistory","removeLoginHistory","removeLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.updateLoginHistory","updateLoginHistory","updateLoginHistory/"+secUser.getId()+"/","loginHistoryList","primary");
		addAction(userContext, secUser, tokens,"sec_user.copyLoginHistoryFrom","copyLoginHistoryFrom","copyLoginHistoryFrom/"+secUser.getId()+"/","loginHistoryList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, SecUser secUser, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public SecUser createSecUser(BcexUserContext userContext,String login, String mobile, String email, String pwd, String weixinOpenid, String weixinAppid, String accessToken, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, String domainId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkLoginOfSecUser(login);
		checkerOf(userContext).checkMobileOfSecUser(mobile);
		checkerOf(userContext).checkEmailOfSecUser(email);
		checkerOf(userContext).checkPwdOfSecUser(pwd);
		checkerOf(userContext).checkWeixinOpenidOfSecUser(weixinOpenid);
		checkerOf(userContext).checkWeixinAppidOfSecUser(weixinAppid);
		checkerOf(userContext).checkAccessTokenOfSecUser(accessToken);
		checkerOf(userContext).checkVerificationCodeOfSecUser(verificationCode);
		checkerOf(userContext).checkVerificationCodeExpireOfSecUser(verificationCodeExpire);
		checkerOf(userContext).checkLastLoginTimeOfSecUser(lastLoginTime);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);


		SecUser secUser=createNewSecUser();	

		secUser.setLogin(login);
		secUser.setMobile(mobile);
		secUser.setEmail(email);
		secUser.setClearTextOfPwd(pwd);
		secUser.setWeixinOpenid(weixinOpenid);
		secUser.setWeixinAppid(weixinAppid);
		secUser.setAccessToken(accessToken);
		secUser.setVerificationCode(verificationCode);
		secUser.setVerificationCodeExpire(verificationCodeExpire);
		secUser.setLastLoginTime(lastLoginTime);
			
		UserDomain domain = loadUserDomain(userContext, domainId,emptyOptions());
		secUser.setDomain(domain);
		
		
		secUser.setCurrentStatus("INIT");

		secUser = saveSecUser(userContext, secUser, emptyOptions());
		
		onNewInstanceCreated(userContext, secUser);
		return secUser;

		
	}
	protected SecUser createNewSecUser() 
	{
		
		return new SecUser();		
	}
	
	protected void checkParamsForUpdatingSecUser(BcexUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkVersionOfSecUser( secUserVersion);
		

		if(SecUser.LOGIN_PROPERTY.equals(property)){
			checkerOf(userContext).checkLoginOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.MOBILE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMobileOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.EMAIL_PROPERTY.equals(property)){
			checkerOf(userContext).checkEmailOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.PWD_PROPERTY.equals(property)){
			checkerOf(userContext).checkPwdOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.WEIXIN_OPENID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinOpenidOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.WEIXIN_APPID_PROPERTY.equals(property)){
			checkerOf(userContext).checkWeixinAppidOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.ACCESS_TOKEN_PROPERTY.equals(property)){
			checkerOf(userContext).checkAccessTokenOfSecUser(parseString(newValueExpr));
		}
		if(SecUser.VERIFICATION_CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeOfSecUser(parseInt(newValueExpr));
		}
		if(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
			checkerOf(userContext).checkVerificationCodeExpireOfSecUser(parseTimestamp(newValueExpr));
		}
		if(SecUser.LAST_LOGIN_TIME_PROPERTY.equals(property)){
			checkerOf(userContext).checkLastLoginTimeOfSecUser(parseTimestamp(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
		
	}
	
	
	
	public SecUser clone(BcexUserContext userContext, String fromSecUserId) throws Exception{
		
		return secUserDaoOf(userContext).clone(fromSecUserId, this.allTokens());
	}
	
	public SecUser internalSaveSecUser(BcexUserContext userContext, SecUser secUser) throws Exception 
	{
		return internalSaveSecUser(userContext, secUser, allTokens());

	}
	public SecUser internalSaveSecUser(BcexUserContext userContext, SecUser secUser, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(secUser){ 
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			if (secUser.isChanged()){
			
			}
			secUser = saveSecUser(userContext, secUser, options);
			return secUser;
			
		}

	}
	
	public SecUser updateSecUser(BcexUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);
		
		
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		if(secUser.getVersion() != secUserVersion){
			String message = "The target version("+secUser.getVersion()+") is not equals to version("+secUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUser){ 
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			
			secUser.changeProperty(property, newValueExpr);
			secUser = saveSecUser(userContext, secUser, tokens().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
			//return saveSecUser(userContext, secUser, tokens().done());
		}

	}
	
	public SecUser updateSecUserProperty(BcexUserContext userContext,String secUserId, int secUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingSecUser(userContext, secUserId, secUserVersion, property, newValueExpr, tokensExpr);
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		if(secUser.getVersion() != secUserVersion){
			String message = "The target version("+secUser.getVersion()+") is not equals to version("+secUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(secUser){ 
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to SecUser.
			
			secUser.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
			//return saveSecUser(userContext, secUser, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected SecUserTokens tokens(){
		return SecUserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return SecUserTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserAppListWith("id","desc")
		.sortLoginHistoryListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return SecUserTokens.mergeAll(tokens).done();
	}
	
	private static final String [] STATUS_SEQUENCE={"BLOCKED"};
 	protected String[] getNextCandidateStatus(BcexUserContext userContext, String currentStatus) throws Exception{
 	
 		if("INIT".equals(currentStatus)){
 			//if current status is null, just return the first status as the next status
 			//code makes sure not throwing ArrayOutOfIndexException here.
 			return STATUS_SEQUENCE;
 		}
 		/*
 		List<String> statusList = Arrays.asList(STATUS_SEQUENCE);
 		int index = statusList.indexOf(currentStatus);
 		if(index < 0){
 			throwExceptionWithMessage("The status '"+currentStatus+"' is not found from status list: "+ statusList );
 		}
 		if(index + 1 == statusList.size()){
 			//this is the last status code; no next status any more
 			return null;
 		}
 		
 		//this is not the last one, just return it.
 		*/
 		return STATUS_SEQUENCE;
 	
 	}/**/
 	protected void ensureStatus(BcexUserContext userContext, SecUser secUser, String expectedNextStatus) throws Exception{
		String currentStatus = secUser.getCurrentStatus();
		//'null' is fine for function getNextStatus
		String candidateStatus[] = getNextCandidateStatus(userContext, currentStatus);
		
		if(candidateStatus == null){
			//no more next status
			String message = "No next status for '"+currentStatus+"', but you want to put the status to 'HIDDEN'";
			throwExceptionWithMessage(message);
		}
		int index = Arrays.asList(candidateStatus).indexOf(expectedNextStatus);
		if(index<0){
			String message = "The current status '"+currentStatus+"' next candidate status should be one of '"+candidateStatus+"', but you want to transit the status to '"+expectedNextStatus+"'";
			throwExceptionWithMessage(message);
		}
	}
	
	protected void checkParamsForTransferingAnotherDomain(BcexUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
 		checkerOf(userContext).checkIdOfUserDomain(anotherDomainId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
 		
 	}
 	public SecUser transferToAnotherDomain(BcexUserContext userContext, String secUserId, String anotherDomainId) throws Exception
 	{
 		checkParamsForTransferingAnotherDomain(userContext, secUserId,anotherDomainId);
 
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());	
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			UserDomain domain = loadUserDomain(userContext, anotherDomainId, emptyOptions());		
			secUser.updateDomain(domain);		
			secUser = saveSecUser(userContext, secUser, emptyOptions());
			
			return present(userContext,secUser, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateUserDomain requestCandidateDomain(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateUserDomain result = new CandidateUserDomain();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<UserDomain> candidateList = userDomainDaoOf(userContext).requestCandidateUserDomainForSecUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherBlocking(BcexUserContext userContext, String secUserId, String anotherBlockingId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfSecUser(secUserId);
 		checkerOf(userContext).checkIdOfSecUserBlocking(anotherBlockingId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
 		
 	}
 	public SecUser transferToAnotherBlocking(BcexUserContext userContext, String secUserId, String anotherBlockingId) throws Exception
 	{
 		checkParamsForTransferingAnotherBlocking(userContext, secUserId,anotherBlockingId);
 
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());	
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUserBlocking blocking = loadSecUserBlocking(userContext, anotherBlockingId, emptyOptions());		
			secUser.updateBlocking(blocking);		
			secUser = saveSecUser(userContext, secUser, emptyOptions());
			
			return present(userContext,secUser, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateSecUserBlocking requestCandidateBlocking(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUserBlocking result = new CandidateSecUserBlocking();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("who");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUserBlocking> candidateList = secUserBlockingDaoOf(userContext).requestCandidateSecUserBlockingForSecUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	
	public static final String BLOCKED_STATUS = "BLOCKED";
 	protected void checkParamsForBlocking(BcexUserContext userContext, String secUserId, String who, String comments
) throws Exception
 	{
 				checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkWhoOfSecUserBlocking(who);
		checkerOf(userContext).checkCommentsOfSecUserBlocking(comments);

	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

 	}
 	public SecUser block(BcexUserContext userContext, String secUserId, String who, String comments
) throws Exception
 	{
		checkParamsForBlocking(userContext, secUserId, who, comments);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());	
		synchronized(secUser){
			//will be good when the secUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			
			checkIfEligibleForBlocking(userContext,secUser);
 		

			secUser.updateCurrentStatus(BLOCKED_STATUS);
			//set the new status, it will be good if add constant to the bean definition
			
			//extract all referenced objects, load them respectively


			SecUserBlocking blocking = createBlocking(userContext, who, comments);		
			secUser.updateBlocking(blocking);		
			
			
			secUser = saveSecUser(userContext, secUser, tokens().withBlocking().done());
			return present(userContext,secUser, allTokens());
			
		}

 	}
 	
 	
 	
 	
 	public SecUserForm blockActionForm(BcexUserContext userContext, String secUserId) throws Exception
 	{
		return new SecUserForm()
			.withTitle("block")
			.secUserIdField(secUserId)
			.whoFieldOfSecUserBlocking()
			.commentsFieldOfSecUserBlocking()
			.blockAction();
 	}
	
 	
 	protected SecUserBlocking createBlocking(BcexUserContext userContext, String who, String comments){
 		SecUserBlocking blocking = new SecUserBlocking();
 		//who, comments
 		
		blocking.setWho(who);
		blocking.setBlockTime(userContext.now());
		blocking.setComments(comments);

 		
 		
 		
 		return secUserBlockingDaoOf(userContext).save(blocking,emptyOptions());
 	}
 	protected void checkIfEligibleForBlocking(BcexUserContext userContext, SecUser secUser) throws Exception{
 
 		ensureStatus(userContext,secUser, BLOCKED_STATUS);
 		
 		SecUserBlocking blocking = secUser.getBlocking();
 		//check the current status equals to the status
 		//String expectedCurrentStatus = blocking 		
 		//if the previous is the expected status?
 		
 		
 		//if already transited to this status?
 		
 		if( blocking != null){
				throwExceptionWithMessage("The SecUser("+secUser.getId()+") has already been "+ BLOCKED_STATUS+".");
		}
 		
 		
 	}
//--------------------------------------------------------------
	
	 	
 	protected UserDomain loadUserDomain(BcexUserContext userContext, String newDomainId, Map<String,Object> options) throws Exception
 	{
		
 		return userDomainDaoOf(userContext).load(newDomainId, options);
 	}
 	
 	
 	
	
	 	
 	protected SecUserBlocking loadSecUserBlocking(BcexUserContext userContext, String newBlockingId, Map<String,Object> options) throws Exception
 	{
		
 		return secUserBlockingDaoOf(userContext).load(newBlockingId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String secUserId, int secUserVersion) throws Exception {
		//deleteInternal(userContext, secUserId, secUserVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String secUserId, int secUserVersion) throws Exception{
			
		secUserDaoOf(userContext).delete(secUserId, secUserVersion);
	}
	
	public SecUser forgetByAll(BcexUserContext userContext, String secUserId, int secUserVersion) throws Exception {
		return forgetByAllInternal(userContext, secUserId, secUserVersion);		
	}
	protected SecUser forgetByAllInternal(BcexUserContext userContext,
			String secUserId, int secUserVersion) throws Exception{
			
		return secUserDaoOf(userContext).disconnectFromAll(secUserId, secUserVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new SecUserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return secUserDaoOf(userContext).deleteAll();
	}


	//disconnect SecUser with object_id in UserApp
	protected SecUser breakWithUserAppByObjectId(BcexUserContext userContext, String secUserId, String objectIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());

			synchronized(secUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				secUserDaoOf(userContext).planToRemoveUserAppListWithObjectId(secUser, objectIdId, this.emptyOptions());

				secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
				return secUser;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingUserApp(BcexUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkTitleOfUserApp(title);
		
		checkerOf(userContext).checkAppIconOfUserApp(appIcon);
		
		checkerOf(userContext).checkFullAccessOfUserApp(fullAccess);
		
		checkerOf(userContext).checkPermissionOfUserApp(permission);
		
		checkerOf(userContext).checkObjectTypeOfUserApp(objectType);
		
		checkerOf(userContext).checkObjectIdOfUserApp(objectId);
		
		checkerOf(userContext).checkLocationOfUserApp(location);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	
	}
	public  SecUser addUserApp(BcexUserContext userContext, String secUserId, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserApp(userContext,secUserId,title, appIcon, fullAccess, permission, objectType, objectId, location,tokensExpr);
		
		UserApp userApp = createUserApp(userContext,title, appIcon, fullAccess, permission, objectType, objectId, location);
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addUserApp( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			
			userContext.getManagerGroup().getUserAppManager().onNewInstanceCreated(userContext, userApp);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAppProperties(BcexUserContext userContext, String secUserId,String id,String title,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfUserApp(id);
		
		checkerOf(userContext).checkTitleOfUserApp( title);
		checkerOf(userContext).checkAppIconOfUserApp( appIcon);
		checkerOf(userContext).checkFullAccessOfUserApp( fullAccess);
		checkerOf(userContext).checkPermissionOfUserApp( permission);
		checkerOf(userContext).checkObjectTypeOfUserApp( objectType);
		checkerOf(userContext).checkObjectIdOfUserApp( objectId);
		checkerOf(userContext).checkLocationOfUserApp( location);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
		
	}
	public  SecUser updateUserAppProperties(BcexUserContext userContext, String secUserId, String id,String title,String appIcon,boolean fullAccess,String permission,String objectType,String objectId,String location, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAppProperties(userContext,secUserId,id,title,appIcon,fullAccess,permission,objectType,objectId,location,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAppListList()
				.searchUserAppListWith(UserApp.ID_PROPERTY, "is", id).done();
		
		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);
		
		if(secUserToUpdate.getUserAppList().isEmpty()){
			throw new SecUserManagerException("UserApp is NOT FOUND with id: '"+id+"'");
		}
		
		UserApp item = secUserToUpdate.getUserAppList().first();
		
		item.updateTitle( title );
		item.updateAppIcon( appIcon );
		item.updateFullAccess( fullAccess );
		item.updatePermission( permission );
		item.updateObjectType( objectType );
		item.updateObjectId( objectId );
		item.updateLocation( location );

		
		//checkParamsForAddingUserApp(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withUserAppList().done());
		synchronized(secUser){ 
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserApp createUserApp(BcexUserContext userContext, String title, String appIcon, boolean fullAccess, String permission, String objectType, String objectId, String location) throws Exception{

		UserApp userApp = new UserApp();
		
		
		userApp.setTitle(title);		
		userApp.setAppIcon(appIcon);		
		userApp.setFullAccess(fullAccess);		
		userApp.setPermission(permission);		
		userApp.setObjectType(objectType);		
		userApp.setObjectId(objectId);		
		userApp.setLocation(location);
	
		
		return userApp;
	
		
	}
	
	protected UserApp createIndexedUserApp(String id, int version){

		UserApp userApp = new UserApp();
		userApp.setId(id);
		userApp.setVersion(version);
		return userApp;			
		
	}
	
	protected void checkParamsForRemovingUserAppList(BcexUserContext userContext, String secUserId, 
			String userAppIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String userAppIdItem: userAppIds){
			checkerOf(userContext).checkIdOfUserApp(userAppIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
		
	}
	public  SecUser removeUserAppList(BcexUserContext userContext, String secUserId, 
			String userAppIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAppList(userContext, secUserId,  userAppIds, tokensExpr);
			
			
			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){ 
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveUserAppList(secUser, userAppIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
				deleteRelationListInGraph(userContext, secUser.getUserAppList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserApp(BcexUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	public  SecUser removeUserApp(BcexUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);
		
		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeUserApp( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			deleteRelationInGraph(userContext, userApp);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserApp(BcexUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	public  SecUser copyUserAppFrom(BcexUserContext userContext, String secUserId, 
		String userAppId, int userAppVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserApp(userContext,secUserId, userAppId, userAppVersion,tokensExpr);
		
		UserApp userApp = createIndexedUserApp(userAppId, userAppVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			secUser.copyUserAppFrom( userApp );		
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			
			userContext.getManagerGroup().getUserAppManager().onNewInstanceCreated(userContext, (UserApp)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserApp(BcexUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfUserApp(userAppId);
		checkerOf(userContext).checkVersionOfUserApp(userAppVersion);
		

		if(UserApp.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.APP_ICON_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppIconOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.FULL_ACCESS_PROPERTY.equals(property)){
			checkerOf(userContext).checkFullAccessOfUserApp(parseBoolean(newValueExpr));
		}
		
		if(UserApp.PERMISSION_PROPERTY.equals(property)){
			checkerOf(userContext).checkPermissionOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.OBJECT_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkObjectTypeOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.OBJECT_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkObjectIdOfUserApp(parseString(newValueExpr));
		}
		
		if(UserApp.LOCATION_PROPERTY.equals(property)){
			checkerOf(userContext).checkLocationOfUserApp(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	
	public  SecUser updateUserApp(BcexUserContext userContext, String secUserId, String userAppId, int userAppVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserApp(userContext, secUserId, userAppId, userAppVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAppList().searchUserAppListWith(UserApp.ID_PROPERTY, "eq", userAppId).done();
		
		
		
		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);
		
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeUserApp( userApp );	
			//make changes to AcceleraterAccount.
			UserApp userAppIndex = createIndexedUserApp(userAppId, userAppVersion);
		
			UserApp userApp = secUser.findTheUserApp(userAppIndex);
			if(userApp == null){
				throw new SecUserManagerException(userApp+" is NOT FOUND" );
			}
			
			userApp.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withUserAppList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingLoginHistory(BcexUserContext userContext, String secUserId, String fromIp, String description,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfSecUser(secUserId);

		
		checkerOf(userContext).checkFromIpOfLoginHistory(fromIp);
		
		checkerOf(userContext).checkDescriptionOfLoginHistory(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);

	
	}
	public  SecUser addLoginHistory(BcexUserContext userContext, String secUserId, String fromIp, String description, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingLoginHistory(userContext,secUserId,fromIp, description,tokensExpr);
		
		LoginHistory loginHistory = createLoginHistory(userContext,fromIp, description);
		
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.addLoginHistory( loginHistory );		
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			
			userContext.getManagerGroup().getLoginHistoryManager().onNewInstanceCreated(userContext, loginHistory);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingLoginHistoryProperties(BcexUserContext userContext, String secUserId,String id,String fromIp,String description,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(id);
		
		checkerOf(userContext).checkFromIpOfLoginHistory( fromIp);
		checkerOf(userContext).checkDescriptionOfLoginHistory( description);

		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
		
	}
	public  SecUser updateLoginHistoryProperties(BcexUserContext userContext, String secUserId, String id,String fromIp,String description, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingLoginHistoryProperties(userContext,secUserId,id,fromIp,description,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withLoginHistoryListList()
				.searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, "is", id).done();
		
		SecUser secUserToUpdate = loadSecUser(userContext, secUserId, options);
		
		if(secUserToUpdate.getLoginHistoryList().isEmpty()){
			throw new SecUserManagerException("LoginHistory is NOT FOUND with id: '"+id+"'");
		}
		
		LoginHistory item = secUserToUpdate.getLoginHistoryList().first();
		
		item.updateFromIp( fromIp );
		item.updateDescription( description );

		
		//checkParamsForAddingLoginHistory(userContext,secUserId,name, code, used,tokensExpr);
		SecUser secUser = saveSecUser(userContext, secUserToUpdate, tokens().withLoginHistoryList().done());
		synchronized(secUser){ 
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected LoginHistory createLoginHistory(BcexUserContext userContext, String fromIp, String description) throws Exception{

		LoginHistory loginHistory = new LoginHistory();
		
		
		loginHistory.setLoginTime(userContext.now());		
		loginHistory.setFromIp(fromIp);		
		loginHistory.setDescription(description);
	
		
		return loginHistory;
	
		
	}
	
	protected LoginHistory createIndexedLoginHistory(String id, int version){

		LoginHistory loginHistory = new LoginHistory();
		loginHistory.setId(id);
		loginHistory.setVersion(version);
		return loginHistory;			
		
	}
	
	protected void checkParamsForRemovingLoginHistoryList(BcexUserContext userContext, String secUserId, 
			String loginHistoryIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		for(String loginHistoryIdItem: loginHistoryIds){
			checkerOf(userContext).checkIdOfLoginHistory(loginHistoryIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
		
	}
	public  SecUser removeLoginHistoryList(BcexUserContext userContext, String secUserId, 
			String loginHistoryIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingLoginHistoryList(userContext, secUserId,  loginHistoryIds, tokensExpr);
			
			
			SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
			synchronized(secUser){ 
				//Will be good when the secUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				secUserDaoOf(userContext).planToRemoveLoginHistoryList(secUser, loginHistoryIds, allTokens());
				secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
				deleteRelationListInGraph(userContext, secUser.getLoginHistoryList());
				return present(userContext,secUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingLoginHistory(BcexUserContext userContext, String secUserId, 
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	public  SecUser removeLoginHistory(BcexUserContext userContext, String secUserId, 
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingLoginHistory(userContext,secUserId, loginHistoryId, loginHistoryVersion,tokensExpr);
		
		LoginHistory loginHistory = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			secUser.removeLoginHistory( loginHistory );		
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			deleteRelationInGraph(userContext, loginHistory);
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingLoginHistory(BcexUserContext userContext, String secUserId, 
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfSecUser( secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	public  SecUser copyLoginHistoryFrom(BcexUserContext userContext, String secUserId, 
		String loginHistoryId, int loginHistoryVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingLoginHistory(userContext,secUserId, loginHistoryId, loginHistoryVersion,tokensExpr);
		
		LoginHistory loginHistory = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);
		SecUser secUser = loadSecUser(userContext, secUserId, allTokens());
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			secUser.copyLoginHistoryFrom( loginHistory );		
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			
			userContext.getManagerGroup().getLoginHistoryManager().onNewInstanceCreated(userContext, (LoginHistory)secUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingLoginHistory(BcexUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfSecUser(secUserId);
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory(loginHistoryVersion);
		

		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
			checkerOf(userContext).checkFromIpOfLoginHistory(parseString(newValueExpr));
		}
		
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfLoginHistory(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(SecUserManagerException.class);
	
	}
	
	public  SecUser updateLoginHistory(BcexUserContext userContext, String secUserId, String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingLoginHistory(userContext, secUserId, loginHistoryId, loginHistoryVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withLoginHistoryList().searchLoginHistoryListWith(LoginHistory.ID_PROPERTY, "eq", loginHistoryId).done();
		
		
		
		SecUser secUser = loadSecUser(userContext, secUserId, loadTokens);
		
		synchronized(secUser){ 
			//Will be good when the secUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//secUser.removeLoginHistory( loginHistory );	
			//make changes to AcceleraterAccount.
			LoginHistory loginHistoryIndex = createIndexedLoginHistory(loginHistoryId, loginHistoryVersion);
		
			LoginHistory loginHistory = secUser.findTheLoginHistory(loginHistoryIndex);
			if(loginHistory == null){
				throw new SecUserManagerException(loginHistory+" is NOT FOUND" );
			}
			
			loginHistory.changeProperty(property, newValueExpr);
			
			secUser = saveSecUser(userContext, secUser, tokens().withLoginHistoryList().done());
			return present(userContext,secUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, SecUser newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


