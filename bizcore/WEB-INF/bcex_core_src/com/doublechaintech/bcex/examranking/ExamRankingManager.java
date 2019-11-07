
package com.doublechaintech.bcex.examranking;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface ExamRankingManager{

		

	public ExamRanking createExamRanking(BcexUserContext userContext, String name, String avarta, String platformId) throws Exception;	
	public ExamRanking updateExamRanking(BcexUserContext userContext,String examRankingId, int examRankingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ExamRanking loadExamRanking(BcexUserContext userContext, String examRankingId, String [] tokensExpr) throws Exception;
	public ExamRanking internalSaveExamRanking(BcexUserContext userContext, ExamRanking examRanking) throws Exception;
	public ExamRanking internalSaveExamRanking(BcexUserContext userContext, ExamRanking examRanking,Map<String,Object>option) throws Exception;
	
	public ExamRanking transferToAnotherPlatform(BcexUserContext userContext, String examRankingId, String anotherPlatformId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String examRankingId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, ExamRanking newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


