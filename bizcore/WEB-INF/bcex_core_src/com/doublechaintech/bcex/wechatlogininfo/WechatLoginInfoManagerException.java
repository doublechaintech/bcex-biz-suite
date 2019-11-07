
package com.doublechaintech.bcex.wechatlogininfo;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class WechatLoginInfoManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public WechatLoginInfoManagerException(String string) {
		super(string);
	}
	public WechatLoginInfoManagerException(Message message) {
		super(message);
	}
	public WechatLoginInfoManagerException(List<Message> messageList) {
		super(messageList);
	}

}


