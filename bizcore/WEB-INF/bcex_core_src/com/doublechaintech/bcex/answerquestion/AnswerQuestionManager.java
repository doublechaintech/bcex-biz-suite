
package com.doublechaintech.bcex.answerquestion;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface AnswerQuestionManager{

		

	public AnswerQuestion createAnswerQuestion(BcexUserContext userContext, String nickName, String userId, String userAnswerId, String answer, String changeRequestId) throws Exception;	
	public AnswerQuestion updateAnswerQuestion(BcexUserContext userContext,String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public AnswerQuestion loadAnswerQuestion(BcexUserContext userContext, String answerQuestionId, String [] tokensExpr) throws Exception;
	public AnswerQuestion internalSaveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion) throws Exception;
	public AnswerQuestion internalSaveAnswerQuestion(BcexUserContext userContext, AnswerQuestion answerQuestion,Map<String,Object>option) throws Exception;
	
	public AnswerQuestion transferToAnotherUser(BcexUserContext userContext, String answerQuestionId, String anotherUserId)  throws Exception;
 	public AnswerQuestion transferToAnotherUserAnswer(BcexUserContext userContext, String answerQuestionId, String anotherUserAnswerId)  throws Exception;
 	public AnswerQuestion transferToAnotherChangeRequest(BcexUserContext userContext, String answerQuestionId, String anotherChangeRequestId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String answerQuestionId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, AnswerQuestion newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


