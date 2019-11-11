package com.doublechaintech.bcex.faultanswer;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class FaultAnswerForm extends BaseForm {
	
	
	public FaultAnswerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public FaultAnswerForm faultAnswerIdField(String parameterName, String initValue){
		FormField field = idFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm faultAnswerIdField(String initValue){
		return faultAnswerIdField("faultAnswerId",initValue);
	}
	public FaultAnswerForm faultAnswerIdField(){
		return faultAnswerIdField("faultAnswerId","");
	}


	public FaultAnswerForm topicField(String parameterName, String initValue){
		FormField field = topicFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm topicField(String initValue){
		return topicField("topic",initValue);
	}
	public FaultAnswerForm topicField(){
		return topicField("topic","");
	}


	public FaultAnswerForm yourAnswerField(String parameterName, String initValue){
		FormField field = yourAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm yourAnswerField(String initValue){
		return yourAnswerField("yourAnswer",initValue);
	}
	public FaultAnswerForm yourAnswerField(){
		return yourAnswerField("yourAnswer","");
	}


	public FaultAnswerForm rightAnswerField(String parameterName, String initValue){
		FormField field = rightAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm rightAnswerField(String initValue){
		return rightAnswerField("rightAnswer",initValue);
	}
	public FaultAnswerForm rightAnswerField(){
		return rightAnswerField("rightAnswer","");
	}


	public FaultAnswerForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public FaultAnswerForm createTimeField(){
		return createTimeField("createTime","");
	}


	public FaultAnswerForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public FaultAnswerForm userIdField(){
		return userIdField("userId","");
	}


	public FaultAnswerForm questionIdField(String parameterName, String initValue){
		FormField field = questionIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm questionIdField(String initValue){
		return questionIdField("questionId",initValue);
	}
	public FaultAnswerForm questionIdField(){
		return questionIdField("questionId","");
	}


	public FaultAnswerForm faultTimesField(String parameterName, String initValue){
		FormField field = faultTimesFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm faultTimesField(String initValue){
		return faultTimesField("faultTimes",initValue);
	}
	public FaultAnswerForm faultTimesField(){
		return faultTimesField("faultTimes","");
	}

	
	


	public FaultAnswerForm wechatUserIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm wechatUserIdFieldOfWechatUser(String initValue){
		return wechatUserIdFieldOfWechatUser("wechatUserId",initValue);
	}
	public FaultAnswerForm wechatUserIdFieldOfWechatUser(){
		return wechatUserIdFieldOfWechatUser("wechatUserId","");
	}


	public FaultAnswerForm nameFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm nameFieldOfWechatUser(String initValue){
		return nameFieldOfWechatUser("name",initValue);
	}
	public FaultAnswerForm nameFieldOfWechatUser(){
		return nameFieldOfWechatUser("name","");
	}


	public FaultAnswerForm avartaFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm avartaFieldOfWechatUser(String initValue){
		return avartaFieldOfWechatUser("avarta",initValue);
	}
	public FaultAnswerForm avartaFieldOfWechatUser(){
		return avartaFieldOfWechatUser("avarta","");
	}


	public FaultAnswerForm createTimeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm createTimeFieldOfWechatUser(String initValue){
		return createTimeFieldOfWechatUser("createTime",initValue);
	}
	public FaultAnswerForm createTimeFieldOfWechatUser(){
		return createTimeFieldOfWechatUser("createTime","");
	}


	public FaultAnswerForm userTypeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  userTypeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm userTypeFieldOfWechatUser(String initValue){
		return userTypeFieldOfWechatUser("userType",initValue);
	}
	public FaultAnswerForm userTypeFieldOfWechatUser(){
		return userTypeFieldOfWechatUser("userType","");
	}


	public FaultAnswerForm platformIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm platformIdFieldOfWechatUser(String initValue){
		return platformIdFieldOfWechatUser("platformId",initValue);
	}
	public FaultAnswerForm platformIdFieldOfWechatUser(){
		return platformIdFieldOfWechatUser("platformId","");
	}


	public FaultAnswerForm questionIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  idFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm questionIdFieldOfQuestion(String initValue){
		return questionIdFieldOfQuestion("questionId",initValue);
	}
	public FaultAnswerForm questionIdFieldOfQuestion(){
		return questionIdFieldOfQuestion("questionId","");
	}


	public FaultAnswerForm topicFieldOfQuestion(String parameterName, String initValue){
		FormField field =  topicFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm topicFieldOfQuestion(String initValue){
		return topicFieldOfQuestion("topic",initValue);
	}
	public FaultAnswerForm topicFieldOfQuestion(){
		return topicFieldOfQuestion("topic","");
	}


	public FaultAnswerForm levelFieldOfQuestion(String parameterName, String initValue){
		FormField field =  levelFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm levelFieldOfQuestion(String initValue){
		return levelFieldOfQuestion("level",initValue);
	}
	public FaultAnswerForm levelFieldOfQuestion(){
		return levelFieldOfQuestion("level","");
	}


	public FaultAnswerForm optionAFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionAFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm optionAFieldOfQuestion(String initValue){
		return optionAFieldOfQuestion("optionA",initValue);
	}
	public FaultAnswerForm optionAFieldOfQuestion(){
		return optionAFieldOfQuestion("optionA","");
	}


	public FaultAnswerForm optionBFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionBFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm optionBFieldOfQuestion(String initValue){
		return optionBFieldOfQuestion("optionB",initValue);
	}
	public FaultAnswerForm optionBFieldOfQuestion(){
		return optionBFieldOfQuestion("optionB","");
	}


	public FaultAnswerForm optionCFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionCFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm optionCFieldOfQuestion(String initValue){
		return optionCFieldOfQuestion("optionC",initValue);
	}
	public FaultAnswerForm optionCFieldOfQuestion(){
		return optionCFieldOfQuestion("optionC","");
	}


	public FaultAnswerForm optionDFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionDFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm optionDFieldOfQuestion(String initValue){
		return optionDFieldOfQuestion("optionD",initValue);
	}
	public FaultAnswerForm optionDFieldOfQuestion(){
		return optionDFieldOfQuestion("optionD","");
	}


	public FaultAnswerForm optionEFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionEFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm optionEFieldOfQuestion(String initValue){
		return optionEFieldOfQuestion("optionE",initValue);
	}
	public FaultAnswerForm optionEFieldOfQuestion(){
		return optionEFieldOfQuestion("optionE","");
	}


	public FaultAnswerForm rightAnswerFieldOfQuestion(String parameterName, String initValue){
		FormField field =  rightAnswerFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm rightAnswerFieldOfQuestion(String initValue){
		return rightAnswerFieldOfQuestion("rightAnswer",initValue);
	}
	public FaultAnswerForm rightAnswerFieldOfQuestion(){
		return rightAnswerFieldOfQuestion("rightAnswer","");
	}


	public FaultAnswerForm platformIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  platformIdFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm platformIdFieldOfQuestion(String initValue){
		return platformIdFieldOfQuestion("platformId",initValue);
	}
	public FaultAnswerForm platformIdFieldOfQuestion(){
		return platformIdFieldOfQuestion("platformId","");
	}

	


	

	
 	public FaultAnswerForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/faultAnswerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public FaultAnswerForm transferToAnotherQuestionAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherQuestion/faultAnswerId/");
		this.addFormAction(action);
		return this;
	}

 

	public FaultAnswerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


