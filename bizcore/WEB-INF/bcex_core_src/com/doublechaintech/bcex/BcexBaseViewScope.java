package com.doublechaintech.bcex;


import com.terapico.caf.viewpage.SerializeScope;

import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.registration.Registration;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfo;
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


public class BcexBaseViewScope {

	protected static SerializeScope PlatformBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.DESCRIPTION_PROPERTY)
		;
	/** 用于Platform的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPlatformSummaryScope() {
		return PlatformBaseSummaryScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		;
	/** 用于ChangeRequestType的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeSummaryScope() {
		return ChangeRequestTypeBaseSummaryScope;
	}

	protected static SerializeScope ChangeRequestBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		;
	/** 用于ChangeRequest的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestSummaryScope() {
		return ChangeRequestBaseSummaryScope;
	}

	protected static SerializeScope RegistrationBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Registration.ID_PROPERTY)
		.field(Registration.NICK_NAME_PROPERTY)
		.field(Registration.AVATAR_PROPERTY)
		;
	/** 用于Registration的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRegistrationSummaryScope() {
		return RegistrationBaseSummaryScope;
	}

	protected static SerializeScope StartExamBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(StartExam.ID_PROPERTY)
		.field(StartExam.NICK_NAME_PROPERTY)
		;
	/** 用于StartExam的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStartExamSummaryScope() {
		return StartExamBaseSummaryScope;
	}

	protected static SerializeScope AnswerQuestionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(AnswerQuestion.ID_PROPERTY)
		.field(AnswerQuestion.NICK_NAME_PROPERTY)
		.field(AnswerQuestion.ANSWER_PROPERTY)
		;
	/** 用于AnswerQuestion的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAnswerQuestionSummaryScope() {
		return AnswerQuestionBaseSummaryScope;
	}

	protected static SerializeScope ExamStatusBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamStatus.ID_PROPERTY)
		.field(ExamStatus.NAME_PROPERTY)
		.field(ExamStatus.CODE_PROPERTY)
		;
	/** 用于ExamStatus的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamStatusSummaryScope() {
		return ExamStatusBaseSummaryScope;
	}

	protected static SerializeScope QuestionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Question.ID_PROPERTY)
		.field(Question.TOPIC_PROPERTY)
		.field(Question.LEVEL_PROPERTY)
		.field(Question.OPTION_A_PROPERTY)
		.field(Question.OPTION_B_PROPERTY)
		.field(Question.OPTION_C_PROPERTY)
		.field(Question.OPTION_D_PROPERTY)
		.field(Question.OPTION_E_PROPERTY)
		.field(Question.RIGHT_ANSWER_PROPERTY)
		;
	/** 用于Question的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuestionSummaryScope() {
		return QuestionBaseSummaryScope;
	}

	protected static SerializeScope ExamRankingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamRanking.ID_PROPERTY)
		.field(ExamRanking.NAME_PROPERTY)
		.field(ExamRanking.AVATAR_PROPERTY)
		;
	/** 用于ExamRanking的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamRankingSummaryScope() {
		return ExamRankingBaseSummaryScope;
	}

	protected static SerializeScope AnswerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Answer.ID_PROPERTY)
		.field(Answer.TITLE_PROPERTY)
		.field(Answer.COMMENT_PROPERTY)
		;
	/** 用于Answer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAnswerSummaryScope() {
		return AnswerBaseSummaryScope;
	}

	protected static SerializeScope WechatUserBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatUser.ID_PROPERTY)
		.field(WechatUser.NAME_PROPERTY)
		.field(WechatUser.AVARTA_PROPERTY)
		.field(WechatUser.CREATE_TIME_PROPERTY)
		;
	/** 用于WechatUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatUserSummaryScope() {
		return WechatUserBaseSummaryScope;
	}

	protected static SerializeScope WechatLoginInfoBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatLoginInfo.ID_PROPERTY)
		.field(WechatLoginInfo.APP_ID_PROPERTY)
		.field(WechatLoginInfo.OPEN_ID_PROPERTY)
		.field(WechatLoginInfo.SESSION_KEY_PROPERTY)
		.field(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WechatLoginInfo的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatLoginInfoSummaryScope() {
		return WechatLoginInfoBaseSummaryScope;
	}

	protected static SerializeScope ExamBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Exam.ID_PROPERTY)
		.field(Exam.NAME_PROPERTY)
		.field(Exam.CREATE_TIME_PROPERTY)
		.field(Exam.SCORE_PROPERTY)
		;
	/** 用于Exam的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamSummaryScope() {
		return ExamBaseSummaryScope;
	}

	protected static SerializeScope UserAnswerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserAnswer.ID_PROPERTY)
		.field(UserAnswer.TOPIC_PROPERTY)
		.field(UserAnswer.USER_SELECT_PROPERTY)
		;
	/** 用于UserAnswer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAnswerSummaryScope() {
		return UserAnswerBaseSummaryScope;
	}

	protected static SerializeScope FaultAnswerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FaultAnswer.ID_PROPERTY)
		.field(FaultAnswer.TOPIC_PROPERTY)
		.field(FaultAnswer.YOUR_ANSWER_PROPERTY)
		.field(FaultAnswer.RIGHT_ANSWER_PROPERTY)
		.field(FaultAnswer.CREATE_TIME_PROPERTY)
		;
	/** 用于FaultAnswer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFaultAnswerSummaryScope() {
		return FaultAnswerBaseSummaryScope;
	}

	protected static SerializeScope UserDomainBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSummaryScope() {
		return UserDomainBaseSummaryScope;
	}

	protected static SerializeScope UserWhiteListBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSummaryScope() {
		return UserWhiteListBaseSummaryScope;
	}

	protected static SerializeScope SecUserBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		;
	/** 用于SecUser的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserSummaryScope() {
		return SecUserBaseSummaryScope;
	}

	protected static SerializeScope SecUserBlockingBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSummaryScope() {
		return SecUserBlockingBaseSummaryScope;
	}

	protected static SerializeScope UserAppBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppSummaryScope() {
		return UserAppBaseSummaryScope;
	}

	protected static SerializeScope QuickLinkBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSummaryScope() {
		return QuickLinkBaseSummaryScope;
	}

	protected static SerializeScope ListAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessSummaryScope() {
		return ListAccessBaseSummaryScope;
	}

	protected static SerializeScope ObjectAccessBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		;
	/** 用于ObjectAccess的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSummaryScope() {
		return ObjectAccessBaseSummaryScope;
	}

	protected static SerializeScope LoginHistoryBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySummaryScope() {
		return LoginHistoryBaseSummaryScope;
	}

	protected static SerializeScope GenericFormBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSummaryScope() {
		return GenericFormBaseSummaryScope;
	}

	protected static SerializeScope FormMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSummaryScope() {
		return FormMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldMessageBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSummaryScope() {
		return FormFieldMessageBaseSummaryScope;
	}

	protected static SerializeScope FormFieldBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSummaryScope() {
		return FormFieldBaseSummaryScope;
	}

	protected static SerializeScope FormActionBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionSummaryScope() {
		return FormActionBaseSummaryScope;
	}

	protected static SerializeScope CandidateContainerBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSummaryScope() {
		return CandidateContainerBaseSummaryScope;
	}

	protected static SerializeScope CandidateElementBaseSummaryScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的子对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSummaryScope() {
		return CandidateElementBaseSummaryScope;
	}

	protected static SerializeScope PlatformBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.DESCRIPTION_PROPERTY)
		;
	/** 用于Platform的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPlatformSecondaryListItemScope() {
		return PlatformBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		;
	/** 用于ChangeRequestType的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeSecondaryListItemScope() {
		return ChangeRequestTypeBaseSecondaryListItemScope;
	}

	protected static SerializeScope ChangeRequestBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		;
	/** 用于ChangeRequest的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestSecondaryListItemScope() {
		return ChangeRequestBaseSecondaryListItemScope;
	}

	protected static SerializeScope RegistrationBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Registration.ID_PROPERTY)
		.field(Registration.NICK_NAME_PROPERTY)
		.field(Registration.AVATAR_PROPERTY)
		;
	/** 用于Registration的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRegistrationSecondaryListItemScope() {
		return RegistrationBaseSecondaryListItemScope;
	}

	protected static SerializeScope StartExamBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(StartExam.ID_PROPERTY)
		.field(StartExam.NICK_NAME_PROPERTY)
		;
	/** 用于StartExam的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStartExamSecondaryListItemScope() {
		return StartExamBaseSecondaryListItemScope;
	}

	protected static SerializeScope AnswerQuestionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(AnswerQuestion.ID_PROPERTY)
		.field(AnswerQuestion.NICK_NAME_PROPERTY)
		.field(AnswerQuestion.ANSWER_PROPERTY)
		;
	/** 用于AnswerQuestion的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAnswerQuestionSecondaryListItemScope() {
		return AnswerQuestionBaseSecondaryListItemScope;
	}

	protected static SerializeScope ExamStatusBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamStatus.ID_PROPERTY)
		.field(ExamStatus.NAME_PROPERTY)
		.field(ExamStatus.CODE_PROPERTY)
		;
	/** 用于ExamStatus的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamStatusSecondaryListItemScope() {
		return ExamStatusBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuestionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Question.ID_PROPERTY)
		.field(Question.TOPIC_PROPERTY)
		.field(Question.LEVEL_PROPERTY)
		.field(Question.OPTION_A_PROPERTY)
		.field(Question.OPTION_B_PROPERTY)
		.field(Question.OPTION_C_PROPERTY)
		.field(Question.OPTION_D_PROPERTY)
		.field(Question.OPTION_E_PROPERTY)
		.field(Question.RIGHT_ANSWER_PROPERTY)
		;
	/** 用于Question的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuestionSecondaryListItemScope() {
		return QuestionBaseSecondaryListItemScope;
	}

	protected static SerializeScope ExamRankingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamRanking.ID_PROPERTY)
		.field(ExamRanking.NAME_PROPERTY)
		.field(ExamRanking.AVATAR_PROPERTY)
		;
	/** 用于ExamRanking的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamRankingSecondaryListItemScope() {
		return ExamRankingBaseSecondaryListItemScope;
	}

	protected static SerializeScope AnswerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Answer.ID_PROPERTY)
		.field(Answer.TITLE_PROPERTY)
		.field(Answer.COMMENT_PROPERTY)
		;
	/** 用于Answer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAnswerSecondaryListItemScope() {
		return AnswerBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatUser.ID_PROPERTY)
		.field(WechatUser.NAME_PROPERTY)
		.field(WechatUser.AVARTA_PROPERTY)
		.field(WechatUser.CREATE_TIME_PROPERTY)
		;
	/** 用于WechatUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatUserSecondaryListItemScope() {
		return WechatUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope WechatLoginInfoBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatLoginInfo.ID_PROPERTY)
		.field(WechatLoginInfo.APP_ID_PROPERTY)
		.field(WechatLoginInfo.OPEN_ID_PROPERTY)
		.field(WechatLoginInfo.SESSION_KEY_PROPERTY)
		.field(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WechatLoginInfo的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatLoginInfoSecondaryListItemScope() {
		return WechatLoginInfoBaseSecondaryListItemScope;
	}

	protected static SerializeScope ExamBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Exam.ID_PROPERTY)
		.field(Exam.NAME_PROPERTY)
		.field(Exam.CREATE_TIME_PROPERTY)
		.field(Exam.SCORE_PROPERTY)
		;
	/** 用于Exam的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamSecondaryListItemScope() {
		return ExamBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAnswerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserAnswer.ID_PROPERTY)
		.field(UserAnswer.TOPIC_PROPERTY)
		.field(UserAnswer.USER_SELECT_PROPERTY)
		;
	/** 用于UserAnswer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAnswerSecondaryListItemScope() {
		return UserAnswerBaseSecondaryListItemScope;
	}

	protected static SerializeScope FaultAnswerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FaultAnswer.ID_PROPERTY)
		.field(FaultAnswer.TOPIC_PROPERTY)
		.field(FaultAnswer.YOUR_ANSWER_PROPERTY)
		.field(FaultAnswer.RIGHT_ANSWER_PROPERTY)
		.field(FaultAnswer.CREATE_TIME_PROPERTY)
		;
	/** 用于FaultAnswer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFaultAnswerSecondaryListItemScope() {
		return FaultAnswerBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserDomainBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		;
	/** 用于UserDomain的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainSecondaryListItemScope() {
		return UserDomainBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		;
	/** 用于UserWhiteList的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListSecondaryListItemScope() {
		return UserWhiteListBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		;
	/** 用于SecUser的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserSecondaryListItemScope() {
		return SecUserBaseSecondaryListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		;
	/** 用于SecUserBlocking的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingSecondaryListItemScope() {
		return SecUserBlockingBaseSecondaryListItemScope;
	}

	protected static SerializeScope UserAppBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		;
	/** 用于UserApp的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppSecondaryListItemScope() {
		return UserAppBaseSecondaryListItemScope;
	}

	protected static SerializeScope QuickLinkBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		;
	/** 用于QuickLink的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkSecondaryListItemScope() {
		return QuickLinkBaseSecondaryListItemScope;
	}

	protected static SerializeScope ListAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		;
	/** 用于ListAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessSecondaryListItemScope() {
		return ListAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		;
	/** 用于ObjectAccess的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessSecondaryListItemScope() {
		return ObjectAccessBaseSecondaryListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		;
	/** 用于LoginHistory的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistorySecondaryListItemScope() {
		return LoginHistoryBaseSecondaryListItemScope;
	}

	protected static SerializeScope GenericFormBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		;
	/** 用于GenericForm的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormSecondaryListItemScope() {
		return GenericFormBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageSecondaryListItemScope() {
		return FormMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageSecondaryListItemScope() {
		return FormFieldMessageBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormFieldBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldSecondaryListItemScope() {
		return FormFieldBaseSecondaryListItemScope;
	}

	protected static SerializeScope FormActionBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		;
	/** 用于FormAction的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionSecondaryListItemScope() {
		return FormActionBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		;
	/** 用于CandidateContainer的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerSecondaryListItemScope() {
		return CandidateContainerBaseSecondaryListItemScope;
	}

	protected static SerializeScope CandidateElementBaseSecondaryListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		;
	/** 用于CandidateElement的父对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementSecondaryListItemScope() {
		return CandidateElementBaseSecondaryListItemScope;
	}

	protected static SerializeScope PlatformBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.DESCRIPTION_PROPERTY)
		.field(Platform.CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeSecondaryListItemScope())
		.field(Platform.CHANGE_REQUEST_LIST, getChangeRequestSecondaryListItemScope())
		.field(Platform.EXAM_STATUS_LIST, getExamStatusSecondaryListItemScope())
		.field(Platform.QUESTION_LIST, getQuestionSecondaryListItemScope())
		.field(Platform.EXAM_RANKING_LIST, getExamRankingSecondaryListItemScope())
		.field(Platform.WECHAT_USER_LIST, getWechatUserSecondaryListItemScope())
		;
	/** 用于Platform对象的列表时需要序列化的属性列表 */
	public static SerializeScope getPlatformListItemScope() {
		return PlatformBaseListItemScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ChangeRequestType.CHANGE_REQUEST_LIST, getChangeRequestSecondaryListItemScope())
		;
	/** 用于ChangeRequestType对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeListItemScope() {
		return ChangeRequestTypeBaseListItemScope;
	}

	protected static SerializeScope ChangeRequestBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		.field(ChangeRequest.REQUEST_TYPE_PROPERTY, getChangeRequestTypeSummaryScope())
		.field(ChangeRequest.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ChangeRequest.REGISTRATION_LIST, getRegistrationSecondaryListItemScope())
		.field(ChangeRequest.START_EXAM_LIST, getStartExamSecondaryListItemScope())
		.field(ChangeRequest.ANSWER_QUESTION_LIST, getAnswerQuestionSecondaryListItemScope())
		;
	/** 用于ChangeRequest对象的列表时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestListItemScope() {
		return ChangeRequestBaseListItemScope;
	}

	protected static SerializeScope RegistrationBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Registration.ID_PROPERTY)
		.field(Registration.NICK_NAME_PROPERTY)
		.field(Registration.AVATAR_PROPERTY)
		.field(Registration.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于Registration对象的列表时需要序列化的属性列表 */
	public static SerializeScope getRegistrationListItemScope() {
		return RegistrationBaseListItemScope;
	}

	protected static SerializeScope StartExamBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(StartExam.ID_PROPERTY)
		.field(StartExam.NICK_NAME_PROPERTY)
		.field(StartExam.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于StartExam对象的列表时需要序列化的属性列表 */
	public static SerializeScope getStartExamListItemScope() {
		return StartExamBaseListItemScope;
	}

	protected static SerializeScope AnswerQuestionBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(AnswerQuestion.ID_PROPERTY)
		.field(AnswerQuestion.NICK_NAME_PROPERTY)
		.field(AnswerQuestion.USER_PROPERTY, getWechatUserSummaryScope())
		.field(AnswerQuestion.QUESTION_PROPERTY, getQuestionSummaryScope())
		.field(AnswerQuestion.ANSWER_PROPERTY)
		.field(AnswerQuestion.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于AnswerQuestion对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAnswerQuestionListItemScope() {
		return AnswerQuestionBaseListItemScope;
	}

	protected static SerializeScope ExamStatusBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamStatus.ID_PROPERTY)
		.field(ExamStatus.NAME_PROPERTY)
		.field(ExamStatus.CODE_PROPERTY)
		.field(ExamStatus.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ExamStatus.EXAM_LIST, getExamSecondaryListItemScope())
		;
	/** 用于ExamStatus对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamStatusListItemScope() {
		return ExamStatusBaseListItemScope;
	}

	protected static SerializeScope QuestionBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Question.ID_PROPERTY)
		.field(Question.TOPIC_PROPERTY)
		.field(Question.LEVEL_PROPERTY)
		.field(Question.OPTION_A_PROPERTY)
		.field(Question.OPTION_B_PROPERTY)
		.field(Question.OPTION_C_PROPERTY)
		.field(Question.OPTION_D_PROPERTY)
		.field(Question.OPTION_E_PROPERTY)
		.field(Question.RIGHT_ANSWER_PROPERTY)
		.field(Question.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(Question.ANSWER_QUESTION_LIST, getAnswerQuestionSecondaryListItemScope())
		.field(Question.ANSWER_LIST, getAnswerSecondaryListItemScope())
		.field(Question.USER_ANSWER_LIST, getUserAnswerSecondaryListItemScope())
		;
	/** 用于Question对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuestionListItemScope() {
		return QuestionBaseListItemScope;
	}

	protected static SerializeScope ExamRankingBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamRanking.ID_PROPERTY)
		.field(ExamRanking.NAME_PROPERTY)
		.field(ExamRanking.AVATAR_PROPERTY)
		.field(ExamRanking.PLATFORM_PROPERTY, getPlatformSummaryScope())
		;
	/** 用于ExamRanking对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamRankingListItemScope() {
		return ExamRankingBaseListItemScope;
	}

	protected static SerializeScope AnswerBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Answer.ID_PROPERTY)
		.field(Answer.TITLE_PROPERTY)
		.field(Answer.COMMENT_PROPERTY)
		.field(Answer.QUESTION_PROPERTY, getQuestionSummaryScope())
		;
	/** 用于Answer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getAnswerListItemScope() {
		return AnswerBaseListItemScope;
	}

	protected static SerializeScope WechatUserBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatUser.ID_PROPERTY)
		.field(WechatUser.NAME_PROPERTY)
		.field(WechatUser.AVARTA_PROPERTY)
		.field(WechatUser.CREATE_TIME_PROPERTY)
		.field(WechatUser.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(WechatUser.ANSWER_QUESTION_LIST, getAnswerQuestionSecondaryListItemScope())
		.field(WechatUser.WECHAT_LOGIN_INFO_LIST, getWechatLoginInfoSecondaryListItemScope())
		.field(WechatUser.EXAM_LIST, getExamSecondaryListItemScope())
		.field(WechatUser.FAULT_ANSWER_LIST, getFaultAnswerSecondaryListItemScope())
		;
	/** 用于WechatUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatUserListItemScope() {
		return WechatUserBaseListItemScope;
	}

	protected static SerializeScope WechatLoginInfoBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatLoginInfo.ID_PROPERTY)
		.field(WechatLoginInfo.WECHAT_USER_PROPERTY, getWechatUserSummaryScope())
		.field(WechatLoginInfo.APP_ID_PROPERTY)
		.field(WechatLoginInfo.OPEN_ID_PROPERTY)
		.field(WechatLoginInfo.SESSION_KEY_PROPERTY)
		.field(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WechatLoginInfo对象的列表时需要序列化的属性列表 */
	public static SerializeScope getWechatLoginInfoListItemScope() {
		return WechatLoginInfoBaseListItemScope;
	}

	protected static SerializeScope ExamBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Exam.ID_PROPERTY)
		.field(Exam.NAME_PROPERTY)
		.field(Exam.CREATE_TIME_PROPERTY)
		.field(Exam.STATUS_PROPERTY, getExamStatusSummaryScope())
		.field(Exam.USER_PROPERTY, getWechatUserSummaryScope())
		.field(Exam.SCORE_PROPERTY)
		.field(Exam.USER_ANSWER_LIST, getUserAnswerSecondaryListItemScope())
		.field(Exam.FAULT_ANSWER_LIST, getFaultAnswerSecondaryListItemScope())
		;
	/** 用于Exam对象的列表时需要序列化的属性列表 */
	public static SerializeScope getExamListItemScope() {
		return ExamBaseListItemScope;
	}

	protected static SerializeScope UserAnswerBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserAnswer.ID_PROPERTY)
		.field(UserAnswer.TOPIC_PROPERTY)
		.field(UserAnswer.USER_SELECT_PROPERTY)
		.field(UserAnswer.QUESTION_PROPERTY, getQuestionSummaryScope())
		.field(UserAnswer.EXAM_PROPERTY, getExamSummaryScope())
		;
	/** 用于UserAnswer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAnswerListItemScope() {
		return UserAnswerBaseListItemScope;
	}

	protected static SerializeScope FaultAnswerBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FaultAnswer.ID_PROPERTY)
		.field(FaultAnswer.TOPIC_PROPERTY)
		.field(FaultAnswer.YOUR_ANSWER_PROPERTY)
		.field(FaultAnswer.RIGHT_ANSWER_PROPERTY)
		.field(FaultAnswer.CREATE_TIME_PROPERTY)
		.field(FaultAnswer.USER_PROPERTY, getWechatUserSummaryScope())
		.field(FaultAnswer.EXAM_PROPERTY, getExamSummaryScope())
		;
	/** 用于FaultAnswer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFaultAnswerListItemScope() {
		return FaultAnswerBaseListItemScope;
	}

	protected static SerializeScope UserDomainBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListSecondaryListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于UserDomain对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserDomainListItemScope() {
		return UserDomainBaseListItemScope;
	}

	protected static SerializeScope UserWhiteListBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListListItemScope() {
		return UserWhiteListBaseListItemScope;
	}

	protected static SerializeScope SecUserBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		.field(SecUser.USER_APP_LIST, getUserAppSecondaryListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistorySecondaryListItemScope())
		;
	/** 用于SecUser对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserListItemScope() {
		return SecUserBaseListItemScope;
	}

	protected static SerializeScope SecUserBlockingBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserSecondaryListItemScope())
		;
	/** 用于SecUserBlocking对象的列表时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingListItemScope() {
		return SecUserBlockingBaseListItemScope;
	}

	protected static SerializeScope UserAppBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkSecondaryListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessSecondaryListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessSecondaryListItemScope())
		;
	/** 用于UserApp对象的列表时需要序列化的属性列表 */
	public static SerializeScope getUserAppListItemScope() {
		return UserAppBaseListItemScope;
	}

	protected static SerializeScope QuickLinkBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的列表时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkListItemScope() {
		return QuickLinkBaseListItemScope;
	}

	protected static SerializeScope ListAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getListAccessListItemScope() {
		return ListAccessBaseListItemScope;
	}

	protected static SerializeScope ObjectAccessBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的列表时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessListItemScope() {
		return ObjectAccessBaseListItemScope;
	}

	protected static SerializeScope LoginHistoryBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的列表时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryListItemScope() {
		return LoginHistoryBaseListItemScope;
	}

	protected static SerializeScope GenericFormBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageSecondaryListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldSecondaryListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionSecondaryListItemScope())
		;
	/** 用于GenericForm对象的列表时需要序列化的属性列表 */
	public static SerializeScope getGenericFormListItemScope() {
		return GenericFormBaseListItemScope;
	}

	protected static SerializeScope FormMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormMessageListItemScope() {
		return FormMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldMessageBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageListItemScope() {
		return FormFieldMessageBaseListItemScope;
	}

	protected static SerializeScope FormFieldBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormFieldListItemScope() {
		return FormFieldBaseListItemScope;
	}

	protected static SerializeScope FormActionBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的列表时需要序列化的属性列表 */
	public static SerializeScope getFormActionListItemScope() {
		return FormActionBaseListItemScope;
	}

	protected static SerializeScope CandidateContainerBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementSecondaryListItemScope())
		;
	/** 用于CandidateContainer对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerListItemScope() {
		return CandidateContainerBaseListItemScope;
	}

	protected static SerializeScope CandidateElementBaseListItemScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的列表时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementListItemScope() {
		return CandidateElementBaseListItemScope;
	}

	protected static SerializeScope PlatformBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Platform.ID_PROPERTY)
		.field(Platform.NAME_PROPERTY)
		.field(Platform.DESCRIPTION_PROPERTY)
		.field(Platform.CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeListItemScope())
		.field(Platform.CHANGE_REQUEST_LIST, getChangeRequestListItemScope())
		.field(Platform.EXAM_STATUS_LIST, getExamStatusListItemScope())
		.field(Platform.QUESTION_LIST, getQuestionListItemScope())
		.field(Platform.EXAM_RANKING_LIST, getExamRankingListItemScope())
		.field(Platform.WECHAT_USER_LIST, getWechatUserListItemScope())
		;
	/** 用于Platform对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getPlatformDetailScope() {
		return PlatformBaseDetailScope;
	}

	protected static SerializeScope ChangeRequestTypeBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequestType.ID_PROPERTY)
		.field(ChangeRequestType.NAME_PROPERTY)
		.field(ChangeRequestType.CODE_PROPERTY)
		.field(ChangeRequestType.ICON_PROPERTY)
		.field(ChangeRequestType.DISPLAY_ORDER_PROPERTY)
		.field(ChangeRequestType.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ChangeRequestType.CHANGE_REQUEST_LIST, getChangeRequestListItemScope())
		;
	/** 用于ChangeRequestType对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestTypeDetailScope() {
		return ChangeRequestTypeBaseDetailScope;
	}

	protected static SerializeScope ChangeRequestBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ChangeRequest.ID_PROPERTY)
		.field(ChangeRequest.NAME_PROPERTY)
		.field(ChangeRequest.CREATE_TIME_PROPERTY)
		.field(ChangeRequest.REMOTE_IP_PROPERTY)
		.field(ChangeRequest.REQUEST_TYPE_PROPERTY, getChangeRequestTypeSummaryScope())
		.field(ChangeRequest.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ChangeRequest.REGISTRATION_LIST, getRegistrationListItemScope())
		.field(ChangeRequest.START_EXAM_LIST, getStartExamListItemScope())
		.field(ChangeRequest.ANSWER_QUESTION_LIST, getAnswerQuestionListItemScope())
		;
	/** 用于ChangeRequest对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getChangeRequestDetailScope() {
		return ChangeRequestBaseDetailScope;
	}

	protected static SerializeScope RegistrationBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Registration.ID_PROPERTY)
		.field(Registration.NICK_NAME_PROPERTY)
		.field(Registration.AVATAR_PROPERTY)
		.field(Registration.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于Registration对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getRegistrationDetailScope() {
		return RegistrationBaseDetailScope;
	}

	protected static SerializeScope StartExamBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(StartExam.ID_PROPERTY)
		.field(StartExam.NICK_NAME_PROPERTY)
		.field(StartExam.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于StartExam对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getStartExamDetailScope() {
		return StartExamBaseDetailScope;
	}

	protected static SerializeScope AnswerQuestionBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(AnswerQuestion.ID_PROPERTY)
		.field(AnswerQuestion.NICK_NAME_PROPERTY)
		.field(AnswerQuestion.USER_PROPERTY, getWechatUserSummaryScope())
		.field(AnswerQuestion.QUESTION_PROPERTY, getQuestionSummaryScope())
		.field(AnswerQuestion.ANSWER_PROPERTY)
		.field(AnswerQuestion.CHANGE_REQUEST_PROPERTY, getChangeRequestSummaryScope())
		;
	/** 用于AnswerQuestion对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAnswerQuestionDetailScope() {
		return AnswerQuestionBaseDetailScope;
	}

	protected static SerializeScope ExamStatusBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamStatus.ID_PROPERTY)
		.field(ExamStatus.NAME_PROPERTY)
		.field(ExamStatus.CODE_PROPERTY)
		.field(ExamStatus.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(ExamStatus.EXAM_LIST, getExamListItemScope())
		;
	/** 用于ExamStatus对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamStatusDetailScope() {
		return ExamStatusBaseDetailScope;
	}

	protected static SerializeScope QuestionBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Question.ID_PROPERTY)
		.field(Question.TOPIC_PROPERTY)
		.field(Question.LEVEL_PROPERTY)
		.field(Question.OPTION_A_PROPERTY)
		.field(Question.OPTION_B_PROPERTY)
		.field(Question.OPTION_C_PROPERTY)
		.field(Question.OPTION_D_PROPERTY)
		.field(Question.OPTION_E_PROPERTY)
		.field(Question.RIGHT_ANSWER_PROPERTY)
		.field(Question.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(Question.ANSWER_QUESTION_LIST, getAnswerQuestionListItemScope())
		.field(Question.ANSWER_LIST, getAnswerListItemScope())
		.field(Question.USER_ANSWER_LIST, getUserAnswerListItemScope())
		;
	/** 用于Question对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuestionDetailScope() {
		return QuestionBaseDetailScope;
	}

	protected static SerializeScope ExamRankingBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ExamRanking.ID_PROPERTY)
		.field(ExamRanking.NAME_PROPERTY)
		.field(ExamRanking.AVATAR_PROPERTY)
		.field(ExamRanking.PLATFORM_PROPERTY, getPlatformSummaryScope())
		;
	/** 用于ExamRanking对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamRankingDetailScope() {
		return ExamRankingBaseDetailScope;
	}

	protected static SerializeScope AnswerBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Answer.ID_PROPERTY)
		.field(Answer.TITLE_PROPERTY)
		.field(Answer.COMMENT_PROPERTY)
		.field(Answer.QUESTION_PROPERTY, getQuestionSummaryScope())
		;
	/** 用于Answer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getAnswerDetailScope() {
		return AnswerBaseDetailScope;
	}

	protected static SerializeScope WechatUserBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatUser.ID_PROPERTY)
		.field(WechatUser.NAME_PROPERTY)
		.field(WechatUser.AVARTA_PROPERTY)
		.field(WechatUser.CREATE_TIME_PROPERTY)
		.field(WechatUser.PLATFORM_PROPERTY, getPlatformSummaryScope())
		.field(WechatUser.ANSWER_QUESTION_LIST, getAnswerQuestionListItemScope())
		.field(WechatUser.WECHAT_LOGIN_INFO_LIST, getWechatLoginInfoListItemScope())
		.field(WechatUser.EXAM_LIST, getExamListItemScope())
		.field(WechatUser.FAULT_ANSWER_LIST, getFaultAnswerListItemScope())
		;
	/** 用于WechatUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatUserDetailScope() {
		return WechatUserBaseDetailScope;
	}

	protected static SerializeScope WechatLoginInfoBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(WechatLoginInfo.ID_PROPERTY)
		.field(WechatLoginInfo.WECHAT_USER_PROPERTY, getWechatUserSummaryScope())
		.field(WechatLoginInfo.APP_ID_PROPERTY)
		.field(WechatLoginInfo.OPEN_ID_PROPERTY)
		.field(WechatLoginInfo.SESSION_KEY_PROPERTY)
		.field(WechatLoginInfo.LAST_UPDATE_TIME_PROPERTY)
		;
	/** 用于WechatLoginInfo对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getWechatLoginInfoDetailScope() {
		return WechatLoginInfoBaseDetailScope;
	}

	protected static SerializeScope ExamBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(Exam.ID_PROPERTY)
		.field(Exam.NAME_PROPERTY)
		.field(Exam.CREATE_TIME_PROPERTY)
		.field(Exam.STATUS_PROPERTY, getExamStatusSummaryScope())
		.field(Exam.USER_PROPERTY, getWechatUserSummaryScope())
		.field(Exam.SCORE_PROPERTY)
		.field(Exam.USER_ANSWER_LIST, getUserAnswerListItemScope())
		.field(Exam.FAULT_ANSWER_LIST, getFaultAnswerListItemScope())
		;
	/** 用于Exam对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getExamDetailScope() {
		return ExamBaseDetailScope;
	}

	protected static SerializeScope UserAnswerBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserAnswer.ID_PROPERTY)
		.field(UserAnswer.TOPIC_PROPERTY)
		.field(UserAnswer.USER_SELECT_PROPERTY)
		.field(UserAnswer.QUESTION_PROPERTY, getQuestionSummaryScope())
		.field(UserAnswer.EXAM_PROPERTY, getExamSummaryScope())
		;
	/** 用于UserAnswer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAnswerDetailScope() {
		return UserAnswerBaseDetailScope;
	}

	protected static SerializeScope FaultAnswerBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FaultAnswer.ID_PROPERTY)
		.field(FaultAnswer.TOPIC_PROPERTY)
		.field(FaultAnswer.YOUR_ANSWER_PROPERTY)
		.field(FaultAnswer.RIGHT_ANSWER_PROPERTY)
		.field(FaultAnswer.CREATE_TIME_PROPERTY)
		.field(FaultAnswer.USER_PROPERTY, getWechatUserSummaryScope())
		.field(FaultAnswer.EXAM_PROPERTY, getExamSummaryScope())
		;
	/** 用于FaultAnswer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFaultAnswerDetailScope() {
		return FaultAnswerBaseDetailScope;
	}

	protected static SerializeScope UserDomainBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserDomain.ID_PROPERTY)
		.field(UserDomain.NAME_PROPERTY)
		.field(UserDomain.USER_WHITE_LIST_LIST, getUserWhiteListListItemScope())
		.field(UserDomain.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于UserDomain对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserDomainDetailScope() {
		return UserDomainBaseDetailScope;
	}

	protected static SerializeScope UserWhiteListBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserWhiteList.ID_PROPERTY)
		.field(UserWhiteList.USER_IDENTITY_PROPERTY)
		.field(UserWhiteList.USER_SPECIAL_FUNCTIONS_PROPERTY)
		.field(UserWhiteList.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		;
	/** 用于UserWhiteList对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserWhiteListDetailScope() {
		return UserWhiteListBaseDetailScope;
	}

	protected static SerializeScope SecUserBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUser.ID_PROPERTY)
		.field(SecUser.LOGIN_PROPERTY)
		.field(SecUser.MOBILE_PROPERTY)
		.field(SecUser.EMAIL_PROPERTY)
		.field(SecUser.PWD_PROPERTY)
		.field(SecUser.WEIXIN_OPENID_PROPERTY)
		.field(SecUser.WEIXIN_APPID_PROPERTY)
		.field(SecUser.ACCESS_TOKEN_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_PROPERTY)
		.field(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY)
		.field(SecUser.LAST_LOGIN_TIME_PROPERTY)
		.field(SecUser.DOMAIN_PROPERTY, getUserDomainSummaryScope())
		.field(SecUser.BLOCKING_PROPERTY, getSecUserBlockingSummaryScope())
		.field(SecUser.CURRENT_STATUS_PROPERTY)
		.field(SecUser.USER_APP_LIST, getUserAppListItemScope())
		.field(SecUser.LOGIN_HISTORY_LIST, getLoginHistoryListItemScope())
		;
	/** 用于SecUser对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserDetailScope() {
		return SecUserBaseDetailScope;
	}

	protected static SerializeScope SecUserBlockingBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(SecUserBlocking.ID_PROPERTY)
		.field(SecUserBlocking.WHO_PROPERTY)
		.field(SecUserBlocking.BLOCK_TIME_PROPERTY)
		.field(SecUserBlocking.COMMENTS_PROPERTY)
		.field(SecUserBlocking.SEC_USER_LIST, getSecUserListItemScope())
		;
	/** 用于SecUserBlocking对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getSecUserBlockingDetailScope() {
		return SecUserBlockingBaseDetailScope;
	}

	protected static SerializeScope UserAppBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(UserApp.ID_PROPERTY)
		.field(UserApp.TITLE_PROPERTY)
		.field(UserApp.SEC_USER_PROPERTY, getSecUserSummaryScope())
		.field(UserApp.APP_ICON_PROPERTY)
		.field(UserApp.FULL_ACCESS_PROPERTY)
		.field(UserApp.PERMISSION_PROPERTY)
		.field(UserApp.OBJECT_TYPE_PROPERTY)
		.field(UserApp.OBJECT_ID_PROPERTY)
		.field(UserApp.LOCATION_PROPERTY)
		.field(UserApp.QUICK_LINK_LIST, getQuickLinkListItemScope())
		.field(UserApp.LIST_ACCESS_LIST, getListAccessListItemScope())
		.field(UserApp.OBJECT_ACCESS_LIST, getObjectAccessListItemScope())
		;
	/** 用于UserApp对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getUserAppDetailScope() {
		return UserAppBaseDetailScope;
	}

	protected static SerializeScope QuickLinkBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(QuickLink.ID_PROPERTY)
		.field(QuickLink.NAME_PROPERTY)
		.field(QuickLink.ICON_PROPERTY)
		.field(QuickLink.IMAGE_PATH_PROPERTY)
		.field(QuickLink.LINK_TARGET_PROPERTY)
		.field(QuickLink.CREATE_TIME_PROPERTY)
		.field(QuickLink.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于QuickLink对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getQuickLinkDetailScope() {
		return QuickLinkBaseDetailScope;
	}

	protected static SerializeScope ListAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ListAccess.ID_PROPERTY)
		.field(ListAccess.NAME_PROPERTY)
		.field(ListAccess.INTERNAL_NAME_PROPERTY)
		.field(ListAccess.READ_PERMISSION_PROPERTY)
		.field(ListAccess.CREATE_PERMISSION_PROPERTY)
		.field(ListAccess.DELETE_PERMISSION_PROPERTY)
		.field(ListAccess.UPDATE_PERMISSION_PROPERTY)
		.field(ListAccess.EXECUTION_PERMISSION_PROPERTY)
		.field(ListAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ListAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getListAccessDetailScope() {
		return ListAccessBaseDetailScope;
	}

	protected static SerializeScope ObjectAccessBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(ObjectAccess.ID_PROPERTY)
		.field(ObjectAccess.NAME_PROPERTY)
		.field(ObjectAccess.OBJECT_TYPE_PROPERTY)
		.field(ObjectAccess.LIST1_PROPERTY)
		.field(ObjectAccess.LIST2_PROPERTY)
		.field(ObjectAccess.LIST3_PROPERTY)
		.field(ObjectAccess.LIST4_PROPERTY)
		.field(ObjectAccess.LIST5_PROPERTY)
		.field(ObjectAccess.LIST6_PROPERTY)
		.field(ObjectAccess.LIST7_PROPERTY)
		.field(ObjectAccess.LIST8_PROPERTY)
		.field(ObjectAccess.LIST9_PROPERTY)
		.field(ObjectAccess.APP_PROPERTY, getUserAppSummaryScope())
		;
	/** 用于ObjectAccess对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getObjectAccessDetailScope() {
		return ObjectAccessBaseDetailScope;
	}

	protected static SerializeScope LoginHistoryBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(LoginHistory.ID_PROPERTY)
		.field(LoginHistory.LOGIN_TIME_PROPERTY)
		.field(LoginHistory.FROM_IP_PROPERTY)
		.field(LoginHistory.DESCRIPTION_PROPERTY)
		.field(LoginHistory.SEC_USER_PROPERTY, getSecUserSummaryScope())
		;
	/** 用于LoginHistory对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getLoginHistoryDetailScope() {
		return LoginHistoryBaseDetailScope;
	}

	protected static SerializeScope GenericFormBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(GenericForm.ID_PROPERTY)
		.field(GenericForm.TITLE_PROPERTY)
		.field(GenericForm.DESCRIPTION_PROPERTY)
		.field(GenericForm.FORM_MESSAGE_LIST, getFormMessageListItemScope())
		.field(GenericForm.FORM_FIELD_MESSAGE_LIST, getFormFieldMessageListItemScope())
		.field(GenericForm.FORM_FIELD_LIST, getFormFieldListItemScope())
		.field(GenericForm.FORM_ACTION_LIST, getFormActionListItemScope())
		;
	/** 用于GenericForm对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getGenericFormDetailScope() {
		return GenericFormBaseDetailScope;
	}

	protected static SerializeScope FormMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormMessage.ID_PROPERTY)
		.field(FormMessage.TITLE_PROPERTY)
		.field(FormMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormMessage.LEVEL_PROPERTY)
		;
	/** 用于FormMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormMessageDetailScope() {
		return FormMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldMessageBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormFieldMessage.ID_PROPERTY)
		.field(FormFieldMessage.TITLE_PROPERTY)
		.field(FormFieldMessage.PARAMETER_NAME_PROPERTY)
		.field(FormFieldMessage.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormFieldMessage.LEVEL_PROPERTY)
		;
	/** 用于FormFieldMessage对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldMessageDetailScope() {
		return FormFieldMessageBaseDetailScope;
	}

	protected static SerializeScope FormFieldBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormField.ID_PROPERTY)
		.field(FormField.LABEL_PROPERTY)
		.field(FormField.LOCALE_KEY_PROPERTY)
		.field(FormField.PARAMETER_NAME_PROPERTY)
		.field(FormField.TYPE_PROPERTY)
		.field(FormField.FORM_PROPERTY, getGenericFormSummaryScope())
		.field(FormField.PLACEHOLDER_PROPERTY)
		.field(FormField.DEFAULT_VALUE_PROPERTY)
		.field(FormField.DESCRIPTION_PROPERTY)
		.field(FormField.FIELD_GROUP_PROPERTY)
		.field(FormField.MINIMUM_VALUE_PROPERTY)
		.field(FormField.MAXIMUM_VALUE_PROPERTY)
		.field(FormField.REQUIRED_PROPERTY)
		.field(FormField.DISABLED_PROPERTY)
		.field(FormField.CUSTOM_RENDERING_PROPERTY)
		.field(FormField.CANDIDATE_VALUES_PROPERTY)
		.field(FormField.SUGGEST_VALUES_PROPERTY)
		;
	/** 用于FormField对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormFieldDetailScope() {
		return FormFieldBaseDetailScope;
	}

	protected static SerializeScope FormActionBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(FormAction.ID_PROPERTY)
		.field(FormAction.LABEL_PROPERTY)
		.field(FormAction.LOCALE_KEY_PROPERTY)
		.field(FormAction.ACTION_KEY_PROPERTY)
		.field(FormAction.LEVEL_PROPERTY)
		.field(FormAction.URL_PROPERTY)
		.field(FormAction.FORM_PROPERTY, getGenericFormSummaryScope())
		;
	/** 用于FormAction对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getFormActionDetailScope() {
		return FormActionBaseDetailScope;
	}

	protected static SerializeScope CandidateContainerBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateContainer.ID_PROPERTY)
		.field(CandidateContainer.NAME_PROPERTY)
		.field(CandidateContainer.CANDIDATE_ELEMENT_LIST, getCandidateElementListItemScope())
		;
	/** 用于CandidateContainer对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateContainerDetailScope() {
		return CandidateContainerBaseDetailScope;
	}

	protected static SerializeScope CandidateElementBaseDetailScope = SerializeScope.INCLUDE()
		.field(BcexBaseConstants.X_LINK_TO_URL)
		.field(CandidateElement.ID_PROPERTY)
		.field(CandidateElement.NAME_PROPERTY)
		.field(CandidateElement.TYPE_PROPERTY)
		.field(CandidateElement.IMAGE_PROPERTY)
		.field(CandidateElement.CONTAINER_PROPERTY, getCandidateContainerSummaryScope())
		;
	/** 用于CandidateElement对象的详情页时需要序列化的属性列表 */
	public static SerializeScope getCandidateElementDetailScope() {
		return CandidateElementBaseDetailScope;
	}

	

}






