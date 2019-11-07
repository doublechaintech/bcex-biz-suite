
package com.doublechaintech.bcex.examstatus;

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
import com.doublechaintech.bcex.exam.Exam;

import com.doublechaintech.bcex.exam.ExamDAO;
import com.doublechaintech.bcex.platform.PlatformDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class ExamStatusJDBCTemplateDAO extends BcexBaseDAOImpl implements ExamStatusDAO{
 
 	
 	private  PlatformDAO  platformDAO;
 	public void setPlatformDAO(PlatformDAO platformDAO){
	 	this.platformDAO = platformDAO;
 	}
 	public PlatformDAO getPlatformDAO(){
	 	return this.platformDAO;
 	}


			
		
	
  	private  ExamDAO  examDAO;
 	public void setExamDAO(ExamDAO pExamDAO){
 	
 		if(pExamDAO == null){
 			throw new IllegalStateException("Do not try to set examDAO to null.");
 		}
	 	this.examDAO = pExamDAO;
 	}
 	public ExamDAO getExamDAO(){
 		if(this.examDAO == null){
 			throw new IllegalStateException("The examDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.examDAO;
 	}	
 	
			
		

	
	/*
	protected ExamStatus load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalExamStatus(accessKey, options);
	}
	*/
	
	public SmartList<ExamStatus> loadAll() {
	    return this.loadAll(getExamStatusMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public ExamStatus load(String id,Map<String,Object> options) throws Exception{
		return loadInternalExamStatus(ExamStatusTable.withId(id), options);
	}
	
	
	
	public ExamStatus loadByCode(String code,Map<String,Object> options) throws Exception{
		return loadInternalExamStatus(ExamStatusTable.withCode( code), options);
	}
	
	
	public ExamStatus save(ExamStatus examStatus,Map<String,Object> options){
		
		String methodName="save(ExamStatus examStatus,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(examStatus, methodName, "examStatus");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalExamStatus(examStatus,options);
	}
	public ExamStatus clone(String examStatusId, Map<String,Object> options) throws Exception{
	
		return clone(ExamStatusTable.withId(examStatusId),options);
	}
	
	protected ExamStatus clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String examStatusId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		ExamStatus newExamStatus = loadInternalExamStatus(accessKey, options);
		newExamStatus.setVersion(0);
		
		
 		
 		if(isSaveExamListEnabled(options)){
 			for(Exam item: newExamStatus.getExamList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalExamStatus(newExamStatus,options);
		
		return newExamStatus;
	}
	
	
	
	public ExamStatus cloneByCode(String code,Map<String,Object> options) throws Exception{
		return clone(ExamStatusTable.withCode( code), options);
	}
	
	
	

	protected void throwIfHasException(String examStatusId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ExamStatusVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ExamStatusNotFoundException(
					"The " + this.getTableName() + "(" + examStatusId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String examStatusId, int version) throws Exception{
	
		String methodName="delete(String examStatusId, int version)";
		assertMethodArgumentNotNull(examStatusId, methodName, "examStatusId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{examStatusId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(examStatusId,version);
		}
		
	
	}
	
	
	
	
	

	public ExamStatus disconnectFromAll(String examStatusId, int version) throws Exception{
	
		
		ExamStatus examStatus = loadInternalExamStatus(ExamStatusTable.withId(examStatusId), emptyOptions());
		examStatus.clearFromAll();
		this.saveExamStatus(examStatus);
		return examStatus;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return ExamStatusTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "exam_status";
	}
	@Override
	protected String getBeanName() {
		
		return "examStatus";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return ExamStatusTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPlatformEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, ExamStatusTokens.PLATFORM);
 	}

 	protected boolean isSavePlatformEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, ExamStatusTokens.PLATFORM);
 	}
 	

 	
 
		
	
	protected boolean isExtractExamListEnabled(Map<String,Object> options){		
 		return checkOptions(options,ExamStatusTokens.EXAM_LIST);
 	}
 	protected boolean isAnalyzeExamListEnabled(Map<String,Object> options){		 		
 		return ExamStatusTokens.of(options).analyzeExamListEnabled();
 	}
	
	protected boolean isSaveExamListEnabled(Map<String,Object> options){
		return checkOptions(options, ExamStatusTokens.EXAM_LIST);
		
 	}
 	
		

	

	protected ExamStatusMapper getExamStatusMapper(){
		return new ExamStatusMapper();
	}

	
	
	protected ExamStatus extractExamStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ExamStatus examStatus = loadSingleObject(accessKey, getExamStatusMapper());
			return examStatus;
		}catch(EmptyResultDataAccessException e){
			throw new ExamStatusNotFoundException("ExamStatus("+accessKey+") is not found!");
		}

	}

	
	

	protected ExamStatus loadInternalExamStatus(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		ExamStatus examStatus = extractExamStatus(accessKey, loadOptions);
 	
 		if(isExtractPlatformEnabled(loadOptions)){
	 		extractPlatform(examStatus, loadOptions);
 		}
 
		
		if(isExtractExamListEnabled(loadOptions)){
	 		extractExamList(examStatus, loadOptions);
 		}	
 		if(isAnalyzeExamListEnabled(loadOptions)){
	 		analyzeExamList(examStatus, loadOptions);
 		}
 		
		
		return examStatus;
		
	}

	 

 	protected ExamStatus extractPlatform(ExamStatus examStatus, Map<String,Object> options) throws Exception{

		if(examStatus.getPlatform() == null){
			return examStatus;
		}
		String platformId = examStatus.getPlatform().getId();
		if( platformId == null){
			return examStatus;
		}
		Platform platform = getPlatformDAO().load(platformId,options);
		if(platform != null){
			examStatus.setPlatform(platform);
		}
		
 		
 		return examStatus;
 	}
 		
 
		
	protected void enhanceExamList(SmartList<Exam> examList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected ExamStatus extractExamList(ExamStatus examStatus, Map<String,Object> options){
		
		
		if(examStatus == null){
			return null;
		}
		if(examStatus.getId() == null){
			return examStatus;
		}

		
		
		SmartList<Exam> examList = getExamDAO().findExamByStatus(examStatus.getId(),options);
		if(examList != null){
			enhanceExamList(examList,options);
			examStatus.setExamList(examList);
		}
		
		return examStatus;
	
	}	
	
	protected ExamStatus analyzeExamList(ExamStatus examStatus, Map<String,Object> options){
		
		
		if(examStatus == null){
			return null;
		}
		if(examStatus.getId() == null){
			return examStatus;
		}

		
		
		SmartList<Exam> examList = examStatus.getExamList();
		if(examList != null){
			getExamDAO().analyzeExamByStatus(examList, examStatus.getId(), options);
			
		}
		
		return examStatus;
	
	}	
	
		
		
  	
 	public SmartList<ExamStatus> findExamStatusByPlatform(String platformId,Map<String,Object> options){
 	
  		SmartList<ExamStatus> resultList = queryWith(ExamStatusTable.COLUMN_PLATFORM, platformId, options, getExamStatusMapper());
		// analyzeExamStatusByPlatform(resultList, platformId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<ExamStatus> findExamStatusByPlatform(String platformId, int start, int count,Map<String,Object> options){
 		
 		SmartList<ExamStatus> resultList =  queryWithRange(ExamStatusTable.COLUMN_PLATFORM, platformId, options, getExamStatusMapper(), start, count);
 		//analyzeExamStatusByPlatform(resultList, platformId, options);
 		return resultList;
 		
 	}
 	public void analyzeExamStatusByPlatform(SmartList<ExamStatus> resultList, String platformId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countExamStatusByPlatform(String platformId,Map<String,Object> options){

 		return countWith(ExamStatusTable.COLUMN_PLATFORM, platformId, options);
 	}
 	@Override
	public Map<String, Integer> countExamStatusByPlatformIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ExamStatusTable.COLUMN_PLATFORM, ids, options);
	}
 	
 	
		
		
		

	

	protected ExamStatus saveExamStatus(ExamStatus  examStatus){
		
		if(!examStatus.isChanged()){
			return examStatus;
		}
		
		
		String SQL=this.getSaveExamStatusSQL(examStatus);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveExamStatusParameters(examStatus);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		examStatus.incVersion();
		return examStatus;
	
	}
	public SmartList<ExamStatus> saveExamStatusList(SmartList<ExamStatus> examStatusList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitExamStatusList(examStatusList);
		
		batchExamStatusCreate((List<ExamStatus>)lists[CREATE_LIST_INDEX]);
		
		batchExamStatusUpdate((List<ExamStatus>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(ExamStatus examStatus:examStatusList){
			if(examStatus.isChanged()){
				examStatus.incVersion();
			}
			
		
		}
		
		
		return examStatusList;
	}

	public SmartList<ExamStatus> removeExamStatusList(SmartList<ExamStatus> examStatusList,Map<String,Object> options){
		
		
		super.removeList(examStatusList, options);
		
		return examStatusList;
		
		
	}
	
	protected List<Object[]> prepareExamStatusBatchCreateArgs(List<ExamStatus> examStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExamStatus examStatus:examStatusList ){
			Object [] parameters = prepareExamStatusCreateParameters(examStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareExamStatusBatchUpdateArgs(List<ExamStatus> examStatusList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ExamStatus examStatus:examStatusList ){
			if(!examStatus.isChanged()){
				continue;
			}
			Object [] parameters = prepareExamStatusUpdateParameters(examStatus);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchExamStatusCreate(List<ExamStatus> examStatusList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareExamStatusBatchCreateArgs(examStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchExamStatusUpdate(List<ExamStatus> examStatusList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareExamStatusBatchUpdateArgs(examStatusList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitExamStatusList(List<ExamStatus> examStatusList){
		
		List<ExamStatus> examStatusCreateList=new ArrayList<ExamStatus>();
		List<ExamStatus> examStatusUpdateList=new ArrayList<ExamStatus>();
		
		for(ExamStatus examStatus: examStatusList){
			if(isUpdateRequest(examStatus)){
				examStatusUpdateList.add( examStatus);
				continue;
			}
			examStatusCreateList.add(examStatus);
		}
		
		return new Object[]{examStatusCreateList,examStatusUpdateList};
	}
	
	protected boolean isUpdateRequest(ExamStatus examStatus){
 		return examStatus.getVersion() > 0;
 	}
 	protected String getSaveExamStatusSQL(ExamStatus examStatus){
 		if(isUpdateRequest(examStatus)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveExamStatusParameters(ExamStatus examStatus){
 		if(isUpdateRequest(examStatus) ){
 			return prepareExamStatusUpdateParameters(examStatus);
 		}
 		return prepareExamStatusCreateParameters(examStatus);
 	}
 	protected Object[] prepareExamStatusUpdateParameters(ExamStatus examStatus){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = examStatus.getName();
 		parameters[1] = examStatus.getCode(); 	
 		if(examStatus.getPlatform() != null){
 			parameters[2] = examStatus.getPlatform().getId();
 		}
 		
 		parameters[3] = examStatus.nextVersion();
 		parameters[4] = examStatus.getId();
 		parameters[5] = examStatus.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareExamStatusCreateParameters(ExamStatus examStatus){
		Object[] parameters = new Object[4];
		String newExamStatusId=getNextId();
		examStatus.setId(newExamStatusId);
		parameters[0] =  examStatus.getId();
 
 		parameters[1] = examStatus.getName();
 		parameters[2] = examStatus.getCode(); 	
 		if(examStatus.getPlatform() != null){
 			parameters[3] = examStatus.getPlatform().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected ExamStatus saveInternalExamStatus(ExamStatus examStatus, Map<String,Object> options){
		
		saveExamStatus(examStatus);
 	
 		if(isSavePlatformEnabled(options)){
	 		savePlatform(examStatus, options);
 		}
 
		
		if(isSaveExamListEnabled(options)){
	 		saveExamList(examStatus, options);
	 		//removeExamList(examStatus, options);
	 		//Not delete the record
	 		
 		}		
		
		return examStatus;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected ExamStatus savePlatform(ExamStatus examStatus, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(examStatus.getPlatform() == null){
 			return examStatus;//do nothing when it is null
 		}
 		
 		getPlatformDAO().save(examStatus.getPlatform(),options);
 		return examStatus;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public ExamStatus planToRemoveExamList(ExamStatus examStatus, String examIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.STATUS_PROPERTY, examStatus.getId());
		key.put(Exam.ID_PROPERTY, examIds);
		
		SmartList<Exam> externalExamList = getExamDAO().
				findExamWithKey(key, options);
		if(externalExamList == null){
			return examStatus;
		}
		if(externalExamList.isEmpty()){
			return examStatus;
		}
		
		for(Exam examItem: externalExamList){

			examItem.clearFromAll();
		}
		
		
		SmartList<Exam> examList = examStatus.getExamList();		
		examList.addAllToRemoveList(externalExamList);
		return examStatus;	
	
	}


	//disconnect ExamStatus with user in Exam
	public ExamStatus planToRemoveExamListWithUser(ExamStatus examStatus, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.STATUS_PROPERTY, examStatus.getId());
		key.put(Exam.USER_PROPERTY, userId);
		
		SmartList<Exam> externalExamList = getExamDAO().
				findExamWithKey(key, options);
		if(externalExamList == null){
			return examStatus;
		}
		if(externalExamList.isEmpty()){
			return examStatus;
		}
		
		for(Exam examItem: externalExamList){
			examItem.clearUser();
			examItem.clearStatus();
			
		}
		
		
		SmartList<Exam> examList = examStatus.getExamList();		
		examList.addAllToRemoveList(externalExamList);
		return examStatus;
	}
	
	public int countExamListWithUser(String examStatusId, String userId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.STATUS_PROPERTY, examStatusId);
		key.put(Exam.USER_PROPERTY, userId);
		
		int count = getExamDAO().countExamWithKey(key, options);
		return count;
	}
	

		
	protected ExamStatus saveExamList(ExamStatus examStatus, Map<String,Object> options){
		
		
		
		
		SmartList<Exam> examList = examStatus.getExamList();
		if(examList == null){
			//null list means nothing
			return examStatus;
		}
		SmartList<Exam> mergedUpdateExamList = new SmartList<Exam>();
		
		
		mergedUpdateExamList.addAll(examList); 
		if(examList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateExamList.addAll(examList.getToRemoveList());
			examList.removeAll(examList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getExamDAO().saveExamList(mergedUpdateExamList,options);
		
		if(examList.getToRemoveList() != null){
			examList.removeAll(examList.getToRemoveList());
		}
		
		
		return examStatus;
	
	}
	
	protected ExamStatus removeExamList(ExamStatus examStatus, Map<String,Object> options){
	
	
		SmartList<Exam> examList = examStatus.getExamList();
		if(examList == null){
			return examStatus;
		}	
	
		SmartList<Exam> toRemoveExamList = examList.getToRemoveList();
		
		if(toRemoveExamList == null){
			return examStatus;
		}
		if(toRemoveExamList.isEmpty()){
			return examStatus;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getExamDAO().removeExamList(toRemoveExamList,options);
		
		return examStatus;
	
	}
	
	

 	
 	
	
	
	
		

	public ExamStatus present(ExamStatus examStatus,Map<String, Object> options){
	
		presentExamList(examStatus,options);

		return examStatus;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected ExamStatus presentExamList(
			ExamStatus examStatus,
			Map<String, Object> options) {

		SmartList<Exam> examList = examStatus.getExamList();		
				SmartList<Exam> newList= presentSubList(examStatus.getId(),
				examList,
				options,
				getExamDAO()::countExamByStatus,
				getExamDAO()::findExamByStatus
				);

		
		examStatus.setExamList(newList);
		

		return examStatus;
	}			
		

	
    public SmartList<ExamStatus> requestCandidateExamStatusForExam(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ExamStatusTable.COLUMN_NAME, filterKey, pageNo, pageSize, getExamStatusMapper());
    }
		

	protected String getTableName(){
		return ExamStatusTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<ExamStatus> examStatusList) {		
		this.enhanceListInternal(examStatusList, this.getExamStatusMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:Exam的status的ExamList
	public SmartList<Exam> loadOurExamList(BcexUserContext userContext, List<ExamStatus> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Exam.STATUS_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Exam> loadedObjs = userContext.getDAOGroup().getExamDAO().findExamWithKey(key, options);
		Map<String, List<Exam>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getStatus().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Exam> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Exam> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setExamList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ExamStatus> examStatusList = ownerEntity.collectRefsWithType(ExamStatus.INTERNAL_TYPE);
		this.enhanceList(examStatusList);
		
	}
	
	@Override
	public SmartList<ExamStatus> findExamStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getExamStatusMapper());

	}
	@Override
	public int countExamStatusWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countExamStatusWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<ExamStatus> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getExamStatusMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	
	

}


