package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registeration.Registeration;
import com.doublechaintech.bcex.BcexUserContext;

public class RegisterationCustomProcessor extends RegisterationProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, Registeration event ){
		
		userContext.log("RegisterationCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}





