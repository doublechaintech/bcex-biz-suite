
package com.doublechaintech.bcex.registration;

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


public class RegistrationJDBCTemplateDAO extends BcexBaseDAOImpl implements RegistrationDAO{
 
 	
 	private  ChangeRequestDAO  changeRequestDAO;
 	public void setChangeRequestDAO(ChangeRequestDAO changeRequestDAO){
	 	this.changeRequestDAO = changeRequestDAO;
 	}
 	public ChangeRequestDAO getChangeRequestDAO(){
	 	return this.changeRequestDAO;
 	}


			
		

	
	/*
	protected Registration load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRegistration(accessKey, options);
	}
	*/
	
	public SmartList<Registration> loadAll() {
	    return this.loadAll(getRegistrationMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public Registration load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRegistration(RegistrationTable.withId(id), options);
	}
	
	
	
	public Registration save(Registration registration,Map<String,Object> options){
		
		String methodName="save(Registration registration,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(registration, methodName, "registration");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRegistration(registration,options);
	}
	public Registration clone(String registrationId, Map<String,Object> options) throws Exception{
	
		return clone(RegistrationTable.withId(registrationId),options);
	}
	
	protected Registration clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String registrationId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		Registration newRegistration = loadInternalRegistration(accessKey, options);
		newRegistration.setVersion(0);
		
		

		
		saveInternalRegistration(newRegistration,options);
		
		return newRegistration;
	}
	
	
	
	

	protected void throwIfHasException(String registrationId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RegistrationVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RegistrationNotFoundException(
					"The " + this.getTableName() + "(" + registrationId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String registrationId, int version) throws Exception{
	
		String methodName="delete(String registrationId, int version)";
		assertMethodArgumentNotNull(registrationId, methodName, "registrationId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{registrationId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(registrationId,version);
		}
		
	
	}
	
	
	
	
	

	public Registration disconnectFromAll(String registrationId, int version) throws Exception{
	
		
		Registration registration = loadInternalRegistration(RegistrationTable.withId(registrationId), emptyOptions());
		registration.clearFromAll();
		this.saveRegistration(registration);
		return registration;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RegistrationTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "registration";
	}
	@Override
	protected String getBeanName() {
		
		return "registration";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RegistrationTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractChangeRequestEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RegistrationTokens.CHANGEREQUEST);
 	}

