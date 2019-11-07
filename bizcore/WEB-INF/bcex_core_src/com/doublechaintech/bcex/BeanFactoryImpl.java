
package com.doublechaintech.bcex;
import java.util.Map;

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registeration.Registeration;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.userdomain.UserDomain;
import com.doublechaintech.bcex.userwhitelist.UserWhiteList;
import com.doublechaintech.bcex.secuser.SecUser;
import com.doublechaintech.bcex.secuserblocking.SecUserBlocking;
import com.doublechaintech.bcex.userapp.UserApp;
import com.doublechaintech.bcex.quicklink.QuickLink;
import com.doublechaintech.bcex.listaccess.ListAccess;
import com.doublechaintech.bcex.objectaccess.ObjectAccess;
import com.doublechaintech.bcex.loginhistory.LoginHistory;
import com.doublechaintech.bcex.genericform.GenericForm;
import com.doublechaintech.bcex.formmessage.FormMessage;
import com.doublechaintech.bcex.formfieldmessage.FormFieldMessage;
import com.doublechaintech.bcex.formfield.FormField;
import com.doublechaintech.bcex.formaction.FormAction;
import com.doublechaintech.bcex.candidatecontainer.CandidateContainer;
import com.doublechaintech.bcex.candidateelement.CandidateElement;

public class BeanFactoryImpl{


	public Platform createPlatform(Map<String,Object> options){
		return new Platform();
	}


	public ChangeRequestType createChangeRequestType(Map<String,Object> options){
		return new ChangeRequestType();
	}


	public ChangeRequest createChangeRequest(Map<String,Object> options){
		return new ChangeRequest();
	}


	public Registeration createRegisteration(Map<String,Object> options){
		return new Registeration();
	}


	public StartExam createStartExam(Map<String,Object> options){
		return new StartExam();
	}


	public AnswerQuestion createAnswerQuestion(Map<String,Object> options){
		return new AnswerQuestion();
	}


	public ExamStatus createExamStatus(Map<String,Object> options){
		return new ExamStatus();
	}


	public Question createQuestion(Map<String,Object> options){
		return new Question();
	}


	public ExamRanking createExamRanking(Map<String,Object> options){
		return new ExamRanking();
	}


	public Answer createAnswer(Map<String,Object> options){
		return new Answer();
	}


	public WechatUser createWechatUser(Map<String,Object> options){
		return new WechatUser();
	}


	public Exam createExam(Map<String,Object> options){
		return new Exam();
	}


	public UserAnswer createUserAnswer(Map<String,Object> options){
		return new UserAnswer();
	}


	public FaultAnswer createFaultAnswer(Map<String,Object> options){
		return new FaultAnswer();
	}


	public UserDomain createUserDomain(Map<String,Object> options){
		return new UserDomain();
	}


	public UserWhiteList createUserWhiteList(Map<String,Object> options){
		return new UserWhiteList();
	}


	public SecUser createSecUser(Map<String,Object> options){
		return new SecUser();
	}


	public SecUserBlocking createSecUserBlocking(Map<String,Object> options){
		return new SecUserBlocking();
	}


	public UserApp createUserApp(Map<String,Object> options){
		return new UserApp();
	}


	public QuickLink createQuickLink(Map<String,Object> options){
		return new QuickLink();
	}


	public ListAccess createListAccess(Map<String,Object> options){
		return new ListAccess();
	}


	public ObjectAccess createObjectAccess(Map<String,Object> options){
		return new ObjectAccess();
	}


	public LoginHistory createLoginHistory(Map<String,Object> options){
		return new LoginHistory();
	}


	public GenericForm createGenericForm(Map<String,Object> options){
		return new GenericForm();
	}


	public FormMessage createFormMessage(Map<String,Object> options){
		return new FormMessage();
	}


	public FormFieldMessage createFormFieldMessage(Map<String,Object> options){
		return new FormFieldMessage();
	}


	public FormField createFormField(Map<String,Object> options){
		return new FormField();
	}


	public FormAction createFormAction(Map<String,Object> options){
		return new FormAction();
	}


	public CandidateContainer createCandidateContainer(Map<String,Object> options){
		return new CandidateContainer();
	}


	public CandidateElement createCandidateElement(Map<String,Object> options){
		return new CandidateElement();
	}





}







