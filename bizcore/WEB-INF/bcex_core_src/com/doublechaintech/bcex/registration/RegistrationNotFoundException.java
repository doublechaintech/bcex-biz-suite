
package com.doublechaintech.bcex.registration;
import com.doublechaintech.bcex.EntityNotFoundException;
public class RegistrationNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public RegistrationNotFoundException(String string) {
		super(string);
	}

}

