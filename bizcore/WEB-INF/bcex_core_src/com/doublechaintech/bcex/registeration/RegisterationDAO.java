
package com.doublechaintech.bcex.registeration;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.changerequest.ChangeRequest;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;


public interface RegisterationDAO{

	public SmartList<Registeration> loadAll();
	public Registeration load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Registeration> registerationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Registeration present(Registeration registeration,Map<String,Object> options) throws Exception;
	public Registeration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Registeration save(Registeration registeration,Map<String,Object> options);
	public SmartList<Registeration> saveRegisterationList(SmartList<Registeration> registerationList,Map<String,Object> options);
	public SmartList<Registeration> removeRegisterationList(SmartList<Registeration> registerationList,Map<String,Object> options);
	public SmartList<Registeration> findRegisterationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRegisterationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRegisterationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String registerationId, int version) throws Exception;
	public Registeration disconnectFromAll(String registerationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Registeration> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Registeration> findRegisterationByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public int countRegisterationByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public Map<String, Integer> countRegisterationByChangeRequestIds(String[] ids, Map<String,Object> options);
 	public SmartList<Registeration> findRegisterationByChangeRequest(String changeRequestId, int start, int count, Map<String,Object> options);
 	public void analyzeRegisterationByChangeRequest(SmartList<Registeration> resultList, String changeRequestId, Map<String,Object> options);

 
 
}


