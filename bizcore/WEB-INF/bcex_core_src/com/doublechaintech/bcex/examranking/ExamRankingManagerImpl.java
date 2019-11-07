
package com.doublechaintech.bcex.examranking;

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

import com.doublechaintech.bcex.platform.Platform;

import com.doublechaintech.bcex.platform.CandidatePlatform;







public class ExamRankingManagerImpl extends CustomBcexCheckerManager implements ExamRankingManager {
	
	private static final String SERVICE_TYPE = "ExamRanking";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ExamRankingManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ExamRankingManagerException(message);

	}
	
	

 	protected ExamRanking saveExamRanking(BcexUserContext userContext, ExamRanking examRanking, String [] tokensExpr) throws Exception{	
 		//return getExamRankingDAO().save(examRanking, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveExamRanking(userContext, examRanking, tokens);
 	}
 	
 	protected ExamRanking saveExamRankingDetail(BcexUserContext userContext, ExamRanking examRanking) throws Exception{	

 		
 		return saveExamRanking(userContext, examRanking, allTokens());
 	}
 	
 	public ExamRanking loadExamRanking(BcexUserContext userContext, String examRankingId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamRankingManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExamRanking examRanking = loadExamRanking( userContext, examRankingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,examRanking, tokens);
 	}
 	
 	
 	 public ExamRanking searchExamRanking(BcexUserContext userContext, String examRankingId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamRankingManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExamRanking examRanking = loadExamRanking( userContext, examRankingId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,examRanking, tokens);
 	}
 	
 	

 	protected ExamRanking present(BcexUserContext userContext, ExamRanking examRanking, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,examRanking,tokens);
		
		
		ExamRanking  examRankingToPresent = examRankingDaoOf(userContext).present(examRanking, tokens);
		
		List<BaseEntity> entityListToNaming = examRankingToPresent.collectRefercencesFromLists();
		examRankingDaoOf(userContext).alias(entityListToNaming);
		
		return  examRankingToPresent;
		
		
	}
 
 	
 	
 	public ExamRanking loadExamRankingDetail(BcexUserContext userContext, String examRankingId) throws Exception{	
 		ExamRanking examRanking = loadExamRanking( userContext, examRankingId, allTokens());
 		return present(userContext,examRanking, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String examRankingId) throws Exception{	
 		ExamRanking examRanking = loadExamRanking( userContext, examRankingId, viewTokens());
 		return present(userContext,examRanking, allTokens());
		
 	}
 	protected ExamRanking saveExamRanking(BcexUserContext userContext, ExamRanking examRanking, Map<String,Object>tokens) throws Exception{	
 		return examRankingDaoOf(userContext).save(examRanking, tokens);
 	}
 	protected ExamRanking loadExamRanking(BcexUserContext userContext, String examRankingId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamRankingManagerException.class);

 
 		return examRankingDaoOf(userContext).load(examRankingId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ExamRanking examRanking, Map<String, Object> tokens){
		super.addActions(userContext, examRanking, tokens);
		
		addAction(userContext, examRanking, tokens,"@create","createExamRanking","createExamRanking/","main","primary");
		addAction(userContext, examRanking, tokens,"@update","updateExamRanking","updateExamRanking/"+examRanking.getId()+"/","main","primary");
		addAction(userContext, examRanking, tokens,"@copy","cloneExamRanking","cloneExamRanking/"+examRanking.getId()+"/","main","primary");
		
		addAction(userContext, examRanking, tokens,"exam_ranking.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+examRanking.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ExamRanking examRanking, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ExamRanking createExamRanking(BcexUserContext userContext,String name, String avatar, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfExamRanking(name);
		checkerOf(userContext).checkAvatarOfExamRanking(avatar);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamRankingManagerException.class);


		ExamRanking examRanking=createNewExamRanking();	

		examRanking.setName(name);
		examRanking.setAvatar(avatar);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		examRanking.setPlatform(platform);
		
		

		examRanking = saveExamRanking(userContext, examRanking, emptyOptions());
		
		onNewInstanceCreated(userContext, examRanking);
		return examRanking;

		
	}
	protected ExamRanking createNewExamRanking() 
	{
		
		return new ExamRanking();		
	}
	
	protected void checkParamsForUpdatingExamRanking(BcexUserContext userContext,String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
		checkerOf(userContext).checkVersionOfExamRanking( examRankingVersion);
		

		if(ExamRanking.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExamRanking(parseString(newValueExpr));
		}
		if(ExamRanking.AVATAR_PROPERTY.equals(property)){
			checkerOf(userContext).checkAvatarOfExamRanking(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamRankingManagerException.class);
	
		
	}
	
	
	
	public ExamRanking clone(BcexUserContext userContext, String fromExamRankingId) throws Exception{
		
		return examRankingDaoOf(userContext).clone(fromExamRankingId, this.allTokens());
	}
	
	public ExamRanking internalSaveExamRanking(BcexUserContext userContext, ExamRanking examRanking) throws Exception 
	{
		return internalSaveExamRanking(userContext, examRanking, allTokens());

	}
	public ExamRanking internalSaveExamRanking(BcexUserContext userContext, ExamRanking examRanking, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingExamRanking(userContext, examRankingId, examRankingVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(examRanking){ 
			//will be good when the examRanking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamRanking.
			if (examRanking.isChanged()){
			
			}
			examRanking = saveExamRanking(userContext, examRanking, options);
			return examRanking;
			
		}

	}
	
	public ExamRanking updateExamRanking(BcexUserContext userContext,String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExamRanking(userContext, examRankingId, examRankingVersion, property, newValueExpr, tokensExpr);
		
		
		
		ExamRanking examRanking = loadExamRanking(userContext, examRankingId, allTokens());
		if(examRanking.getVersion() != examRankingVersion){
			String message = "The target version("+examRanking.getVersion()+") is not equals to version("+examRankingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(examRanking){ 
			//will be good when the examRanking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamRanking.
			
			examRanking.changeProperty(property, newValueExpr);
			examRanking = saveExamRanking(userContext, examRanking, tokens().done());
			return present(userContext,examRanking, mergedAllTokens(tokensExpr));
			//return saveExamRanking(userContext, examRanking, tokens().done());
		}

	}
	
	public ExamRanking updateExamRankingProperty(BcexUserContext userContext,String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExamRanking(userContext, examRankingId, examRankingVersion, property, newValueExpr, tokensExpr);
		
		ExamRanking examRanking = loadExamRanking(userContext, examRankingId, allTokens());
		if(examRanking.getVersion() != examRankingVersion){
			String message = "The target version("+examRanking.getVersion()+") is not equals to version("+examRankingVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(examRanking){ 
			//will be good when the examRanking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamRanking.
			
			examRanking.changeProperty(property, newValueExpr);
			
			examRanking = saveExamRanking(userContext, examRanking, tokens().done());
			return present(userContext,examRanking, mergedAllTokens(tokensExpr));
			//return saveExamRanking(userContext, examRanking, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ExamRankingTokens tokens(){
		return ExamRankingTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ExamRankingTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ExamRankingTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String examRankingId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfExamRanking(examRankingId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExamRankingManagerException.class);
 		
 	}
 	public ExamRanking transferToAnotherPlatform(BcexUserContext userContext, String examRankingId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, examRankingId,anotherPlatformId);
 
		ExamRanking examRanking = loadExamRanking(userContext, examRankingId, allTokens());	
		synchronized(examRanking){
			//will be good when the examRanking loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			examRanking.updatePlatform(platform);		
			examRanking = saveExamRanking(userContext, examRanking, emptyOptions());
			
			return present(userContext,examRanking, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForExamRanking(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String examRankingId, int examRankingVersion) throws Exception {
		//deleteInternal(userContext, examRankingId, examRankingVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String examRankingId, int examRankingVersion) throws Exception{
			
		examRankingDaoOf(userContext).delete(examRankingId, examRankingVersion);
	}
	
	public ExamRanking forgetByAll(BcexUserContext userContext, String examRankingId, int examRankingVersion) throws Exception {
		return forgetByAllInternal(userContext, examRankingId, examRankingVersion);		
	}
	protected ExamRanking forgetByAllInternal(BcexUserContext userContext,
			String examRankingId, int examRankingVersion) throws Exception{
			
		return examRankingDaoOf(userContext).disconnectFromAll(examRankingId, examRankingVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ExamRankingManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return examRankingDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, ExamRanking newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


