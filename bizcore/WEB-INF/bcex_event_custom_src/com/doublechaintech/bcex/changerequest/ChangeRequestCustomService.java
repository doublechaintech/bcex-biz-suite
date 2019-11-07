
package  com.doublechaintech.bcex.changerequest;

import com.doublechaintech.bcex.BcexUserContext;
public class ChangeRequestCustomService extends ChangeRequestService{
	
	/*
	 * 小程序端可以注册，分享用户的昵称和头像
	 * 
	 * */
	
	public ChangeRequest register(BcexUserContext userContext, String nickname,  String avartImage ) {
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




