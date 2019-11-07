
package com.doublechaintech.bcex.platform;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface PlatformManager{

		

	public Platform createPlatform(BcexUserContext userContext, String name, String description) throws Exception;	
	public Platform updatePlatform(BcexUserContext userContext,String platformId, int platformVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Platform loadPlatform(BcexUserContext userContext, String platformId, String [] tokensExpr) throws Exception;
	public Platform internalSavePlatform(BcexUserContext userContext, Platform platform) throws Exception;
	public Platform internalSavePlatform(BcexUserContext userContext, Platform platform,Map<String,Object>option) throws Exception;
	


	public void delete(BcexUserContext userContext, String platformId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, Platform newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  ChangeRequestTypeManager getChangeRequestTypeManager(BcexUserContext userContext, String platformId, String name, String code, String icon, int displayOrder ,String [] tokensExpr)  throws Exception;
	
	public  Platform addChangeRequestType(BcexUserContext userContext, String platformId, String name, String code, String icon, int displayOrder , String [] tokensExpr)  throws Exception;
	public  Platform removeChangeRequestType(BcexUserContext userContext, String platformId, String changeRequestTypeId, int changeRequestTypeVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateChangeRequestType(BcexUserContext userContext, String platformId, String changeRequestTypeId, int changeRequestTypeVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ChangeRequestManager getChangeRequestManager(BcexUserContext userContext, String platformId, String name, String requestTypeId ,String [] tokensExpr)  throws Exception;
	
	public  Platform addChangeRequest(BcexUserContext userContext, String platformId, String name, String requestTypeId , String [] tokensExpr)  throws Exception;
	public  Platform removeChangeRequest(BcexUserContext userContext, String platformId, String changeRequestId, int changeRequestVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateChangeRequest(BcexUserContext userContext, String platformId, String changeRequestId, int changeRequestVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ExamStatusManager getExamStatusManager(BcexUserContext userContext, String platformId, String name, String code ,String [] tokensExpr)  throws Exception;
	
	public  Platform addExamStatus(BcexUserContext userContext, String platformId, String name, String code , String [] tokensExpr)  throws Exception;
	public  Platform removeExamStatus(BcexUserContext userContext, String platformId, String examStatusId, int examStatusVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateExamStatus(BcexUserContext userContext, String platformId, String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  QuestionManager getQuestionManager(BcexUserContext userContext, String platformId, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer ,String [] tokensExpr)  throws Exception;
	
	public  Platform addQuestion(BcexUserContext userContext, String platformId, String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer , String [] tokensExpr)  throws Exception;
	public  Platform removeQuestion(BcexUserContext userContext, String platformId, String questionId, int questionVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateQuestion(BcexUserContext userContext, String platformId, String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  ExamRankingManager getExamRankingManager(BcexUserContext userContext, String platformId, String name, String avarta ,String [] tokensExpr)  throws Exception;
	
	public  Platform addExamRanking(BcexUserContext userContext, String platformId, String name, String avarta , String [] tokensExpr)  throws Exception;
	public  Platform removeExamRanking(BcexUserContext userContext, String platformId, String examRankingId, int examRankingVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateExamRanking(BcexUserContext userContext, String platformId, String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  WechatUserManager getWechatUserManager(BcexUserContext userContext, String platformId, String name, String avarta ,String [] tokensExpr)  throws Exception;
	
	public  Platform addWechatUser(BcexUserContext userContext, String platformId, String name, String avarta , String [] tokensExpr)  throws Exception;
	public  Platform removeWechatUser(BcexUserContext userContext, String platformId, String wechatUserId, int wechatUserVersion,String [] tokensExpr)  throws Exception;
	public  Platform updateWechatUser(BcexUserContext userContext, String platformId, String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


