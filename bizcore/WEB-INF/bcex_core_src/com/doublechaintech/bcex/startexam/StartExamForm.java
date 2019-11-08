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


	public StartExamForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public StartExamForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public StartExamForm userIdField(){
		return userIdField("userId","");
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

	
	


	public StartExamForm wechatUserIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm wechatUserIdFieldOfWechatUser(String initValue){
		return wechatUserIdFieldOfWechatUser("wechatUserId",initValue);
	}
	public StartExamForm wechatUserIdFieldOfWechatUser(){
		return wechatUserIdFieldOfWechatUser("wechatUserId","");
	}


	public StartExamForm nameFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm nameFieldOfWechatUser(String initValue){
		return nameFieldOfWechatUser("name",initValue);
	}
	public StartExamForm nameFieldOfWechatUser(){
		return nameFieldOfWechatUser("name","");
	}


	public StartExamForm avartaFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm avartaFieldOfWechatUser(String initValue){
		return avartaFieldOfWechatUser("avarta",initValue);
	}
	public StartExamForm avartaFieldOfWechatUser(){
		return avartaFieldOfWechatUser("avarta","");
	}


	public StartExamForm createTimeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm createTimeFieldOfWechatUser(String initValue){
		return createTimeFieldOfWechatUser("createTime",initValue);
	}
	public StartExamForm createTimeFieldOfWechatUser(){
		return createTimeFieldOfWechatUser("createTime","");
	}


	public StartExamForm userTypeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  userTypeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm userTypeFieldOfWechatUser(String initValue){
		return userTypeFieldOfWechatUser("userType",initValue);
	}
	public StartExamForm userTypeFieldOfWechatUser(){
		return userTypeFieldOfWechatUser("userType","");
	}


	public StartExamForm platformIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public StartExamForm platformIdFieldOfWechatUser(String initValue){
		return platformIdFieldOfWechatUser("platformId",initValue);
	}
	public StartExamForm platformIdFieldOfWechatUser(){
		return platformIdFieldOfWechatUser("platformId","");
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

	


	

	
 	public StartExamForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/startExamId/");
		this.addFormAction(action);
		return this;
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


