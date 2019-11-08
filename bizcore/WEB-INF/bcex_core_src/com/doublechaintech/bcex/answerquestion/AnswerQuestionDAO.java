
package com.doublechaintech.bcex.answerquestion;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.useranswer.UserAnswerDAO;
import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;


public interface AnswerQuestionDAO{

	public SmartList<AnswerQuestion> loadAll();
	public AnswerQuestion load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<AnswerQuestion> answerQuestionList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public AnswerQuestion present(AnswerQuestion answerQuestion,Map<String,Object> options) throws Exception;
	public AnswerQuestion clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public AnswerQuestion save(AnswerQuestion answerQuestion,Map<String,Object> options);
	public SmartList<AnswerQuestion> saveAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options);
	public SmartList<AnswerQuestion> removeAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList,Map<String,Object> options);
	public SmartList<AnswerQuestion> findAnswerQuestionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countAnswerQuestionWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countAnswerQuestionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String answerQuestionId, int version) throws Exception;
	public AnswerQuestion disconnectFromAll(String answerQuestionId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<AnswerQuestion> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<AnswerQuestion> findAnswerQuestionByUser(String wechatUserId, Map<String,Object> options);
 	public int countAnswerQuestionByUser(String wechatUserId, Map<String,Object> options);
 	public Map<String, Integer> countAnswerQuestionByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<AnswerQuestion> findAnswerQuestionByUser(String wechatUserId, int start, int count, Map<String,Object> options);
 	public void analyzeAnswerQuestionByUser(SmartList<AnswerQuestion> resultList, String wechatUserId, Map<String,Object> options);

 
  
 	public SmartList<AnswerQuestion> findAnswerQuestionByUserAnswer(String userAnswerId, Map<String,Object> options);
 	public int countAnswerQuestionByUserAnswer(String userAnswerId, Map<String,Object> options);
 	public Map<String, Integer> countAnswerQuestionByUserAnswerIds(String[] ids, Map<String,Object> options);
 	public SmartList<AnswerQuestion> findAnswerQuestionByUserAnswer(String userAnswerId, int start, int count, Map<String,Object> options);
 	public void analyzeAnswerQuestionByUserAnswer(SmartList<AnswerQuestion> resultList, String userAnswerId, Map<String,Object> options);

 
  
 	public SmartList<AnswerQuestion> findAnswerQuestionByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public int countAnswerQuestionByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public Map<String, Integer> countAnswerQuestionByChangeRequestIds(String[] ids, Map<String,Object> options);
 	public SmartList<AnswerQuestion> findAnswerQuestionByChangeRequest(String changeRequestId, int start, int count, Map<String,Object> options);
 	public void analyzeAnswerQuestionByChangeRequest(SmartList<AnswerQuestion> resultList, String changeRequestId, Map<String,Object> options);

 
 
}


