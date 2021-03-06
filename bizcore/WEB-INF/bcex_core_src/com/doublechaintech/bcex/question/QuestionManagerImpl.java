
package com.doublechaintech.bcex.question;

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

import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;

import com.doublechaintech.bcex.platform.CandidatePlatform;

import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;






public class QuestionManagerImpl extends CustomBcexCheckerManager implements QuestionManager {
	
	private static final String SERVICE_TYPE = "Question";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws QuestionManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new QuestionManagerException(message);

	}
	
	

 	protected Question saveQuestion(BcexUserContext userContext, Question question, String [] tokensExpr) throws Exception{	
 		//return getQuestionDAO().save(question, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveQuestion(userContext, question, tokens);
 	}
 	
 	protected Question saveQuestionDetail(BcexUserContext userContext, Question question) throws Exception{	

 		
 		return saveQuestion(userContext, question, allTokens());
 	}
 	
 	public Question loadQuestion(BcexUserContext userContext, String questionId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuestionManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		Question question = loadQuestion( userContext, questionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,question, tokens);
 	}
 	
 	
 	 public Question searchQuestion(BcexUserContext userContext, String questionId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuestionManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		Question question = loadQuestion( userContext, questionId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,question, tokens);
 	}
 	
 	

 	protected Question present(BcexUserContext userContext, Question question, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,question,tokens);
		
		
		Question  questionToPresent = questionDaoOf(userContext).present(question, tokens);
		
		List<BaseEntity> entityListToNaming = questionToPresent.collectRefercencesFromLists();
		questionDaoOf(userContext).alias(entityListToNaming);
		
		return  questionToPresent;
		
		
	}
 
 	
 	
 	public Question loadQuestionDetail(BcexUserContext userContext, String questionId) throws Exception{	
 		Question question = loadQuestion( userContext, questionId, allTokens());
 		return present(userContext,question, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String questionId) throws Exception{	
 		Question question = loadQuestion( userContext, questionId, viewTokens());
 		return present(userContext,question, allTokens());
		
 	}
 	protected Question saveQuestion(BcexUserContext userContext, Question question, Map<String,Object>tokens) throws Exception{	
 		return questionDaoOf(userContext).save(question, tokens);
 	}
 	protected Question loadQuestion(BcexUserContext userContext, String questionId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).throwExceptionIfHasErrors( QuestionManagerException.class);

 
 		return questionDaoOf(userContext).load(questionId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Question question, Map<String, Object> tokens){
		super.addActions(userContext, question, tokens);
		
		addAction(userContext, question, tokens,"@create","createQuestion","createQuestion/","main","primary");
		addAction(userContext, question, tokens,"@update","updateQuestion","updateQuestion/"+question.getId()+"/","main","primary");
		addAction(userContext, question, tokens,"@copy","cloneQuestion","cloneQuestion/"+question.getId()+"/","main","primary");
		
		addAction(userContext, question, tokens,"question.transfer_to_platform","transferToAnotherPlatform","transferToAnotherPlatform/"+question.getId()+"/","main","primary");
		addAction(userContext, question, tokens,"question.addAnswer","addAnswer","addAnswer/"+question.getId()+"/","answerList","primary");
		addAction(userContext, question, tokens,"question.removeAnswer","removeAnswer","removeAnswer/"+question.getId()+"/","answerList","primary");
		addAction(userContext, question, tokens,"question.updateAnswer","updateAnswer","updateAnswer/"+question.getId()+"/","answerList","primary");
		addAction(userContext, question, tokens,"question.copyAnswerFrom","copyAnswerFrom","copyAnswerFrom/"+question.getId()+"/","answerList","primary");
		addAction(userContext, question, tokens,"question.addUserAnswer","addUserAnswer","addUserAnswer/"+question.getId()+"/","userAnswerList","primary");
		addAction(userContext, question, tokens,"question.removeUserAnswer","removeUserAnswer","removeUserAnswer/"+question.getId()+"/","userAnswerList","primary");
		addAction(userContext, question, tokens,"question.updateUserAnswer","updateUserAnswer","updateUserAnswer/"+question.getId()+"/","userAnswerList","primary");
		addAction(userContext, question, tokens,"question.copyUserAnswerFrom","copyUserAnswerFrom","copyUserAnswerFrom/"+question.getId()+"/","userAnswerList","primary");
		addAction(userContext, question, tokens,"question.addFaultAnswer","addFaultAnswer","addFaultAnswer/"+question.getId()+"/","faultAnswerList","primary");
		addAction(userContext, question, tokens,"question.removeFaultAnswer","removeFaultAnswer","removeFaultAnswer/"+question.getId()+"/","faultAnswerList","primary");
		addAction(userContext, question, tokens,"question.updateFaultAnswer","updateFaultAnswer","updateFaultAnswer/"+question.getId()+"/","faultAnswerList","primary");
		addAction(userContext, question, tokens,"question.copyFaultAnswerFrom","copyFaultAnswerFrom","copyFaultAnswerFrom/"+question.getId()+"/","faultAnswerList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, Question question, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public Question createQuestion(BcexUserContext userContext,String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer, String platformId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkTopicOfQuestion(topic);
		checkerOf(userContext).checkLevelOfQuestion(level);
		checkerOf(userContext).checkOptionAOfQuestion(optionA);
		checkerOf(userContext).checkOptionBOfQuestion(optionB);
		checkerOf(userContext).checkOptionCOfQuestion(optionC);
		checkerOf(userContext).checkOptionDOfQuestion(optionD);
		checkerOf(userContext).checkOptionEOfQuestion(optionE);
		checkerOf(userContext).checkRightAnswerOfQuestion(rightAnswer);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);


		Question question=createNewQuestion();	

		question.setTopic(topic);
		question.setLevel(level);
		question.setOptionA(optionA);
		question.setOptionB(optionB);
		question.setOptionC(optionC);
		question.setOptionD(optionD);
		question.setOptionE(optionE);
		question.setRightAnswer(rightAnswer);
			
		Platform platform = loadPlatform(userContext, platformId,emptyOptions());
		question.setPlatform(platform);
		
		

		question = saveQuestion(userContext, question, emptyOptions());
		
		onNewInstanceCreated(userContext, question);
		return question;

		
	}
	protected Question createNewQuestion() 
	{
		
		return new Question();		
	}
	
	protected void checkParamsForUpdatingQuestion(BcexUserContext userContext,String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkVersionOfQuestion( questionVersion);
		

		if(Question.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfQuestion(parseString(newValueExpr));
		}
		if(Question.LEVEL_PROPERTY.equals(property)){
			checkerOf(userContext).checkLevelOfQuestion(parseString(newValueExpr));
		}
		if(Question.OPTION_A_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionAOfQuestion(parseString(newValueExpr));
		}
		if(Question.OPTION_B_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionBOfQuestion(parseString(newValueExpr));
		}
		if(Question.OPTION_C_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionCOfQuestion(parseString(newValueExpr));
		}
		if(Question.OPTION_D_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionDOfQuestion(parseString(newValueExpr));
		}
		if(Question.OPTION_E_PROPERTY.equals(property)){
			checkerOf(userContext).checkOptionEOfQuestion(parseString(newValueExpr));
		}
		if(Question.RIGHT_ANSWER_PROPERTY.equals(property)){
			checkerOf(userContext).checkRightAnswerOfQuestion(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
		
	}
	
	
	
	public Question clone(BcexUserContext userContext, String fromQuestionId) throws Exception{
		
		return questionDaoOf(userContext).clone(fromQuestionId, this.allTokens());
	}
	
	public Question internalSaveQuestion(BcexUserContext userContext, Question question) throws Exception 
	{
		return internalSaveQuestion(userContext, question, allTokens());

	}
	public Question internalSaveQuestion(BcexUserContext userContext, Question question, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingQuestion(userContext, questionId, questionVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(question){ 
			//will be good when the question loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Question.
			if (question.isChanged()){
			
			}
			question = saveQuestion(userContext, question, options);
			return question;
			
		}

	}
	
	public Question updateQuestion(BcexUserContext userContext,String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuestion(userContext, questionId, questionVersion, property, newValueExpr, tokensExpr);
		
		
		
		Question question = loadQuestion(userContext, questionId, allTokens());
		if(question.getVersion() != questionVersion){
			String message = "The target version("+question.getVersion()+") is not equals to version("+questionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(question){ 
			//will be good when the question loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Question.
			
			question.changeProperty(property, newValueExpr);
			question = saveQuestion(userContext, question, tokens().done());
			return present(userContext,question, mergedAllTokens(tokensExpr));
			//return saveQuestion(userContext, question, tokens().done());
		}

	}
	
	public Question updateQuestionProperty(BcexUserContext userContext,String questionId, int questionVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingQuestion(userContext, questionId, questionVersion, property, newValueExpr, tokensExpr);
		
		Question question = loadQuestion(userContext, questionId, allTokens());
		if(question.getVersion() != questionVersion){
			String message = "The target version("+question.getVersion()+") is not equals to version("+questionVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(question){ 
			//will be good when the question loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to Question.
			
			question.changeProperty(property, newValueExpr);
			
			question = saveQuestion(userContext, question, tokens().done());
			return present(userContext,question, mergedAllTokens(tokensExpr));
			//return saveQuestion(userContext, question, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected QuestionTokens tokens(){
		return QuestionTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return QuestionTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortAnswerListWith("id","desc")
		.sortUserAnswerListWith("id","desc")
		.sortFaultAnswerListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return QuestionTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherPlatform(BcexUserContext userContext, String questionId, String anotherPlatformId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfQuestion(questionId);
 		checkerOf(userContext).checkIdOfPlatform(anotherPlatformId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
 		
 	}
 	public Question transferToAnotherPlatform(BcexUserContext userContext, String questionId, String anotherPlatformId) throws Exception
 	{
 		checkParamsForTransferingAnotherPlatform(userContext, questionId,anotherPlatformId);
 
		Question question = loadQuestion(userContext, questionId, allTokens());	
		synchronized(question){
			//will be good when the question loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			Platform platform = loadPlatform(userContext, anotherPlatformId, emptyOptions());		
			question.updatePlatform(platform);		
			question = saveQuestion(userContext, question, emptyOptions());
			
			return present(userContext,question, allTokens());
			
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
		SmartList<Platform> candidateList = platformDaoOf(userContext).requestCandidatePlatformForQuestion(userContext,ownerClass, id, filterKey, pageNo, pageSize);
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

	public void delete(BcexUserContext userContext, String questionId, int questionVersion) throws Exception {
		//deleteInternal(userContext, questionId, questionVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String questionId, int questionVersion) throws Exception{
			
		questionDaoOf(userContext).delete(questionId, questionVersion);
	}
	
	public Question forgetByAll(BcexUserContext userContext, String questionId, int questionVersion) throws Exception {
		return forgetByAllInternal(userContext, questionId, questionVersion);		
	}
	protected Question forgetByAllInternal(BcexUserContext userContext,
			String questionId, int questionVersion) throws Exception{
			
		return questionDaoOf(userContext).disconnectFromAll(questionId, questionVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new QuestionManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return questionDaoOf(userContext).deleteAll();
	}


	//disconnect Question with exam in UserAnswer
	protected Question breakWithUserAnswerByExam(BcexUserContext userContext, String questionId, String examId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Question question = loadQuestion(userContext, questionId, allTokens());

			synchronized(question){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				questionDaoOf(userContext).planToRemoveUserAnswerListWithExam(question, examId, this.emptyOptions());

				question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
				return question;
			}
	}
	//disconnect Question with user in FaultAnswer
	protected Question breakWithFaultAnswerByUser(BcexUserContext userContext, String questionId, String userId,  String [] tokensExpr)
		 throws Exception{
			
			//TODO add check code here
			
			Question question = loadQuestion(userContext, questionId, allTokens());

			synchronized(question){ 
				//Will be good when the thread loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				
				questionDaoOf(userContext).planToRemoveFaultAnswerListWithUser(question, userId, this.emptyOptions());

				question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
				return question;
			}
	}
	
	
	
	
	

	protected void checkParamsForAddingAnswer(BcexUserContext userContext, String questionId, String title, String comment,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfQuestion(questionId);

		
		checkerOf(userContext).checkTitleOfAnswer(title);
		
		checkerOf(userContext).checkCommentOfAnswer(comment);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);

	
	}
	public  Question addAnswer(BcexUserContext userContext, String questionId, String title, String comment, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingAnswer(userContext,questionId,title, comment,tokensExpr);
		
		Answer answer = createAnswer(userContext,title, comment);
		
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.addAnswer( answer );		
			question = saveQuestion(userContext, question, tokens().withAnswerList().done());
			
			userContext.getManagerGroup().getAnswerManager().onNewInstanceCreated(userContext, answer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingAnswerProperties(BcexUserContext userContext, String questionId,String id,String title,String comment,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkIdOfAnswer(id);
		
		checkerOf(userContext).checkTitleOfAnswer( title);
		checkerOf(userContext).checkCommentOfAnswer( comment);

		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question updateAnswerProperties(BcexUserContext userContext, String questionId, String id,String title,String comment, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingAnswerProperties(userContext,questionId,id,title,comment,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withAnswerListList()
				.searchAnswerListWith(Answer.ID_PROPERTY, "is", id).done();
		
		Question questionToUpdate = loadQuestion(userContext, questionId, options);
		
		if(questionToUpdate.getAnswerList().isEmpty()){
			throw new QuestionManagerException("Answer is NOT FOUND with id: '"+id+"'");
		}
		
		Answer item = questionToUpdate.getAnswerList().first();
		
		item.updateTitle( title );
		item.updateComment( comment );

		
		//checkParamsForAddingAnswer(userContext,questionId,name, code, used,tokensExpr);
		Question question = saveQuestion(userContext, questionToUpdate, tokens().withAnswerList().done());
		synchronized(question){ 
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected Answer createAnswer(BcexUserContext userContext, String title, String comment) throws Exception{

		Answer answer = new Answer();
		
		
		answer.setTitle(title);		
		answer.setComment(comment);
	
		
		return answer;
	
		
	}
	
	protected Answer createIndexedAnswer(String id, int version){

		Answer answer = new Answer();
		answer.setId(id);
		answer.setVersion(version);
		return answer;			
		
	}
	
	protected void checkParamsForRemovingAnswerList(BcexUserContext userContext, String questionId, 
			String answerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		for(String answerIdItem: answerIds){
			checkerOf(userContext).checkIdOfAnswer(answerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question removeAnswerList(BcexUserContext userContext, String questionId, 
			String answerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingAnswerList(userContext, questionId,  answerIds, tokensExpr);
			
			
			Question question = loadQuestion(userContext, questionId, allTokens());
			synchronized(question){ 
				//Will be good when the question loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				questionDaoOf(userContext).planToRemoveAnswerList(question, answerIds, allTokens());
				question = saveQuestion(userContext, question, tokens().withAnswerList().done());
				deleteRelationListInGraph(userContext, question.getAnswerList());
				return present(userContext,question, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingAnswer(BcexUserContext userContext, String questionId, 
		String answerId, int answerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).checkVersionOfAnswer(answerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question removeAnswer(BcexUserContext userContext, String questionId, 
		String answerId, int answerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingAnswer(userContext,questionId, answerId, answerVersion,tokensExpr);
		
		Answer answer = createIndexedAnswer(answerId, answerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.removeAnswer( answer );		
			question = saveQuestion(userContext, question, tokens().withAnswerList().done());
			deleteRelationInGraph(userContext, answer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingAnswer(BcexUserContext userContext, String questionId, 
		String answerId, int answerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).checkVersionOfAnswer(answerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question copyAnswerFrom(BcexUserContext userContext, String questionId, 
		String answerId, int answerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingAnswer(userContext,questionId, answerId, answerVersion,tokensExpr);
		
		Answer answer = createIndexedAnswer(answerId, answerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			question.copyAnswerFrom( answer );		
			question = saveQuestion(userContext, question, tokens().withAnswerList().done());
			
			userContext.getManagerGroup().getAnswerManager().onNewInstanceCreated(userContext, (Answer)question.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingAnswer(BcexUserContext userContext, String questionId, String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkIdOfAnswer(answerId);
		checkerOf(userContext).checkVersionOfAnswer(answerVersion);
		

		if(Answer.TITLE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTitleOfAnswer(parseString(newValueExpr));
		}
		
		if(Answer.COMMENT_PROPERTY.equals(property)){
			checkerOf(userContext).checkCommentOfAnswer(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	
	public  Question updateAnswer(BcexUserContext userContext, String questionId, String answerId, int answerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingAnswer(userContext, questionId, answerId, answerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withAnswerList().searchAnswerListWith(Answer.ID_PROPERTY, "eq", answerId).done();
		
		
		
		Question question = loadQuestion(userContext, questionId, loadTokens);
		
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//question.removeAnswer( answer );	
			//make changes to AcceleraterAccount.
			Answer answerIndex = createIndexedAnswer(answerId, answerVersion);
		
			Answer answer = question.findTheAnswer(answerIndex);
			if(answer == null){
				throw new QuestionManagerException(answer+" is NOT FOUND" );
			}
			
			answer.changeProperty(property, newValueExpr);
			
			question = saveQuestion(userContext, question, tokens().withAnswerList().done());
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingUserAnswer(BcexUserContext userContext, String questionId, String topic, String userSelect, String examId,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfQuestion(questionId);

		
		checkerOf(userContext).checkTopicOfUserAnswer(topic);
		
		checkerOf(userContext).checkUserSelectOfUserAnswer(userSelect);
		
		checkerOf(userContext).checkExamIdOfUserAnswer(examId);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);

	
	}
	public  Question addUserAnswer(BcexUserContext userContext, String questionId, String topic, String userSelect, String examId, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingUserAnswer(userContext,questionId,topic, userSelect, examId,tokensExpr);
		
		UserAnswer userAnswer = createUserAnswer(userContext,topic, userSelect, examId);
		
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.addUserAnswer( userAnswer );		
			question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
			
			userContext.getManagerGroup().getUserAnswerManager().onNewInstanceCreated(userContext, userAnswer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingUserAnswerProperties(BcexUserContext userContext, String questionId,String id,String topic,String userSelect,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkIdOfUserAnswer(id);
		
		checkerOf(userContext).checkTopicOfUserAnswer( topic);
		checkerOf(userContext).checkUserSelectOfUserAnswer( userSelect);

		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question updateUserAnswerProperties(BcexUserContext userContext, String questionId, String id,String topic,String userSelect, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingUserAnswerProperties(userContext,questionId,id,topic,userSelect,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withUserAnswerListList()
				.searchUserAnswerListWith(UserAnswer.ID_PROPERTY, "is", id).done();
		
		Question questionToUpdate = loadQuestion(userContext, questionId, options);
		
		if(questionToUpdate.getUserAnswerList().isEmpty()){
			throw new QuestionManagerException("UserAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		UserAnswer item = questionToUpdate.getUserAnswerList().first();
		
		item.updateTopic( topic );
		item.updateUserSelect( userSelect );

		
		//checkParamsForAddingUserAnswer(userContext,questionId,name, code, used,tokensExpr);
		Question question = saveQuestion(userContext, questionToUpdate, tokens().withUserAnswerList().done());
		synchronized(question){ 
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected UserAnswer createUserAnswer(BcexUserContext userContext, String topic, String userSelect, String examId) throws Exception{

		UserAnswer userAnswer = new UserAnswer();
		
		
		userAnswer.setTopic(topic);		
		userAnswer.setUserSelect(userSelect);		
		Exam  exam = new Exam();
		exam.setId(examId);		
		userAnswer.setExam(exam);
	
		
		return userAnswer;
	
		
	}
	
	protected UserAnswer createIndexedUserAnswer(String id, int version){

		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setId(id);
		userAnswer.setVersion(version);
		return userAnswer;			
		
	}
	
	protected void checkParamsForRemovingUserAnswerList(BcexUserContext userContext, String questionId, 
			String userAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		for(String userAnswerIdItem: userAnswerIds){
			checkerOf(userContext).checkIdOfUserAnswer(userAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question removeUserAnswerList(BcexUserContext userContext, String questionId, 
			String userAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingUserAnswerList(userContext, questionId,  userAnswerIds, tokensExpr);
			
			
			Question question = loadQuestion(userContext, questionId, allTokens());
			synchronized(question){ 
				//Will be good when the question loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				questionDaoOf(userContext).planToRemoveUserAnswerList(question, userAnswerIds, allTokens());
				question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
				deleteRelationListInGraph(userContext, question.getUserAnswerList());
				return present(userContext,question, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingUserAnswer(BcexUserContext userContext, String questionId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question removeUserAnswer(BcexUserContext userContext, String questionId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingUserAnswer(userContext,questionId, userAnswerId, userAnswerVersion,tokensExpr);
		
		UserAnswer userAnswer = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.removeUserAnswer( userAnswer );		
			question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
			deleteRelationInGraph(userContext, userAnswer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingUserAnswer(BcexUserContext userContext, String questionId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question copyUserAnswerFrom(BcexUserContext userContext, String questionId, 
		String userAnswerId, int userAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingUserAnswer(userContext,questionId, userAnswerId, userAnswerVersion,tokensExpr);
		
		UserAnswer userAnswer = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			question.copyUserAnswerFrom( userAnswer );		
			question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
			
			userContext.getManagerGroup().getUserAnswerManager().onNewInstanceCreated(userContext, (UserAnswer)question.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingUserAnswer(BcexUserContext userContext, String questionId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkIdOfUserAnswer(userAnswerId);
		checkerOf(userContext).checkVersionOfUserAnswer(userAnswerVersion);
		

		if(UserAnswer.TOPIC_PROPERTY.equals(property)){
			checkerOf(userContext).checkTopicOfUserAnswer(parseString(newValueExpr));
		}
		
		if(UserAnswer.USER_SELECT_PROPERTY.equals(property)){
			checkerOf(userContext).checkUserSelectOfUserAnswer(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	
	public  Question updateUserAnswer(BcexUserContext userContext, String questionId, String userAnswerId, int userAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingUserAnswer(userContext, questionId, userAnswerId, userAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withUserAnswerList().searchUserAnswerListWith(UserAnswer.ID_PROPERTY, "eq", userAnswerId).done();
		
		
		
		Question question = loadQuestion(userContext, questionId, loadTokens);
		
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//question.removeUserAnswer( userAnswer );	
			//make changes to AcceleraterAccount.
			UserAnswer userAnswerIndex = createIndexedUserAnswer(userAnswerId, userAnswerVersion);
		
			UserAnswer userAnswer = question.findTheUserAnswer(userAnswerIndex);
			if(userAnswer == null){
				throw new QuestionManagerException(userAnswer+" is NOT FOUND" );
			}
			
			userAnswer.changeProperty(property, newValueExpr);
			
			question = saveQuestion(userContext, question, tokens().withUserAnswerList().done());
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	protected void checkParamsForAddingFaultAnswer(BcexUserContext userContext, String questionId, String topic, String yourAnswer, String rightAnswer, String userId, int faultTimes,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfQuestion(questionId);

		
		checkerOf(userContext).checkTopicOfFaultAnswer(topic);
		
		checkerOf(userContext).checkYourAnswerOfFaultAnswer(yourAnswer);
		
		checkerOf(userContext).checkRightAnswerOfFaultAnswer(rightAnswer);
		
		checkerOf(userContext).checkUserIdOfFaultAnswer(userId);
		
		checkerOf(userContext).checkFaultTimesOfFaultAnswer(faultTimes);
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);

	
	}
	public  Question addFaultAnswer(BcexUserContext userContext, String questionId, String topic, String yourAnswer, String rightAnswer, String userId, int faultTimes, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingFaultAnswer(userContext,questionId,topic, yourAnswer, rightAnswer, userId, faultTimes,tokensExpr);
		
		FaultAnswer faultAnswer = createFaultAnswer(userContext,topic, yourAnswer, rightAnswer, userId, faultTimes);
		
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.addFaultAnswer( faultAnswer );		
			question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, faultAnswer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingFaultAnswerProperties(BcexUserContext userContext, String questionId,String id,String topic,String yourAnswer,String rightAnswer,int faultTimes,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		checkerOf(userContext).checkIdOfFaultAnswer(id);
		
		checkerOf(userContext).checkTopicOfFaultAnswer( topic);
		checkerOf(userContext).checkYourAnswerOfFaultAnswer( yourAnswer);
		checkerOf(userContext).checkRightAnswerOfFaultAnswer( rightAnswer);
		checkerOf(userContext).checkFaultTimesOfFaultAnswer( faultTimes);

		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question updateFaultAnswerProperties(BcexUserContext userContext, String questionId, String id,String topic,String yourAnswer,String rightAnswer,int faultTimes, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingFaultAnswerProperties(userContext,questionId,id,topic,yourAnswer,rightAnswer,faultTimes,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withFaultAnswerListList()
				.searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "is", id).done();
		
		Question questionToUpdate = loadQuestion(userContext, questionId, options);
		
		if(questionToUpdate.getFaultAnswerList().isEmpty()){
			throw new QuestionManagerException("FaultAnswer is NOT FOUND with id: '"+id+"'");
		}
		
		FaultAnswer item = questionToUpdate.getFaultAnswerList().first();
		
		item.updateTopic( topic );
		item.updateYourAnswer( yourAnswer );
		item.updateRightAnswer( rightAnswer );
		item.updateFaultTimes( faultTimes );

		
		//checkParamsForAddingFaultAnswer(userContext,questionId,name, code, used,tokensExpr);
		Question question = saveQuestion(userContext, questionToUpdate, tokens().withFaultAnswerList().done());
		synchronized(question){ 
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected FaultAnswer createFaultAnswer(BcexUserContext userContext, String topic, String yourAnswer, String rightAnswer, String userId, int faultTimes) throws Exception{

		FaultAnswer faultAnswer = new FaultAnswer();
		
		
		faultAnswer.setTopic(topic);		
		faultAnswer.setYourAnswer(yourAnswer);		
		faultAnswer.setRightAnswer(rightAnswer);		
		faultAnswer.setCreateTime(userContext.now());		
		WechatUser  user = new WechatUser();
		user.setId(userId);		
		faultAnswer.setUser(user);		
		faultAnswer.setFaultTimes(faultTimes);
	
		
		return faultAnswer;
	
		
	}
	
	protected FaultAnswer createIndexedFaultAnswer(String id, int version){

		FaultAnswer faultAnswer = new FaultAnswer();
		faultAnswer.setId(id);
		faultAnswer.setVersion(version);
		return faultAnswer;			
		
	}
	
	protected void checkParamsForRemovingFaultAnswerList(BcexUserContext userContext, String questionId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfQuestion(questionId);
		for(String faultAnswerIdItem: faultAnswerIds){
			checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
		
	}
	public  Question removeFaultAnswerList(BcexUserContext userContext, String questionId, 
			String faultAnswerIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingFaultAnswerList(userContext, questionId,  faultAnswerIds, tokensExpr);
			
			
			Question question = loadQuestion(userContext, questionId, allTokens());
			synchronized(question){ 
				//Will be good when the question loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				questionDaoOf(userContext).planToRemoveFaultAnswerList(question, faultAnswerIds, allTokens());
				question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
				deleteRelationListInGraph(userContext, question.getFaultAnswerList());
				return present(userContext,question, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingFaultAnswer(BcexUserContext userContext, String questionId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question removeFaultAnswer(BcexUserContext userContext, String questionId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingFaultAnswer(userContext,questionId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			question.removeFaultAnswer( faultAnswer );		
			question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
			deleteRelationInGraph(userContext, faultAnswer);
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingFaultAnswer(BcexUserContext userContext, String questionId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfQuestion( questionId);
		checkerOf(userContext).checkIdOfFaultAnswer(faultAnswerId);
		checkerOf(userContext).checkVersionOfFaultAnswer(faultAnswerVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	public  Question copyFaultAnswerFrom(BcexUserContext userContext, String questionId, 
		String faultAnswerId, int faultAnswerVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingFaultAnswer(userContext,questionId, faultAnswerId, faultAnswerVersion,tokensExpr);
		
		FaultAnswer faultAnswer = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		Question question = loadQuestion(userContext, questionId, allTokens());
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			question.copyFaultAnswerFrom( faultAnswer );		
			question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
			
			userContext.getManagerGroup().getFaultAnswerManager().onNewInstanceCreated(userContext, (FaultAnswer)question.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingFaultAnswer(BcexUserContext userContext, String questionId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfQuestion(questionId);
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
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(QuestionManagerException.class);
	
	}
	
	public  Question updateFaultAnswer(BcexUserContext userContext, String questionId, String faultAnswerId, int faultAnswerVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingFaultAnswer(userContext, questionId, faultAnswerId, faultAnswerVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withFaultAnswerList().searchFaultAnswerListWith(FaultAnswer.ID_PROPERTY, "eq", faultAnswerId).done();
		
		
		
		Question question = loadQuestion(userContext, questionId, loadTokens);
		
		synchronized(question){ 
			//Will be good when the question loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//question.removeFaultAnswer( faultAnswer );	
			//make changes to AcceleraterAccount.
			FaultAnswer faultAnswerIndex = createIndexedFaultAnswer(faultAnswerId, faultAnswerVersion);
		
			FaultAnswer faultAnswer = question.findTheFaultAnswer(faultAnswerIndex);
			if(faultAnswer == null){
				throw new QuestionManagerException(faultAnswer+" is NOT FOUND" );
			}
			
			faultAnswer.changeProperty(property, newValueExpr);
			
			question = saveQuestion(userContext, question, tokens().withFaultAnswerList().done());
			return present(userContext,question, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, Question newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


