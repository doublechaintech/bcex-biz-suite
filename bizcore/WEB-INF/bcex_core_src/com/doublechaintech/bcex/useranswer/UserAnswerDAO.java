
package com.doublechaintech.bcex.useranswer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.question.QuestionDAO;


public interface UserAnswerDAO{

	public SmartList<UserAnswer> loadAll();
	public UserAnswer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserAnswer> userAnswerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserAnswer present(UserAnswer userAnswer,Map<String,Object> options) throws Exception;
	public UserAnswer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserAnswer save(UserAnswer userAnswer,Map<String,Object> options);
	public SmartList<UserAnswer> saveUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options);
	public SmartList<UserAnswer> removeUserAnswerList(SmartList<UserAnswer> userAnswerList,Map<String,Object> options);
	public SmartList<UserAnswer> findUserAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userAnswerId, int version) throws Exception;
	public UserAnswer disconnectFromAll(String userAnswerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<UserAnswer> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<UserAnswer> findUserAnswerByQuestion(String questionId, Map<String,Object> options);
 	public int countUserAnswerByQuestion(String questionId, Map<String,Object> options);
 	public Map<String, Integer> countUserAnswerByQuestionIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserAnswer> findUserAnswerByQuestion(String questionId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAnswerByQuestion(SmartList<UserAnswer> resultList, String questionId, Map<String,Object> options);

 
  
 	public SmartList<UserAnswer> findUserAnswerByExam(String examId, Map<String,Object> options);
 	public int countUserAnswerByExam(String examId, Map<String,Object> options);
 	public Map<String, Integer> countUserAnswerByExamIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserAnswer> findUserAnswerByExam(String examId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAnswerByExam(SmartList<UserAnswer> resultList, String examId, Map<String,Object> options);

 
 
}


