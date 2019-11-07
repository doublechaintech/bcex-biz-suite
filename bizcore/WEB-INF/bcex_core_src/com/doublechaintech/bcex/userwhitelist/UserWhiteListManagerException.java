
package com.doublechaintech.bcex.userwhitelist;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class UserWhiteListManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public UserWhiteListManagerException(String string) {
		super(string);
	}
	public UserWhiteListManagerException(Message message) {
		super(message);
	}
	public UserWhiteListManagerException(List<Message> messageList) {
		super(messageList);
	}

}


