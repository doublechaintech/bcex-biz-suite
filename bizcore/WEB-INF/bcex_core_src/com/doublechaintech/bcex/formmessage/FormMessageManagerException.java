
package com.doublechaintech.bcex.formmessage;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class FormMessageManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public FormMessageManagerException(String string) {
		super(string);
	}
	public FormMessageManagerException(Message message) {
		super(message);
	}
	public FormMessageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


