package com.doublechaintech.bcex.question;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class QuestionForm extends BaseForm {
	
	
	public QuestionForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public QuestionForm questionIdField(String parameterName, String initValue){
		FormField field = idFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm questionIdField(String initValue){
		return questionIdField("questionId",initValue);
	}
	public QuestionForm questionIdField(){
		return questionIdField("questionId","");
	}


	public QuestionForm topicField(String parameterName, String initValue){
		FormField field = topicFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm topicField(String initValue){
		return topicField("topic",initValue);
	}
	public QuestionForm topicField(){
		return topicField("topic","");
	}


	public QuestionForm levelField(String parameterName, String initValue){
		FormField field = levelFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm levelField(String initValue){
		return levelField("level",initValue);
	}
	public QuestionForm levelField(){
		return levelField("level","");
	}


	public QuestionForm optionAField(String parameterName, String initValue){
		FormField field = optionAFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm optionAField(String initValue){
		return optionAField("optionA",initValue);
	}
	public QuestionForm optionAField(){
		return optionAField("optionA","");
	}


	public QuestionForm optionBField(String parameterName, String initValue){
		FormField field = optionBFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm optionBField(String initValue){
		return optionBField("optionB",initValue);
	}
	public QuestionForm optionBField(){
		return optionBField("optionB","");
	}


	public QuestionForm optionCField(String parameterName, String initValue){
		FormField field = optionCFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm optionCField(String initValue){
		return optionCField("optionC",initValue);
	}
	public QuestionForm optionCField(){
		return optionCField("optionC","");
	}


	public QuestionForm optionDField(String parameterName, String initValue){
		FormField field = optionDFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm optionDField(String initValue){
		return optionDField("optionD",initValue);
	}
	public QuestionForm optionDField(){
		return optionDField("optionD","");
	}


	public QuestionForm optionEField(String parameterName, String initValue){
		FormField field = optionEFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm optionEField(String initValue){
		return optionEField("optionE",initValue);
	}
	public QuestionForm optionEField(){
		return optionEField("optionE","");
	}


	public QuestionForm rightAnswerField(String parameterName, String initValue){
		FormField field = rightAnswerFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm rightAnswerField(String initValue){
		return rightAnswerField("rightAnswer",initValue);
	}
	public QuestionForm rightAnswerField(){
		return rightAnswerField("rightAnswer","");
	}


	public QuestionForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public QuestionForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public QuestionForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuestionForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public QuestionForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public QuestionForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuestionForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public QuestionForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public QuestionForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public QuestionForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public QuestionForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	



	public QuestionForm answerQuestionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  idFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm answerQuestionIdFieldForAnswerQuestion(String initValue){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId",initValue);
	}
	public QuestionForm answerQuestionIdFieldForAnswerQuestion(){
		return answerQuestionIdFieldForAnswerQuestion("answerQuestionId","");
	}


	public QuestionForm nickNameFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  nickNameFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm nickNameFieldForAnswerQuestion(String initValue){
		return nickNameFieldForAnswerQuestion("nickName",initValue);
	}
	public QuestionForm nickNameFieldForAnswerQuestion(){
		return nickNameFieldForAnswerQuestion("nickName","");
	}


	public QuestionForm userIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  userIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm userIdFieldForAnswerQuestion(String initValue){
		return userIdFieldForAnswerQuestion("userId",initValue);
	}
	public QuestionForm userIdFieldForAnswerQuestion(){
		return userIdFieldForAnswerQuestion("userId","");
	}


	public QuestionForm questionIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  questionIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm questionIdFieldForAnswerQuestion(String initValue){
		return questionIdFieldForAnswerQuestion("questionId",initValue);
	}
	public QuestionForm questionIdFieldForAnswerQuestion(){
		return questionIdFieldForAnswerQuestion("questionId","");
	}


	public QuestionForm answerFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  answerFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm answerFieldForAnswerQuestion(String initValue){
		return answerFieldForAnswerQuestion("answer",initValue);
	}
	public QuestionForm answerFieldForAnswerQuestion(){
		return answerFieldForAnswerQuestion("answer","");
	}


	public QuestionForm changeRequestIdFieldForAnswerQuestion(String parameterName, String initValue){
		FormField field =  changeRequestIdFromAnswerQuestion(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm changeRequestIdFieldForAnswerQuestion(String initValue){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId",initValue);
	}
	public QuestionForm changeRequestIdFieldForAnswerQuestion(){
		return changeRequestIdFieldForAnswerQuestion("changeRequestId","");
	}


	public QuestionForm answerIdFieldForAnswer(String parameterName, String initValue){
		FormField field =  idFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm answerIdFieldForAnswer(String initValue){
		return answerIdFieldForAnswer("answerId",initValue);
	}
	public QuestionForm answerIdFieldForAnswer(){
		return answerIdFieldForAnswer("answerId","");
	}


	public QuestionForm titleFieldForAnswer(String parameterName, String initValue){
		FormField field =  titleFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm titleFieldForAnswer(String initValue){
		return titleFieldForAnswer("title",initValue);
	}
	public QuestionForm titleFieldForAnswer(){
		return titleFieldForAnswer("title","");
	}


	public QuestionForm commentFieldForAnswer(String parameterName, String initValue){
		FormField field =  commentFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm commentFieldForAnswer(String initValue){
		return commentFieldForAnswer("comment",initValue);
	}
	public QuestionForm commentFieldForAnswer(){
		return commentFieldForAnswer("comment","");
	}


	public QuestionForm questionIdFieldForAnswer(String parameterName, String initValue){
		FormField field =  questionIdFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm questionIdFieldForAnswer(String initValue){
		return questionIdFieldForAnswer("questionId",initValue);
	}
	public QuestionForm questionIdFieldForAnswer(){
		return questionIdFieldForAnswer("questionId","");
	}


	public QuestionForm userAnswerIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  idFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm userAnswerIdFieldForUserAnswer(String initValue){
		return userAnswerIdFieldForUserAnswer("userAnswerId",initValue);
	}
	public QuestionForm userAnswerIdFieldForUserAnswer(){
		return userAnswerIdFieldForUserAnswer("userAnswerId","");
	}


	public QuestionForm topicFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  topicFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm topicFieldForUserAnswer(String initValue){
		return topicFieldForUserAnswer("topic",initValue);
	}
	public QuestionForm topicFieldForUserAnswer(){
		return topicFieldForUserAnswer("topic","");
	}


	public QuestionForm userSelectFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  userSelectFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm userSelectFieldForUserAnswer(String initValue){
		return userSelectFieldForUserAnswer("userSelect",initValue);
	}
	public QuestionForm userSelectFieldForUserAnswer(){
		return userSelectFieldForUserAnswer("userSelect","");
	}


	public QuestionForm questionIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  questionIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm questionIdFieldForUserAnswer(String initValue){
		return questionIdFieldForUserAnswer("questionId",initValue);
	}
	public QuestionForm questionIdFieldForUserAnswer(){
		return questionIdFieldForUserAnswer("questionId","");
	}


	public QuestionForm examIdFieldForUserAnswer(String parameterName, String initValue){
		FormField field =  examIdFromUserAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm examIdFieldForUserAnswer(String initValue){
		return examIdFieldForUserAnswer("examId",initValue);
	}
	public QuestionForm examIdFieldForUserAnswer(){
		return examIdFieldForUserAnswer("examId","");
	}

	

	
 	public QuestionForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/questionId/");
		this.addFormAction(action);
		return this;
	}

 

	public QuestionForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


