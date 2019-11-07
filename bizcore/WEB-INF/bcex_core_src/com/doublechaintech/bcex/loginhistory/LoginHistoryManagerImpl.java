
package com.doublechaintech.bcex.loginhistory;

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

import com.doublechaintech.bcex.secuser.SecUser;

import com.doublechaintech.bcex.secuser.CandidateSecUser;







public class LoginHistoryManagerImpl extends CustomBcexCheckerManager implements LoginHistoryManager {
	
	private static final String SERVICE_TYPE = "LoginHistory";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws LoginHistoryManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new LoginHistoryManagerException(message);

	}
	
	

 	protected LoginHistory saveLoginHistory(BcexUserContext userContext, LoginHistory loginHistory, String [] tokensExpr) throws Exception{	
 		//return getLoginHistoryDAO().save(loginHistory, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveLoginHistory(userContext, loginHistory, tokens);
 	}
 	
 	protected LoginHistory saveLoginHistoryDetail(BcexUserContext userContext, LoginHistory loginHistory) throws Exception{	

 		
 		return saveLoginHistory(userContext, loginHistory, allTokens());
 	}
 	
 	public LoginHistory loadLoginHistory(BcexUserContext userContext, String loginHistoryId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	
 	 public LoginHistory searchLoginHistory(BcexUserContext userContext, String loginHistoryId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,loginHistory, tokens);
 	}
 	
 	

 	protected LoginHistory present(BcexUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,loginHistory,tokens);
		
		
		LoginHistory  loginHistoryToPresent = loginHistoryDaoOf(userContext).present(loginHistory, tokens);
		
		List<BaseEntity> entityListToNaming = loginHistoryToPresent.collectRefercencesFromLists();
		loginHistoryDaoOf(userContext).alias(entityListToNaming);
		
		return  loginHistoryToPresent;
		
		
	}
 
 	
 	
 	public LoginHistory loadLoginHistoryDetail(BcexUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, allTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String loginHistoryId) throws Exception{	
 		LoginHistory loginHistory = loadLoginHistory( userContext, loginHistoryId, viewTokens());
 		return present(userContext,loginHistory, allTokens());
		
 	}
 	protected LoginHistory saveLoginHistory(BcexUserContext userContext, LoginHistory loginHistory, Map<String,Object>tokens) throws Exception{	
 		return loginHistoryDaoOf(userContext).save(loginHistory, tokens);
 	}
 	protected LoginHistory loadLoginHistory(BcexUserContext userContext, String loginHistoryId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).throwExceptionIfHasErrors( LoginHistoryManagerException.class);

 
 		return loginHistoryDaoOf(userContext).load(loginHistoryId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
		super.addActions(userContext, loginHistory, tokens);
		
		addAction(userContext, loginHistory, tokens,"@create","createLoginHistory","createLoginHistory/","main","primary");
		addAction(userContext, loginHistory, tokens,"@update","updateLoginHistory","updateLoginHistory/"+loginHistory.getId()+"/","main","primary");
		addAction(userContext, loginHistory, tokens,"@copy","cloneLoginHistory","cloneLoginHistory/"+loginHistory.getId()+"/","main","primary");
		
		addAction(userContext, loginHistory, tokens,"login_history.transfer_to_sec_user","transferToAnotherSecUser","transferToAnotherSecUser/"+loginHistory.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, LoginHistory loginHistory, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public LoginHistory createLoginHistory(BcexUserContext userContext,String fromIp, String description, String secUserId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkFromIpOfLoginHistory(fromIp);
		checkerOf(userContext).checkDescriptionOfLoginHistory(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);


		LoginHistory loginHistory=createNewLoginHistory();	

		loginHistory.setLoginTime(userContext.now());
		loginHistory.setFromIp(fromIp);
		loginHistory.setDescription(description);
			
		SecUser secUser = loadSecUser(userContext, secUserId,emptyOptions());
		loginHistory.setSecUser(secUser);
		
		

		loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
		
		onNewInstanceCreated(userContext, loginHistory);
		return loginHistory;

		
	}
	protected LoginHistory createNewLoginHistory() 
	{
		
		return new LoginHistory();		
	}
	
	protected void checkParamsForUpdatingLoginHistory(BcexUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
		checkerOf(userContext).checkVersionOfLoginHistory( loginHistoryVersion);
		

		if(LoginHistory.FROM_IP_PROPERTY.equals(property)){
			checkerOf(userContext).checkFromIpOfLoginHistory(parseString(newValueExpr));
		}
		if(LoginHistory.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfLoginHistory(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);
	
		
	}
	
	
	
	public LoginHistory clone(BcexUserContext userContext, String fromLoginHistoryId) throws Exception{
		
		return loginHistoryDaoOf(userContext).clone(fromLoginHistoryId, this.allTokens());
	}
	
	public LoginHistory internalSaveLoginHistory(BcexUserContext userContext, LoginHistory loginHistory) throws Exception 
	{
		return internalSaveLoginHistory(userContext, loginHistory, allTokens());

	}
	public LoginHistory internalSaveLoginHistory(BcexUserContext userContext, LoginHistory loginHistory, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			if (loginHistory.isChanged()){
			
			}
			loginHistory = saveLoginHistory(userContext, loginHistory, options);
			return loginHistory;
			
		}

	}
	
	public LoginHistory updateLoginHistory(BcexUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		
		
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	
	public LoginHistory updateLoginHistoryProperty(BcexUserContext userContext,String loginHistoryId, int loginHistoryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingLoginHistory(userContext, loginHistoryId, loginHistoryVersion, property, newValueExpr, tokensExpr);
		
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());
		if(loginHistory.getVersion() != loginHistoryVersion){
			String message = "The target version("+loginHistory.getVersion()+") is not equals to version("+loginHistoryVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(loginHistory){ 
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to LoginHistory.
			
			loginHistory.changeProperty(property, newValueExpr);
			
			loginHistory = saveLoginHistory(userContext, loginHistory, tokens().done());
			return present(userContext,loginHistory, mergedAllTokens(tokensExpr));
			//return saveLoginHistory(userContext, loginHistory, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected LoginHistoryTokens tokens(){
		return LoginHistoryTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return LoginHistoryTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return LoginHistoryTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherSecUser(BcexUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkIdOfSecUser(anotherSecUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}
 	public LoginHistory transferToAnotherSecUser(BcexUserContext userContext, String loginHistoryId, String anotherSecUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUser(userContext, loginHistoryId,anotherSecUserId);
 
		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUser(userContext, anotherSecUserId, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherSecUserWithLogin(BcexUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkLoginOfSecUser( anotherLogin);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithLogin(BcexUserContext userContext, String loginHistoryId, String anotherLogin) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithLogin(userContext, loginHistoryId,anotherLogin);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithLogin(userContext, anotherLogin, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	 

	protected void checkParamsForTransferingAnotherSecUserWithEmail(BcexUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkEmailOfSecUser( anotherEmail);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithEmail(BcexUserContext userContext, String loginHistoryId, String anotherEmail) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithEmail(userContext, loginHistoryId,anotherEmail);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithEmail(userContext, anotherEmail, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	 

	protected void checkParamsForTransferingAnotherSecUserWithMobile(BcexUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfLoginHistory(loginHistoryId);
 		checkerOf(userContext).checkMobileOfSecUser( anotherMobile);
 		checkerOf(userContext).throwExceptionIfHasErrors(LoginHistoryManagerException.class);
 		
 	}

 	public LoginHistory transferToAnotherSecUserWithMobile(BcexUserContext userContext, String loginHistoryId, String anotherMobile) throws Exception
 	{
 		checkParamsForTransferingAnotherSecUserWithMobile(userContext, loginHistoryId,anotherMobile);
 		LoginHistory loginHistory = loadLoginHistory(userContext, loginHistoryId, allTokens());	
		synchronized(loginHistory){
			//will be good when the loginHistory loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			SecUser secUser = loadSecUserWithMobile(userContext, anotherMobile, emptyOptions());		
			loginHistory.updateSecUser(secUser);		
			loginHistory = saveLoginHistory(userContext, loginHistory, emptyOptions());
			
			return present(userContext,loginHistory, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateSecUser requestCandidateSecUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("login");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<SecUser> candidateList = secUserDaoOf(userContext).requestCandidateSecUserForLoginHistory(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected SecUser loadSecUser(BcexUserContext userContext, String newSecUserId, Map<String,Object> options) throws Exception
 	{
		
 		return secUserDaoOf(userContext).load(newSecUserId, options);
 	}
 	
 	protected SecUser loadSecUserWithLogin(BcexUserContext userContext, String newLogin, Map<String,Object> options) throws Exception
 	{
		
 		return secUserDaoOf(userContext).loadByLogin(newLogin, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithEmail(BcexUserContext userContext, String newEmail, Map<String,Object> options) throws Exception
 	{
		
 		return secUserDaoOf(userContext).loadByEmail(newEmail, options);
 	}
 	
 	
 	protected SecUser loadSecUserWithMobile(BcexUserContext userContext, String newMobile, Map<String,Object> options) throws Exception
 	{
		
 		return secUserDaoOf(userContext).loadByMobile(newMobile, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		//deleteInternal(userContext, loginHistoryId, loginHistoryVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{
			
		loginHistoryDaoOf(userContext).delete(loginHistoryId, loginHistoryVersion);
	}
	
	public LoginHistory forgetByAll(BcexUserContext userContext, String loginHistoryId, int loginHistoryVersion) throws Exception {
		return forgetByAllInternal(userContext, loginHistoryId, loginHistoryVersion);		
	}
	protected LoginHistory forgetByAllInternal(BcexUserContext userContext,
			String loginHistoryId, int loginHistoryVersion) throws Exception{
			
		return loginHistoryDaoOf(userContext).disconnectFromAll(loginHistoryId, loginHistoryVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new LoginHistoryManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return loginHistoryDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, LoginHistory newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


