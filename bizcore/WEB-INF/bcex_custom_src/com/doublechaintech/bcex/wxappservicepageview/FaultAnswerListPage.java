package com.doublechaintech.bcex.wxappservicepageview;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.doublechaintech.bcex.BaseViewPage;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BcexViewScope;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.wxappservice.DBQuery;
import com.doublechaintech.bcex.wxappservice.WxappServiceViewService;
import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.utils.MapUtil;

public class FaultAnswerListPage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static BcexViewScope ViewScope = BcexViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.INCLUDE()
			.field("title")
			.field("popup")
			.field("toast", SerializeScope.EXCLUDE())
			.field("refreshAction")
			.field("actions", SerializeScope.EXCLUDE())
			.field("actionList")
			.field("displayMode")
			.field("emptyMessage")
			.field("list", SerializeScope.INCLUDE()
					.field(FaultAnswer.QUESTION_PROPERTY, SerializeScope.INCLUDE()
							.field(Question.TOPIC_PROPERTY).as("title")
						).move_up()
				  ).in_data_container()
			.field("tabs")
			;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "我的错题";
		}
		return pageTitle;
	}
	@Override
	protected void beforeDoRendering() {
		super.beforeDoRendering();
		this.set("displayMode", "only-title");
	}
	@Override
	protected void afterDoRendering() {
		super.afterDoRendering();
		forceResponseAsListOfPage();
	}
	@Override
	public void assemblerContent(BcexUserContext userContext, String requestName)throws Exception {
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl)userContext;
		DBQuery Q = new DBQuery();
		WechatUser user = ctx.getCurrentUserInfo();
		String lastRecordId = ctx.getLastRecordId();
		SmartList<FaultAnswer> list = Q.queryFaultAnswerListOfUser(ctx, user.getId(), lastRecordId);
		list.addItemToValueMap(BaseViewPage.X_NEXT_PAGE_URL, WxappServiceViewService.makeViewNextPageFaultAnswerUrl(ctx, ctx.getLastRecordId()));
		set("list", list);
		set("emptyMessage", "您太厉害了,没有任何错误!");
	}
}
