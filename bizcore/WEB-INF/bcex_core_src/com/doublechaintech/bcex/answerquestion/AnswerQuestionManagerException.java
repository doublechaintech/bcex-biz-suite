
package com.doublechaintech.bcex.answerquestion;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class AnswerQuestionManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public AnswerQuestionManagerException(String string) {
		super(string);
	}
	public AnswerQuestionManagerException(Message message) {
		super(message);
	}
	public AnswerQuestionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


