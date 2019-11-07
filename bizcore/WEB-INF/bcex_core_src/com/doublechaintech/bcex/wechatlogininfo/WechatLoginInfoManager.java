
package com.doublechaintech.bcex.wechatlogininfo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;

public interface WechatLoginInfoManager{

		

	public WechatLoginInfo createWechatLoginInfo(BcexUserContext userContext, String wechatUserId, String appId, String openId, String sessionKey) throws Exception;	
	public WechatLoginInfo updateWechatLoginInfo(BcexUserContext userContext,String wechatLoginInfoId, int wechatLoginInfoVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public WechatLoginInfo loadWechatLoginInfo(BcexUserContext userContext, String wechatLoginInfoId, String [] tokensExpr) throws Exception;
	public WechatLoginInfo internalSaveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo) throws Exception;
	public WechatLoginInfo internalSaveWechatLoginInfo(BcexUserContext userContext, WechatLoginInfo wechatLoginInfo,Map<String,Object>option) throws Exception;
	
	public WechatLoginInfo transferToAnotherWechatUser(BcexUserContext userContext, String wechatLoginInfoId, String anotherWechatUserId)  throws Exception;
 

	public void delete(BcexUserContext userContext, String wechatLoginInfoId, int version) throws Exception;
	public int deleteAll(BcexUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(BcexUserContext userContext, WechatLoginInfo newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


