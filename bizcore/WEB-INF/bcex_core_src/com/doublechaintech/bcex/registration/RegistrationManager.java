
package com.doublechaintech.bcex.registration;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface RegistrationManager{

		

	public Registration createRegistration(BcexUserContext userContext, String nickName, String avatar, String changeRequestId) throws Exception;	
	public Registration updateRegistration(BcexUserContext userContext,String registrationId, int registrationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Registration loadRegistration(BcexUserContext userContext, String registrationId, String [] tokensExpr) throws Exception;
	public Registration internalSaveRegistration(BcexUserContext userContext, Registration registration) throws Exception;
	public Registration internalSaveRegistration(BcexUserContext userContext, Registration registration,Map<String,Object>option) throws Exception;
	
	public Registration transferToAnotherChangeRequest(BcexUserContext userContext, String registrationId, String anotherChangeRequestId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String registrationId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Registration newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


