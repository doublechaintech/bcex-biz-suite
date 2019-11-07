
package com.doublechaintech.bcex.formfield;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class FormFieldManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public FormFieldManagerException(String string) {
		super(string);
	}
	public FormFieldManagerException(Message message) {
		super(message);
	}
	public FormFieldManagerException(List<Message> messageList) {
		super(messageList);
	}

}


