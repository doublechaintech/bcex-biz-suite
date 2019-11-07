
/*
	本类暂时没有很复杂的代码，这个类用于保留以后智能化推断代码
*/

package  com.doublechaintech.bcex.changerequest;


import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.BcexUserContext;

public class RegisterHandler extends ChangeRequestBaseHandler{
	@Override	
	protected void checkIfComplyWithSpec(BcexUserContext userContext, ChangeRequest request){
		super.checkIfComplyWithSpec(userContext,request);
	}
}

