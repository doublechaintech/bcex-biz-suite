
package com.doublechaintech.bcex;
import java.util.HashMap;
import java.util.Map;

public class CustomRelation extends BaseRelation{

	protected void prepareRelation()
	{
		super.prepareRelation();
		//Uncomment to make any change to the relation type
		//replaceGenericRelation("ChangeRequestType"                     , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("ChangeRequest"                         , BaseRelation.TRUST_CHAIN_ALL, "requestType");
		//replaceGenericRelation("ChangeRequest"                         , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Registration"                          , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("StartExam"                             , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("AnswerQuestion"                        , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("AnswerQuestion"                        , BaseRelation.TRUST_CHAIN_ALL, "question");
		//replaceGenericRelation("AnswerQuestion"                        , BaseRelation.TRUST_CHAIN_ALL, "changeRequest");
		//replaceGenericRelation("ExamStatus"                            , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Question"                              , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("ExamRanking"                           , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("Answer"                                , BaseRelation.TRUST_CHAIN_ALL, "question");
		//replaceGenericRelation("WechatUser"                            , BaseRelation.TRUST_CHAIN_ALL, "platform");
		//replaceGenericRelation("WechatLoginInfo"                       , BaseRelation.TRUST_CHAIN_ALL, "wechatUser");
		//replaceGenericRelation("Exam"                                  , BaseRelation.TRUST_CHAIN_ALL, "status");
		//replaceGenericRelation("Exam"                                  , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("UserAnswer"                            , BaseRelation.TRUST_CHAIN_ALL, "question");
		//replaceGenericRelation("UserAnswer"                            , BaseRelation.TRUST_CHAIN_ALL, "exam");
		//replaceGenericRelation("FaultAnswer"                           , BaseRelation.TRUST_CHAIN_ALL, "user");
		//replaceGenericRelation("FaultAnswer"                           , BaseRelation.TRUST_CHAIN_ALL, "exam");
		//replaceGenericRelation("UserWhiteList"                         , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("SecUser"                               , BaseRelation.TRUST_CHAIN_ALL, "domain");
		//replaceGenericRelation("UserApp"                               , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("QuickLink"                             , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ListAccess"                            , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("ObjectAccess"                          , BaseRelation.TRUST_CHAIN_ALL, "app");
		//replaceGenericRelation("LoginHistory"                          , BaseRelation.TRUST_CHAIN_ALL, "secUser");
		//replaceGenericRelation("FormMessage"                           , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormFieldMessage"                      , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormField"                             , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("FormAction"                            , BaseRelation.TRUST_CHAIN_ALL, "form");
		//replaceGenericRelation("CandidateElement"                      , BaseRelation.TRUST_CHAIN_ALL, "container");

	}
	
	protected void prepareRelationIndex()
	{
		super.prepareRelationIndex();
		/*
		
		Note: you could delete some of the possible relations if you do not want it.
		Just uncomment the definition line and replaceRelationIndex line to replace existing one.
		
		*/
		//String [] changeRequestTypeRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("ChangeRequestType",changeRequestTypeRelatedObjectNames);

		//String [] changeRequestRelatedObjectNames = {"request_type:ChangeRequestType","platform:Platform"};
		//replaceRelationIndex("ChangeRequest",changeRequestRelatedObjectNames);

		//String [] registrationRelatedObjectNames = {"change_request:ChangeRequest"};
		//replaceRelationIndex("Registration",registrationRelatedObjectNames);

		//String [] startExamRelatedObjectNames = {"change_request:ChangeRequest"};
		//replaceRelationIndex("StartExam",startExamRelatedObjectNames);

		//String [] answerQuestionRelatedObjectNames = {"user:WechatUser","question:Question","change_request:ChangeRequest"};
		//replaceRelationIndex("AnswerQuestion",answerQuestionRelatedObjectNames);

		//String [] examStatusRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("ExamStatus",examStatusRelatedObjectNames);

		//String [] questionRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("Question",questionRelatedObjectNames);

		//String [] examRankingRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("ExamRanking",examRankingRelatedObjectNames);

		//String [] answerRelatedObjectNames = {"question:Question"};
		//replaceRelationIndex("Answer",answerRelatedObjectNames);

		//String [] wechatUserRelatedObjectNames = {"platform:Platform"};
		//replaceRelationIndex("WechatUser",wechatUserRelatedObjectNames);

		//String [] wechatLoginInfoRelatedObjectNames = {"wechat_user:WechatUser"};
		//replaceRelationIndex("WechatLoginInfo",wechatLoginInfoRelatedObjectNames);

		//String [] examRelatedObjectNames = {"status:ExamStatus","user:WechatUser"};
		//replaceRelationIndex("Exam",examRelatedObjectNames);

		//String [] userAnswerRelatedObjectNames = {"question:Question","exam:Exam"};
		//replaceRelationIndex("UserAnswer",userAnswerRelatedObjectNames);

		//String [] faultAnswerRelatedObjectNames = {"user:WechatUser","exam:Exam"};
		//replaceRelationIndex("FaultAnswer",faultAnswerRelatedObjectNames);

		//String [] userWhiteListRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("UserWhiteList",userWhiteListRelatedObjectNames);

		//String [] secUserRelatedObjectNames = {"domain:UserDomain"};
		//replaceRelationIndex("SecUser",secUserRelatedObjectNames);

		//String [] userAppRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("UserApp",userAppRelatedObjectNames);

		//String [] quickLinkRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("QuickLink",quickLinkRelatedObjectNames);

		//String [] listAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ListAccess",listAccessRelatedObjectNames);

		//String [] objectAccessRelatedObjectNames = {"app:UserApp"};
		//replaceRelationIndex("ObjectAccess",objectAccessRelatedObjectNames);

		//String [] loginHistoryRelatedObjectNames = {"sec_user:SecUser"};
		//replaceRelationIndex("LoginHistory",loginHistoryRelatedObjectNames);

		//String [] formMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormMessage",formMessageRelatedObjectNames);

		//String [] formFieldMessageRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormFieldMessage",formFieldMessageRelatedObjectNames);

		//String [] formFieldRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormField",formFieldRelatedObjectNames);

		//String [] formActionRelatedObjectNames = {"form:GenericForm"};
		//replaceRelationIndex("FormAction",formActionRelatedObjectNames);

		//String [] candidateElementRelatedObjectNames = {"container:CandidateContainer"};
		//replaceRelationIndex("CandidateElement",candidateElementRelatedObjectNames);

		
		
	
	}
	
	
	@Override
	public String getRelation(String fromType, String fromId, String targetField, String targetId)
	{

		String relation = super.getRelation(fromType, fromId, targetField, targetId);
		if(relation == null){
			throw new IllegalArgumentException("Not able to find any relation to the target type: "+ targetField);
		}
		return relation;
		
	}

}










