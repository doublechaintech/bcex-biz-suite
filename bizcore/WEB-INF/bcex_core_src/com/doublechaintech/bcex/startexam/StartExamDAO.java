
package com.doublechaintech.bcex.startexam;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.changerequest.ChangeRequest;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;


public interface StartExamDAO{

	public SmartList<StartExam> loadAll();
	public StartExam load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<StartExam> startExamList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public StartExam present(StartExam startExam,Map<String,Object> options) throws Exception;
	public StartExam clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public StartExam save(StartExam startExam,Map<String,Object> options);
	public SmartList<StartExam> saveStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options);
	public SmartList<StartExam> removeStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options);
	public SmartList<StartExam> findStartExamWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countStartExamWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countStartExamWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String startExamId, int version) throws Exception;
	public StartExam disconnectFromAll(String startExamId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<StartExam> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<StartExam> findStartExamByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public int countStartExamByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public Map<String, Integer> countStartExamByChangeRequestIds(String[] ids, Map<String,Object> options);
 	public SmartList<StartExam> findStartExamByChangeRequest(String changeRequestId, int start, int count, Map<String,Object> options);
 	public void analyzeStartExamByChangeRequest(SmartList<StartExam> resultList, String changeRequestId, Map<String,Object> options);

 
 
}


