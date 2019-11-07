
package com.doublechaintech.bcex.candidateelement;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BaseEntity;


import com.doublechaintech.bcex.Message;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.MultipleAccessKey;

import com.doublechaintech.bcex.BcexUserContext;
//import com.doublechaintech.bcex.BaseManagerImpl;
import com.doublechaintech.bcex.BcexCheckerManager;
import com.doublechaintech.bcex.CustomBcexCheckerManager;

import com.doublechaintech.bcex.candidatecontainer.CandidateContainer;

import com.doublechaintech.bcex.candidatecontainer.CandidateCandidateContainer;







public class CandidateElementManagerImpl extends CustomBcexCheckerManager implements CandidateElementManager {
	
	private static final String SERVICE_TYPE = "CandidateElement";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CandidateElementManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CandidateElementManagerException(message);

	}
	
	

 	protected CandidateElement saveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement, String [] tokensExpr) throws Exception{	
 		//return getCandidateElementDAO().save(candidateElement, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCandidateElement(userContext, candidateElement, tokens);
 	}
 	
 	protected CandidateElement saveCandidateElementDetail(BcexUserContext userContext, CandidateElement candidateElement) throws Exception{	

 		
 		return saveCandidateElement(userContext, candidateElement, allTokens());
 	}
 	
 	public CandidateElement loadCandidateElement(BcexUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	
 	 public CandidateElement searchCandidateElement(BcexUserContext userContext, String candidateElementId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateElement, tokens);
 	}
 	
 	

 	protected CandidateElement present(BcexUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,candidateElement,tokens);
		
		
		CandidateElement  candidateElementToPresent = candidateElementDaoOf(userContext).present(candidateElement, tokens);
		
		List<BaseEntity> entityListToNaming = candidateElementToPresent.collectRefercencesFromLists();
		candidateElementDaoOf(userContext).alias(entityListToNaming);
		
		return  candidateElementToPresent;
		
		
	}
 
 	
 	
 	public CandidateElement loadCandidateElementDetail(BcexUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, allTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String candidateElementId) throws Exception{	
 		CandidateElement candidateElement = loadCandidateElement( userContext, candidateElementId, viewTokens());
 		return present(userContext,candidateElement, allTokens());
		
 	}
 	protected CandidateElement saveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement, Map<String,Object>tokens) throws Exception{	
 		return candidateElementDaoOf(userContext).save(candidateElement, tokens);
 	}
 	protected CandidateElement loadCandidateElement(BcexUserContext userContext, String candidateElementId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateElementManagerException.class);

 
 		return candidateElementDaoOf(userContext).load(candidateElementId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
		super.addActions(userContext, candidateElement, tokens);
		
		addAction(userContext, candidateElement, tokens,"@create","createCandidateElement","createCandidateElement/","main","primary");
		addAction(userContext, candidateElement, tokens,"@update","updateCandidateElement","updateCandidateElement/"+candidateElement.getId()+"/","main","primary");
		addAction(userContext, candidateElement, tokens,"@copy","cloneCandidateElement","cloneCandidateElement/"+candidateElement.getId()+"/","main","primary");
		
		addAction(userContext, candidateElement, tokens,"candidate_element.transfer_to_container","transferToAnotherContainer","transferToAnotherContainer/"+candidateElement.getId()+"/","main","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, CandidateElement candidateElement, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CandidateElement createCandidateElement(BcexUserContext userContext,String name, String type, String image, String containerId) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfCandidateElement(name);
		checkerOf(userContext).checkTypeOfCandidateElement(type);
		checkerOf(userContext).checkImageOfCandidateElement(image);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);


		CandidateElement candidateElement=createNewCandidateElement();	

		candidateElement.setName(name);
		candidateElement.setType(type);
		candidateElement.setImage(image);
			
		CandidateContainer container = loadCandidateContainer(userContext, containerId,emptyOptions());
		candidateElement.setContainer(container);
		
		

		candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateElement);
		return candidateElement;

		
	}
	protected CandidateElement createNewCandidateElement() 
	{
		
		return new CandidateElement();		
	}
	
	protected void checkParamsForUpdatingCandidateElement(BcexUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement( candidateElementVersion);
		

		if(CandidateElement.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
		}
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
		}
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
		}		

		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);
	
		
	}
	
	
	
	public CandidateElement clone(BcexUserContext userContext, String fromCandidateElementId) throws Exception{
		
		return candidateElementDaoOf(userContext).clone(fromCandidateElementId, this.allTokens());
	}
	
	public CandidateElement internalSaveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement) throws Exception 
	{
		return internalSaveCandidateElement(userContext, candidateElement, allTokens());

	}
	public CandidateElement internalSaveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			if (candidateElement.isChanged()){
			
			}
			candidateElement = saveCandidateElement(userContext, candidateElement, options);
			return candidateElement;
			
		}

	}
	
	public CandidateElement updateCandidateElement(BcexUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		
		
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			
			candidateElement.changeProperty(property, newValueExpr);
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}
	
	public CandidateElement updateCandidateElementProperty(BcexUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateElement(userContext, candidateElementId, candidateElementVersion, property, newValueExpr, tokensExpr);
		
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());
		if(candidateElement.getVersion() != candidateElementVersion){
			String message = "The target version("+candidateElement.getVersion()+") is not equals to version("+candidateElementVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateElement){ 
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateElement.
			
			candidateElement.changeProperty(property, newValueExpr);
			
			candidateElement = saveCandidateElement(userContext, candidateElement, tokens().done());
			return present(userContext,candidateElement, mergedAllTokens(tokensExpr));
			//return saveCandidateElement(userContext, candidateElement, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CandidateElementTokens tokens(){
		return CandidateElementTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateElementTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateElementTokens.mergeAll(tokens).done();
	}
	
	protected void checkParamsForTransferingAnotherContainer(BcexUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{
 		
 		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
 		checkerOf(userContext).checkIdOfCandidateContainer(anotherContainerId);//check for optional reference
 		checkerOf(userContext).throwExceptionIfHasErrors(CandidateElementManagerException.class);
 		
 	}
 	public CandidateElement transferToAnotherContainer(BcexUserContext userContext, String candidateElementId, String anotherContainerId) throws Exception
 	{
 		checkParamsForTransferingAnotherContainer(userContext, candidateElementId,anotherContainerId);
 
		CandidateElement candidateElement = loadCandidateElement(userContext, candidateElementId, allTokens());	
		synchronized(candidateElement){
			//will be good when the candidateElement loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			CandidateContainer container = loadCandidateContainer(userContext, anotherContainerId, emptyOptions());		
			candidateElement.updateContainer(container);		
			candidateElement = saveCandidateElement(userContext, candidateElement, emptyOptions());
			
			return present(userContext,candidateElement, allTokens());
			
		}

 	}
 	
	 	
 	
 	
	public CandidateCandidateContainer requestCandidateContainer(BcexUserContext userContext, String ownerClass, String id, String filterKey, int pageNo) throws Exception {

		CandidateCandidateContainer result = new CandidateCandidateContainer();
		result.setOwnerClass(ownerClass);
		result.setOwnerId(id);
		result.setFilterKey(filterKey==null?"":filterKey.trim());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName("name");
		
		pageNo = Math.max(1, pageNo);
		int pageSize = 20;
		//requestCandidateProductForSkuAsOwner
		SmartList<CandidateContainer> candidateList = candidateContainerDaoOf(userContext).requestCandidateCandidateContainerForCandidateElement(userContext,ownerClass, id, filterKey, pageNo, pageSize);
		result.setCandidates(candidateList);
		int totalCount = candidateList.getTotalCount();
		result.setTotalPage(Math.max(1, (totalCount + pageSize -1)/pageSize ));
		return result;
	}
 	
 //--------------------------------------------------------------
	
	 	
 	protected CandidateContainer loadCandidateContainer(BcexUserContext userContext, String newContainerId, Map<String,Object> options) throws Exception
 	{
		
 		return candidateContainerDaoOf(userContext).load(newContainerId, options);
 	}
 	
 	
 	
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		//deleteInternal(userContext, candidateElementId, candidateElementVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{
			
		candidateElementDaoOf(userContext).delete(candidateElementId, candidateElementVersion);
	}
	
	public CandidateElement forgetByAll(BcexUserContext userContext, String candidateElementId, int candidateElementVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateElementId, candidateElementVersion);		
	}
	protected CandidateElement forgetByAllInternal(BcexUserContext userContext,
			String candidateElementId, int candidateElementVersion) throws Exception{
			
		return candidateElementDaoOf(userContext).disconnectFromAll(candidateElementId, candidateElementVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateElementManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return candidateElementDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	public void onNewInstanceCreated(BcexUserContext userContext, CandidateElement newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}







