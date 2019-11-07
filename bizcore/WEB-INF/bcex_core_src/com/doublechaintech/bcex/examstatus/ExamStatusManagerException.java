
package com.doublechaintech.bcex.examstatus;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ExamStatusManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ExamStatusManagerException(String string) {
		super(string);
	}
	public ExamStatusManagerException(Message message) {
		super(message);
	}
	public ExamStatusManagerException(List<Message> messageList) {
		super(messageList);
	}

}


