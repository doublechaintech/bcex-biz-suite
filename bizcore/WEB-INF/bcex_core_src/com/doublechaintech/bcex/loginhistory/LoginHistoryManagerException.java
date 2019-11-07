
package com.doublechaintech.bcex.loginhistory;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class LoginHistoryManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryManagerException(String string) {
		super(string);
	}
	public LoginHistoryManagerException(Message message) {
		super(message);
	}
	public LoginHistoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


