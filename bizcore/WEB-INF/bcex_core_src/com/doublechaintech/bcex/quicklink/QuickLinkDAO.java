
package com.doublechaintech.bcex.quicklink;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.userapp.UserApp;

import com.doublechaintech.bcex.userapp.UserAppDAO;


public interface QuickLinkDAO{

	public SmartList<QuickLink> loadAll();
	public QuickLink load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<QuickLink> quickLinkList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public QuickLink present(QuickLink quickLink,Map<String,Object> options) throws Exception;
	public QuickLink clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public QuickLink save(QuickLink quickLink,Map<String,Object> options);
	public SmartList<QuickLink> saveQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options);
	public SmartList<QuickLink> removeQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options);
	public SmartList<QuickLink> findQuickLinkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countQuickLinkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countQuickLinkWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String quickLinkId, int version) throws Exception;
	public QuickLink disconnectFromAll(String quickLinkId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<QuickLink> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId, Map<String,Object> options);
 	public int countQuickLinkByApp(String userAppId, Map<String,Object> options);
 	public Map<String, Integer> countQuickLinkByAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId, int start, int count, Map<String,Object> options);
 	public void analyzeQuickLinkByApp(SmartList<QuickLink> resultList, String userAppId, Map<String,Object> options);

 
 
}


