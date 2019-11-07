
package com.doublechaintech.bcex.examranking;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.platform.Platform;

import com.doublechaintech.bcex.platform.PlatformDAO;


public interface ExamRankingDAO{

	public SmartList<ExamRanking> loadAll();
	public ExamRanking load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<ExamRanking> examRankingList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public ExamRanking present(ExamRanking examRanking,Map<String,Object> options) throws Exception;
	public ExamRanking clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public ExamRanking save(ExamRanking examRanking,Map<String,Object> options);
	public SmartList<ExamRanking> saveExamRankingList(SmartList<ExamRanking> examRankingList,Map<String,Object> options);
	public SmartList<ExamRanking> removeExamRankingList(SmartList<ExamRanking> examRankingList,Map<String,Object> options);
	public SmartList<ExamRanking> findExamRankingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countExamRankingWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countExamRankingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String examRankingId, int version) throws Exception;
	public ExamRanking disconnectFromAll(String examRankingId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<ExamRanking> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<ExamRanking> findExamRankingByPlatform(String platformId, Map<String,Object> options);
 	public int countExamRankingByPlatform(String platformId, Map<String,Object> options);
 	public Map<String, Integer> countExamRankingByPlatformIds(String[] ids, Map<String,Object> options);
 	public SmartList<ExamRanking> findExamRankingByPlatform(String platformId, int start, int count, Map<String,Object> options);
 	public void analyzeExamRankingByPlatform(SmartList<ExamRanking> resultList, String platformId, Map<String,Object> options);

 
 
}


