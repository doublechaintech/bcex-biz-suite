
package com.doublechaintech.bcex.candidatecontainer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface CandidateContainerManager{

		

	public CandidateContainer createCandidateContainer(BcexUserContext userContext, String name) throws Exception;	
	public CandidateContainer updateCandidateContainer(BcexUserContext userContext,String candidateContainerId, int candidateContainerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateContainer loadCandidateContainer(BcexUserContext userContext, String candidateContainerId, String [] tokensExpr) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer) throws Exception;
	public CandidateContainer internalSaveCandidateContainer(BcexUserContext userContext, CandidateContainer candidateContainer,Map<String,Object>option) throws Exception;
	


	public void delete(BcexUserContext userContext, String candidateContainerId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, CandidateContainer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	

	//public  CandidateElementManager getCandidateElementManager(BcexUserContext userContext, String candidateContainerId, String name, String type, String image ,String [] tokensExpr)  throws Exception;
	
	public  CandidateContainer addCandidateElement(BcexUserContext userContext, String candidateContainerId, String name, String type, String image , String [] tokensExpr)  throws Exception;
	public  CandidateContainer removeCandidateElement(BcexUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion,String [] tokensExpr)  throws Exception;
	public  CandidateContainer updateCandidateElement(BcexUserContext userContext, String candidateContainerId, String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/



}


