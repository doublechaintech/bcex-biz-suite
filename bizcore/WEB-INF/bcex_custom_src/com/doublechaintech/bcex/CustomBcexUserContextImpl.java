package com.doublechaintech.bcex;

import com.doublechaintech.bcex.wechatuser.WechatUser;

public class CustomBcexUserContextImpl extends BcexBizUserContextImpl{

	protected WechatUser currentUserInfo;

	public WechatUser getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(WechatUser currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

	
}

