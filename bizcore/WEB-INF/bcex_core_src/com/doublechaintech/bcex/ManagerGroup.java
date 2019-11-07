package com.doublechaintech.bcex;


import com.doublechaintech.bcex.platform.PlatformManager;

import com.doublechaintech.bcex.changerequesttype.ChangeRequestTypeManager;

import com.doublechaintech.bcex.changerequest.ChangeRequestManager;

import com.doublechaintech.bcex.registration.RegistrationManager;

import com.doublechaintech.bcex.startexam.StartExamManager;

import com.doublechaintech.bcex.answerquestion.AnswerQuestionManager;

import com.doublechaintech.bcex.examstatus.ExamStatusManager;

import com.doublechaintech.bcex.question.QuestionManager;

import com.doublechaintech.bcex.examranking.ExamRankingManager;

import com.doublechaintech.bcex.answer.AnswerManager;

import com.doublechaintech.bcex.wechatuser.WechatUserManager;

import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfoManager;

import com.doublechaintech.bcex.exam.ExamManager;

import com.doublechaintech.bcex.useranswer.UserAnswerManager;

import com.doublechaintech.bcex.faultanswer.FaultAnswerManager;

import com.doublechaintech.bcex.userdomain.UserDomainManager;

import com.doublechaintech.bcex.userwhitelist.UserWhiteListManager;

import com.doublechaintech.bcex.secuser.SecUserManager;

import com.doublechaintech.bcex.secuserblocking.SecUserBlockingManager;

import com.doublechaintech.bcex.userapp.UserAppManager;

import com.doublechaintech.bcex.quicklink.QuickLinkManager;

import com.doublechaintech.bcex.listaccess.ListAccessManager;

import com.doublechaintech.bcex.objectaccess.ObjectAccessManager;

import com.doublechaintech.bcex.loginhistory.LoginHistoryManager;

import com.doublechaintech.bcex.genericform.GenericFormManager;

import com.doublechaintech.bcex.formmessage.FormMessageManager;

import com.doublechaintech.bcex.formfieldmessage.FormFieldMessageManager;

import com.doublechaintech.bcex.formfield.FormFieldManager;

import com.doublechaintech.bcex.formaction.FormActionManager;

import com.doublechaintech.bcex.candidatecontainer.CandidateContainerManager;

import com.doublechaintech.bcex.candidateelement.CandidateElementManager;


public class ManagerGroup {

	protected PlatformManager platformManager;

	protected ChangeRequestTypeManager changeRequestTypeManager;

	protected ChangeRequestManager changeRequestManager;

	protected RegistrationManager registrationManager;

	protected StartExamManager startExamManager;

	protected AnswerQuestionManager answerQuestionManager;

	protected ExamStatusManager examStatusManager;

	protected QuestionManager questionManager;

	protected ExamRankingManager examRankingManager;

	protected AnswerManager answerManager;

	protected WechatUserManager wechatUserManager;

	protected WechatLoginInfoManager wechatLoginInfoManager;

	protected ExamManager examManager;

	protected UserAnswerManager userAnswerManager;

	protected FaultAnswerManager faultAnswerManager;

	protected UserDomainManager userDomainManager;

	protected UserWhiteListManager userWhiteListManager;

	protected SecUserManager secUserManager;

	protected SecUserBlockingManager secUserBlockingManager;

	protected UserAppManager userAppManager;

	protected QuickLinkManager quickLinkManager;

	protected ListAccessManager listAccessManager;

	protected ObjectAccessManager objectAccessManager;

	protected LoginHistoryManager loginHistoryManager;

	protected GenericFormManager genericFormManager;

	protected FormMessageManager formMessageManager;

	protected FormFieldMessageManager formFieldMessageManager;

	protected FormFieldManager formFieldManager;

	protected FormActionManager formActionManager;

	protected CandidateContainerManager candidateContainerManager;

	protected CandidateElementManager candidateElementManager;

	

	public PlatformManager getPlatformManager(){
		return this.platformManager;
	}
	public void setPlatformManager(PlatformManager manager){
		this.platformManager = manager;
	}


	public ChangeRequestTypeManager getChangeRequestTypeManager(){
		return this.changeRequestTypeManager;
	}
	public void setChangeRequestTypeManager(ChangeRequestTypeManager manager){
		this.changeRequestTypeManager = manager;
	}


	public ChangeRequestManager getChangeRequestManager(){
		return this.changeRequestManager;
	}
	public void setChangeRequestManager(ChangeRequestManager manager){
		this.changeRequestManager = manager;
	}


	public RegistrationManager getRegistrationManager(){
		return this.registrationManager;
	}
	public void setRegistrationManager(RegistrationManager manager){
		this.registrationManager = manager;
	}


	public StartExamManager getStartExamManager(){
		return this.startExamManager;
	}
	public void setStartExamManager(StartExamManager manager){
		this.startExamManager = manager;
	}


	public AnswerQuestionManager getAnswerQuestionManager(){
		return this.answerQuestionManager;
	}
	public void setAnswerQuestionManager(AnswerQuestionManager manager){
		this.answerQuestionManager = manager;
	}


