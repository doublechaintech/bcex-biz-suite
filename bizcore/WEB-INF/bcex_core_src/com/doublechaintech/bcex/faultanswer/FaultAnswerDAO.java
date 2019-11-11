
package com.doublechaintech.bcex.faultanswer;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.question.QuestionDAO;


public interface FaultAnswerDAO{

	public SmartList<FaultAnswer> loadAll();
	public FaultAnswer load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<FaultAnswer> faultAnswerList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public FaultAnswer present(FaultAnswer faultAnswer,Map<String,Object> options) throws Exception;
	public FaultAnswer clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public FaultAnswer save(FaultAnswer faultAnswer,Map<String,Object> options);
	public SmartList<FaultAnswer> saveFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options);
	public SmartList<FaultAnswer> removeFaultAnswerList(SmartList<FaultAnswer> faultAnswerList,Map<String,Object> options);
	public SmartList<FaultAnswer> findFaultAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countFaultAnswerWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countFaultAnswerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String faultAnswerId, int version) throws Exception;
	public FaultAnswer disconnectFromAll(String faultAnswerId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<FaultAnswer> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<FaultAnswer> findFaultAnswerByUser(String wechatUserId, Map<String,Object> options);
 	public int countFaultAnswerByUser(String wechatUserId, Map<String,Object> options);
 	public Map<String, Integer> countFaultAnswerByUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<FaultAnswer> findFaultAnswerByUser(String wechatUserId, int start, int count, Map<String,Object> options);
 	public void analyzeFaultAnswerByUser(SmartList<FaultAnswer> resultList, String wechatUserId, Map<String,Object> options);

 
  
 	public SmartList<FaultAnswer> findFaultAnswerByQuestion(String questionId, Map<String,Object> options);
 	public int countFaultAnswerByQuestion(String questionId, Map<String,Object> options);
 	public Map<String, Integer> countFaultAnswerByQuestionIds(String[] ids, Map<String,Object> options);
 	public SmartList<FaultAnswer> findFaultAnswerByQuestion(String questionId, int start, int count, Map<String,Object> options);
 	public void analyzeFaultAnswerByQuestion(SmartList<FaultAnswer> resultList, String questionId, Map<String,Object> options);

 
 
}


