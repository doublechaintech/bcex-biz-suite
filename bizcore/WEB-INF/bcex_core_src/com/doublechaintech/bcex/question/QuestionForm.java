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


	public QuestionForm faultAnswerIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  idFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm faultAnswerIdFieldForFaultAnswer(String initValue){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId",initValue);
	}
	public QuestionForm faultAnswerIdFieldForFaultAnswer(){
		return faultAnswerIdFieldForFaultAnswer("faultAnswerId","");
	}


	public QuestionForm topicFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  topicFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm topicFieldForFaultAnswer(String initValue){
		return topicFieldForFaultAnswer("topic",initValue);
	}
	public QuestionForm topicFieldForFaultAnswer(){
		return topicFieldForFaultAnswer("topic","");
	}


	public QuestionForm yourAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  yourAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm yourAnswerFieldForFaultAnswer(String initValue){
		return yourAnswerFieldForFaultAnswer("yourAnswer",initValue);
	}
	public QuestionForm yourAnswerFieldForFaultAnswer(){
		return yourAnswerFieldForFaultAnswer("yourAnswer","");
	}


	public QuestionForm rightAnswerFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  rightAnswerFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm rightAnswerFieldForFaultAnswer(String initValue){
		return rightAnswerFieldForFaultAnswer("rightAnswer",initValue);
	}
	public QuestionForm rightAnswerFieldForFaultAnswer(){
		return rightAnswerFieldForFaultAnswer("rightAnswer","");
	}


	public QuestionForm createTimeFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  createTimeFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm createTimeFieldForFaultAnswer(String initValue){
		return createTimeFieldForFaultAnswer("createTime",initValue);
	}
	public QuestionForm createTimeFieldForFaultAnswer(){
		return createTimeFieldForFaultAnswer("createTime","");
	}


	public QuestionForm userIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  userIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm userIdFieldForFaultAnswer(String initValue){
		return userIdFieldForFaultAnswer("userId",initValue);
	}
	public QuestionForm userIdFieldForFaultAnswer(){
		return userIdFieldForFaultAnswer("userId","");
	}


	public QuestionForm questionIdFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  questionIdFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm questionIdFieldForFaultAnswer(String initValue){
		return questionIdFieldForFaultAnswer("questionId",initValue);
	}
	public QuestionForm questionIdFieldForFaultAnswer(){
		return questionIdFieldForFaultAnswer("questionId","");
	}


	public QuestionForm faultTimesFieldForFaultAnswer(String parameterName, String initValue){
		FormField field =  faultTimesFromFaultAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public QuestionForm faultTimesFieldForFaultAnswer(String initValue){
		return faultTimesFieldForFaultAnswer("faultTimes",initValue);
	}
	public QuestionForm faultTimesFieldForFaultAnswer(){
		return faultTimesFieldForFaultAnswer("faultTimes","");
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


