
package com.doublechaintech.bcex.wechatuser;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.faultanswer.FaultAnswerDAO;
import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO;


public interface WechatUserDAO{

	public SmartList<WechatUser> loadAll();
	public WechatUser load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WechatUser> wechatUserList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public WechatUser present(WechatUser wechatUser,Map<String,Object> options) throws Exception;
	public WechatUser clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public WechatUser save(WechatUser wechatUser,Map<String,Object> options);
	public SmartList<WechatUser> saveWechatUserList(SmartList<WechatUser> wechatUserList,Map<String,Object> options);
	public SmartList<WechatUser> removeWechatUserList(SmartList<WechatUser> wechatUserList,Map<String,Object> options);
	public SmartList<WechatUser> findWechatUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWechatUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWechatUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String wechatUserId, int version) throws Exception;
	public WechatUser disconnectFromAll(String wechatUserId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AnswerQuestionDAO getAnswerQuestionDAO();
		
	public ExamDAO getExamDAO();
		
	public FaultAnswerDAO getFaultAnswerDAO();
		
	
 	public SmartList<WechatUser> requestCandidateWechatUserForAnswerQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<WechatUser> requestCandidateWechatUserForExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<WechatUser> requestCandidateWechatUserForFaultAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public WechatUser planToRemoveAnswerQuestionList(WechatUser wechatUser, String answerQuestionIds[], Map<String,Object> options)throws Exception;


	//disconnect WechatUser with question in AnswerQuestion
	public WechatUser planToRemoveAnswerQuestionListWithQuestion(WechatUser wechatUser, String questionId, Map<String,Object> options)throws Exception;
	public int countAnswerQuestionListWithQuestion(String wechatUserId, String questionId, Map<String,Object> options)throws Exception;
	
	//disconnect WechatUser with change_request in AnswerQuestion
	public WechatUser planToRemoveAnswerQuestionListWithChangeRequest(WechatUser wechatUser, String changeRequestId, Map<String,Object> options)throws Exception;
	public int countAnswerQuestionListWithChangeRequest(String wechatUserId, String changeRequestId, Map<String,Object> options)throws Exception;
	
	public WechatUser planToRemoveExamList(WechatUser wechatUser, String examIds[], Map<String,Object> options)throws Exception;


	//disconnect WechatUser with status in Exam
	public WechatUser planToRemoveExamListWithStatus(WechatUser wechatUser, String statusId, Map<String,Object> options)throws Exception;
	public int countExamListWithStatus(String wechatUserId, String statusId, Map<String,Object> options)throws Exception;
	
	public WechatUser planToRemoveFaultAnswerList(WechatUser wechatUser, String faultAnswerIds[], Map<String,Object> options)throws Exception;


	//disconnect WechatUser with exam in FaultAnswer
	public WechatUser planToRemoveFaultAnswerListWithExam(WechatUser wechatUser, String examId, Map<String,Object> options)throws Exception;
	public int countFaultAnswerListWithExam(String wechatUserId, String examId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<WechatUser> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<WechatUser> findWechatUserByPlatform(String platformId, Map<String,Object> options);
 	public int countWechatUserByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countWechatUserByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<WechatUser> findWechatUserByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeWechatUserByPlatform(SmartList<WechatUser> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:AnswerQuestion的user的AnswerQuestionList
	public SmartList<AnswerQuestion> loadOurAnswerQuestionList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Exam的user的ExamList
	public SmartList<Exam> loadOurExamList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FaultAnswer的user的FaultAnswerList
	public SmartList<FaultAnswer> loadOurFaultAnswerList(BcexUserContext userContext, List<WechatUser> us, Map<String,Object> options) throws Exception;
	
}


