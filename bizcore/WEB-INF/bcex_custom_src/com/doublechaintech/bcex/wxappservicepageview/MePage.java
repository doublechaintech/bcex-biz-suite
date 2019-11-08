package com.doublechaintech.bcex.wxappservicepageview;

import com.terapico.caf.viewpage.SerializeScope;
import com.terapico.utils.CollectionUtils;

import java.util.List;

import com.doublechaintech.bcex.BaseViewPage;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.utils.LineItemNavigator;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.wxappservice.WxappServiceViewService;
import com.doublechaintech.bcex.BcexViewScope;

public class MePage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static BcexViewScope ViewScope = BcexViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.me();
//	SerializeScope.INCLUDE()
//			.field("title")
//			.field("popup")
//			.field("toast", SerializeScope.EXCLUDE())
//			.field("refreshAction")
//			.field("actions", SerializeScope.EXCLUDE())
//			.field("actionList")
//			.field("id")
//			.field("name")
//			.field("brief")
//			.field("imageUrl")
//			;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "我的";
		}
		return pageTitle;
	}
	@Override
	protected void afterDoRendering() {
		super.afterDoRendering();
		userContext.forceResponseXClassHeader("com.terapico.appview.MePage");
	}
	@Override
	public void assemblerContent(BcexUserContext userContext, String requestName)throws Exception {
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl)userContext;
		WechatUser user = ctx.getCurrentUserInfo();
		setPageTitle(user.getName());
		set("id", user.getId());
		set("name", user.getName());
		set("brief", user.getUserType());
		set("imageUrl", user.getAvarta());
		
		ctx.addAction("开始考试","start-exam", WxappServiceViewService.makeStartExamUrl(ctx));
		ctx.addAction("查看成绩","scoreboard", WxappServiceViewService.makeViewScoreUrl(ctx, null));
		
		set("lineItemNavigatorList", makeMeNavigationList(ctx));
		set("actions", ctx.getActions());
	}

	private List<LineItemNavigator> makeMeNavigationList(CustomBcexUserContextImpl ctx) {
		// field("lineItemNavigatorList", SerializeScope.INCLUDE()
		return CollectionUtils.toList(new LineItemNavigator("mistake", null, "错题", null, "快去练习吧"),
				new LineItemNavigator("donation", null, "打赏", null, "做的不错,👍"));
	}
}
