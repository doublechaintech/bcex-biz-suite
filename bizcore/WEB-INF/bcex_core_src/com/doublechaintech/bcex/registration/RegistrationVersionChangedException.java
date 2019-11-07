
package com.doublechaintech.bcex.registration;
import com.doublechaintech.bcex.EntityNotFoundException;

public class RegistrationVersionChangedException extends RegistrationManagerException {
	private static final long serialVersionUID = 1L;
	public RegistrationVersionChangedException(String string) {
		super(string);
	}


}


