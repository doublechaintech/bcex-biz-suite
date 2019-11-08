
package com.doublechaintech.bcex.startexam;

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


import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.wechatuser.WechatUser;

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;
import com.doublechaintech.bcex.wechatuser.WechatUserDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class StartExamJDBCTemplateDAO extends BcexBaseDAOImpl implements StartExamDAO{
 
 	
 	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO changeRequestDAO){
	 	this.changeRequestDAO = changeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
	 	return this.changeRequestDAO;
 	}
 
 	
 	private  WechatUserDAO  wechatUserDAO;
 	public void setWechatUserDAO(WechatUserDAO wechatUserDAO){
	 	this.wechatUserDAO = wechatUserDAO;
 	}
 	public WechatUserDAO getWechatUserDAO(){
	 	return this.wechatUserDAO;
 	}


			
		

	
	/*
	protected StartExam load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalStartExam(accessKey, options);
	}
	*/
	
	public SmartList<StartExam> loadAll() {
	    return this.loadAll(getStartExamMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public StartExam load(String id,Map<String,Object> options) throws Exception{
		return loadInternalStartExam(StartExamTable.withId(id), options);
	}
	
	
	
	public StartExam save(StartExam startExam,Map<String,Object> options){
		
		String methodName="save(StartExam startExam,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(startExam, methodName, "startExam");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalStartExam(startExam,options);
	}
	public StartExam clone(String startExamId, Map<String,Object> options) throws Exception{
	
		return clone(StartExamTable.withId(startExamId),options);
	}
	
	protected StartExam clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String startExamId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		StartExam newStartExam = loadInternalStartExam(accessKey, options);
		newStartExam.setVersion(0);
		
		

		
		saveInternalStartExam(newStartExam,options);
		
		return newStartExam;
	}
	
	
	
	

	protected void throwIfHasException(String startExamId,int version,int count) throws Exception{
		if (count == 1) {
			throw new StartExamVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new StartExamNotFoundException(
					"The " + this.getTableName() + "(" + startExamId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String startExamId, int version) throws Exception{
	
		String methodName="delete(String startExamId, int version)";
		assertMethodArgumentNotNull(startExamId, methodName, "startExamId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{startExamId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(startExamId,version);
		}
		
	
	}
	
	
	
	
	

	public StartExam disconnectFromAll(String startExamId, int version) throws Exception{
	
		
		StartExam startExam = loadInternalStartExam(StartExamTable.withId(startExamId), emptyOptions());
		startExam.clearFromAll();
		this.saveStartExam(startExam);
		return startExam;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return StartExamTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "start_exam";
	}
	@Override
	protected String getBeanName() {
		
		return "startExam";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return StartExamTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractUserEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, StartExamTokens.USER);
 	}

 	protected boolean isSaveUserEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, StartExamTokens.USER);
 	}
 	

 	
  

 	protected boolean isExtractChangeRequestEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, StartExamTokens.CHANGEREQUEST);
 	}

 	protected boolean isSaveChangeRequestEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, StartExamTokens.CHANGEREQUEST);
 	}
 	

 	
 
		

	

	protected StartExamMapper getStartExamMapper(){
		return new StartExamMapper();
	}

	
	
	protected StartExam extractStartExam(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			StartExam startExam = loadSingleObject(accessKey, getStartExamMapper());
			return startExam;
		}catch(EmptyResultDataAccessException e){
			throw new StartExamNotFoundException("StartExam("+accessKey+") is not found!");
		}

	}

	
	

	protected StartExam loadInternalStartExam(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		StartExam startExam = extractStartExam(accessKey, loadOptions);
 	
 		if(isExtractUserEnabled(loadOptions)){
	 		extractUser(startExam, loadOptions);
 		}
  	
 		if(isExtractChangeRequestEnabled(loadOptions)){
	 		extractChangeRequest(startExam, loadOptions);
 		}
 
		
		return startExam;
		
	}

	 

 	protected StartExam extractUser(StartExam startExam, Map<String,Object> options) throws Exception{

		if(startExam.getUser() == null){
			return startExam;
		}
		String userId = startExam.getUser().getId();
		if( userId == null){
			return startExam;
		}
		WechatUser user = getWechatUserDAO().load(userId,options);
		if(user != null){
			startExam.setUser(user);
		}
		
 		
 		return startExam;
 	}
 		
  

 	protected StartExam extractChangeRequest(StartExam startExam, Map<String,Object> options) throws Exception{

		if(startExam.getChangeRequest() == null){
			return startExam;
		}
		String changeRequestId = startExam.getChangeRequest().getId();
		if( changeRequestId == null){
			return startExam;
		}
		ChangeRequest changeRequest = getChangeRequestDAO().load(changeRequestId,options);
		if(changeRequest != null){
			startExam.setChangeRequest(changeRequest);
		}
		
 		
 		return startExam;
 	}
 		
 
		
		
  	
 	public SmartList<StartExam> findStartExamByUser(String wechatUserId,Map<String,Object> options){
 	
  		SmartList<StartExam> resultList = queryWith(StartExamTable.COLUMN_USER, wechatUserId, options, getStartExamMapper());
		// analyzeStartExamByUser(resultList, wechatUserId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<StartExam> findStartExamByUser(String wechatUserId, int start, int count,Map<String,Object> options){
 		
 		SmartList<StartExam> resultList =  queryWithRange(StartExamTable.COLUMN_USER, wechatUserId, options, getStartExamMapper(), start, count);
 		//analyzeStartExamByUser(resultList, wechatUserId, options);
 		return resultList;
 		
 	}
 	public void analyzeStartExamByUser(SmartList<StartExam> resultList, String wechatUserId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(StartExam.USER_PROPERTY, wechatUserId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countStartExamByUser(String wechatUserId,Map<String,Object> options){

 		return countWith(StartExamTable.COLUMN_USER, wechatUserId, options);
 	}
 	@Override
	public Map<String, Integer> countStartExamByUserIds(String[] ids, Map<String, Object> options) {
		return countWithIds(StartExamTable.COLUMN_USER, ids, options);
	}
 	
  	
 	public SmartList<StartExam> findStartExamByChangeRequest(String changeRequestId,Map<String,Object> options){
 	
  		SmartList<StartExam> resultList = queryWith(StartExamTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getStartExamMapper());
		// analyzeStartExamByChangeRequest(resultList, changeRequestId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<StartExam> findStartExamByChangeRequest(String changeRequestId, int start, int count,Map<String,Object> options){
 		
 		SmartList<StartExam> resultList =  queryWithRange(StartExamTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getStartExamMapper(), start, count);
 		//analyzeStartExamByChangeRequest(resultList, changeRequestId, options);
 		return resultList;
 		
 	}
 	public void analyzeStartExamByChangeRequest(SmartList<StartExam> resultList, String changeRequestId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(StartExam.CHANGE_REQUEST_PROPERTY, changeRequestId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 		
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countStartExamByChangeRequest(String changeRequestId,Map<String,Object> options){

 		return countWith(StartExamTable.COLUMN_CHANGE_REQUEST, changeRequestId, options);
 	}
 	@Override
	public Map<String, Integer> countStartExamByChangeRequestIds(String[] ids, Map<String, Object> options) {
		return countWithIds(StartExamTable.COLUMN_CHANGE_REQUEST, ids, options);
	}
 	
 	
		
		
		

	

	protected StartExam saveStartExam(StartExam  startExam){
		
		if(!startExam.isChanged()){
			return startExam;
		}
		
		
		String SQL=this.getSaveStartExamSQL(startExam);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveStartExamParameters(startExam);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		startExam.incVersion();
		return startExam;
	
	}
	public SmartList<StartExam> saveStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitStartExamList(startExamList);
		
		batchStartExamCreate((List<StartExam>)lists[CREATE_LIST_INDEX]);
		
		batchStartExamUpdate((List<StartExam>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(StartExam startExam:startExamList){
			if(startExam.isChanged()){
				startExam.incVersion();
			}
			
		
		}
		
		
		return startExamList;
	}

	public SmartList<StartExam> removeStartExamList(SmartList<StartExam> startExamList,Map<String,Object> options){
		
		
		super.removeList(startExamList, options);
		
		return startExamList;
		
		
	}
	
	protected List<Object[]> prepareStartExamBatchCreateArgs(List<StartExam> startExamList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StartExam startExam:startExamList ){
			Object [] parameters = prepareStartExamCreateParameters(startExam);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareStartExamBatchUpdateArgs(List<StartExam> startExamList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(StartExam startExam:startExamList ){
			if(!startExam.isChanged()){
				continue;
			}
			Object [] parameters = prepareStartExamUpdateParameters(startExam);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchStartExamCreate(List<StartExam> startExamList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareStartExamBatchCreateArgs(startExamList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchStartExamUpdate(List<StartExam> startExamList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareStartExamBatchUpdateArgs(startExamList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitStartExamList(List<StartExam> startExamList){
		
		List<StartExam> startExamCreateList=new ArrayList<StartExam>();
		List<StartExam> startExamUpdateList=new ArrayList<StartExam>();
		
		for(StartExam startExam: startExamList){
			if(isUpdateRequest(startExam)){
				startExamUpdateList.add( startExam);
				continue;
			}
			startExamCreateList.add(startExam);
		}
		
		return new Object[]{startExamCreateList,startExamUpdateList};
	}
	
	protected boolean isUpdateRequest(StartExam startExam){
 		return startExam.getVersion() > 0;
 	}
 	protected String getSaveStartExamSQL(StartExam startExam){
 		if(isUpdateRequest(startExam)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveStartExamParameters(StartExam startExam){
 		if(isUpdateRequest(startExam) ){
 			return prepareStartExamUpdateParameters(startExam);
 		}
 		return prepareStartExamCreateParameters(startExam);
 	}
 	protected Object[] prepareStartExamUpdateParameters(StartExam startExam){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = startExam.getNickName(); 	
 		if(startExam.getUser() != null){
 			parameters[1] = startExam.getUser().getId();
 		}
  	
 		if(startExam.getChangeRequest() != null){
 			parameters[2] = startExam.getChangeRequest().getId();
 		}
 		
 		parameters[3] = startExam.nextVersion();
 		parameters[4] = startExam.getId();
 		parameters[5] = startExam.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareStartExamCreateParameters(StartExam startExam){
		Object[] parameters = new Object[4];
		String newStartExamId=getNextId();
		startExam.setId(newStartExamId);
		parameters[0] =  startExam.getId();
 
 		parameters[1] = startExam.getNickName(); 	
 		if(startExam.getUser() != null){
 			parameters[2] = startExam.getUser().getId();
 		
 		}
 		 	
 		if(startExam.getChangeRequest() != null){
 			parameters[3] = startExam.getChangeRequest().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected StartExam saveInternalStartExam(StartExam startExam, Map<String,Object> options){
		
		saveStartExam(startExam);
 	
 		if(isSaveUserEnabled(options)){
	 		saveUser(startExam, options);
 		}
  	
 		if(isSaveChangeRequestEnabled(options)){
	 		saveChangeRequest(startExam, options);
 		}
 
		
		return startExam;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected StartExam saveUser(StartExam startExam, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(startExam.getUser() == null){
 			return startExam;//do nothing when it is null
 		}
 		
 		getWechatUserDAO().save(startExam.getUser(),options);
 		return startExam;
 		
 	}
 	
 	
 	
 	 
	
  
 
 	protected StartExam saveChangeRequest(StartExam startExam, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(startExam.getChangeRequest() == null){
 			return startExam;//do nothing when it is null
 		}
 		
 		getChangeRequestDAO().save(startExam.getChangeRequest(),options);
 		return startExam;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public StartExam present(StartExam startExam,Map<String, Object> options){
	

		return startExam;
	
	}
		

	

	protected String getTableName(){
		return StartExamTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<StartExam> startExamList) {		
		this.enhanceListInternal(startExamList, this.getStartExamMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<StartExam> startExamList = ownerEntity.collectRefsWithType(StartExam.INTERNAL_TYPE);
		this.enhanceList(startExamList);
		
	}
	
	@Override
	public SmartList<StartExam> findStartExamWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getStartExamMapper());

	}
	@Override
	public int countStartExamWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countStartExamWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<StartExam> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getStartExamMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


