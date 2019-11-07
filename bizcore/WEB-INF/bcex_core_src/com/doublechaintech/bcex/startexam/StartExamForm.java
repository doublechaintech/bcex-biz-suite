package com.doublechaintech.bcex.startexam;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class StartExamForm extends BaseForm {
	
	
	public StartExamForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public StartExamForm startExamIdField(String parameterName, String initValue){
		FormField field = idFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StartExamForm startExamIdField(String initValue){
		return startExamIdField("startExamId",initValue);
	}
	public StartExamForm startExamIdField(){
		return startExamIdField("startExamId","");
	}


	public StartExamForm nickNameField(String parameterName, String initValue){
		FormField field = nickNameFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StartExamForm nickNameField(String initValue){
		return nickNameField("nickName",initValue);
	}
	public StartExamForm nickNameField(){
		return nickNameField("nickName","");
	}


	public StartExamForm changeRequestIdField(String parameterName, String initValue){
		FormField field = changeRequestIdFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StartExamForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public StartExamForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}

	
	


	public StartExamForm changeRequestIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm changeRequestIdFieldOfChangeRequest(String initValue){
		return changeRequestIdFieldOfChangeRequest("changeRequestId",initValue);
	}
	public StartExamForm changeRequestIdFieldOfChangeRequest(){
		return changeRequestIdFieldOfChangeRequest("changeRequestId","");
	}


	public StartExamForm nameFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm nameFieldOfChangeRequest(String initValue){
		return nameFieldOfChangeRequest("name",initValue);
	}
	public StartExamForm nameFieldOfChangeRequest(){
		return nameFieldOfChangeRequest("name","");
	}


	public StartExamForm createTimeFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm createTimeFieldOfChangeRequest(String initValue){
		return createTimeFieldOfChangeRequest("createTime",initValue);
	}
	public StartExamForm createTimeFieldOfChangeRequest(){
		return createTimeFieldOfChangeRequest("createTime","");
	}


	public StartExamForm remoteIpFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm remoteIpFieldOfChangeRequest(String initValue){
		return remoteIpFieldOfChangeRequest("remoteIp",initValue);
	}
	public StartExamForm remoteIpFieldOfChangeRequest(){
		return remoteIpFieldOfChangeRequest("remoteIp","");
	}


	public StartExamForm requestTypeIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm requestTypeIdFieldOfChangeRequest(String initValue){
		return requestTypeIdFieldOfChangeRequest("requestTypeId",initValue);
	}
	public StartExamForm requestTypeIdFieldOfChangeRequest(){
		return requestTypeIdFieldOfChangeRequest("requestTypeId","");
	}


	public StartExamForm platformIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm platformIdFieldOfChangeRequest(String initValue){
		return platformIdFieldOfChangeRequest("platformId",initValue);
	}
	public StartExamForm platformIdFieldOfChangeRequest(){
		return platformIdFieldOfChangeRequest("platformId","");
	}

	


	

	
 	public StartExamForm transferToAnotherChangeRequestAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChangeRequest/startExamId/");
		this.addFormAction(action);
		return this;
	}

 

	public StartExamForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


