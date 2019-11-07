
package com.doublechaintech.bcex.answer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.question.QuestionDAO;


public interface AnswerDAO{

	public SmartList<Answer> loadAll();
	public Answer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Answer> answerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Answer present(Answer answer,Map<String,Object> options) throws Exception;
	public Answer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Answer save(Answer answer,Map<String,Object> options);
	public SmartList<Answer> saveAnswerList(SmartList<Answer> answerList,Map<String,Object> options);
	public SmartList<Answer> removeAnswerList(SmartList<Answer> answerList,Map<String,Object> options);
	public SmartList<Answer> findAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String answerId, int version) throws Exception;
	public Answer disconnectFromAll(String answerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Answer> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Answer> findAnswerByQuestion(String questionId, Map<String,Object> options);
 	public int countAnswerByQuestion(String questionId, Map<String,Object> options);
 	public Map<String, Integer> countAnswerByQuestionIds(String[] ids, Map<String,Object> options);
 	public SmartList<Answer> findAnswerByQuestion(String questionId, int start, int count, Map<String,Object> options);
 	public void analyzeAnswerByQuestion(SmartList<Answer> resultList, String questionId, Map<String,Object> options);

 
 
}


