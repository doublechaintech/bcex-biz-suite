
package com.doublechaintech.bcex.registeration;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class RegisterationManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public RegisterationManagerException(String string) {
		super(string);
	}
	public RegisterationManagerException(Message message) {
		super(message);
	}
	public RegisterationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


