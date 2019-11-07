
package com.doublechaintech.bcex.answer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface AnswerManager{

		

	public Answer createAnswer(BcexUserContext userContext, String title, String comment, String questionId) throws Exception;	
	public Answer updateAnswer(BcexUserContext userContext,String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Answer loadAnswer(BcexUserContext userContext, String answerId, String [] tokensExpr) throws Exception;
	public Answer internalSaveAnswer(BcexUserContext userContext, Answer answer) throws Exception;
	public Answer internalSaveAnswer(BcexUserContext userContext, Answer answer,Map<String,Object>option) throws Exception;
	
	public Answer transferToAnotherQuestion(BcexUserContext userContext, String answerId, String anotherQuestionId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String answerId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Answer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


