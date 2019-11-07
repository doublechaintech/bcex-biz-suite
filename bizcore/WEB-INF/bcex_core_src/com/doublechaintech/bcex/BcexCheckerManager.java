package com.doublechaintech.bcex;
import com.terapico.caf.DateTime;
import com.terapico.uccaf.BaseUserContext;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class BcexCheckerManager extends BaseManagerImpl {
	protected BcexObjectChecker checkerOf(BcexUserContext ctx) {
		return ctx.getChecker();
	}
	private static class AsyncManagerJob extends Thread {
		protected Object me;
		protected Object proxy;
		protected Method method;
		protected Object[] args;
		protected MethodProxy methodProxy;

		public AsyncManagerJob(Object me, Object proxy, Method method, Object[] args, MethodProxy methodProxy) {
			super();
			this.me = me;
			this.proxy = proxy;
			this.method = method;
			this.args = args;
			this.methodProxy = methodProxy;
		}

		@Override
		public void run() {
			try {
				method.setAccessible(true);
				method.invoke(me, args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
	
	public static final Map<String, Object> EO = new HashMap<>();
	protected Object asyncProxy = null;
	protected Object getAsyncProxy() {
		if (asyncProxy != null) {
			return asyncProxy;
		}
		
		Object me = this;
		MethodInterceptor proxy = new MethodInterceptor() {

			@Override
			public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {
				new AsyncManagerJob(me, proxyObj, method, args, methodProxy).start();
				return null;
			}
		};
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(me.getClass());
		enhancer.setCallback(proxy);
		return asyncProxy = enhancer.create();
	}
	
	protected void cacheVerifyCode(BcexUserContext ctx, String mobile, String verifyCode) {
		String cacheKey = "verifyCode:"+mobile;
		ctx.putToCache(cacheKey, verifyCode, BcexBaseConstants.DEFAULT_CACHE_TIME_FOR_VCODE);
	}

	protected String getVerifyCodeFromCache(BcexUserContext ctx, String mobile) {
		String cacheKey = "verifyCode:"+mobile;
		return (String) ctx.getCachedObject(cacheKey, String.class);
	}
	protected void checkVerifyCode(BcexUserContext ctx, String inputVerifyCode, String mobile) throws Exception {
		String cachedVerifyCode = getVerifyCodeFromCache(ctx, mobile);
		if (cachedVerifyCode == null) {
			throw new Exception("请先获取验证码");
		}
		if (!cachedVerifyCode.equals(inputVerifyCode)) {
			throw new Exception("验证码不正确");
		}
	}
	
	public com.doublechaintech.bcex.platform.PlatformManager platformManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getPlatformManager();
	}
	public com.doublechaintech.bcex.platform.PlatformDAO platformDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getPlatformDAO();
	}
	public com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeManager changeRequestTypeManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getChangeRequestTypeManager();
	}
	public com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeDAO changeRequestTypeDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getChangeRequestTypeDAO();
	}
	public com.doublechaintech.bcex.changerequest.ChangeRequestManager changeRequestManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getChangeRequestManager();
	}
	public com.doublechaintech.bcex.changerequest.ChangeRequestDAO changeRequestDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getChangeRequestDAO();
	}
	public com.doublechaintech.bcex.registeration.RegisterationManager registerationManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getRegisterationManager();
	}
	public com.doublechaintech.bcex.registeration.RegisterationDAO registerationDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getRegisterationDAO();
	}
	public com.doublechaintech.bcex.startexam.StartExamManager startExamManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getStartExamManager();
	}
	public com.doublechaintech.bcex.startexam.StartExamDAO startExamDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getStartExamDAO();
	}
	public com.doublechaintech.bcex.answerquestion.AnswerQuestionManager answerQuestionManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getAnswerQuestionManager();
	}
	public com.doublechaintech.bcex.answerquestion.AnswerQuestionDAO answerQuestionDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getAnswerQuestionDAO();
	}
	public com.doublechaintech.bcex.examstatus.ExamStatusManager examStatusManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getExamStatusManager();
	}
	public com.doublechaintech.bcex.examstatus.ExamStatusDAO examStatusDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getExamStatusDAO();
	}
	public com.doublechaintech.bcex.question.QuestionManager questionManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getQuestionManager();
	}
	public com.doublechaintech.bcex.question.QuestionDAO questionDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getQuestionDAO();
	}
	public com.doublechaintech.bcex.examranking.ExamRankingManager examRankingManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getExamRankingManager();
	}
	public com.doublechaintech.bcex.examranking.ExamRankingDAO examRankingDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getExamRankingDAO();
	}
	public com.doublechaintech.bcex.answer.AnswerManager answerManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getAnswerManager();
	}
	public com.doublechaintech.bcex.answer.AnswerDAO answerDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getAnswerDAO();
	}
	public com.doublechaintech.bcex.wechatuser.WechatUserManager wechatUserManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getWechatUserManager();
	}
	public com.doublechaintech.bcex.wechatuser.WechatUserDAO wechatUserDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getWechatUserDAO();
	}
	public com.doublechaintech.bcex.exam.ExamManager examManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getExamManager();
	}
	public com.doublechaintech.bcex.exam.ExamDAO examDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getExamDAO();
	}
	public com.doublechaintech.bcex.useranswer.UserAnswerManager userAnswerManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getUserAnswerManager();
	}
	public com.doublechaintech.bcex.useranswer.UserAnswerDAO userAnswerDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getUserAnswerDAO();
	}
	public com.doublechaintech.bcex.faultanswer.FaultAnswerManager faultAnswerManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getFaultAnswerManager();
	}
	public com.doublechaintech.bcex.faultanswer.FaultAnswerDAO faultAnswerDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getFaultAnswerDAO();
	}
	public com.doublechaintech.bcex.userdomain.UserDomainManager userDomainManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getUserDomainManager();
	}
	public com.doublechaintech.bcex.userdomain.UserDomainDAO userDomainDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getUserDomainDAO();
	}
	public com.doublechaintech.bcex.userwhitelist.UserWhiteListManager userWhiteListManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getUserWhiteListManager();
	}
	public com.doublechaintech.bcex.userwhitelist.UserWhiteListDAO userWhiteListDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getUserWhiteListDAO();
	}
	public com.doublechaintech.bcex.secuser.SecUserManager secUserManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getSecUserManager();
	}
	public com.doublechaintech.bcex.secuser.SecUserDAO secUserDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getSecUserDAO();
	}
	public com.doublechaintech.bcex.secuserblocking.SecUserBlockingManager secUserBlockingManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getSecUserBlockingManager();
	}
	public com.doublechaintech.bcex.secuserblocking.SecUserBlockingDAO secUserBlockingDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getSecUserBlockingDAO();
	}
	public com.doublechaintech.bcex.userapp.UserAppManager userAppManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getUserAppManager();
	}
	public com.doublechaintech.bcex.userapp.UserAppDAO userAppDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getUserAppDAO();
	}
	public com.doublechaintech.bcex.quicklink.QuickLinkManager quickLinkManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getQuickLinkManager();
	}
	public com.doublechaintech.bcex.quicklink.QuickLinkDAO quickLinkDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getQuickLinkDAO();
	}
	public com.doublechaintech.bcex.listaccess.ListAccessManager listAccessManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getListAccessManager();
	}
	public com.doublechaintech.bcex.listaccess.ListAccessDAO listAccessDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getListAccessDAO();
	}
	public com.doublechaintech.bcex.objectaccess.ObjectAccessManager objectAccessManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getObjectAccessManager();
	}
	public com.doublechaintech.bcex.objectaccess.ObjectAccessDAO objectAccessDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getObjectAccessDAO();
	}
	public com.doublechaintech.bcex.loginhistory.LoginHistoryManager loginHistoryManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getLoginHistoryManager();
	}
	public com.doublechaintech.bcex.loginhistory.LoginHistoryDAO loginHistoryDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getLoginHistoryDAO();
	}
	public com.doublechaintech.bcex.genericform.GenericFormManager genericFormManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getGenericFormManager();
	}
	public com.doublechaintech.bcex.genericform.GenericFormDAO genericFormDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getGenericFormDAO();
	}
	public com.doublechaintech.bcex.formmessage.FormMessageManager formMessageManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getFormMessageManager();
	}
	public com.doublechaintech.bcex.formmessage.FormMessageDAO formMessageDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getFormMessageDAO();
	}
	public com.doublechaintech.bcex.formfieldmessage.FormFieldMessageManager formFieldMessageManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getFormFieldMessageManager();
	}
	public com.doublechaintech.bcex.formfieldmessage.FormFieldMessageDAO formFieldMessageDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getFormFieldMessageDAO();
	}
	public com.doublechaintech.bcex.formfield.FormFieldManager formFieldManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getFormFieldManager();
	}
	public com.doublechaintech.bcex.formfield.FormFieldDAO formFieldDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getFormFieldDAO();
	}
	public com.doublechaintech.bcex.formaction.FormActionManager formActionManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getFormActionManager();
	}
	public com.doublechaintech.bcex.formaction.FormActionDAO formActionDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getFormActionDAO();
	}
	public com.doublechaintech.bcex.candidatecontainer.CandidateContainerManager candidateContainerManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getCandidateContainerManager();
	}
	public com.doublechaintech.bcex.candidatecontainer.CandidateContainerDAO candidateContainerDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getCandidateContainerDAO();
	}
	public com.doublechaintech.bcex.candidateelement.CandidateElementManager candidateElementManagerOf(BcexUserContext userContext){
		return userContext.getManagerGroup().getCandidateElementManager();
	}
	public com.doublechaintech.bcex.candidateelement.CandidateElementDAO candidateElementDaoOf(BcexUserContext userContext){
		return userContext.getDAOGroup().getCandidateElementDAO();
	}
	
	
	
	

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, BcexException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}








