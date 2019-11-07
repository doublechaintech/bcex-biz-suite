
package com.doublechaintech.bcex.formmessage;

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

import com.doublechaintech.bcex.genericform.GenericForm;

import com.doublechaintech.bcex.genericform.CandidateGenericForm;







public class FormMessageManagerImpl extends CustomBcexCheckerManager implements FormMessageManager {
	
	private static final String SERVICE_TYPE = "FormMessage";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormMessageManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormMessageManagerException(message);

	}
	
	

 	protected FormMessage saveFormMessage(BcexUserContext userContext, FormMessage formMessage, String [] tokensExpr) throws Exception{	
 		//return getFormMessageDAO().save(formMessage, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormMessage(userContext, formMessage, tokens);
 	}
 	
 	protected FormMessage saveFormMessageDetail(BcexUserContext userContext, FormMessage formMessage) throws Exception{	

 		
 		return saveFormMessage(userContext, formMessage, allTokens());
 	}
 	
 	public FormMessage loadFormMessage(BcexUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formMessage, tokens);
 	}
 	
 	
 	 public FormMessage searchFormMessage(BcexUserContext userContext, String formMessageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formMessage, tokens);
 	}
 	
 	

 	protected FormMessage present(BcexUserContext userContext, FormMessage formMessage, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formMessage,tokens);
		
		
		FormMessage  formMessageToPresent = formMessageDaoOf(userContext).present(formMessage, tokens);
		
		List<BaseEntity> entityListToNaming = formMessageToPresent.collectRefercencesFromLists();
		formMessageDaoOf(userContext).alias(entityListToNaming);
		
		return  formMessageToPresent;
		
		
	}
 
 	
 	
 	public FormMessage loadFormMessageDetail(BcexUserContext userContext, String formMessageId) throws Exception{	
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, allTokens());
 		return present(userContext,formMessage, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String formMessageId) throws Exception{	
 		FormMessage formMessage = loadFormMessage( userContext, formMessageId, viewTokens());
 		return present(userContext,formMessage, allTokens());
		
 	}
 	protected FormMessage saveFormMessage(BcexUserContext userContext, FormMessage formMessage, Map<String,Object>tokens) throws Exception{	
 		return formMessageDaoOf(userContext).save(formMessage, tokens);
 	}
 	protected FormMessage loadFormMessage(BcexUserContext userContext, String formMessageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormMessageManagerException.class);

 
 		return formMessageDaoOf(userContext).load(formMessageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormMessage formMessage, Map<String, Object> tokens){
		super.addActions(userContext, formMessage, tokens);
		
		addAction(userContext, formMessage, tokens,"@create","createFormMessage","createFormMessage/","main","primary");
		addAction(userContext, formMessage, tokens,"@update","updateFormMessage","updateFormMessage/"+formMessage.getId()+"/","main","primary");
		addAction(userContext, formMessage, tokens,"@copy","cloneFormMessage","cloneFormMessage/"+formMessage.getId()+"/","main","primary");
		
		addAction(userContext, formMessage, tokens,"form_message.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formMessage.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormMessage formMessage, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormMessage createFormMessage(BcexUserContext userContext,String title, String formId, String level) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTitleOfFormMessage(title);
		checkerOf(userContext).checkLevelOfFormMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);


		FormMessage formMessage=createNewFormMessage();	

		formMessage.setTitle(title);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formMessage.setForm(form);
		
		
		formMessage.setLevel(level);

		formMessage = saveFormMessage(userContext, formMessage, emptyOptions());
		
		onNewInstanceCreated(userContext, formMessage);
		return formMessage;

		
	}
	protected FormMessage createNewFormMessage() 
	{
		
		return new FormMessage();		
	}
	
	protected void checkParamsForUpdatingFormMessage(BcexUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
		checkerOf(userContext).checkVersionOfFormMessage( formMessageVersion);
		

		if(FormMessage.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfFormMessage(parseString(newValueExpr));
		}		

		
		if(FormMessage.LEVEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLevelOfFormMessage(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);
	
		
	}
	
	
	
	public FormMessage clone(BcexUserContext userContext, String fromFormMessageId) throws Exception{
		
		return formMessageDaoOf(userContext).clone(fromFormMessageId, this.allTokens());
	}
	
	public FormMessage internalSaveFormMessage(BcexUserContext userContext, FormMessage formMessage) throws Exception 
	{
		return internalSaveFormMessage(userContext, formMessage, allTokens());

	}
	public FormMessage internalSaveFormMessage(BcexUserContext userContext, FormMessage formMessage, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formMessage){ 
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.
			if (formMessage.isChanged()){
			
			}
			formMessage = saveFormMessage(userContext, formMessage, options);
			return formMessage;
			
		}

	}
	
	public FormMessage updateFormMessage(BcexUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());
		if(formMessage.getVersion() != formMessageVersion){
			String message = "The target version("+formMessage.getVersion()+") is not equals to version("+formMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formMessage){ 
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.
			
			formMessage.changeProperty(property, newValueExpr);
			formMessage = saveFormMessage(userContext, formMessage, tokens().done());
			return present(userContext,formMessage, mergedAllTokens(tokensExpr));
			//return saveFormMessage(userContext, formMessage, tokens().done());
		}

	}
	
	public FormMessage updateFormMessageProperty(BcexUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormMessage(userContext, formMessageId, formMessageVersion, property, newValueExpr, tokensExpr);
		
		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());
		if(formMessage.getVersion() != formMessageVersion){
			String message = "The target version("+formMessage.getVersion()+") is not equals to version("+formMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formMessage){ 
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormMessage.
			
			formMessage.changeProperty(property, newValueExpr);
			
			formMessage = saveFormMessage(userContext, formMessage, tokens().done());
			return present(userContext,formMessage, mergedAllTokens(tokensExpr));
			//return saveFormMessage(userContext, formMessage, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormMessageTokens tokens(){
		return FormMessageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormMessageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormMessageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(BcexUserContext userContext, String formMessageId, String anotherFormId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFormMessage(formMessageId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormMessageManagerException.class);
 		
 	}
 	public FormMessage transferToAnotherForm(BcexUserContext userContext, String formMessageId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formMessageId,anotherFormId);
 
		FormMessage formMessage = loadFormMessage(userContext, formMessageId, allTokens());	
		synchronized(formMessage){
			//will be good when the formMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formMessage.updateForm(form);		
			formMessage = saveFormMessage(userContext, formMessage, emptyOptions());
			
			return present(userContext,formMessage, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateGenericForm requestCandidateForm(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateGenericForm result = new CandidateGenericForm();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("title");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormMessage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected GenericForm loadGenericForm(BcexUserContext userContext, String newFormId, Map<String,Object> options) throws Exception
 	{
		
 		return genericFormDaoOf(userContext).load(newFormId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String formMessageId, int formMessageVersion) throws Exception {
		//deleteInternal(userContext, formMessageId, formMessageVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String formMessageId, int formMessageVersion) throws Exception{
			
		formMessageDaoOf(userContext).delete(formMessageId, formMessageVersion);
	}
	
	public FormMessage forgetByAll(BcexUserContext userContext, String formMessageId, int formMessageVersion) throws Exception {
		return forgetByAllInternal(userContext, formMessageId, formMessageVersion);		
	}
	protected FormMessage forgetByAllInternal(BcexUserContext userContext,
			String formMessageId, int formMessageVersion) throws Exception{
			
		return formMessageDaoOf(userContext).disconnectFromAll(formMessageId, formMessageVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormMessageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return formMessageDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, FormMessage newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


