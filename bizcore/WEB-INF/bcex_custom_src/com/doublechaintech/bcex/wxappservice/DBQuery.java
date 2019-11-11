package com.doublechaintech.bcex.wxappservice;

import java.util.List;

import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.utils.MiscUtils;

public class DBQuery extends WxappServiceDBQueryHelper {

	/**
	 * 找到随机的几个问题.
	 */
	protected String prepareSqlAndParamsForQueryQuestionListOfRandom( CustomBcexUserContextImpl ctx , List<Object> params, Integer number ) throws Exception {
		if (number == null) {
			number = 10;
		}
		params.add(number);
		String sql = "select D.* from question_data D order by rand() limit ?";
		return sql;
	}
	
	/**
	 * 查询用户的错题库.
	 */
	protected String prepareSqlAndParamsForQueryFaultAnswerListOfUser( CustomBcexUserContextImpl ctx , FaultAnswer lastRecord, int limit , List<Object> params, String userId ) throws Exception {
		params.add(userId);
		String paginClause = "";
		if (lastRecord != null) {
			params.add(lastRecord.getFaultTimes());
			params.add(lastRecord.getFaultTimes());
			params.add(lastRecord.getId());
			paginClause = "		and (FA.fault_times < ? or (FA.fault_times=? and FA.id <= ?))" ;
		}
		String sql = "select * from fault_answer_data FA" + 
				"	where FA.user=? " + 
				paginClause + 
				"    order by FA.fault_times desc, FA.id desc" +
				"    limit ?";
		params.add(limit);
		return sql;
	}
	
	protected void enhanceFaultAnswerListOfUser(CustomBcexUserContextImpl ctx, SmartList<FaultAnswer> list, String queryName, String userId) throws Exception {
		if (list == null || list.isEmpty()) {
			return;
		}
		List<Question> qList = MiscUtils.collectReferencedObjectWithType(ctx, list, Question.class);
		ctx.getDAOGroup().getQuestionDAO().enhanceList(qList);
	}
}
