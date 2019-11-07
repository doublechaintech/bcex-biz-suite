
package com.doublechaintech.bcex.examranking;

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


import com.doublechaintech.bcex.platform.Platform;

import com.doublechaintech.bcex.platform.PlatformDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ExamRankingJDBCTemplateDAO extends BcexBaseDAOImpl implements ExamRankingDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		

	
	/*
	protected ExamRanking load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalExamRanking(accessKey, options);
	}
	*/
	
	public SmartList<ExamRanking> loadAll() {
	    return this.loadAll(getExamRankingMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ExamRanking load(String id,Map<String,Object> options) throws Exception{
		return loadInternalExamRanking(ExamRankingTable.withId(id), options);
	}
	
	
	
	public ExamRanking save(ExamRanking examRanking,Map<String,Object> options){
		
		String methodName="save(ExamRanking examRanking,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(examRanking, methodName, "examRanking");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalExamRanking(examRanking,options);
	}
	public ExamRanking clone(String examRankingId, Map<String,Object> options) throws Exception{
	
		return clone(ExamRankingTable.withId(examRankingId),options);
	}
	
	protected ExamRanking clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String examRankingId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ExamRanking newExamRanking = loadInternalExamRanking(accessKey, options);
		newExamRanking.setVersion(0);
		
		

		
		saveInternalExamRanking(newExamRanking,options);
		
		return newExamRanking;
	}
	
	
	
	

	protected void throwIfHasException(String examRankingId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ExamRankingVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ExamRankingNotFoundException(
					"The " + this.getTableName() + "(" + examRankingId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String examRankingId, int version) throws Exception{
	
		String methodName="delete(String examRankingId, int version)";
		assertMethodArgumentNotNull(examRankingId, methodName, "examRankingId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{examRankingId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(examRankingId,version);
		}
		
	
	}
	
	
	
	
	

	public ExamRanking disconnectFromAll(String examRankingId, int version) throws Exception{
	
		
		ExamRanking examRanking = loadInternalExamRanking(ExamRankingTable.withId(examRankingId), emptyOptions());
		examRanking.clearFromAll();
		this.saveExamRanking(examRanking);
		return examRanking;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ExamRankingTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "exam_ranking";
	}
	@Override
	protected String getBeanName() {
		
		return "examRanking";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ExamRankingTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExamRankingTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExamRankingTokens.PLATFORM);
 	}
 	

 	
 
		

	

	protected ExamRankingMapper getExamRankingMapper(){
		return new ExamRankingMapper();
	}

	
	
	protected ExamRanking extractExamRanking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ExamRanking examRanking = loadSingleObject(accessKey, getExamRankingMapper());
			return examRanking;
		}catch(EmptyResultDataAccessException e){
			throw new ExamRankingNotFoundException("ExamRanking("+accessKey+") is not found!");
		}

	}

	
	

	protected ExamRanking loadInternalExamRanking(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ExamRanking examRanking = extractExamRanking(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(examRanking, loadOptions);
 		}
 
		
		return examRanking;
		
	}

	 

 	protected ExamRanking extractPlatform(ExamRanking examRanking, Map<String,Object> options) throws Exception{

		if(examRanking.getPlatform() == null){
			return examRanking;
		}
		String platformId = examRanking.getPlatform().getId();
		if( platformId == null){
			return examRanking;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			examRanking.setPlatform(platform);
		}
		
 		
 		return examRanking;
 	}
 		
 
		
		
  	
 	public SmartList<ExamRanking> findExamRankingByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<ExamRanking> resultList = queryWith(ExamRankingTable.COLUMN_PLATFORM, platformId, options, getExamRankingMapper());
		// analyzeExamRankingByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ExamRanking> findExamRankingByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ExamRanking> resultList =  queryWithRange(ExamRankingTable.COLUMN_PLATFORM, platformId, options, getExamRankingMapper(), start, count);
 		//analyzeExamRankingByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeExamRankingByPlatform(SmartList<ExamRanking> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countExamRankingByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ExamRankingTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countExamRankingByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExamRankingTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected ExamRanking saveExamRanking(ExamRanking  examRanking){
		
		if(!examRanking.isChanged()){
			return examRanking;
		}
		
		
		String SQL=this.getSaveExamRankingSQL(examRanking);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveExamRankingParameters(examRanking);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		examRanking.incVersion();
		return examRanking;
	
	}
	public SmartList<ExamRanking> saveExamRankingList(SmartList<ExamRanking> examRankingList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitExamRankingList(examRankingList);
		
		batchExamRankingCreate((List<ExamRanking>)lists[CREATE_LIST_INDEX]);
		
		batchExamRankingUpdate((List<ExamRanking>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ExamRanking examRanking:examRankingList){
			if(examRanking.isChanged()){
				examRanking.incVersion();
			}
			
		
		}
		
		
		return examRankingList;
	}

	public SmartList<ExamRanking> removeExamRankingList(SmartList<ExamRanking> examRankingList,Map<String,Object> options){
		
		
		super.removeList(examRankingList, options);
		
		return examRankingList;
		
		
	}
	
	protected List<Object[]> prepareExamRankingBatchCreateArgs(List<ExamRanking> examRankingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExamRanking examRanking:examRankingList ){
			Object [] parameters = prepareExamRankingCreateParameters(examRanking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareExamRankingBatchUpdateArgs(List<ExamRanking> examRankingList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExamRanking examRanking:examRankingList ){
			if(!examRanking.isChanged()){
				continue;
			}
			Object [] parameters = prepareExamRankingUpdateParameters(examRanking);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchExamRankingCreate(List<ExamRanking> examRankingList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareExamRankingBatchCreateArgs(examRankingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchExamRankingUpdate(List<ExamRanking> examRankingList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareExamRankingBatchUpdateArgs(examRankingList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitExamRankingList(List<ExamRanking> examRankingList){
		
		List<ExamRanking> examRankingCreateList=new ArrayList<ExamRanking>();
		List<ExamRanking> examRankingUpdateList=new ArrayList<ExamRanking>();
		
		for(ExamRanking examRanking: examRankingList){
			if(isUpdateRequest(examRanking)){
				examRankingUpdateList.add( examRanking);
				continue;
			}
			examRankingCreateList.add(examRanking);
		}
		
		return new Object[]{examRankingCreateList,examRankingUpdateList};
	}
	
	protected boolean isUpdateRequest(ExamRanking examRanking){
 		return examRanking.getVersion() > 0;
 	}
 	protected String getSaveExamRankingSQL(ExamRanking examRanking){
 		if(isUpdateRequest(examRanking)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveExamRankingParameters(ExamRanking examRanking){
 		if(isUpdateRequest(examRanking) ){
 			return prepareExamRankingUpdateParameters(examRanking);
 		}
 		return prepareExamRankingCreateParameters(examRanking);
 	}
 	protected Object[] prepareExamRankingUpdateParameters(ExamRanking examRanking){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = examRanking.getName();
 		parameters[1] = examRanking.getAvarta(); 	
 		if(examRanking.getPlatform() != null){
 			parameters[2] = examRanking.getPlatform().getId();
 		}
 		
 		parameters[3] = examRanking.nextVersion();
 		parameters[4] = examRanking.getId();
 		parameters[5] = examRanking.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareExamRankingCreateParameters(ExamRanking examRanking){
		Object[] parameters = new Object[4];
		String newExamRankingId=getNextId();
		examRanking.setId(newExamRankingId);
		parameters[0] =  examRanking.getId();
 
 		parameters[1] = examRanking.getName();
 		parameters[2] = examRanking.getAvarta(); 	
 		if(examRanking.getPlatform() != null){
 			parameters[3] = examRanking.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ExamRanking saveInternalExamRanking(ExamRanking examRanking, Map<String,Object> options){
		
		saveExamRanking(examRanking);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(examRanking, options);
 		}
 
		
		return examRanking;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ExamRanking savePlatform(ExamRanking examRanking, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(examRanking.getPlatform() == null){
 			return examRanking;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(examRanking.getPlatform(),options);
 		return examRanking;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public ExamRanking present(ExamRanking examRanking,Map<String, Object> options){
	

		return examRanking;
	
	}
		

	

	protected String getTableName(){
		return ExamRankingTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ExamRanking> examRankingList) {		
		this.enhanceListInternal(examRankingList, this.getExamRankingMapper());
	}
	
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ExamRanking> examRankingList = ownerEntity.collectRefsWithType(ExamRanking.INTERNAL_TYPE);
		this.enhanceList(examRankingList);
		
	}
	
	@Override
	public SmartList<ExamRanking> findExamRankingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getExamRankingMapper());

	}
	@Override
	public int countExamRankingWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countExamRankingWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ExamRanking> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getExamRankingMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


