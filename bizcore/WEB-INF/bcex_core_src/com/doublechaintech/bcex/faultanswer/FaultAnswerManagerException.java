
package com.doublechaintech.bcex.faultanswer;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class FaultAnswerManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public FaultAnswerManagerException(String string) {
		super(string);
	}
	public FaultAnswerManagerException(Message message) {
		super(message);
	}
	public FaultAnswerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


