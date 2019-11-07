package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.BcexUserContext;

public class AnswerQuestionProcessor extends ChangeRequestChainProcessor{
	
	
	protected void processInternal(BcexUserContext userContext, ChangeRequest request, String beanName){
		request.getAnswerQuestionList().forEach(event->{
			
			handleSingleEvent(userContext,request,event);
		});
	}
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, AnswerQuestion event ){
		
		userContext.log("AnswerQuestionProcessor\t"+ event +" from processor");
		
		/*
		try {
				Account a1 = accountManagerOf(userContext)
						.loadAccount(userContext, event.getAccount().getId(), new String[] {});
				a1.updateName(event.getName());
				accountManagerOf(userContext).internalSaveAccount(userContext, a1);
		} catch (Exception e) {
				
				e.printStackTrace();
		}*/
	}
	
}


