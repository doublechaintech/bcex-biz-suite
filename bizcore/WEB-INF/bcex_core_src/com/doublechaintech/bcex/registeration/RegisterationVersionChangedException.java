
package com.doublechaintech.bcex.registeration;
import com.doublechaintech.bcex.EntityNotFoundException;

public class RegisterationVersionChangedException extends RegisterationManagerException {
	private static final long serialVersionUID = 1L;
	public RegisterationVersionChangedException(String string) {
		super(string);
	}


}


