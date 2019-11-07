package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registration.Registration;
import com.doublechaintech.bcex.BcexUserContext;

public class RegistrationProcessor extends ChangeRequestChainProcessor{
	
	
	protected void processInternal(BcexUserContext userContext, ChangeRequest request, String beanName){
		request.getRegistrationList().forEach(event->{
			
			handleSingleEvent(userContext,request,event);
		});
	}
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, Registration event ){
		
		userContext.log("RegistrationProcessor\t"+ event +" from processor");
		
		/*
		try {
				Account a1 = accountManagerOf(userContext)
						.loadAccount(userContext, event.getAccount().getId(), new String[] {});
				a1.updateName(event.getName());
				accountManagerOf(userContext).internalSaveAccount(userContext, a1);
		} catch (Exception e) {
				
				e.printStackTrace();
		}*/
	}
	
}


