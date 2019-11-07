
package com.doublechaintech.bcex.secuser;
import com.doublechaintech.bcex.EntityNotFoundException;
public class SecUserNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public SecUserNotFoundException(String string) {
		super(string);
	}

}

