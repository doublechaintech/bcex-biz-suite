
package com.doublechaintech.bcex.useranswer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface UserAnswerManager{

		

	public UserAnswer createUserAnswer(BcexUserContext userContext, String topic, String userSelect, String questionId, String examId) throws Exception;	
	public UserAnswer updateUserAnswer(BcexUserContext userContext,String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public UserAnswer loadUserAnswer(BcexUserContext userContext, String userAnswerId, String [] tokensExpr) throws Exception;
	public UserAnswer internalSaveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer) throws Exception;
	public UserAnswer internalSaveUserAnswer(BcexUserContext userContext, UserAnswer userAnswer,Map<String,Object>option) throws Exception;
	
	public UserAnswer transferToAnotherQuestion(BcexUserContext userContext, String userAnswerId, String anotherQuestionId)  throws Exception;
 	public UserAnswer transferToAnotherExam(BcexUserContext userContext, String userAnswerId, String anotherExamId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String userAnswerId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, UserAnswer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


