package  com.doublechaintech.bcex.changerequest;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.exam.ExamTokens;
import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.wxappservice.DBQuery;
import com.terapico.utils.DateTimeUtil;

public class StartExamCustomProcessor extends StartExamProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, StartExam event ){
		if (event == null) {
			return;
		}
		try {
			CustomBcexUserContextImpl ctx = (CustomBcexUserContextImpl) userContext;
			ctx.log("StartExamCustomProcessor\t"+ event +" from processor");
			// 无条件开创考试
			WechatUser user = ctx.getCurrentUserInfo();
			createExamForUser(ctx, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 为用户创建一个exam
	private void createExamForUser(CustomBcexUserContextImpl ctx, WechatUser user) throws Exception {
		// 先创建exam
		String name = String.format("%s-%s", user.getName(), DateTimeUtil.formatDate(ctx.now(), "yyyyMMdd HH:mm"));
		String statusId = ExamStatus.STARTED;
		String userId = user.getId();
		int score = 0;
		Exam exam = examManagerOf(ctx).createExam(ctx, name, statusId, userId, score);
		// 然后挑题目
		DBQuery Q = new DBQuery();
		SmartList<Question> questionList = Q.queryQuestionListOfRandom(ctx, 10);
		// 再讲题目加入考试
		questionList.forEach(q->{
			UserAnswer userAnswer = new UserAnswer();
			userAnswer.setQuestion(q);
			userAnswer.setUserSelect("");
			exam.addUserAnswer(userAnswer);
		});
		examManagerOf(ctx).internalSaveExam(ctx, exam, ExamTokens.start().withUserAnswerList().done());
		
		ctx.setExam(exam);
		
	}
	
}





