

/*

这里面放置你需要定制的行为，可以增加方法，也可以重写原来的方法，主要是增加新的约束和关联。
注意，在同名方法里面一定要使用super来调用，不然将会出现缓冲出溢出的问题Stack Overflow。
这个类讲在第一次生成，此后这些文件不会被覆盖，如果名字发生了变更，则需要手动删除，修改本类来适应新的模型变更，
这个类已经被配置到了相应的Spring配置文件 WEB-INF/bcex_custom_src/META-INF/bcex_custom.xml 中，
所以直接在里面重写或者增加新的方法将会修改客户的行为

*/


package com.doublechaintech.bcex.changerequest;
import java.util.Date;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;

import cn.binarywang.wx.miniapp.api.WxMaService;

public class ChangeRequestCustomManagerImpl extends ChangeRequestManagerImpl{

	protected  WxMaService  wxMaService;
	protected ChangeRequestCustomService changeRequestService;

	public ChangeRequestCustomService getChangeRequestService() {
		return changeRequestService;
	}
	public void setChangeRequestService(ChangeRequestCustomService changeRequestService) {
		this.changeRequestService = changeRequestService;
	}
	public WxMaService getWxMaService() {
		return wxMaService;
	}
	public void setWxMaService(WxMaService wxMaService) {
		this.wxMaService = wxMaService;
	}
	

	/*
	 * 小程序端可以注册，分享用户的昵称和头像
	 * 
	 * */
	
	public ChangeRequest updateProfile(CustomBcexUserContextImpl ctx, String nickname,  String avartImage) {
		
		
		
		
		
		
		
		
		
		
		return null;
	}
	/*
	 * 用户开始回答问题，系统随机从系统中选择出来10道题，
	 * 
	 * 
	 * */
	public ChangeRequest startExam(BcexUserContext userContext) {
		
		
		
		return null;
	}
	/*
	 * 用户回答问题，用提供答案和要回答的问题Id，通过这个id可以找到是哪个question，从而获取正确答案，
	 * 用户回答正确只是做一个记录，回答错误的话，要多记录一个错题日志
	 * 如果是最后一道题，则返回一个完成标记，显示成绩，分享链接
	 * 
	 * 
	 * */
	public ChangeRequest answerQuestion(BcexUserContext userContext, String awserId,  String userAwnser) {
		
		return null;
	}
	/*
	 * 用户分享问答链接，提供一个HTML页面供朋友们查看。
	 * 
	 * */
	
	public ChangeRequest shareExam(BcexUserContext userContext, String examId) {
		
		return null;
	}
	
	
	
	
	/*
	 * 
	 * 	<registeration
		nick_name="豆豆鬼|[1,200]"
		avarta="share.jpg"
		change_request="$(change_request)"
		_features="event"
	/>
	
	<start_exam
		nick_name="豆豆鬼参与考试|[1,200]"
		
		change_request="$(change_request)"
		_features="event"
	/>
	
	<answer_question
		nick_name="豆豆鬼参与考试|[1,200]"
		user="$(wechat_user)"
		question="$(question)"
		answer="A|B|C|[1,20]"
		change_request="$(change_request)"
		_features="event"
	/>
	 * 
	 * 
	 * */
	
	
	


}

