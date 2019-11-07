
package com.doublechaintech.bcex.formfield;

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







public class FormFieldManagerImpl extends CustomBcexCheckerManager implements FormFieldManager {
	
	private static final String SERVICE_TYPE = "FormField";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws FormFieldManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new FormFieldManagerException(message);

	}
	
	

 	protected FormField saveFormField(BcexUserContext userContext, FormField formField, String [] tokensExpr) throws Exception{	
 		//return getFormFieldDAO().save(formField, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveFormField(userContext, formField, tokens);
 	}
 	
 	protected FormField saveFormFieldDetail(BcexUserContext userContext, FormField formField) throws Exception{	

 		
 		return saveFormField(userContext, formField, allTokens());
 	}
 	
 	public FormField loadFormField(BcexUserContext userContext, String formFieldId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	
 	 public FormField searchFormField(BcexUserContext userContext, String formFieldId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		FormField formField = loadFormField( userContext, formFieldId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,formField, tokens);
 	}
 	
 	

 	protected FormField present(BcexUserContext userContext, FormField formField, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,formField,tokens);
		
		
		FormField  formFieldToPresent = formFieldDaoOf(userContext).present(formField, tokens);
		
		List<BaseEntity> entityListToNaming = formFieldToPresent.collectRefercencesFromLists();
		formFieldDaoOf(userContext).alias(entityListToNaming);
		
		return  formFieldToPresent;
		
		
	}
 
 	
 	
 	public FormField loadFormFieldDetail(BcexUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, allTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String formFieldId) throws Exception{	
 		FormField formField = loadFormField( userContext, formFieldId, viewTokens());
 		return present(userContext,formField, allTokens());
		
 	}
 	protected FormField saveFormField(BcexUserContext userContext, FormField formField, Map<String,Object>tokens) throws Exception{	
 		return formFieldDaoOf(userContext).save(formField, tokens);
 	}
 	protected FormField loadFormField(BcexUserContext userContext, String formFieldId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).throwExceptionIfHasErrors( FormFieldManagerException.class);

 
 		return formFieldDaoOf(userContext).load(formFieldId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormField formField, Map<String, Object> tokens){
		super.addActions(userContext, formField, tokens);
		
		addAction(userContext, formField, tokens,"@create","createFormField","createFormField/","main","primary");
		addAction(userContext, formField, tokens,"@update","updateFormField","updateFormField/"+formField.getId()+"/","main","primary");
		addAction(userContext, formField, tokens,"@copy","cloneFormField","cloneFormField/"+formField.getId()+"/","main","primary");
		
		addAction(userContext, formField, tokens,"form_field.transfer_to_form","transferToAnotherForm","transferToAnotherForm/"+formField.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, FormField formField, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public FormField createFormField(BcexUserContext userContext,String label, String localeKey, String parameterName, String type, String formId, String placeholder, String defaultValue, String description, String fieldGroup, String minimumValue, String maximumValue, boolean required, boolean disabled, boolean customRendering, String candidateValues, String suggestValues) throws Exception
	{
		
		

		

		checkerOf(userContext).checkLabelOfFormField(label);
		checkerOf(userContext).checkLocaleKeyOfFormField(localeKey);
		checkerOf(userContext).checkParameterNameOfFormField(parameterName);
		checkerOf(userContext).checkTypeOfFormField(type);
		checkerOf(userContext).checkPlaceholderOfFormField(placeholder);
		checkerOf(userContext).checkDefaultValueOfFormField(defaultValue);
		checkerOf(userContext).checkDescriptionOfFormField(description);
		checkerOf(userContext).checkFieldGroupOfFormField(fieldGroup);
		checkerOf(userContext).checkMinimumValueOfFormField(minimumValue);
		checkerOf(userContext).checkMaximumValueOfFormField(maximumValue);
		checkerOf(userContext).checkRequiredOfFormField(required);
		checkerOf(userContext).checkDisabledOfFormField(disabled);
		checkerOf(userContext).checkCustomRenderingOfFormField(customRendering);
		checkerOf(userContext).checkCandidateValuesOfFormField(candidateValues);
		checkerOf(userContext).checkSuggestValuesOfFormField(suggestValues);
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);


		FormField formField=createNewFormField();	

		formField.setLabel(label);
		formField.setLocaleKey(localeKey);
		formField.setParameterName(parameterName);
		formField.setType(type);
			
		GenericForm form = loadGenericForm(userContext, formId,emptyOptions());
		formField.setForm(form);
		
		
		formField.setPlaceholder(placeholder);
		formField.setDefaultValue(defaultValue);
		formField.setDescription(description);
		formField.setFieldGroup(fieldGroup);
		formField.setMinimumValue(minimumValue);
		formField.setMaximumValue(maximumValue);
		formField.setRequired(required);
		formField.setDisabled(disabled);
		formField.setCustomRendering(customRendering);
		formField.setCandidateValues(candidateValues);
		formField.setSuggestValues(suggestValues);

		formField = saveFormField(userContext, formField, emptyOptions());
		
		onNewInstanceCreated(userContext, formField);
		return formField;

		
	}
	protected FormField createNewFormField() 
	{
		
		return new FormField();		
	}
	
	protected void checkParamsForUpdatingFormField(BcexUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfFormField(formFieldId);
		checkerOf(userContext).checkVersionOfFormField( formFieldVersion);
		

		if(FormField.LABEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLabelOfFormField(parseString(newValueExpr));
		}
		if(FormField.LOCALE_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkLocaleKeyOfFormField(parseString(newValueExpr));
		}
		if(FormField.PARAMETER_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkParameterNameOfFormField(parseString(newValueExpr));
		}
		if(FormField.TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTypeOfFormField(parseString(newValueExpr));
		}		

		
		if(FormField.PLACEHOLDER_PROPERTY.equals(property)){
			checkerOf(userContext).checkPlaceholderOfFormField(parseString(newValueExpr));
		}
		if(FormField.DEFAULT_VALUE_PROPERTY.equals(property)){
			checkerOf(userContext).checkDefaultValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.DESCRIPTION_PROPERTY.equals(property)){
			checkerOf(userContext).checkDescriptionOfFormField(parseString(newValueExpr));
		}
		if(FormField.FIELD_GROUP_PROPERTY.equals(property)){
			checkerOf(userContext).checkFieldGroupOfFormField(parseString(newValueExpr));
		}
		if(FormField.MINIMUM_VALUE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMinimumValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.MAXIMUM_VALUE_PROPERTY.equals(property)){
			checkerOf(userContext).checkMaximumValueOfFormField(parseString(newValueExpr));
		}
		if(FormField.REQUIRED_PROPERTY.equals(property)){
			checkerOf(userContext).checkRequiredOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.DISABLED_PROPERTY.equals(property)){
			checkerOf(userContext).checkDisabledOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.CUSTOM_RENDERING_PROPERTY.equals(property)){
			checkerOf(userContext).checkCustomRenderingOfFormField(parseBoolean(newValueExpr));
		}
		if(FormField.CANDIDATE_VALUES_PROPERTY.equals(property)){
			checkerOf(userContext).checkCandidateValuesOfFormField(parseString(newValueExpr));
		}
		if(FormField.SUGGEST_VALUES_PROPERTY.equals(property)){
			checkerOf(userContext).checkSuggestValuesOfFormField(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);
	
		
	}
	
	
	
	public FormField clone(BcexUserContext userContext, String fromFormFieldId) throws Exception{
		
		return formFieldDaoOf(userContext).clone(fromFormFieldId, this.allTokens());
	}
	
	public FormField internalSaveFormField(BcexUserContext userContext, FormField formField) throws Exception 
	{
		return internalSaveFormField(userContext, formField, allTokens());

	}
	public FormField internalSaveFormField(BcexUserContext userContext, FormField formField, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			if (formField.isChanged()){
			
			}
			formField = saveFormField(userContext, formField, options);
			return formField;
			
		}

	}
	
	public FormField updateFormField(BcexUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		
		
		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			formField.changeProperty(property, newValueExpr);
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}
	
	public FormField updateFormFieldProperty(BcexUserContext userContext,String formFieldId, int formFieldVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingFormField(userContext, formFieldId, formFieldVersion, property, newValueExpr, tokensExpr);
		
		FormField formField = loadFormField(userContext, formFieldId, allTokens());
		if(formField.getVersion() != formFieldVersion){
			String message = "The target version("+formField.getVersion()+") is not equals to version("+formFieldVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(formField){ 
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to FormField.
			
			formField.changeProperty(property, newValueExpr);
			
			formField = saveFormField(userContext, formField, tokens().done());
			return present(userContext,formField, mergedAllTokens(tokensExpr));
			//return saveFormField(userContext, formField, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected FormFieldTokens tokens(){
		return FormFieldTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return FormFieldTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return FormFieldTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherForm(BcexUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfFormField(formFieldId);
 		checkerOf(userContext).checkIdOfGenericForm(anotherFormId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(FormFieldManagerException.class);
 		
 	}
 	public FormField transferToAnotherForm(BcexUserContext userContext, String formFieldId, String anotherFormId) throws Exception
 	{
 		checkParamsForTransferingAnotherForm(userContext, formFieldId,anotherFormId);
 
		FormField formField = loadFormField(userContext, formFieldId, allTokens());	
		synchronized(formField){
			//will be good when the formField loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			GenericForm form = loadGenericForm(userContext, anotherFormId, emptyOptions());		
			formField.updateForm(form);		
			formField = saveFormField(userContext, formField, emptyOptions());
			
			return present(userContext,formField, allTokens());
			
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
		SmartList<GenericForm> candidateList = genericFormDaoOf(userContext).requestCandidateGenericFormForFormField(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		//deleteInternal(userContext, formFieldId, formFieldVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{
			
		formFieldDaoOf(userContext).delete(formFieldId, formFieldVersion);
	}
	
	public FormField forgetByAll(BcexUserContext userContext, String formFieldId, int formFieldVersion) throws Exception {
		return forgetByAllInternal(userContext, formFieldId, formFieldVersion);		
	}
	protected FormField forgetByAllInternal(BcexUserContext userContext,
			String formFieldId, int formFieldVersion) throws Exception{
			
		return formFieldDaoOf(userContext).disconnectFromAll(formFieldId, formFieldVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new FormFieldManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return formFieldDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, FormField newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


