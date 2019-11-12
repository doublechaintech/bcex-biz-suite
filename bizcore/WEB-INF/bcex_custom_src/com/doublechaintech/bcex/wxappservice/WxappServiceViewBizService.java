package com.doublechaintech.bcex.wxappservice;

import java.util.Map;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.secuser.SecUser;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.utils.BcexConstants;
import com.doublechaintech.bcex.utils.MiscUtils;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.skynet.infrastructure.StorageService;
import com.terapico.caf.DateTime;
import com.terapico.caf.baseelement.LoginParam;
import com.terapico.caf.viewcomponent.PopupViewComponent;
import com.terapico.utils.DebugUtil;
import com.terapico.utils.ImageUtil;
import com.terapico.utils.RandomUtil;


/**
 * 此类负责：所有的业务逻辑，例如所有的过滤规则，计算规则
 * @author clariones
 *
 */
public class WxappServiceViewBizService extends BasicWxappServiceViewBizService{
	// 处理请求：默认的客户端登录接口. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestClientLogin(CustomBcexUserContextImpl ctx) throws Exception {
		this.processClientLogin(ctx, ctx.getLoginParam());
		return PRC_BY_DEFAULT;
	}
	public Object loginForTest(CustomBcexUserContextImpl ctx, String formData) throws Exception {
		LoginParam logp = DebugUtil.getObjectMapper().readValue(formData, LoginParam.class);
		return clientLogin(ctx, logp);
	}
	
	// 处理请求：查看首页. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestViewHomepage(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	
	// 处理请求：我的. 返回值：PRC_BY_DEFAULT: ; 
	@Override
	protected int processRequestCustomerViewDashboard(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	

	@Override
	protected void commonLog(CustomBcexUserContextImpl ctx, String eventCode, String title, String key1, String key2,
			String key3, Object detailInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected WechatUser onNewLogin(CustomBcexUserContextImpl ctx, LoginParam loginParam, BaseLoginHandler loginHandler)
			throws Exception {
		Map<String, Object> loginInfo = loginHandler.getProcessedLoginInfo(ctx);
		String openId = (String) loginInfo.get("openId");
		String sessionKey = (String) loginInfo.get("sessionKey");
		
		// 创建对象
		String name = "点击更新头像";// "微信用户"+RandomUtil.randomChars(6);
		String avarta = ImageUtil.animal(); // 随机取个动物
		String platformId = BcexConstants.ROOT_PLATFORM_ID;
		String userType = "未填写";
		WechatUser newUser = wechatUserManagerOf(ctx).createWechatUser(ctx, name, avarta, userType, platformId);
		// 创建secUSer
		String login = openId;
		String mobile = null;
		String email = null;
		String pwd = RandomUtil.randomNumAndChars(8);
		String weixinOpenid = openId;
		String weixinAppid = this.getWxMaService().getWxMaConfig().getAppid();
		String accessToken = null;
		int verificationCode = RandomUtil.randomInteger(999999);
		DateTime verificationCodeExpire = ctx.now();
		DateTime lastLoginTime = ctx.now();
		String domainId = BcexConstants.ROOT_USERDOMAIN_ID;
		SecUser secUser = secUserManagerOf(ctx).createSecUser(ctx, login, mobile, email, pwd, weixinOpenid, weixinAppid,
				accessToken, verificationCode, verificationCodeExpire, lastLoginTime, domainId);
		// 创建userApp
		String title = "用户";
		String secUserId = secUser.getId();
		String appIcon = "user";
		boolean fullAccess = true;
		String permission = "RMWX";
		String objectType = newUser.getInternalType();
		String objectId = newUser.getId();
		String location = "link/top/";
		userAppManagerOf(ctx).createUserApp(ctx, title, secUserId, appIcon, fullAccess, permission, objectType,
				objectId, location);
		
		return newUser;
	}
	
	public Object customGetOssToken(CustomBcexUserContextImpl ctx) throws Exception{
		DecodedJWT token = super.getTokenFromClientRequest(ctx);
		if (token == null){
			throwsExceptionWithMessage(ctx,"cannot get jwt token from request");
		}

		String userUploadHome = token.getClaim("userUploadHome").asString();

		if (userUploadHome == null){
			throwsExceptionWithMessage(ctx, "userUploadHome is empty");
		}

		//we will output json only
		ctx.forceRenderingAsJson();

		StorageService storageService = (StorageService) ctx.getBean("storageService");
		return storageService.genToken(userUploadHome);
	}
	@Override
	protected int processRequestCustomerUpdateProfile(CustomBcexUserContextImpl ctx) throws Exception {
		WechatUser user = ctx.getCurrentUserInfo();
		user.updateName(ctx.getName());
		user.updateAvarta(ctx.getAvantar());
		user.updateUserType(ctx.getUserType());
		MiscUtils.updateUserInfo(ctx, user);
		
//		PopupViewComponent popup = new PopupViewComponent("更新成功","关闭");
//		ctx.setPopup(popup);
//		return PRC_BY_DEFAULT;
		return setAndReturn(ctx, true);
	}
	@Override
	protected int processRequestCustomerStartExam(CustomBcexUserContextImpl ctx) throws Exception {
		ChangeRequest startExamRequest = MiscUtils.newStarExamChangeRequest(ctx);
		this.getChangeRequestService().process(ctx, startExamRequest);
		Exam exam = ctx.getExam();
		UserAnswer curUserAnswer = MiscUtils.findNextUserAnswerOfExam(ctx, exam, null);
		ctx.setUserAnswer(curUserAnswer);
		return PRC_BY_DEFAULT;
	}
	@Override
	protected int processRequestCustomerAnswerQuestion(CustomBcexUserContextImpl ctx) throws Exception {
		ChangeRequest answerRequest = MiscUtils.newAnswerQuestionChangeRequest(ctx);
		this.getChangeRequestService().process(ctx, answerRequest);
//		Exam exam = ctx.getExam();
//		UserAnswer curUserAnswer = MiscUtils.findNextUserAnswerOfExam(ctx, exam, ctx.getQuizId());
//		ctx.setUserAnswer(curUserAnswer);
//		if (curUserAnswer == null) {
//			return PRC_ALL_DONE;
//		}
//		return PRC_HAS_MORE_QUESTION;
		return setAndReturn(ctx, true);
	}
	@Override
	protected int processRequestCustomerViewScore(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	@Override
	protected int processRequestCustomerViewFaultAnswer(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	@Override
	protected int processRequestCustomerViewNextPageFaultAnswer(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	@Override
	protected int processRequestCustomerExamFaultAnswer(CustomBcexUserContextImpl ctx) throws Exception {
		return PRC_BY_DEFAULT;
	}
	
}