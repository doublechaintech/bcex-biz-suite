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


	public AnswerQuestionForm questionIdField(String parameterName, String initValue){
		FormField field = questionIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerQuestionForm questionIdField(String initValue){
		return questionIdField("questionId",initValue);
	}
	public AnswerQuestionForm questionIdField(){
		return questionIdField("questionId","");
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


	public AnswerQuestionForm questionIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  idFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm questionIdFieldOfQuestion(String initValue){
		return questionIdFieldOfQuestion("questionId",initValue);
	}
	public AnswerQuestionForm questionIdFieldOfQuestion(){
		return questionIdFieldOfQuestion("questionId","");
	}


	public AnswerQuestionForm topicFieldOfQuestion(String parameterName, String initValue){
		FormField field =  topicFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm topicFieldOfQuestion(String initValue){
		return topicFieldOfQuestion("topic",initValue);
	}
	public AnswerQuestionForm topicFieldOfQuestion(){
		return topicFieldOfQuestion("topic","");
	}


	public AnswerQuestionForm levelFieldOfQuestion(String parameterName, String initValue){
		FormField field =  levelFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm levelFieldOfQuestion(String initValue){
		return levelFieldOfQuestion("level",initValue);
	}
	public AnswerQuestionForm levelFieldOfQuestion(){
		return levelFieldOfQuestion("level","");
	}


	public AnswerQuestionForm optionAFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionAFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm optionAFieldOfQuestion(String initValue){
		return optionAFieldOfQuestion("optionA",initValue);
	}
	public AnswerQuestionForm optionAFieldOfQuestion(){
		return optionAFieldOfQuestion("optionA","");
	}


	public AnswerQuestionForm optionBFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionBFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm optionBFieldOfQuestion(String initValue){
		return optionBFieldOfQuestion("optionB",initValue);
	}
	public AnswerQuestionForm optionBFieldOfQuestion(){
		return optionBFieldOfQuestion("optionB","");
	}


	public AnswerQuestionForm optionCFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionCFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm optionCFieldOfQuestion(String initValue){
		return optionCFieldOfQuestion("optionC",initValue);
	}
	public AnswerQuestionForm optionCFieldOfQuestion(){
		return optionCFieldOfQuestion("optionC","");
	}


	public AnswerQuestionForm optionDFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionDFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm optionDFieldOfQuestion(String initValue){
		return optionDFieldOfQuestion("optionD",initValue);
	}
	public AnswerQuestionForm optionDFieldOfQuestion(){
		return optionDFieldOfQuestion("optionD","");
	}


	public AnswerQuestionForm optionEFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionEFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm optionEFieldOfQuestion(String initValue){
		return optionEFieldOfQuestion("optionE",initValue);
	}
	public AnswerQuestionForm optionEFieldOfQuestion(){
		return optionEFieldOfQuestion("optionE","");
	}


	public AnswerQuestionForm rightAnswerFieldOfQuestion(String parameterName, String initValue){
		FormField field =  rightAnswerFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm rightAnswerFieldOfQuestion(String initValue){
		return rightAnswerFieldOfQuestion("rightAnswer",initValue);
	}
	public AnswerQuestionForm rightAnswerFieldOfQuestion(){
		return rightAnswerFieldOfQuestion("rightAnswer","");
	}


	public AnswerQuestionForm platformIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  platformIdFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerQuestionForm platformIdFieldOfQuestion(String initValue){
		return platformIdFieldOfQuestion("platformId",initValue);
	}
	public AnswerQuestionForm platformIdFieldOfQuestion(){
		return platformIdFieldOfQuestion("platformId","");
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

 	
 	public AnswerQuestionForm transferToAnotherQuestionAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherQuestion/answerQuestionId/");
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


