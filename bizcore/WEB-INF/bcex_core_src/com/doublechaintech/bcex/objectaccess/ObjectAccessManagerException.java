
package com.doublechaintech.bcex.objectaccess;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ObjectAccessManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ObjectAccessManagerException(String string) {
		super(string);
	}
	public ObjectAccessManagerException(Message message) {
		super(message);
	}
	public ObjectAccessManagerException(List<Message> messageList) {
		super(messageList);
	}

}


