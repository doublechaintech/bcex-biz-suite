
package com.doublechaintech.bcex.startexam;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class StartExamManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public StartExamManagerException(String string) {
		super(string);
	}
	public StartExamManagerException(Message message) {
		super(message);
	}
	public StartExamManagerException(List<Message> messageList) {
		super(messageList);
	}

}


