
package com.doublechaintech.bcex.faultanswer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface FaultAnswerManager{

		

	public FaultAnswer createFaultAnswer(BcexUserContext userContext, String topic, String yourAnswer, String rightAnswer, String userId, String examId) throws Exception;	
	public FaultAnswer updateFaultAnswer(BcexUserContext userContext,String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public FaultAnswer loadFaultAnswer(BcexUserContext userContext, String faultAnswerId, String [] tokensExpr) throws Exception;
	public FaultAnswer internalSaveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer) throws Exception;
	public FaultAnswer internalSaveFaultAnswer(BcexUserContext userContext, FaultAnswer faultAnswer,Map<String,Object>option) throws Exception;
	
	public FaultAnswer transferToAnotherUser(BcexUserContext userContext, String faultAnswerId, String anotherUserId)  throws Exception;
 	public FaultAnswer transferToAnotherExam(BcexUserContext userContext, String faultAnswerId, String anotherExamId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String faultAnswerId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, FaultAnswer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


