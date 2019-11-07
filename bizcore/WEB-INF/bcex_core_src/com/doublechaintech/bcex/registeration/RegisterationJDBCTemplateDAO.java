
package com.doublechaintech.bcex.registeration;

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

import com.doublechaintech.bcex.changerequest.ChangeRequestDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RegisterationJDBCTemplateDAO extends BcexBaseDAOImpl implements RegisterationDAO{
 
 	
 	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO changeRequestDAO){
	 	this.changeRequestDAO = changeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
	 	return this.changeRequestDAO;
 	}


			
		

	
	/*
	protected Registeration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRegisteration(accessKey, options);
	}
	*/
	
	public SmartList<Registeration> loadAll() {
	    return this.loadAll(getRegisterationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Registeration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRegisteration(RegisterationTable.withId(id), options);
	}
	
	
	
	public Registeration save(Registeration registeration,Map<String,Object> options){
		
		String methodName="save(Registeration registeration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(registeration, methodName, "registeration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRegisteration(registeration,options);
	}
	public Registeration clone(String registerationId, Map<String,Object> options) throws Exception{
	
		return clone(RegisterationTable.withId(registerationId),options);
	}
	
	protected Registeration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String registerationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Registeration newRegisteration = loadInternalRegisteration(accessKey, options);
		newRegisteration.setVersion(0);
		
		

		
		saveInternalRegisteration(newRegisteration,options);
		
		return newRegisteration;
	}
	
	
	
	

	protected void throwIfHasException(String registerationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RegisterationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RegisterationNotFoundException(
					"The " + this.getTableName() + "(" + registerationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String registerationId, int version) throws Exception{
	
		String methodName="delete(String registerationId, int version)";
		assertMethodArgumentNotNull(registerationId, methodName, "registerationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{registerationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(registerationId,version);
		}
		
	
	}
	
	
	
	
	

	public Registeration disconnectFromAll(String registerationId, int version) throws Exception{
	
		
		Registeration registeration = loadInternalRegisteration(RegisterationTable.withId(registerationId), emptyOptions());
		registeration.clearFromAll();
		this.saveRegisteration(registeration);
		return registeration;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RegisterationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "registeration";
	}
	@Override
	protected String getBeanName() {
		
		return "registeration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RegisterationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChangeRequestEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RegisterationTokens.CHANGEREQUEST);
 	}

 	protected boolean isSaveChangeRequestEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RegisterationTokens.CHANGEREQUEST);
 	}
 	

 	
 
		

	

	protected RegisterationMapper getRegisterationMapper(){
		return new RegisterationMapper();
	}

	
	
	protected Registeration extractRegisteration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Registeration registeration = loadSingleObject(accessKey, getRegisterationMapper());
			return registeration;
		}catch(EmptyResultDataAccessException e){
			throw new RegisterationNotFoundException("Registeration("+accessKey+") is not found!");
		}

	}

	
	

	protected Registeration loadInternalRegisteration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Registeration registeration = extractRegisteration(accessKey, loadOptions);
 	
 		if(isExtractChangeRequestEnabled(loadOptions)){
	 		extractChangeRequest(registeration, loadOptions);
 		}
 
		
		return registeration;
		
	}

	 

 	protected Registeration extractChangeRequest(Registeration registeration, Map<String,Object> options) throws Exception{

		if(registeration.getChangeRequest() == null){
			return registeration;
		}
		String changeRequestId = registeration.getChangeRequest().getId();
		if( changeRequestId == null){
			return registeration;
		}
		ChangeRequest changeRequest = getChangeRequestDAO().load(changeRequestId,options);
		if(changeRequest != null){
			registeration.setChangeRequest(changeRequest);
		}
		
 		
 		return registeration;
 	}
 		
 
		
		
  	
 	public SmartList<Registeration> findRegisterationByChangeRequest(String changeRequestId,Map<String,Object> options){
 	
  		SmartList<Registeration> resultList = queryWith(RegisterationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getRegisterationMapper());
		// analyzeRegisterationByChangeRequest(resultList, changeRequestId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Registeration> findRegisterationByChangeRequest(String changeRequestId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Registeration> resultList =  queryWithRange(RegisterationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getRegisterationMapper(), start, count);
 		//analyzeRegisterationByChangeRequest(resultList, changeRequestId, options);
 		return resultList;
 		
 	}
 	public void analyzeRegisterationByChangeRequest(SmartList<Registeration> resultList, String changeRequestId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countRegisterationByChangeRequest(String changeRequestId,Map<String,Object> options){

 		return countWith(RegisterationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options);
 	}
 	@Override
	public Map<String, Integer> countRegisterationByChangeRequestIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RegisterationTable.COLUMN_CHANGE_REQUEST, ids, options);
	}
 	
 	
		
		
		

	

	protected Registeration saveRegisteration(Registeration  registeration){
		
		if(!registeration.isChanged()){
			return registeration;
		}
		
		
		String SQL=this.getSaveRegisterationSQL(registeration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRegisterationParameters(registeration);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		registeration.incVersion();
		return registeration;
	
	}
	public SmartList<Registeration> saveRegisterationList(SmartList<Registeration> registerationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRegisterationList(registerationList);
		
		batchRegisterationCreate((List<Registeration>)lists[CREATE_LIST_INDEX]);
		
		batchRegisterationUpdate((List<Registeration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Registeration registeration:registerationList){
			if(registeration.isChanged()){
				registeration.incVersion();
			}
			
		
		}
		
		
		return registerationList;
	}

	public SmartList<Registeration> removeRegisterationList(SmartList<Registeration> registerationList,Map<String,Object> options){
		
		
		super.removeList(registerationList, options);
		
		return registerationList;
		
		
	}
	
	protected List<Object[]> prepareRegisterationBatchCreateArgs(List<Registeration> registerationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registeration registeration:registerationList ){
			Object [] parameters = prepareRegisterationCreateParameters(registeration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRegisterationBatchUpdateArgs(List<Registeration> registerationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registeration registeration:registerationList ){
			if(!registeration.isChanged()){
				continue;
			}
			Object [] parameters = prepareRegisterationUpdateParameters(registeration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRegisterationCreate(List<Registeration> registerationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRegisterationBatchCreateArgs(registerationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRegisterationUpdate(List<Registeration> registerationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRegisterationBatchUpdateArgs(registerationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRegisterationList(List<Registeration> registerationList){
		
		List<Registeration> registerationCreateList=new ArrayList<Registeration>();
		List<Registeration> registerationUpdateList=new ArrayList<Registeration>();
		
		for(Registeration registeration: registerationList){
			if(isUpdateRequest(registeration)){
				registerationUpdateList.add( registeration);
				continue;
			}
			registerationCreateList.add(registeration);
		}
		
		return new Object[]{registerationCreateList,registerationUpdateList};
	}
	
	protected boolean isUpdateRequest(Registeration registeration){
 		return registeration.getVersion() > 0;
 	}
 	protected String getSaveRegisterationSQL(Registeration registeration){
 		if(isUpdateRequest(registeration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRegisterationParameters(Registeration registeration){
 		if(isUpdateRequest(registeration) ){
 			return prepareRegisterationUpdateParameters(registeration);
 		}
 		return prepareRegisterationCreateParameters(registeration);
 	}
 	protected Object[] prepareRegisterationUpdateParameters(Registeration registeration){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = registeration.getNickName();
 		parameters[1] = registeration.getAvarta(); 	
 		if(registeration.getChangeRequest() != null){
 			parameters[2] = registeration.getChangeRequest().getId();
 		}
 		
 		parameters[3] = registeration.nextVersion();
 		parameters[4] = registeration.getId();
 		parameters[5] = registeration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRegisterationCreateParameters(Registeration registeration){
		Object[] parameters = new Object[4];
		String newRegisterationId=getNextId();
		registeration.setId(newRegisterationId);
		parameters[0] =  registeration.getId();
 
 		parameters[1] = registeration.getNickName();
 		parameters[2] = registeration.getAvarta(); 	
 		if(registeration.getChangeRequest() != null){
 			parameters[3] = registeration.getChangeRequest().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Registeration saveInternalRegisteration(Registeration registeration, Map<String,Object> options){
		
		saveRegisteration(registeration);
 	
 		if(isSaveChangeRequestEnabled(options)){
	 		saveChangeRequest(registeration, options);
 		}
 
		
		return registeration;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Registeration saveChangeRequest(Registeration registeration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(registeration.getChangeRequest() == null){
 			return registeration;//do nothing when it is null
 		}
 		
 		getChangeRequestDAO().save(registeration.getChangeRequest(),options);
 		return registeration;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Registeration present(Registeration registeration,Map<String, Object> options){
	

		return registeration;
	
	}
		

	

	protected String getTableName(){
		return RegisterationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Registeration> registerationList) {		
		this.enhanceListInternal(registerationList, this.getRegisterationMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Registeration> registerationList = ownerEntity.collectRefsWithType(Registeration.INTERNAL_TYPE);
		this.enhanceList(registerationList);
		
	}
	
	@Override
	public SmartList<Registeration> findRegisterationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRegisterationMapper());

	}
	@Override
	public int countRegisterationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRegisterationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Registeration> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRegisterationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


