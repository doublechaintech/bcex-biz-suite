package com.doublechaintech.bcex.platform;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class PlatformForm extends BaseForm {
	
	
	public PlatformForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public PlatformForm platformIdField(String parameterName, String initValue){
		FormField field = idFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public PlatformForm platformIdField(){
		return platformIdField("platformId","");
	}


	public PlatformForm nameField(String parameterName, String initValue){
		FormField field = nameFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public PlatformForm nameField(){
		return nameField("name","");
	}


	public PlatformForm descriptionField(String parameterName, String initValue){
		FormField field = descriptionFromPlatform(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm descriptionField(String initValue){
		return descriptionField("description",initValue);
	}
	public PlatformForm descriptionField(){
		return descriptionField("description","");
	}

	
	

	



	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  idFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(String initValue){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId",initValue);
	}
	public PlatformForm changeRequestTypeIdFieldForChangeRequestType(){
		return changeRequestTypeIdFieldForChangeRequestType("changeRequestTypeId","");
	}


	public PlatformForm nameFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  nameFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForChangeRequestType(String initValue){
		return nameFieldForChangeRequestType("name",initValue);
	}
	public PlatformForm nameFieldForChangeRequestType(){
		return nameFieldForChangeRequestType("name","");
	}


	public PlatformForm codeFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  codeFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm codeFieldForChangeRequestType(String initValue){
		return codeFieldForChangeRequestType("code",initValue);
	}
	public PlatformForm codeFieldForChangeRequestType(){
		return codeFieldForChangeRequestType("code","");
	}


	public PlatformForm iconFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  iconFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm iconFieldForChangeRequestType(String initValue){
		return iconFieldForChangeRequestType("icon",initValue);
	}
	public PlatformForm iconFieldForChangeRequestType(){
		return iconFieldForChangeRequestType("icon","");
	}


	public PlatformForm displayOrderFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  displayOrderFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm displayOrderFieldForChangeRequestType(String initValue){
		return displayOrderFieldForChangeRequestType("displayOrder",initValue);
	}
	public PlatformForm displayOrderFieldForChangeRequestType(){
		return displayOrderFieldForChangeRequestType("displayOrder","");
	}


	public PlatformForm platformIdFieldForChangeRequestType(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequestType(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForChangeRequestType(String initValue){
		return platformIdFieldForChangeRequestType("platformId",initValue);
	}
	public PlatformForm platformIdFieldForChangeRequestType(){
		return platformIdFieldForChangeRequestType("platformId","");
	}


	public PlatformForm changeRequestIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  idFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm changeRequestIdFieldForChangeRequest(String initValue){
		return changeRequestIdFieldForChangeRequest("changeRequestId",initValue);
	}
	public PlatformForm changeRequestIdFieldForChangeRequest(){
		return changeRequestIdFieldForChangeRequest("changeRequestId","");
	}


	public PlatformForm nameFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  nameFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForChangeRequest(String initValue){
		return nameFieldForChangeRequest("name",initValue);
	}
	public PlatformForm nameFieldForChangeRequest(){
		return nameFieldForChangeRequest("name","");
	}


	public PlatformForm createTimeFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  createTimeFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForChangeRequest(String initValue){
		return createTimeFieldForChangeRequest("createTime",initValue);
	}
	public PlatformForm createTimeFieldForChangeRequest(){
		return createTimeFieldForChangeRequest("createTime","");
	}


	public PlatformForm remoteIpFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  remoteIpFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm remoteIpFieldForChangeRequest(String initValue){
		return remoteIpFieldForChangeRequest("remoteIp",initValue);
	}
	public PlatformForm remoteIpFieldForChangeRequest(){
		return remoteIpFieldForChangeRequest("remoteIp","");
	}


	public PlatformForm requestTypeIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  requestTypeIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm requestTypeIdFieldForChangeRequest(String initValue){
		return requestTypeIdFieldForChangeRequest("requestTypeId",initValue);
	}
	public PlatformForm requestTypeIdFieldForChangeRequest(){
		return requestTypeIdFieldForChangeRequest("requestTypeId","");
	}


	public PlatformForm platformIdFieldForChangeRequest(String parameterName, String initValue){
		FormField field =  platformIdFromChangeRequest(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForChangeRequest(String initValue){
		return platformIdFieldForChangeRequest("platformId",initValue);
	}
	public PlatformForm platformIdFieldForChangeRequest(){
		return platformIdFieldForChangeRequest("platformId","");
	}


	public PlatformForm examStatusIdFieldForExamStatus(String parameterName, String initValue){
		FormField field =  idFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm examStatusIdFieldForExamStatus(String initValue){
		return examStatusIdFieldForExamStatus("examStatusId",initValue);
	}
	public PlatformForm examStatusIdFieldForExamStatus(){
		return examStatusIdFieldForExamStatus("examStatusId","");
	}


	public PlatformForm nameFieldForExamStatus(String parameterName, String initValue){
		FormField field =  nameFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForExamStatus(String initValue){
		return nameFieldForExamStatus("name",initValue);
	}
	public PlatformForm nameFieldForExamStatus(){
		return nameFieldForExamStatus("name","");
	}


	public PlatformForm codeFieldForExamStatus(String parameterName, String initValue){
		FormField field =  codeFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm codeFieldForExamStatus(String initValue){
		return codeFieldForExamStatus("code",initValue);
	}
	public PlatformForm codeFieldForExamStatus(){
		return codeFieldForExamStatus("code","");
	}


	public PlatformForm platformIdFieldForExamStatus(String parameterName, String initValue){
		FormField field =  platformIdFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForExamStatus(String initValue){
		return platformIdFieldForExamStatus("platformId",initValue);
	}
	public PlatformForm platformIdFieldForExamStatus(){
		return platformIdFieldForExamStatus("platformId","");
	}


	public PlatformForm questionIdFieldForQuestion(String parameterName, String initValue){
		FormField field =  idFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm questionIdFieldForQuestion(String initValue){
		return questionIdFieldForQuestion("questionId",initValue);
	}
	public PlatformForm questionIdFieldForQuestion(){
		return questionIdFieldForQuestion("questionId","");
	}


	public PlatformForm topicFieldForQuestion(String parameterName, String initValue){
		FormField field =  topicFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm topicFieldForQuestion(String initValue){
		return topicFieldForQuestion("topic",initValue);
	}
	public PlatformForm topicFieldForQuestion(){
		return topicFieldForQuestion("topic","");
	}


	public PlatformForm levelFieldForQuestion(String parameterName, String initValue){
		FormField field =  levelFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm levelFieldForQuestion(String initValue){
		return levelFieldForQuestion("level",initValue);
	}
	public PlatformForm levelFieldForQuestion(){
		return levelFieldForQuestion("level","");
	}


	public PlatformForm optionAFieldForQuestion(String parameterName, String initValue){
		FormField field =  optionAFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm optionAFieldForQuestion(String initValue){
		return optionAFieldForQuestion("optionA",initValue);
	}
	public PlatformForm optionAFieldForQuestion(){
		return optionAFieldForQuestion("optionA","");
	}


	public PlatformForm optionBFieldForQuestion(String parameterName, String initValue){
		FormField field =  optionBFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm optionBFieldForQuestion(String initValue){
		return optionBFieldForQuestion("optionB",initValue);
	}
	public PlatformForm optionBFieldForQuestion(){
		return optionBFieldForQuestion("optionB","");
	}


	public PlatformForm optionCFieldForQuestion(String parameterName, String initValue){
		FormField field =  optionCFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm optionCFieldForQuestion(String initValue){
		return optionCFieldForQuestion("optionC",initValue);
	}
	public PlatformForm optionCFieldForQuestion(){
		return optionCFieldForQuestion("optionC","");
	}


	public PlatformForm optionDFieldForQuestion(String parameterName, String initValue){
		FormField field =  optionDFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm optionDFieldForQuestion(String initValue){
		return optionDFieldForQuestion("optionD",initValue);
	}
	public PlatformForm optionDFieldForQuestion(){
		return optionDFieldForQuestion("optionD","");
	}


	public PlatformForm optionEFieldForQuestion(String parameterName, String initValue){
		FormField field =  optionEFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm optionEFieldForQuestion(String initValue){
		return optionEFieldForQuestion("optionE",initValue);
	}
	public PlatformForm optionEFieldForQuestion(){
		return optionEFieldForQuestion("optionE","");
	}


	public PlatformForm rightAnswerFieldForQuestion(String parameterName, String initValue){
		FormField field =  rightAnswerFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm rightAnswerFieldForQuestion(String initValue){
		return rightAnswerFieldForQuestion("rightAnswer",initValue);
	}
	public PlatformForm rightAnswerFieldForQuestion(){
		return rightAnswerFieldForQuestion("rightAnswer","");
	}


	public PlatformForm platformIdFieldForQuestion(String parameterName, String initValue){
		FormField field =  platformIdFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForQuestion(String initValue){
		return platformIdFieldForQuestion("platformId",initValue);
	}
	public PlatformForm platformIdFieldForQuestion(){
		return platformIdFieldForQuestion("platformId","");
	}


	public PlatformForm examRankingIdFieldForExamRanking(String parameterName, String initValue){
		FormField field =  idFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm examRankingIdFieldForExamRanking(String initValue){
		return examRankingIdFieldForExamRanking("examRankingId",initValue);
	}
	public PlatformForm examRankingIdFieldForExamRanking(){
		return examRankingIdFieldForExamRanking("examRankingId","");
	}


	public PlatformForm nameFieldForExamRanking(String parameterName, String initValue){
		FormField field =  nameFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForExamRanking(String initValue){
		return nameFieldForExamRanking("name",initValue);
	}
	public PlatformForm nameFieldForExamRanking(){
		return nameFieldForExamRanking("name","");
	}


	public PlatformForm avartaFieldForExamRanking(String parameterName, String initValue){
		FormField field =  avartaFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm avartaFieldForExamRanking(String initValue){
		return avartaFieldForExamRanking("avarta",initValue);
	}
	public PlatformForm avartaFieldForExamRanking(){
		return avartaFieldForExamRanking("avarta","");
	}


	public PlatformForm platformIdFieldForExamRanking(String parameterName, String initValue){
		FormField field =  platformIdFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForExamRanking(String initValue){
		return platformIdFieldForExamRanking("platformId",initValue);
	}
	public PlatformForm platformIdFieldForExamRanking(){
		return platformIdFieldForExamRanking("platformId","");
	}


	public PlatformForm wechatUserIdFieldForWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm wechatUserIdFieldForWechatUser(String initValue){
		return wechatUserIdFieldForWechatUser("wechatUserId",initValue);
	}
	public PlatformForm wechatUserIdFieldForWechatUser(){
		return wechatUserIdFieldForWechatUser("wechatUserId","");
	}


	public PlatformForm nameFieldForWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm nameFieldForWechatUser(String initValue){
		return nameFieldForWechatUser("name",initValue);
	}
	public PlatformForm nameFieldForWechatUser(){
		return nameFieldForWechatUser("name","");
	}


	public PlatformForm avartaFieldForWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm avartaFieldForWechatUser(String initValue){
		return avartaFieldForWechatUser("avarta",initValue);
	}
	public PlatformForm avartaFieldForWechatUser(){
		return avartaFieldForWechatUser("avarta","");
	}


	public PlatformForm createTimeFieldForWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm createTimeFieldForWechatUser(String initValue){
		return createTimeFieldForWechatUser("createTime",initValue);
	}
	public PlatformForm createTimeFieldForWechatUser(){
		return createTimeFieldForWechatUser("createTime","");
	}


	public PlatformForm platformIdFieldForWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public PlatformForm platformIdFieldForWechatUser(String initValue){
		return platformIdFieldForWechatUser("platformId",initValue);
	}
	public PlatformForm platformIdFieldForWechatUser(){
		return platformIdFieldForWechatUser("platformId","");
	}

	



	public PlatformForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


