
package com.doublechaintech.bcex.exam;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface ExamManager{

		

	public Exam createExam(BcexUserContext userContext, String name, String statusId, String userId, int score) throws Exception;	
	public Exam updateExam(BcexUserContext userContext,String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Exam loadExam(BcexUserContext userContext, String examId, String [] tokensExpr) throws Exception;
	public Exam internalSaveExam(BcexUserContext userContext, Exam exam) throws Exception;
	public Exam internalSaveExam(BcexUserContext userContext, Exam exam,Map<String,Object>option) throws Exception;
	
	public Exam transferToAnotherStatus(BcexUserContext userContext, String examId, String anotherStatusId)  throws Exception;
 	public Exam transferToAnotherUser(BcexUserContext userContext, String examId, String anotherUserId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String examId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Exam newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  UserAnswerManager getUserAnswerManager(BcexUserContext userContext, String examId, String topic, String userSelect, String questionId ,String [] tokensExpr)  throws Exception;
	
	public  Exam addUserAnswer(BcexUserContext userContext, String examId, String topic, String userSelect, String questionId , String [] tokensExpr)  throws Exception;
	public  Exam removeUserAnswer(BcexUserContext userContext, String examId, String userAnswerId, int userAnswerVersion,String [] tokensExpr)  throws Exception;
	public  Exam updateUserAnswer(BcexUserContext userContext, String examId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FaultAnswerManager getFaultAnswerManager(BcexUserContext userContext, String examId, String topic, String yourAnswer, String rightAnswer, String userId ,String [] tokensExpr)  throws Exception;
	
	public  Exam addFaultAnswer(BcexUserContext userContext, String examId, String topic, String yourAnswer, String rightAnswer, String userId , String [] tokensExpr)  throws Exception;
	public  Exam removeFaultAnswer(BcexUserContext userContext, String examId, String faultAnswerId, int faultAnswerVersion,String [] tokensExpr)  throws Exception;
	public  Exam updateFaultAnswer(BcexUserContext userContext, String examId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


