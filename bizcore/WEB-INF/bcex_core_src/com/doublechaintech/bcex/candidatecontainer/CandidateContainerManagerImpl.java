
package com.doublechaintech.bcex.candidatecontainer;

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

import com.doublechaintech.bcex.candidateelement.CandidateElement;


import com.doublechaintech.bcex.candidatecontainer.CandidateContainer;






public class CandidateContainerManagerImpl extends CustomBcexCheckerManager implements CandidateContainerManager {
	
	private static final String SERVICE_TYPE = "CandidateContainer";
	
	@Override
	public String serviceFor(){
		return SERVICE_TYPE;
	}
	
	
	protected void throwExceptionWithMessage(String value) throws CandidateContainerManagerException{
	
		Message message = new Message();
		message.setBody(value);
		throw new CandidateContainerManagerException(message);

	}
	
	

 	protected CandidateContainer saveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer, String [] tokensExpr) throws Exception{	
 		//return getCandidateContainerDAO().save(candidateContainer, tokens);
 		
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		return saveCandidateContainer(userContext, candidateContainer, tokens);
 	}
 	
 	protected CandidateContainer saveCandidateContainerDetail(BcexUserContext userContext, CandidateContainer candidateContainer) throws Exception{	

 		
 		return saveCandidateContainer(userContext, candidateContainer, allTokens());
 	}
 	
 	public CandidateContainer loadCandidateContainer(BcexUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 			
 		Map<String,Object>tokens = parseTokens(tokensExpr);
 		
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}
 	
 	
 	 public CandidateContainer searchCandidateContainer(BcexUserContext userContext, String candidateContainerId, String textToSearch,String [] tokensExpr) throws Exception{				
 
 		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 		
 		Map<String,Object>tokens = tokens().allTokens().searchEntireObjectText("startsWith", textToSearch).initWithArray(tokensExpr);
 		
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, tokens);
 		//do some calc before sent to customer?
 		return present(userContext,candidateContainer, tokens);
 	}
 	
 	

 	protected CandidateContainer present(BcexUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens) throws Exception {
		
		
		addActions(userContext,candidateContainer,tokens);
		
		
		CandidateContainer  candidateContainerToPresent = candidateContainerDaoOf(userContext).present(candidateContainer, tokens);
		
		List<BaseEntity> entityListToNaming = candidateContainerToPresent.collectRefercencesFromLists();
		candidateContainerDaoOf(userContext).alias(entityListToNaming);
		
		return  candidateContainerToPresent;
		
		
	}
 
 	
 	
 	public CandidateContainer loadCandidateContainerDetail(BcexUserContext userContext, String candidateContainerId) throws Exception{	
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, allTokens());
 		return present(userContext,candidateContainer, allTokens());
		
 	}
 	
 	public Object view(BcexUserContext userContext, String candidateContainerId) throws Exception{	
 		CandidateContainer candidateContainer = loadCandidateContainer( userContext, candidateContainerId, viewTokens());
 		return present(userContext,candidateContainer, allTokens());
		
 	}
 	protected CandidateContainer saveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer, Map<String,Object>tokens) throws Exception{	
 		return candidateContainerDaoOf(userContext).save(candidateContainer, tokens);
 	}
 	protected CandidateContainer loadCandidateContainer(BcexUserContext userContext, String candidateContainerId, Map<String,Object>tokens) throws Exception{	
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).throwExceptionIfHasErrors( CandidateContainerManagerException.class);

 
 		return candidateContainerDaoOf(userContext).load(candidateContainerId, tokens);
 	}

	


 	


 	
 	
 	protected<T extends BaseEntity> void addActions(BcexUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){
		super.addActions(userContext, candidateContainer, tokens);
		
		addAction(userContext, candidateContainer, tokens,"@create","createCandidateContainer","createCandidateContainer/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@update","updateCandidateContainer","updateCandidateContainer/"+candidateContainer.getId()+"/","main","primary");
		addAction(userContext, candidateContainer, tokens,"@copy","cloneCandidateContainer","cloneCandidateContainer/"+candidateContainer.getId()+"/","main","primary");
		
		addAction(userContext, candidateContainer, tokens,"candidate_container.addCandidateElement","addCandidateElement","addCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.removeCandidateElement","removeCandidateElement","removeCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.updateCandidateElement","updateCandidateElement","updateCandidateElement/"+candidateContainer.getId()+"/","candidateElementList","primary");
		addAction(userContext, candidateContainer, tokens,"candidate_container.copyCandidateElementFrom","copyCandidateElementFrom","copyCandidateElementFrom/"+candidateContainer.getId()+"/","candidateElementList","primary");
	
		
		
	}// end method of protected<T extends BaseEntity> void addActions(BcexUserContext userContext, CandidateContainer candidateContainer, Map<String, Object> tokens){
	
 	
 	
 
 	
 	


	public CandidateContainer createCandidateContainer(BcexUserContext userContext,String name) throws Exception
	{
		
		

		

		checkerOf(userContext).checkNameOfCandidateContainer(name);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);


		CandidateContainer candidateContainer=createNewCandidateContainer();	

		candidateContainer.setName(name);

		candidateContainer = saveCandidateContainer(userContext, candidateContainer, emptyOptions());
		
		onNewInstanceCreated(userContext, candidateContainer);
		return candidateContainer;

		
	}
	protected CandidateContainer createNewCandidateContainer() 
	{
		
		return new CandidateContainer();		
	}
	
	protected void checkParamsForUpdatingCandidateContainer(BcexUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr)throws Exception
	{
		

		
		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkVersionOfCandidateContainer( candidateContainerVersion);
		

		if(CandidateContainer.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfCandidateContainer(parseString(newValueExpr));
		}
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
	
		
	}
	
	
	
	public CandidateContainer clone(BcexUserContext userContext, String fromCandidateContainerId) throws Exception{
		
		return candidateContainerDaoOf(userContext).clone(fromCandidateContainerId, this.allTokens());
	}
	
	public CandidateContainer internalSaveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer) throws Exception 
	{
		return internalSaveCandidateContainer(userContext, candidateContainer, allTokens());

	}
	public CandidateContainer internalSaveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer, Map<String,Object> options) throws Exception 
	{
		//checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);
		
		
		synchronized(candidateContainer){ 
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			if (candidateContainer.isChanged()){
			
			}
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, options);
			return candidateContainer;
			
		}

	}
	
	public CandidateContainer updateCandidateContainer(BcexUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);
		
		
		
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){ 
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			
			candidateContainer.changeProperty(property, newValueExpr);
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}
	
	public CandidateContainer updateCandidateContainerProperty(BcexUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception 
	{
		checkParamsForUpdatingCandidateContainer(userContext, candidateContainerId, candidateContainerVersion, property, newValueExpr, tokensExpr);
		
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		if(candidateContainer.getVersion() != candidateContainerVersion){
			String message = "The target version("+candidateContainer.getVersion()+") is not equals to version("+candidateContainerVersion+") provided";
			throwExceptionWithMessage(message);
		}
		synchronized(candidateContainer){ 
			//will be good when the candidateContainer loaded from this JVM process cache.
			//also good when there is a ram based DAO implementation
			//make changes to CandidateContainer.
			
			candidateContainer.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			//return saveCandidateContainer(userContext, candidateContainer, tokens().done());
		}

	}
	protected Map<String,Object> emptyOptions(){
		return tokens().done();
	}
	
	protected CandidateContainerTokens tokens(){
		return CandidateContainerTokens.start();
	}
	protected Map<String,Object> parseTokens(String [] tokensExpr){
		return tokens().initWithArray(tokensExpr);
	}
	protected Map<String,Object> allTokens(){
		return CandidateContainerTokens.all();
	}
	protected Map<String,Object> viewTokens(){
		return tokens().allTokens()
		.sortCandidateElementListWith("id","desc")
		.analyzeAllLists().done();

	}
	protected Map<String,Object> mergedAllTokens(String []tokens){
		return CandidateContainerTokens.mergeAll(tokens).done();
	}
	
//--------------------------------------------------------------
	
	//--------------------------------------------------------------

	public void delete(BcexUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		//deleteInternal(userContext, candidateContainerId, candidateContainerVersion);		
	}
	protected void deleteInternal(BcexUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{
			
		candidateContainerDaoOf(userContext).delete(candidateContainerId, candidateContainerVersion);
	}
	
	public CandidateContainer forgetByAll(BcexUserContext userContext, String candidateContainerId, int candidateContainerVersion) throws Exception {
		return forgetByAllInternal(userContext, candidateContainerId, candidateContainerVersion);		
	}
	protected CandidateContainer forgetByAllInternal(BcexUserContext userContext,
			String candidateContainerId, int candidateContainerVersion) throws Exception{
			
		return candidateContainerDaoOf(userContext).disconnectFromAll(candidateContainerId, candidateContainerVersion);
	}
	
	

	
	public int deleteAll(BcexUserContext userContext, String secureCode) throws Exception
	{
		/*
		if(!("dElEtEaLl".equals(secureCode))){
			throw new CandidateContainerManagerException("Your secure code is not right, please guess again");
		}
		return deleteAllInternal(userContext);
		*/
		return 0;
	}
	
	
	protected int deleteAllInternal(BcexUserContext userContext) throws Exception{
		return candidateContainerDaoOf(userContext).deleteAll();
	}


	
	
	
	
	

	protected void checkParamsForAddingCandidateElement(BcexUserContext userContext, String candidateContainerId, String name, String type, String image,String [] tokensExpr) throws Exception{
		
				checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);

		
		checkerOf(userContext).checkNameOfCandidateElement(name);
		
		checkerOf(userContext).checkTypeOfCandidateElement(type);
		
		checkerOf(userContext).checkImageOfCandidateElement(image);
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);

	
	}
	public  CandidateContainer addCandidateElement(BcexUserContext userContext, String candidateContainerId, String name, String type, String image, String [] tokensExpr) throws Exception
	{	
		
		checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, type, image,tokensExpr);
		
		CandidateElement candidateElement = createCandidateElement(userContext,name, type, image);
		
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){ 
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.addCandidateElement( candidateElement );		
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			userContext.getManagerGroup().getCandidateElementManager().onNewInstanceCreated(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}
	protected void checkParamsForUpdatingCandidateElementProperties(BcexUserContext userContext, String candidateContainerId,String id,String name,String type,String image,String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(id);
		
		checkerOf(userContext).checkNameOfCandidateElement( name);
		checkerOf(userContext).checkTypeOfCandidateElement( type);
		checkerOf(userContext).checkImageOfCandidateElement( image);

		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
		
	}
	public  CandidateContainer updateCandidateElementProperties(BcexUserContext userContext, String candidateContainerId, String id,String name,String type,String image, String [] tokensExpr) throws Exception
	{	
		checkParamsForUpdatingCandidateElementProperties(userContext,candidateContainerId,id,name,type,image,tokensExpr);

		Map<String, Object> options = tokens()
				.allTokens()
				//.withCandidateElementListList()
				.searchCandidateElementListWith(CandidateElement.ID_PROPERTY, "is", id).done();
		
		CandidateContainer candidateContainerToUpdate = loadCandidateContainer(userContext, candidateContainerId, options);
		
		if(candidateContainerToUpdate.getCandidateElementList().isEmpty()){
			throw new CandidateContainerManagerException("CandidateElement is NOT FOUND with id: '"+id+"'");
		}
		
		CandidateElement item = candidateContainerToUpdate.getCandidateElementList().first();
		
		item.updateName( name );
		item.updateType( type );
		item.updateImage( image );

		
		//checkParamsForAddingCandidateElement(userContext,candidateContainerId,name, code, used,tokensExpr);
		CandidateContainer candidateContainer = saveCandidateContainer(userContext, candidateContainerToUpdate, tokens().withCandidateElementList().done());
		synchronized(candidateContainer){ 
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
	}
	
	
	protected CandidateElement createCandidateElement(BcexUserContext userContext, String name, String type, String image) throws Exception{

		CandidateElement candidateElement = new CandidateElement();
		
		
		candidateElement.setName(name);		
		candidateElement.setType(type);		
		candidateElement.setImage(image);
	
		
		return candidateElement;
	
		
	}
	
	protected CandidateElement createIndexedCandidateElement(String id, int version){

		CandidateElement candidateElement = new CandidateElement();
		candidateElement.setId(id);
		candidateElement.setVersion(version);
		return candidateElement;			
		
	}
	
	protected void checkParamsForRemovingCandidateElementList(BcexUserContext userContext, String candidateContainerId, 
			String candidateElementIds[],String [] tokensExpr) throws Exception {
		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		for(String candidateElementIdItem: candidateElementIds){
			checkerOf(userContext).checkIdOfCandidateElement(candidateElementIdItem);
		}
		
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
		
	}
	public  CandidateContainer removeCandidateElementList(BcexUserContext userContext, String candidateContainerId, 
			String candidateElementIds[],String [] tokensExpr) throws Exception{
			
			checkParamsForRemovingCandidateElementList(userContext, candidateContainerId,  candidateElementIds, tokensExpr);
			
			
			CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
			synchronized(candidateContainer){ 
				//Will be good when the candidateContainer loaded from this JVM process cache.
				//Also good when there is a RAM based DAO implementation
				candidateContainerDaoOf(userContext).planToRemoveCandidateElementList(candidateContainer, candidateElementIds, allTokens());
				candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
				deleteRelationListInGraph(userContext, candidateContainer.getCandidateElementList());
				return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
			}
	}
	
	protected void checkParamsForRemovingCandidateElement(BcexUserContext userContext, String candidateContainerId, 
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
	
	}
	public  CandidateContainer removeCandidateElement(BcexUserContext userContext, String candidateContainerId, 
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForRemovingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);
		
		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){ 
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			candidateContainer.removeCandidateElement( candidateElement );		
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			deleteRelationInGraph(userContext, candidateElement);
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
		
		
	}
	protected void checkParamsForCopyingCandidateElement(BcexUserContext userContext, String candidateContainerId, 
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkerOf(userContext).checkIdOfCandidateContainer( candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
	
	}
	public  CandidateContainer copyCandidateElementFrom(BcexUserContext userContext, String candidateContainerId, 
		String candidateElementId, int candidateElementVersion,String [] tokensExpr) throws Exception{
		
		checkParamsForCopyingCandidateElement(userContext,candidateContainerId, candidateElementId, candidateElementVersion,tokensExpr);
		
		CandidateElement candidateElement = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, allTokens());
		synchronized(candidateContainer){ 
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			
			
			
			candidateContainer.copyCandidateElementFrom( candidateElement );		
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			
			userContext.getManagerGroup().getCandidateElementManager().onNewInstanceCreated(userContext, (CandidateElement)candidateContainer.getFlexiableObjects().get(BaseEntity.COPIED_CHILD));
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}
		
	}
	
	protected void checkParamsForUpdatingCandidateElement(BcexUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception{
		

		
		checkerOf(userContext).checkIdOfCandidateContainer(candidateContainerId);
		checkerOf(userContext).checkIdOfCandidateElement(candidateElementId);
		checkerOf(userContext).checkVersionOfCandidateElement(candidateElementVersion);
		

		if(CandidateElement.NAME_PROPERTY.equals(property)){
			checkerOf(userContext).checkNameOfCandidateElement(parseString(newValueExpr));
		}
		
		if(CandidateElement.TYPE_PROPERTY.equals(property)){
			checkerOf(userContext).checkTypeOfCandidateElement(parseString(newValueExpr));
		}
		
		if(CandidateElement.IMAGE_PROPERTY.equals(property)){
			checkerOf(userContext).checkImageOfCandidateElement(parseString(newValueExpr));
		}
		
	
		checkerOf(userContext).throwExceptionIfHasErrors(CandidateContainerManagerException.class);
	
	}
	
	public  CandidateContainer updateCandidateElement(BcexUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)
			throws Exception{
		
		checkParamsForUpdatingCandidateElement(userContext, candidateContainerId, candidateElementId, candidateElementVersion, property, newValueExpr,  tokensExpr);
		
		Map<String,Object> loadTokens = this.tokens().withCandidateElementList().searchCandidateElementListWith(CandidateElement.ID_PROPERTY, "eq", candidateElementId).done();
		
		
		
		CandidateContainer candidateContainer = loadCandidateContainer(userContext, candidateContainerId, loadTokens);
		
		synchronized(candidateContainer){ 
			//Will be good when the candidateContainer loaded from this JVM process cache.
			//Also good when there is a RAM based DAO implementation
			//candidateContainer.removeCandidateElement( candidateElement );	
			//make changes to AcceleraterAccount.
			CandidateElement candidateElementIndex = createIndexedCandidateElement(candidateElementId, candidateElementVersion);
		
			CandidateElement candidateElement = candidateContainer.findTheCandidateElement(candidateElementIndex);
			if(candidateElement == null){
				throw new CandidateContainerManagerException(candidateElement+" is NOT FOUND" );
			}
			
			candidateElement.changeProperty(property, newValueExpr);
			
			candidateContainer = saveCandidateContainer(userContext, candidateContainer, tokens().withCandidateElementList().done());
			return present(userContext,candidateContainer, mergedAllTokens(tokensExpr));
		}

	}
	/*

	*/
	



	public void onNewInstanceCreated(BcexUserContext userContext, CandidateContainer newCreated) throws Exception{
		ensureRelationInGraph(userContext, newCreated);
		sendCreationEvent(userContext, newCreated);
	}

}


