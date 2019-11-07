
package com.doublechaintech.bcex.changerequest;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ChangeRequestManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestManagerException(String string) {
		super(string);
	}
	public ChangeRequestManagerException(Message message) {
		super(message);
	}
	public ChangeRequestManagerException(List<Message> messageList) {
		super(messageList);
	}

}


