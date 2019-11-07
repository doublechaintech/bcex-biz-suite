
package com.doublechaintech.bcex.examstatus;
import com.doublechaintech.bcex.EntityNotFoundException;

public class ExamStatusVersionChangedException extends ExamStatusManagerException {
	private static final long serialVersionUID = 1L;
	public ExamStatusVersionChangedException(String string) {
		super(string);
	}


}


