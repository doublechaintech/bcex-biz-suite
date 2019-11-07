package com.doublechaintech.bcex.wxappservice;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.BaseViewPage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;



/**
 * 此类负责：所有的页面入口。 以及页面的组装
 * @author clariones
 *
 */
public abstract class WxappServiceViewService extends BaseWxappServiceViewService{
	// 默认的客户端登录接口(client login)
	public Object clientLogin(BcexUserContext userContext, com.terapico.caf.baseelement.LoginParam loginParam) throws Exception {
		String accessUrl = makeUrlF("clientLogin", false, loginParam);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		getCurrentUserInfo(ctx);
		ctx.setLoginParam(loginParam);
		commonLog(ctx, "clientLogin", "默认的客户端登录接口", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false, loginParam), null);
		int resultCode = processRequestClientLogin(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerMePage(ctx, "clientLogin");
		return page.doRender(ctx);
	}
	
	// 查看首页(view homepage)
	public Object viewHomepage(BcexUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("viewHomepage", false);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		getCurrentUserInfo(ctx);
		ctx.addFootprint(this);
		commonLog(ctx, "viewHomepage", "查看首页", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestViewHomepage(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerHomePage(ctx, "viewHomepage");
		page.setLinkToUrl(accessUrl);
		return page.doRender(ctx);
	}
	
	// 我的(view dashboard)
	public Object customerViewDashboard(BcexUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("customerViewDashboard", false);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.addFootprint(this);
		commonLog(ctx, "customerViewDashboard", "我的", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestCustomerViewDashboard(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerMePage(ctx, "customerViewDashboard");
		page.setLinkToUrl(accessUrl);
		return page.doRender(ctx);
	}
	
}

