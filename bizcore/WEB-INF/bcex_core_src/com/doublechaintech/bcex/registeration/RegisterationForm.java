package com.doublechaintech.bcex.registeration;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class RegisterationForm extends BaseForm {
	
	
	public RegisterationForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RegisterationForm registerationIdField(String parameterName, String initValue){
		FormField field = idFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegisterationForm registerationIdField(String initValue){
		return registerationIdField("registerationId",initValue);
	}
	public RegisterationForm registerationIdField(){
		return registerationIdField("registerationId","");
	}


	public RegisterationForm nickNameField(String parameterName, String initValue){
		FormField field = nickNameFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegisterationForm nickNameField(String initValue){
		return nickNameField("nickName",initValue);
	}
	public RegisterationForm nickNameField(){
		return nickNameField("nickName","");
	}


	public RegisterationForm avartaField(String parameterName, String initValue){
		FormField field = avartaFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegisterationForm avartaField(String initValue){
		return avartaField("avarta",initValue);
	}
	public RegisterationForm avartaField(){
		return avartaField("avarta","");
	}


	public RegisterationForm changeRequestIdField(String parameterName, String initValue){
		FormField field = changeRequestIdFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RegisterationForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public RegisterationForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}

	
	


	public RegisterationForm changeRequestIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm changeRequestIdFieldOfChangeRequest(String initValue){
		return changeRequestIdFieldOfChangeRequest("changeRequestId",initValue);
	}
	public RegisterationForm changeRequestIdFieldOfChangeRequest(){
		return changeRequestIdFieldOfChangeRequest("changeRequestId","");
	}


	public RegisterationForm nameFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm nameFieldOfChangeRequest(String initValue){
		return nameFieldOfChangeRequest("name",initValue);
	}
	public RegisterationForm nameFieldOfChangeRequest(){
		return nameFieldOfChangeRequest("name","");
	}


	public RegisterationForm createTimeFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm createTimeFieldOfChangeRequest(String initValue){
		return createTimeFieldOfChangeRequest("createTime",initValue);
	}
	public RegisterationForm createTimeFieldOfChangeRequest(){
		return createTimeFieldOfChangeRequest("createTime","");
	}


	public RegisterationForm remoteIpFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm remoteIpFieldOfChangeRequest(String initValue){
		return remoteIpFieldOfChangeRequest("remoteIp",initValue);
	}
	public RegisterationForm remoteIpFieldOfChangeRequest(){
		return remoteIpFieldOfChangeRequest("remoteIp","");
	}


	public RegisterationForm requestTypeIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm requestTypeIdFieldOfChangeRequest(String initValue){
		return requestTypeIdFieldOfChangeRequest("requestTypeId",initValue);
	}
	public RegisterationForm requestTypeIdFieldOfChangeRequest(){
		return requestTypeIdFieldOfChangeRequest("requestTypeId","");
	}


	public RegisterationForm platformIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RegisterationForm platformIdFieldOfChangeRequest(String initValue){
		return platformIdFieldOfChangeRequest("platformId",initValue);
	}
	public RegisterationForm platformIdFieldOfChangeRequest(){
		return platformIdFieldOfChangeRequest("platformId","");
	}

	


	

	
 	public RegisterationForm transferToAnotherChangeRequestAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChangeRequest/registerationId/");
		this.addFormAction(action);
		return this;
	}

 

	public RegisterationForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