 	protected boolean isSaveChangeRequestEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RegistrationTokens.CHANGEREQUEST);
 	}
 	

 	
 
		

	

	protected RegistrationMapper getRegistrationMapper(){
		return new RegistrationMapper();
	}

	
	
	protected Registration extractRegistration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			Registration registration = loadSingleObject(accessKey, getRegistrationMapper());
			return registration;
		}catch(EmptyResultDataAccessException e){
			throw new RegistrationNotFoundException("Registration("+accessKey+") is not found!");
		}

	}

	
	

	protected Registration loadInternalRegistration(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		Registration registration = extractRegistration(accessKey, loadOptions);
 	
 		if(isExtractChangeRequestEnabled(loadOptions)){
	 		extractChangeRequest(registration, loadOptions);
 		}
 
		
		return registration;
		
	}

	 

 	protected Registration extractChangeRequest(Registration registration, Map<String,Object> options) throws Exception{

		if(registration.getChangeRequest() == null){
			return registration;
		}
		String changeRequestId = registration.getChangeRequest().getId();
		if( changeRequestId == null){
			return registration;
		}
		ChangeRequest changeRequest = getChangeRequestDAO().load(changeRequestId,options);
		if(changeRequest != null){
			registration.setChangeRequest(changeRequest);
		}
		
 		
 		return registration;
 	}
 		
 
		
		
  	
 	public SmartList<Registration> findRegistrationByChangeRequest(String changeRequestId,Map<String,Object> options){
 	
  		SmartList<Registration> resultList = queryWith(RegistrationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getRegistrationMapper());
		// analyzeRegistrationByChangeRequest(resultList, changeRequestId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<Registration> findRegistrationByChangeRequest(String changeRequestId, int start, int count,Map<String,Object> options){
 		
 		SmartList<Registration> resultList =  queryWithRange(RegistrationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options, getRegistrationMapper(), start, count);
 		//analyzeRegistrationByChangeRequest(resultList, changeRequestId, options);
 		return resultList;
 		
 	}
 	public void analyzeRegistrationByChangeRequest(SmartList<Registration> resultList, String changeRequestId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countRegistrationByChangeRequest(String changeRequestId,Map<String,Object> options){

 		return countWith(RegistrationTable.COLUMN_CHANGE_REQUEST, changeRequestId, options);
 	}
 	@Override
	public Map<String, Integer> countRegistrationByChangeRequestIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RegistrationTable.COLUMN_CHANGE_REQUEST, ids, options);
	}
 	
 	
		
		
		

	

	protected Registration saveRegistration(Registration  registration){
		
		if(!registration.isChanged()){
			return registration;
		}
		
		
		String SQL=this.getSaveRegistrationSQL(registration);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRegistrationParameters(registration);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		registration.incVersion();
		return registration;
	
	}
	public SmartList<Registration> saveRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRegistrationList(registrationList);
		
		batchRegistrationCreate((List<Registration>)lists[CREATE_LIST_INDEX]);
		
		batchRegistrationUpdate((List<Registration>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(Registration registration:registrationList){
			if(registration.isChanged()){
				registration.incVersion();
			}
			
		
		}
		
		
		return registrationList;
	}

	public SmartList<Registration> removeRegistrationList(SmartList<Registration> registrationList,Map<String,Object> options){
		
		
		super.removeList(registrationList, options);
		
		return registrationList;
		
		
	}
	
	protected List<Object[]> prepareRegistrationBatchCreateArgs(List<Registration> registrationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registration registration:registrationList ){
			Object [] parameters = prepareRegistrationCreateParameters(registration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRegistrationBatchUpdateArgs(List<Registration> registrationList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(Registration registration:registrationList ){
			if(!registration.isChanged()){
				continue;
			}
			Object [] parameters = prepareRegistrationUpdateParameters(registration);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRegistrationCreate(List<Registration> registrationList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRegistrationBatchCreateArgs(registrationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRegistrationUpdate(List<Registration> registrationList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRegistrationBatchUpdateArgs(registrationList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRegistrationList(List<Registration> registrationList){
		
		List<Registration> registrationCreateList=new ArrayList<Registration>();
		List<Registration> registrationUpdateList=new ArrayList<Registration>();
		
		for(Registration registration: registrationList){
			if(isUpdateRequest(registration)){
				registrationUpdateList.add( registration);
				continue;
			}
			registrationCreateList.add(registration);
		}
		
		return new Object[]{registrationCreateList,registrationUpdateList};
	}
	
	protected boolean isUpdateRequest(Registration registration){
 		return registration.getVersion() > 0;
 	}
 	protected String getSaveRegistrationSQL(Registration registration){
 		if(isUpdateRequest(registration)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRegistrationParameters(Registration registration){
 		if(isUpdateRequest(registration) ){
 			return prepareRegistrationUpdateParameters(registration);
 		}
 		return prepareRegistrationCreateParameters(registration);
 	}
 	protected Object[] prepareRegistrationUpdateParameters(Registration registration){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = registration.getNickName();
 		parameters[1] = registration.getAvatar(); 	
 		if(registration.getChangeRequest() != null){
 			parameters[2] = registration.getChangeRequest().getId();
 		}
 		
 		parameters[3] = registration.nextVersion();
 		parameters[4] = registration.getId();
 		parameters[5] = registration.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRegistrationCreateParameters(Registration registration){
		Object[] parameters = new Object[4];
		String newRegistrationId=getNextId();
		registration.setId(newRegistrationId);
		parameters[0] =  registration.getId();
 
 		parameters[1] = registration.getNickName();
 		parameters[2] = registration.getAvatar(); 	
 		if(registration.getChangeRequest() != null){
 			parameters[3] = registration.getChangeRequest().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected Registration saveInternalRegistration(Registration registration, Map<String,Object> options){
		
		saveRegistration(registration);
 	
 		if(isSaveChangeRequestEnabled(options)){
	 		saveChangeRequest(registration, options);
 		}
 
		
		return registration;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected Registration saveChangeRequest(Registration registration, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(registration.getChangeRequest() == null){
 			return registration;//do nothing when it is null
 		}
 		
 		getChangeRequestDAO().save(registration.getChangeRequest(),options);
 		return registration;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public Registration present(Registration registration,Map<String, Object> options){
	

		return registration;
	
	}
		

	

	protected String getTableName(){
		return RegistrationTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<Registration> registrationList) {		
		this.enhanceListInternal(registrationList, this.getRegistrationMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<Registration> registrationList = ownerEntity.collectRefsWithType(Registration.INTERNAL_TYPE);
		this.enhanceList(registrationList);
		
	}
	
	@Override
	public SmartList<Registration> findRegistrationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRegistrationMapper());

	}
	@Override
	public int countRegistrationWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRegistrationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<Registration> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRegistrationMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


