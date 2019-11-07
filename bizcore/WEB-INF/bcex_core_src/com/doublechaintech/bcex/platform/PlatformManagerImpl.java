
package com.doublechaintech.bcex.platform;

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

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;


import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;






public class PlatformManagerImpl extends CustomBcexCheckerManager implements PlatformManager {
	
	private static final String SERVICE_TYPE = "Platform";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws PlatformManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new PlatformManagerException(message);

	}
	
	

 	protected Platform savePlatform(BcexUserContext userContext, Platform platform, String [] tokensExpr) throws Exception{	
 		//return getPlatformDAO().save(platform, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return savePlatform(userContext, platform, tokens);
 	}
 	
 	protected Platform savePlatformDetail(BcexUserContext userContext, Platform platform) throws Exception{	

 		
 		return savePlatform(userContext, platform, allTokens());
 	}
 	
 	public Platform loadPlatform(BcexUserContext userContext, String platformId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	
 	 public Platform searchPlatform(BcexUserContext userContext, String platformId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Platform platform = loadPlatform( userContext, platformId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,platform, tokens);
 	}
 	
 	

 	protected Platform present(BcexUserContext userContext, Platform platform, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,platform,tokens);
		
		
		Platform  platformToPresent = platformDaoOf(userContext).present(platform, tokens);
		
		List<BaseEntity> entityListToNaming = platformToPresent.collectRefercencesFromLists();
		platformDaoOf(userContext).alias(entityListToNaming);
		
		return  platformToPresent;
		
		
	}
 
 	
 	
 	public Platform loadPlatformDetail(BcexUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, allTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String platformId) throws Exception{	
 		Platform platform = loadPlatform( userContext, platformId, viewTokens());
 		return present(userContext,platform, allTokens());
		
 	}
 	protected Platform savePlatform(BcexUserContext userContext, Platform platform, Map<String,Object>tokens) throws Exception{	
 		return platformDaoOf(userContext).save(platform, tokens);
 	}
 	protected Platform loadPlatform(BcexUserContext userContext, String platformId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).throwExceptionIfHasErrors( PlatformManagerException.class);

 
 		return platformDaoOf(userContext).load(platformId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Platform platform, Map<String, Object> tokens){
		super.addActions(userContext, platform, tokens);
		
		addAction(userContext, platform, tokens,"@create","createPlatform","createPlatform/","main","primary");
		addAction(userContext, platform, tokens,"@update","updatePlatform","updatePlatform/"+platform.getId()+"/","main","primary");
		addAction(userContext, platform, tokens,"@copy","clonePlatform","clonePlatform/"+platform.getId()+"/","main","primary");
		
		addAction(userContext, platform, tokens,"platform.addChangeRequestType","addChangeRequestType","addChangeRequestType/"+platform.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, platform, tokens,"platform.removeChangeRequestType","removeChangeRequestType","removeChangeRequestType/"+platform.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, platform, tokens,"platform.updateChangeRequestType","updateChangeRequestType","updateChangeRequestType/"+platform.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, platform, tokens,"platform.copyChangeRequestTypeFrom","copyChangeRequestTypeFrom","copyChangeRequestTypeFrom/"+platform.getId()+"/","changeRequestTypeList","primary");
		addAction(userContext, platform, tokens,"platform.addChangeRequest","addChangeRequest","addChangeRequest/"+platform.getId()+"/","changeRequestList","primary");
		addAction(userContext, platform, tokens,"platform.removeChangeRequest","removeChangeRequest","removeChangeRequest/"+platform.getId()+"/","changeRequestList","primary");
		addAction(userContext, platform, tokens,"platform.updateChangeRequest","updateChangeRequest","updateChangeRequest/"+platform.getId()+"/","changeRequestList","primary");
		addAction(userContext, platform, tokens,"platform.copyChangeRequestFrom","copyChangeRequestFrom","copyChangeRequestFrom/"+platform.getId()+"/","changeRequestList","primary");
		addAction(userContext, platform, tokens,"platform.addExamStatus","addExamStatus","addExamStatus/"+platform.getId()+"/","examStatusList","primary");
		addAction(userContext, platform, tokens,"platform.removeExamStatus","removeExamStatus","removeExamStatus/"+platform.getId()+"/","examStatusList","primary");
		addAction(userContext, platform, tokens,"platform.updateExamStatus","updateExamStatus","updateExamStatus/"+platform.getId()+"/","examStatusList","primary");
		addAction(userContext, platform, tokens,"platform.copyExamStatusFrom","copyExamStatusFrom","copyExamStatusFrom/"+platform.getId()+"/","examStatusList","primary");
		addAction(userContext, platform, tokens,"platform.addQuestion","addQuestion","addQuestion/"+platform.getId()+"/","questionList","primary");
		addAction(userContext, platform, tokens,"platform.removeQuestion","removeQuestion","removeQuestion/"+platform.getId()+"/","questionList","primary");
		addAction(userContext, platform, tokens,"platform.updateQuestion","updateQuestion","updateQuestion/"+platform.getId()+"/","questionList","primary");
		addAction(userContext, platform, tokens,"platform.copyQuestionFrom","copyQuestionFrom","copyQuestionFrom/"+platform.getId()+"/","questionList","primary");
		addAction(userContext, platform, tokens,"platform.addExamRanking","addExamRanking","addExamRanking/"+platform.getId()+"/","examRankingList","primary");
		addAction(userContext, platform, tokens,"platform.removeExamRanking","removeExamRanking","removeExamRanking/"+platform.getId()+"/","examRankingList","primary");
		addAction(userContext, platform, tokens,"platform.updateExamRanking","updateExamRanking","updateExamRanking/"+platform.getId()+"/","examRankingList","primary");
		addAction(userContext, platform, tokens,"platform.copyExamRankingFrom","copyExamRankingFrom","copyExamRankingFrom/"+platform.getId()+"/","examRankingList","primary");
		addAction(userContext, platform, tokens,"platform.addWechatUser","addWechatUser","addWechatUser/"+platform.getId()+"/","wechatUserList","primary");
		addAction(userContext, platform, tokens,"platform.removeWechatUser","removeWechatUser","removeWechatUser/"+platform.getId()+"/","wechatUserList","primary");
		addAction(userContext, platform, tokens,"platform.updateWechatUser","updateWechatUser","updateWechatUser/"+platform.getId()+"/","wechatUserList","primary");
		addAction(userContext, platform, tokens,"platform.copyWechatUserFrom","copyWechatUserFrom","copyWechatUserFrom/"+platform.getId()+"/","wechatUserList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Platform platform, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Platform createPlatform(BcexUserContext userContext,String name, String description) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfPlatform(name);
		checkerOf(userContext).checkDescriptionOfPlatform(description);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);


		Platform platform=createNewPlatform();	

		platform.setName(name);
		platform.setDescription(description);

		platform = savePlatform(userContext, platform, emptyOptions());
		
		onNewInstanceCreated(userContext, platform);
		return platform;

		
	}
	protected Platform createNewPlatform() 
	{
		
		return new Platform();		
	}
	
	protected void checkParamsForUpdatingPlatform(BcexUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkVersionOfPlatform( platformVersion);
		

		if(Platform.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfPlatform(parseString(newValueExpr));
		}
		if(Platform.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfPlatform(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
		
	}
	
	
	
	public Platform clone(BcexUserContext userContext, String fromPlatformId) throws Exception{
		
		return platformDaoOf(userContext).clone(fromPlatformId, this.allTokens());
	}
	
	public Platform internalSavePlatform(BcexUserContext userContext, Platform platform) throws Exception 
	{
		return internalSavePlatform(userContext, platform, allTokens());

	}
	public Platform internalSavePlatform(BcexUserContext userContext, Platform platform, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			if (platform.isChanged()){
			
			}
			platform = savePlatform(userContext, platform, options);
			return platform;
			
		}

	}
	
	public Platform updatePlatform(BcexUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	
	public Platform updatePlatformProperty(BcexUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingPlatform(userContext, platformId, platformVersion, property, newValueExpr, tokensExpr);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		if(platform.getVersion() != platformVersion){
			String message = "The target version("+platform.getVersion()+") is not equals to version("+platformVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(platform){ 
			//will be good when the platform loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Platform.
			
			platform.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
			//return savePlatform(userContext, platform, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected PlatformTokens tokens(){
		return PlatformTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return PlatformTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortChangeRequestTypeListWith("id","desc")
		.sortChangeRequestListWith("id","desc")
		.sortExamStatusListWith("id","desc")
		.sortQuestionListWith("id","desc")
		.sortExamRankingListWith("id","desc")
		.sortWechatUserListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return PlatformTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String platformId, int platformVersion) throws Exception {
		//deleteInternal(userContext, platformId, platformVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		platformDaoOf(userContext).delete(platformId, platformVersion);
	}
	
	public Platform forgetByAll(BcexUserContext userContext, String platformId, int platformVersion) throws Exception {
		return forgetByAllInternal(userContext, platformId, platformVersion);		
	}
	protected Platform forgetByAllInternal(BcexUserContext userContext,
			String platformId, int platformVersion) throws Exception{
			
		return platformDaoOf(userContext).disconnectFromAll(platformId, platformVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new PlatformManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return platformDaoOf(userContext).deleteAll();
	}


	//disconnect Platform with request_type in ChangeRequest
	protected Platform breakWithChangeRequestByRequestType(BcexUserContext userContext, String platformId, String requestTypeId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());

			synchronized(platform){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				platformDaoOf(userContext).planToRemoveChangeRequestListWithRequestType(platform, requestTypeId, this.emptyOptions());

				platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
				return platform;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingChangeRequestType(BcexUserContext userContext, String platformId, String name, String code, String icon, int displayOrder,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfChangeRequestType(name);
		
		checkerOf(userContext).checkCodeOfChangeRequestType(code);
		
		checkerOf(userContext).checkIconOfChangeRequestType(icon);
		
		checkerOf(userContext).checkDisplayOrderOfChangeRequestType(displayOrder);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addChangeRequestType(BcexUserContext userContext, String platformId, String name, String code, String icon, int displayOrder, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequestType(userContext,platformId,name, code, icon, displayOrder,tokensExpr);
		
		ChangeRequestType changeRequestType = createChangeRequestType(userContext,name, code, icon, displayOrder);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addChangeRequestType( changeRequestType );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestTypeList().done());
			
			userContext.getManagerGroup().getChangeRequestTypeManager().onNewInstanceCreated(userContext, changeRequestType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestTypeProperties(BcexUserContext userContext, String platformId,String id,String name,String code,String icon,int displayOrder,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfChangeRequestType(id);
		
		checkerOf(userContext).checkNameOfChangeRequestType( name);
		checkerOf(userContext).checkCodeOfChangeRequestType( code);
		checkerOf(userContext).checkIconOfChangeRequestType( icon);
		checkerOf(userContext).checkDisplayOrderOfChangeRequestType( displayOrder);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateChangeRequestTypeProperties(BcexUserContext userContext, String platformId, String id,String name,String code,String icon,int displayOrder, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestTypeProperties(userContext,platformId,id,name,code,icon,displayOrder,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestTypeListList()
				.searchChangeRequestTypeListWith(ChangeRequestType.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getChangeRequestTypeList().isEmpty()){
			throw new PlatformManagerException("ChangeRequestType is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequestType item = platformToUpdate.getChangeRequestTypeList().first();
		
		item.updateName( name );
		item.updateCode( code );
		item.updateIcon( icon );
		item.updateDisplayOrder( displayOrder );

		
		//checkParamsForAddingChangeRequestType(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withChangeRequestTypeList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequestType createChangeRequestType(BcexUserContext userContext, String name, String code, String icon, int displayOrder) throws Exception{

		ChangeRequestType changeRequestType = new ChangeRequestType();
		
		
		changeRequestType.setName(name);		
		changeRequestType.setCode(code);		
		changeRequestType.setIcon(icon);		
		changeRequestType.setDisplayOrder(displayOrder);
	
		
		return changeRequestType;
	
		
	}
	
	protected ChangeRequestType createIndexedChangeRequestType(String id, int version){

		ChangeRequestType changeRequestType = new ChangeRequestType();
		changeRequestType.setId(id);
		changeRequestType.setVersion(version);
		return changeRequestType;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestTypeList(BcexUserContext userContext, String platformId, 
			String changeRequestTypeIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String changeRequestTypeIdItem: changeRequestTypeIds){
			checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeChangeRequestTypeList(BcexUserContext userContext, String platformId, 
			String changeRequestTypeIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestTypeList(userContext, platformId,  changeRequestTypeIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveChangeRequestTypeList(platform, changeRequestTypeIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withChangeRequestTypeList().done());
				deleteRelationListInGraph(userContext, platform.getChangeRequestTypeList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequestType(BcexUserContext userContext, String platformId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeChangeRequestType(BcexUserContext userContext, String platformId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequestType(userContext,platformId, changeRequestTypeId, changeRequestTypeVersion,tokensExpr);
		
		ChangeRequestType changeRequestType = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeChangeRequestType( changeRequestType );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestTypeList().done());
			deleteRelationInGraph(userContext, changeRequestType);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequestType(BcexUserContext userContext, String platformId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyChangeRequestTypeFrom(BcexUserContext userContext, String platformId, 
		String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequestType(userContext,platformId, changeRequestTypeId, changeRequestTypeVersion,tokensExpr);
		
		ChangeRequestType changeRequestType = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyChangeRequestTypeFrom( changeRequestType );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestTypeList().done());
			
			userContext.getManagerGroup().getChangeRequestTypeManager().onNewInstanceCreated(userContext, (ChangeRequestType)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequestType(BcexUserContext userContext, String platformId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfChangeRequestType(changeRequestTypeId);
		checkerOf(userContext).checkVersionOfChangeRequestType(changeRequestTypeVersion);
		

		if(ChangeRequestType.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.ICON_PROPERTY.equals(property)){
			checkerOf(userContext).checkIconOfChangeRequestType(parseString(newValueExpr));
		}
		
		if(ChangeRequestType.DISPLAY_ORDER_PROPERTY.equals(property)){
			checkerOf(userContext).checkDisplayOrderOfChangeRequestType(parseInt(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateChangeRequestType(BcexUserContext userContext, String platformId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequestType(userContext, platformId, changeRequestTypeId, changeRequestTypeVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestTypeList().searchChangeRequestTypeListWith(ChangeRequestType.ID_PROPERTY, "eq", changeRequestTypeId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeChangeRequestType( changeRequestType );	
			//make changes to AcceleraterAccount.
			ChangeRequestType changeRequestTypeIndex = createIndexedChangeRequestType(changeRequestTypeId, changeRequestTypeVersion);
		
			ChangeRequestType changeRequestType = platform.findTheChangeRequestType(changeRequestTypeIndex);
			if(changeRequestType == null){
				throw new PlatformManagerException(changeRequestType+" is NOT FOUND" );
			}
			
			changeRequestType.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withChangeRequestTypeList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingChangeRequest(BcexUserContext userContext, String platformId, String name, String requestTypeId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfChangeRequest(name);
		
		checkerOf(userContext).checkRequestTypeIdOfChangeRequest(requestTypeId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addChangeRequest(BcexUserContext userContext, String platformId, String name, String requestTypeId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingChangeRequest(userContext,platformId,name, requestTypeId,tokensExpr);
		
		ChangeRequest changeRequest = createChangeRequest(userContext,name, requestTypeId);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addChangeRequest( changeRequest );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, changeRequest);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingChangeRequestProperties(BcexUserContext userContext, String platformId,String id,String name,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfChangeRequest(id);
		
		checkerOf(userContext).checkNameOfChangeRequest( name);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateChangeRequestProperties(BcexUserContext userContext, String platformId, String id,String name, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingChangeRequestProperties(userContext,platformId,id,name,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withChangeRequestListList()
				.searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getChangeRequestList().isEmpty()){
			throw new PlatformManagerException("ChangeRequest is NOT FOUND with id: '"+id+"'");
		}
		
		ChangeRequest item = platformToUpdate.getChangeRequestList().first();
		
		item.updateName( name );

		
		//checkParamsForAddingChangeRequest(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withChangeRequestList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ChangeRequest createChangeRequest(BcexUserContext userContext, String name, String requestTypeId) throws Exception{

		ChangeRequest changeRequest = new ChangeRequest();
		
		
		changeRequest.setName(name);		
		changeRequest.setCreateTime(userContext.now());		
		changeRequest.setRemoteIp(userContext.getRemoteIP());		
		ChangeRequestType  requestType = new ChangeRequestType();
		requestType.setId(requestTypeId);		
		changeRequest.setRequestType(requestType);
	
		
		return changeRequest;
	
		
	}
	
	protected ChangeRequest createIndexedChangeRequest(String id, int version){

		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(version);
		return changeRequest;			
		
	}
	
	protected void checkParamsForRemovingChangeRequestList(BcexUserContext userContext, String platformId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String changeRequestIdItem: changeRequestIds){
			checkerOf(userContext).checkIdOfChangeRequest(changeRequestIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeChangeRequestList(BcexUserContext userContext, String platformId, 
			String changeRequestIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingChangeRequestList(userContext, platformId,  changeRequestIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveChangeRequestList(platform, changeRequestIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
				deleteRelationListInGraph(userContext, platform.getChangeRequestList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingChangeRequest(BcexUserContext userContext, String platformId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeChangeRequest(BcexUserContext userContext, String platformId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingChangeRequest(userContext,platformId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeChangeRequest( changeRequest );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
			deleteRelationInGraph(userContext, changeRequest);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingChangeRequest(BcexUserContext userContext, String platformId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyChangeRequestFrom(BcexUserContext userContext, String platformId, 
		String changeRequestId, int changeRequestVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingChangeRequest(userContext,platformId, changeRequestId, changeRequestVersion,tokensExpr);
		
		ChangeRequest changeRequest = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			
			platform.copyChangeRequestFrom( changeRequest );		
			platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
			
			userContext.getManagerGroup().getChangeRequestManager().onNewInstanceCreated(userContext, (ChangeRequest)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingChangeRequest(BcexUserContext userContext, String platformId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfChangeRequest(changeRequestId);
		checkerOf(userContext).checkVersionOfChangeRequest(changeRequestVersion);
		

		if(ChangeRequest.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfChangeRequest(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateChangeRequest(BcexUserContext userContext, String platformId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingChangeRequest(userContext, platformId, changeRequestId, changeRequestVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withChangeRequestList().searchChangeRequestListWith(ChangeRequest.ID_PROPERTY, "eq", changeRequestId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeChangeRequest( changeRequest );	
			//make changes to AcceleraterAccount.
			ChangeRequest changeRequestIndex = createIndexedChangeRequest(changeRequestId, changeRequestVersion);
		
			ChangeRequest changeRequest = platform.findTheChangeRequest(changeRequestIndex);
			if(changeRequest == null){
				throw new PlatformManagerException(changeRequest+" is NOT FOUND" );
			}
			
			changeRequest.changeProperty(property, newValueExpr);
			changeRequest.updateRemoteIp(userContext.getRemoteIP());
			platform = savePlatform(userContext, platform, tokens().withChangeRequestList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingExamStatus(BcexUserContext userContext, String platformId, String name, String code,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfExamStatus(name);
		
		checkerOf(userContext).checkCodeOfExamStatus(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addExamStatus(BcexUserContext userContext, String platformId, String name, String code, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExamStatus(userContext,platformId,name, code,tokensExpr);
		
		ExamStatus examStatus = createExamStatus(userContext,name, code);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addExamStatus( examStatus );		
			platform = savePlatform(userContext, platform, tokens().withExamStatusList().done());
			
			userContext.getManagerGroup().getExamStatusManager().onNewInstanceCreated(userContext, examStatus);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExamStatusProperties(BcexUserContext userContext, String platformId,String id,String name,String code,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfExamStatus(id);
		
		checkerOf(userContext).checkNameOfExamStatus( name);
		checkerOf(userContext).checkCodeOfExamStatus( code);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateExamStatusProperties(BcexUserContext userContext, String platformId, String id,String name,String code, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExamStatusProperties(userContext,platformId,id,name,code,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExamStatusListList()
				.searchExamStatusListWith(ExamStatus.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getExamStatusList().isEmpty()){
			throw new PlatformManagerException("ExamStatus is NOT FOUND with id: '"+id+"'");
		}
		
		ExamStatus item = platformToUpdate.getExamStatusList().first();
		
		item.updateName( name );
		item.updateCode( code );

		
		//checkParamsForAddingExamStatus(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withExamStatusList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ExamStatus createExamStatus(BcexUserContext userContext, String name, String code) throws Exception{

		ExamStatus examStatus = new ExamStatus();
		
		
		examStatus.setName(name);		
		examStatus.setCode(code);
	
		
		return examStatus;
	
		
	}
	
	protected ExamStatus createIndexedExamStatus(String id, int version){

		ExamStatus examStatus = new ExamStatus();
		examStatus.setId(id);
		examStatus.setVersion(version);
		return examStatus;			
		
	}
	
	protected void checkParamsForRemovingExamStatusList(BcexUserContext userContext, String platformId, 
			String examStatusIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String examStatusIdItem: examStatusIds){
			checkerOf(userContext).checkIdOfExamStatus(examStatusIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeExamStatusList(BcexUserContext userContext, String platformId, 
			String examStatusIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExamStatusList(userContext, platformId,  examStatusIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveExamStatusList(platform, examStatusIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withExamStatusList().done());
				deleteRelationListInGraph(userContext, platform.getExamStatusList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExamStatus(BcexUserContext userContext, String platformId, 
		String examStatusId, int examStatusVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkVersionOfExamStatus(examStatusVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeExamStatus(BcexUserContext userContext, String platformId, 
		String examStatusId, int examStatusVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExamStatus(userContext,platformId, examStatusId, examStatusVersion,tokensExpr);
		
		ExamStatus examStatus = createIndexedExamStatus(examStatusId, examStatusVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeExamStatus( examStatus );		
			platform = savePlatform(userContext, platform, tokens().withExamStatusList().done());
			deleteRelationInGraph(userContext, examStatus);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExamStatus(BcexUserContext userContext, String platformId, 
		String examStatusId, int examStatusVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkVersionOfExamStatus(examStatusVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyExamStatusFrom(BcexUserContext userContext, String platformId, 
		String examStatusId, int examStatusVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExamStatus(userContext,platformId, examStatusId, examStatusVersion,tokensExpr);
		
		ExamStatus examStatus = createIndexedExamStatus(examStatusId, examStatusVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyExamStatusFrom( examStatus );		
			platform = savePlatform(userContext, platform, tokens().withExamStatusList().done());
			
			userContext.getManagerGroup().getExamStatusManager().onNewInstanceCreated(userContext, (ExamStatus)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExamStatus(BcexUserContext userContext, String platformId, String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkVersionOfExamStatus(examStatusVersion);
		

		if(ExamStatus.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExamStatus(parseString(newValueExpr));
		}
		
		if(ExamStatus.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfExamStatus(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateExamStatus(BcexUserContext userContext, String platformId, String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExamStatus(userContext, platformId, examStatusId, examStatusVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExamStatusList().searchExamStatusListWith(ExamStatus.ID_PROPERTY, "eq", examStatusId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeExamStatus( examStatus );	
			//make changes to AcceleraterAccount.
			ExamStatus examStatusIndex = createIndexedExamStatus(examStatusId, examStatusVersion);
		
			ExamStatus examStatus = platform.findTheExamStatus(examStatusIndex);
			if(examStatus == null){
				throw new PlatformManagerException(examStatus+" is NOT FOUND" );
			}
			
			examStatus.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withExamStatusList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingQuestion(BcexUserContext userContext, String platformId, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkTopicOfQuestion(topic);
		
		checkerOf(userContext).checkLevelOfQuestion(level);
		
		checkerOf(userContext).checkOptionAOfQuestion(optionA);
		
		checkerOf(userContext).checkOptionBOfQuestion(optionB);
		
		checkerOf(userContext).checkOptionCOfQuestion(optionC);
		
		checkerOf(userContext).checkOptionDOfQuestion(optionD);
		
		checkerOf(userContext).checkOptionEOfQuestion(optionE);
		
		checkerOf(userContext).checkRightAnswerOfQuestion(rightAnswer);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addQuestion(BcexUserContext userContext, String platformId, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingQuestion(userContext,platformId,topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer,tokensExpr);
		
		Question question = createQuestion(userContext,topic, level, optionA, optionB, optionC, optionD, optionE, rightAnswer);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addQuestion( question );		
			platform = savePlatform(userContext, platform, tokens().withQuestionList().done());
			
			userContext.getManagerGroup().getQuestionManager().onNewInstanceCreated(userContext, question);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingQuestionProperties(BcexUserContext userContext, String platformId,String id,String topic,String level,String optionA,String optionB,String optionC,String optionD,String optionE,String rightAnswer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfQuestion(id);
		
		checkerOf(userContext).checkTopicOfQuestion( topic);
		checkerOf(userContext).checkLevelOfQuestion( level);
		checkerOf(userContext).checkOptionAOfQuestion( optionA);
		checkerOf(userContext).checkOptionBOfQuestion( optionB);
		checkerOf(userContext).checkOptionCOfQuestion( optionC);
		checkerOf(userContext).checkOptionDOfQuestion( optionD);
		checkerOf(userContext).checkOptionEOfQuestion( optionE);
		checkerOf(userContext).checkRightAnswerOfQuestion( rightAnswer);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateQuestionProperties(BcexUserContext userContext, String platformId, String id,String topic,String level,String optionA,String optionB,String optionC,String optionD,String optionE,String rightAnswer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingQuestionProperties(userContext,platformId,id,topic,level,optionA,optionB,optionC,optionD,optionE,rightAnswer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withQuestionListList()
				.searchQuestionListWith(Question.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getQuestionList().isEmpty()){
			throw new PlatformManagerException("Question is NOT FOUND with id: '"+id+"'");
		}
		
		Question item = platformToUpdate.getQuestionList().first();
		
		item.updateTopic( topic );
		item.updateLevel( level );
		item.updateOptionA( optionA );
		item.updateOptionB( optionB );
		item.updateOptionC( optionC );
		item.updateOptionD( optionD );
		item.updateOptionE( optionE );
		item.updateRightAnswer( rightAnswer );

		
		//checkParamsForAddingQuestion(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withQuestionList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Question createQuestion(BcexUserContext userContext, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer) throws Exception{

		Question question = new Question();
		
		
		question.setTopic(topic);		
		question.setLevel(level);		
		question.setOptionA(optionA);		
		question.setOptionB(optionB);		
		question.setOptionC(optionC);		
		question.setOptionD(optionD);		
		question.setOptionE(optionE);		
		question.setRightAnswer(rightAnswer);
	
		
		return question;
	
		
	}
	
	protected Question createIndexedQuestion(String id, int version){

		Question question = new Question();
		question.setId(id);
		question.setVersion(version);
		return question;			
		
	}
	
	protected void checkParamsForRemovingQuestionList(BcexUserContext userContext, String platformId, 
			String questionIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String questionIdItem: questionIds){
			checkerOf(userContext).checkIdOfQuestion(questionIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeQuestionList(BcexUserContext userContext, String platformId, 
			String questionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingQuestionList(userContext, platformId,  questionIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveQuestionList(platform, questionIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withQuestionList().done());
				deleteRelationListInGraph(userContext, platform.getQuestionList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingQuestion(BcexUserContext userContext, String platformId, 
		String questionId, int questionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkVersionOfQuestion(questionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeQuestion(BcexUserContext userContext, String platformId, 
		String questionId, int questionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingQuestion(userContext,platformId, questionId, questionVersion,tokensExpr);
		
		Question question = createIndexedQuestion(questionId, questionVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeQuestion( question );		
			platform = savePlatform(userContext, platform, tokens().withQuestionList().done());
			deleteRelationInGraph(userContext, question);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingQuestion(BcexUserContext userContext, String platformId, 
		String questionId, int questionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkVersionOfQuestion(questionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyQuestionFrom(BcexUserContext userContext, String platformId, 
		String questionId, int questionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingQuestion(userContext,platformId, questionId, questionVersion,tokensExpr);
		
		Question question = createIndexedQuestion(questionId, questionVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyQuestionFrom( question );		
			platform = savePlatform(userContext, platform, tokens().withQuestionList().done());
			
			userContext.getManagerGroup().getQuestionManager().onNewInstanceCreated(userContext, (Question)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingQuestion(BcexUserContext userContext, String platformId, String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkVersionOfQuestion(questionVersion);
		

		if(Question.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.LEVEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLevelOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.OPTION_A_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionAOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.OPTION_B_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionBOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.OPTION_C_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionCOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.OPTION_D_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionDOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.OPTION_E_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionEOfQuestion(parseString(newValueExpr));
		}
		
		if(Question.RIGHT_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkRightAnswerOfQuestion(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateQuestion(BcexUserContext userContext, String platformId, String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingQuestion(userContext, platformId, questionId, questionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withQuestionList().searchQuestionListWith(Question.ID_PROPERTY, "eq", questionId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeQuestion( question );	
			//make changes to AcceleraterAccount.
			Question questionIndex = createIndexedQuestion(questionId, questionVersion);
		
			Question question = platform.findTheQuestion(questionIndex);
			if(question == null){
				throw new PlatformManagerException(question+" is NOT FOUND" );
			}
			
			question.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withQuestionList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingExamRanking(BcexUserContext userContext, String platformId, String name, String avarta,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfExamRanking(name);
		
		checkerOf(userContext).checkAvartaOfExamRanking(avarta);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addExamRanking(BcexUserContext userContext, String platformId, String name, String avarta, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExamRanking(userContext,platformId,name, avarta,tokensExpr);
		
		ExamRanking examRanking = createExamRanking(userContext,name, avarta);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addExamRanking( examRanking );		
			platform = savePlatform(userContext, platform, tokens().withExamRankingList().done());
			
			userContext.getManagerGroup().getExamRankingManager().onNewInstanceCreated(userContext, examRanking);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExamRankingProperties(BcexUserContext userContext, String platformId,String id,String name,String avarta,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfExamRanking(id);
		
		checkerOf(userContext).checkNameOfExamRanking( name);
		checkerOf(userContext).checkAvartaOfExamRanking( avarta);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateExamRankingProperties(BcexUserContext userContext, String platformId, String id,String name,String avarta, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExamRankingProperties(userContext,platformId,id,name,avarta,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExamRankingListList()
				.searchExamRankingListWith(ExamRanking.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getExamRankingList().isEmpty()){
			throw new PlatformManagerException("ExamRanking is NOT FOUND with id: '"+id+"'");
		}
		
		ExamRanking item = platformToUpdate.getExamRankingList().first();
		
		item.updateName( name );
		item.updateAvarta( avarta );

		
		//checkParamsForAddingExamRanking(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withExamRankingList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected ExamRanking createExamRanking(BcexUserContext userContext, String name, String avarta) throws Exception{

		ExamRanking examRanking = new ExamRanking();
		
		
		examRanking.setName(name);		
		examRanking.setAvarta(avarta);
	
		
		return examRanking;
	
		
	}
	
	protected ExamRanking createIndexedExamRanking(String id, int version){

		ExamRanking examRanking = new ExamRanking();
		examRanking.setId(id);
		examRanking.setVersion(version);
		return examRanking;			
		
	}
	
	protected void checkParamsForRemovingExamRankingList(BcexUserContext userContext, String platformId, 
			String examRankingIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String examRankingIdItem: examRankingIds){
			checkerOf(userContext).checkIdOfExamRanking(examRankingIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeExamRankingList(BcexUserContext userContext, String platformId, 
			String examRankingIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExamRankingList(userContext, platformId,  examRankingIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveExamRankingList(platform, examRankingIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withExamRankingList().done());
				deleteRelationListInGraph(userContext, platform.getExamRankingList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExamRanking(BcexUserContext userContext, String platformId, 
		String examRankingId, int examRankingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).checkVersionOfExamRanking(examRankingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeExamRanking(BcexUserContext userContext, String platformId, 
		String examRankingId, int examRankingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExamRanking(userContext,platformId, examRankingId, examRankingVersion,tokensExpr);
		
		ExamRanking examRanking = createIndexedExamRanking(examRankingId, examRankingVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeExamRanking( examRanking );		
			platform = savePlatform(userContext, platform, tokens().withExamRankingList().done());
			deleteRelationInGraph(userContext, examRanking);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExamRanking(BcexUserContext userContext, String platformId, 
		String examRankingId, int examRankingVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).checkVersionOfExamRanking(examRankingVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyExamRankingFrom(BcexUserContext userContext, String platformId, 
		String examRankingId, int examRankingVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExamRanking(userContext,platformId, examRankingId, examRankingVersion,tokensExpr);
		
		ExamRanking examRanking = createIndexedExamRanking(examRankingId, examRankingVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyExamRankingFrom( examRanking );		
			platform = savePlatform(userContext, platform, tokens().withExamRankingList().done());
			
			userContext.getManagerGroup().getExamRankingManager().onNewInstanceCreated(userContext, (ExamRanking)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExamRanking(BcexUserContext userContext, String platformId, String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).checkVersionOfExamRanking(examRankingVersion);
		

		if(ExamRanking.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExamRanking(parseString(newValueExpr));
		}
		
		if(ExamRanking.AVARTA_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvartaOfExamRanking(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateExamRanking(BcexUserContext userContext, String platformId, String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExamRanking(userContext, platformId, examRankingId, examRankingVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExamRankingList().searchExamRankingListWith(ExamRanking.ID_PROPERTY, "eq", examRankingId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeExamRanking( examRanking );	
			//make changes to AcceleraterAccount.
			ExamRanking examRankingIndex = createIndexedExamRanking(examRankingId, examRankingVersion);
		
			ExamRanking examRanking = platform.findTheExamRanking(examRankingIndex);
			if(examRanking == null){
				throw new PlatformManagerException(examRanking+" is NOT FOUND" );
			}
			
			examRanking.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withExamRankingList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingWechatUser(BcexUserContext userContext, String platformId, String name, String avarta,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfPlatform(platformId);

		
		checkerOf(userContext).checkNameOfWechatUser(name);
		
		checkerOf(userContext).checkAvartaOfWechatUser(avarta);
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);

	
	}
	public  Platform addWechatUser(BcexUserContext userContext, String platformId, String name, String avarta, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingWechatUser(userContext,platformId,name, avarta,tokensExpr);
		
		WechatUser wechatUser = createWechatUser(userContext,name, avarta);
		
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.addWechatUser( wechatUser );		
			platform = savePlatform(userContext, platform, tokens().withWechatUserList().done());
			
			userContext.getManagerGroup().getWechatUserManager().onNewInstanceCreated(userContext, wechatUser);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatUserProperties(BcexUserContext userContext, String platformId,String id,String name,String avarta,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfWechatUser(id);
		
		checkerOf(userContext).checkNameOfWechatUser( name);
		checkerOf(userContext).checkAvartaOfWechatUser( avarta);

		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform updateWechatUserProperties(BcexUserContext userContext, String platformId, String id,String name,String avarta, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingWechatUserProperties(userContext,platformId,id,name,avarta,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatUserListList()
				.searchWechatUserListWith(WechatUser.ID_PROPERTY, "is", id).done();
		
		Platform platformToUpdate = loadPlatform(userContext, platformId, options);
		
		if(platformToUpdate.getWechatUserList().isEmpty()){
			throw new PlatformManagerException("WechatUser is NOT FOUND with id: '"+id+"'");
		}
		
		WechatUser item = platformToUpdate.getWechatUserList().first();
		
		item.updateName( name );
		item.updateAvarta( avarta );

		
		//checkParamsForAddingWechatUser(userContext,platformId,name, code, used,tokensExpr);
		Platform platform = savePlatform(userContext, platformToUpdate, tokens().withWechatUserList().done());
		synchronized(platform){ 
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected WechatUser createWechatUser(BcexUserContext userContext, String name, String avarta) throws Exception{

		WechatUser wechatUser = new WechatUser();
		
		
		wechatUser.setName(name);		
		wechatUser.setAvarta(avarta);		
		wechatUser.setCreateTime(userContext.now());
	
		
		return wechatUser;
	
		
	}
	
	protected WechatUser createIndexedWechatUser(String id, int version){

		WechatUser wechatUser = new WechatUser();
		wechatUser.setId(id);
		wechatUser.setVersion(version);
		return wechatUser;			
		
	}
	
	protected void checkParamsForRemovingWechatUserList(BcexUserContext userContext, String platformId, 
			String wechatUserIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		for(String wechatUserIdItem: wechatUserIds){
			checkerOf(userContext).checkIdOfWechatUser(wechatUserIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
		
	}
	public  Platform removeWechatUserList(BcexUserContext userContext, String platformId, 
			String wechatUserIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingWechatUserList(userContext, platformId,  wechatUserIds, tokensExpr);
			
			
			Platform platform = loadPlatform(userContext, platformId, allTokens());
			synchronized(platform){ 
				//Will be good when the platform loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				platformDaoOf(userContext).planToRemoveWechatUserList(platform, wechatUserIds, allTokens());
				platform = savePlatform(userContext, platform, tokens().withWechatUserList().done());
				deleteRelationListInGraph(userContext, platform.getWechatUserList());
				return present(userContext,platform, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingWechatUser(BcexUserContext userContext, String platformId, 
		String wechatUserId, int wechatUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkVersionOfWechatUser(wechatUserVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform removeWechatUser(BcexUserContext userContext, String platformId, 
		String wechatUserId, int wechatUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingWechatUser(userContext,platformId, wechatUserId, wechatUserVersion,tokensExpr);
		
		WechatUser wechatUser = createIndexedWechatUser(wechatUserId, wechatUserVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			platform.removeWechatUser( wechatUser );		
			platform = savePlatform(userContext, platform, tokens().withWechatUserList().done());
			deleteRelationInGraph(userContext, wechatUser);
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingWechatUser(BcexUserContext userContext, String platformId, 
		String wechatUserId, int wechatUserVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfPlatform( platformId);
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkVersionOfWechatUser(wechatUserVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	public  Platform copyWechatUserFrom(BcexUserContext userContext, String platformId, 
		String wechatUserId, int wechatUserVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingWechatUser(userContext,platformId, wechatUserId, wechatUserVersion,tokensExpr);
		
		WechatUser wechatUser = createIndexedWechatUser(wechatUserId, wechatUserVersion);
		Platform platform = loadPlatform(userContext, platformId, allTokens());
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			platform.copyWechatUserFrom( wechatUser );		
			platform = savePlatform(userContext, platform, tokens().withWechatUserList().done());
			
			userContext.getManagerGroup().getWechatUserManager().onNewInstanceCreated(userContext, (WechatUser)platform.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingWechatUser(BcexUserContext userContext, String platformId, String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfPlatform(platformId);
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkVersionOfWechatUser(wechatUserVersion);
		

		if(WechatUser.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfWechatUser(parseString(newValueExpr));
		}
		
		if(WechatUser.AVARTA_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvartaOfWechatUser(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(PlatformManagerException.class);
	
	}
	
	public  Platform updateWechatUser(BcexUserContext userContext, String platformId, String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingWechatUser(userContext, platformId, wechatUserId, wechatUserVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withWechatUserList().searchWechatUserListWith(WechatUser.ID_PROPERTY, "eq", wechatUserId).done();
		
		
		
		Platform platform = loadPlatform(userContext, platformId, loadTokens);
		
		synchronized(platform){ 
			//Will be good when the platform loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//platform.removeWechatUser( wechatUser );	
			//make changes to AcceleraterAccount.
			WechatUser wechatUserIndex = createIndexedWechatUser(wechatUserId, wechatUserVersion);
		
			WechatUser wechatUser = platform.findTheWechatUser(wechatUserIndex);
			if(wechatUser == null){
				throw new PlatformManagerException(wechatUser+" is NOT FOUND" );
			}
			
			wechatUser.changeProperty(property, newValueExpr);
			
			platform = savePlatform(userContext, platform, tokens().withWechatUserList().done());
			return present(userContext,platform, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, Platform newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


