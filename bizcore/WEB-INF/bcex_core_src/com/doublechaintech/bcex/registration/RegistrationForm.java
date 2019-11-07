package com.doublechaintech.bcex.registration;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class RegistrationForm extends BaseForm {
	
	
	public RegistrationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RegistrationForm registrationIdField(String parameterName, String initValue){
		FormField field = idFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm registrationIdField(String initValue){
		return registrationIdField("registrationId",initValue);
	}
	public RegistrationForm registrationIdField(){
		return registrationIdField("registrationId","");
	}


	public RegistrationForm nickNameField(String parameterName, String initValue){
		FormField field = nickNameFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm nickNameField(String initValue){
		return nickNameField("nickName",initValue);
	}
	public RegistrationForm nickNameField(){
		return nickNameField("nickName","");
	}


	public RegistrationForm avatarField(String parameterName, String initValue){
		FormField field = avatarFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm avatarField(String initValue){
		return avatarField("avatar",initValue);
	}
	public RegistrationForm avatarField(){
		return avatarField("avatar","");
	}


	public RegistrationForm changeRequestIdField(String parameterName, String initValue){
		FormField field = changeRequestIdFromRegistration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegistrationForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public RegistrationForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}

	
	


	public RegistrationForm changeRequestIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm changeRequestIdFieldOfChangeRequest(String initValue){
		return changeRequestIdFieldOfChangeRequest("changeRequestId",initValue);
	}
	public RegistrationForm changeRequestIdFieldOfChangeRequest(){
		return changeRequestIdFieldOfChangeRequest("changeRequestId","");
	}


	public RegistrationForm nameFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm nameFieldOfChangeRequest(String initValue){
		return nameFieldOfChangeRequest("name",initValue);
	}
	public RegistrationForm nameFieldOfChangeRequest(){
		return nameFieldOfChangeRequest("name","");
	}


	public RegistrationForm createTimeFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm createTimeFieldOfChangeRequest(String initValue){
		return createTimeFieldOfChangeRequest("createTime",initValue);
	}
	public RegistrationForm createTimeFieldOfChangeRequest(){
		return createTimeFieldOfChangeRequest("createTime","");
	}


	public RegistrationForm remoteIpFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm remoteIpFieldOfChangeRequest(String initValue){
		return remoteIpFieldOfChangeRequest("remoteIp",initValue);
	}
	public RegistrationForm remoteIpFieldOfChangeRequest(){
		return remoteIpFieldOfChangeRequest("remoteIp","");
	}


	public RegistrationForm requestTypeIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm requestTypeIdFieldOfChangeRequest(String initValue){
		return requestTypeIdFieldOfChangeRequest("requestTypeId",initValue);
	}
	public RegistrationForm requestTypeIdFieldOfChangeRequest(){
		return requestTypeIdFieldOfChangeRequest("requestTypeId","");
	}


	public RegistrationForm platformIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegistrationForm platformIdFieldOfChangeRequest(String initValue){
		return platformIdFieldOfChangeRequest("platformId",initValue);
	}
	public RegistrationForm platformIdFieldOfChangeRequest(){
		return platformIdFieldOfChangeRequest("platformId","");
	}

	


	

	
 	public RegistrationForm transferToAnotherChangeRequestAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChangeRequest/registrationId/");
		this.addFormAction(action);
		return this;
	}

 

	public RegistrationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


