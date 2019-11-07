
package com.doublechaintech.bcex.useranswer;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class UserAnswerManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public UserAnswerManagerException(String string) {
		super(string);
	}
	public UserAnswerManagerException(Message message) {
		super(message);
	}
	public UserAnswerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


