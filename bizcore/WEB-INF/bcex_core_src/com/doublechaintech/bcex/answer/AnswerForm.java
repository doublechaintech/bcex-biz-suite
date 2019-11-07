package com.doublechaintech.bcex.answer;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class AnswerForm extends BaseForm {
	
	
	public AnswerForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public AnswerForm answerIdField(String parameterName, String initValue){
		FormField field = idFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerForm answerIdField(String initValue){
		return answerIdField("answerId",initValue);
	}
	public AnswerForm answerIdField(){
		return answerIdField("answerId","");
	}


	public AnswerForm titleField(String parameterName, String initValue){
		FormField field = titleFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerForm titleField(String initValue){
		return titleField("title",initValue);
	}
	public AnswerForm titleField(){
		return titleField("title","");
	}


	public AnswerForm commentField(String parameterName, String initValue){
		FormField field = commentFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerForm commentField(String initValue){
		return commentField("comment",initValue);
	}
	public AnswerForm commentField(){
		return commentField("comment","");
	}


	public AnswerForm questionIdField(String parameterName, String initValue){
		FormField field = questionIdFromAnswer(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public AnswerForm questionIdField(String initValue){
		return questionIdField("questionId",initValue);
	}
	public AnswerForm questionIdField(){
		return questionIdField("questionId","");
	}

	
	


	public AnswerForm questionIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  idFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm questionIdFieldOfQuestion(String initValue){
		return questionIdFieldOfQuestion("questionId",initValue);
	}
	public AnswerForm questionIdFieldOfQuestion(){
		return questionIdFieldOfQuestion("questionId","");
	}


	public AnswerForm topicFieldOfQuestion(String parameterName, String initValue){
		FormField field =  topicFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm topicFieldOfQuestion(String initValue){
		return topicFieldOfQuestion("topic",initValue);
	}
	public AnswerForm topicFieldOfQuestion(){
		return topicFieldOfQuestion("topic","");
	}


	public AnswerForm levelFieldOfQuestion(String parameterName, String initValue){
		FormField field =  levelFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm levelFieldOfQuestion(String initValue){
		return levelFieldOfQuestion("level",initValue);
	}
	public AnswerForm levelFieldOfQuestion(){
		return levelFieldOfQuestion("level","");
	}


	public AnswerForm optionAFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionAFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm optionAFieldOfQuestion(String initValue){
		return optionAFieldOfQuestion("optionA",initValue);
	}
	public AnswerForm optionAFieldOfQuestion(){
		return optionAFieldOfQuestion("optionA","");
	}


	public AnswerForm optionBFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionBFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm optionBFieldOfQuestion(String initValue){
		return optionBFieldOfQuestion("optionB",initValue);
	}
	public AnswerForm optionBFieldOfQuestion(){
		return optionBFieldOfQuestion("optionB","");
	}


	public AnswerForm optionCFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionCFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm optionCFieldOfQuestion(String initValue){
		return optionCFieldOfQuestion("optionC",initValue);
	}
	public AnswerForm optionCFieldOfQuestion(){
		return optionCFieldOfQuestion("optionC","");
	}


	public AnswerForm optionDFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionDFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm optionDFieldOfQuestion(String initValue){
		return optionDFieldOfQuestion("optionD",initValue);
	}
	public AnswerForm optionDFieldOfQuestion(){
		return optionDFieldOfQuestion("optionD","");
	}


	public AnswerForm optionEFieldOfQuestion(String parameterName, String initValue){
		FormField field =  optionEFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm optionEFieldOfQuestion(String initValue){
		return optionEFieldOfQuestion("optionE",initValue);
	}
	public AnswerForm optionEFieldOfQuestion(){
		return optionEFieldOfQuestion("optionE","");
	}


	public AnswerForm rightAnswerFieldOfQuestion(String parameterName, String initValue){
		FormField field =  rightAnswerFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm rightAnswerFieldOfQuestion(String initValue){
		return rightAnswerFieldOfQuestion("rightAnswer",initValue);
	}
	public AnswerForm rightAnswerFieldOfQuestion(){
		return rightAnswerFieldOfQuestion("rightAnswer","");
	}


	public AnswerForm platformIdFieldOfQuestion(String parameterName, String initValue){
		FormField field =  platformIdFromQuestion(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public AnswerForm platformIdFieldOfQuestion(String initValue){
		return platformIdFieldOfQuestion("platformId",initValue);
	}
	public AnswerForm platformIdFieldOfQuestion(){
		return platformIdFieldOfQuestion("platformId","");
	}

	


	

	
 	public AnswerForm transferToAnotherQuestionAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherQuestion/answerId/");
		this.addFormAction(action);
		return this;
	}

 

	public AnswerForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


