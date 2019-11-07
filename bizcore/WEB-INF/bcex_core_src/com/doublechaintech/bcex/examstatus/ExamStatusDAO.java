
package com.doublechaintech.bcex.examstatus;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;


public interface ExamStatusDAO{

	public SmartList<ExamStatus> loadAll();
	public ExamStatus load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ExamStatus> examStatusList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ExamStatus loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public ExamStatus present(ExamStatus examStatus,Map<String,Object> options) throws Exception;
	public ExamStatus clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ExamStatus cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public ExamStatus save(ExamStatus examStatus,Map<String,Object> options);
	public SmartList<ExamStatus> saveExamStatusList(SmartList<ExamStatus> examStatusList,Map<String,Object> options);
	public SmartList<ExamStatus> removeExamStatusList(SmartList<ExamStatus> examStatusList,Map<String,Object> options);
	public SmartList<ExamStatus> findExamStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countExamStatusWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countExamStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String examStatusId, int version) throws Exception;
	public ExamStatus disconnectFromAll(String examStatusId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ExamDAO getExamDAO();
		
	
 	public SmartList<ExamStatus> requestCandidateExamStatusForExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public ExamStatus planToRemoveExamList(ExamStatus examStatus, String examIds[], Map<String,Object> options)throws Exception;


	//disconnect ExamStatus with user in Exam
	public ExamStatus planToRemoveExamListWithUser(ExamStatus examStatus, String userId, Map<String,Object> options)throws Exception;
	public int countExamListWithUser(String examStatusId, String userId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<ExamStatus> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ExamStatus> findExamStatusByPlatform(String platformId, Map<String,Object> options);
 	public int countExamStatusByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countExamStatusByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<ExamStatus> findExamStatusByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeExamStatusByPlatform(SmartList<ExamStatus> resultList, String platformId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Exam的status的ExamList
	public SmartList<Exam> loadOurExamList(BcexUserContext userContext, List<ExamStatus> us, Map<String,Object> options) throws Exception;
	
}


