package com.doublechaintech.bcex.utils;

import com.doublechaintech.bcex.BcexBaseUtils;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.terapico.utils.TaskUtil;
import com.terapico.utils.TextUtil;

public class MiscUtils extends BcexBaseUtils {

	public static void updateUserInfo(CustomBcexUserContextImpl ctx, WechatUser user) throws Exception {
		WechatUser dbUser = null;
		String key = user.getInternalType()+"_"+user.getId();
		synchronized (TaskUtil.getLockByKey(ctx, key)) {
			dbUser = ctx.getDAOGroup().getWechatUserDAO().load(user.getId(), EO);
			dbUser.updateName(user.getName());
			dbUser.updateAvarta(user.getAvarta());
			dbUser.updateUserType(user.getUserType());
			dbUser.updateCreateTime(ctx.now());
			ctx.getDAOGroup().getWechatUserDAO().save(dbUser, EO);
		}
		dbUser.mergePrimitiveDataTo(user);
	}

	public static ChangeRequest newStarExamChangeRequest(CustomBcexUserContextImpl ctx) {
		ChangeRequest rst = new ChangeRequest();
		
		StartExam evt = new StartExam();
		evt.updateNickName(ctx.getCurrentUserInfo().getName()+"的考试")
			.updateUser(ctx.getCurrentUserInfo());
		rst.addStartExam(evt);
		rst.updatePlatform(Platform.refById(BcexConstants.ROOT_PLATFORM_ID))
			.updateRequestType(ChangeRequestType.refById(ChangeRequestType.START_EXAM))
			.updateName("CR"+System.currentTimeMillis());
		
		ctx.getChecker().checkAndFixChangeRequest(rst);
		
		return rst;
	}
	
	public static ChangeRequest newAnswerQuestionChangeRequest(CustomBcexUserContextImpl ctx) {
		ChangeRequest rst = new ChangeRequest();
		
		AnswerQuestion evt = new AnswerQuestion();
		evt.updateAnswer(ctx.getAnswer())
			.updateUserAnswer(UserAnswer.refById(ctx.getQuizId()))
			.updateUser(ctx.getCurrentUserInfo());
		rst.addAnswerQuestion(evt);
		
		rst.updatePlatform(Platform.refById(BcexConstants.ROOT_PLATFORM_ID))
			.updateRequestType(ChangeRequestType.refById(ChangeRequestType.START_EXAM))
			.updateName("CR"+System.currentTimeMillis());
		
		ctx.getChecker().checkAndFixChangeRequest(rst);
		
		return rst;
	}

	// 返回 null 表示考试完成了
	// 异常表示不对
	public static UserAnswer findNextUserAnswerOfExam(CustomBcexUserContextImpl ctx, Exam exam, String lastRcdId) {
		String sql = 
				"select * from user_answer_data UA " + 
				"	where UA.exam = ? and UA.id > ? " + 
				"   order by UA.id asc\n" + 
				"   limit ?";
		if (TextUtil.isBlank(lastRcdId)) {
			lastRcdId = "";
		}
		SmartList<UserAnswer> uaList = ctx.getDAOGroup().getUserAnswerDAO().queryList(sql, exam.getId(), lastRcdId, 1);
		if (uaList == null || uaList.isEmpty()) {
			return null;
		}
		return uaList.first();
	}

	// 计算当前用户的世界排名
	public static int findUserWorldRank(CustomBcexUserContextImpl ctx, int totalScore) {
		String sql = "select count(*) from (" + 
				"	select WU.*, sum(E.score)  as total from exam_data E" + 
				"	left join wechat_user_data WU on E.user = WU.id" + 
				"	group by WU.id" + 
				") as tbl1 where tbl1.total > ?";
		Integer rst = ctx.dao().queryForObject(sql, new Object[] {totalScore}, Integer.class);
		if (rst == null) {
			return 1;
		}
		return rst+1;
	}

	public static int calcUserTotalScore(CustomBcexUserContextImpl ctx, WechatUser user) {
		String sql = "select sum(score) from exam_data E where E.user = ?";
		Integer rst = ctx.dao().queryForObject(sql, new Object[] {user.getId()}, Integer.class);
		return rst == null ? 0 : rst;
	}

	public static int calcExamScore(CustomBcexUserContextImpl ctx, String examId) {
		String sql = "select  count(1) from user_answer_data UA" + 
				"		left join question_data Q on UA.question = Q.id" + 
				"	where UA.exam = ?" + 
				"		and UA.user_select = Q.right_answer";
		return ctx.dao().queryForObject(sql, new Object[] {examId}, Integer.class);
	}

	public static int calcUserTotalExam(CustomBcexUserContextImpl ctx, WechatUser user) {
		String sql = "select count(*) from exam_data where user=?";
		Integer rst = ctx.dao().queryForObject(sql, new Object[] {user.getId()}, Integer.class);
		return rst == null ? 0 : rst;
	}

}
