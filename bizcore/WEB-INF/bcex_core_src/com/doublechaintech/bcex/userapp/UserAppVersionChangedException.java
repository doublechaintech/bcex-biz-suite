
package com.doublechaintech.bcex.userapp;
import com.doublechaintech.bcex.EntityNotFoundException;

public class UserAppVersionChangedException extends UserAppManagerException {
	private static final long serialVersionUID = 1L;
	public UserAppVersionChangedException(String string) {
		super(string);
	}


}


