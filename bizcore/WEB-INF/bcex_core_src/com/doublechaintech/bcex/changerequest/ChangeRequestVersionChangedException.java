
package com.doublechaintech.bcex.changerequest;
import com.doublechaintech.bcex.EntityNotFoundException;

public class ChangeRequestVersionChangedException extends ChangeRequestManagerException {
	private static final long serialVersionUID = 1L;
	public ChangeRequestVersionChangedException(String string) {
		super(string);
	}


}


