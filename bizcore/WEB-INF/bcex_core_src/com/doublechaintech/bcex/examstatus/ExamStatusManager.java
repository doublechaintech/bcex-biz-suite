
package com.doublechaintech.bcex.examstatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface ExamStatusManager{

		
	

	public ExamStatus loadExamStatusWithCode(BcexUserContext userContext, String code, Map<String,Object>tokens) throws Exception;

	 

	public ExamStatus createExamStatus(BcexUserContext userContext, String name, String code, String platformId) throws Exception;	
	public ExamStatus updateExamStatus(BcexUserContext userContext,String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ExamStatus loadExamStatus(BcexUserContext userContext, String examStatusId, String [] tokensExpr) throws Exception;
	public ExamStatus internalSaveExamStatus(BcexUserContext userContext, ExamStatus examStatus) throws Exception;
	public ExamStatus internalSaveExamStatus(BcexUserContext userContext, ExamStatus examStatus,Map<String,Object>option) throws Exception;
	
	public ExamStatus transferToAnotherPlatform(BcexUserContext userContext, String examStatusId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String examStatusId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, ExamStatus newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ExamManager getExamManager(BcexUserContext userContext, String examStatusId, String name, String userId, int score ,String [] tokensExpr)  throws Exception;
	
	public  ExamStatus addExam(BcexUserContext userContext, String examStatusId, String name, String userId, int score , String [] tokensExpr)  throws Exception;
	public  ExamStatus removeExam(BcexUserContext userContext, String examStatusId, String examId, int examVersion,String [] tokensExpr)  throws Exception;
	public  ExamStatus updateExam(BcexUserContext userContext, String examStatusId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


