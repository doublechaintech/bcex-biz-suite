package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.BcexUserContext;

public class StartExamCustomProcessor extends StartExamProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, StartExam event ){
		
		userContext.log("StartExamCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}





