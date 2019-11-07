
package com.doublechaintech.bcex.answer;
import com.doublechaintech.bcex.EntityNotFoundException;

public class AnswerVersionChangedException extends AnswerManagerException {
	private static final long serialVersionUID = 1L;
	public AnswerVersionChangedException(String string) {
		super(string);
	}


}


