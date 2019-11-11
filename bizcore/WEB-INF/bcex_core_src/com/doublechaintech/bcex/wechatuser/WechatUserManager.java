
package com.doublechaintech.bcex.wechatuser;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface WechatUserManager{

		

	public WechatUser createWechatUser(BcexUserContext userContext, String name, String avarta, String userType, String platformId) throws Exception;	
	public WechatUser updateWechatUser(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatUser loadWechatUser(BcexUserContext userContext, String wechatUserId, String [] tokensExpr) throws Exception;
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser) throws Exception;
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser,Map<String,Object>option) throws Exception;
	
	public WechatUser transferToAnotherPlatform(BcexUserContext userContext, String wechatUserId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String wechatUserId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, WechatUser newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  StartExamManager getStartExamManager(BcexUserContext userContext, String wechatUserId, String nickName, String changeRequestId ,String [] tokensExpr)  throws Exception;
	
	public  WechatUser addStartExam(BcexUserContext userContext, String wechatUserId, String nickName, String changeRequestId , String [] tokensExpr)  throws Exception;
	public  WechatUser removeStartExam(BcexUserContext userContext, String wechatUserId, String startExamId, int startExamVersion,String [] tokensExpr)  throws Exception;
	public  WechatUser updateStartExam(BcexUserContext userContext, String wechatUserId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  AnswerQuestionManager getAnswerQuestionManager(BcexUserContext userContext, String wechatUserId, String nickName, String userAnswerId, String answer, String changeRequestId ,String [] tokensExpr)  throws Exception;
	
	public  WechatUser addAnswerQuestion(BcexUserContext userContext, String wechatUserId, String nickName, String userAnswerId, String answer, String changeRequestId , String [] tokensExpr)  throws Exception;
	public  WechatUser removeAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion,String [] tokensExpr)  throws Exception;
	public  WechatUser updateAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatLoginInfoManager getWechatLoginInfoManager(BcexUserContext userContext, String wechatUserId, String appId, String openId, String sessionKey ,String [] tokensExpr)  throws Exception;
	
	public  WechatUser addWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String appId, String openId, String sessionKey , String [] tokensExpr)  throws Exception;
	public  WechatUser removeWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String wechatLoginInfoId, int wechatLoginInfoVersion,String [] tokensExpr)  throws Exception;
	public  WechatUser updateWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ExamManager getExamManager(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score ,String [] tokensExpr)  throws Exception;
	
	public  WechatUser addExam(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score , String [] tokensExpr)  throws Exception;
	public  WechatUser removeExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion,String [] tokensExpr)  throws Exception;
	public  WechatUser updateExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  FaultAnswerManager getFaultAnswerManager(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String questionId, int faultTimes ,String [] tokensExpr)  throws Exception;
	
	public  WechatUser addFaultAnswer(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String questionId, int faultTimes , String [] tokensExpr)  throws Exception;
	public  WechatUser removeFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion,String [] tokensExpr)  throws Exception;
	public  WechatUser updateFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


