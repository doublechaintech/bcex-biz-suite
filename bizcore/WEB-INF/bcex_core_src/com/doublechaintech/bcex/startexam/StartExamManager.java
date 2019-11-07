
package com.doublechaintech.bcex.startexam;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface StartExamManager{

		

	public StartExam createStartExam(BcexUserContext userContext, String nickName, String changeRequestId) throws Exception;	
	public StartExam updateStartExam(BcexUserContext userContext,String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public StartExam loadStartExam(BcexUserContext userContext, String startExamId, String [] tokensExpr) throws Exception;
	public StartExam internalSaveStartExam(BcexUserContext userContext, StartExam startExam) throws Exception;
	public StartExam internalSaveStartExam(BcexUserContext userContext, StartExam startExam,Map<String,Object>option) throws Exception;
	
	public StartExam transferToAnotherChangeRequest(BcexUserContext userContext, String startExamId, String anotherChangeRequestId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String startExamId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, StartExam newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


