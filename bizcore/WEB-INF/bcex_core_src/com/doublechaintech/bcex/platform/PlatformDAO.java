
package com.doublechaintech.bcex.platform;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;
import com.doublechaintech.bcex.examstatus.ExamStatusDAO;
import com.doublechaintech.bcex.question.QuestionDAO;
import com.doublechaintech.bcex.examranking.ExamRankingDAO;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeDAO;


public interface PlatformDAO{

	public SmartList<Platform> loadAll();
	public Platform load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Platform> platformList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Platform present(Platform platform,Map<String,Object> options) throws Exception;
	public Platform clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Platform save(Platform platform,Map<String,Object> options);
	public SmartList<Platform> savePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> removePlatformList(SmartList<Platform> platformList,Map<String,Object> options);
	public SmartList<Platform> findPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPlatformWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPlatformWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String platformId, int version) throws Exception;
	public Platform disconnectFromAll(String platformId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ChangeRequestTypeDAO getChangeRequestTypeDAO();
		
	public ChangeRequestDAO getChangeRequestDAO();
		
	public ExamStatusDAO getExamStatusDAO();
		
	public QuestionDAO getQuestionDAO();
		
	public ExamRankingDAO getExamRankingDAO();
		
	public WechatUserDAO getWechatUserDAO();
		
	
 	public SmartList<Platform> requestCandidatePlatformForChangeRequestType(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForChangeRequest(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForExamStatus(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForQuestion(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForExamRanking(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Platform> requestCandidatePlatformForWechatUser(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Platform planToRemoveChangeRequestTypeList(Platform platform, String changeRequestTypeIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveChangeRequestList(Platform platform, String changeRequestIds[], Map<String,Object> options)throws Exception;


	//disconnect Platform with request_type in ChangeRequest
	public Platform planToRemoveChangeRequestListWithRequestType(Platform platform, String requestTypeId, Map<String,Object> options)throws Exception;
	public int countChangeRequestListWithRequestType(String platformId, String requestTypeId, Map<String,Object> options)throws Exception;
	
	public Platform planToRemoveExamStatusList(Platform platform, String examStatusIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveQuestionList(Platform platform, String questionIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveExamRankingList(Platform platform, String examRankingIds[], Map<String,Object> options)throws Exception;


	public Platform planToRemoveWechatUserList(Platform platform, String wechatUserIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<Platform> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);

	// 需要一个加载引用我的对象的enhance方法:ChangeRequestType的platform的ChangeRequestTypeList
	public SmartList<ChangeRequestType> loadOurChangeRequestTypeList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ChangeRequest的platform的ChangeRequestList
	public SmartList<ChangeRequest> loadOurChangeRequestList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ExamStatus的platform的ExamStatusList
	public SmartList<ExamStatus> loadOurExamStatusList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:Question的platform的QuestionList
	public SmartList<Question> loadOurQuestionList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ExamRanking的platform的ExamRankingList
	public SmartList<ExamRanking> loadOurExamRankingList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatUser的platform的WechatUserList
	public SmartList<WechatUser> loadOurWechatUserList(BcexUserContext userContext, List<Platform> us, Map<String,Object> options) throws Exception;
	
}


