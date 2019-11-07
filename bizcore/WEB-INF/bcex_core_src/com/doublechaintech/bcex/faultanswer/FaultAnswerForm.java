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


	public FaultAnswerForm examIdField(String parameterName, String initValue){
		FormField field = examIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public FaultAnswerForm examIdField(String initValue){
		return examIdField("examId",initValue);
	}
	public FaultAnswerForm examIdField(){
		return examIdField("examId","");
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


	public FaultAnswerForm examIdFieldOfExam(String parameterName, String initValue){
		FormField field =  idFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm examIdFieldOfExam(String initValue){
		return examIdFieldOfExam("examId",initValue);
	}
	public FaultAnswerForm examIdFieldOfExam(){
		return examIdFieldOfExam("examId","");
	}


	public FaultAnswerForm nameFieldOfExam(String parameterName, String initValue){
		FormField field =  nameFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm nameFieldOfExam(String initValue){
		return nameFieldOfExam("name",initValue);
	}
	public FaultAnswerForm nameFieldOfExam(){
		return nameFieldOfExam("name","");
	}


	public FaultAnswerForm createTimeFieldOfExam(String parameterName, String initValue){
		FormField field =  createTimeFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm createTimeFieldOfExam(String initValue){
		return createTimeFieldOfExam("createTime",initValue);
	}
	public FaultAnswerForm createTimeFieldOfExam(){
		return createTimeFieldOfExam("createTime","");
	}


	public FaultAnswerForm statusIdFieldOfExam(String parameterName, String initValue){
		FormField field =  statusIdFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm statusIdFieldOfExam(String initValue){
		return statusIdFieldOfExam("statusId",initValue);
	}
	public FaultAnswerForm statusIdFieldOfExam(){
		return statusIdFieldOfExam("statusId","");
	}


	public FaultAnswerForm userIdFieldOfExam(String parameterName, String initValue){
		FormField field =  userIdFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm userIdFieldOfExam(String initValue){
		return userIdFieldOfExam("userId",initValue);
	}
	public FaultAnswerForm userIdFieldOfExam(){
		return userIdFieldOfExam("userId","");
	}


	public FaultAnswerForm scoreFieldOfExam(String parameterName, String initValue){
		FormField field =  scoreFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public FaultAnswerForm scoreFieldOfExam(String initValue){
		return scoreFieldOfExam("score",initValue);
	}
	public FaultAnswerForm scoreFieldOfExam(){
		return scoreFieldOfExam("score","");
	}

	


	

	
 	public FaultAnswerForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/faultAnswerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public FaultAnswerForm transferToAnotherExamAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherExam/faultAnswerId/");
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


