
package com.doublechaintech.bcex.quicklink;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface QuickLinkManager{

		

	public QuickLink createQuickLink(BcexUserContext userContext, String name, String icon, String imagePath, String linkTarget, String appId) throws Exception;	
	public QuickLink updateQuickLink(BcexUserContext userContext,String quickLinkId, int quickLinkVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public QuickLink loadQuickLink(BcexUserContext userContext, String quickLinkId, String [] tokensExpr) throws Exception;
	public QuickLink internalSaveQuickLink(BcexUserContext userContext, QuickLink quickLink) throws Exception;
	public QuickLink internalSaveQuickLink(BcexUserContext userContext, QuickLink quickLink,Map<String,Object>option) throws Exception;
	
	public QuickLink transferToAnotherApp(BcexUserContext userContext, String quickLinkId, String anotherAppId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String quickLinkId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, QuickLink newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


