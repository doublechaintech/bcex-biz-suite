
package com.doublechaintech.bcex.exam;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ExamManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ExamManagerException(String string) {
		super(string);
	}
	public ExamManagerException(Message message) {
		super(message);
	}
	public ExamManagerException(List<Message> messageList) {
		super(messageList);
	}

}


