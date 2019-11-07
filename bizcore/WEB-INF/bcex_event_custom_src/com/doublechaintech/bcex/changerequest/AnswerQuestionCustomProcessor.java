package  com.doublechaintech.bcex.changerequest;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;

public class AnswerQuestionCustomProcessor extends AnswerQuestionProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, AnswerQuestion event ){
		
		userContext.log("AnswerQuestionCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}











