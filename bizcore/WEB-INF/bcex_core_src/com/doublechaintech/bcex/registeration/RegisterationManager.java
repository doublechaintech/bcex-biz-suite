
package com.doublechaintech.bcex.registeration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface RegisterationManager{

		

	public Registeration createRegisteration(BcexUserContext userContext, String nickName, String avarta, String changeRequestId) throws Exception;	
	public Registeration updateRegisteration(BcexUserContext userContext,String registerationId, int registerationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Registeration loadRegisteration(BcexUserContext userContext, String registerationId, String [] tokensExpr) throws Exception;
	public Registeration internalSaveRegisteration(BcexUserContext userContext, Registeration registeration) throws Exception;
	public Registeration internalSaveRegisteration(BcexUserContext userContext, Registeration registeration,Map<String,Object>option) throws Exception;
	
	public Registeration transferToAnotherChangeRequest(BcexUserContext userContext, String registerationId, String anotherChangeRequestId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String registerationId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Registeration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


