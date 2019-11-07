package  com.doublechaintech.bcex.changerequest;

import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registeration.Registeration;
import com.doublechaintech.bcex.BcexUserContext;

public class RegisterationProcessor extends ChangeRequestChainProcessor{
	
	
	protected void processInternal(BcexUserContext userContext, ChangeRequest request, String beanName){
		request.getRegisterationList().forEach(event->{
			
			handleSingleEvent(userContext,request,event);
		});
	}
	protected void handleSingleEvent(BcexUserContext userContext, ChangeRequest request, Registeration event ){
		
		userContext.log("RegisterationProcessor\t"+ event +" from processor");
		
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


