
package com.doublechaintech.bcex.registration;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;

import com.doublechaintech.bcex.changerequest.ChangeRequest;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;


public interface RegistrationDAO{

	public SmartList<Registration> loadAll();
	public Registration load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Registration> registrationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Registration present(Registration registration,Map<String,Object> options) throws Exception;
	public Registration clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Registration save(Registration registration,Map<String,Object> options);
	public SmartList<Registration> saveRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options);
	public SmartList<Registration> removeRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options);
	public SmartList<Registration> findRegistrationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countRegistrationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countRegistrationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String registrationId, int version) throws Exception;
	public Registration disconnectFromAll(String registrationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Registration> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
 
 	public SmartList<Registration> findRegistrationByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public int countRegistrationByChangeRequest(String changeRequestId, Map<String,Object> options);
 	public Map<String, Integer> countRegistrationByChangeRequestIds(String[] ids, Map<String,Object> options);
 	public SmartList<Registration> findRegistrationByChangeRequest(String changeRequestId, int start, int count, Map<String,Object> options);
 	public void analyzeRegistrationByChangeRequest(SmartList<Registration> resultList, String changeRequestId, Map<String,Object> options);

 
 
}


