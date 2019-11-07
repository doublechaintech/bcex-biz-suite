package com.doublechaintech.bcex.exam;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class ExamForm extends BaseForm {
	
	
	public ExamForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ExamForm examIdField(String parameterName, String initValue){
		FormField field = idFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm examIdField(String initValue){
		return examIdField("examId",initValue);
	}
	public ExamForm examIdField(){
		return examIdField("examId","");
	}


	public ExamForm nameField(String parameterName, String initValue){
		FormField field = nameFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ExamForm nameField(){
		return nameField("name","");
	}


	public ExamForm createTimeField(String parameterName, String initValue){
		FormField field = createTimeFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm createTimeField(String initValue){
		return createTimeField("createTime",initValue);
	}
	public ExamForm createTimeField(){
		return createTimeField("createTime","");
	}


	public ExamForm statusIdField(String parameterName, String initValue){
		FormField field = statusIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm statusIdField(String initValue){
		return statusIdField("statusId",initValue);
	}
	public ExamForm statusIdField(){
		return statusIdField("statusId","");
	}


	public ExamForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public ExamForm userIdField(){
		return userIdField("userId","");
	}


	public ExamForm scoreField(String parameterName, String initValue){
		FormField field = scoreFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm scoreField(String initValue){
		return scoreField("score",initValue);
	}
	public ExamForm scoreField(){
		return scoreField("score","");
	}

	
	


	public ExamForm examStatusIdFieldOfExamStatus(String parameterName, String initValue){
		FormField field =  idFromExamStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm examStatusIdFieldOfExamStatus(String initValue){
		return examStatusIdFieldOfExamStatus("examStatusId",initValue);
	}
	public ExamForm examStatusIdFieldOfExamStatus(){
		return examStatusIdFieldOfExamStatus("examStatusId","");
	}


	public ExamForm nameFieldOfExamStatus(String parameterName, String initValue){
		FormField field =  nameFromExamStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm nameFieldOfExamStatus(String initValue){
		return nameFieldOfExamStatus("name",initValue);
	}
	public ExamForm nameFieldOfExamStatus(){
		return nameFieldOfExamStatus("name","");
	}


	public ExamForm codeFieldOfExamStatus(String parameterName, String initValue){
		FormField field =  codeFromExamStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm codeFieldOfExamStatus(String initValue){
		return codeFieldOfExamStatus("code",initValue);
	}
	public ExamForm codeFieldOfExamStatus(){
		return codeFieldOfExamStatus("code","");
	}


	public ExamForm platformIdFieldOfExamStatus(String parameterName, String initValue){
		FormField field =  platformIdFromExamStatus(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm platformIdFieldOfExamStatus(String initValue){
		return platformIdFieldOfExamStatus("platformId",initValue);
	}
	public ExamForm platformIdFieldOfExamStatus(){
		return platformIdFieldOfExamStatus("platformId","");
	}


	public ExamForm wechatUserIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm wechatUserIdFieldOfWechatUser(String initValue){
		return wechatUserIdFieldOfWechatUser("wechatUserId",initValue);
	}
	public ExamForm wechatUserIdFieldOfWechatUser(){
		return wechatUserIdFieldOfWechatUser("wechatUserId","");
	}


	public ExamForm nameFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm nameFieldOfWechatUser(String initValue){
		return nameFieldOfWechatUser("name",initValue);
	}
	public ExamForm nameFieldOfWechatUser(){
		return nameFieldOfWechatUser("name","");
	}


	public ExamForm avartaFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm avartaFieldOfWechatUser(String initValue){
		return avartaFieldOfWechatUser("avarta",initValue);
	}
	public ExamForm avartaFieldOfWechatUser(){
		return avartaFieldOfWechatUser("avarta","");
	}


	public ExamForm createTimeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm createTimeFieldOfWechatUser(String initValue){
		return createTimeFieldOfWechatUser("createTime",initValue);
	}
	public ExamForm createTimeFieldOfWechatUser(){
		return createTimeFieldOfWechatUser("createTime","");
	}


	public ExamForm platformIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamForm platformIdFieldOfWechatUser(String initValue){
		return platformIdFieldOfWechatUser("platformId",initValue);
	}
	public ExamForm platformIdFieldOfWechatUser(){
		return platformIdFieldOfWechatUser("platformId","");
	}

	



	public ExamForm userAnswerIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  idFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm userAnswerIdFieldForUserAnswer(String initValue){
		return userAnswerIdFieldForUserAnswer("userAnswerId",initValue);
	}
	public ExamForm userAnswerIdFieldForUserAnswer(){
		return userAnswerIdFieldForUserAnswer("userAnswerId","");
	}


	public ExamForm topicFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  topicFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm topicFieldForUserAnswer(String initValue){
		return topicFieldForUserAnswer("topic",initValue);
	}
	public ExamForm topicFieldForUserAnswer(){
		return topicFieldForUserAnswer("topic","");
	}


	public ExamForm userSelectFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  userSelectFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm userSelectFieldForUserAnswer(String initValue){
		return userSelectFieldForUserAnswer("userSelect",initValue);
	}
	public ExamForm userSelectFieldForUserAnswer(){
		return userSelectFieldForUserAnswer("userSelect","");
	}


	public ExamForm questionIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  questionIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm questionIdFieldForUserAnswer(String initValue){
		return questionIdFieldForUserAnswer("questionId",initValue);
	}
	public ExamForm questionIdFieldForUserAnswer(){
		return questionIdFieldForUserAnswer("questionId","");
	}


	public ExamForm examIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  examIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm examIdFieldForUserAnswer(String initValue){
		return examIdFieldForUserAnswer("examId",initValue);
	}
	public ExamForm examIdFieldForUserAnswer(){
		return examIdFieldForUserAnswer("examId","");
	}


	public ExamForm faultAnswerIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  idFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm faultAnswerIdFieldForFaultAnswer(String initValue){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId",initValue);
	}
	public ExamForm faultAnswerIdFieldForFaultAnswer(){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId","");
	}


	public ExamForm topicFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  topicFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm topicFieldForFaultAnswer(String initValue){
		return topicFieldForFaultAnswer("topic",initValue);
	}
	public ExamForm topicFieldForFaultAnswer(){
		return topicFieldForFaultAnswer("topic","");
	}


	public ExamForm yourAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  yourAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm yourAnswerFieldForFaultAnswer(String initValue){
		return yourAnswerFieldForFaultAnswer("yourAnswer",initValue);
	}
	public ExamForm yourAnswerFieldForFaultAnswer(){
		return yourAnswerFieldForFaultAnswer("yourAnswer","");
	}


	public ExamForm rightAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  rightAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm rightAnswerFieldForFaultAnswer(String initValue){
		return rightAnswerFieldForFaultAnswer("rightAnswer",initValue);
	}
	public ExamForm rightAnswerFieldForFaultAnswer(){
		return rightAnswerFieldForFaultAnswer("rightAnswer","");
	}


	public ExamForm createTimeFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  createTimeFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm createTimeFieldForFaultAnswer(String initValue){
		return createTimeFieldForFaultAnswer("createTime",initValue);
	}
	public ExamForm createTimeFieldForFaultAnswer(){
		return createTimeFieldForFaultAnswer("createTime","");
	}


	public ExamForm userIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  userIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm userIdFieldForFaultAnswer(String initValue){
		return userIdFieldForFaultAnswer("userId",initValue);
	}
	public ExamForm userIdFieldForFaultAnswer(){
		return userIdFieldForFaultAnswer("userId","");
	}


	public ExamForm examIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  examIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamForm examIdFieldForFaultAnswer(String initValue){
		return examIdFieldForFaultAnswer("examId",initValue);
	}
	public ExamForm examIdFieldForFaultAnswer(){
		return examIdFieldForFaultAnswer("examId","");
	}

	

	
 	public ExamForm transferToAnotherStatusAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherStatus/examId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public ExamForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/examId/");
		this.addFormAction(action);
		return this;
	}

 

	public ExamForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


