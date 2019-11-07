
package com.doublechaintech.bcex.examstatus;

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
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.platform.CandidatePlatform;

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.wechatuser.WechatUser;






public class ExamStatusManagerImpl extends CustomBcexCheckerManager implements ExamStatusManager {
	
	private static final String SERVICE_TYPE = "ExamStatus";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ExamStatusManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ExamStatusManagerException(message);

	}
	
	

 	protected ExamStatus saveExamStatus(BcexUserContext userContext, ExamStatus examStatus, String [] tokensExpr) throws Exception{	
 		//return getExamStatusDAO().save(examStatus, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveExamStatus(userContext, examStatus, tokens);
 	}
 	
 	protected ExamStatus saveExamStatusDetail(BcexUserContext userContext, ExamStatus examStatus) throws Exception{	

 		
 		return saveExamStatus(userContext, examStatus, allTokens());
 	}
 	
 	public ExamStatus loadExamStatus(BcexUserContext userContext, String examStatusId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamStatusManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		ExamStatus examStatus = loadExamStatus( userContext, examStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,examStatus, tokens);
 	}
 	
 	
 	 public ExamStatus searchExamStatus(BcexUserContext userContext, String examStatusId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamStatusManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		ExamStatus examStatus = loadExamStatus( userContext, examStatusId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,examStatus, tokens);
 	}
 	
 	

 	protected ExamStatus present(BcexUserContext userContext, ExamStatus examStatus, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,examStatus,tokens);
		
		
		ExamStatus  examStatusToPresent = examStatusDaoOf(userContext).present(examStatus, tokens);
		
		List<BaseEntity> entityListToNaming = examStatusToPresent.collectRefercencesFromLists();
		examStatusDaoOf(userContext).alias(entityListToNaming);
		
		return  examStatusToPresent;
		
		
	}
 
 	
 	
 	public ExamStatus loadExamStatusDetail(BcexUserContext userContext, String examStatusId) throws Exception{	
 		ExamStatus examStatus = loadExamStatus( userContext, examStatusId, allTokens());
 		return present(userContext,examStatus, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String examStatusId) throws Exception{	
 		ExamStatus examStatus = loadExamStatus( userContext, examStatusId, viewTokens());
 		return present(userContext,examStatus, allTokens());
		
 	}
 	protected ExamStatus saveExamStatus(BcexUserContext userContext, ExamStatus examStatus, Map<String,Object>tokens) throws Exception{	
 		return examStatusDaoOf(userContext).save(examStatus, tokens);
 	}
 	protected ExamStatus loadExamStatus(BcexUserContext userContext, String examStatusId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamStatusManagerException.class);

 
 		return examStatusDaoOf(userContext).load(examStatusId, tokens);
 	}

	
	

	public ExamStatus loadExamStatusWithCode(BcexUserContext userContext, String code, Map<String,Object>tokens) throws Exception{	
 		return examStatusDaoOf(userContext).loadByCode(code, tokens);
 	}

	 


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ExamStatus examStatus, Map<String, Object> tokens){
		super.addActions(userContext, examStatus, tokens);
		
		addAction(userContext, examStatus, tokens,"@create","createExamStatus","createExamStatus/","main","primary");
		addAction(userContext, examStatus, tokens,"@update","updateExamStatus","updateExamStatus/"+examStatus.getId()+"/","main","primary");
		addAction(userContext, examStatus, tokens,"@copy","cloneExamStatus","cloneExamStatus/"+examStatus.getId()+"/","main","primary");
		
		addAction(userContext, examStatus, tokens,"exam_status.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+examStatus.getId()+"/","main","primary");
		addAction(userContext, examStatus, tokens,"exam_status.addExam","addExam","addExam/"+examStatus.getId()+"/","examList","primary");
		addAction(userContext, examStatus, tokens,"exam_status.removeExam","removeExam","removeExam/"+examStatus.getId()+"/","examList","primary");
		addAction(userContext, examStatus, tokens,"exam_status.updateExam","updateExam","updateExam/"+examStatus.getId()+"/","examList","primary");
		addAction(userContext, examStatus, tokens,"exam_status.copyExamFrom","copyExamFrom","copyExamFrom/"+examStatus.getId()+"/","examList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, ExamStatus examStatus, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public ExamStatus createExamStatus(BcexUserContext userContext,String name, String code, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfExamStatus(name);
		checkerOf(userContext).checkCodeOfExamStatus(code);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);


		ExamStatus examStatus=createNewExamStatus();	

		examStatus.setName(name);
		examStatus.setCode(code);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		examStatus.setPlatform(platform);
		
		

		examStatus = saveExamStatus(userContext, examStatus, emptyOptions());
		
		onNewInstanceCreated(userContext, examStatus);
		return examStatus;

		
	}
	protected ExamStatus createNewExamStatus() 
	{
		
		return new ExamStatus();		
	}
	
	protected void checkParamsForUpdatingExamStatus(BcexUserContext userContext,String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkVersionOfExamStatus( examStatusVersion);
		

		if(ExamStatus.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExamStatus(parseString(newValueExpr));
		}
		if(ExamStatus.CODE_PROPERTY.equals(property)){
			checkerOf(userContext).checkCodeOfExamStatus(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
	
		
	}
	
	
	
	public ExamStatus clone(BcexUserContext userContext, String fromExamStatusId) throws Exception{
		
		return examStatusDaoOf(userContext).clone(fromExamStatusId, this.allTokens());
	}
	
	public ExamStatus internalSaveExamStatus(BcexUserContext userContext, ExamStatus examStatus) throws Exception 
	{
		return internalSaveExamStatus(userContext, examStatus, allTokens());

	}
	public ExamStatus internalSaveExamStatus(BcexUserContext userContext, ExamStatus examStatus, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingExamStatus(userContext, examStatusId, examStatusVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(examStatus){ 
			//will be good when the examStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamStatus.
			if (examStatus.isChanged()){
			
			}
			examStatus = saveExamStatus(userContext, examStatus, options);
			return examStatus;
			
		}

	}
	
	public ExamStatus updateExamStatus(BcexUserContext userContext,String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExamStatus(userContext, examStatusId, examStatusVersion, property, newValueExpr, tokensExpr);
		
		
		
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
		if(examStatus.getVersion() != examStatusVersion){
			String message = "The target version("+examStatus.getVersion()+") is not equals to version("+examStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(examStatus){ 
			//will be good when the examStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamStatus.
			
			examStatus.changeProperty(property, newValueExpr);
			examStatus = saveExamStatus(userContext, examStatus, tokens().done());
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
			//return saveExamStatus(userContext, examStatus, tokens().done());
		}

	}
	
	public ExamStatus updateExamStatusProperty(BcexUserContext userContext,String examStatusId, int examStatusVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExamStatus(userContext, examStatusId, examStatusVersion, property, newValueExpr, tokensExpr);
		
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
		if(examStatus.getVersion() != examStatusVersion){
			String message = "The target version("+examStatus.getVersion()+") is not equals to version("+examStatusVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(examStatus){ 
			//will be good when the examStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to ExamStatus.
			
			examStatus.changeProperty(property, newValueExpr);
			
			examStatus = saveExamStatus(userContext, examStatus, tokens().done());
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
			//return saveExamStatus(userContext, examStatus, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ExamStatusTokens tokens(){
		return ExamStatusTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ExamStatusTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortExamListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ExamStatusTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String examStatusId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
 		
 	}
 	public ExamStatus transferToAnotherPlatform(BcexUserContext userContext, String examStatusId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, examStatusId,anotherPlatformId);
 
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());	
		synchronized(examStatus){
			//will be good when the examStatus loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			examStatus.updatePlatform(platform);		
			examStatus = saveExamStatus(userContext, examStatus, emptyOptions());
			
			return present(userContext,examStatus, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForExamStatus(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String examStatusId, int examStatusVersion) throws Exception {
		//deleteInternal(userContext, examStatusId, examStatusVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String examStatusId, int examStatusVersion) throws Exception{
			
		examStatusDaoOf(userContext).delete(examStatusId, examStatusVersion);
	}
	
	public ExamStatus forgetByAll(BcexUserContext userContext, String examStatusId, int examStatusVersion) throws Exception {
		return forgetByAllInternal(userContext, examStatusId, examStatusVersion);		
	}
	protected ExamStatus forgetByAllInternal(BcexUserContext userContext,
			String examStatusId, int examStatusVersion) throws Exception{
			
		return examStatusDaoOf(userContext).disconnectFromAll(examStatusId, examStatusVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ExamStatusManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return examStatusDaoOf(userContext).deleteAll();
	}


	//disconnect ExamStatus with user in Exam
	protected ExamStatus breakWithExamByUser(BcexUserContext userContext, String examStatusId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());

			synchronized(examStatus){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				examStatusDaoOf(userContext).planToRemoveExamListWithUser(examStatus, userId, this.emptyOptions());

				examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
				return examStatus;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingExam(BcexUserContext userContext, String examStatusId, String name, String userId, int score,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfExamStatus(examStatusId);

		
		checkerOf(userContext).checkNameOfExam(name);
		
		checkerOf(userContext).checkUserIdOfExam(userId);
		
		checkerOf(userContext).checkScoreOfExam(score);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);

	
	}
	public  ExamStatus addExam(BcexUserContext userContext, String examStatusId, String name, String userId, int score, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingExam(userContext,examStatusId,name, userId, score,tokensExpr);
		
		Exam exam = createExam(userContext,name, userId, score);
		
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
		synchronized(examStatus){ 
			//Will be good when the examStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			examStatus.addExam( exam );		
			examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, exam);
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingExamProperties(BcexUserContext userContext, String examStatusId,String id,String name,int score,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkIdOfExam(id);
		
		checkerOf(userContext).checkNameOfExam( name);
		checkerOf(userContext).checkScoreOfExam( score);

		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
		
	}
	public  ExamStatus updateExamProperties(BcexUserContext userContext, String examStatusId, String id,String name,int score, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingExamProperties(userContext,examStatusId,id,name,score,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withExamListList()
				.searchExamListWith(Exam.ID_PROPERTY, "is", id).done();
		
		ExamStatus examStatusToUpdate = loadExamStatus(userContext, examStatusId, options);
		
		if(examStatusToUpdate.getExamList().isEmpty()){
			throw new ExamStatusManagerException("Exam is NOT FOUND with id: '"+id+"'");
		}
		
		Exam item = examStatusToUpdate.getExamList().first();
		
		item.updateName( name );
		item.updateScore( score );

		
		//checkParamsForAddingExam(userContext,examStatusId,name, code, used,tokensExpr);
		ExamStatus examStatus = saveExamStatus(userContext, examStatusToUpdate, tokens().withExamList().done());
		synchronized(examStatus){ 
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Exam createExam(BcexUserContext userContext, String name, String userId, int score) throws Exception{

		Exam exam = new Exam();
		
		
		exam.setName(name);		
		exam.setCreateTime(userContext.now());		
		WechatUser  user = new WechatUser();
		user.setId(userId);		
		exam.setUser(user);		
		exam.setScore(score);
	
		
		return exam;
	
		
	}
	
	protected Exam createIndexedExam(String id, int version){

		Exam exam = new Exam();
		exam.setId(id);
		exam.setVersion(version);
		return exam;			
		
	}
	
	protected void checkParamsForRemovingExamList(BcexUserContext userContext, String examStatusId, 
			String examIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		for(String examIdItem: examIds){
			checkerOf(userContext).checkIdOfExam(examIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
		
	}
	public  ExamStatus removeExamList(BcexUserContext userContext, String examStatusId, 
			String examIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingExamList(userContext, examStatusId,  examIds, tokensExpr);
			
			
			ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
			synchronized(examStatus){ 
				//Will be good when the examStatus loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				examStatusDaoOf(userContext).planToRemoveExamList(examStatus, examIds, allTokens());
				examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
				deleteRelationListInGraph(userContext, examStatus.getExamList());
				return present(userContext,examStatus, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingExam(BcexUserContext userContext, String examStatusId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExamStatus( examStatusId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
	
	}
	public  ExamStatus removeExam(BcexUserContext userContext, String examStatusId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingExam(userContext,examStatusId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
		synchronized(examStatus){ 
			//Will be good when the examStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			examStatus.removeExam( exam );		
			examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
			deleteRelationInGraph(userContext, exam);
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingExam(BcexUserContext userContext, String examStatusId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExamStatus( examStatusId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
	
	}
	public  ExamStatus copyExamFrom(BcexUserContext userContext, String examStatusId, 
		String examId, int examVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingExam(userContext,examStatusId, examId, examVersion,tokensExpr);
		
		Exam exam = createIndexedExam(examId, examVersion);
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, allTokens());
		synchronized(examStatus){ 
			//Will be good when the examStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			examStatus.copyExamFrom( exam );		
			examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
			
			userContext.getManagerGroup().getExamManager().onNewInstanceCreated(userContext, (Exam)examStatus.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingExam(BcexUserContext userContext, String examStatusId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfExamStatus(examStatusId);
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam(examVersion);
		

		if(Exam.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExam(parseString(newValueExpr));
		}
		
		if(Exam.SCORE_PROPERTY.equals(property)){
			checkerOf(userContext).checkScoreOfExam(parseInt(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamStatusManagerException.class);
	
	}
	
	public  ExamStatus updateExam(BcexUserContext userContext, String examStatusId, String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingExam(userContext, examStatusId, examId, examVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withExamList().searchExamListWith(Exam.ID_PROPERTY, "eq", examId).done();
		
		
		
		ExamStatus examStatus = loadExamStatus(userContext, examStatusId, loadTokens);
		
		synchronized(examStatus){ 
			//Will be good when the examStatus loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//examStatus.removeExam( exam );	
			//make changes to AcceleraterAccount.
			Exam examIndex = createIndexedExam(examId, examVersion);
		
			Exam exam = examStatus.findTheExam(examIndex);
			if(exam == null){
				throw new ExamStatusManagerException(exam+" is NOT FOUND" );
			}
			
			exam.changeProperty(property, newValueExpr);
			
			examStatus = saveExamStatus(userContext, examStatus, tokens().withExamList().done());
			return present(userContext,examStatus, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, ExamStatus newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


