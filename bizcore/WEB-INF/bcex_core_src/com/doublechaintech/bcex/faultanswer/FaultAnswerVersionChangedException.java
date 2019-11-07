
package com.doublechaintech.bcex.faultanswer;
import com.doublechaintech.bcex.EntityNotFoundException;

public class FaultAnswerVersionChangedException extends FaultAnswerManagerException {
	private static final long serialVersionUID = 1L;
	public FaultAnswerVersionChangedException(String string) {
		super(string);
	}


}


