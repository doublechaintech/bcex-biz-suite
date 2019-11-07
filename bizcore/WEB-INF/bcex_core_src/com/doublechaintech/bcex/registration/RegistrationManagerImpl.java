
package com.doublechaintech.bcex.registration;

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







public class RegistrationManagerImpl extends CustomBcexCheckerManager implements RegistrationManager {
	
	private static final String SERVICE_TYPE = "Registration";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws RegistrationManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new RegistrationManagerException(message);

	}
	
	

 	protected Registration saveRegistration(BcexUserContext userContext, Registration registration, String [] tokensExpr) throws Exception{	
 		//return getRegistrationDAO().save(registration, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveRegistration(userContext, registration, tokens);
 	}
 	
 	protected Registration saveRegistrationDetail(BcexUserContext userContext, Registration registration) throws Exception{	

 		
 		return saveRegistration(userContext, registration, allTokens());
 	}
 	
 	public Registration loadRegistration(BcexUserContext userContext, String registrationId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegistrationManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Registration registration = loadRegistration( userContext, registrationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registration, tokens);
 	}
 	
 	
 	 public Registration searchRegistration(BcexUserContext userContext, String registrationId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegistrationManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Registration registration = loadRegistration( userContext, registrationId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,registration, tokens);
 	}
 	
 	

 	protected Registration present(BcexUserContext userContext, Registration registration, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,registration,tokens);
		
		
		Registration  registrationToPresent = registrationDaoOf(userContext).present(registration, tokens);
		
		List<BaseEntity> entityListToNaming = registrationToPresent.collectRefercencesFromLists();
		registrationDaoOf(userContext).alias(entityListToNaming);
		
		return  registrationToPresent;
		
		
	}
 
 	
 	
 	public Registration loadRegistrationDetail(BcexUserContext userContext, String registrationId) throws Exception{	
 		Registration registration = loadRegistration( userContext, registrationId, allTokens());
 		return present(userContext,registration, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String registrationId) throws Exception{	
 		Registration registration = loadRegistration( userContext, registrationId, viewTokens());
 		return present(userContext,registration, allTokens());
		
 	}
 	protected Registration saveRegistration(BcexUserContext userContext, Registration registration, Map<String,Object>tokens) throws Exception{	
 		return registrationDaoOf(userContext).save(registration, tokens);
 	}
 	protected Registration loadRegistration(BcexUserContext userContext, String registrationId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).throwExceptionIfHasErrors( RegistrationManagerException.class);

 
 		return registrationDaoOf(userContext).load(registrationId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Registration registration, Map<String, Object> tokens){
		super.addActions(userContext, registration, tokens);
		
		addAction(userContext, registration, tokens,"@create","createRegistration","createRegistration/","main","primary");
		addAction(userContext, registration, tokens,"@update","updateRegistration","updateRegistration/"+registration.getId()+"/","main","primary");
		addAction(userContext, registration, tokens,"@copy","cloneRegistration","cloneRegistration/"+registration.getId()+"/","main","primary");
		
		addAction(userContext, registration, tokens,"registration.transfer_to_change_request","transferToAnotherChangeRequest","transferToAnotherChangeRequest/"+registration.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Registration registration, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Registration createRegistration(BcexUserContext userContext,String nickName, String avatar, String changeRequestId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNickNameOfRegistration(nickName);
		checkerOf(userContext).checkAvatarOfRegistration(avatar);
	
		checkerOf(userContext).throwExceptionIfHasErrors(RegistrationManagerException.class);


		Registration registration=createNewRegistration();	

		registration.setNickName(nickName);
		registration.setAvatar(avatar);
			
		ChangeRequest changeRequest = loadChangeRequest(userContext, changeRequestId,emptyOptions());
		registration.setChangeRequest(changeRequest);
		
		

		registration = saveRegistration(userContext, registration, emptyOptions());
		
		onNewInstanceCreated(userContext, registration);
		return registration;

		
	}
	protected Registration createNewRegistration() 
	{
		
		return new Registration();		
	}
	
	protected void checkParamsForUpdatingRegistration(BcexUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfRegistration(registrationId);
		checkerOf(userContext).checkVersionOfRegistration( registrationVersion);
		

		if(Registration.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfRegistration(parseString(newValueExpr));
		}
		if(Registration.AVATAR_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvatarOfRegistration(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(RegistrationManagerException.class);
	
		
	}
	
	
	
	public Registration clone(BcexUserContext userContext, String fromRegistrationId) throws Exception{
		
		return registrationDaoOf(userContext).clone(fromRegistrationId, this.allTokens());
	}
	
	public Registration internalSaveRegistration(BcexUserContext userContext, Registration registration) throws Exception 
	{
		return internalSaveRegistration(userContext, registration, allTokens());

	}
	public Registration internalSaveRegistration(BcexUserContext userContext, Registration registration, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			if (registration.isChanged()){
			
			}
			registration = saveRegistration(userContext, registration, options);
			return registration;
			
		}

	}
	
	public Registration updateRegistration(BcexUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		
		
		Registration registration = loadRegistration(userContext, registrationId, allTokens());
		if(registration.getVersion() != registrationVersion){
			String message = "The target version("+registration.getVersion()+") is not equals to version("+registrationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			
			registration.changeProperty(property, newValueExpr);
			registration = saveRegistration(userContext, registration, tokens().done());
			return present(userContext,registration, mergedAllTokens(tokensExpr));
			//return saveRegistration(userContext, registration, tokens().done());
		}

	}
	
	public Registration updateRegistrationProperty(BcexUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingRegistration(userContext, registrationId, registrationVersion, property, newValueExpr, tokensExpr);
		
		Registration registration = loadRegistration(userContext, registrationId, allTokens());
		if(registration.getVersion() != registrationVersion){
			String message = "The target version("+registration.getVersion()+") is not equals to version("+registrationVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(registration){ 
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Registration.
			
			registration.changeProperty(property, newValueExpr);
			
			registration = saveRegistration(userContext, registration, tokens().done());
			return present(userContext,registration, mergedAllTokens(tokensExpr));
			//return saveRegistration(userContext, registration, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected RegistrationTokens tokens(){
		return RegistrationTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return RegistrationTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return RegistrationTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherChangeRequest(BcexUserContext userContext, String registrationId, String anotherChangeRequestId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfRegistration(registrationId);
 		checkerOf(userContext).checkIdOfChangeRequest(anotherChangeRequestId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(RegistrationManagerException.class);
 		
 	}
 	public Registration transferToAnotherChangeRequest(BcexUserContext userContext, String registrationId, String anotherChangeRequestId) throws Exception
 	{
 		checkParamsForTransferingAnotherChangeRequest(userContext, registrationId,anotherChangeRequestId);
 
		Registration registration = loadRegistration(userContext, registrationId, allTokens());	
		synchronized(registration){
			//will be good when the registration loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ChangeRequest changeRequest = loadChangeRequest(userContext, anotherChangeRequestId, emptyOptions());		
			registration.updateChangeRequest(changeRequest);		
			registration = saveRegistration(userContext, registration, emptyOptions());
			
			return present(userContext,registration, allTokens());
			
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
		SmartList<ChangeRequest> candidateList = changeRequestDaoOf(userContext).requestCandidateChangeRequestForRegistration(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String registrationId, int registrationVersion) throws Exception {
		//deleteInternal(userContext, registrationId, registrationVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String registrationId, int registrationVersion) throws Exception{
			
		registrationDaoOf(userContext).delete(registrationId, registrationVersion);
	}
	
	public Registration forgetByAll(BcexUserContext userContext, String registrationId, int registrationVersion) throws Exception {
		return forgetByAllInternal(userContext, registrationId, registrationVersion);		
	}
	protected Registration forgetByAllInternal(BcexUserContext userContext,
			String registrationId, int registrationVersion) throws Exception{
			
		return registrationDaoOf(userContext).disconnectFromAll(registrationId, registrationVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new RegistrationManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return registrationDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, Registration newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


