
package com.doublechaintech.bcex.changerequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.registration.Registration;

import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.registration.RegistrationDAO;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeDAO;
import com.doublechaintech.bcex.startexam.StartExamDAO;
import com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO;


public interface ChangeRequestDAO{

	public SmartList<ChangeRequest> loadAll();
	public ChangeRequest load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ChangeRequest> changeRequestList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ChangeRequest present(ChangeRequest changeRequest,Map<String,Object> options) throws Exception;
	public ChangeRequest clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ChangeRequest save(ChangeRequest changeRequest,Map<String,Object> options);
	public SmartList<ChangeRequest> saveChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options);
	public SmartList<ChangeRequest> removeChangeRequestList(SmartList<ChangeRequest> changeRequestList,Map<String,Object> options);
	public SmartList<ChangeRequest> findChangeRequestWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countChangeRequestWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countChangeRequestWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String changeRequestId, int version) throws Exception;
	public ChangeRequest disconnectFromAll(String changeRequestId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public RegistrationDAO getRegistrationDAO();
		
	public StartExamDAO getStartExamDAO();
		
	public AnswerQuestionDAO getAnswerQuestionDAO();
		
	
 	public SmartList<ChangeRequest> requestCandidateChangeRequestForRegistration(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ChangeRequest> requestCandidateChangeRequestForStartExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<ChangeRequest> requestCandidateChangeRequestForAnswerQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ChangeRequest planToRemoveRegistrationList(ChangeRequest changeRequest, String registrationIds[], Map<String,Object> options)throws Exception;


	public ChangeRequest planToRemoveStartExamList(ChangeRequest changeRequest, String startExamIds[], Map<String,Object> options)throws Exception;


	//disconnect ChangeRequest with user in StartExam
	public ChangeRequest planToRemoveStartExamListWithUser(ChangeRequest changeRequest, String userId, Map<String,Object> options)throws Exception;
	public int countStartExamListWithUser(String changeRequestId, String userId, Map<String,Object> options)throws Exception;
	
	public ChangeRequest planToRemoveAnswerQuestionList(ChangeRequest changeRequest, String answerQuestionIds[], Map<String,Object> options)throws Exception;


	//disconnect ChangeRequest with user in AnswerQuestion
	public ChangeRequest planToRemoveAnswerQuestionListWithUser(ChangeRequest changeRequest, String userId, Map<String,Object> options)throws Exception;
	public int countAnswerQuestionListWithUser(String changeRequestId, String userId, Map<String,Object> options)throws Exception;
	
	//disconnect ChangeRequest with user_answer in AnswerQuestion
	public ChangeRequest planToRemoveAnswerQuestionListWithUserAnswer(ChangeRequest changeRequest, String userAnswerId, Map<String,Object> options)throws Exception;
	public int countAnswerQuestionListWithUserAnswer(String changeRequestId, String userAnswerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ChangeRequest> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, Map<String,Object> options);
 	public int countChangeRequestByRequestType(String changeRequestTypeId, Map<String,Object> options);
 	public Map<String, Integer> countChangeRequestByRequestTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChangeRequest> findChangeRequestByRequestType(String changeRequestTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeChangeRequestByRequestType(SmartList<ChangeRequest> resultList, String changeRequestTypeId, Map<String,Object> options);

 
  
 	public SmartList<ChangeRequest> findChangeRequestByPlatform(String platformId, Map<String,Object> options);
 	public int countChangeRequestByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countChangeRequestByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<ChangeRequest> findChangeRequestByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeChangeRequestByPlatform(SmartList<ChangeRequest> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Registration的changeRequest的RegistrationList
	public SmartList<Registration> loadOurRegistrationList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:StartExam的changeRequest的StartExamList
	public SmartList<StartExam> loadOurStartExamList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:AnswerQuestion的changeRequest的AnswerQuestionList
	public SmartList<AnswerQuestion> loadOurAnswerQuestionList(BcexUserContext userContext, List<ChangeRequest> us, Map<String,Object> options) throws Exception;
	
}


