/*
	ChangeRequestBaseHandler 最基础的Handler，如果这些ChangeRequest都按照Event规则来处理，
	那么有这个ChangeRequestBaseHandler对于大多数系统就足够了。
*/
package  com.doublechaintech.bcex.changerequest;
import java.util.Arrays;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexCheckerManager;
public class ChangeRequestChainProcessor extends CustomBcexCheckerManager{
	
	protected void preProcess(BcexUserContext userContext, ChangeRequest request, String beanName){
		
	}
	public void process(BcexUserContext userContext, ChangeRequest request, String beanName){
		preProcess(userContext, request, beanName);
		processInternal(userContext, request, beanName);
		postProcess(userContext, request, beanName);
	}
	protected void postProcess(BcexUserContext userContext, ChangeRequest request, String beanName){
		
	}
	protected void processInternal(BcexUserContext userContext, ChangeRequest request, String beanName){
		
	}
	
}




