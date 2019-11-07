package com.doublechaintech.bcex.wxappservice;

import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.wxappservicepageview.HomePage;
import com.doublechaintech.bcex.wxappservicepageview.MePage;
import com.terapico.caf.baseelement.LoginParam;


/**
 * 此类负责：所有的业务逻辑，例如所有的过滤规则，计算规则
 * @author clariones
 *
 */
public class WxappServiceViewBizService extends BasicWxappServiceViewBizService{
	// 处理请求：默认的客户端登录接口. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestClientLogin(CustomBcexUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}
	
	// 处理请求：查看首页. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestViewHomepage(CustomBcexUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}
	
	// 处理请求：我的. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestCustomerViewDashboard(CustomBcexUserContextImpl ctx) throws Exception {
		// TODO
		return PRC_BY_DEFAULT;
	}
	

	// 
	@Override
	protected MePage assemblerMePage(CustomBcexUserContextImpl ctx, String requestName) throws Exception {
		// TODO
		return null;
	}
	
	// 
	@Override
	protected HomePage assemblerHomePage(CustomBcexUserContextImpl ctx, String requestName) throws Exception {
		// TODO
		return null;
	}

	@Override
	protected void commonLog(CustomBcexUserContextImpl ctx, String eventCode, String title, String key1, String key2,
			String key3, Object detailInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WechatUser onNewLogin(CustomBcexUserContextImpl ctx, LoginParam loginParam, BaseLoginHandler loginHandler)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}