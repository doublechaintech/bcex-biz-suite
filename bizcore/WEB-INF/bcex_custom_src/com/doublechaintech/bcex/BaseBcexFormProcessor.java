package com.doublechaintech.bcex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.terapico.caf.form.ImageInfo;
import com.terapico.utils.DebugUtil;

public class BaseBcexFormProcessor extends BaseFormProcessor{
	protected BcexUserContext userContext;
	
	public BcexUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(BcexUserContext userContext) {
		this.userContext = userContext;
	}
	protected void addMessageToException(BcexException e, String msg) {
		Message message = new Message();
		message.setBody(msg);
		e.addErrorMessage(message);
	}
	public Map<String, Object> mapToUiForm(BcexUserContext userContext) {
		return null; 
	}
}















