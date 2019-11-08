
package com.doublechaintech.bcex.question;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface QuestionManager{

		

	public Question createQuestion(BcexUserContext userContext, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer, String platformId) throws Exception;	
	public Question updateQuestion(BcexUserContext userContext,String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Question loadQuestion(BcexUserContext userContext, String questionId, String [] tokensExpr) throws Exception;
	public Question internalSaveQuestion(BcexUserContext userContext, Question question) throws Exception;
	public Question internalSaveQuestion(BcexUserContext userContext, Question question,Map<String,Object>option) throws Exception;
	
	public Question transferToAnotherPlatform(BcexUserContext userContext, String questionId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String questionId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Question newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  AnswerManager getAnswerManager(BcexUserContext userContext, String questionId, String title, String comment ,String [] tokensExpr)  throws Exception;
	
	public  Question addAnswer(BcexUserContext userContext, String questionId, String title, String comment , String [] tokensExpr)  throws Exception;
	public  Question removeAnswer(BcexUserContext userContext, String questionId, String answerId, int answerVersion,String [] tokensExpr)  throws Exception;
	public  Question updateAnswer(BcexUserContext userContext, String questionId, String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  UserAnswerManager getUserAnswerManager(BcexUserContext userContext, String questionId, String topic, String userSelect, String examId ,String [] tokensExpr)  throws Exception;
	
	public  Question addUserAnswer(BcexUserContext userContext, String questionId, String topic, String userSelect, String examId , String [] tokensExpr)  throws Exception;
	public  Question removeUserAnswer(BcexUserContext userContext, String questionId, String userAnswerId, int userAnswerVersion,String [] tokensExpr)  throws Exception;
	public  Question updateUserAnswer(BcexUserContext userContext, String questionId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


