package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registration.Registration;
import com.doublechaintech.bcex.BcexUserContext;

public class RegistrationCustomProcessor extends RegistrationProcessor{
	
	
	
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, Registration event ){
		
		userContext.log("RegistrationCustomProcessor\t"+ event +" from processor");
		
		
	}
	
}





