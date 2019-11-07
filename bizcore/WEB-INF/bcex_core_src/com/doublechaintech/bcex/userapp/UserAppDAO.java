
package com.doublechaintech.bcex.userapp;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.secuser.SecUser;
import com.doublechaintech.bcex.objectaccess.ObjectAccess;
import com.doublechaintech.bcex.quicklink.QuickLink;
import com.doublechaintech.bcex.listaccess.ListAccess;

import com.doublechaintech.bcex.objectaccess.ObjectAccessDAO;
import com.doublechaintech.bcex.listaccess.ListAccessDAO;
import com.doublechaintech.bcex.secuser.SecUserDAO;
import com.doublechaintech.bcex.quicklink.QuickLinkDAO;


public interface UserAppDAO{

	public SmartList<UserApp> loadAll();
	public UserApp load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserApp> userAppList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserApp present(UserApp userApp,Map<String,Object> options) throws Exception;
	public UserApp clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserApp save(UserApp userApp,Map<String,Object> options);
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> findUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userAppId, int version) throws Exception;
	public UserApp disconnectFromAll(String userAppId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public QuickLinkDAO getQuickLinkDAO();
		
	public ListAccessDAO getListAccessDAO();
		
	public ObjectAccessDAO getObjectAccessDAO();
		
	
 	public SmartList<UserApp> requestCandidateUserAppForQuickLink(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserApp> requestCandidateUserAppForListAccess(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserApp> requestCandidateUserAppForObjectAccess(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserApp planToRemoveQuickLinkList(UserApp userApp, String quickLinkIds[], Map<String,Object> options)throws Exception;


	public UserApp planToRemoveListAccessList(UserApp userApp, String listAccessIds[], Map<String,Object> options)throws Exception;


	public UserApp planToRemoveObjectAccessList(UserApp userApp, String objectAccessIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserApp> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public int countUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countUserAppBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAppBySecUser(SmartList<UserApp> resultList, String secUserId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:QuickLink的app的QuickLinkList
	public SmartList<QuickLink> loadOurQuickLinkList(BcexUserContext userContext, List<UserApp> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ListAccess的app的ListAccessList
	public SmartList<ListAccess> loadOurListAccessList(BcexUserContext userContext, List<UserApp> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ObjectAccess的app的ObjectAccessList
	public SmartList<ObjectAccess> loadOurObjectAccessList(BcexUserContext userContext, List<UserApp> us, Map<String,Object> options) throws Exception;
	
}


