package  com.doublechaintech.bcex.changerequest;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexUserContextImpl;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.exam.ExamTokens;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswerTokens;
import com.doublechaintech.bcex.utils.MiscUtils;

public class AnswerQuestionCustomProcessor extends AnswerQuestionProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, AnswerQuestion event ){
		
		userContext.log("AnswerQuestionCustomProcessor\t"+ event +" from processor");
		if (event == null) {
			return;
		}
		
		try {
			handleAnswerQuestionEvent((CustomBcexUserContextImpl)userContext, request, event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void handleAnswerQuestionEvent(CustomBcexUserContextImpl ctx, ChangeRequest request,
			AnswerQuestion event) throws Exception {
		UserAnswer userAnswer = userAnswerDaoOf(ctx).load(event.getUserAnswer().getId(), UserAnswerTokens.withoutLists());
		String userAnswerStr = event.getAnswer();
		Question question = questionDaoOf(ctx).load(userAnswer.getQuestion().getId(), EO);
		// boolean correct = userAnswerStr.equalsIgnoreCase(question.getRightAnswer());
		
		// 保存答题结果
		userAnswer.updateTopic(getSelectionText(question, userAnswerStr.toLowerCase()))
			.updateUserSelect(userAnswerStr);
		Exam exam = examDaoOf(ctx).load(userAnswer.getExam().getId(), EO);
		ctx.setExam(exam);
		int score = MiscUtils.calcExamScore(ctx, exam.getId());
		exam.updateScore(score); // 先加1
		examManagerOf(ctx).internalSaveExam(ctx, exam, ExamTokens.start().withUserAnswerList().done());
	}

	private String getSelectionText(Question question, String lowerCase) {
		switch (lowerCase) {
		case "a":
			return question.getOptionA();
		case "b":
			return question.getOptionB();
		case "c":
			return question.getOptionC();
		case "d":
			return question.getOptionD();
		default:
			return question.getOptionE();
		}
	}
	
}











