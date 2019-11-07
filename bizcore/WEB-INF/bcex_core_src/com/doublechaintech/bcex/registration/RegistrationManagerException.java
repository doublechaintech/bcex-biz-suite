
package com.doublechaintech.bcex.registration;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class RegistrationManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public RegistrationManagerException(String string) {
		super(string);
	}
	public RegistrationManagerException(Message message) {
		super(message);
	}
	public RegistrationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


