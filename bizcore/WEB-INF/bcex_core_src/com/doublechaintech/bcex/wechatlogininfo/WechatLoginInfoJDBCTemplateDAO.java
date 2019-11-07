
package com.doublechaintech.bcex.wechatlogininfo;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.bcex.BcexBaseDAOImpl;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.AccessKey;
import com.doublechaintech.bcex.DateKey;
import com.doublechaintech.bcex.StatsInfo;
import com.doublechaintech.bcex.StatsItem;

import com.doublechaintech.bcex.MultipleAccessKey;
import com.doublechaintech.bcex.BcexUserContext;


import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.wechatuser.WechatUserDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class WechatLoginInfoJDBCTemplateDAO extends BcexBaseDAOImpl implements WechatLoginInfoDAO{
 
 	
 	private  WechatUserDAO  wechatUserDAO;
 	public void setWechatUserDAO(WechatUserDAO wechatUserDAO){
	 	this.wechatUserDAO = wechatUserDAO;
 	}
 	public WechatUserDAO getWechatUserDAO(){
	 	return this.wechatUserDAO;
 	}


			
		

	
	/*
	protected WechatLoginInfo load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalWechatLoginInfo(accessKey, options);
	}
	*/
	
	public SmartList<WechatLoginInfo> loadAll() {
	    return this.loadAll(getWechatLoginInfoMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public WechatLoginInfo load(String id,Map<String,Object> options) throws Exception{
		return loadInternalWechatLoginInfo(WechatLoginInfoTable.withId(id), options);
	}
	
	
	
	public WechatLoginInfo save(WechatLoginInfo wechatLoginInfo,Map<String,Object> options){
		
		String methodName="save(WechatLoginInfo wechatLoginInfo,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(wechatLoginInfo, methodName, "wechatLoginInfo");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalWechatLoginInfo(wechatLoginInfo,options);
	}
	public WechatLoginInfo clone(String wechatLoginInfoId, Map<String,Object> options) throws Exception{
	
		return clone(WechatLoginInfoTable.withId(wechatLoginInfoId),options);
	}
	
	protected WechatLoginInfo clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String wechatLoginInfoId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		WechatLoginInfo newWechatLoginInfo = loadInternalWechatLoginInfo(accessKey, options);
		newWechatLoginInfo.setVersion(0);
		
		

		
		saveInternalWechatLoginInfo(newWechatLoginInfo,options);
		
		return newWechatLoginInfo;
	}
	
	
	
	

	protected void throwIfHasException(String wechatLoginInfoId,int version,int count) throws Exception{
		if (count == 1) {
			throw new WechatLoginInfoVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new WechatLoginInfoNotFoundException(
					"The " + this.getTableName() + "(" + wechatLoginInfoId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String wechatLoginInfoId, int version) throws Exception{
	
		String methodName="delete(String wechatLoginInfoId, int version)";
		assertMethodArgumentNotNull(wechatLoginInfoId, methodName, "wechatLoginInfoId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{wechatLoginInfoId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(wechatLoginInfoId,version);
		}
		
	
	}
	
	
	
	
	

	public WechatLoginInfo disconnectFromAll(String wechatLoginInfoId, int version) throws Exception{
	
		
		WechatLoginInfo wechatLoginInfo = loadInternalWechatLoginInfo(WechatLoginInfoTable.withId(wechatLoginInfoId), emptyOptions());
		wechatLoginInfo.clearFromAll();
		this.saveWechatLoginInfo(wechatLoginInfo);
		return wechatLoginInfo;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return WechatLoginInfoTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "wechat_login_info";
	}
	@Override
	protected String getBeanName() {
		
		return "wechatLoginInfo";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return WechatLoginInfoTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractWechatUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, WechatLoginInfoTokens.WECHATUSER);
 	}

 	protected boolean isSaveWechatUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, WechatLoginInfoTokens.WECHATUSER);
 	}
 	

 	
 
		

	

	protected WechatLoginInfoMapper getWechatLoginInfoMapper(){
		return new WechatLoginInfoMapper();
	}

	
	
	protected WechatLoginInfo extractWechatLoginInfo(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			WechatLoginInfo wechatLoginInfo = loadSingleObject(accessKey, getWechatLoginInfoMapper());
			return wechatLoginInfo;
		}catch(EmptyResultDataAccessException e){
			throw new WechatLoginInfoNotFoundException("WechatLoginInfo("+accessKey+") is not found!");
		}

	}

	
	

	protected WechatLoginInfo loadInternalWechatLoginInfo(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		WechatLoginInfo wechatLoginInfo = extractWechatLoginInfo(accessKey, loadOptions);
 	
 		if(isExtractWechatUserEnabled(loadOptions)){
	 		extractWechatUser(wechatLoginInfo, loadOptions);
 		}
 
		
		return wechatLoginInfo;
		
	}

	 

 	protected WechatLoginInfo extractWechatUser(WechatLoginInfo wechatLoginInfo, Map<String,Object> options) throws Exception{

		if(wechatLoginInfo.getWechatUser() == null){
			return wechatLoginInfo;
		}
		String wechatUserId = wechatLoginInfo.getWechatUser().getId();
		if( wechatUserId == null){
			return wechatLoginInfo;
		}
		WechatUser wechatUser = getWechatUserDAO().load(wechatUserId,options);
		if(wechatUser != null){
			wechatLoginInfo.setWechatUser(wechatUser);
		}
		
 		
 		return wechatLoginInfo;
 	}
 		
 
		
		
  	
 	public SmartList<WechatLoginInfo> findWechatLoginInfoByWechatUser(String wechatUserId,Map<String,Object> options){
 	
  		SmartList<WechatLoginInfo> resultList = queryWith(WechatLoginInfoTable.COLUMN_WECHAT_USER, wechatUserId, options, getWechatLoginInfoMapper());
		// analyzeWechatLoginInfoByWechatUser(resultList, wechatUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<WechatLoginInfo> findWechatLoginInfoByWechatUser(String wechatUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<WechatLoginInfo> resultList =  queryWithRange(WechatLoginInfoTable.COLUMN_WECHAT_USER, wechatUserId, options, getWechatLoginInfoMapper(), start, count);
 		//analyzeWechatLoginInfoByWechatUser(resultList, wechatUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeWechatLoginInfoByWechatUser(SmartList<WechatLoginInfo> resultList, String wechatUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(WechatLoginInfo.WECHAT_USER_PROPERTY, wechatUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("微信登录信息");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countWechatLoginInfoByWechatUser(String wechatUserId,Map<String,Object> options){

 		return countWith(WechatLoginInfoTable.COLUMN_WECHAT_USER, wechatUserId, options);
 	}
 	@Override
	public Map<String, Integer> countWechatLoginInfoByWechatUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(WechatLoginInfoTable.COLUMN_WECHAT_USER, ids, options);
	}
 	
 	
		
		
		

	

	protected WechatLoginInfo saveWechatLoginInfo(WechatLoginInfo  wechatLoginInfo){
		
		if(!wechatLoginInfo.isChanged()){
			return wechatLoginInfo;
		}
		
		
		String SQL=this.getSaveWechatLoginInfoSQL(wechatLoginInfo);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveWechatLoginInfoParameters(wechatLoginInfo);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		wechatLoginInfo.incVersion();
		return wechatLoginInfo;
	
	}
	public SmartList<WechatLoginInfo> saveWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitWechatLoginInfoList(wechatLoginInfoList);
		
		batchWechatLoginInfoCreate((List<WechatLoginInfo>)lists[CREATE_LIST_INDEX]);
		
		batchWechatLoginInfoUpdate((List<WechatLoginInfo>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(WechatLoginInfo wechatLoginInfo:wechatLoginInfoList){
			if(wechatLoginInfo.isChanged()){
				wechatLoginInfo.incVersion();
			}
			
		
		}
		
		
		return wechatLoginInfoList;
	}

	public SmartList<WechatLoginInfo> removeWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList,Map<String,Object> options){
		
		
		super.removeList(wechatLoginInfoList, options);
		
		return wechatLoginInfoList;
		
		
	}
	
	protected List<Object[]> prepareWechatLoginInfoBatchCreateArgs(List<WechatLoginInfo> wechatLoginInfoList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatLoginInfo wechatLoginInfo:wechatLoginInfoList ){
			Object [] parameters = prepareWechatLoginInfoCreateParameters(wechatLoginInfo);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareWechatLoginInfoBatchUpdateArgs(List<WechatLoginInfo> wechatLoginInfoList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(WechatLoginInfo wechatLoginInfo:wechatLoginInfoList ){
			if(!wechatLoginInfo.isChanged()){
				continue;
			}
			Object [] parameters = prepareWechatLoginInfoUpdateParameters(wechatLoginInfo);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchWechatLoginInfoCreate(List<WechatLoginInfo> wechatLoginInfoList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareWechatLoginInfoBatchCreateArgs(wechatLoginInfoList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchWechatLoginInfoUpdate(List<WechatLoginInfo> wechatLoginInfoList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareWechatLoginInfoBatchUpdateArgs(wechatLoginInfoList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitWechatLoginInfoList(List<WechatLoginInfo> wechatLoginInfoList){
		
		List<WechatLoginInfo> wechatLoginInfoCreateList=new ArrayList<WechatLoginInfo>();
		List<WechatLoginInfo> wechatLoginInfoUpdateList=new ArrayList<WechatLoginInfo>();
		
		for(WechatLoginInfo wechatLoginInfo: wechatLoginInfoList){
			if(isUpdateRequest(wechatLoginInfo)){
				wechatLoginInfoUpdateList.add( wechatLoginInfo);
				continue;
			}
			wechatLoginInfoCreateList.add(wechatLoginInfo);
		}
		
		return new Object[]{wechatLoginInfoCreateList,wechatLoginInfoUpdateList};
	}
	
	protected boolean isUpdateRequest(WechatLoginInfo wechatLoginInfo){
 		return wechatLoginInfo.getVersion() > 0;
 	}
 	protected String getSaveWechatLoginInfoSQL(WechatLoginInfo wechatLoginInfo){
 		if(isUpdateRequest(wechatLoginInfo)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveWechatLoginInfoParameters(WechatLoginInfo wechatLoginInfo){
 		if(isUpdateRequest(wechatLoginInfo) ){
 			return prepareWechatLoginInfoUpdateParameters(wechatLoginInfo);
 		}
 		return prepareWechatLoginInfoCreateParameters(wechatLoginInfo);
 	}
 	protected Object[] prepareWechatLoginInfoUpdateParameters(WechatLoginInfo wechatLoginInfo){
 		Object[] parameters = new Object[8];
  	
 		if(wechatLoginInfo.getWechatUser() != null){
 			parameters[0] = wechatLoginInfo.getWechatUser().getId();
 		}
 
 		parameters[1] = wechatLoginInfo.getAppId();
 		parameters[2] = wechatLoginInfo.getOpenId();
 		parameters[3] = wechatLoginInfo.getSessionKey();
 		parameters[4] = wechatLoginInfo.getLastUpdateTime();		
 		parameters[5] = wechatLoginInfo.nextVersion();
 		parameters[6] = wechatLoginInfo.getId();
 		parameters[7] = wechatLoginInfo.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareWechatLoginInfoCreateParameters(WechatLoginInfo wechatLoginInfo){
		Object[] parameters = new Object[6];
		String newWechatLoginInfoId=getNextId();
		wechatLoginInfo.setId(newWechatLoginInfoId);
		parameters[0] =  wechatLoginInfo.getId();
  	
 		if(wechatLoginInfo.getWechatUser() != null){
 			parameters[1] = wechatLoginInfo.getWechatUser().getId();
 		
 		}
 		
 		parameters[2] = wechatLoginInfo.getAppId();
 		parameters[3] = wechatLoginInfo.getOpenId();
 		parameters[4] = wechatLoginInfo.getSessionKey();
 		parameters[5] = wechatLoginInfo.getLastUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected WechatLoginInfo saveInternalWechatLoginInfo(WechatLoginInfo wechatLoginInfo, Map<String,Object> options){
		
		saveWechatLoginInfo(wechatLoginInfo);
 	
 		if(isSaveWechatUserEnabled(options)){
	 		saveWechatUser(wechatLoginInfo, options);
 		}
 
		
		return wechatLoginInfo;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected WechatLoginInfo saveWechatUser(WechatLoginInfo wechatLoginInfo, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(wechatLoginInfo.getWechatUser() == null){
 			return wechatLoginInfo;//do nothing when it is null
 		}
 		
 		getWechatUserDAO().save(wechatLoginInfo.getWechatUser(),options);
 		return wechatLoginInfo;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public WechatLoginInfo present(WechatLoginInfo wechatLoginInfo,Map<String, Object> options){
	

		return wechatLoginInfo;
	
	}
		

	

	protected String getTableName(){
		return WechatLoginInfoTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<WechatLoginInfo> wechatLoginInfoList) {		
		this.enhanceListInternal(wechatLoginInfoList, this.getWechatLoginInfoMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<WechatLoginInfo> wechatLoginInfoList = ownerEntity.collectRefsWithType(WechatLoginInfo.INTERNAL_TYPE);
		this.enhanceList(wechatLoginInfoList);
		
	}
	
	@Override
	public SmartList<WechatLoginInfo> findWechatLoginInfoWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getWechatLoginInfoMapper());

	}
	@Override
	public int countWechatLoginInfoWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countWechatLoginInfoWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<WechatLoginInfo> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getWechatLoginInfoMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


