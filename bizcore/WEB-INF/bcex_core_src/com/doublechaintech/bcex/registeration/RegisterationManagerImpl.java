
package com.doublechaintech.bcex.registeration;

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

import com.doublechaintech.bcex.changerequest.CandidateChangeRequest;







public class RegisterationManagerImpl extends CustomBcexCheckerManager implements RegisterationManager {
	
	private static final String SERVICE_TYPE = "Registeration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RegisterationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RegisterationManagerException(message);

	}
	
	

 	protected Registeration saveRegisteration(BcexUserContext userContext, Registeration registeration, String [] tokensExpr) throws Exception{	
 		//return getRegisterationDAO().save(registeration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRegisteration(userContext, registeration, tokens);
 	}
 	
 	protected Registeration saveRegisterationDetail(BcexUserContext userContext, Registeration registeration) throws Exception{	

 		
 		return saveRegisteration(userContext, registeration, allTokens());
 	}
 	
 	public Registeration loadRegisteration(BcexUserContext userContext, String registerationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRegisteration(registerationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegisterationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Registeration registeration = loadRegisteration( userContext, registerationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registeration, tokens);
 	}
 	
 	
 	 public Registeration searchRegisteration(BcexUserContext userContext, String registerationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRegisteration(registerationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegisterationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Registeration registeration = loadRegisteration( userContext, registerationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registeration, tokens);
 	}
 	
 	

 	protected Registeration present(BcexUserContext userContext, Registeration registeration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,registeration,tokens);
		
		
		Registeration  registerationToPresent = registerationDaoOf(userContext).present(registeration, tokens);
		
		List<BaseEntity> entityListToNaming = registerationToPresent.collectRefercencesFromLists();
		registerationDaoOf(userContext).alias(entityListToNaming);
		
		return  registerationToPresent;
		
		
	}
 
 	
 	
 	public Registeration loadRegisterationDetail(BcexUserContext userContext, String registerationId) throws Exception{	
 		Registeration registeration = loadRegisteration( userContext, registerationId, allTokens());
 		return present(userContext,registeration, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String registerationId) throws Exception{	
 		Registeration registeration = loadRegisteration( userContext, registerationId, viewTokens());
 		return present(userContext,registeration, allTokens());
		
 	}
 	protected Registeration saveRegisteration(BcexUserContext userContext, Registeration registeration, Map<String,Object>tokens) throws Exception{	
 		return registerationDaoOf(userContext).save(registeration, tokens);
 	}
 	protected Registeration loadRegisteration(BcexUserContext userContext, String registerationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRegisteration(registerationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegisterationManagerException.class);

 
 		return registerationDaoOf(userContext).load(registerationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Registeration registeration, Map<String, Object> tokens){
		super.addActions(userContext, registeration, tokens);
		
		addAction(userContext, registeration, tokens,"@create","createRegisteration","createRegisteration/","main","primary");
		addAction(userContext, registeration, tokens,"@update","updateRegisteration","updateRegisteration/"+registeration.getId()+"/","main","primary");
		addAction(userContext, registeration, tokens,"@copy","cloneRegisteration","cloneRegisteration/"+registeration.getId()+"/","main","primary");
		
		addAction(userContext, registeration, tokens,"registeration.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+registeration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Registeration registeration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Registeration createRegisteration(BcexUserContext userContext,String nickName, String avarta, String changeRequestId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNickNameOfRegisteration(nickName);
		checkerOf(userContext).checkAvartaOfRegisteration(avarta);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RegisterationManagerException.class);


		Registeration registeration=createNewRegisteration();	

		registeration.setNickName(nickName);
		registeration.setAvarta(avarta);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		registeration.setChangeRequest(changeRequest);
		
		

		registeration = saveRegisteration(userContext, registeration, emptyOptions());
		
		onNewInstanceCreated(userContext, registeration);
		return registeration;

		
	}
	protected Registeration createNewRegisteration() 
	{
		
		return new Registeration();		
	}
	
	protected void checkParamsForUpdatingRegisteration(BcexUserContext userContext,String registerationId, int registerationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRegisteration(registerationId);
		checkerOf(userContext).checkVersionOfRegisteration( registerationVersion);
		

		if(Registeration.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfRegisteration(parseString(newValueExpr));
		}
		if(Registeration.AVARTA_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvartaOfRegisteration(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RegisterationManagerException.class);
	
		
	}
	
	
	
	public Registeration clone(BcexUserContext userContext, String fromRegisterationId) throws Exception{
		
		return registerationDaoOf(userContext).clone(fromRegisterationId, this.allTokens());
	}
	
	public Registeration internalSaveRegisteration(BcexUserContext userContext, Registeration registeration) throws Exception 
	{
		return internalSaveRegisteration(userContext, registeration, allTokens());

	}
	public Registeration internalSaveRegisteration(BcexUserContext userContext, Registeration registeration, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRegisteration(userContext, registerationId, registerationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(registeration){ 
			//will be good when the registeration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registeration.
			if (registeration.isChanged()){
			
			}
			registeration = saveRegisteration(userContext, registeration, options);
			return registeration;
			
		}

	}
	
	public Registeration updateRegisteration(BcexUserContext userContext,String registerationId, int registerationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegisteration(userContext, registerationId, registerationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Registeration registeration = loadRegisteration(userContext, registerationId, allTokens());
		if(registeration.getVersion() != registerationVersion){
			String message = "The target version("+registeration.getVersion()+") is not equals to version("+registerationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registeration){ 
			//will be good when the registeration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registeration.
			
			registeration.changeProperty(property, newValueExpr);
			registeration = saveRegisteration(userContext, registeration, tokens().done());
			return present(userContext,registeration, mergedAllTokens(tokensExpr));
			//return saveRegisteration(userContext, registeration, tokens().done());
		}

	}
	
	public Registeration updateRegisterationProperty(BcexUserContext userContext,String registerationId, int registerationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegisteration(userContext, registerationId, registerationVersion, property, newValueExpr, tokensExpr);
		
		Registeration registeration = loadRegisteration(userContext, registerationId, allTokens());
		if(registeration.getVersion() != registerationVersion){
			String message = "The target version("+registeration.getVersion()+") is not equals to version("+registerationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registeration){ 
			//will be good when the registeration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registeration.
			
			registeration.changeProperty(property, newValueExpr);
			
			registeration = saveRegisteration(userContext, registeration, tokens().done());
			return present(userContext,registeration, mergedAllTokens(tokensExpr));
			//return saveRegisteration(userContext, registeration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RegisterationTokens tokens(){
		return RegisterationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RegisterationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RegisterationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherChangeRequest(BcexUserContext userContext, String registerationId, String anotherChangeRequestId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfRegisteration(registerationId);
 		checkerOf(userContext).checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RegisterationManagerException.class);
 		
 	}
 	public Registeration transferToAnotherChangeRequest(BcexUserContext userContext, String registerationId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, registerationId,anotherChangeRequestId);
 
		Registeration registeration = loadRegisteration(userContext, registerationId, allTokens());	
		synchronized(registeration){
			//will be good when the registeration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			registeration.updateChangeRequest(changeRequest);		
			registeration = saveRegisteration(userContext, registeration, emptyOptions());
			
			return present(userContext,registeration, allTokens());
			
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
		SmartList<ChangeRequest> candidateList = changeRequestDaoOf(userContext).requestCandidateChangeRequestForRegisteration(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String registerationId, int registerationVersion) throws Exception {
		//deleteInternal(userContext, registerationId, registerationVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String registerationId, int registerationVersion) throws Exception{
			
		registerationDaoOf(userContext).delete(registerationId, registerationVersion);
	}
	
	public Registeration forgetByAll(BcexUserContext userContext, String registerationId, int registerationVersion) throws Exception {
		return forgetByAllInternal(userContext, registerationId, registerationVersion);		
	}
	protected Registeration forgetByAllInternal(BcexUserContext userContext,
			String registerationId, int registerationVersion) throws Exception{
			
		return registerationDaoOf(userContext).disconnectFromAll(registerationId, registerationVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RegisterationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return registerationDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, Registeration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


