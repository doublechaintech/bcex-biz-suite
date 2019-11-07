
package com.doublechaintech.bcex.wechatuser;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class WechatUserManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public WechatUserManagerException(String string) {
		super(string);
	}
	public WechatUserManagerException(Message message) {
		super(message);
	}
	public WechatUserManagerException(List<Message> messageList) {
		super(messageList);
	}

}


