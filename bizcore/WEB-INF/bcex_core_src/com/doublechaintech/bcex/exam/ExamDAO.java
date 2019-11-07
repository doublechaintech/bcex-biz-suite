
package com.doublechaintech.bcex.exam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.faultanswer.FaultAnswerDAO;
import com.doublechaintech.bcex.useranswer.UserAnswerDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.examstatus.ExamStatusDAO;


public interface ExamDAO{

	public SmartList<Exam> loadAll();
	public Exam load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Exam> examList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Exam present(Exam exam,Map<String,Object> options) throws Exception;
	public Exam clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Exam save(Exam exam,Map<String,Object> options);
	public SmartList<Exam> saveExamList(SmartList<Exam> examList,Map<String,Object> options);
	public SmartList<Exam> removeExamList(SmartList<Exam> examList,Map<String,Object> options);
	public SmartList<Exam> findExamWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countExamWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countExamWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String examId, int version) throws Exception;
	public Exam disconnectFromAll(String examId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserAnswerDAO getUserAnswerDAO();
		
	public FaultAnswerDAO getFaultAnswerDAO();
		
	
 	public SmartList<Exam> requestCandidateExamForUserAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Exam> requestCandidateExamForFaultAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Exam planToRemoveUserAnswerList(Exam exam, String userAnswerIds[], Map<String,Object> options)throws Exception;


	//disconnect Exam with question in UserAnswer
	public Exam planToRemoveUserAnswerListWithQuestion(Exam exam, String questionId, Map<String,Object> options)throws Exception;
	public int countUserAnswerListWithQuestion(String examId, String questionId, Map<String,Object> options)throws Exception;
	
	public Exam planToRemoveFaultAnswerList(Exam exam, String faultAnswerIds[], Map<String,Object> options)throws Exception;


	//disconnect Exam with user in FaultAnswer
	public Exam planToRemoveFaultAnswerListWithUser(Exam exam, String userId, Map<String,Object> options)throws Exception;
	public int countFaultAnswerListWithUser(String examId, String userId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Exam> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Exam> findExamByStatus(String examStatusId, Map<String,Object> options);
 	public int countExamByStatus(String examStatusId, Map<String,Object> options);
 	public Map<String, Integer> countExamByStatusIds(String[] ids, Map<String,Object> options);
 	public SmartList<Exam> findExamByStatus(String examStatusId, int start, int count, Map<String,Object> options);
 	public void analyzeExamByStatus(SmartList<Exam> resultList, String examStatusId, Map<String,Object> options);

 
  
 	public SmartList<Exam> findExamByUser(String wechatUserId, Map<String,Object> options);
 	public int countExamByUser(String wechatUserId, Map<String,Object> options);
 	public Map<String, Integer> countExamByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<Exam> findExamByUser(String wechatUserId, int start, int count, Map<String,Object> options);
 	public void analyzeExamByUser(SmartList<Exam> resultList, String wechatUserId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:UserAnswer的exam的UserAnswerList
	public SmartList<UserAnswer> loadOurUserAnswerList(BcexUserContext userContext, List<Exam> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:FaultAnswer的exam的FaultAnswerList
	public SmartList<FaultAnswer> loadOurFaultAnswerList(BcexUserContext userContext, List<Exam> us, Map<String,Object> options) throws Exception;
	
}


