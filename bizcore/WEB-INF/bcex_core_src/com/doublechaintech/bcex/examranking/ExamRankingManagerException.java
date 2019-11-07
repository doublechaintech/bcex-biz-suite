
package com.doublechaintech.bcex.examranking;
//import com.doublechaintech.bcex.EntityNotFoundException;
import com.doublechaintech.bcex.BcexException;
import com.doublechaintech.bcex.Message;
import java.util.List;

public class ExamRankingManagerException extends BcexException {
	private static final long serialVersionUID = 1L;
	public ExamRankingManagerException(String string) {
		super(string);
	}
	public ExamRankingManagerException(Message message) {
		super(message);
	}
	public ExamRankingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


