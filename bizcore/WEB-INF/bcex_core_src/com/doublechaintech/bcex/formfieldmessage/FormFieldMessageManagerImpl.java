
package com.doublechaintech.bcex.formfieldmessage;

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







public class FormFieldMessageManagerImpl extends CustomBcexCheckerManager implements FormFieldMessageManager {
	
	private static final String SERVICE_TYPE = "FormFieldMessage";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormFieldMessageManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormFieldMessageManagerException(message);

	}
	
	

 	protected FormFieldMessage saveFormFieldMessage(BcexUserContext userContext, FormFieldMessage formFieldMessage, String [] tokensExpr) throws Exception{	
 		//return getFormFieldMessageDAO().save(formFieldMessage, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormFieldMessage(userContext, formFieldMessage, tokens);
 	}
 	
 	protected FormFieldMessage saveFormFieldMessageDetail(BcexUserContext userContext, FormFieldMessage formFieldMessage) throws Exception{	

 		
 		return saveFormFieldMessage(userContext, formFieldMessage, allTokens());
 	}
 	
 	public FormFieldMessage loadFormFieldMessage(BcexUserContext userContext, String formFieldMessageId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	
 	 public FormFieldMessage searchFormFieldMessage(BcexUserContext userContext, String formFieldMessageId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formFieldMessage, tokens);
 	}
 	
 	

 	protected FormFieldMessage present(BcexUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formFieldMessage,tokens);
		
		
		FormFieldMessage  formFieldMessageToPresent = formFieldMessageDaoOf(userContext).present(formFieldMessage, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldMessageToPresent.collectRefercencesFromLists();
		formFieldMessageDaoOf(userContext).alias(entityListToNaming);
		
		return  formFieldMessageToPresent;
		
		
	}
 
 	
 	
 	public FormFieldMessage loadFormFieldMessageDetail(BcexUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, allTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String formFieldMessageId) throws Exception{	
 		FormFieldMessage formFieldMessage = loadFormFieldMessage( userContext, formFieldMessageId, viewTokens());
 		return present(userContext,formFieldMessage, allTokens());
		
 	}
 	protected FormFieldMessage saveFormFieldMessage(BcexUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object>tokens) throws Exception{	
 		return formFieldMessageDaoOf(userContext).save(formFieldMessage, tokens);
 	}
 	protected FormFieldMessage loadFormFieldMessage(BcexUserContext userContext, String formFieldMessageId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldMessageManagerException.class);

 
 		return formFieldMessageDaoOf(userContext).load(formFieldMessageId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
		super.addActions(userContext, formFieldMessage, tokens);
		
		addAction(userContext, formFieldMessage, tokens,"@create","createFormFieldMessage","createFormFieldMessage/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@update","updateFormFieldMessage","updateFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		addAction(userContext, formFieldMessage, tokens,"@copy","cloneFormFieldMessage","cloneFormFieldMessage/"+formFieldMessage.getId()+"/","main","primary");
		
		addAction(userContext, formFieldMessage, tokens,"form_field_message.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formFieldMessage.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormFieldMessage formFieldMessage, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormFieldMessage createFormFieldMessage(BcexUserContext userContext,String title, String parameterName, String formId, String level) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTitleOfFormFieldMessage(title);
		checkerOf(userContext).checkParameterNameOfFormFieldMessage(parameterName);
		checkerOf(userContext).checkLevelOfFormFieldMessage(level);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);


		FormFieldMessage formFieldMessage=createNewFormFieldMessage();	

		formFieldMessage.setTitle(title);
		formFieldMessage.setParameterName(parameterName);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formFieldMessage.setForm(form);
		
		
		formFieldMessage.setLevel(level);

		formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
		
		onNewInstanceCreated(userContext, formFieldMessage);
		return formFieldMessage;

		
	}
	protected FormFieldMessage createNewFormFieldMessage() 
	{
		
		return new FormFieldMessage();		
	}
	
	protected void checkParamsForUpdatingFormFieldMessage(BcexUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
		checkerOf(userContext).checkVersionOfFormFieldMessage( formFieldMessageVersion);
		

		if(FormFieldMessage.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfFormFieldMessage(parseString(newValueExpr));
		}
		if(FormFieldMessage.PARAMETER_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterNameOfFormFieldMessage(parseString(newValueExpr));
		}		

		
		if(FormFieldMessage.LEVEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLevelOfFormFieldMessage(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);
	
		
	}
	
	
	
	public FormFieldMessage clone(BcexUserContext userContext, String fromFormFieldMessageId) throws Exception{
		
		return formFieldMessageDaoOf(userContext).clone(fromFormFieldMessageId, this.allTokens());
	}
	
	public FormFieldMessage internalSaveFormFieldMessage(BcexUserContext userContext, FormFieldMessage formFieldMessage) throws Exception 
	{
		return internalSaveFormFieldMessage(userContext, formFieldMessage, allTokens());

	}
	public FormFieldMessage internalSaveFormFieldMessage(BcexUserContext userContext, FormFieldMessage formFieldMessage, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			if (formFieldMessage.isChanged()){
			
			}
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, options);
			return formFieldMessage;
			
		}

	}
	
	public FormFieldMessage updateFormFieldMessage(BcexUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			formFieldMessage.changeProperty(property, newValueExpr);
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}
	
	public FormFieldMessage updateFormFieldMessageProperty(BcexUserContext userContext,String formFieldMessageId, int formFieldMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormFieldMessage(userContext, formFieldMessageId, formFieldMessageVersion, property, newValueExpr, tokensExpr);
		
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());
		if(formFieldMessage.getVersion() != formFieldMessageVersion){
			String message = "The target version("+formFieldMessage.getVersion()+") is not equals to version("+formFieldMessageVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formFieldMessage){ 
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormFieldMessage.
			
			formFieldMessage.changeProperty(property, newValueExpr);
			
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
			return present(userContext,formFieldMessage, mergedAllTokens(tokensExpr));
			//return saveFormFieldMessage(userContext, formFieldMessage, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormFieldMessageTokens tokens(){
		return FormFieldMessageTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldMessageTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldMessageTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(BcexUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFormFieldMessage(formFieldMessageId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldMessageManagerException.class);
 		
 	}
 	public FormFieldMessage transferToAnotherForm(BcexUserContext userContext, String formFieldMessageId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldMessageId,anotherFormId);
 
		FormFieldMessage formFieldMessage = loadFormFieldMessage(userContext, formFieldMessageId, allTokens());	
		synchronized(formFieldMessage){
			//will be good when the formFieldMessage loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formFieldMessage.updateForm(form);		
			formFieldMessage = saveFormFieldMessage(userContext, formFieldMessage, emptyOptions());
			
			return present(userContext,formFieldMessage, allTokens());
			
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
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormFieldMessage(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		//deleteInternal(userContext, formFieldMessageId, formFieldMessageVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{
			
		formFieldMessageDaoOf(userContext).delete(formFieldMessageId, formFieldMessageVersion);
	}
	
	public FormFieldMessage forgetByAll(BcexUserContext userContext, String formFieldMessageId, int formFieldMessageVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldMessageId, formFieldMessageVersion);		
	}
	protected FormFieldMessage forgetByAllInternal(BcexUserContext userContext,
			String formFieldMessageId, int formFieldMessageVersion) throws Exception{
			
		return formFieldMessageDaoOf(userContext).disconnectFromAll(formFieldMessageId, formFieldMessageVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldMessageManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return formFieldMessageDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, FormFieldMessage newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


