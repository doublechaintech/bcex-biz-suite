package com.doublechaintech.bcex.wxappservice;

import java.util.List;

import com.doublechaintech.bcex.CustomBcexUserContextImpl;

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
}
