package com.doublechaintech.bcex.wxappservice;

import java.util.List;

import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;

public class WxappServiceException extends BcexException {

	public WxappServiceException() {
		super();
	}

	public WxappServiceException(List<Message> messageList) {
		super(messageList);
	}

	public WxappServiceException(Message message) {
		super(message);
	}

	public WxappServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public WxappServiceException(String message) {
		super(message);
	}

	public WxappServiceException(Throwable cause) {
		super(cause);
	}

}
