
package com.doublechaintech.bcex.question;
import com.doublechaintech.bcex.EntityNotFoundException;

public class QuestionVersionChangedException extends QuestionManagerException {
	private static final long serialVersionUID = 1L;
	public QuestionVersionChangedException(String string) {
		super(string);
	}


}


