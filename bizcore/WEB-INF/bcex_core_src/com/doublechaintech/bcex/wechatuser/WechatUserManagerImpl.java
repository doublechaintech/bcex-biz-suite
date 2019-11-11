
package com.doublechaintech.bcex.wechatuser;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BaseEntity;


import com.doublechaintech.bcex.Message;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;

import com.doublechaintech.bcex.BcexUserContext;
//import com.doublechaintech.bcex.BaseManagerImpl;
import com.doublechaintech.bcex.BcexCheckerManager;
import com.doublechaintech.bcex.CustomBcexCheckerManager;

import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfo;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.platform.CandidatePlatform;

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;






public class WechatUserManagerImpl extends CustomBcexCheckerManager implements WechatUserManager {
	
	private static final String SERVICE_TYPE = "WechatUser";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws WechatUserManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new WechatUserManagerException(message);

	}
	
	

 	protected WechatUser saveWechatUser(BcexUserContext userContext, WechatUser wechatUser, String [] tokensExpr) throws Exception{	
 		//return getWechatUserDAO().save(wechatUser, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveWechatUser(userContext, wechatUser, tokens);
 	}
 	
 	protected WechatUser saveWechatUserDetail(BcexUserContext userContext, WechatUser wechatUser) throws Exception{	

 		
 		return saveWechatUser(userContext, wechatUser, allTokens());
 	}
 	
 	public WechatUser loadWechatUser(BcexUserContext userContext, String wechatUserId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatUser, tokens);
 	}
 	
 	
 	 public WechatUser searchWechatUser(BcexUserContext userContext, String wechatUserId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,wechatUser, tokens);
 	}
 	
 	

 	protected WechatUser present(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,wechatUser,tokens);
		
		
		WechatUser  wechatUserToPresent = wechatUserDaoOf(userContext).present(wechatUser, tokens);
		
		List<BaseEntity> entityListToNaming = wechatUserToPresent.collectRefercencesFromLists();
		wechatUserDaoOf(userContext).alias(entityListToNaming);
		
		return  wechatUserToPresent;
		
		
	}
 
 	
 	
 	public WechatUser loadWechatUserDetail(BcexUserContext userContext, String wechatUserId) throws Exception{	
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, allTokens());
 		return present(userContext,wechatUser, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String wechatUserId) throws Exception{	
 		WechatUser wechatUser = loadWechatUser( userContext, wechatUserId, viewTokens());
 		return present(userContext,wechatUser, allTokens());
		
 	}
 	protected WechatUser saveWechatUser(BcexUserContext userContext, WechatUser wechatUser, Map<String,Object>tokens) throws Exception{	
 		return wechatUserDaoOf(userContext).save(wechatUser, tokens);
 	}
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String wechatUserId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).throwExceptionIfHasErrors( WechatUserManagerException.class);

 
 		return wechatUserDaoOf(userContext).load(wechatUserId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens){
		super.addActions(userContext, wechatUser, tokens);
		
		addAction(userContext, wechatUser, tokens,"@create","createWechatUser","createWechatUser/","main","primary");
		addAction(userContext, wechatUser, tokens,"@update","updateWechatUser","updateWechatUser/"+wechatUser.getId()+"/","main","primary");
		addAction(userContext, wechatUser, tokens,"@copy","cloneWechatUser","cloneWechatUser/"+wechatUser.getId()+"/","main","primary");
		
		addAction(userContext, wechatUser, tokens,"wechat_user.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+wechatUser.getId()+"/","main","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addStartExam","addStartExam","addStartExam/"+wechatUser.getId()+"/","startExamList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeStartExam","removeStartExam","removeStartExam/"+wechatUser.getId()+"/","startExamList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateStartExam","updateStartExam","updateStartExam/"+wechatUser.getId()+"/","startExamList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyStartExamFrom","copyStartExamFrom","copyStartExamFrom/"+wechatUser.getId()+"/","startExamList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addAnswerQuestion","addAnswerQuestion","addAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeAnswerQuestion","removeAnswerQuestion","removeAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateAnswerQuestion","updateAnswerQuestion","updateAnswerQuestion/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyAnswerQuestionFrom","copyAnswerQuestionFrom","copyAnswerQuestionFrom/"+wechatUser.getId()+"/","answerQuestionList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addWechatLoginInfo","addWechatLoginInfo","addWechatLoginInfo/"+wechatUser.getId()+"/","wechatLoginInfoList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeWechatLoginInfo","removeWechatLoginInfo","removeWechatLoginInfo/"+wechatUser.getId()+"/","wechatLoginInfoList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateWechatLoginInfo","updateWechatLoginInfo","updateWechatLoginInfo/"+wechatUser.getId()+"/","wechatLoginInfoList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyWechatLoginInfoFrom","copyWechatLoginInfoFrom","copyWechatLoginInfoFrom/"+wechatUser.getId()+"/","wechatLoginInfoList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addExam","addExam","addExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeExam","removeExam","removeExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateExam","updateExam","updateExam/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyExamFrom","copyExamFrom","copyExamFrom/"+wechatUser.getId()+"/","examList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.addFaultAnswer","addFaultAnswer","addFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.removeFaultAnswer","removeFaultAnswer","removeFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.updateFaultAnswer","updateFaultAnswer","updateFaultAnswer/"+wechatUser.getId()+"/","faultAnswerList","primary");
		addAction(userContext, wechatUser, tokens,"wechat_user.copyFaultAnswerFrom","copyFaultAnswerFrom","copyFaultAnswerFrom/"+wechatUser.getId()+"/","faultAnswerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, WechatUser wechatUser, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public WechatUser createWechatUser(BcexUserContext userContext,String name, String avarta, String userType, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfWechatUser(name);
		checkerOf(userContext).checkAvartaOfWechatUser(avarta);
		checkerOf(userContext).checkUserTypeOfWechatUser(userType);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);


		WechatUser wechatUser=createNewWechatUser();	

		wechatUser.setName(name);
		wechatUser.setAvarta(avarta);
		wechatUser.setCreateTime(userContext.now());
		wechatUser.setUserType(userType);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		wechatUser.setPlatform(platform);
		
		

		wechatUser = saveWechatUser(userContext, wechatUser, emptyOptions());
		
		onNewInstanceCreated(userContext, wechatUser);
		return wechatUser;

		
	}
	protected WechatUser createNewWechatUser() 
	{
		
		return new WechatUser();		
	}
	
	protected void checkParamsForUpdatingWechatUser(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkVersionOfWechatUser( wechatUserVersion);
		

		if(WechatUser.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfWechatUser(parseString(newValueExpr));
		}
		if(WechatUser.AVARTA_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvartaOfWechatUser(parseString(newValueExpr));
		}
		if(WechatUser.USER_TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserTypeOfWechatUser(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
		
	}
	
	
	
	public WechatUser clone(BcexUserContext userContext, String fromWechatUserId) throws Exception{
		
		return wechatUserDaoOf(userContext).clone(fromWechatUserId, this.allTokens());
	}
	
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser) throws Exception 
	{
		return internalSaveWechatUser(userContext, wechatUser, allTokens());

	}
	public WechatUser internalSaveWechatUser(BcexUserContext userContext, WechatUser wechatUser, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			if (wechatUser.isChanged()){
			
			}
			wechatUser = saveWechatUser(userContext, wechatUser, options);
			return wechatUser;
			
		}

	}
	
	public WechatUser updateWechatUser(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		if(wechatUser.getVersion() != wechatUserVersion){
			String message = "The target version("+wechatUser.getVersion()+") is not equals to version("+wechatUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			
			wechatUser.changeProperty(property, newValueExpr);
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			//return saveWechatUser(userContext, wechatUser, tokens().done());
		}

	}
	
	public WechatUser updateWechatUserProperty(BcexUserContext userContext,String wechatUserId, int wechatUserVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingWechatUser(userContext, wechatUserId, wechatUserVersion, property, newValueExpr, tokensExpr);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		if(wechatUser.getVersion() != wechatUserVersion){
			String message = "The target version("+wechatUser.getVersion()+") is not equals to version("+wechatUserVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(wechatUser){ 
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to WechatUser.
			
			wechatUser.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			//return saveWechatUser(userContext, wechatUser, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected WechatUserTokens tokens(){
		return WechatUserTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return WechatUserTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortStartExamListWith("id","desc")
		.sortAnswerQuestionListWith("id","desc")
		.sortWechatLoginInfoListWith("id","desc")
		.sortExamListWith("id","desc")
		.sortFaultAnswerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return WechatUserTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String wechatUserId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
 		
 	}
 	public WechatUser transferToAnotherPlatform(BcexUserContext userContext, String wechatUserId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, wechatUserId,anotherPlatformId);
 
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());	
		synchronized(wechatUser){
			//will be good when the wechatUser loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			wechatUser.updatePlatform(platform);		
			wechatUser = saveWechatUser(userContext, wechatUser, emptyOptions());
			
			return present(userContext,wechatUser, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidatePlatform requestCandidatePlatform(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidatePlatform result = new CandidatePlatform();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForWechatUser(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected Platform loadPlatform(BcexUserContext userContext, String newPlatformId, Map<String,Object> options) throws Exception
 	{
		
 		return platformDaoOf(userContext).load(newPlatformId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String wechatUserId, int wechatUserVersion) throws Exception {
		//deleteInternal(userContext, wechatUserId, wechatUserVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String wechatUserId, int wechatUserVersion) throws Exception{
			
		wechatUserDaoOf(userContext).delete(wechatUserId, wechatUserVersion);
	}
	
	public WechatUser forgetByAll(BcexUserContext userContext, String wechatUserId, int wechatUserVersion) throws Exception {
		return forgetByAllInternal(userContext, wechatUserId, wechatUserVersion);		
	}
	protected WechatUser forgetByAllInternal(BcexUserContext userContext,
			String wechatUserId, int wechatUserVersion) throws Exception{
			
		return wechatUserDaoOf(userContext).disconnectFromAll(wechatUserId, wechatUserVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new WechatUserManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return wechatUserDaoOf(userContext).deleteAll();
	}


	//disconnect WechatUser with change_request in StartExam
	protected WechatUser breakWithStartExamByChangeRequest(BcexUserContext userContext, String wechatUserId, String changeRequestId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveStartExamListWithChangeRequest(wechatUser, changeRequestId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with user_answer in AnswerQuestion
	protected WechatUser breakWithAnswerQuestionByUserAnswer(BcexUserContext userContext, String wechatUserId, String userAnswerId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionListWithUserAnswer(wechatUser, userAnswerId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with change_request in AnswerQuestion
	protected WechatUser breakWithAnswerQuestionByChangeRequest(BcexUserContext userContext, String wechatUserId, String changeRequestId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionListWithChangeRequest(wechatUser, changeRequestId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with app_id in WechatLoginInfo
	protected WechatUser breakWithWechatLoginInfoByAppId(BcexUserContext userContext, String wechatUserId, String appIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveWechatLoginInfoListWithAppId(wechatUser, appIdId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with open_id in WechatLoginInfo
	protected WechatUser breakWithWechatLoginInfoByOpenId(BcexUserContext userContext, String wechatUserId, String openIdId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveWechatLoginInfoListWithOpenId(wechatUser, openIdId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with status in Exam
	protected WechatUser breakWithExamByStatus(BcexUserContext userContext, String wechatUserId, String statusId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveExamListWithStatus(wechatUser, statusId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
				return wechatUser;
			}
	}
	//disconnect WechatUser with question in FaultAnswer
	protected WechatUser breakWithFaultAnswerByQuestion(BcexUserContext userContext, String wechatUserId, String questionId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());

			synchronized(wechatUser){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				wechatUserDaoOf(userContext).planToRemoveFaultAnswerListWithQuestion(wechatUser, questionId, this.emptyOptions());

				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
				return wechatUser;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingStartExam(BcexUserContext userContext, String wechatUserId, String nickName, String changeRequestId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkNickNameOfStartExam(nickName);
		
		checkerOf(userContext).checkChangeRequestIdOfStartExam(changeRequestId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addStartExam(BcexUserContext userContext, String wechatUserId, String nickName, String changeRequestId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingStartExam(userContext,wechatUserId,nickName, changeRequestId,tokensExpr);
		
		StartExam startExam = createStartExam(userContext,nickName, changeRequestId);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addStartExam( startExam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
			
			userContext.getManagerGroup().getStartExamManager().onNewInstanceCreated(userContext, startExam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingStartExamProperties(BcexUserContext userContext, String wechatUserId,String id,String nickName,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfStartExam(id);
		
		checkerOf(userContext).checkNickNameOfStartExam( nickName);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateStartExamProperties(BcexUserContext userContext, String wechatUserId, String id,String nickName, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingStartExamProperties(userContext,wechatUserId,id,nickName,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withStartExamListList()
				.searchStartExamListWith(StartExam.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getStartExamList().isEmpty()){
			throw new WechatUserManagerException("StartExam is NOT FOUND with id: '"+id+"'");
		}
		
		StartExam item = wechatUserToUpdate.getStartExamList().first();
		
		item.updateNickName( nickName );

		
		//checkParamsForAddingStartExam(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withStartExamList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected StartExam createStartExam(BcexUserContext userContext, String nickName, String changeRequestId) throws Exception{

		StartExam startExam = new StartExam();
		
		
		startExam.setNickName(nickName);		
		ChangeRequest  changeRequest = new ChangeRequest();
		changeRequest.setId(changeRequestId);		
		startExam.setChangeRequest(changeRequest);
	
		
		return startExam;
	
		
	}
	
	protected StartExam createIndexedStartExam(String id, int version){

		StartExam startExam = new StartExam();
		startExam.setId(id);
		startExam.setVersion(version);
		return startExam;			
		
	}
	
	protected void checkParamsForRemovingStartExamList(BcexUserContext userContext, String wechatUserId, 
			String startExamIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String startExamIdItem: startExamIds){
			checkerOf(userContext).checkIdOfStartExam(startExamIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeStartExamList(BcexUserContext userContext, String wechatUserId, 
			String startExamIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingStartExamList(userContext, wechatUserId,  startExamIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveStartExamList(wechatUser, startExamIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
				deleteRelationListInGraph(userContext, wechatUser.getStartExamList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingStartExam(BcexUserContext userContext, String wechatUserId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeStartExam(BcexUserContext userContext, String wechatUserId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingStartExam(userContext,wechatUserId, startExamId, startExamVersion,tokensExpr);
		
		StartExam startExam = createIndexedStartExam(startExamId, startExamVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeStartExam( startExam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
			deleteRelationInGraph(userContext, startExam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingStartExam(BcexUserContext userContext, String wechatUserId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyStartExamFrom(BcexUserContext userContext, String wechatUserId, 
		String startExamId, int startExamVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingStartExam(userContext,wechatUserId, startExamId, startExamVersion,tokensExpr);
		
		StartExam startExam = createIndexedStartExam(startExamId, startExamVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyStartExamFrom( startExam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
			
			userContext.getManagerGroup().getStartExamManager().onNewInstanceCreated(userContext, (StartExam)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingStartExam(BcexUserContext userContext, String wechatUserId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfStartExam(startExamId);
		checkerOf(userContext).checkVersionOfStartExam(startExamVersion);
		

		if(StartExam.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfStartExam(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateStartExam(BcexUserContext userContext, String wechatUserId, String startExamId, int startExamVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingStartExam(userContext, wechatUserId, startExamId, startExamVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withStartExamList().searchStartExamListWith(StartExam.ID_PROPERTY, "eq", startExamId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeStartExam( startExam );	
			//make changes to AcceleraterAccount.
			StartExam startExamIndex = createIndexedStartExam(startExamId, startExamVersion);
		
			StartExam startExam = wechatUser.findTheStartExam(startExamIndex);
			if(startExam == null){
				throw new WechatUserManagerException(startExam+" is NOT FOUND" );
			}
			
			startExam.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withStartExamList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingAnswerQuestion(BcexUserContext userContext, String wechatUserId, String nickName, String userAnswerId, String answer, String changeRequestId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkNickNameOfAnswerQuestion(nickName);
		
		checkerOf(userContext).checkUserAnswerIdOfAnswerQuestion(userAnswerId);
		
		checkerOf(userContext).checkAnswerOfAnswerQuestion(answer);
		
		checkerOf(userContext).checkChangeRequestIdOfAnswerQuestion(changeRequestId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addAnswerQuestion(BcexUserContext userContext, String wechatUserId, String nickName, String userAnswerId, String answer, String changeRequestId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAnswerQuestion(userContext,wechatUserId,nickName, userAnswerId, answer, changeRequestId,tokensExpr);
		
		AnswerQuestion answerQuestion = createAnswerQuestion(userContext,nickName, userAnswerId, answer, changeRequestId);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addAnswerQuestion( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, answerQuestion);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAnswerQuestionProperties(BcexUserContext userContext, String wechatUserId,String id,String nickName,String answer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(id);
		
		checkerOf(userContext).checkNickNameOfAnswerQuestion( nickName);
		checkerOf(userContext).checkAnswerOfAnswerQuestion( answer);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateAnswerQuestionProperties(BcexUserContext userContext, String wechatUserId, String id,String nickName,String answer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAnswerQuestionProperties(userContext,wechatUserId,id,nickName,answer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAnswerQuestionListList()
				.searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getAnswerQuestionList().isEmpty()){
			throw new WechatUserManagerException("AnswerQuestion is NOT FOUND with id: '"+id+"'");
		}
		
		AnswerQuestion item = wechatUserToUpdate.getAnswerQuestionList().first();
		
		item.updateNickName( nickName );
		item.updateAnswer( answer );

		
		//checkParamsForAddingAnswerQuestion(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withAnswerQuestionList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected AnswerQuestion createAnswerQuestion(BcexUserContext userContext, String nickName, String userAnswerId, String answer, String changeRequestId) throws Exception{

		AnswerQuestion answerQuestion = new AnswerQuestion();
		
		
		answerQuestion.setNickName(nickName);		
		UserAnswer  userAnswer = new UserAnswer();
		userAnswer.setId(userAnswerId);		
		answerQuestion.setUserAnswer(userAnswer);		
		answerQuestion.setAnswer(answer);		
		ChangeRequest  changeRequest = new ChangeRequest();
		changeRequest.setId(changeRequestId);		
		answerQuestion.setChangeRequest(changeRequest);
	
		
		return answerQuestion;
	
		
	}
	
	protected AnswerQuestion createIndexedAnswerQuestion(String id, int version){

		AnswerQuestion answerQuestion = new AnswerQuestion();
		answerQuestion.setId(id);
		answerQuestion.setVersion(version);
		return answerQuestion;			
		
	}
	
	protected void checkParamsForRemovingAnswerQuestionList(BcexUserContext userContext, String wechatUserId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String answerQuestionIdItem: answerQuestionIds){
			checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeAnswerQuestionList(BcexUserContext userContext, String wechatUserId, 
			String answerQuestionIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAnswerQuestionList(userContext, wechatUserId,  answerQuestionIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveAnswerQuestionList(wechatUser, answerQuestionIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
				deleteRelationListInGraph(userContext, wechatUser.getAnswerQuestionList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAnswerQuestion(userContext,wechatUserId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeAnswerQuestion( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			deleteRelationInGraph(userContext, answerQuestion);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAnswerQuestion(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyAnswerQuestionFrom(BcexUserContext userContext, String wechatUserId, 
		String answerQuestionId, int answerQuestionVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAnswerQuestion(userContext,wechatUserId, answerQuestionId, answerQuestionVersion,tokensExpr);
		
		AnswerQuestion answerQuestion = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyAnswerQuestionFrom( answerQuestion );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			
			userContext.getManagerGroup().getAnswerQuestionManager().onNewInstanceCreated(userContext, (AnswerQuestion)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfAnswerQuestion(answerQuestionId);
		checkerOf(userContext).checkVersionOfAnswerQuestion(answerQuestionVersion);
		

		if(AnswerQuestion.NICK_NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNickNameOfAnswerQuestion(parseString(newValueExpr));
		}
		
		if(AnswerQuestion.ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkAnswerOfAnswerQuestion(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateAnswerQuestion(BcexUserContext userContext, String wechatUserId, String answerQuestionId, int answerQuestionVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAnswerQuestion(userContext, wechatUserId, answerQuestionId, answerQuestionVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAnswerQuestionList().searchAnswerQuestionListWith(AnswerQuestion.ID_PROPERTY, "eq", answerQuestionId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeAnswerQuestion( answerQuestion );	
			//make changes to AcceleraterAccount.
			AnswerQuestion answerQuestionIndex = createIndexedAnswerQuestion(answerQuestionId, answerQuestionVersion);
		
			AnswerQuestion answerQuestion = wechatUser.findTheAnswerQuestion(answerQuestionIndex);
			if(answerQuestion == null){
				throw new WechatUserManagerException(answerQuestion+" is NOT FOUND" );
			}
			
			answerQuestion.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withAnswerQuestionList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String appId, String openId, String sessionKey,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkAppIdOfWechatLoginInfo(appId);
		
		checkerOf(userContext).checkOpenIdOfWechatLoginInfo(openId);
		
		checkerOf(userContext).checkSessionKeyOfWechatLoginInfo(sessionKey);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String appId, String openId, String sessionKey, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingWechatLoginInfo(userContext,wechatUserId,appId, openId, sessionKey,tokensExpr);
		
		WechatLoginInfo wechatLoginInfo = createWechatLoginInfo(userContext,appId, openId, sessionKey);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addWechatLoginInfo( wechatLoginInfo );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
			
			userContext.getManagerGroup().getWechatLoginInfoManager().onNewInstanceCreated(userContext, wechatLoginInfo);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingWechatLoginInfoProperties(BcexUserContext userContext, String wechatUserId,String id,String appId,String openId,String sessionKey,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfWechatLoginInfo(id);
		
		checkerOf(userContext).checkAppIdOfWechatLoginInfo( appId);
		checkerOf(userContext).checkOpenIdOfWechatLoginInfo( openId);
		checkerOf(userContext).checkSessionKeyOfWechatLoginInfo( sessionKey);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateWechatLoginInfoProperties(BcexUserContext userContext, String wechatUserId, String id,String appId,String openId,String sessionKey, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingWechatLoginInfoProperties(userContext,wechatUserId,id,appId,openId,sessionKey,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withWechatLoginInfoListList()
				.searchWechatLoginInfoListWith(WechatLoginInfo.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getWechatLoginInfoList().isEmpty()){
			throw new WechatUserManagerException("WechatLoginInfo is NOT FOUND with id: '"+id+"'");
		}
		
		WechatLoginInfo item = wechatUserToUpdate.getWechatLoginInfoList().first();
		
		item.updateAppId( appId );
		item.updateOpenId( openId );
		item.updateSessionKey( sessionKey );

		
		//checkParamsForAddingWechatLoginInfo(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withWechatLoginInfoList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected WechatLoginInfo createWechatLoginInfo(BcexUserContext userContext, String appId, String openId, String sessionKey) throws Exception{

		WechatLoginInfo wechatLoginInfo = new WechatLoginInfo();
		
		
		wechatLoginInfo.setAppId(appId);		
		wechatLoginInfo.setOpenId(openId);		
		wechatLoginInfo.setSessionKey(sessionKey);		
		wechatLoginInfo.setLastUpdateTime(userContext.now());
	
		
		return wechatLoginInfo;
	
		
	}
	
	protected WechatLoginInfo createIndexedWechatLoginInfo(String id, int version){

		WechatLoginInfo wechatLoginInfo = new WechatLoginInfo();
		wechatLoginInfo.setId(id);
		wechatLoginInfo.setVersion(version);
		return wechatLoginInfo;			
		
	}
	
	protected void checkParamsForRemovingWechatLoginInfoList(BcexUserContext userContext, String wechatUserId, 
			String wechatLoginInfoIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String wechatLoginInfoIdItem: wechatLoginInfoIds){
			checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeWechatLoginInfoList(BcexUserContext userContext, String wechatUserId, 
			String wechatLoginInfoIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingWechatLoginInfoList(userContext, wechatUserId,  wechatLoginInfoIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveWechatLoginInfoList(wechatUser, wechatLoginInfoIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
				deleteRelationListInGraph(userContext, wechatUser.getWechatLoginInfoList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingWechatLoginInfo(BcexUserContext userContext, String wechatUserId, 
		String wechatLoginInfoId, int wechatLoginInfoVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).checkVersionOfWechatLoginInfo(wechatLoginInfoVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeWechatLoginInfo(BcexUserContext userContext, String wechatUserId, 
		String wechatLoginInfoId, int wechatLoginInfoVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingWechatLoginInfo(userContext,wechatUserId, wechatLoginInfoId, wechatLoginInfoVersion,tokensExpr);
		
		WechatLoginInfo wechatLoginInfo = createIndexedWechatLoginInfo(wechatLoginInfoId, wechatLoginInfoVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeWechatLoginInfo( wechatLoginInfo );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
			deleteRelationInGraph(userContext, wechatLoginInfo);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingWechatLoginInfo(BcexUserContext userContext, String wechatUserId, 
		String wechatLoginInfoId, int wechatLoginInfoVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).checkVersionOfWechatLoginInfo(wechatLoginInfoVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyWechatLoginInfoFrom(BcexUserContext userContext, String wechatUserId, 
		String wechatLoginInfoId, int wechatLoginInfoVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingWechatLoginInfo(userContext,wechatUserId, wechatLoginInfoId, wechatLoginInfoVersion,tokensExpr);
		
		WechatLoginInfo wechatLoginInfo = createIndexedWechatLoginInfo(wechatLoginInfoId, wechatLoginInfoVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			wechatLoginInfo.updateLastUpdateTime(userContext.now());
			
			wechatUser.copyWechatLoginInfoFrom( wechatLoginInfo );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
			
			userContext.getManagerGroup().getWechatLoginInfoManager().onNewInstanceCreated(userContext, (WechatLoginInfo)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfWechatLoginInfo(wechatLoginInfoId);
		checkerOf(userContext).checkVersionOfWechatLoginInfo(wechatLoginInfoVersion);
		

		if(WechatLoginInfo.APP_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkAppIdOfWechatLoginInfo(parseString(newValueExpr));
		}
		
		if(WechatLoginInfo.OPEN_ID_PROPERTY.equals(property)){
			checkerOf(userContext).checkOpenIdOfWechatLoginInfo(parseString(newValueExpr));
		}
		
		if(WechatLoginInfo.SESSION_KEY_PROPERTY.equals(property)){
			checkerOf(userContext).checkSessionKeyOfWechatLoginInfo(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingWechatLoginInfo(userContext, wechatUserId, wechatLoginInfoId, wechatLoginInfoVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withWechatLoginInfoList().searchWechatLoginInfoListWith(WechatLoginInfo.ID_PROPERTY, "eq", wechatLoginInfoId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeWechatLoginInfo( wechatLoginInfo );	
			//make changes to AcceleraterAccount.
			WechatLoginInfo wechatLoginInfoIndex = createIndexedWechatLoginInfo(wechatLoginInfoId, wechatLoginInfoVersion);
		
			WechatLoginInfo wechatLoginInfo = wechatUser.findTheWechatLoginInfo(wechatLoginInfoIndex);
			if(wechatLoginInfo == null){
				throw new WechatUserManagerException(wechatLoginInfo+" is NOT FOUND" );
			}
			
			wechatLoginInfo.changeProperty(property, newValueExpr);
			wechatLoginInfo.updateLastUpdateTime(userContext.now());
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withWechatLoginInfoList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingExam(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkNameOfExam(name);
		
		checkerOf(userContext).checkStatusIdOfExam(statusId);
		
		checkerOf(userContext).checkScoreOfExam(score);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addExam(BcexUserContext userContext, String wechatUserId, String name, String statusId, int score, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExam(userContext,wechatUserId,name, statusId, score,tokensExpr);
		
		Exam exam = createExam(userContext,name, statusId, score);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addExam( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, exam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExamProperties(BcexUserContext userContext, String wechatUserId,String id,String name,int score,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfExam(id);
		
		checkerOf(userContext).checkNameOfExam( name);
		checkerOf(userContext).checkScoreOfExam( score);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateExamProperties(BcexUserContext userContext, String wechatUserId, String id,String name,int score, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExamProperties(userContext,wechatUserId,id,name,score,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExamListList()
				.searchExamListWith(Exam.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getExamList().isEmpty()){
			throw new WechatUserManagerException("Exam is NOT FOUND with id: '"+id+"'");
		}
		
		Exam item = wechatUserToUpdate.getExamList().first();
		
		item.updateName( name );
		item.updateScore( score );

		
		//checkParamsForAddingExam(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withExamList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Exam createExam(BcexUserContext userContext, String name, String statusId, int score) throws Exception{

		Exam exam = new Exam();
		
		
		exam.setName(name);		
		exam.setCreateTime(userContext.now());		
		ExamStatus  status = new ExamStatus();
		status.setId(statusId);		
		exam.setStatus(status);		
		exam.setScore(score);
	
		
		return exam;
	
		
	}
	
	protected Exam createIndexedExam(String id, int version){

		Exam exam = new Exam();
		exam.setId(id);
		exam.setVersion(version);
		return exam;			
		
	}
	
	protected void checkParamsForRemovingExamList(BcexUserContext userContext, String wechatUserId, 
			String examIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String examIdItem: examIds){
			checkerOf(userContext).checkIdOfExam(examIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeExamList(BcexUserContext userContext, String wechatUserId, 
			String examIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExamList(userContext, wechatUserId,  examIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveExamList(wechatUser, examIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
				deleteRelationListInGraph(userContext, wechatUser.getExamList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExam(userContext,wechatUserId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeExam( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			deleteRelationInGraph(userContext, exam);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExam(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyExamFrom(BcexUserContext userContext, String wechatUserId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExam(userContext,wechatUserId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyExamFrom( exam );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, (Exam)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		

		if(Exam.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExam(parseString(newValueExpr));
		}
		
		if(Exam.SCORE_PROPERTY.equals(property)){
			checkerOf(userContext).checkScoreOfExam(parseInt(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateExam(BcexUserContext userContext, String wechatUserId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExam(userContext, wechatUserId, examId, examVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExamList().searchExamListWith(Exam.ID_PROPERTY, "eq", examId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeExam( exam );	
			//make changes to AcceleraterAccount.
			Exam examIndex = createIndexedExam(examId, examVersion);
		
			Exam exam = wechatUser.findTheExam(examIndex);
			if(exam == null){
				throw new WechatUserManagerException(exam+" is NOT FOUND" );
			}
			
			exam.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withExamList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFaultAnswer(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String questionId, int faultTimes,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfWechatUser(wechatUserId);

		
		checkerOf(userContext).checkTopicOfFaultAnswer(topic);
		
		checkerOf(userContext).checkYourAnswerOfFaultAnswer(yourAnswer);
		
		checkerOf(userContext).checkRightAnswerOfFaultAnswer(rightAnswer);
		
		checkerOf(userContext).checkQuestionIdOfFaultAnswer(questionId);
		
		checkerOf(userContext).checkFaultTimesOfFaultAnswer(faultTimes);
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);

	
	}
	public  WechatUser addFaultAnswer(BcexUserContext userContext, String wechatUserId, String topic, String yourAnswer, String rightAnswer, String questionId, int faultTimes, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFaultAnswer(userContext,wechatUserId,topic, yourAnswer, rightAnswer, questionId, faultTimes,tokensExpr);
		
		FaultAnswer faultAnswer = createFaultAnswer(userContext,topic, yourAnswer, rightAnswer, questionId, faultTimes);
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.addFaultAnswer( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, faultAnswer);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFaultAnswerProperties(BcexUserContext userContext, String wechatUserId,String id,String topic,String yourAnswer,String rightAnswer,int faultTimes,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(id);
		
		checkerOf(userContext).checkTopicOfFaultAnswer( topic);
		checkerOf(userContext).checkYourAnswerOfFaultAnswer( yourAnswer);
		checkerOf(userContext).checkRightAnswerOfFaultAnswer( rightAnswer);
		checkerOf(userContext).checkFaultTimesOfFaultAnswer( faultTimes);

		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser updateFaultAnswerProperties(BcexUserContext userContext, String wechatUserId, String id,String topic,String yourAnswer,String rightAnswer,int faultTimes, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFaultAnswerProperties(userContext,wechatUserId,id,topic,yourAnswer,rightAnswer,faultTimes,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFaultAnswerListList()
				.searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "is", id).done();
		
		WechatUser wechatUserToUpdate = loadWechatUser(userContext, wechatUserId, options);
		
		if(wechatUserToUpdate.getFaultAnswerList().isEmpty()){
			throw new WechatUserManagerException("FaultAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		FaultAnswer item = wechatUserToUpdate.getFaultAnswerList().first();
		
		item.updateTopic( topic );
		item.updateYourAnswer( yourAnswer );
		item.updateRightAnswer( rightAnswer );
		item.updateFaultTimes( faultTimes );

		
		//checkParamsForAddingFaultAnswer(userContext,wechatUserId,name, code, used,tokensExpr);
		WechatUser wechatUser = saveWechatUser(userContext, wechatUserToUpdate, tokens().withFaultAnswerList().done());
		synchronized(wechatUser){ 
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FaultAnswer createFaultAnswer(BcexUserContext userContext, String topic, String yourAnswer, String rightAnswer, String questionId, int faultTimes) throws Exception{

		FaultAnswer faultAnswer = new FaultAnswer();
		
		
		faultAnswer.setTopic(topic);		
		faultAnswer.setYourAnswer(yourAnswer);		
		faultAnswer.setRightAnswer(rightAnswer);		
		faultAnswer.setCreateTime(userContext.now());		
		Question  question = new Question();
		question.setId(questionId);		
		faultAnswer.setQuestion(question);		
		faultAnswer.setFaultTimes(faultTimes);
	
		
		return faultAnswer;
	
		
	}
	
	protected FaultAnswer createIndexedFaultAnswer(String id, int version){

		FaultAnswer faultAnswer = new FaultAnswer();
		faultAnswer.setId(id);
		faultAnswer.setVersion(version);
		return faultAnswer;			
		
	}
	
	protected void checkParamsForRemovingFaultAnswerList(BcexUserContext userContext, String wechatUserId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		for(String faultAnswerIdItem: faultAnswerIds){
			checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
		
	}
	public  WechatUser removeFaultAnswerList(BcexUserContext userContext, String wechatUserId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFaultAnswerList(userContext, wechatUserId,  faultAnswerIds, tokensExpr);
			
			
			WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
			synchronized(wechatUser){ 
				//Will be good when the wechatUser loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				wechatUserDaoOf(userContext).planToRemoveFaultAnswerList(wechatUser, faultAnswerIds, allTokens());
				wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
				deleteRelationListInGraph(userContext, wechatUser.getFaultAnswerList());
				return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser removeFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFaultAnswer(userContext,wechatUserId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			wechatUser.removeFaultAnswer( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			deleteRelationInGraph(userContext, faultAnswer);
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFaultAnswer(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfWechatUser( wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	public  WechatUser copyFaultAnswerFrom(BcexUserContext userContext, String wechatUserId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFaultAnswer(userContext,wechatUserId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, allTokens());
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			wechatUser.copyFaultAnswerFrom( faultAnswer );		
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, (FaultAnswer)wechatUser.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfWechatUser(wechatUserId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		

		if(FaultAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfFaultAnswer(parseString(newValueExpr));
		}
		
		if(FaultAnswer.YOUR_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkYourAnswerOfFaultAnswer(parseString(newValueExpr));
		}
		
		if(FaultAnswer.RIGHT_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkRightAnswerOfFaultAnswer(parseString(newValueExpr));
		}
		
		if(FaultAnswer.FAULT_TIMES_PROPERTY.equals(property)){
			checkerOf(userContext).checkFaultTimesOfFaultAnswer(parseInt(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(WechatUserManagerException.class);
	
	}
	
	public  WechatUser updateFaultAnswer(BcexUserContext userContext, String wechatUserId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFaultAnswer(userContext, wechatUserId, faultAnswerId, faultAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFaultAnswerList().searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "eq", faultAnswerId).done();
		
		
		
		WechatUser wechatUser = loadWechatUser(userContext, wechatUserId, loadTokens);
		
		synchronized(wechatUser){ 
			//Will be good when the wechatUser loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//wechatUser.removeFaultAnswer( faultAnswer );	
			//make changes to AcceleraterAccount.
			FaultAnswer faultAnswerIndex = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		
			FaultAnswer faultAnswer = wechatUser.findTheFaultAnswer(faultAnswerIndex);
			if(faultAnswer == null){
				throw new WechatUserManagerException(faultAnswer+" is NOT FOUND" );
			}
			
			faultAnswer.changeProperty(property, newValueExpr);
			
			wechatUser = saveWechatUser(userContext, wechatUser, tokens().withFaultAnswerList().done());
			return present(userContext,wechatUser, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, WechatUser newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


