package com.doublechaintech.bcex.wxappservice;

import java.util.List;

import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;

public class WxappServiceException extends BcexException {

	public WxappServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WxappServiceException(List<Message> messageList) {
		super(messageList);
		// TODO Auto-generated constructor stub
	}

	public WxappServiceException(Message message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WxappServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WxappServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WxappServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
