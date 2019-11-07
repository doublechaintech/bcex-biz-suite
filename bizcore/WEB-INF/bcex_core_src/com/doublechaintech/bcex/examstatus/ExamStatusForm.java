package com.doublechaintech.bcex.examstatus;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class ExamStatusForm extends BaseForm {
	
	
	public ExamStatusForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ExamStatusForm examStatusIdField(String parameterName, String initValue){
		FormField field = idFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm examStatusIdField(String initValue){
		return examStatusIdField("examStatusId",initValue);
	}
	public ExamStatusForm examStatusIdField(){
		return examStatusIdField("examStatusId","");
	}


	public ExamStatusForm nameField(String parameterName, String initValue){
		FormField field = nameFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ExamStatusForm nameField(){
		return nameField("name","");
	}


	public ExamStatusForm codeField(String parameterName, String initValue){
		FormField field = codeFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm codeField(String initValue){
		return codeField("code",initValue);
	}
	public ExamStatusForm codeField(){
		return codeField("code","");
	}


	public ExamStatusForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromExamStatus(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ExamStatusForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ExamStatusForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamStatusForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ExamStatusForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ExamStatusForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamStatusForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ExamStatusForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ExamStatusForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamStatusForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public ExamStatusForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	



	public ExamStatusForm examIdFieldForExam(String parameterName, String initValue){
		FormField field =  idFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm examIdFieldForExam(String initValue){
		return examIdFieldForExam("examId",initValue);
	}
	public ExamStatusForm examIdFieldForExam(){
		return examIdFieldForExam("examId","");
	}


	public ExamStatusForm nameFieldForExam(String parameterName, String initValue){
		FormField field =  nameFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm nameFieldForExam(String initValue){
		return nameFieldForExam("name",initValue);
	}
	public ExamStatusForm nameFieldForExam(){
		return nameFieldForExam("name","");
	}


	public ExamStatusForm createTimeFieldForExam(String parameterName, String initValue){
		FormField field =  createTimeFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm createTimeFieldForExam(String initValue){
		return createTimeFieldForExam("createTime",initValue);
	}
	public ExamStatusForm createTimeFieldForExam(){
		return createTimeFieldForExam("createTime","");
	}


	public ExamStatusForm statusIdFieldForExam(String parameterName, String initValue){
		FormField field =  statusIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm statusIdFieldForExam(String initValue){
		return statusIdFieldForExam("statusId",initValue);
	}
	public ExamStatusForm statusIdFieldForExam(){
		return statusIdFieldForExam("statusId","");
	}


	public ExamStatusForm userIdFieldForExam(String parameterName, String initValue){
		FormField field =  userIdFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm userIdFieldForExam(String initValue){
		return userIdFieldForExam("userId",initValue);
	}
	public ExamStatusForm userIdFieldForExam(){
		return userIdFieldForExam("userId","");
	}


	public ExamStatusForm scoreFieldForExam(String parameterName, String initValue){
		FormField field =  scoreFromExam(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamStatusForm scoreFieldForExam(String initValue){
		return scoreFieldForExam("score",initValue);
	}
	public ExamStatusForm scoreFieldForExam(){
		return scoreFieldForExam("score","");
	}

	

	
 	public ExamStatusForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/examStatusId/");
		this.addFormAction(action);
		return this;
	}

 

	public ExamStatusForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


