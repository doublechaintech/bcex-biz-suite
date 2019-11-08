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
	
	// 更新个人信息(update profile)
	public Object customerUpdateProfile(BcexUserContext userContext, String name , String avantar , String userType) throws Exception {
		String accessUrl = makeUrlF("customerUpdateProfile", false, name , avantar , userType);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.setName(name);
		ctx.setAvantar(avantar);
		ctx.setUserType(userType);
		commonLog(ctx, "customerUpdateProfile", "更新个人信息", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false, name , avantar , userType), null);
		int resultCode = processRequestCustomerUpdateProfile(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerSimplePopupPage(ctx, "customerUpdateProfile");
		return page.doRender(ctx);
	}
	
	// 开始考试(start exam)
	public Object customerStartExam(BcexUserContext userContext) throws Exception {
		String accessUrl = makeUrlF("customerStartExam", false);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		commonLog(ctx, "customerStartExam", "开始考试", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false), null);
		int resultCode = processRequestCustomerStartExam(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerAnswerSheetPage(ctx, "customerStartExam");
		return page.doRender(ctx);
	}
	
	// 答题(answer question)
	public Object customerAnswerQuestion(BcexUserContext userContext, String quizId , String answer) throws Exception {
		String accessUrl = makeUrlF("customerAnswerQuestion", false, quizId , answer);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.setQuizId(quizId);
		ctx.setAnswer(answer);
		commonLog(ctx, "customerAnswerQuestion", "答题", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false, quizId , answer), null);
		int resultCode = processRequestCustomerAnswerQuestion(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = null;
		switch(resultCode){
			case PRC_ALL_DONE:{
				// 全部答完
				page = assemblerExamResultPage(ctx, "customerAnswerQuestion");
				break;
			}
			case PRC_HAS_MORE_QUESTION:
			case PRC_BY_DEFAULT: {
				page = assemblerAnswerSheetPage(ctx, "customerAnswerQuestion");
				break;
			}
			default: {
				throw new Exception("未定义的分支代码"+resultCode);
			}
		}
		return page.doRender(ctx);
	}
	
	// 查看成绩(view score)
	public Object customerViewScore(BcexUserContext userContext, String quizId) throws Exception {
		String accessUrl = makeUrlF("customerViewScore", false, quizId);
		
		CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
		ctx.setAccessUrl(accessUrl);
		ensureCurrentUserInfo(ctx);
		ctx.setQuizId(quizId);
		commonLog(ctx, "customerViewScore", "查看成绩", ctx.getRemoteIP(), ctx.tokenId(), makeUrlF("", false, quizId), null);
		int resultCode = processRequestCustomerViewScore(ctx);
		if (returnRightNow(resultCode)){
			return ctx.getResultObject();
		}
		BaseViewPage page = assemblerScoreboardPage(ctx, "customerViewScore");
		return page.doRender(ctx);
	}
	
}

