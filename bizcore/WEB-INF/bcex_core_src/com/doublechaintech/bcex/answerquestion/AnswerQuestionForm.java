package com.doublechaintech.bcex.answerquestion;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class AnswerQuestionForm extends BaseForm {
	
	
	public AnswerQuestionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AnswerQuestionForm answerQuestionIdField(String parameterName, String initValue){
		FormField field = idFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm answerQuestionIdField(String initValue){
		return answerQuestionIdField("answerQuestionId",initValue);
	}
	public AnswerQuestionForm answerQuestionIdField(){
		return answerQuestionIdField("answerQuestionId","");
	}


	public AnswerQuestionForm nickNameField(String parameterName, String initValue){
		FormField field = nickNameFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm nickNameField(String initValue){
		return nickNameField("nickName",initValue);
	}
	public AnswerQuestionForm nickNameField(){
		return nickNameField("nickName","");
	}


	public AnswerQuestionForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public AnswerQuestionForm userIdField(){
		return userIdField("userId","");
	}


	public AnswerQuestionForm userAnswerIdField(String parameterName, String initValue){
		FormField field = userAnswerIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm userAnswerIdField(String initValue){
		return userAnswerIdField("userAnswerId",initValue);
	}
	public AnswerQuestionForm userAnswerIdField(){
		return userAnswerIdField("userAnswerId","");
	}


	public AnswerQuestionForm answerField(String parameterName, String initValue){
		FormField field = answerFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm answerField(String initValue){
		return answerField("answer",initValue);
	}
	public AnswerQuestionForm answerField(){
		return answerField("answer","");
	}


	public AnswerQuestionForm changeRequestIdField(String parameterName, String initValue){
		FormField field = changeRequestIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm changeRequestIdField(String initValue){
		return changeRequestIdField("changeRequestId",initValue);
	}
	public AnswerQuestionForm changeRequestIdField(){
		return changeRequestIdField("changeRequestId","");
	}

	
	


	public AnswerQuestionForm wechatUserIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm wechatUserIdFieldOfWechatUser(String initValue){
		return wechatUserIdFieldOfWechatUser("wechatUserId",initValue);
	}
	public AnswerQuestionForm wechatUserIdFieldOfWechatUser(){
		return wechatUserIdFieldOfWechatUser("wechatUserId","");
	}


	public AnswerQuestionForm nameFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm nameFieldOfWechatUser(String initValue){
		return nameFieldOfWechatUser("name",initValue);
	}
	public AnswerQuestionForm nameFieldOfWechatUser(){
		return nameFieldOfWechatUser("name","");
	}


	public AnswerQuestionForm avartaFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm avartaFieldOfWechatUser(String initValue){
		return avartaFieldOfWechatUser("avarta",initValue);
	}
	public AnswerQuestionForm avartaFieldOfWechatUser(){
		return avartaFieldOfWechatUser("avarta","");
	}


	public AnswerQuestionForm createTimeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm createTimeFieldOfWechatUser(String initValue){
		return createTimeFieldOfWechatUser("createTime",initValue);
	}
	public AnswerQuestionForm createTimeFieldOfWechatUser(){
		return createTimeFieldOfWechatUser("createTime","");
	}


	public AnswerQuestionForm userTypeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  userTypeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm userTypeFieldOfWechatUser(String initValue){
		return userTypeFieldOfWechatUser("userType",initValue);
	}
	public AnswerQuestionForm userTypeFieldOfWechatUser(){
		return userTypeFieldOfWechatUser("userType","");
	}


	public AnswerQuestionForm platformIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm platformIdFieldOfWechatUser(String initValue){
		return platformIdFieldOfWechatUser("platformId",initValue);
	}
	public AnswerQuestionForm platformIdFieldOfWechatUser(){
		return platformIdFieldOfWechatUser("platformId","");
	}


	public AnswerQuestionForm userAnswerIdFieldOfUserAnswer(String parameterName, String initValue){
		FormField field =  idFromUserAnswer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm userAnswerIdFieldOfUserAnswer(String initValue){
		return userAnswerIdFieldOfUserAnswer("userAnswerId",initValue);
	}
	public AnswerQuestionForm userAnswerIdFieldOfUserAnswer(){
		return userAnswerIdFieldOfUserAnswer("userAnswerId","");
	}


	public AnswerQuestionForm topicFieldOfUserAnswer(String parameterName, String initValue){
		FormField field =  topicFromUserAnswer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm topicFieldOfUserAnswer(String initValue){
		return topicFieldOfUserAnswer("topic",initValue);
	}
	public AnswerQuestionForm topicFieldOfUserAnswer(){
		return topicFieldOfUserAnswer("topic","");
	}


	public AnswerQuestionForm userSelectFieldOfUserAnswer(String parameterName, String initValue){
		FormField field =  userSelectFromUserAnswer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm userSelectFieldOfUserAnswer(String initValue){
		return userSelectFieldOfUserAnswer("userSelect",initValue);
	}
	public AnswerQuestionForm userSelectFieldOfUserAnswer(){
		return userSelectFieldOfUserAnswer("userSelect","");
	}


	public AnswerQuestionForm questionIdFieldOfUserAnswer(String parameterName, String initValue){
		FormField field =  questionIdFromUserAnswer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm questionIdFieldOfUserAnswer(String initValue){
		return questionIdFieldOfUserAnswer("questionId",initValue);
	}
	public AnswerQuestionForm questionIdFieldOfUserAnswer(){
		return questionIdFieldOfUserAnswer("questionId","");
	}


	public AnswerQuestionForm examIdFieldOfUserAnswer(String parameterName, String initValue){
		FormField field =  examIdFromUserAnswer(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm examIdFieldOfUserAnswer(String initValue){
		return examIdFieldOfUserAnswer("examId",initValue);
	}
	public AnswerQuestionForm examIdFieldOfUserAnswer(){
		return examIdFieldOfUserAnswer("examId","");
	}


	public AnswerQuestionForm changeRequestIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm changeRequestIdFieldOfChangeRequest(String initValue){
		return changeRequestIdFieldOfChangeRequest("changeRequestId",initValue);
	}
	public AnswerQuestionForm changeRequestIdFieldOfChangeRequest(){
		return changeRequestIdFieldOfChangeRequest("changeRequestId","");
	}


	public AnswerQuestionForm nameFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm nameFieldOfChangeRequest(String initValue){
		return nameFieldOfChangeRequest("name",initValue);
	}
	public AnswerQuestionForm nameFieldOfChangeRequest(){
		return nameFieldOfChangeRequest("name","");
	}


	public AnswerQuestionForm createTimeFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm createTimeFieldOfChangeRequest(String initValue){
		return createTimeFieldOfChangeRequest("createTime",initValue);
	}
	public AnswerQuestionForm createTimeFieldOfChangeRequest(){
		return createTimeFieldOfChangeRequest("createTime","");
	}


	public AnswerQuestionForm remoteIpFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm remoteIpFieldOfChangeRequest(String initValue){
		return remoteIpFieldOfChangeRequest("remoteIp",initValue);
	}
	public AnswerQuestionForm remoteIpFieldOfChangeRequest(){
		return remoteIpFieldOfChangeRequest("remoteIp","");
	}


	public AnswerQuestionForm requestTypeIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm requestTypeIdFieldOfChangeRequest(String initValue){
		return requestTypeIdFieldOfChangeRequest("requestTypeId",initValue);
	}
	public AnswerQuestionForm requestTypeIdFieldOfChangeRequest(){
		return requestTypeIdFieldOfChangeRequest("requestTypeId","");
	}


	public AnswerQuestionForm platformIdFieldOfChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm platformIdFieldOfChangeRequest(String initValue){
		return platformIdFieldOfChangeRequest("platformId",initValue);
	}
	public AnswerQuestionForm platformIdFieldOfChangeRequest(){
		return platformIdFieldOfChangeRequest("platformId","");
	}

	


	

	
 	public AnswerQuestionForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/answerQuestionId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AnswerQuestionForm transferToAnotherUserAnswerAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUserAnswer/answerQuestionId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public AnswerQuestionForm transferToAnotherChangeRequestAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherChangeRequest/answerQuestionId/");
		this.addFormAction(action);
		return this;
	}

 

	public AnswerQuestionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


