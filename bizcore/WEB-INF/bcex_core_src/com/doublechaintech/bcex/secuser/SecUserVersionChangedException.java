
package com.doublechaintech.bcex.secuser;
import com.doublechaintech.bcex.EntityNotFoundException;

public class SecUserVersionChangedException extends SecUserManagerException {
	private static final long serialVersionUID = 1L;
	public SecUserVersionChangedException(String string) {
		super(string);
	}


}


