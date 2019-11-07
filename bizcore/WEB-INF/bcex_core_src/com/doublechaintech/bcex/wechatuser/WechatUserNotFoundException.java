
package com.doublechaintech.bcex.wechatuser;
import com.doublechaintech.bcex.EntityNotFoundException;
public class WechatUserNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public WechatUserNotFoundException(String string) {
		super(string);
	}

}

