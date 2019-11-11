package com.doublechaintech.bcex.wxappservice;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.changerequest.ChangeRequestCustomManagerImpl;
import com.doublechaintech.bcex.wxappservicepageview.*;

import com.terapico.utils.TextUtil;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;

/**
 * 此类负责：声明所有{@link WxappServiceViewService}中所使用的数据库搜索方法。 单独列出的目的是便于维护。
 * @author clariones
 *
 */
public abstract class WxappServiceDBQueryHelper{
	public static final Map<String, Object> EO = new HashMap<>();
	public int getPageSize(CustomBcexUserContextImpl ctx, String queryName) {
		return 20;
	}
	/**
	 * 找到随机的几个问题.
	 */
	public SmartList<Question> queryQuestionListOfRandom( CustomBcexUserContextImpl ctx , Integer number ) throws Exception {
		List<Object> params = new ArrayList<>();
		String sql = prepareSqlAndParamsForQueryQuestionListOfRandom(ctx, params, number);
		SmartList<Question> list = ctx.getDAOGroup().getQuestionDAO().queryList(sql, params.toArray());
		list.setRowsPerPage(Integer.MAX_VALUE);
		if (list == null || list.isEmpty()){
			return list;
		}
		ctx.setLastRecordId(null);
		enhanceQuestionListOfRandom(ctx, list, "queryQuestionListOfRandom", number);
		return list;
	}
	
	/**
	 * 找到随机的几个问题.
	 */
	protected String prepareSqlAndParamsForQueryQuestionListOfRandom( CustomBcexUserContextImpl ctx , List<Object> params, Integer number ) throws Exception {
		String sql = "select D.* from question_data D ";
		return sql + " order by D.id desc";
	}
	
	protected void enhanceQuestionListOfRandom(CustomBcexUserContextImpl ctx, SmartList<Question> list, String queryName, Integer number) throws Exception {
	}

	/**
	 * 查询用户的错题库.
	 */
	public SmartList<FaultAnswer> queryFaultAnswerListOfUser( CustomBcexUserContextImpl ctx , String userId , String lastRecordId ) throws Exception {
		FaultAnswer lastRecord = null;
		if (!TextUtil.isBlank(lastRecordId)) {
			lastRecord = ctx.getDAOGroup().getFaultAnswerDAO().load(lastRecordId, EO);
		}
		List<Object> params = new ArrayList<>();
		int pageSize = getPageSize(ctx, "queryFaultAnswerListOfUser");
		String sql = prepareSqlAndParamsForQueryFaultAnswerListOfUser(ctx, lastRecord, pageSize+1, params, userId);
		SmartList<FaultAnswer> list = ctx.getDAOGroup().getFaultAnswerDAO().queryList(sql, params.toArray());
		list.setRowsPerPage(pageSize);
		if (list == null || list.isEmpty()){
			return list;
		}
		if (list.size() > pageSize){
			ctx.setLastRecordId(list.last().getId());
		}else{
			ctx.setLastRecordId(null);
		}
		enhanceFaultAnswerListOfUser(ctx, list, "queryFaultAnswerListOfUser", userId);
		return list;
	}
	
	/**
	 * 查询用户的错题库.
	 */
	protected String prepareSqlAndParamsForQueryFaultAnswerListOfUser( CustomBcexUserContextImpl ctx , FaultAnswer lastRecord, int limit , List<Object> params, String userId ) throws Exception {
		String sql = "select D.* from fault_answer_data D ";
		if (lastRecord != null) {
			params.add(lastRecord.getId());
			sql += " where D.id <= ? ";
		}
		params.add(limit);
		return sql + " order by D.id desc limit ?";
	}
	
	protected void enhanceFaultAnswerListOfUser(CustomBcexUserContextImpl ctx, SmartList<FaultAnswer> list, String queryName, String userId) throws Exception {
	}

}
