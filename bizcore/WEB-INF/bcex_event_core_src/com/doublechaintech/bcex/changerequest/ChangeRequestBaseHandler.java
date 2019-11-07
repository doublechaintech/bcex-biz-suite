/*
	ChangeRequestBaseHandler 最基础的Handler，如果这些ChangeRequest都按照Event规则来处理，
	那么有这个ChangeRequestBaseHandler对于大多数系统就足够了。
*/
package  com.doublechaintech.bcex.changerequest;
import java.util.Arrays;

import com.doublechaintech.bcex.BcexUserContext;
import com.doublechaintech.bcex.CustomBcexCheckerManager;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
public class ChangeRequestBaseHandler extends CustomBcexCheckerManager{
	
	private static final String SUB_EVENT_NAMES[]={"registerationProcessor","startExamProcessor","answerQuestionProcessor"};
	
	public ChangeRequest handle(BcexUserContext userContext, ChangeRequest request) throws Exception {
		
		checkerOf(userContext).checkAndFixChangeRequest(request);
		checkIfComplyWithSpec(userContext,request);
		userContext.log("ChangeRequestBaseHandler\t"+request.toString());
		Arrays.stream(SUB_EVENT_NAMES).forEach(beanName->handleByChainNode(userContext,request,beanName));
		return request;
		
	}
	protected void checkIfComplyWithSpec(BcexUserContext userContext, ChangeRequest request){
		//empty code to let sub class implementation
	}
	protected void handleByChainNode(BcexUserContext userContext, ChangeRequest request, String beanName){
		ChangeRequestChainProcessor processor =(ChangeRequestChainProcessor) userContext.getBean(beanName);
		processor.process(userContext,request,beanName);
	}
	
}




