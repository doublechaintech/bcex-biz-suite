package com.doublechaintech.bcex.examranking;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class ExamRankingForm extends BaseForm {
	
	
	public ExamRankingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public ExamRankingForm examRankingIdField(String parameterName, String initValue){
		FormField field = idFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamRankingForm examRankingIdField(String initValue){
		return examRankingIdField("examRankingId",initValue);
	}
	public ExamRankingForm examRankingIdField(){
		return examRankingIdField("examRankingId","");
	}


	public ExamRankingForm nameField(String parameterName, String initValue){
		FormField field = nameFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamRankingForm nameField(String initValue){
		return nameField("name",initValue);
	}
	public ExamRankingForm nameField(){
		return nameField("name","");
	}


	public ExamRankingForm avartaField(String parameterName, String initValue){
		FormField field = avartaFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamRankingForm avartaField(String initValue){
		return avartaField("avarta",initValue);
	}
	public ExamRankingForm avartaField(){
		return avartaField("avarta","");
	}


	public ExamRankingForm platformIdField(String parameterName, String initValue){
		FormField field = platformIdFromExamRanking(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public ExamRankingForm platformIdField(String initValue){
		return platformIdField("platformId",initValue);
	}
	public ExamRankingForm platformIdField(){
		return platformIdField("platformId","");
	}

	
	


	public ExamRankingForm platformIdFieldOfPlatform(String parameterName, String initValue){
		FormField field =  idFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamRankingForm platformIdFieldOfPlatform(String initValue){
		return platformIdFieldOfPlatform("platformId",initValue);
	}
	public ExamRankingForm platformIdFieldOfPlatform(){
		return platformIdFieldOfPlatform("platformId","");
	}


	public ExamRankingForm nameFieldOfPlatform(String parameterName, String initValue){
		FormField field =  nameFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamRankingForm nameFieldOfPlatform(String initValue){
		return nameFieldOfPlatform("name",initValue);
	}
	public ExamRankingForm nameFieldOfPlatform(){
		return nameFieldOfPlatform("name","");
	}


	public ExamRankingForm descriptionFieldOfPlatform(String parameterName, String initValue){
		FormField field =  descriptionFromPlatform(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public ExamRankingForm descriptionFieldOfPlatform(String initValue){
		return descriptionFieldOfPlatform("description",initValue);
	}
	public ExamRankingForm descriptionFieldOfPlatform(){
		return descriptionFieldOfPlatform("description","");
	}

	


	

	
 	public ExamRankingForm transferToAnotherPlatformAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherPlatform/examRankingId/");
		this.addFormAction(action);
		return this;
	}

 

	public ExamRankingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


