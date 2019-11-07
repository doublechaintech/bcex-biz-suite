package com.doublechaintech.bcex;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class BcexObjectChecker extends BcexChecker{

	Set<BaseEntity> checkedObjectSet;
	
	protected void markAsChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			checkedObjectSet =  new HashSet<BaseEntity>();
		}
		checkedObjectSet.add(baseEntity);
		
		
	}
	
	protected boolean isChecked(BaseEntity baseEntity) {
		if(checkedObjectSet==null) {
			return false;
			
		}
		return checkedObjectSet.contains(baseEntity);
	}
	@FunctionalInterface
	public interface CheckerParameterFunction<P1> {
		BcexChecker apply(P1 valueToCheck);
	}
	@FunctionalInterface
	public interface AssignParameterFunction {
		BcexObjectChecker apply(BaseEntity targetEntity);
	}
	
	protected boolean isReferenceObject(BaseEntity target) {
		
		if(target.getId()==null) {
			return false;
		}
		if(target.getId().isEmpty()) {
			return false;
		}
		if(target.getVersion() > 0) {
			return false;
		}
		
		return true;
		
	}
	protected boolean isObjectForCreate(BaseEntity target) {
		if(target.getVersion() > 0) {
			return false;
		}
		if(target.getId()==null) {
			return true;
		}
		if(!target.getId().isEmpty()) {
			return false;
		}
		
		
		return true;
		
	}
	protected void setEntityProperty(BaseEntity targetEntity, String property, Object value) {
		if(!targetEntity.isChanged()) {
			return;
		}
		try {
			targetEntity.setPropertyOf(property, value);
		} catch (Exception e) {
			throw new IllegalArgumentException(concat("set property <",property,"> with value ",value.toString()," of ",targetEntity.toString()," failed"));
		}
		
	}
	
	public <T> BcexObjectChecker commonObjectPropertyAssign(BaseEntity target, String propertyName, AssignParameterFunction assigmentFunction) {
		assigmentFunction.apply(target);
		return this;
	}
	public <T> BcexObjectChecker commonObjectPropertyCheck(BaseEntity target, String propertyName, CheckerParameterFunction<T> checkerFunction) {
		
		
		if(!target.isChanged()) {
			return this;
		}
		
		if(isReferenceObject(target)&&!propertyName.equals("id")) {
			//this is an object reference, so all other properties except id check will be ignored
			//id will be checked in this case
			return this; //with an Id, but version is 0 regard as refencer
		}
		if(isObjectForCreate(target)&&propertyName.equals("id")) {
			// ignore check id for new object to create
			return this;
		}
		pushPosition(propertyName);
		T valueToCheck=(T)target.propertyOf(propertyName);
		checkerFunction.apply(valueToCheck);
		popPosition();
		
		return this;
	}
	public  BcexChecker commonObjectElementCheck(BaseEntity target, String propertyName, CheckerParameterFunction<BaseEntity> checkerFunction) {
		
		pushPosition(propertyName);
		checkerFunction.apply(target);
		popPosition();
		return this;
	}
	protected String wrapArrayIndex(int andIncrement) {
		return "["+andIncrement+"]";
	}
	protected String concat(String ...args) {
		
		return Arrays.asList(args).stream().collect(Collectors.joining(""));
		
	}
	// use like commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);

	public BcexObjectChecker checkAndFixPlatform(BaseEntity platformAsBaseEntity){

		if( isChecked(platformAsBaseEntity) ){
			return this;
		}
		markAsChecked(platformAsBaseEntity);
		commonObjectPropertyCheck(platformAsBaseEntity,"id",this::checkIdOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"name",this::checkNameOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"description",this::checkDescriptionOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"version",this::checkVersionOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"changeRequestTypeList",this::checkChangeRequestTypeListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"examStatusList",this::checkExamStatusListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"questionList",this::checkQuestionListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"examRankingList",this::checkExamRankingListOfPlatform);
		commonObjectPropertyCheck(platformAsBaseEntity,"wechatUserList",this::checkWechatUserListOfPlatform);
		return this;

	}

	public BcexObjectChecker checkAndFixChangeRequestType(BaseEntity changeRequestTypeAsBaseEntity){

		if( isChecked(changeRequestTypeAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestTypeAsBaseEntity);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"id",this::checkIdOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"name",this::checkNameOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"code",this::checkCodeOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"icon",this::checkIconOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"displayOrder",this::checkDisplayOrderOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"platform",this::checkPlatformOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"version",this::checkVersionOfChangeRequestType);
		commonObjectPropertyCheck(changeRequestTypeAsBaseEntity,"changeRequestList",this::checkChangeRequestListOfChangeRequestType);
		return this;

	}

	public BcexObjectChecker checkAndFixChangeRequest(BaseEntity changeRequestAsBaseEntity){

		if( isChecked(changeRequestAsBaseEntity) ){
			return this;
		}
		markAsChecked(changeRequestAsBaseEntity);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"id",this::checkIdOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"name",this::checkNameOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"createTime",this::assignCreateTimeOfChangeRequest);
		commonObjectPropertyAssign(changeRequestAsBaseEntity,"remoteIp",this::assignRemoteIpOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"requestType",this::checkRequestTypeOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"platform",this::checkPlatformOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"version",this::checkVersionOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"registrationList",this::checkRegistrationListOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"startExamList",this::checkStartExamListOfChangeRequest);
		commonObjectPropertyCheck(changeRequestAsBaseEntity,"answerQuestionList",this::checkAnswerQuestionListOfChangeRequest);
		return this;

	}

	public BcexObjectChecker checkAndFixRegistration(BaseEntity registrationAsBaseEntity){

		if( isChecked(registrationAsBaseEntity) ){
			return this;
		}
		markAsChecked(registrationAsBaseEntity);
		commonObjectPropertyCheck(registrationAsBaseEntity,"id",this::checkIdOfRegistration);
		commonObjectPropertyCheck(registrationAsBaseEntity,"nickName",this::checkNickNameOfRegistration);
		commonObjectPropertyCheck(registrationAsBaseEntity,"avatar",this::checkAvatarOfRegistration);
		commonObjectPropertyCheck(registrationAsBaseEntity,"changeRequest",this::checkChangeRequestOfRegistration);
		commonObjectPropertyCheck(registrationAsBaseEntity,"version",this::checkVersionOfRegistration);
		return this;

	}

	public BcexObjectChecker checkAndFixStartExam(BaseEntity startExamAsBaseEntity){

		if( isChecked(startExamAsBaseEntity) ){
			return this;
		}
		markAsChecked(startExamAsBaseEntity);
		commonObjectPropertyCheck(startExamAsBaseEntity,"id",this::checkIdOfStartExam);
		commonObjectPropertyCheck(startExamAsBaseEntity,"nickName",this::checkNickNameOfStartExam);
		commonObjectPropertyCheck(startExamAsBaseEntity,"changeRequest",this::checkChangeRequestOfStartExam);
		commonObjectPropertyCheck(startExamAsBaseEntity,"version",this::checkVersionOfStartExam);
		return this;

	}

	public BcexObjectChecker checkAndFixAnswerQuestion(BaseEntity answerQuestionAsBaseEntity){

		if( isChecked(answerQuestionAsBaseEntity) ){
			return this;
		}
		markAsChecked(answerQuestionAsBaseEntity);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"id",this::checkIdOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"nickName",this::checkNickNameOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"user",this::checkUserOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"question",this::checkQuestionOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"answer",this::checkAnswerOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"changeRequest",this::checkChangeRequestOfAnswerQuestion);
		commonObjectPropertyCheck(answerQuestionAsBaseEntity,"version",this::checkVersionOfAnswerQuestion);
		return this;

	}

	public BcexObjectChecker checkAndFixExamStatus(BaseEntity examStatusAsBaseEntity){

		if( isChecked(examStatusAsBaseEntity) ){
			return this;
		}
		markAsChecked(examStatusAsBaseEntity);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"id",this::checkIdOfExamStatus);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"name",this::checkNameOfExamStatus);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"code",this::checkCodeOfExamStatus);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"platform",this::checkPlatformOfExamStatus);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"version",this::checkVersionOfExamStatus);
		commonObjectPropertyCheck(examStatusAsBaseEntity,"examList",this::checkExamListOfExamStatus);
		return this;

	}

	public BcexObjectChecker checkAndFixQuestion(BaseEntity questionAsBaseEntity){

		if( isChecked(questionAsBaseEntity) ){
			return this;
		}
		markAsChecked(questionAsBaseEntity);
		commonObjectPropertyCheck(questionAsBaseEntity,"id",this::checkIdOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"topic",this::checkTopicOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"level",this::checkLevelOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"optionA",this::checkOptionAOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"optionB",this::checkOptionBOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"optionC",this::checkOptionCOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"optionD",this::checkOptionDOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"optionE",this::checkOptionEOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"rightAnswer",this::checkRightAnswerOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"platform",this::checkPlatformOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"version",this::checkVersionOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"answerQuestionList",this::checkAnswerQuestionListOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"answerList",this::checkAnswerListOfQuestion);
		commonObjectPropertyCheck(questionAsBaseEntity,"userAnswerList",this::checkUserAnswerListOfQuestion);
		return this;

	}

	public BcexObjectChecker checkAndFixExamRanking(BaseEntity examRankingAsBaseEntity){

		if( isChecked(examRankingAsBaseEntity) ){
			return this;
		}
		markAsChecked(examRankingAsBaseEntity);
		commonObjectPropertyCheck(examRankingAsBaseEntity,"id",this::checkIdOfExamRanking);
		commonObjectPropertyCheck(examRankingAsBaseEntity,"name",this::checkNameOfExamRanking);
		commonObjectPropertyCheck(examRankingAsBaseEntity,"avatar",this::checkAvatarOfExamRanking);
		commonObjectPropertyCheck(examRankingAsBaseEntity,"platform",this::checkPlatformOfExamRanking);
		commonObjectPropertyCheck(examRankingAsBaseEntity,"version",this::checkVersionOfExamRanking);
		return this;

	}

	public BcexObjectChecker checkAndFixAnswer(BaseEntity answerAsBaseEntity){

		if( isChecked(answerAsBaseEntity) ){
			return this;
		}
		markAsChecked(answerAsBaseEntity);
		commonObjectPropertyCheck(answerAsBaseEntity,"id",this::checkIdOfAnswer);
		commonObjectPropertyCheck(answerAsBaseEntity,"title",this::checkTitleOfAnswer);
		commonObjectPropertyCheck(answerAsBaseEntity,"comment",this::checkCommentOfAnswer);
		commonObjectPropertyCheck(answerAsBaseEntity,"question",this::checkQuestionOfAnswer);
		commonObjectPropertyCheck(answerAsBaseEntity,"version",this::checkVersionOfAnswer);
		return this;

	}

	public BcexObjectChecker checkAndFixWechatUser(BaseEntity wechatUserAsBaseEntity){

		if( isChecked(wechatUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatUserAsBaseEntity);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"id",this::checkIdOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"name",this::checkNameOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"avarta",this::checkAvartaOfWechatUser);
		commonObjectPropertyAssign(wechatUserAsBaseEntity,"createTime",this::assignCreateTimeOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"platform",this::checkPlatformOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"version",this::checkVersionOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"answerQuestionList",this::checkAnswerQuestionListOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"wechatLoginInfoList",this::checkWechatLoginInfoListOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"examList",this::checkExamListOfWechatUser);
		commonObjectPropertyCheck(wechatUserAsBaseEntity,"faultAnswerList",this::checkFaultAnswerListOfWechatUser);
		return this;

	}

	public BcexObjectChecker checkAndFixWechatLoginInfo(BaseEntity wechatLoginInfoAsBaseEntity){

		if( isChecked(wechatLoginInfoAsBaseEntity) ){
			return this;
		}
		markAsChecked(wechatLoginInfoAsBaseEntity);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"id",this::checkIdOfWechatLoginInfo);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"wechatUser",this::checkWechatUserOfWechatLoginInfo);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"appId",this::checkAppIdOfWechatLoginInfo);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"openId",this::checkOpenIdOfWechatLoginInfo);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"sessionKey",this::checkSessionKeyOfWechatLoginInfo);
		commonObjectPropertyAssign(wechatLoginInfoAsBaseEntity,"lastUpdateTime",this::assignLastUpdateTimeOfWechatLoginInfo);
		commonObjectPropertyCheck(wechatLoginInfoAsBaseEntity,"version",this::checkVersionOfWechatLoginInfo);
		return this;

	}

	public BcexObjectChecker checkAndFixExam(BaseEntity examAsBaseEntity){

		if( isChecked(examAsBaseEntity) ){
			return this;
		}
		markAsChecked(examAsBaseEntity);
		commonObjectPropertyCheck(examAsBaseEntity,"id",this::checkIdOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"name",this::checkNameOfExam);
		commonObjectPropertyAssign(examAsBaseEntity,"createTime",this::assignCreateTimeOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"status",this::checkStatusOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"user",this::checkUserOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"score",this::checkScoreOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"version",this::checkVersionOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"userAnswerList",this::checkUserAnswerListOfExam);
		commonObjectPropertyCheck(examAsBaseEntity,"faultAnswerList",this::checkFaultAnswerListOfExam);
		return this;

	}

	public BcexObjectChecker checkAndFixUserAnswer(BaseEntity userAnswerAsBaseEntity){

		if( isChecked(userAnswerAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAnswerAsBaseEntity);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"id",this::checkIdOfUserAnswer);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"topic",this::checkTopicOfUserAnswer);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"userSelect",this::checkUserSelectOfUserAnswer);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"question",this::checkQuestionOfUserAnswer);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"exam",this::checkExamOfUserAnswer);
		commonObjectPropertyCheck(userAnswerAsBaseEntity,"version",this::checkVersionOfUserAnswer);
		return this;

	}

	public BcexObjectChecker checkAndFixFaultAnswer(BaseEntity faultAnswerAsBaseEntity){

		if( isChecked(faultAnswerAsBaseEntity) ){
			return this;
		}
		markAsChecked(faultAnswerAsBaseEntity);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"id",this::checkIdOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"topic",this::checkTopicOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"yourAnswer",this::checkYourAnswerOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"rightAnswer",this::checkRightAnswerOfFaultAnswer);
		commonObjectPropertyAssign(faultAnswerAsBaseEntity,"createTime",this::assignCreateTimeOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"user",this::checkUserOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"exam",this::checkExamOfFaultAnswer);
		commonObjectPropertyCheck(faultAnswerAsBaseEntity,"version",this::checkVersionOfFaultAnswer);
		return this;

	}

	public BcexObjectChecker checkAndFixUserDomain(BaseEntity userDomainAsBaseEntity){

		if( isChecked(userDomainAsBaseEntity) ){
			return this;
		}
		markAsChecked(userDomainAsBaseEntity);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"id",this::checkIdOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"name",this::checkNameOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"version",this::checkVersionOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"userWhiteListList",this::checkUserWhiteListListOfUserDomain);
		commonObjectPropertyCheck(userDomainAsBaseEntity,"secUserList",this::checkSecUserListOfUserDomain);
		return this;

	}

	public BcexObjectChecker checkAndFixUserWhiteList(BaseEntity userWhiteListAsBaseEntity){

		if( isChecked(userWhiteListAsBaseEntity) ){
			return this;
		}
		markAsChecked(userWhiteListAsBaseEntity);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"id",this::checkIdOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userIdentity",this::checkUserIdentityOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"userSpecialFunctions",this::checkUserSpecialFunctionsOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"domain",this::checkDomainOfUserWhiteList);
		commonObjectPropertyCheck(userWhiteListAsBaseEntity,"version",this::checkVersionOfUserWhiteList);
		return this;

	}

	public BcexObjectChecker checkAndFixSecUser(BaseEntity secUserAsBaseEntity){

		if( isChecked(secUserAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserAsBaseEntity);
		commonObjectPropertyCheck(secUserAsBaseEntity,"id",this::checkIdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"login",this::checkLoginOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"mobile",this::checkMobileOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"email",this::checkEmailOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"pwd",this::checkPwdOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinOpenid",this::checkWeixinOpenidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"weixinAppid",this::checkWeixinAppidOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"accessToken",this::checkAccessTokenOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCode",this::checkVerificationCodeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"verificationCodeExpire",this::checkVerificationCodeExpireOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"lastLoginTime",this::checkLastLoginTimeOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"domain",this::checkDomainOfSecUser);
		commonObjectPropertyAssign(secUserAsBaseEntity,"currentStatus",this::assignCurrentStatusOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"version",this::checkVersionOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"userAppList",this::checkUserAppListOfSecUser);
		commonObjectPropertyCheck(secUserAsBaseEntity,"loginHistoryList",this::checkLoginHistoryListOfSecUser);
		return this;

	}

	public BcexObjectChecker checkAndFixSecUserBlocking(BaseEntity secUserBlockingAsBaseEntity){

		if( isChecked(secUserBlockingAsBaseEntity) ){
			return this;
		}
		markAsChecked(secUserBlockingAsBaseEntity);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"id",this::checkIdOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"who",this::checkWhoOfSecUserBlocking);
		commonObjectPropertyAssign(secUserBlockingAsBaseEntity,"blockTime",this::assignBlockTimeOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"comments",this::checkCommentsOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"version",this::checkVersionOfSecUserBlocking);
		commonObjectPropertyCheck(secUserBlockingAsBaseEntity,"secUserList",this::checkSecUserListOfSecUserBlocking);
		return this;

	}

	public BcexObjectChecker checkAndFixUserApp(BaseEntity userAppAsBaseEntity){

		if( isChecked(userAppAsBaseEntity) ){
			return this;
		}
		markAsChecked(userAppAsBaseEntity);
		commonObjectPropertyCheck(userAppAsBaseEntity,"id",this::checkIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"title",this::checkTitleOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"secUser",this::checkSecUserOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"appIcon",this::checkAppIconOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"fullAccess",this::checkFullAccessOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"permission",this::checkPermissionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectType",this::checkObjectTypeOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectId",this::checkObjectIdOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"location",this::checkLocationOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"version",this::checkVersionOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"quickLinkList",this::checkQuickLinkListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"listAccessList",this::checkListAccessListOfUserApp);
		commonObjectPropertyCheck(userAppAsBaseEntity,"objectAccessList",this::checkObjectAccessListOfUserApp);
		return this;

	}

	public BcexObjectChecker checkAndFixQuickLink(BaseEntity quickLinkAsBaseEntity){

		if( isChecked(quickLinkAsBaseEntity) ){
			return this;
		}
		markAsChecked(quickLinkAsBaseEntity);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"id",this::checkIdOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"name",this::checkNameOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"icon",this::checkIconOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"imagePath",this::checkImagePathOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"linkTarget",this::checkLinkTargetOfQuickLink);
		commonObjectPropertyAssign(quickLinkAsBaseEntity,"createTime",this::assignCreateTimeOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"app",this::checkAppOfQuickLink);
		commonObjectPropertyCheck(quickLinkAsBaseEntity,"version",this::checkVersionOfQuickLink);
		return this;

	}

	public BcexObjectChecker checkAndFixListAccess(BaseEntity listAccessAsBaseEntity){

		if( isChecked(listAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(listAccessAsBaseEntity);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"id",this::checkIdOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"name",this::checkNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"internalName",this::checkInternalNameOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"readPermission",this::checkReadPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"createPermission",this::checkCreatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"deletePermission",this::checkDeletePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"updatePermission",this::checkUpdatePermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"executionPermission",this::checkExecutionPermissionOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"app",this::checkAppOfListAccess);
		commonObjectPropertyCheck(listAccessAsBaseEntity,"version",this::checkVersionOfListAccess);
		return this;

	}

	public BcexObjectChecker checkAndFixObjectAccess(BaseEntity objectAccessAsBaseEntity){

		if( isChecked(objectAccessAsBaseEntity) ){
			return this;
		}
		markAsChecked(objectAccessAsBaseEntity);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"id",this::checkIdOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"name",this::checkNameOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"objectType",this::checkObjectTypeOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list1",this::checkList1OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list2",this::checkList2OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list3",this::checkList3OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list4",this::checkList4OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list5",this::checkList5OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list6",this::checkList6OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list7",this::checkList7OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list8",this::checkList8OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"list9",this::checkList9OfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"app",this::checkAppOfObjectAccess);
		commonObjectPropertyCheck(objectAccessAsBaseEntity,"version",this::checkVersionOfObjectAccess);
		return this;

	}

	public BcexObjectChecker checkAndFixLoginHistory(BaseEntity loginHistoryAsBaseEntity){

		if( isChecked(loginHistoryAsBaseEntity) ){
			return this;
		}
		markAsChecked(loginHistoryAsBaseEntity);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"id",this::checkIdOfLoginHistory);
		commonObjectPropertyAssign(loginHistoryAsBaseEntity,"loginTime",this::assignLoginTimeOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"fromIp",this::checkFromIpOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"description",this::checkDescriptionOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"secUser",this::checkSecUserOfLoginHistory);
		commonObjectPropertyCheck(loginHistoryAsBaseEntity,"version",this::checkVersionOfLoginHistory);
		return this;

	}

	public BcexObjectChecker checkAndFixGenericForm(BaseEntity genericFormAsBaseEntity){

		if( isChecked(genericFormAsBaseEntity) ){
			return this;
		}
		markAsChecked(genericFormAsBaseEntity);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"id",this::checkIdOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"title",this::checkTitleOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"description",this::checkDescriptionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"version",this::checkVersionOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formMessageList",this::checkFormMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldMessageList",this::checkFormFieldMessageListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formFieldList",this::checkFormFieldListOfGenericForm);
		commonObjectPropertyCheck(genericFormAsBaseEntity,"formActionList",this::checkFormActionListOfGenericForm);
		return this;

	}

	public BcexObjectChecker checkAndFixFormMessage(BaseEntity formMessageAsBaseEntity){

		if( isChecked(formMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formMessageAsBaseEntity);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"id",this::checkIdOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"title",this::checkTitleOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"form",this::checkFormOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"level",this::checkLevelOfFormMessage);
		commonObjectPropertyCheck(formMessageAsBaseEntity,"version",this::checkVersionOfFormMessage);
		return this;

	}

	public BcexObjectChecker checkAndFixFormFieldMessage(BaseEntity formFieldMessageAsBaseEntity){

		if( isChecked(formFieldMessageAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldMessageAsBaseEntity);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"id",this::checkIdOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"title",this::checkTitleOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"parameterName",this::checkParameterNameOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"form",this::checkFormOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"level",this::checkLevelOfFormFieldMessage);
		commonObjectPropertyCheck(formFieldMessageAsBaseEntity,"version",this::checkVersionOfFormFieldMessage);
		return this;

	}

	public BcexObjectChecker checkAndFixFormField(BaseEntity formFieldAsBaseEntity){

		if( isChecked(formFieldAsBaseEntity) ){
			return this;
		}
		markAsChecked(formFieldAsBaseEntity);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"id",this::checkIdOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"label",this::checkLabelOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"parameterName",this::checkParameterNameOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"type",this::checkTypeOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"form",this::checkFormOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"placeholder",this::checkPlaceholderOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"defaultValue",this::checkDefaultValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"description",this::checkDescriptionOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"fieldGroup",this::checkFieldGroupOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"minimumValue",this::checkMinimumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"maximumValue",this::checkMaximumValueOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"required",this::checkRequiredOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"disabled",this::checkDisabledOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"customRendering",this::checkCustomRenderingOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"candidateValues",this::checkCandidateValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"suggestValues",this::checkSuggestValuesOfFormField);
		commonObjectPropertyCheck(formFieldAsBaseEntity,"version",this::checkVersionOfFormField);
		return this;

	}

	public BcexObjectChecker checkAndFixFormAction(BaseEntity formActionAsBaseEntity){

		if( isChecked(formActionAsBaseEntity) ){
			return this;
		}
		markAsChecked(formActionAsBaseEntity);
		commonObjectPropertyCheck(formActionAsBaseEntity,"id",this::checkIdOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"label",this::checkLabelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"localeKey",this::checkLocaleKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"actionKey",this::checkActionKeyOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"level",this::checkLevelOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"url",this::checkUrlOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"form",this::checkFormOfFormAction);
		commonObjectPropertyCheck(formActionAsBaseEntity,"version",this::checkVersionOfFormAction);
		return this;

	}

	public BcexObjectChecker checkAndFixCandidateContainer(BaseEntity candidateContainerAsBaseEntity){

		if( isChecked(candidateContainerAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateContainerAsBaseEntity);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"id",this::checkIdOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"name",this::checkNameOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"version",this::checkVersionOfCandidateContainer);
		commonObjectPropertyCheck(candidateContainerAsBaseEntity,"candidateElementList",this::checkCandidateElementListOfCandidateContainer);
		return this;

	}

	public BcexObjectChecker checkAndFixCandidateElement(BaseEntity candidateElementAsBaseEntity){

		if( isChecked(candidateElementAsBaseEntity) ){
			return this;
		}
		markAsChecked(candidateElementAsBaseEntity);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"id",this::checkIdOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"name",this::checkNameOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"type",this::checkTypeOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"image",this::checkImageOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"container",this::checkContainerOfCandidateElement);
		commonObjectPropertyCheck(candidateElementAsBaseEntity,"version",this::checkVersionOfCandidateElement);
		return this;

	}


	public BcexObjectChecker checkChangeRequestTypeListOfPlatform(List<BaseEntity> changeRequestTypeList){
		AtomicInteger index = new AtomicInteger();
		changeRequestTypeList.stream().forEach(changeRequestType->
			commonObjectElementCheck(changeRequestType,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequestType));
		return this;
	}

	public BcexObjectChecker checkChangeRequestListOfPlatform(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public BcexObjectChecker checkExamStatusListOfPlatform(List<BaseEntity> examStatusList){
		AtomicInteger index = new AtomicInteger();
		examStatusList.stream().forEach(examStatus->
			commonObjectElementCheck(examStatus,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExamStatus));
		return this;
	}

	public BcexObjectChecker checkQuestionListOfPlatform(List<BaseEntity> questionList){
		AtomicInteger index = new AtomicInteger();
		questionList.stream().forEach(question->
			commonObjectElementCheck(question,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuestion));
		return this;
	}

	public BcexObjectChecker checkExamRankingListOfPlatform(List<BaseEntity> examRankingList){
		AtomicInteger index = new AtomicInteger();
		examRankingList.stream().forEach(examRanking->
			commonObjectElementCheck(examRanking,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExamRanking));
		return this;
	}

	public BcexObjectChecker checkWechatUserListOfPlatform(List<BaseEntity> wechatUserList){
		AtomicInteger index = new AtomicInteger();
		wechatUserList.stream().forEach(wechatUser->
			commonObjectElementCheck(wechatUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatUser));
		return this;
	}

	public BcexObjectChecker checkChangeRequestListOfChangeRequestType(List<BaseEntity> changeRequestList){
		AtomicInteger index = new AtomicInteger();
		changeRequestList.stream().forEach(changeRequest->
			commonObjectElementCheck(changeRequest,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixChangeRequest));
		return this;
	}

	public static final String PLATFORM_OF_CHANGE_REQUEST_TYPE = "change_request_type.platform";


	public BcexObjectChecker checkPlatformOfChangeRequestType(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_CHANGE_REQUEST_TYPE);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkRegistrationListOfChangeRequest(List<BaseEntity> registrationList){
		AtomicInteger index = new AtomicInteger();
		registrationList.stream().forEach(registration->
			commonObjectElementCheck(registration,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixRegistration));
		return this;
	}

	public BcexObjectChecker checkStartExamListOfChangeRequest(List<BaseEntity> startExamList){
		AtomicInteger index = new AtomicInteger();
		startExamList.stream().forEach(startExam->
			commonObjectElementCheck(startExam,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixStartExam));
		return this;
	}

	public BcexObjectChecker checkAnswerQuestionListOfChangeRequest(List<BaseEntity> answerQuestionList){
		AtomicInteger index = new AtomicInteger();
		answerQuestionList.stream().forEach(answerQuestion->
			commonObjectElementCheck(answerQuestion,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAnswerQuestion));
		return this;
	}

	public static final String REQUEST_TYPE_OF_CHANGE_REQUEST = "change_request.request_type";


	public BcexObjectChecker checkRequestTypeOfChangeRequest(BaseEntity requestTypeAsBaseEntity){

		if(requestTypeAsBaseEntity == null){
			checkBaseEntityReference(requestTypeAsBaseEntity,true,REQUEST_TYPE_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixChangeRequestType(requestTypeAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_CHANGE_REQUEST = "change_request.platform";


	public BcexObjectChecker checkPlatformOfChangeRequest(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_CHANGE_REQUEST);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_REGISTRATION = "registration.change_request";


	public BcexObjectChecker checkChangeRequestOfRegistration(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_REGISTRATION);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_START_EXAM = "start_exam.change_request";


	public BcexObjectChecker checkChangeRequestOfStartExam(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_START_EXAM);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public static final String USER_OF_ANSWER_QUESTION = "answer_question.user";


	public BcexObjectChecker checkUserOfAnswerQuestion(BaseEntity userAsBaseEntity){

		if(userAsBaseEntity == null){
			checkBaseEntityReference(userAsBaseEntity,true,USER_OF_ANSWER_QUESTION);
			return this;
		}
		checkAndFixWechatUser(userAsBaseEntity);
		return this;
	}


	public static final String QUESTION_OF_ANSWER_QUESTION = "answer_question.question";


	public BcexObjectChecker checkQuestionOfAnswerQuestion(BaseEntity questionAsBaseEntity){

		if(questionAsBaseEntity == null){
			checkBaseEntityReference(questionAsBaseEntity,true,QUESTION_OF_ANSWER_QUESTION);
			return this;
		}
		checkAndFixQuestion(questionAsBaseEntity);
		return this;
	}


	public static final String CHANGE_REQUEST_OF_ANSWER_QUESTION = "answer_question.change_request";


	public BcexObjectChecker checkChangeRequestOfAnswerQuestion(BaseEntity changeRequestAsBaseEntity){

		if(changeRequestAsBaseEntity == null){
			checkBaseEntityReference(changeRequestAsBaseEntity,true,CHANGE_REQUEST_OF_ANSWER_QUESTION);
			return this;
		}
		checkAndFixChangeRequest(changeRequestAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkExamListOfExamStatus(List<BaseEntity> examList){
		AtomicInteger index = new AtomicInteger();
		examList.stream().forEach(exam->
			commonObjectElementCheck(exam,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExam));
		return this;
	}

	public static final String PLATFORM_OF_EXAM_STATUS = "exam_status.platform";


	public BcexObjectChecker checkPlatformOfExamStatus(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_EXAM_STATUS);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkAnswerQuestionListOfQuestion(List<BaseEntity> answerQuestionList){
		AtomicInteger index = new AtomicInteger();
		answerQuestionList.stream().forEach(answerQuestion->
			commonObjectElementCheck(answerQuestion,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAnswerQuestion));
		return this;
	}

	public BcexObjectChecker checkAnswerListOfQuestion(List<BaseEntity> answerList){
		AtomicInteger index = new AtomicInteger();
		answerList.stream().forEach(answer->
			commonObjectElementCheck(answer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAnswer));
		return this;
	}

	public BcexObjectChecker checkUserAnswerListOfQuestion(List<BaseEntity> userAnswerList){
		AtomicInteger index = new AtomicInteger();
		userAnswerList.stream().forEach(userAnswer->
			commonObjectElementCheck(userAnswer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserAnswer));
		return this;
	}

	public static final String PLATFORM_OF_QUESTION = "question.platform";


	public BcexObjectChecker checkPlatformOfQuestion(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_QUESTION);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String PLATFORM_OF_EXAM_RANKING = "exam_ranking.platform";


	public BcexObjectChecker checkPlatformOfExamRanking(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_EXAM_RANKING);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String QUESTION_OF_ANSWER = "answer.question";


	public BcexObjectChecker checkQuestionOfAnswer(BaseEntity questionAsBaseEntity){

		if(questionAsBaseEntity == null){
			checkBaseEntityReference(questionAsBaseEntity,true,QUESTION_OF_ANSWER);
			return this;
		}
		checkAndFixQuestion(questionAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkAnswerQuestionListOfWechatUser(List<BaseEntity> answerQuestionList){
		AtomicInteger index = new AtomicInteger();
		answerQuestionList.stream().forEach(answerQuestion->
			commonObjectElementCheck(answerQuestion,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixAnswerQuestion));
		return this;
	}

	public BcexObjectChecker checkWechatLoginInfoListOfWechatUser(List<BaseEntity> wechatLoginInfoList){
		AtomicInteger index = new AtomicInteger();
		wechatLoginInfoList.stream().forEach(wechatLoginInfo->
			commonObjectElementCheck(wechatLoginInfo,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixWechatLoginInfo));
		return this;
	}

	public BcexObjectChecker checkExamListOfWechatUser(List<BaseEntity> examList){
		AtomicInteger index = new AtomicInteger();
		examList.stream().forEach(exam->
			commonObjectElementCheck(exam,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixExam));
		return this;
	}

	public BcexObjectChecker checkFaultAnswerListOfWechatUser(List<BaseEntity> faultAnswerList){
		AtomicInteger index = new AtomicInteger();
		faultAnswerList.stream().forEach(faultAnswer->
			commonObjectElementCheck(faultAnswer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFaultAnswer));
		return this;
	}

	public static final String PLATFORM_OF_WECHAT_USER = "wechat_user.platform";


	public BcexObjectChecker checkPlatformOfWechatUser(BaseEntity platformAsBaseEntity){

		if(platformAsBaseEntity == null){
			checkBaseEntityReference(platformAsBaseEntity,true,PLATFORM_OF_WECHAT_USER);
			return this;
		}
		checkAndFixPlatform(platformAsBaseEntity);
		return this;
	}


	public static final String WECHAT_USER_OF_WECHAT_LOGIN_INFO = "wechat_login_info.wechat_user";


	public BcexObjectChecker checkWechatUserOfWechatLoginInfo(BaseEntity wechatUserAsBaseEntity){

		if(wechatUserAsBaseEntity == null){
			checkBaseEntityReference(wechatUserAsBaseEntity,true,WECHAT_USER_OF_WECHAT_LOGIN_INFO);
			return this;
		}
		checkAndFixWechatUser(wechatUserAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkUserAnswerListOfExam(List<BaseEntity> userAnswerList){
		AtomicInteger index = new AtomicInteger();
		userAnswerList.stream().forEach(userAnswer->
			commonObjectElementCheck(userAnswer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserAnswer));
		return this;
	}

	public BcexObjectChecker checkFaultAnswerListOfExam(List<BaseEntity> faultAnswerList){
		AtomicInteger index = new AtomicInteger();
		faultAnswerList.stream().forEach(faultAnswer->
			commonObjectElementCheck(faultAnswer,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFaultAnswer));
		return this;
	}

	public static final String STATUS_OF_EXAM = "exam.status";


	public BcexObjectChecker checkStatusOfExam(BaseEntity statusAsBaseEntity){

		if(statusAsBaseEntity == null){
			checkBaseEntityReference(statusAsBaseEntity,true,STATUS_OF_EXAM);
			return this;
		}
		checkAndFixExamStatus(statusAsBaseEntity);
		return this;
	}


	public static final String USER_OF_EXAM = "exam.user";


	public BcexObjectChecker checkUserOfExam(BaseEntity userAsBaseEntity){

		if(userAsBaseEntity == null){
			checkBaseEntityReference(userAsBaseEntity,true,USER_OF_EXAM);
			return this;
		}
		checkAndFixWechatUser(userAsBaseEntity);
		return this;
	}


	public static final String QUESTION_OF_USER_ANSWER = "user_answer.question";


	public BcexObjectChecker checkQuestionOfUserAnswer(BaseEntity questionAsBaseEntity){

		if(questionAsBaseEntity == null){
			checkBaseEntityReference(questionAsBaseEntity,true,QUESTION_OF_USER_ANSWER);
			return this;
		}
		checkAndFixQuestion(questionAsBaseEntity);
		return this;
	}


	public static final String EXAM_OF_USER_ANSWER = "user_answer.exam";


	public BcexObjectChecker checkExamOfUserAnswer(BaseEntity examAsBaseEntity){

		if(examAsBaseEntity == null){
			checkBaseEntityReference(examAsBaseEntity,true,EXAM_OF_USER_ANSWER);
			return this;
		}
		checkAndFixExam(examAsBaseEntity);
		return this;
	}


	public static final String USER_OF_FAULT_ANSWER = "fault_answer.user";


	public BcexObjectChecker checkUserOfFaultAnswer(BaseEntity userAsBaseEntity){

		if(userAsBaseEntity == null){
			checkBaseEntityReference(userAsBaseEntity,true,USER_OF_FAULT_ANSWER);
			return this;
		}
		checkAndFixWechatUser(userAsBaseEntity);
		return this;
	}


	public static final String EXAM_OF_FAULT_ANSWER = "fault_answer.exam";


	public BcexObjectChecker checkExamOfFaultAnswer(BaseEntity examAsBaseEntity){

		if(examAsBaseEntity == null){
			checkBaseEntityReference(examAsBaseEntity,true,EXAM_OF_FAULT_ANSWER);
			return this;
		}
		checkAndFixExam(examAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkUserWhiteListListOfUserDomain(List<BaseEntity> userWhiteListList){
		AtomicInteger index = new AtomicInteger();
		userWhiteListList.stream().forEach(userWhiteList->
			commonObjectElementCheck(userWhiteList,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserWhiteList));
		return this;
	}

	public BcexObjectChecker checkSecUserListOfUserDomain(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public static final String DOMAIN_OF_USER_WHITE_LIST = "user_white_list.domain";


	public BcexObjectChecker checkDomainOfUserWhiteList(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_USER_WHITE_LIST);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkUserAppListOfSecUser(List<BaseEntity> userAppList){
		AtomicInteger index = new AtomicInteger();
		userAppList.stream().forEach(userApp->
			commonObjectElementCheck(userApp,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixUserApp));
		return this;
	}

	public BcexObjectChecker checkLoginHistoryListOfSecUser(List<BaseEntity> loginHistoryList){
		AtomicInteger index = new AtomicInteger();
		loginHistoryList.stream().forEach(loginHistory->
			commonObjectElementCheck(loginHistory,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixLoginHistory));
		return this;
	}

	public static final String DOMAIN_OF_SEC_USER = "sec_user.domain";


	public BcexObjectChecker checkDomainOfSecUser(BaseEntity domainAsBaseEntity){

		if(domainAsBaseEntity == null){
			checkBaseEntityReference(domainAsBaseEntity,true,DOMAIN_OF_SEC_USER);
			return this;
		}
		checkAndFixUserDomain(domainAsBaseEntity);
		return this;
	}


	public static final String BLOCKING_OF_SEC_USER = "sec_user.blocking";


	public BcexObjectChecker checkBlockingOfSecUser(BaseEntity blockingAsBaseEntity){

		if(blockingAsBaseEntity == null){
			checkBaseEntityReference(blockingAsBaseEntity,true,BLOCKING_OF_SEC_USER);
			return this;
		}
		checkAndFixSecUserBlocking(blockingAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkSecUserListOfSecUserBlocking(List<BaseEntity> secUserList){
		AtomicInteger index = new AtomicInteger();
		secUserList.stream().forEach(secUser->
			commonObjectElementCheck(secUser,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixSecUser));
		return this;
	}

	public BcexObjectChecker checkQuickLinkListOfUserApp(List<BaseEntity> quickLinkList){
		AtomicInteger index = new AtomicInteger();
		quickLinkList.stream().forEach(quickLink->
			commonObjectElementCheck(quickLink,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixQuickLink));
		return this;
	}

	public BcexObjectChecker checkListAccessListOfUserApp(List<BaseEntity> listAccessList){
		AtomicInteger index = new AtomicInteger();
		listAccessList.stream().forEach(listAccess->
			commonObjectElementCheck(listAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixListAccess));
		return this;
	}

	public BcexObjectChecker checkObjectAccessListOfUserApp(List<BaseEntity> objectAccessList){
		AtomicInteger index = new AtomicInteger();
		objectAccessList.stream().forEach(objectAccess->
			commonObjectElementCheck(objectAccess,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixObjectAccess));
		return this;
	}

	public static final String SEC_USER_OF_USER_APP = "user_app.sec_user";


	public BcexObjectChecker checkSecUserOfUserApp(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_USER_APP);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public static final String APP_OF_QUICK_LINK = "quick_link.app";


	public BcexObjectChecker checkAppOfQuickLink(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_QUICK_LINK);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_LIST_ACCESS = "list_access.app";


	public BcexObjectChecker checkAppOfListAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_LIST_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String APP_OF_OBJECT_ACCESS = "object_access.app";


	public BcexObjectChecker checkAppOfObjectAccess(BaseEntity appAsBaseEntity){

		if(appAsBaseEntity == null){
			checkBaseEntityReference(appAsBaseEntity,true,APP_OF_OBJECT_ACCESS);
			return this;
		}
		checkAndFixUserApp(appAsBaseEntity);
		return this;
	}


	public static final String SEC_USER_OF_LOGIN_HISTORY = "login_history.sec_user";


	public BcexObjectChecker checkSecUserOfLoginHistory(BaseEntity secUserAsBaseEntity){

		if(secUserAsBaseEntity == null){
			checkBaseEntityReference(secUserAsBaseEntity,true,SEC_USER_OF_LOGIN_HISTORY);
			return this;
		}
		checkAndFixSecUser(secUserAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkFormMessageListOfGenericForm(List<BaseEntity> formMessageList){
		AtomicInteger index = new AtomicInteger();
		formMessageList.stream().forEach(formMessage->
			commonObjectElementCheck(formMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormMessage));
		return this;
	}

	public BcexObjectChecker checkFormFieldMessageListOfGenericForm(List<BaseEntity> formFieldMessageList){
		AtomicInteger index = new AtomicInteger();
		formFieldMessageList.stream().forEach(formFieldMessage->
			commonObjectElementCheck(formFieldMessage,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormFieldMessage));
		return this;
	}

	public BcexObjectChecker checkFormFieldListOfGenericForm(List<BaseEntity> formFieldList){
		AtomicInteger index = new AtomicInteger();
		formFieldList.stream().forEach(formField->
			commonObjectElementCheck(formField,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormField));
		return this;
	}

	public BcexObjectChecker checkFormActionListOfGenericForm(List<BaseEntity> formActionList){
		AtomicInteger index = new AtomicInteger();
		formActionList.stream().forEach(formAction->
			commonObjectElementCheck(formAction,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixFormAction));
		return this;
	}

	public static final String FORM_OF_FORM_MESSAGE = "form_message.form";


	public BcexObjectChecker checkFormOfFormMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD_MESSAGE = "form_field_message.form";


	public BcexObjectChecker checkFormOfFormFieldMessage(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD_MESSAGE);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_FIELD = "form_field.form";


	public BcexObjectChecker checkFormOfFormField(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_FIELD);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public static final String FORM_OF_FORM_ACTION = "form_action.form";


	public BcexObjectChecker checkFormOfFormAction(BaseEntity formAsBaseEntity){

		if(formAsBaseEntity == null){
			checkBaseEntityReference(formAsBaseEntity,true,FORM_OF_FORM_ACTION);
			return this;
		}
		checkAndFixGenericForm(formAsBaseEntity);
		return this;
	}


	public BcexObjectChecker checkCandidateElementListOfCandidateContainer(List<BaseEntity> candidateElementList){
		AtomicInteger index = new AtomicInteger();
		candidateElementList.stream().forEach(candidateElement->
			commonObjectElementCheck(candidateElement,wrapArrayIndex(index.getAndIncrement()),this::checkAndFixCandidateElement));
		return this;
	}

	public static final String CONTAINER_OF_CANDIDATE_ELEMENT = "candidate_element.container";


	public BcexObjectChecker checkContainerOfCandidateElement(BaseEntity containerAsBaseEntity){

		if(containerAsBaseEntity == null){
			checkBaseEntityReference(containerAsBaseEntity,true,CONTAINER_OF_CANDIDATE_ELEMENT);
			return this;
		}
		checkAndFixCandidateContainer(containerAsBaseEntity);
		return this;
	}

	public BcexObjectChecker assignCreateTimeOfChangeRequest(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignRemoteIpOfChangeRequest(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"remoteIp",userContext.getRemoteIP());
		return this;
	}
	public BcexObjectChecker assignCreateTimeOfWechatUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignLastUpdateTimeOfWechatLoginInfo(BaseEntity targetEntity){
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"lastUpdateTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignCreateTimeOfExam(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignCreateTimeOfFaultAnswer(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignBlockingOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		return this;
	}
	public BcexObjectChecker assignCurrentStatusOfSecUser(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"currentStatus","INIT");
		return this;
	}
	public BcexObjectChecker assignBlockTimeOfSecUserBlocking(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"blockTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignCreateTimeOfQuickLink(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"createTime",userContext.now());
		return this;
	}
	public BcexObjectChecker assignLoginTimeOfLoginHistory(BaseEntity targetEntity){
		if(!isObjectForCreate(targetEntity)){
			return this;
		}
		if(userContext==null){
			return this;
		}
		setEntityProperty(targetEntity,"loginTime",userContext.now());
		return this;
	}

}

