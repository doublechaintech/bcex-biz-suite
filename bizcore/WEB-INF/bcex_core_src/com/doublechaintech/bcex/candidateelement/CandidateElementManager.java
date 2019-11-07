
package com.doublechaintech.bcex.candidateelement;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface CandidateElementManager{

		

	public CandidateElement createCandidateElement(BcexUserContext userContext, String name, String type, String image, String containerId) throws Exception;	
	public CandidateElement updateCandidateElement(BcexUserContext userContext,String candidateElementId, int candidateElementVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public CandidateElement loadCandidateElement(BcexUserContext userContext, String candidateElementId, String [] tokensExpr) throws Exception;
	public CandidateElement internalSaveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement) throws Exception;
	public CandidateElement internalSaveCandidateElement(BcexUserContext userContext, CandidateElement candidateElement,Map<String,Object>option) throws Exception;
	
	public CandidateElement transferToAnotherContainer(BcexUserContext userContext, String candidateElementId, String anotherContainerId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String candidateElementId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, CandidateElement newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}











