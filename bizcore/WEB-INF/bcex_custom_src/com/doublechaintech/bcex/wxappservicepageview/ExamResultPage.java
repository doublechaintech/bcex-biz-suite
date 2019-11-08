package com.doublechaintech.bcex.wxappservicepageview;

import com.terapico.caf.viewpage.SerializeScope;
import com.doublechaintech.bcex.BaseViewPage;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.BcexViewScope;

public class ExamResultPage extends BaseViewPage{
	private static final long serialVersionUID = 1L;
	private static BcexViewScope ViewScope = BcexViewScope.getInstance();
	protected static final SerializeScope SCOPE = SerializeScope.INCLUDE()
			.field("title")
			.field("popup")
			.field("toast", SerializeScope.EXCLUDE())
			.field("refreshAction")
			.field("actions", SerializeScope.EXCLUDE())
			.field("actionList")
			;
	@Override
	protected SerializeScope getSerializeScope() {
		return SCOPE;
	}

	public String getPageTitle() {
		if (pageTitle == null) {
			return "exam result";
		}
		return pageTitle;
	}
	@Override
	public void assemblerContent(BcexUserContext userContext, String requestName)throws Exception {
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl)userContext;
		// TODO: 需要实现
		setPageTitle("尚未实现");
	}
}
