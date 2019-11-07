
package com.doublechaintech.bcex.formmessage;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface FormMessageManager{

		

	public FormMessage createFormMessage(BcexUserContext userContext, String title, String formId, String level) throws Exception;	
	public FormMessage updateFormMessage(BcexUserContext userContext,String formMessageId, int formMessageVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FormMessage loadFormMessage(BcexUserContext userContext, String formMessageId, String [] tokensExpr) throws Exception;
	public FormMessage internalSaveFormMessage(BcexUserContext userContext, FormMessage formMessage) throws Exception;
	public FormMessage internalSaveFormMessage(BcexUserContext userContext, FormMessage formMessage,Map<String,Object>option) throws Exception;
	
	public FormMessage transferToAnotherForm(BcexUserContext userContext, String formMessageId, String anotherFormId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String formMessageId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, FormMessage newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


