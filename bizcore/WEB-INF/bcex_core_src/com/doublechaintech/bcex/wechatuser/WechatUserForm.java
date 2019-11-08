package com.doublechaintech.bcex.wechatuser;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class WechatUserForm extends BaseForm {
	
	
	public WechatUserForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public WechatUserForm wechatUserIdField(String parameterName, String initValue){
		FormField field = idFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm wechatUserIdField(String initValue){
		return wechatUserIdField("wechatUserId",initValue);
	}
	public WechatUserForm wechatUserIdField(){
		return wechatUserIdField("wechatUserId","");
	}


	public WechatUserForm nameField(String parameterName, String initValue){
		FormField field = nameFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public WechatUserForm nameField(){
		return nameField("name","");
	}


	public WechatUserForm avartaField(String parameterName, String initValue){
		FormField field = avartaFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm avartaField(String initValue){
		return avartaField("avarta",initValue);
	}
	public WechatUserForm avartaField(){
		return avartaField("avarta","");
	}


	public WechatUserForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public WechatUserForm createTimeField(){
		return createTimeField("createTime","");
	}


	public WechatUserForm userTypeField(String parameterName, String initValue){
		FormField field = userTypeFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userTypeField(String initValue){
		return userTypeField("userType",initValue);
	}
	public WechatUserForm userTypeField(){
		return userTypeField("userType","");
	}


	public WechatUserForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public WechatUserForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public WechatUserForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatUserForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public WechatUserForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public WechatUserForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatUserForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public WechatUserForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public WechatUserForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatUserForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public WechatUserForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	



	public WechatUserForm startExamIdFieldForStartExam(String parameterName, String initValue){
		FormField field =  idFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm startExamIdFieldForStartExam(String initValue){
		return startExamIdFieldForStartExam("startExamId",initValue);
	}
	public WechatUserForm startExamIdFieldForStartExam(){
		return startExamIdFieldForStartExam("startExamId","");
	}


	public WechatUserForm nickNameFieldForStartExam(String parameterName, String initValue){
		FormField field =  nickNameFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm nickNameFieldForStartExam(String initValue){
		return nickNameFieldForStartExam("nickName",initValue);
	}
	public WechatUserForm nickNameFieldForStartExam(){
		return nickNameFieldForStartExam("nickName","");
	}


	public WechatUserForm userIdFieldForStartExam(String parameterName, String initValue){
		FormField field =  userIdFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userIdFieldForStartExam(String initValue){
		return userIdFieldForStartExam("userId",initValue);
	}
	public WechatUserForm userIdFieldForStartExam(){
		return userIdFieldForStartExam("userId","");
	}


	public WechatUserForm changeRequestIdFieldForStartExam(String parameterName, String initValue){
		FormField field =  changeRequestIdFromStartExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm changeRequestIdFieldForStartExam(String initValue){
		return changeRequestIdFieldForStartExam("changeRequestId",initValue);
	}
	public WechatUserForm changeRequestIdFieldForStartExam(){
		return changeRequestIdFieldForStartExam("changeRequestId","");
	}


	public WechatUserForm answerQuestionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  idFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm answerQuestionIdFieldForAnswerQuestion(String initValue){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId",initValue);
	}
	public WechatUserForm answerQuestionIdFieldForAnswerQuestion(){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId","");
	}


	public WechatUserForm nickNameFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  nickNameFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm nickNameFieldForAnswerQuestion(String initValue){
		return nickNameFieldForAnswerQuestion("nickName",initValue);
	}
	public WechatUserForm nickNameFieldForAnswerQuestion(){
		return nickNameFieldForAnswerQuestion("nickName","");
	}


	public WechatUserForm userIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userIdFieldForAnswerQuestion(String initValue){
		return userIdFieldForAnswerQuestion("userId",initValue);
	}
	public WechatUserForm userIdFieldForAnswerQuestion(){
		return userIdFieldForAnswerQuestion("userId","");
	}


	public WechatUserForm userAnswerIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userAnswerIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userAnswerIdFieldForAnswerQuestion(String initValue){
		return userAnswerIdFieldForAnswerQuestion("userAnswerId",initValue);
	}
	public WechatUserForm userAnswerIdFieldForAnswerQuestion(){
		return userAnswerIdFieldForAnswerQuestion("userAnswerId","");
	}


	public WechatUserForm answerFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  answerFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm answerFieldForAnswerQuestion(String initValue){
		return answerFieldForAnswerQuestion("answer",initValue);
	}
	public WechatUserForm answerFieldForAnswerQuestion(){
		return answerFieldForAnswerQuestion("answer","");
	}


	public WechatUserForm changeRequestIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  changeRequestIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm changeRequestIdFieldForAnswerQuestion(String initValue){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId",initValue);
	}
	public WechatUserForm changeRequestIdFieldForAnswerQuestion(){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId","");
	}


	public WechatUserForm wechatLoginInfoIdFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  idFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm wechatLoginInfoIdFieldForWechatLoginInfo(String initValue){
		return wechatLoginInfoIdFieldForWechatLoginInfo("wechatLoginInfoId",initValue);
	}
	public WechatUserForm wechatLoginInfoIdFieldForWechatLoginInfo(){
		return wechatLoginInfoIdFieldForWechatLoginInfo("wechatLoginInfoId","");
	}


	public WechatUserForm wechatUserIdFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  wechatUserIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm wechatUserIdFieldForWechatLoginInfo(String initValue){
		return wechatUserIdFieldForWechatLoginInfo("wechatUserId",initValue);
	}
	public WechatUserForm wechatUserIdFieldForWechatLoginInfo(){
		return wechatUserIdFieldForWechatLoginInfo("wechatUserId","");
	}


	public WechatUserForm appIdFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  appIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm appIdFieldForWechatLoginInfo(String initValue){
		return appIdFieldForWechatLoginInfo("appId",initValue);
	}
	public WechatUserForm appIdFieldForWechatLoginInfo(){
		return appIdFieldForWechatLoginInfo("appId","");
	}


	public WechatUserForm openIdFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  openIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm openIdFieldForWechatLoginInfo(String initValue){
		return openIdFieldForWechatLoginInfo("openId",initValue);
	}
	public WechatUserForm openIdFieldForWechatLoginInfo(){
		return openIdFieldForWechatLoginInfo("openId","");
	}


	public WechatUserForm sessionKeyFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  sessionKeyFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm sessionKeyFieldForWechatLoginInfo(String initValue){
		return sessionKeyFieldForWechatLoginInfo("sessionKey",initValue);
	}
	public WechatUserForm sessionKeyFieldForWechatLoginInfo(){
		return sessionKeyFieldForWechatLoginInfo("sessionKey","");
	}


	public WechatUserForm lastUpdateTimeFieldForWechatLoginInfo(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm lastUpdateTimeFieldForWechatLoginInfo(String initValue){
		return lastUpdateTimeFieldForWechatLoginInfo("lastUpdateTime",initValue);
	}
	public WechatUserForm lastUpdateTimeFieldForWechatLoginInfo(){
		return lastUpdateTimeFieldForWechatLoginInfo("lastUpdateTime","");
	}


	public WechatUserForm examIdFieldForExam(String parameterName, String initValue){
		FormField field =  idFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm examIdFieldForExam(String initValue){
		return examIdFieldForExam("examId",initValue);
	}
	public WechatUserForm examIdFieldForExam(){
		return examIdFieldForExam("examId","");
	}


	public WechatUserForm nameFieldForExam(String parameterName, String initValue){
		FormField field =  nameFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm nameFieldForExam(String initValue){
		return nameFieldForExam("name",initValue);
	}
	public WechatUserForm nameFieldForExam(){
		return nameFieldForExam("name","");
	}


	public WechatUserForm createTimeFieldForExam(String parameterName, String initValue){
		FormField field =  createTimeFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm createTimeFieldForExam(String initValue){
		return createTimeFieldForExam("createTime",initValue);
	}
	public WechatUserForm createTimeFieldForExam(){
		return createTimeFieldForExam("createTime","");
	}


	public WechatUserForm statusIdFieldForExam(String parameterName, String initValue){
		FormField field =  statusIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm statusIdFieldForExam(String initValue){
		return statusIdFieldForExam("statusId",initValue);
	}
	public WechatUserForm statusIdFieldForExam(){
		return statusIdFieldForExam("statusId","");
	}


	public WechatUserForm userIdFieldForExam(String parameterName, String initValue){
		FormField field =  userIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userIdFieldForExam(String initValue){
		return userIdFieldForExam("userId",initValue);
	}
	public WechatUserForm userIdFieldForExam(){
		return userIdFieldForExam("userId","");
	}


	public WechatUserForm scoreFieldForExam(String parameterName, String initValue){
		FormField field =  scoreFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm scoreFieldForExam(String initValue){
		return scoreFieldForExam("score",initValue);
	}
	public WechatUserForm scoreFieldForExam(){
		return scoreFieldForExam("score","");
	}


	public WechatUserForm faultAnswerIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  idFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm faultAnswerIdFieldForFaultAnswer(String initValue){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId",initValue);
	}
	public WechatUserForm faultAnswerIdFieldForFaultAnswer(){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId","");
	}


	public WechatUserForm topicFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  topicFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm topicFieldForFaultAnswer(String initValue){
		return topicFieldForFaultAnswer("topic",initValue);
	}
	public WechatUserForm topicFieldForFaultAnswer(){
		return topicFieldForFaultAnswer("topic","");
	}


	public WechatUserForm yourAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  yourAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm yourAnswerFieldForFaultAnswer(String initValue){
		return yourAnswerFieldForFaultAnswer("yourAnswer",initValue);
	}
	public WechatUserForm yourAnswerFieldForFaultAnswer(){
		return yourAnswerFieldForFaultAnswer("yourAnswer","");
	}


	public WechatUserForm rightAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  rightAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm rightAnswerFieldForFaultAnswer(String initValue){
		return rightAnswerFieldForFaultAnswer("rightAnswer",initValue);
	}
	public WechatUserForm rightAnswerFieldForFaultAnswer(){
		return rightAnswerFieldForFaultAnswer("rightAnswer","");
	}


	public WechatUserForm createTimeFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  createTimeFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm createTimeFieldForFaultAnswer(String initValue){
		return createTimeFieldForFaultAnswer("createTime",initValue);
	}
	public WechatUserForm createTimeFieldForFaultAnswer(){
		return createTimeFieldForFaultAnswer("createTime","");
	}


	public WechatUserForm userIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  userIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm userIdFieldForFaultAnswer(String initValue){
		return userIdFieldForFaultAnswer("userId",initValue);
	}
	public WechatUserForm userIdFieldForFaultAnswer(){
		return userIdFieldForFaultAnswer("userId","");
	}


	public WechatUserForm examIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  examIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatUserForm examIdFieldForFaultAnswer(String initValue){
		return examIdFieldForFaultAnswer("examId",initValue);
	}
	public WechatUserForm examIdFieldForFaultAnswer(){
		return examIdFieldForFaultAnswer("examId","");
	}

	

	
 	public WechatUserForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/wechatUserId/");
		this.addFormAction(action);
		return this;
	}

 

	public WechatUserForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


