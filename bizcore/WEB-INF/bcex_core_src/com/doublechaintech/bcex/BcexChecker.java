
package com.doublechaintech.bcex;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class BcexChecker extends BaseChecker{

	
	public BcexChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_PLATFORM ="platform.id";
	public BcexChecker checkIdOfPlatform(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PLATFORM ="platform.name";
	public BcexChecker checkNameOfPlatform(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_PLATFORM ="platform.description";
	public BcexChecker checkDescriptionOfPlatform(String description)
	{
		
	 	checkLongtext(description,0, 1048576,DESCRIPTION_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PLATFORM ="platform.version";
	public BcexChecker checkVersionOfPlatform(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PLATFORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANGE_REQUEST_TYPE ="change_request_type.id";
	public BcexChecker checkIdOfChangeRequestType(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHANGE_REQUEST_TYPE ="change_request_type.name";
	public BcexChecker checkNameOfChangeRequestType(String name)
	{
		
	 	checkStringLengthRange(name,1, 16,NAME_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_CHANGE_REQUEST_TYPE ="change_request_type.code";
	public BcexChecker checkCodeOfChangeRequestType(String code)
	{
		
	 	checkStringLengthRange(code,3, 40,CODE_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  ICON_OF_CHANGE_REQUEST_TYPE ="change_request_type.icon";
	public BcexChecker checkIconOfChangeRequestType(String icon)
	{
		
	 	checkStringLengthRange(icon,2, 48,ICON_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_CHANGE_REQUEST_TYPE ="change_request_type.display_order";
	public BcexChecker checkDisplayOrderOfChangeRequestType(int displayOrder)
	{
		
	 	checkIntegerRange(displayOrder,0, 6,DISPLAY_ORDER_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_CHANGE_REQUEST_TYPE ="change_request_type.platform";
	public BcexChecker checkPlatformIdOfChangeRequestType(String platformId)
	{
		
	 	checkIdOfChangeRequestType(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANGE_REQUEST_TYPE ="change_request_type.version";
	public BcexChecker checkVersionOfChangeRequestType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANGE_REQUEST_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_CHANGE_REQUEST ="change_request.id";
	public BcexChecker checkIdOfChangeRequest(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CHANGE_REQUEST ="change_request.name";
	public BcexChecker checkNameOfChangeRequest(String name)
	{
		
	 	checkStringLengthRange(name,1, 50,NAME_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  REQUEST_TYPE_OF_CHANGE_REQUEST ="change_request.request_type";
	public BcexChecker checkRequestTypeIdOfChangeRequest(String requestTypeId)
	{
		
	 	checkIdOfChangeRequest(requestTypeId ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_CHANGE_REQUEST ="change_request.platform";
	public BcexChecker checkPlatformIdOfChangeRequest(String platformId)
	{
		
	 	checkIdOfChangeRequest(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CHANGE_REQUEST ="change_request.version";
	public BcexChecker checkVersionOfChangeRequest(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CHANGE_REQUEST ); 		
		
		return this;
	}	

	public static final String  ID_OF_REGISTRATION ="registration.id";
	public BcexChecker checkIdOfRegistration(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_REGISTRATION ); 		
		
		return this;
	}	

	public static final String  NICK_NAME_OF_REGISTRATION ="registration.nick_name";
	public BcexChecker checkNickNameOfRegistration(String nickName)
	{
		
	 	checkStringLengthRange(nickName,1, 200,NICK_NAME_OF_REGISTRATION ); 		
		
		return this;
	}	

	public static final String  AVATAR_OF_REGISTRATION ="registration.avatar";
	public BcexChecker checkAvatarOfRegistration(String avatar)
	{
		
	 	checkImage(avatar,0, 512,AVATAR_OF_REGISTRATION ); 		
		
		return this;
	}	

	public static final String  CHANGE_REQUEST_OF_REGISTRATION ="registration.change_request";
	public BcexChecker checkChangeRequestIdOfRegistration(String changeRequestId)
	{
		
	 	checkIdOfRegistration(changeRequestId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_REGISTRATION ="registration.version";
	public BcexChecker checkVersionOfRegistration(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_REGISTRATION ); 		
		
		return this;
	}	

	public static final String  ID_OF_START_EXAM ="start_exam.id";
	public BcexChecker checkIdOfStartExam(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_START_EXAM ); 		
		
		return this;
	}	

	public static final String  NICK_NAME_OF_START_EXAM ="start_exam.nick_name";
	public BcexChecker checkNickNameOfStartExam(String nickName)
	{
		
	 	checkStringLengthRange(nickName,1, 200,NICK_NAME_OF_START_EXAM ); 		
		
		return this;
	}	

	public static final String  CHANGE_REQUEST_OF_START_EXAM ="start_exam.change_request";
	public BcexChecker checkChangeRequestIdOfStartExam(String changeRequestId)
	{
		
	 	checkIdOfStartExam(changeRequestId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_START_EXAM ="start_exam.version";
	public BcexChecker checkVersionOfStartExam(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_START_EXAM ); 		
		
		return this;
	}	

	public static final String  ID_OF_ANSWER_QUESTION ="answer_question.id";
	public BcexChecker checkIdOfAnswerQuestion(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_ANSWER_QUESTION ); 		
		
		return this;
	}	

	public static final String  NICK_NAME_OF_ANSWER_QUESTION ="answer_question.nick_name";
	public BcexChecker checkNickNameOfAnswerQuestion(String nickName)
	{
		
	 	checkStringLengthRange(nickName,1, 200,NICK_NAME_OF_ANSWER_QUESTION ); 		
		
		return this;
	}	

	public static final String  USER_OF_ANSWER_QUESTION ="answer_question.user";
	public BcexChecker checkUserIdOfAnswerQuestion(String userId)
	{
		
	 	checkIdOfAnswerQuestion(userId ); 		
		
		return this;
	}	

	public static final String  QUESTION_OF_ANSWER_QUESTION ="answer_question.question";
	public BcexChecker checkQuestionIdOfAnswerQuestion(String questionId)
	{
		
	 	checkIdOfAnswerQuestion(questionId ); 		
		
		return this;
	}	

	public static final String  ANSWER_OF_ANSWER_QUESTION ="answer_question.answer";
	public BcexChecker checkAnswerOfAnswerQuestion(String answer)
	{
		
	 	checkStringLengthRange(answer,1, 20,ANSWER_OF_ANSWER_QUESTION ); 		
		
		return this;
	}	

	public static final String  CHANGE_REQUEST_OF_ANSWER_QUESTION ="answer_question.change_request";
	public BcexChecker checkChangeRequestIdOfAnswerQuestion(String changeRequestId)
	{
		
	 	checkIdOfAnswerQuestion(changeRequestId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ANSWER_QUESTION ="answer_question.version";
	public BcexChecker checkVersionOfAnswerQuestion(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ANSWER_QUESTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_EXAM_STATUS ="exam_status.id";
	public BcexChecker checkIdOfExamStatus(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_EXAM_STATUS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_EXAM_STATUS ="exam_status.name";
	public BcexChecker checkNameOfExamStatus(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_EXAM_STATUS ); 		
		
		return this;
	}	

	public static final String  CODE_OF_EXAM_STATUS ="exam_status.code";
	public BcexChecker checkCodeOfExamStatus(String code)
	{
		
	 	checkStringLengthRange(code,3, 36,CODE_OF_EXAM_STATUS ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_EXAM_STATUS ="exam_status.platform";
	public BcexChecker checkPlatformIdOfExamStatus(String platformId)
	{
		
	 	checkIdOfExamStatus(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EXAM_STATUS ="exam_status.version";
	public BcexChecker checkVersionOfExamStatus(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EXAM_STATUS ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUESTION ="question.id";
	public BcexChecker checkIdOfQuestion(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  TOPIC_OF_QUESTION ="question.topic";
	public BcexChecker checkTopicOfQuestion(String topic)
	{
		
	 	checkStringLengthRange(topic,6, 80,TOPIC_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_QUESTION ="question.level";
	public BcexChecker checkLevelOfQuestion(String level)
	{
		
	 	checkStringLengthRange(level,0, 4,LEVEL_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  OPTION_A_OF_QUESTION ="question.option_a";
	public BcexChecker checkOptionAOfQuestion(String optionA)
	{
		
	 	checkStringLengthRange(optionA,2, 16,OPTION_A_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  OPTION_B_OF_QUESTION ="question.option_b";
	public BcexChecker checkOptionBOfQuestion(String optionB)
	{
		
	 	checkStringLengthRange(optionB,2, 16,OPTION_B_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  OPTION_C_OF_QUESTION ="question.option_c";
	public BcexChecker checkOptionCOfQuestion(String optionC)
	{
		
	 	checkStringLengthRange(optionC,2, 16,OPTION_C_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  OPTION_D_OF_QUESTION ="question.option_d";
	public BcexChecker checkOptionDOfQuestion(String optionD)
	{
		
	 	checkStringLengthRange(optionD,2, 16,OPTION_D_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  OPTION_E_OF_QUESTION ="question.option_e";
	public BcexChecker checkOptionEOfQuestion(String optionE)
	{
		
	 	checkStringLengthRange(optionE,2, 16,OPTION_E_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  RIGHT_ANSWER_OF_QUESTION ="question.right_answer";
	public BcexChecker checkRightAnswerOfQuestion(String rightAnswer)
	{
		
	 	checkStringLengthRange(rightAnswer,0, 4,RIGHT_ANSWER_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_QUESTION ="question.platform";
	public BcexChecker checkPlatformIdOfQuestion(String platformId)
	{
		
	 	checkIdOfQuestion(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUESTION ="question.version";
	public BcexChecker checkVersionOfQuestion(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUESTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_EXAM_RANKING ="exam_ranking.id";
	public BcexChecker checkIdOfExamRanking(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_EXAM_RANKING ); 		
		
		return this;
	}	

	public static final String  NAME_OF_EXAM_RANKING ="exam_ranking.name";
	public BcexChecker checkNameOfExamRanking(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_EXAM_RANKING ); 		
		
		return this;
	}	

	public static final String  AVATAR_OF_EXAM_RANKING ="exam_ranking.avatar";
	public BcexChecker checkAvatarOfExamRanking(String avatar)
	{
		
	 	checkImage(avatar,0, 512,AVATAR_OF_EXAM_RANKING ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_EXAM_RANKING ="exam_ranking.platform";
	public BcexChecker checkPlatformIdOfExamRanking(String platformId)
	{
		
	 	checkIdOfExamRanking(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EXAM_RANKING ="exam_ranking.version";
	public BcexChecker checkVersionOfExamRanking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EXAM_RANKING ); 		
		
		return this;
	}	

	public static final String  ID_OF_ANSWER ="answer.id";
	public BcexChecker checkIdOfAnswer(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_ANSWER ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_ANSWER ="answer.title";
	public BcexChecker checkTitleOfAnswer(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_ANSWER ); 		
		
		return this;
	}	

	public static final String  COMMENT_OF_ANSWER ="answer.comment";
	public BcexChecker checkCommentOfAnswer(String comment)
	{
		
	 	checkStringLengthRange(comment,4, 56,COMMENT_OF_ANSWER ); 		
		
		return this;
	}	

	public static final String  QUESTION_OF_ANSWER ="answer.question";
	public BcexChecker checkQuestionIdOfAnswer(String questionId)
	{
		
	 	checkIdOfAnswer(questionId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_ANSWER ="answer.version";
	public BcexChecker checkVersionOfAnswer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ANSWER ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_USER ="wechat_user.id";
	public BcexChecker checkIdOfWechatUser(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_USER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_WECHAT_USER ="wechat_user.name";
	public BcexChecker checkNameOfWechatUser(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_WECHAT_USER ); 		
		
		return this;
	}	

	public static final String  AVARTA_OF_WECHAT_USER ="wechat_user.avarta";
	public BcexChecker checkAvartaOfWechatUser(String avarta)
	{
		
	 	checkImage(avarta,0, 512,AVARTA_OF_WECHAT_USER ); 		
		
		return this;
	}	

	public static final String  PLATFORM_OF_WECHAT_USER ="wechat_user.platform";
	public BcexChecker checkPlatformIdOfWechatUser(String platformId)
	{
		
	 	checkIdOfWechatUser(platformId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_USER ="wechat_user.version";
	public BcexChecker checkVersionOfWechatUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_LOGIN_INFO ="wechat_login_info.id";
	public BcexChecker checkIdOfWechatLoginInfo(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_LOGIN_INFO ); 		
		
		return this;
	}	

	public static final String  WECHAT_USER_OF_WECHAT_LOGIN_INFO ="wechat_login_info.wechat_user";
	public BcexChecker checkWechatUserIdOfWechatLoginInfo(String wechatUserId)
	{
		
	 	checkIdOfWechatLoginInfo(wechatUserId ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_LOGIN_INFO ="wechat_login_info.app_id";
	public BcexChecker checkAppIdOfWechatLoginInfo(String appId)
	{
		
	 	checkStringLengthRange(appId,0, 100,APP_ID_OF_WECHAT_LOGIN_INFO ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_LOGIN_INFO ="wechat_login_info.open_id";
	public BcexChecker checkOpenIdOfWechatLoginInfo(String openId)
	{
		
	 	checkStringLengthRange(openId,1, 100,OPEN_ID_OF_WECHAT_LOGIN_INFO ); 		
		
		return this;
	}	

	public static final String  SESSION_KEY_OF_WECHAT_LOGIN_INFO ="wechat_login_info.session_key";
	public BcexChecker checkSessionKeyOfWechatLoginInfo(String sessionKey)
	{
		
	 	checkStringLengthRange(sessionKey,1, 200,SESSION_KEY_OF_WECHAT_LOGIN_INFO ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_LOGIN_INFO ="wechat_login_info.version";
	public BcexChecker checkVersionOfWechatLoginInfo(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_LOGIN_INFO ); 		
		
		return this;
	}	

	public static final String  ID_OF_EXAM ="exam.id";
	public BcexChecker checkIdOfExam(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_EXAM ); 		
		
		return this;
	}	

	public static final String  NAME_OF_EXAM ="exam.name";
	public BcexChecker checkNameOfExam(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_EXAM ); 		
		
		return this;
	}	

	public static final String  STATUS_OF_EXAM ="exam.status";
	public BcexChecker checkStatusIdOfExam(String statusId)
	{
		
	 	checkIdOfExam(statusId ); 		
		
		return this;
	}	

	public static final String  USER_OF_EXAM ="exam.user";
	public BcexChecker checkUserIdOfExam(String userId)
	{
		
	 	checkIdOfExam(userId ); 		
		
		return this;
	}	

	public static final String  SCORE_OF_EXAM ="exam.score";
	public BcexChecker checkScoreOfExam(int score)
	{
		
	 	checkIntegerRange(score,0, 100,SCORE_OF_EXAM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_EXAM ="exam.version";
	public BcexChecker checkVersionOfExam(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EXAM ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_ANSWER ="user_answer.id";
	public BcexChecker checkIdOfUserAnswer(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_ANSWER ); 		
		
		return this;
	}	

	public static final String  TOPIC_OF_USER_ANSWER ="user_answer.topic";
	public BcexChecker checkTopicOfUserAnswer(String topic)
	{
		
	 	checkStringLengthRange(topic,6, 80,TOPIC_OF_USER_ANSWER ); 		
		
		return this;
	}	

	public static final String  USER_SELECT_OF_USER_ANSWER ="user_answer.user_select";
	public BcexChecker checkUserSelectOfUserAnswer(String userSelect)
	{
		
	 	checkStringLengthRange(userSelect,1, 4,USER_SELECT_OF_USER_ANSWER ); 		
		
		return this;
	}	

	public static final String  QUESTION_OF_USER_ANSWER ="user_answer.question";
	public BcexChecker checkQuestionIdOfUserAnswer(String questionId)
	{
		
	 	checkIdOfUserAnswer(questionId ); 		
		
		return this;
	}	

	public static final String  EXAM_OF_USER_ANSWER ="user_answer.exam";
	public BcexChecker checkExamIdOfUserAnswer(String examId)
	{
		
	 	checkIdOfUserAnswer(examId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_ANSWER ="user_answer.version";
	public BcexChecker checkVersionOfUserAnswer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ANSWER ); 		
		
		return this;
	}	

	public static final String  ID_OF_FAULT_ANSWER ="fault_answer.id";
	public BcexChecker checkIdOfFaultAnswer(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FAULT_ANSWER ); 		
		
		return this;
	}	

	public static final String  TOPIC_OF_FAULT_ANSWER ="fault_answer.topic";
	public BcexChecker checkTopicOfFaultAnswer(String topic)
	{
		
	 	checkStringLengthRange(topic,6, 80,TOPIC_OF_FAULT_ANSWER ); 		
		
		return this;
	}	

	public static final String  YOUR_ANSWER_OF_FAULT_ANSWER ="fault_answer.your_answer";
	public BcexChecker checkYourAnswerOfFaultAnswer(String yourAnswer)
	{
		
	 	checkStringLengthRange(yourAnswer,2, 16,YOUR_ANSWER_OF_FAULT_ANSWER ); 		
		
		return this;
	}	

	public static final String  RIGHT_ANSWER_OF_FAULT_ANSWER ="fault_answer.right_answer";
	public BcexChecker checkRightAnswerOfFaultAnswer(String rightAnswer)
	{
		
	 	checkStringLengthRange(rightAnswer,2, 16,RIGHT_ANSWER_OF_FAULT_ANSWER ); 		
		
		return this;
	}	

	public static final String  USER_OF_FAULT_ANSWER ="fault_answer.user";
	public BcexChecker checkUserIdOfFaultAnswer(String userId)
	{
		
	 	checkIdOfFaultAnswer(userId ); 		
		
		return this;
	}	

	public static final String  EXAM_OF_FAULT_ANSWER ="fault_answer.exam";
	public BcexChecker checkExamIdOfFaultAnswer(String examId)
	{
		
	 	checkIdOfFaultAnswer(examId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FAULT_ANSWER ="fault_answer.version";
	public BcexChecker checkVersionOfFaultAnswer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FAULT_ANSWER ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public BcexChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public BcexChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public BcexChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public BcexChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public BcexChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public BcexChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public BcexChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public BcexChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public BcexChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public BcexChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public BcexChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public BcexChecker checkEmailOfSecUser(String email)
	{
		
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public BcexChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public BcexChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{
		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public BcexChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{
		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public BcexChecker checkAccessTokenOfSecUser(String accessToken)
	{
		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public BcexChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public BcexChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public BcexChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public BcexChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public BcexChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public BcexChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public BcexChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public BcexChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public BcexChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_APP ="user_app.id";
	public BcexChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public BcexChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public BcexChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public BcexChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public BcexChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public BcexChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public BcexChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public BcexChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public BcexChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public BcexChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public BcexChecker checkIdOfQuickLink(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public BcexChecker checkNameOfQuickLink(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public BcexChecker checkIconOfQuickLink(String icon)
	{
		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public BcexChecker checkImagePathOfQuickLink(String imagePath)
	{
		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public BcexChecker checkLinkTargetOfQuickLink(String linkTarget)
	{
		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public BcexChecker checkAppIdOfQuickLink(String appId)
	{
		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public BcexChecker checkVersionOfQuickLink(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public BcexChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public BcexChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public BcexChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public BcexChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public BcexChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public BcexChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public BcexChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public BcexChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public BcexChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public BcexChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public BcexChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public BcexChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public BcexChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public BcexChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public BcexChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public BcexChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public BcexChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public BcexChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public BcexChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public BcexChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public BcexChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public BcexChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public BcexChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public BcexChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public BcexChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public BcexChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public BcexChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public BcexChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public BcexChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public BcexChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public BcexChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public BcexChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public BcexChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public BcexChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public BcexChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public BcexChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public BcexChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public BcexChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public BcexChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public BcexChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public BcexChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public BcexChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public BcexChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public BcexChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public BcexChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public BcexChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public BcexChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public BcexChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public BcexChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public BcexChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public BcexChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public BcexChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public BcexChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public BcexChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public BcexChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public BcexChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public BcexChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public BcexChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public BcexChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public BcexChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public BcexChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public BcexChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public BcexChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public BcexChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public BcexChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public BcexChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public BcexChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public BcexChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public BcexChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public BcexChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public BcexChecker checkIdOfCandidateContainer(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public BcexChecker checkNameOfCandidateContainer(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public BcexChecker checkVersionOfCandidateContainer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public BcexChecker checkIdOfCandidateElement(String id)
	{
		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public BcexChecker checkNameOfCandidateElement(String name)
	{
		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public BcexChecker checkTypeOfCandidateElement(String type)
	{
		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public BcexChecker checkImageOfCandidateElement(String image)
	{
		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public BcexChecker checkContainerIdOfCandidateElement(String containerId)
	{
		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public BcexChecker checkVersionOfCandidateElement(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	
}








