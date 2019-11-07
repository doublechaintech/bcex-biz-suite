
package com.doublechaintech.bcex.changerequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface ChangeRequestManager{

		

	public ChangeRequest createChangeRequest(BcexUserContext userContext, String name, String requestTypeId, String platformId) throws Exception;	
	public ChangeRequest updateChangeRequest(BcexUserContext userContext,String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ChangeRequest loadChangeRequest(BcexUserContext userContext, String changeRequestId, String [] tokensExpr) throws Exception;
	public ChangeRequest internalSaveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest) throws Exception;
	public ChangeRequest internalSaveChangeRequest(BcexUserContext userContext, ChangeRequest changeRequest,Map<String,Object>option) throws Exception;
	
	public ChangeRequest transferToAnotherRequestType(BcexUserContext userContext, String changeRequestId, String anotherRequestTypeId)  throws Exception;
 	public ChangeRequest transferToAnotherPlatform(BcexUserContext userContext, String changeRequestId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String changeRequestId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, ChangeRequest newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  RegisterationManager getRegisterationManager(BcexUserContext userContext, String changeRequestId, String nickName, String avarta ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequest addRegisteration(BcexUserContext userContext, String changeRequestId, String nickName, String avarta , String [] tokensExpr)  throws Exception;
	public  ChangeRequest removeRegisteration(BcexUserContext userContext, String changeRequestId, String registerationId, int registerationVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequest updateRegisteration(BcexUserContext userContext, String changeRequestId, String registerationId, int registerationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  StartExamManager getStartExamManager(BcexUserContext userContext, String changeRequestId, String nickName ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequest addStartExam(BcexUserContext userContext, String changeRequestId, String nickName , String [] tokensExpr)  throws Exception;
	public  ChangeRequest removeStartExam(BcexUserContext userContext, String changeRequestId, String startExamId, int startExamVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequest updateStartExam(BcexUserContext userContext, String changeRequestId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AnswerQuestionManager getAnswerQuestionManager(BcexUserContext userContext, String changeRequestId, String nickName, String userId, String questionId, String answer ,String [] tokensExpr)  throws Exception;
	
	public  ChangeRequest addAnswerQuestion(BcexUserContext userContext, String changeRequestId, String nickName, String userId, String questionId, String answer , String [] tokensExpr)  throws Exception;
	public  ChangeRequest removeAnswerQuestion(BcexUserContext userContext, String changeRequestId, String answerQuestionId, int answerQuestionVersion,String [] tokensExpr)  throws Exception;
	public  ChangeRequest updateAnswerQuestion(BcexUserContext userContext, String changeRequestId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


