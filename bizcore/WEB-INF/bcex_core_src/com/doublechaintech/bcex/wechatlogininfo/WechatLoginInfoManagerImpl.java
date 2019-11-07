
package com.doublechaintech.bcex.wechatlogininfo;

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

import com.doublechaintech.bcex.wechatuser.CandidateWechatUser;







public class WechatLoginInfoManagerImpl extends CustomBcexCheckerManager implements WechatLoginInfoManager {
	
	private static final String SERVICE_TYPE = "WechatLoginInfo";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws WechatLoginInfoManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new WechatLoginInfoManagerException(message);

	}
	
	

 	protected WechatLoginInfo saveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, String [] tokensExpr) throws Exception{	
 		//return getWechatLoginInfoDAO().save(wechatLoginInfo, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatLoginInfo(userContext, wechatLoginInfo, tokens);
 	}
 	
 	protected WechatLoginInfo saveWechatLoginInfoDetail(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo) throws Exception{	

 		
 		return saveWechatLoginInfo(userContext, wechatLoginInfo, allTokens());
 	}
 	
 	public WechatLoginInfo loadWechatLoginInfo(BcexUserContext userContext, String wechatLoginInfoId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatLoginInfoManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo( userContext, wechatLoginInfoId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatLoginInfo, tokens);
 	}
 	
 	
 	 public WechatLoginInfo searchWechatLoginInfo(BcexUserContext userContext, String wechatLoginInfoId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatLoginInfoManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo( userContext, wechatLoginInfoId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatLoginInfo, tokens);
 	}
 	
 	

 	protected WechatLoginInfo present(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatLoginInfo,tokens);
		
		
		WechatLoginInfo  wechatLoginInfoToPresent = wechatLoginInfoDaoOf(userContext).present(wechatLoginInfo, tokens);
		
		List<BaseEntity> entityListToNaming = wechatLoginInfoToPresent.collectRefercencesFromLists();
		wechatLoginInfoDaoOf(userContext).alias(entityListToNaming);
		
		return  wechatLoginInfoToPresent;
		
		
	}
 
 	
 	
 	public WechatLoginInfo loadWechatLoginInfoDetail(BcexUserContext userContext, String wechatLoginInfoId) throws Exception{	
 		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo( userContext, wechatLoginInfoId, allTokens());
 		return present(userContext,wechatLoginInfo, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String wechatLoginInfoId) throws Exception{	
 		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo( userContext, wechatLoginInfoId, viewTokens());
 		return present(userContext,wechatLoginInfo, allTokens());
		
 	}
 	protected WechatLoginInfo saveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, Map<String,Object>tokens) throws Exception{	
 		return wechatLoginInfoDaoOf(userContext).save(wechatLoginInfo, tokens);
 	}
 	protected WechatLoginInfo loadWechatLoginInfo(BcexUserContext userContext, String wechatLoginInfoId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatLoginInfoManagerException.class);

 
 		return wechatLoginInfoDaoOf(userContext).load(wechatLoginInfoId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, Map<String, Object> tokens){
		super.addActions(userContext, wechatLoginInfo, tokens);
		
		addAction(userContext, wechatLoginInfo, tokens,"@create","createWechatLoginInfo","createWechatLoginInfo/","main","primary");
		addAction(userContext, wechatLoginInfo, tokens,"@update","updateWechatLoginInfo","updateWechatLoginInfo/"+wechatLoginInfo.getId()+"/","main","primary");
		addAction(userContext, wechatLoginInfo, tokens,"@copy","cloneWechatLoginInfo","cloneWechatLoginInfo/"+wechatLoginInfo.getId()+"/","main","primary");
		
		addAction(userContext, wechatLoginInfo, tokens,"wechat_login_info.transfer_to_wechat_user","transferToAnotherWechatUser","transferToAnotherWechatUser/"+wechatLoginInfo.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public WechatLoginInfo createWechatLoginInfo(BcexUserContext userContext,String wechatUserId, String appId, String openId, String sessionKey) throws Exception
	{
		
		

		

		checkerOf(userContext).checkAppIdOfWechatLoginInfo(appId);
		checkerOf(userContext).checkOpenIdOfWechatLoginInfo(openId);
		checkerOf(userContext).checkSessionKeyOfWechatLoginInfo(sessionKey);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatLoginInfoManagerException.class);


		WechatLoginInfo wechatLoginInfo=createNewWechatLoginInfo();	

			
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId,emptyOptions());
		wechatLoginInfo.setWechatUser(wechatUser);
		
		
		wechatLoginInfo.setAppId(appId);
		wechatLoginInfo.setOpenId(openId);
		wechatLoginInfo.setSessionKey(sessionKey);
		wechatLoginInfo.setLastUpdateTime(userContext.now());

		wechatLoginInfo = saveWechatLoginInfo(userContext, wechatLoginInfo, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatLoginInfo);
		return wechatLoginInfo;

		
	}
	protected WechatLoginInfo createNewWechatLoginInfo() 
	{
		
		return new WechatLoginInfo();		
	}
	
	protected void checkParamsForUpdatingWechatLoginInfo(BcexUserContext userContext,String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).checkVersionOfWechatLoginInfo( wechatLoginInfoVersion);
		
		

		
		if(WechatLoginInfo.APP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppIdOfWechatLoginInfo(parseString(newValueExpr));
		}
		if(WechatLoginInfo.OPEN_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkOpenIdOfWechatLoginInfo(parseString(newValueExpr));
		}
		if(WechatLoginInfo.SESSION_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkSessionKeyOfWechatLoginInfo(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatLoginInfoManagerException.class);
	
		
	}
	
	
	
	public WechatLoginInfo clone(BcexUserContext userContext, String fromWechatLoginInfoId) throws Exception{
		
		return wechatLoginInfoDaoOf(userContext).clone(fromWechatLoginInfoId, this.allTokens());
	}
	
	public WechatLoginInfo internalSaveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo) throws Exception 
	{
		return internalSaveWechatLoginInfo(userContext, wechatLoginInfo, allTokens());

	}
	public WechatLoginInfo internalSaveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingWechatLoginInfo(userContext, wechatLoginInfoId, wechatLoginInfoVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(wechatLoginInfo){ 
			//will be good when the wechatLoginInfo loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatLoginInfo.
			if (wechatLoginInfo.isChanged()){
			wechatLoginInfo.updateLastUpdateTime(userContext.now());
			}
			wechatLoginInfo = saveWechatLoginInfo(userContext, wechatLoginInfo, options);
			return wechatLoginInfo;
			
		}

	}
	
	public WechatLoginInfo updateWechatLoginInfo(BcexUserContext userContext,String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatLoginInfo(userContext, wechatLoginInfoId, wechatLoginInfoVersion, property, newValueExpr, tokensExpr);
		
		
		
		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo(userContext, wechatLoginInfoId, allTokens());
		if(wechatLoginInfo.getVersion() != wechatLoginInfoVersion){
			String message = "The target version("+wechatLoginInfo.getVersion()+") is not equals to version("+wechatLoginInfoVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatLoginInfo){ 
			//will be good when the wechatLoginInfo loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatLoginInfo.
			wechatLoginInfo.updateLastUpdateTime(userContext.now());
			wechatLoginInfo.changeProperty(property, newValueExpr);
			wechatLoginInfo = saveWechatLoginInfo(userContext, wechatLoginInfo, tokens().done());
			return present(userContext,wechatLoginInfo, mergedAllTokens(tokensExpr));
			//return saveWechatLoginInfo(userContext, wechatLoginInfo, tokens().done());
		}

	}
	
	public WechatLoginInfo updateWechatLoginInfoProperty(BcexUserContext userContext,String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatLoginInfo(userContext, wechatLoginInfoId, wechatLoginInfoVersion, property, newValueExpr, tokensExpr);
		
		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo(userContext, wechatLoginInfoId, allTokens());
		if(wechatLoginInfo.getVersion() != wechatLoginInfoVersion){
			String message = "The target version("+wechatLoginInfo.getVersion()+") is not equals to version("+wechatLoginInfoVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatLoginInfo){ 
			//will be good when the wechatLoginInfo loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatLoginInfo.
			
			wechatLoginInfo.changeProperty(property, newValueExpr);
			wechatLoginInfo.updateLastUpdateTime(userContext.now());
			wechatLoginInfo = saveWechatLoginInfo(userContext, wechatLoginInfo, tokens().done());
			return present(userContext,wechatLoginInfo, mergedAllTokens(tokensExpr));
			//return saveWechatLoginInfo(userContext, wechatLoginInfo, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WechatLoginInfoTokens tokens(){
		return WechatLoginInfoTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatLoginInfoTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatLoginInfoTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherWechatUser(BcexUserContext userContext, String wechatLoginInfoId, String anotherWechatUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
 		checkerOf(userContext).checkIdOfWechatUser(anotherWechatUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatLoginInfoManagerException.class);
 		
 	}
 	public WechatLoginInfo transferToAnotherWechatUser(BcexUserContext userContext, String wechatLoginInfoId, String anotherWechatUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherWechatUser(userContext, wechatLoginInfoId,anotherWechatUserId);
 
		WechatLoginInfo wechatLoginInfo = loadWechatLoginInfo(userContext, wechatLoginInfoId, allTokens());	
		synchronized(wechatLoginInfo){
			//will be good when the wechatLoginInfo loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			WechatUser wechatUser = loadWechatUser(userContext, anotherWechatUserId, emptyOptions());		
			wechatLoginInfo.updateWechatUser(wechatUser);		
			wechatLoginInfo = saveWechatLoginInfo(userContext, wechatLoginInfo, emptyOptions());
			
			return present(userContext,wechatLoginInfo, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWechatUser requestCandidateWechatUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

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
		SmartList<WechatUser> candidateList = wechatUserDaoOf(userContext).requestCandidateWechatUserForWechatLoginInfo(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String newWechatUserId, Map<String,Object> options) throws Exception
 	{
		
 		return wechatUserDaoOf(userContext).load(newWechatUserId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String wechatLoginInfoId, int wechatLoginInfoVersion) throws Exception {
		//deleteInternal(userContext, wechatLoginInfoId, wechatLoginInfoVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String wechatLoginInfoId, int wechatLoginInfoVersion) throws Exception{
			
		wechatLoginInfoDaoOf(userContext).delete(wechatLoginInfoId, wechatLoginInfoVersion);
	}
	
	public WechatLoginInfo forgetByAll(BcexUserContext userContext, String wechatLoginInfoId, int wechatLoginInfoVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatLoginInfoId, wechatLoginInfoVersion);		
	}
	protected WechatLoginInfo forgetByAllInternal(BcexUserContext userContext,
			String wechatLoginInfoId, int wechatLoginInfoVersion) throws Exception{
			
		return wechatLoginInfoDaoOf(userContext).disconnectFromAll(wechatLoginInfoId, wechatLoginInfoVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatLoginInfoManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return wechatLoginInfoDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, WechatLoginInfo newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


