
package com.doublechaintech.bcex.changerequesttype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface ChangeRequestTypeManager{

		
	

	public ChangeRequestType loadChangeRequestTypeWithCode(BcexUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public ChangeRequestType createChangeRequestType(BcexUserContext userContext, String name, String code, String icon, int displayOrder, String platformId) throws Exception;	
	public ChangeRequestType updateChangeRequestType(BcexUserContext userContext,String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChangeRequestType loadChangeRequestType(BcexUserContext userContext, String changeRequestTypeId, String [] tokensExpr) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(BcexUserContext userContext, ChangeRequestType changeRequestType) throws Exception;
	public ChangeRequestType internalSaveChangeRequestType(BcexUserContext userContext, ChangeRequestType changeRequestType,Map<String,Object>option) throws Exception;
	
	public ChangeRequestType transferToAnotherPlatform(BcexUserContext userContext, String changeRequestTypeId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String changeRequestTypeId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, ChangeRequestType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ChangeRequestManager getChangeRequestManager(BcexUserContext userContext, String changeRequestTypeId, String name, String platformId ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequestType addChangeRequest(BcexUserContext userContext, String changeRequestTypeId, String name, String platformId , String [] tokensExpr)  throws Exception;
	public  ChangeRequestType removeChangeRequest(BcexUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequestType updateChangeRequest(BcexUserContext userContext, String changeRequestTypeId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


