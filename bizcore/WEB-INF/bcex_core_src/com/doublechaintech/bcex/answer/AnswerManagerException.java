
package com.doublechaintech.bcex.answer;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class AnswerManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public AnswerManagerException(String string) {
		super(string);
	}
	public AnswerManagerException(Message message) {
		super(message);
	}
	public AnswerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


