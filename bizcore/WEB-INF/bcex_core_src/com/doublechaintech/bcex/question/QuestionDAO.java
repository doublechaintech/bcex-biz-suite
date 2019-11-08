
package com.doublechaintech.bcex.question;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.useranswer.UserAnswer;

import com.doublechaintech.bcex.useranswer.UserAnswerDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.answer.AnswerDAO;


public interface QuestionDAO{

	public SmartList<Question> loadAll();
	public Question load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Question> questionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Question present(Question question,Map<String,Object> options) throws Exception;
	public Question clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Question save(Question question,Map<String,Object> options);
	public SmartList<Question> saveQuestionList(SmartList<Question> questionList,Map<String,Object> options);
	public SmartList<Question> removeQuestionList(SmartList<Question> questionList,Map<String,Object> options);
	public SmartList<Question> findQuestionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countQuestionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countQuestionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String questionId, int version) throws Exception;
	public Question disconnectFromAll(String questionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public AnswerDAO getAnswerDAO();
		
	public UserAnswerDAO getUserAnswerDAO();
		
	
 	public SmartList<Question> requestCandidateQuestionForAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Question> requestCandidateQuestionForUserAnswer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Question planToRemoveAnswerList(Question question, String answerIds[], Map<String,Object> options)throws Exception;


	public Question planToRemoveUserAnswerList(Question question, String userAnswerIds[], Map<String,Object> options)throws Exception;


	//disconnect Question with exam in UserAnswer
	public Question planToRemoveUserAnswerListWithExam(Question question, String examId, Map<String,Object> options)throws Exception;
	public int countUserAnswerListWithExam(String questionId, String examId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<Question> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Question> findQuestionByPlatform(String platformId, Map<String,Object> options);
 	public int countQuestionByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countQuestionByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<Question> findQuestionByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeQuestionByPlatform(SmartList<Question> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Answer的question的AnswerList
	public SmartList<Answer> loadOurAnswerList(BcexUserContext userContext, List<Question> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:UserAnswer的question的UserAnswerList
	public SmartList<UserAnswer> loadOurUserAnswerList(BcexUserContext userContext, List<Question> us, Map<String,Object> options) throws Exception;
	
}


