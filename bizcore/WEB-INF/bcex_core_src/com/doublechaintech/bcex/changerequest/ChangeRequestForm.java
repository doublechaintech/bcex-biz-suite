package com.doublechaintech.bcex.changerequest;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class ChangeRequestForm extends BaseForm {
	
	
	public ChangeRequestForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ChangeRequestForm changeRequestIdField(String parameterName, String initValue){
		FormField field = idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}


	public ChangeRequestForm nameField(String parameterName, String initValue){
		FormField field = nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ChangeRequestForm nameField(){
		return nameField("name","");
	}


	public ChangeRequestForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ChangeRequestForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ChangeRequestForm remoteIpField(String parameterName, String initValue){
		FormField field = remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm remoteIpField(String initValue){
		return remoteIpField("remoteIp",initValue);
	}
	public ChangeRequestForm remoteIpField(){
		return remoteIpField("remoteIp","");
	}


	public ChangeRequestForm requestTypeIdField(String parameterName, String initValue){
		FormField field = requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm requestTypeIdField(String initValue){
		return requestTypeIdField("requestTypeId",initValue);
	}
	public ChangeRequestForm requestTypeIdField(){
		return requestTypeIdField("requestTypeId","");
	}


	public ChangeRequestForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ChangeRequestForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  idFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(String initValue){
		return changeRequestTypeIdFieldOfChangeRequestType("changeRequestTypeId",initValue);
	}
	public ChangeRequestForm changeRequestTypeIdFieldOfChangeRequestType(){
		return changeRequestTypeIdFieldOfChangeRequestType("changeRequestTypeId","");
	}


	public ChangeRequestForm nameFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  nameFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm nameFieldOfChangeRequestType(String initValue){
		return nameFieldOfChangeRequestType("name",initValue);
	}
	public ChangeRequestForm nameFieldOfChangeRequestType(){
		return nameFieldOfChangeRequestType("name","");
	}


	public ChangeRequestForm codeFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  codeFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm codeFieldOfChangeRequestType(String initValue){
		return codeFieldOfChangeRequestType("code",initValue);
	}
	public ChangeRequestForm codeFieldOfChangeRequestType(){
		return codeFieldOfChangeRequestType("code","");
	}


	public ChangeRequestForm iconFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  iconFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm iconFieldOfChangeRequestType(String initValue){
		return iconFieldOfChangeRequestType("icon",initValue);
	}
	public ChangeRequestForm iconFieldOfChangeRequestType(){
		return iconFieldOfChangeRequestType("icon","");
	}


	public ChangeRequestForm displayOrderFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  displayOrderFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm displayOrderFieldOfChangeRequestType(String initValue){
		return displayOrderFieldOfChangeRequestType("displayOrder",initValue);
	}
	public ChangeRequestForm displayOrderFieldOfChangeRequestType(){
		return displayOrderFieldOfChangeRequestType("displayOrder","");
	}


	public ChangeRequestForm platformIdFieldOfChangeRequestType(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequestType(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm platformIdFieldOfChangeRequestType(String initValue){
		return platformIdFieldOfChangeRequestType("platformId",initValue);
	}
	public ChangeRequestForm platformIdFieldOfChangeRequestType(){
		return platformIdFieldOfChangeRequestType("platformId","");
	}


	public ChangeRequestForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ChangeRequestForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ChangeRequestForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ChangeRequestForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ChangeRequestForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ChangeRequestForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public ChangeRequestForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	



	public ChangeRequestForm registerationIdFieldForRegisteration(String parameterName, String initValue){
		FormField field =  idFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm registerationIdFieldForRegisteration(String initValue){
		return registerationIdFieldForRegisteration("registerationId",initValue);
	}
	public ChangeRequestForm registerationIdFieldForRegisteration(){
		return registerationIdFieldForRegisteration("registerationId","");
	}


	public ChangeRequestForm nickNameFieldForRegisteration(String parameterName, String initValue){
		FormField field =  nickNameFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm nickNameFieldForRegisteration(String initValue){
		return nickNameFieldForRegisteration("nickName",initValue);
	}
	public ChangeRequestForm nickNameFieldForRegisteration(){
		return nickNameFieldForRegisteration("nickName","");
	}


	public ChangeRequestForm avartaFieldForRegisteration(String parameterName, String initValue){
		FormField field =  avartaFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm avartaFieldForRegisteration(String initValue){
		return avartaFieldForRegisteration("avarta",initValue);
	}
	public ChangeRequestForm avartaFieldForRegisteration(){
		return avartaFieldForRegisteration("avarta","");
	}


	public ChangeRequestForm changeRequestIdFieldForRegisteration(String parameterName, String initValue){
		FormField field =  changeRequestIdFromRegisteration(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdFieldForRegisteration(String initValue){
		return changeRequestIdFieldForRegisteration("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdFieldForRegisteration(){
		return changeRequestIdFieldForRegisteration("changeRequestId","");
	}


	public ChangeRequestForm startExamIdFieldForStartExam(String parameterName, String initValue){
		FormField field =  idFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm startExamIdFieldForStartExam(String initValue){
		return startExamIdFieldForStartExam("startExamId",initValue);
	}
	public ChangeRequestForm startExamIdFieldForStartExam(){
		return startExamIdFieldForStartExam("startExamId","");
	}


	public ChangeRequestForm nickNameFieldForStartExam(String parameterName, String initValue){
		FormField field =  nickNameFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm nickNameFieldForStartExam(String initValue){
		return nickNameFieldForStartExam("nickName",initValue);
	}
	public ChangeRequestForm nickNameFieldForStartExam(){
		return nickNameFieldForStartExam("nickName","");
	}


	public ChangeRequestForm changeRequestIdFieldForStartExam(String parameterName, String initValue){
		FormField field =  changeRequestIdFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdFieldForStartExam(String initValue){
		return changeRequestIdFieldForStartExam("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdFieldForStartExam(){
		return changeRequestIdFieldForStartExam("changeRequestId","");
	}


	public ChangeRequestForm answerQuestionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  idFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm answerQuestionIdFieldForAnswerQuestion(String initValue){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId",initValue);
	}
	public ChangeRequestForm answerQuestionIdFieldForAnswerQuestion(){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId","");
	}


	public ChangeRequestForm nickNameFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  nickNameFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm nickNameFieldForAnswerQuestion(String initValue){
		return nickNameFieldForAnswerQuestion("nickName",initValue);
	}
	public ChangeRequestForm nickNameFieldForAnswerQuestion(){
		return nickNameFieldForAnswerQuestion("nickName","");
	}


	public ChangeRequestForm userIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm userIdFieldForAnswerQuestion(String initValue){
		return userIdFieldForAnswerQuestion("userId",initValue);
	}
	public ChangeRequestForm userIdFieldForAnswerQuestion(){
		return userIdFieldForAnswerQuestion("userId","");
	}


	public ChangeRequestForm questionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  questionIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm questionIdFieldForAnswerQuestion(String initValue){
		return questionIdFieldForAnswerQuestion("questionId",initValue);
	}
	public ChangeRequestForm questionIdFieldForAnswerQuestion(){
		return questionIdFieldForAnswerQuestion("questionId","");
	}


	public ChangeRequestForm answerFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  answerFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm answerFieldForAnswerQuestion(String initValue){
		return answerFieldForAnswerQuestion("answer",initValue);
	}
	public ChangeRequestForm answerFieldForAnswerQuestion(){
		return answerFieldForAnswerQuestion("answer","");
	}


	public ChangeRequestForm changeRequestIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  changeRequestIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ChangeRequestForm changeRequestIdFieldForAnswerQuestion(String initValue){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId",initValue);
	}
	public ChangeRequestForm changeRequestIdFieldForAnswerQuestion(){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId","");
	}

	

	
 	public ChangeRequestForm transferToAnotherRequestTypeAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherRequestType/changeRequestId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ChangeRequestForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/changeRequestId/");
		this.addFormAction(action);
		return this;
	}

 

	public ChangeRequestForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


