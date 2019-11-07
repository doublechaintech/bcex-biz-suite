
package com.doublechaintech.bcex.exam;
import com.doublechaintech.bcex.EntityNotFoundException;

public class ExamVersionChangedException extends ExamManagerException {
	private static final long serialVersionUID = 1L;
	public ExamVersionChangedException(String string) {
		super(string);
	}


}


