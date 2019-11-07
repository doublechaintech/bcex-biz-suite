
package com.doublechaintech.bcex.changerequest;
import com.doublechaintech.bcex.EntityNotFoundException;
public class ChangeRequestNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestNotFoundException(String string) {
		super(string);
	}

}