	public ExamStatusManager getExamStatusManager(){
		return this.examStatusManager;
	}
	public void setExamStatusManager(ExamStatusManager manager){
		this.examStatusManager = manager;
	}


	public QuestionManager getQuestionManager(){
		return this.questionManager;
	}
	public void setQuestionManager(QuestionManager manager){
		this.questionManager = manager;
	}


	public ExamRankingManager getExamRankingManager(){
		return this.examRankingManager;
	}
	public void setExamRankingManager(ExamRankingManager manager){
		this.examRankingManager = manager;
	}


	public AnswerManager getAnswerManager(){
		return this.answerManager;
	}
	public void setAnswerManager(AnswerManager manager){
		this.answerManager = manager;
	}


	public WechatUserManager getWechatUserManager(){
		return this.wechatUserManager;
	}
	public void setWechatUserManager(WechatUserManager manager){
		this.wechatUserManager = manager;
	}


	public WechatLoginInfoManager getWechatLoginInfoManager(){
		return this.wechatLoginInfoManager;
	}
	public void setWechatLoginInfoManager(WechatLoginInfoManager manager){
		this.wechatLoginInfoManager = manager;
	}


	public ExamManager getExamManager(){
		return this.examManager;
	}
	public void setExamManager(ExamManager manager){
		this.examManager = manager;
	}


	public UserAnswerManager getUserAnswerManager(){
		return this.userAnswerManager;
	}
	public void setUserAnswerManager(UserAnswerManager manager){
		this.userAnswerManager = manager;
	}


	public FaultAnswerManager getFaultAnswerManager(){
		return this.faultAnswerManager;
	}
	public void setFaultAnswerManager(FaultAnswerManager manager){
		this.faultAnswerManager = manager;
	}


	public UserDomainManager getUserDomainManager(){
		return this.userDomainManager;
	}
	public void setUserDomainManager(UserDomainManager manager){
		this.userDomainManager = manager;
	}


	public UserWhiteListManager getUserWhiteListManager(){
		return this.userWhiteListManager;
	}
	public void setUserWhiteListManager(UserWhiteListManager manager){
		this.userWhiteListManager = manager;
	}


	public SecUserManager getSecUserManager(){
		return this.secUserManager;
	}
	public void setSecUserManager(SecUserManager manager){
		this.secUserManager = manager;
	}


	public SecUserBlockingManager getSecUserBlockingManager(){
		return this.secUserBlockingManager;
	}
	public void setSecUserBlockingManager(SecUserBlockingManager manager){
		this.secUserBlockingManager = manager;
	}


	public UserAppManager getUserAppManager(){
		return this.userAppManager;
	}
	public void setUserAppManager(UserAppManager manager){
		this.userAppManager = manager;
	}


	public QuickLinkManager getQuickLinkManager(){
		return this.quickLinkManager;
	}
	public void setQuickLinkManager(QuickLinkManager manager){
		this.quickLinkManager = manager;
	}


	public ListAccessManager getListAccessManager(){
		return this.listAccessManager;
	}
	public void setListAccessManager(ListAccessManager manager){
		this.listAccessManager = manager;
	}


	public ObjectAccessManager getObjectAccessManager(){
		return this.objectAccessManager;
	}
	public void setObjectAccessManager(ObjectAccessManager manager){
		this.objectAccessManager = manager;
	}


	public LoginHistoryManager getLoginHistoryManager(){
		return this.loginHistoryManager;
	}
	public void setLoginHistoryManager(LoginHistoryManager manager){
		this.loginHistoryManager = manager;
	}


	public GenericFormManager getGenericFormManager(){
		return this.genericFormManager;
	}
	public void setGenericFormManager(GenericFormManager manager){
		this.genericFormManager = manager;
	}


	public FormMessageManager getFormMessageManager(){
		return this.formMessageManager;
	}
	public void setFormMessageManager(FormMessageManager manager){
		this.formMessageManager = manager;
	}


	public FormFieldMessageManager getFormFieldMessageManager(){
		return this.formFieldMessageManager;
	}
	public void setFormFieldMessageManager(FormFieldMessageManager manager){
		this.formFieldMessageManager = manager;
	}


	public FormFieldManager getFormFieldManager(){
		return this.formFieldManager;
	}
	public void setFormFieldManager(FormFieldManager manager){
		this.formFieldManager = manager;
	}


	public FormActionManager getFormActionManager(){
		return this.formActionManager;
	}
	public void setFormActionManager(FormActionManager manager){
		this.formActionManager = manager;
	}


	public CandidateContainerManager getCandidateContainerManager(){
		return this.candidateContainerManager;
	}
	public void setCandidateContainerManager(CandidateContainerManager manager){
		this.candidateContainerManager = manager;
	}


	public CandidateElementManager getCandidateElementManager(){
		return this.candidateElementManager;
	}
	public void setCandidateElementManager(CandidateElementManager manager){
		this.candidateElementManager = manager;
	}


}






