
package com.doublechaintech.bcex.formaction;

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







public class FormActionManagerImpl extends CustomBcexCheckerManager implements FormActionManager {
	
	private static final String SERVICE_TYPE = "FormAction";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormActionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormActionManagerException(message);

	}
	
	

 	protected FormAction saveFormAction(BcexUserContext userContext, FormAction formAction, String [] tokensExpr) throws Exception{	
 		//return getFormActionDAO().save(formAction, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormAction(userContext, formAction, tokens);
 	}
 	
 	protected FormAction saveFormActionDetail(BcexUserContext userContext, FormAction formAction) throws Exception{	

 		
 		return saveFormAction(userContext, formAction, allTokens());
 	}
 	
 	public FormAction loadFormAction(BcexUserContext userContext, String formActionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	
 	 public FormAction searchFormAction(BcexUserContext userContext, String formActionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormAction formAction = loadFormAction( userContext, formActionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formAction, tokens);
 	}
 	
 	

 	protected FormAction present(BcexUserContext userContext, FormAction formAction, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formAction,tokens);
		
		
		FormAction  formActionToPresent = formActionDaoOf(userContext).present(formAction, tokens);
		
		List<BaseEntity> entityListToNaming = formActionToPresent.collectRefercencesFromLists();
		formActionDaoOf(userContext).alias(entityListToNaming);
		
		return  formActionToPresent;
		
		
	}
 
 	
 	
 	public FormAction loadFormActionDetail(BcexUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, allTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String formActionId) throws Exception{	
 		FormAction formAction = loadFormAction( userContext, formActionId, viewTokens());
 		return present(userContext,formAction, allTokens());
		
 	}
 	protected FormAction saveFormAction(BcexUserContext userContext, FormAction formAction, Map<String,Object>tokens) throws Exception{	
 		return formActionDaoOf(userContext).save(formAction, tokens);
 	}
 	protected FormAction loadFormAction(BcexUserContext userContext, String formActionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormActionManagerException.class);

 
 		return formActionDaoOf(userContext).load(formActionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormAction formAction, Map<String, Object> tokens){
		super.addActions(userContext, formAction, tokens);
		
		addAction(userContext, formAction, tokens,"@create","createFormAction","createFormAction/","main","primary");
		addAction(userContext, formAction, tokens,"@update","updateFormAction","updateFormAction/"+formAction.getId()+"/","main","primary");
		addAction(userContext, formAction, tokens,"@copy","cloneFormAction","cloneFormAction/"+formAction.getId()+"/","main","primary");
		
		addAction(userContext, formAction, tokens,"form_action.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formAction.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormAction formAction, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormAction createFormAction(BcexUserContext userContext,String label, String localeKey, String actionKey, String level, String url, String formId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkLabelOfFormAction(label);
		checkerOf(userContext).checkLocaleKeyOfFormAction(localeKey);
		checkerOf(userContext).checkActionKeyOfFormAction(actionKey);
		checkerOf(userContext).checkLevelOfFormAction(level);
		checkerOf(userContext).checkUrlOfFormAction(url);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);


		FormAction formAction=createNewFormAction();	

		formAction.setLabel(label);
		formAction.setLocaleKey(localeKey);
		formAction.setActionKey(actionKey);
		formAction.setLevel(level);
		formAction.setUrl(url);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formAction.setForm(form);
		
		

		formAction = saveFormAction(userContext, formAction, emptyOptions());
		
		onNewInstanceCreated(userContext, formAction);
		return formAction;

		
	}
	protected FormAction createNewFormAction() 
	{
		
		return new FormAction();		
	}
	
	protected void checkParamsForUpdatingFormAction(BcexUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormAction(formActionId);
		checkerOf(userContext).checkVersionOfFormAction( formActionVersion);
		

		if(FormAction.LABEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLabelOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.LOCALE_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkLocaleKeyOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.ACTION_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkActionKeyOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.LEVEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLevelOfFormAction(parseString(newValueExpr));
		}
		if(FormAction.URL_PROPERTY.equals(property)){
			checkerOf(userContext).checkUrlOfFormAction(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);
	
		
	}
	
	
	
	public FormAction clone(BcexUserContext userContext, String fromFormActionId) throws Exception{
		
		return formActionDaoOf(userContext).clone(fromFormActionId, this.allTokens());
	}
	
	public FormAction internalSaveFormAction(BcexUserContext userContext, FormAction formAction) throws Exception 
	{
		return internalSaveFormAction(userContext, formAction, allTokens());

	}
	public FormAction internalSaveFormAction(BcexUserContext userContext, FormAction formAction, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			if (formAction.isChanged()){
			
			}
			formAction = saveFormAction(userContext, formAction, options);
			return formAction;
			
		}

	}
	
	public FormAction updateFormAction(BcexUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	
	public FormAction updateFormActionProperty(BcexUserContext userContext,String formActionId, int formActionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormAction(userContext, formActionId, formActionVersion, property, newValueExpr, tokensExpr);
		
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());
		if(formAction.getVersion() != formActionVersion){
			String message = "The target version("+formAction.getVersion()+") is not equals to version("+formActionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formAction){ 
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormAction.
			
			formAction.changeProperty(property, newValueExpr);
			
			formAction = saveFormAction(userContext, formAction, tokens().done());
			return present(userContext,formAction, mergedAllTokens(tokensExpr));
			//return saveFormAction(userContext, formAction, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormActionTokens tokens(){
		return FormActionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormActionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormActionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(BcexUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFormAction(formActionId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormActionManagerException.class);
 		
 	}
 	public FormAction transferToAnotherForm(BcexUserContext userContext, String formActionId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formActionId,anotherFormId);
 
		FormAction formAction = loadFormAction(userContext, formActionId, allTokens());	
		synchronized(formAction){
			//will be good when the formAction loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formAction.updateForm(form);		
			formAction = saveFormAction(userContext, formAction, emptyOptions());
			
			return present(userContext,formAction, allTokens());
			
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
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormAction(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		//deleteInternal(userContext, formActionId, formActionVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{
			
		formActionDaoOf(userContext).delete(formActionId, formActionVersion);
	}
	
	public FormAction forgetByAll(BcexUserContext userContext, String formActionId, int formActionVersion) throws Exception {
		return forgetByAllInternal(userContext, formActionId, formActionVersion);		
	}
	protected FormAction forgetByAllInternal(BcexUserContext userContext,
			String formActionId, int formActionVersion) throws Exception{
			
		return formActionDaoOf(userContext).disconnectFromAll(formActionId, formActionVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormActionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return formActionDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, FormAction newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


