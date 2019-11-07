package com.doublechaintech.bcex.wechatlogininfo;
import com.doublechaintech.bcex.BaseForm;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;



public class WechatLoginInfoForm extends BaseForm {
	
	
	public WechatLoginInfoForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public WechatLoginInfoForm wechatLoginInfoIdField(String parameterName, String initValue){
		FormField field = idFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm wechatLoginInfoIdField(String initValue){
		return wechatLoginInfoIdField("wechatLoginInfoId",initValue);
	}
	public WechatLoginInfoForm wechatLoginInfoIdField(){
		return wechatLoginInfoIdField("wechatLoginInfoId","");
	}


	public WechatLoginInfoForm wechatUserIdField(String parameterName, String initValue){
		FormField field = wechatUserIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm wechatUserIdField(String initValue){
		return wechatUserIdField("wechatUserId",initValue);
	}
	public WechatLoginInfoForm wechatUserIdField(){
		return wechatUserIdField("wechatUserId","");
	}


	public WechatLoginInfoForm appIdField(String parameterName, String initValue){
		FormField field = appIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm appIdField(String initValue){
		return appIdField("appId",initValue);
	}
	public WechatLoginInfoForm appIdField(){
		return appIdField("appId","");
	}


	public WechatLoginInfoForm openIdField(String parameterName, String initValue){
		FormField field = openIdFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm openIdField(String initValue){
		return openIdField("openId",initValue);
	}
	public WechatLoginInfoForm openIdField(){
		return openIdField("openId","");
	}


	public WechatLoginInfoForm sessionKeyField(String parameterName, String initValue){
		FormField field = sessionKeyFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm sessionKeyField(String initValue){
		return sessionKeyField("sessionKey",initValue);
	}
	public WechatLoginInfoForm sessionKeyField(){
		return sessionKeyField("sessionKey","");
	}


	public WechatLoginInfoForm lastUpdateTimeField(String parameterName, String initValue){
		FormField field = lastUpdateTimeFromWechatLoginInfo(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public WechatLoginInfoForm lastUpdateTimeField(String initValue){
		return lastUpdateTimeField("lastUpdateTime",initValue);
	}
	public WechatLoginInfoForm lastUpdateTimeField(){
		return lastUpdateTimeField("lastUpdateTime","");
	}

	
	


	public WechatLoginInfoForm wechatUserIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  idFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatLoginInfoForm wechatUserIdFieldOfWechatUser(String initValue){
		return wechatUserIdFieldOfWechatUser("wechatUserId",initValue);
	}
	public WechatLoginInfoForm wechatUserIdFieldOfWechatUser(){
		return wechatUserIdFieldOfWechatUser("wechatUserId","");
	}


	public WechatLoginInfoForm nameFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  nameFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatLoginInfoForm nameFieldOfWechatUser(String initValue){
		return nameFieldOfWechatUser("name",initValue);
	}
	public WechatLoginInfoForm nameFieldOfWechatUser(){
		return nameFieldOfWechatUser("name","");
	}


	public WechatLoginInfoForm avartaFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  avartaFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatLoginInfoForm avartaFieldOfWechatUser(String initValue){
		return avartaFieldOfWechatUser("avarta",initValue);
	}
	public WechatLoginInfoForm avartaFieldOfWechatUser(){
		return avartaFieldOfWechatUser("avarta","");
	}


	public WechatLoginInfoForm createTimeFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  createTimeFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatLoginInfoForm createTimeFieldOfWechatUser(String initValue){
		return createTimeFieldOfWechatUser("createTime",initValue);
	}
	public WechatLoginInfoForm createTimeFieldOfWechatUser(){
		return createTimeFieldOfWechatUser("createTime","");
	}


	public WechatLoginInfoForm platformIdFieldOfWechatUser(String parameterName, String initValue){
		FormField field =  platformIdFromWechatUser(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public WechatLoginInfoForm platformIdFieldOfWechatUser(String initValue){
		return platformIdFieldOfWechatUser("platformId",initValue);
	}
	public WechatLoginInfoForm platformIdFieldOfWechatUser(){
		return platformIdFieldOfWechatUser("platformId","");
	}

	


	

	
 	public WechatLoginInfoForm transferToAnotherWechatUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherWechatUser/wechatLoginInfoId/");
		this.addFormAction(action);
		return this;
	}

 

	public WechatLoginInfoForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


