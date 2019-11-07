/*
	ChangeRequestService 用于分发请求，一般来说，ChangeRequest的Type不同，可以使用不同的Handler来处理
	这些不同的Handler又去调用不同的EventHandler来处理.
	如果需要做额外的检查，可以考虑重写process方法
*/
package  com.doublechaintech.bcex.changerequest;
import java.util.Arrays;
import java.util.stream.Collectors;
import com.terapico.uccaf.BaseUserContext;
import com.doublechaintech.bcex.BcexUserContext;
import java.util.concurrent.atomic.AtomicInteger;
import com.doublechaintech.bcex.CustomBcexCheckerManager;

public class ChangeRequestService extends CustomBcexCheckerManager{
	
	
	public ChangeRequestBaseHandler getDefaultHandler() {
		return defaultHandler;
	}


	public void setDefaultHandler(ChangeRequestBaseHandler defaultHandler) {
		this.defaultHandler = defaultHandler;
	}
	private ChangeRequestBaseHandler defaultHandler;
	
	@Override
	public Object checkAccess(BaseUserContext baseUserContext, String methodName, Object[] parameters)
			throws IllegalAccessException {
		String whiteList[]= {"process"};
		if(Arrays.asList(whiteList).contains(methodName)) {
			return this.accessOK();
		}
		return super.checkAccess(baseUserContext, methodName, parameters);
	}
	
	
	public ChangeRequest process(BcexUserContext userContext, ChangeRequest request) throws Exception {
		
		checkerOf(userContext).checkAndFixChangeRequest(request);
		userContext.log("ChangeRequestService\t"+request.toString());
		
		saveChangeRequest(userContext,request);
		ChangeRequestBaseHandler handler = calcHandlerFor(userContext,request);
		handler.handle(userContext,request);
		
		return request;
		
	}
	protected void saveChangeRequest(BcexUserContext userContext,ChangeRequest request) throws Exception{
		this.changeRequestManagerOf(userContext).internalSaveChangeRequest(userContext, request);
	}
	
	protected String calcBeanNameFor(BcexUserContext userContext,String type) {
		AtomicInteger index = new AtomicInteger();
		//String type = request.getRequestType().getId();
		return Arrays.stream(type.toLowerCase().split("_"))
				.map(ele->capFirst(ele,index.getAndIncrement()))
				.collect(Collectors.joining(""))+"Handler";
	}
	
	protected String capFirst(String ele, int index) {
		
		if(index==0) {
			return ele;
		}
		return Character.toUpperCase(ele.charAt(0))+ele.substring(1);
	}
	

	protected ChangeRequestBaseHandler calcHandlerFor(BcexUserContext userContext,ChangeRequest request){
		String type = request.getRequestType().getId();
		if(type == null) {
			userContext.log("request type is null");
			return this.defaultHandler;
		}
		if(type.isEmpty()) {
			userContext.log("request type is empty");
			return this.defaultHandler;
		}
		String beanName=calcBeanNameFor(userContext,type);
		Object hanlderObject = userContext.getBean(calcBeanNameFor(userContext,type));
		if(hanlderObject==null) {
			userContext.log("not able to find bean with name: "+beanName);
			return this.defaultHandler;
		}
		
		if(! (hanlderObject instanceof ChangeRequestBaseHandler)) {
			userContext.log("not a type of ChangeRequestBaseHandler it is a "+hanlderObject.getClass().getSimpleName());
			return this.defaultHandler;
		}
		// super safe to cast to this type of object
		return  (ChangeRequestBaseHandler)hanlderObject;
	}
}

