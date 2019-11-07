
package com.doublechaintech.bcex.changerequesttype;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ChangeRequestTypeManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestTypeManagerException(String string) {
		super(string);
	}
	public ChangeRequestTypeManagerException(Message message) {
		super(message);
	}
	public ChangeRequestTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


