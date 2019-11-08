package com.doublechaintech.bcex.useranswer;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class UserAnswerForm extends BaseForm {
	
	
	public UserAnswerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public UserAnswerForm userAnswerIdField(String parameterName, String initValue){
		FormField field = idFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm userAnswerIdField(String initValue){
		return userAnswerIdField("userAnswerId",initValue);
	}
	public UserAnswerForm userAnswerIdField(){
		return userAnswerIdField("userAnswerId","");
	}


	public UserAnswerForm topicField(String parameterName, String initValue){
		FormField field = topicFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm topicField(String initValue){
		return topicField("topic",initValue);
	}
	public UserAnswerForm topicField(){
		return topicField("topic","");
	}


	public UserAnswerForm userSelectField(String parameterName, String initValue){
		FormField field = userSelectFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm userSelectField(String initValue){
		return userSelectField("userSelect",initValue);
	}
	public UserAnswerForm userSelectField(){
		return userSelectField("userSelect","");
	}


	public UserAnswerForm questionIdField(String parameterName, String initValue){
		FormField field = questionIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm questionIdField(String initValue){
		return questionIdField("questionId",initValue);
	}
	public UserAnswerForm questionIdField(){
		return questionIdField("questionId","");
	}


	public UserAnswerForm examIdField(String parameterName, String initValue){
		FormField field = examIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm examIdField(String initValue){
		return examIdField("examId",initValue);
	}
	public UserAnswerForm examIdField(){
		return examIdField("examId","");
	}

	
	


	public UserAnswerForm questionIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  idFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm questionIdFieldOfQuestion(String initValue){
		return questionIdFieldOfQuestion("questionId",initValue);
	}
	public UserAnswerForm questionIdFieldOfQuestion(){
		return questionIdFieldOfQuestion("questionId","");
	}


	public UserAnswerForm topicFieldOfQuestion(String parameterName, String initValue){
		FormField field =  topicFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm topicFieldOfQuestion(String initValue){
		return topicFieldOfQuestion("topic",initValue);
	}
	public UserAnswerForm topicFieldOfQuestion(){
		return topicFieldOfQuestion("topic","");
	}


	public UserAnswerForm levelFieldOfQuestion(String parameterName, String initValue){
		FormField field =  levelFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm levelFieldOfQuestion(String initValue){
		return levelFieldOfQuestion("level",initValue);
	}
	public UserAnswerForm levelFieldOfQuestion(){
		return levelFieldOfQuestion("level","");
	}


	public UserAnswerForm optionAFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionAFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm optionAFieldOfQuestion(String initValue){
		return optionAFieldOfQuestion("optionA",initValue);
	}
	public UserAnswerForm optionAFieldOfQuestion(){
		return optionAFieldOfQuestion("optionA","");
	}


	public UserAnswerForm optionBFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionBFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm optionBFieldOfQuestion(String initValue){
		return optionBFieldOfQuestion("optionB",initValue);
	}
	public UserAnswerForm optionBFieldOfQuestion(){
		return optionBFieldOfQuestion("optionB","");
	}


	public UserAnswerForm optionCFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionCFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm optionCFieldOfQuestion(String initValue){
		return optionCFieldOfQuestion("optionC",initValue);
	}
	public UserAnswerForm optionCFieldOfQuestion(){
		return optionCFieldOfQuestion("optionC","");
	}


	public UserAnswerForm optionDFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionDFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm optionDFieldOfQuestion(String initValue){
		return optionDFieldOfQuestion("optionD",initValue);
	}
	public UserAnswerForm optionDFieldOfQuestion(){
		return optionDFieldOfQuestion("optionD","");
	}


	public UserAnswerForm optionEFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionEFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm optionEFieldOfQuestion(String initValue){
		return optionEFieldOfQuestion("optionE",initValue);
	}
	public UserAnswerForm optionEFieldOfQuestion(){
		return optionEFieldOfQuestion("optionE","");
	}


	public UserAnswerForm rightAnswerFieldOfQuestion(String parameterName, String initValue){
		FormField field =  rightAnswerFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm rightAnswerFieldOfQuestion(String initValue){
		return rightAnswerFieldOfQuestion("rightAnswer",initValue);
	}
	public UserAnswerForm rightAnswerFieldOfQuestion(){
		return rightAnswerFieldOfQuestion("rightAnswer","");
	}


	public UserAnswerForm platformIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  platformIdFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm platformIdFieldOfQuestion(String initValue){
		return platformIdFieldOfQuestion("platformId",initValue);
	}
	public UserAnswerForm platformIdFieldOfQuestion(){
		return platformIdFieldOfQuestion("platformId","");
	}


	public UserAnswerForm examIdFieldOfExam(String parameterName, String initValue){
		FormField field =  idFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm examIdFieldOfExam(String initValue){
		return examIdFieldOfExam("examId",initValue);
	}
	public UserAnswerForm examIdFieldOfExam(){
		return examIdFieldOfExam("examId","");
	}


	public UserAnswerForm nameFieldOfExam(String parameterName, String initValue){
		FormField field =  nameFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm nameFieldOfExam(String initValue){
		return nameFieldOfExam("name",initValue);
	}
	public UserAnswerForm nameFieldOfExam(){
		return nameFieldOfExam("name","");
	}


	public UserAnswerForm createTimeFieldOfExam(String parameterName, String initValue){
		FormField field =  createTimeFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm createTimeFieldOfExam(String initValue){
		return createTimeFieldOfExam("createTime",initValue);
	}
	public UserAnswerForm createTimeFieldOfExam(){
		return createTimeFieldOfExam("createTime","");
	}


	public UserAnswerForm statusIdFieldOfExam(String parameterName, String initValue){
		FormField field =  statusIdFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm statusIdFieldOfExam(String initValue){
		return statusIdFieldOfExam("statusId",initValue);
	}
	public UserAnswerForm statusIdFieldOfExam(){
		return statusIdFieldOfExam("statusId","");
	}


	public UserAnswerForm userIdFieldOfExam(String parameterName, String initValue){
		FormField field =  userIdFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm userIdFieldOfExam(String initValue){
		return userIdFieldOfExam("userId",initValue);
	}
	public UserAnswerForm userIdFieldOfExam(){
		return userIdFieldOfExam("userId","");
	}


	public UserAnswerForm scoreFieldOfExam(String parameterName, String initValue){
		FormField field =  scoreFromExam(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public UserAnswerForm scoreFieldOfExam(String initValue){
		return scoreFieldOfExam("score",initValue);
	}
	public UserAnswerForm scoreFieldOfExam(){
		return scoreFieldOfExam("score","");
	}

	



	public UserAnswerForm answerQuestionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  idFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm answerQuestionIdFieldForAnswerQuestion(String initValue){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId",initValue);
	}
	public UserAnswerForm answerQuestionIdFieldForAnswerQuestion(){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId","");
	}


	public UserAnswerForm nickNameFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  nickNameFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm nickNameFieldForAnswerQuestion(String initValue){
		return nickNameFieldForAnswerQuestion("nickName",initValue);
	}
	public UserAnswerForm nickNameFieldForAnswerQuestion(){
		return nickNameFieldForAnswerQuestion("nickName","");
	}


	public UserAnswerForm userIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm userIdFieldForAnswerQuestion(String initValue){
		return userIdFieldForAnswerQuestion("userId",initValue);
	}
	public UserAnswerForm userIdFieldForAnswerQuestion(){
		return userIdFieldForAnswerQuestion("userId","");
	}


	public UserAnswerForm userAnswerIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userAnswerIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm userAnswerIdFieldForAnswerQuestion(String initValue){
		return userAnswerIdFieldForAnswerQuestion("userAnswerId",initValue);
	}
	public UserAnswerForm userAnswerIdFieldForAnswerQuestion(){
		return userAnswerIdFieldForAnswerQuestion("userAnswerId","");
	}


	public UserAnswerForm answerFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  answerFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm answerFieldForAnswerQuestion(String initValue){
		return answerFieldForAnswerQuestion("answer",initValue);
	}
	public UserAnswerForm answerFieldForAnswerQuestion(){
		return answerFieldForAnswerQuestion("answer","");
	}


	public UserAnswerForm changeRequestIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  changeRequestIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public UserAnswerForm changeRequestIdFieldForAnswerQuestion(String initValue){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId",initValue);
	}
	public UserAnswerForm changeRequestIdFieldForAnswerQuestion(){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId","");
	}

	

	
 	public UserAnswerForm transferToAnotherQuestionAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherQuestion/userAnswerId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public UserAnswerForm transferToAnotherExamAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherExam/userAnswerId/");
		this.addFormAction(action);
		return this;
	}

 

	public UserAnswerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


