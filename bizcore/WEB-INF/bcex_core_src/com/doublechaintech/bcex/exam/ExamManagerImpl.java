
package com.doublechaintech.bcex.exam;

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

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.examstatus.CandidateExamStatus;
import com.doublechaintech.bcex.wechatuser.CandidateWechatUser;

import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;






public class ExamManagerImpl extends CustomBcexCheckerManager implements ExamManager {
	
	private static final String SERVICE_TYPE = "Exam";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws ExamManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new ExamManagerException(message);

	}
	
	

 	protected Exam saveExam(BcexUserContext userContext, Exam exam, String [] tokensExpr) throws Exception{	
 		//return getExamDAO().save(exam, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveExam(userContext, exam, tokens);
 	}
 	
 	protected Exam saveExamDetail(BcexUserContext userContext, Exam exam) throws Exception{	

 		
 		return saveExam(userContext, exam, allTokens());
 	}
 	
 	public Exam loadExam(BcexUserContext userContext, String examId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Exam exam = loadExam( userContext, examId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,exam, tokens);
 	}
 	
 	
 	 public Exam searchExam(BcexUserContext userContext, String examId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Exam exam = loadExam( userContext, examId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,exam, tokens);
 	}
 	
 	

 	protected Exam present(BcexUserContext userContext, Exam exam, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,exam,tokens);
		
		
		Exam  examToPresent = examDaoOf(userContext).present(exam, tokens);
		
		List<BaseEntity> entityListToNaming = examToPresent.collectRefercencesFromLists();
		examDaoOf(userContext).alias(entityListToNaming);
		
		return  examToPresent;
		
		
	}
 
 	
 	
 	public Exam loadExamDetail(BcexUserContext userContext, String examId) throws Exception{	
 		Exam exam = loadExam( userContext, examId, allTokens());
 		return present(userContext,exam, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String examId) throws Exception{	
 		Exam exam = loadExam( userContext, examId, viewTokens());
 		return present(userContext,exam, allTokens());
		
 	}
 	protected Exam saveExam(BcexUserContext userContext, Exam exam, Map<String,Object>tokens) throws Exception{	
 		return examDaoOf(userContext).save(exam, tokens);
 	}
 	protected Exam loadExam(BcexUserContext userContext, String examId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).throwExceptionIfHasErrors( ExamManagerException.class);

 
 		return examDaoOf(userContext).load(examId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Exam exam, Map<String, Object> tokens){
		super.addActions(userContext, exam, tokens);
		
		addAction(userContext, exam, tokens,"@create","createExam","createExam/","main","primary");
		addAction(userContext, exam, tokens,"@update","updateExam","updateExam/"+exam.getId()+"/","main","primary");
		addAction(userContext, exam, tokens,"@copy","cloneExam","cloneExam/"+exam.getId()+"/","main","primary");
		
		addAction(userContext, exam, tokens,"exam.transfer_to_status","transferToAnotherStatus","transferToAnotherStatus/"+exam.getId()+"/","main","primary");
		addAction(userContext, exam, tokens,"exam.transfer_to_user","transferToAnotherUser","transferToAnotherUser/"+exam.getId()+"/","main","primary");
		addAction(userContext, exam, tokens,"exam.addUserAnswer","addUserAnswer","addUserAnswer/"+exam.getId()+"/","userAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.removeUserAnswer","removeUserAnswer","removeUserAnswer/"+exam.getId()+"/","userAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.updateUserAnswer","updateUserAnswer","updateUserAnswer/"+exam.getId()+"/","userAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.copyUserAnswerFrom","copyUserAnswerFrom","copyUserAnswerFrom/"+exam.getId()+"/","userAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.addFaultAnswer","addFaultAnswer","addFaultAnswer/"+exam.getId()+"/","faultAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.removeFaultAnswer","removeFaultAnswer","removeFaultAnswer/"+exam.getId()+"/","faultAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.updateFaultAnswer","updateFaultAnswer","updateFaultAnswer/"+exam.getId()+"/","faultAnswerList","primary");
		addAction(userContext, exam, tokens,"exam.copyFaultAnswerFrom","copyFaultAnswerFrom","copyFaultAnswerFrom/"+exam.getId()+"/","faultAnswerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Exam exam, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Exam createExam(BcexUserContext userContext,String name, String statusId, String userId, int score) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfExam(name);
		checkerOf(userContext).checkScoreOfExam(score);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);


		Exam exam=createNewExam();	

		exam.setName(name);
		exam.setCreateTime(userContext.now());
			
		ExamStatus status = loadExamStatus(userContext, statusId,emptyOptions());
		exam.setStatus(status);
		
		
			
		WechatUser user = loadWechatUser(userContext, userId,emptyOptions());
		exam.setUser(user);
		
		
		exam.setScore(score);

		exam = saveExam(userContext, exam, emptyOptions());
		
		onNewInstanceCreated(userContext, exam);
		return exam;

		
	}
	protected Exam createNewExam() 
	{
		
		return new Exam();		
	}
	
	protected void checkParamsForUpdatingExam(BcexUserContext userContext,String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkVersionOfExam( examVersion);
		

		if(Exam.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfExam(parseString(newValueExpr));
		}		

				

		
		if(Exam.SCORE_PROPERTY.equals(property)){
			checkerOf(userContext).checkScoreOfExam(parseInt(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
		
	}
	
	
	
	public Exam clone(BcexUserContext userContext, String fromExamId) throws Exception{
		
		return examDaoOf(userContext).clone(fromExamId, this.allTokens());
	}
	
	public Exam internalSaveExam(BcexUserContext userContext, Exam exam) throws Exception 
	{
		return internalSaveExam(userContext, exam, allTokens());

	}
	public Exam internalSaveExam(BcexUserContext userContext, Exam exam, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingExam(userContext, examId, examVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(exam){ 
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Exam.
			if (exam.isChanged()){
			
			}
			exam = saveExam(userContext, exam, options);
			return exam;
			
		}

	}
	
	public Exam updateExam(BcexUserContext userContext,String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExam(userContext, examId, examVersion, property, newValueExpr, tokensExpr);
		
		
		
		Exam exam = loadExam(userContext, examId, allTokens());
		if(exam.getVersion() != examVersion){
			String message = "The target version("+exam.getVersion()+") is not equals to version("+examVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(exam){ 
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Exam.
			
			exam.changeProperty(property, newValueExpr);
			exam = saveExam(userContext, exam, tokens().done());
			return present(userContext,exam, mergedAllTokens(tokensExpr));
			//return saveExam(userContext, exam, tokens().done());
		}

	}
	
	public Exam updateExamProperty(BcexUserContext userContext,String examId, int examVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingExam(userContext, examId, examVersion, property, newValueExpr, tokensExpr);
		
		Exam exam = loadExam(userContext, examId, allTokens());
		if(exam.getVersion() != examVersion){
			String message = "The target version("+exam.getVersion()+") is not equals to version("+examVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(exam){ 
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Exam.
			
			exam.changeProperty(property, newValueExpr);
			
			exam = saveExam(userContext, exam, tokens().done());
			return present(userContext,exam, mergedAllTokens(tokensExpr));
			//return saveExam(userContext, exam, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected ExamTokens tokens(){
		return ExamTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return ExamTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortUserAnswerListWith("id","desc")
		.sortFaultAnswerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return ExamTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherStatus(BcexUserContext userContext, String examId, String anotherStatusId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfExam(examId);
 		checkerOf(userContext).checkIdOfExamStatus(anotherStatusId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
 		
 	}
 	public Exam transferToAnotherStatus(BcexUserContext userContext, String examId, String anotherStatusId) throws Exception
 	{
 		checkParamsForTransferingAnotherStatus(userContext, examId,anotherStatusId);
 
		Exam exam = loadExam(userContext, examId, allTokens());	
		synchronized(exam){
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ExamStatus status = loadExamStatus(userContext, anotherStatusId, emptyOptions());		
			exam.updateStatus(status);		
			exam = saveExam(userContext, exam, emptyOptions());
			
			return present(userContext,exam, allTokens());
			
		}

 	}
 	
	

	protected void checkParamsForTransferingAnotherStatusWithCode(BcexUserContext userContext, String examId, String anotherCode) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfExam(examId);
 		checkerOf(userContext).checkCodeOfExamStatus( anotherCode);
 		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
 		
 	}

 	public Exam transferToAnotherStatusWithCode(BcexUserContext userContext, String examId, String anotherCode) throws Exception
 	{
 		checkParamsForTransferingAnotherStatusWithCode(userContext, examId,anotherCode);
 		Exam exam = loadExam(userContext, examId, allTokens());	
		synchronized(exam){
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			ExamStatus status = loadExamStatusWithCode(userContext, anotherCode, emptyOptions());		
			exam.updateStatus(status);		
			exam = saveExam(userContext, exam, emptyOptions());
			
			return present(userContext,exam, allTokens());
			
		}
 	}	

	  	
 	
 	
	public CandidateExamStatus requestCandidateStatus(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateExamStatus result = new CandidateExamStatus();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<ExamStatus> candidateList = examStatusDaoOf(userContext).requestCandidateExamStatusForExam(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 	protected void checkParamsForTransferingAnotherUser(BcexUserContext userContext, String examId, String anotherUserId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfExam(examId);
 		checkerOf(userContext).checkIdOfWechatUser(anotherUserId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
 		
 	}
 	public Exam transferToAnotherUser(BcexUserContext userContext, String examId, String anotherUserId) throws Exception
 	{
 		checkParamsForTransferingAnotherUser(userContext, examId,anotherUserId);
 
		Exam exam = loadExam(userContext, examId, allTokens());	
		synchronized(exam){
			//will be good when the exam loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			WechatUser user = loadWechatUser(userContext, anotherUserId, emptyOptions());		
			exam.updateUser(user);		
			exam = saveExam(userContext, exam, emptyOptions());
			
			return present(userContext,exam, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateWechatUser requestCandidateUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateWechatUser result = new CandidateWechatUser();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<WechatUser> candidateList = wechatUserDaoOf(userContext).requestCandidateWechatUserForExam(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected WechatUser loadWechatUser(BcexUserContext userContext, String newUserId, Map<String,Object> options) throws Exception
 	{
		
 		return wechatUserDaoOf(userContext).load(newUserId, options);
 	}
 	
 	
 	
	
	 	
 	protected ExamStatus loadExamStatus(BcexUserContext userContext, String newStatusId, Map<String,Object> options) throws Exception
 	{
		
 		return examStatusDaoOf(userContext).load(newStatusId, options);
 	}
 	
 	protected ExamStatus loadExamStatusWithCode(BcexUserContext userContext, String newCode, Map<String,Object> options) throws Exception
 	{
		
 		return examStatusDaoOf(userContext).loadByCode(newCode, options);
 	}
 	
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String examId, int examVersion) throws Exception {
		//deleteInternal(userContext, examId, examVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String examId, int examVersion) throws Exception{
			
		examDaoOf(userContext).delete(examId, examVersion);
	}
	
	public Exam forgetByAll(BcexUserContext userContext, String examId, int examVersion) throws Exception {
		return forgetByAllInternal(userContext, examId, examVersion);		
	}
	protected Exam forgetByAllInternal(BcexUserContext userContext,
			String examId, int examVersion) throws Exception{
			
		return examDaoOf(userContext).disconnectFromAll(examId, examVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new ExamManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return examDaoOf(userContext).deleteAll();
	}


	//disconnect Exam with question in UserAnswer
	protected Exam breakWithUserAnswerByQuestion(BcexUserContext userContext, String examId, String questionId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Exam exam = loadExam(userContext, examId, allTokens());

			synchronized(exam){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				examDaoOf(userContext).planToRemoveUserAnswerListWithQuestion(exam, questionId, this.emptyOptions());

				exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
				return exam;
			}
	}
	//disconnect Exam with user in FaultAnswer
	protected Exam breakWithFaultAnswerByUser(BcexUserContext userContext, String examId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Exam exam = loadExam(userContext, examId, allTokens());

			synchronized(exam){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				examDaoOf(userContext).planToRemoveFaultAnswerListWithUser(exam, userId, this.emptyOptions());

				exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
				return exam;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingUserAnswer(BcexUserContext userContext, String examId, String topic, String userSelect, String questionId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfExam(examId);

		
		checkerOf(userContext).checkTopicOfUserAnswer(topic);
		
		checkerOf(userContext).checkUserSelectOfUserAnswer(userSelect);
		
		checkerOf(userContext).checkQuestionIdOfUserAnswer(questionId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);

	
	}
	public  Exam addUserAnswer(BcexUserContext userContext, String examId, String topic, String userSelect, String questionId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserAnswer(userContext,examId,topic, userSelect, questionId,tokensExpr);
		
		UserAnswer userAnswer = createUserAnswer(userContext,topic, userSelect, questionId);
		
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			exam.addUserAnswer( userAnswer );		
			exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
			
			userContext.getManagerGroup().getUserAnswerManager().onNewInstanceCreated(userContext, userAnswer);
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAnswerProperties(BcexUserContext userContext, String examId,String id,String topic,String userSelect,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkIdOfUserAnswer(id);
		
		checkerOf(userContext).checkTopicOfUserAnswer( topic);
		checkerOf(userContext).checkUserSelectOfUserAnswer( userSelect);

		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
		
	}
	public  Exam updateUserAnswerProperties(BcexUserContext userContext, String examId, String id,String topic,String userSelect, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAnswerProperties(userContext,examId,id,topic,userSelect,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAnswerListList()
				.searchUserAnswerListWith(UserAnswer.ID_PROPERTY, "is", id).done();
		
		Exam examToUpdate = loadExam(userContext, examId, options);
		
		if(examToUpdate.getUserAnswerList().isEmpty()){
			throw new ExamManagerException("UserAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		UserAnswer item = examToUpdate.getUserAnswerList().first();
		
		item.updateTopic( topic );
		item.updateUserSelect( userSelect );

		
		//checkParamsForAddingUserAnswer(userContext,examId,name, code, used,tokensExpr);
		Exam exam = saveExam(userContext, examToUpdate, tokens().withUserAnswerList().done());
		synchronized(exam){ 
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserAnswer createUserAnswer(BcexUserContext userContext, String topic, String userSelect, String questionId) throws Exception{

		UserAnswer userAnswer = new UserAnswer();
		
		
		userAnswer.setTopic(topic);		
		userAnswer.setUserSelect(userSelect);		
		Question  question = new Question();
		question.setId(questionId);		
		userAnswer.setQuestion(question);
	
		
		return userAnswer;
	
		
	}
	
	protected UserAnswer createIndexedUserAnswer(String id, int version){

		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setId(id);
		userAnswer.setVersion(version);
		return userAnswer;			
		
	}
	
	protected void checkParamsForRemovingUserAnswerList(BcexUserContext userContext, String examId, 
			String userAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExam(examId);
		for(String userAnswerIdItem: userAnswerIds){
			checkerOf(userContext).checkIdOfUserAnswer(userAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
		
	}
	public  Exam removeUserAnswerList(BcexUserContext userContext, String examId, 
			String userAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAnswerList(userContext, examId,  userAnswerIds, tokensExpr);
			
			
			Exam exam = loadExam(userContext, examId, allTokens());
			synchronized(exam){ 
				//Will be good when the exam loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				examDaoOf(userContext).planToRemoveUserAnswerList(exam, userAnswerIds, allTokens());
				exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
				deleteRelationListInGraph(userContext, exam.getUserAnswerList());
				return present(userContext,exam, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserAnswer(BcexUserContext userContext, String examId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExam( examId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	public  Exam removeUserAnswer(BcexUserContext userContext, String examId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserAnswer(userContext,examId, userAnswerId, userAnswerVersion,tokensExpr);
		
		UserAnswer userAnswer = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			exam.removeUserAnswer( userAnswer );		
			exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
			deleteRelationInGraph(userContext, userAnswer);
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserAnswer(BcexUserContext userContext, String examId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExam( examId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	public  Exam copyUserAnswerFrom(BcexUserContext userContext, String examId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserAnswer(userContext,examId, userAnswerId, userAnswerVersion,tokensExpr);
		
		UserAnswer userAnswer = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			exam.copyUserAnswerFrom( userAnswer );		
			exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
			
			userContext.getManagerGroup().getUserAnswerManager().onNewInstanceCreated(userContext, (UserAnswer)exam.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserAnswer(BcexUserContext userContext, String examId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		

		if(UserAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfUserAnswer(parseString(newValueExpr));
		}
		
		if(UserAnswer.USER_SELECT_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserSelectOfUserAnswer(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	
	public  Exam updateUserAnswer(BcexUserContext userContext, String examId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserAnswer(userContext, examId, userAnswerId, userAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAnswerList().searchUserAnswerListWith(UserAnswer.ID_PROPERTY, "eq", userAnswerId).done();
		
		
		
		Exam exam = loadExam(userContext, examId, loadTokens);
		
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//exam.removeUserAnswer( userAnswer );	
			//make changes to AcceleraterAccount.
			UserAnswer userAnswerIndex = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		
			UserAnswer userAnswer = exam.findTheUserAnswer(userAnswerIndex);
			if(userAnswer == null){
				throw new ExamManagerException(userAnswer+" is NOT FOUND" );
			}
			
			userAnswer.changeProperty(property, newValueExpr);
			
			exam = saveExam(userContext, exam, tokens().withUserAnswerList().done());
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFaultAnswer(BcexUserContext userContext, String examId, String topic, String yourAnswer, String rightAnswer, String userId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfExam(examId);

		
		checkerOf(userContext).checkTopicOfFaultAnswer(topic);
		
		checkerOf(userContext).checkYourAnswerOfFaultAnswer(yourAnswer);
		
		checkerOf(userContext).checkRightAnswerOfFaultAnswer(rightAnswer);
		
		checkerOf(userContext).checkUserIdOfFaultAnswer(userId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);

	
	}
	public  Exam addFaultAnswer(BcexUserContext userContext, String examId, String topic, String yourAnswer, String rightAnswer, String userId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFaultAnswer(userContext,examId,topic, yourAnswer, rightAnswer, userId,tokensExpr);
		
		FaultAnswer faultAnswer = createFaultAnswer(userContext,topic, yourAnswer, rightAnswer, userId);
		
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			exam.addFaultAnswer( faultAnswer );		
			exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, faultAnswer);
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFaultAnswerProperties(BcexUserContext userContext, String examId,String id,String topic,String yourAnswer,String rightAnswer,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExam(examId);
		checkerOf(userContext).checkIdOfFaultAnswer(id);
		
		checkerOf(userContext).checkTopicOfFaultAnswer( topic);
		checkerOf(userContext).checkYourAnswerOfFaultAnswer( yourAnswer);
		checkerOf(userContext).checkRightAnswerOfFaultAnswer( rightAnswer);

		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
		
	}
	public  Exam updateFaultAnswerProperties(BcexUserContext userContext, String examId, String id,String topic,String yourAnswer,String rightAnswer, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFaultAnswerProperties(userContext,examId,id,topic,yourAnswer,rightAnswer,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFaultAnswerListList()
				.searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "is", id).done();
		
		Exam examToUpdate = loadExam(userContext, examId, options);
		
		if(examToUpdate.getFaultAnswerList().isEmpty()){
			throw new ExamManagerException("FaultAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		FaultAnswer item = examToUpdate.getFaultAnswerList().first();
		
		item.updateTopic( topic );
		item.updateYourAnswer( yourAnswer );
		item.updateRightAnswer( rightAnswer );

		
		//checkParamsForAddingFaultAnswer(userContext,examId,name, code, used,tokensExpr);
		Exam exam = saveExam(userContext, examToUpdate, tokens().withFaultAnswerList().done());
		synchronized(exam){ 
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FaultAnswer createFaultAnswer(BcexUserContext userContext, String topic, String yourAnswer, String rightAnswer, String userId) throws Exception{

		FaultAnswer faultAnswer = new FaultAnswer();
		
		
		faultAnswer.setTopic(topic);		
		faultAnswer.setYourAnswer(yourAnswer);		
		faultAnswer.setRightAnswer(rightAnswer);		
		faultAnswer.setCreateTime(userContext.now());		
		WechatUser  user = new WechatUser();
		user.setId(userId);		
		faultAnswer.setUser(user);
	
		
		return faultAnswer;
	
		
	}
	
	protected FaultAnswer createIndexedFaultAnswer(String id, int version){

		FaultAnswer faultAnswer = new FaultAnswer();
		faultAnswer.setId(id);
		faultAnswer.setVersion(version);
		return faultAnswer;			
		
	}
	
	protected void checkParamsForRemovingFaultAnswerList(BcexUserContext userContext, String examId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfExam(examId);
		for(String faultAnswerIdItem: faultAnswerIds){
			checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
		
	}
	public  Exam removeFaultAnswerList(BcexUserContext userContext, String examId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFaultAnswerList(userContext, examId,  faultAnswerIds, tokensExpr);
			
			
			Exam exam = loadExam(userContext, examId, allTokens());
			synchronized(exam){ 
				//Will be good when the exam loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				examDaoOf(userContext).planToRemoveFaultAnswerList(exam, faultAnswerIds, allTokens());
				exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
				deleteRelationListInGraph(userContext, exam.getFaultAnswerList());
				return present(userContext,exam, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFaultAnswer(BcexUserContext userContext, String examId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExam( examId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	public  Exam removeFaultAnswer(BcexUserContext userContext, String examId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFaultAnswer(userContext,examId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			exam.removeFaultAnswer( faultAnswer );		
			exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
			deleteRelationInGraph(userContext, faultAnswer);
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFaultAnswer(BcexUserContext userContext, String examId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfExam( examId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	public  Exam copyFaultAnswerFrom(BcexUserContext userContext, String examId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFaultAnswer(userContext,examId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		Exam exam = loadExam(userContext, examId, allTokens());
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			exam.copyFaultAnswerFrom( faultAnswer );		
			exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, (FaultAnswer)exam.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFaultAnswer(BcexUserContext userContext, String examId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfExam(examId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(ExamManagerException.class);
	
	}
	
	public  Exam updateFaultAnswer(BcexUserContext userContext, String examId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFaultAnswer(userContext, examId, faultAnswerId, faultAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFaultAnswerList().searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "eq", faultAnswerId).done();
		
		
		
		Exam exam = loadExam(userContext, examId, loadTokens);
		
		synchronized(exam){ 
			//Will be good when the exam loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//exam.removeFaultAnswer( faultAnswer );	
			//make changes to AcceleraterAccount.
			FaultAnswer faultAnswerIndex = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		
			FaultAnswer faultAnswer = exam.findTheFaultAnswer(faultAnswerIndex);
			if(faultAnswer == null){
				throw new ExamManagerException(faultAnswer+" is NOT FOUND" );
			}
			
			faultAnswer.changeProperty(property, newValueExpr);
			
			exam = saveExam(userContext, exam, tokens().withFaultAnswerList().done());
			return present(userContext,exam, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, Exam newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


