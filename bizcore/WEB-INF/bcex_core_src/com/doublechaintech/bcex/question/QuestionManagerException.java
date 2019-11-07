
package com.doublechaintech.bcex.question;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class QuestionManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public QuestionManagerException(String string) {
		super(string);
	}
	public QuestionManagerException(Message message) {
		super(message);
	}
	public QuestionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


