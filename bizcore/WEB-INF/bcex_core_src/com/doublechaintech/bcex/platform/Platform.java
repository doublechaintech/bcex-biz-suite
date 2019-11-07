
package com.doublechaintech.bcex.platform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.bcex.BaseEntity;
import com.doublechaintech.bcex.SmartList;
import com.doublechaintech.bcex.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.bcex.examstatus.ExamStatus;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.examranking.ExamRanking;
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.question.Question;

@JsonSerialize(using = PlatformSerializer.class)
public class Platform extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CHANGE_REQUEST_TYPE_LIST                 = "changeRequestTypeList";
	public static final String CHANGE_REQUEST_LIST                      = "changeRequestList" ;
	public static final String EXAM_STATUS_LIST                         = "examStatusList"    ;
	public static final String QUESTION_LIST                            = "questionList"      ;
	public static final String EXAM_RANKING_LIST                        = "examRankingList"   ;
	public static final String WECHAT_USER_LIST                         = "wechatUserList"    ;

	public static final String INTERNAL_TYPE="Platform";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ChangeRequestType>	mChangeRequestTypeList;
	protected		SmartList<ChangeRequest>	mChangeRequestList  ;
	protected		SmartList<ExamStatus>	mExamStatusList     ;
	protected		SmartList<Question> 	mQuestionList       ;
	protected		SmartList<ExamRanking>	mExamRankingList    ;
	protected		SmartList<WechatUser>	mWechatUserList     ;
	
		
	public 	Platform(){
		// lazy load for all the properties
	}
	public 	static Platform withId(String id){
		Platform platform = new Platform();
		platform.setId(id);
		platform.setVersion(Integer.MAX_VALUE);
		return platform;
	}
	public 	static Platform refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	Platform(String name, String description)
	{
		setName(name);
		setDescription(description);

		this.mChangeRequestTypeList = new SmartList<ChangeRequestType>();
		this.mChangeRequestList = new SmartList<ChangeRequest>();
		this.mExamStatusList = new SmartList<ExamStatus>();
		this.mQuestionList = new SmartList<Question>();
		this.mExamRankingList = new SmartList<ExamRanking>();
		this.mWechatUserList = new SmartList<WechatUser>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(CHANGE_REQUEST_TYPE_LIST.equals(property)){
			List<BaseEntity> list = getChangeRequestTypeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CHANGE_REQUEST_LIST.equals(property)){
			List<BaseEntity> list = getChangeRequestList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EXAM_STATUS_LIST.equals(property)){
			List<BaseEntity> list = getExamStatusList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(QUESTION_LIST.equals(property)){
			List<BaseEntity> list = getQuestionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EXAM_RANKING_LIST.equals(property)){
			List<BaseEntity> list = getExamRankingList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WECHAT_USER_LIST.equals(property)){
			List<BaseEntity> list = getWechatUserList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Platform updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public Platform updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = description;;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public Platform updateDescription(String description){
		this.mDescription = description;;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Platform updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ChangeRequestType> getChangeRequestTypeList(){
		if(this.mChangeRequestTypeList == null){
			this.mChangeRequestTypeList = new SmartList<ChangeRequestType>();
			this.mChangeRequestTypeList.setListInternalName (CHANGE_REQUEST_TYPE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChangeRequestTypeList;	
	}
	public  void setChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		for( ChangeRequestType changeRequestType:changeRequestTypeList){
			changeRequestType.setPlatform(this);
		}

		this.mChangeRequestTypeList = changeRequestTypeList;
		this.mChangeRequestTypeList.setListInternalName (CHANGE_REQUEST_TYPE_LIST );
		
	}
	
	public  void addChangeRequestType(ChangeRequestType changeRequestType){
		changeRequestType.setPlatform(this);
		getChangeRequestTypeList().add(changeRequestType);
	}
	public  void addChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		for( ChangeRequestType changeRequestType:changeRequestTypeList){
			changeRequestType.setPlatform(this);
		}
		getChangeRequestTypeList().addAll(changeRequestTypeList);
	}
	public  void mergeChangeRequestTypeList(SmartList<ChangeRequestType> changeRequestTypeList){
		if(changeRequestTypeList==null){
			return;
		}
		if(changeRequestTypeList.isEmpty()){
			return;
		}
		addChangeRequestTypeList( changeRequestTypeList );
		
	}
	public  ChangeRequestType removeChangeRequestType(ChangeRequestType changeRequestTypeIndex){
		
		int index = getChangeRequestTypeList().indexOf(changeRequestTypeIndex);
        if(index < 0){
        	String message = "ChangeRequestType("+changeRequestTypeIndex.getId()+") with version='"+changeRequestTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChangeRequestType changeRequestType = getChangeRequestTypeList().get(index);        
        // changeRequestType.clearPlatform(); //disconnect with Platform
        changeRequestType.clearFromAll(); //disconnect with Platform
		
		boolean result = getChangeRequestTypeList().planToRemove(changeRequestType);
        if(!result){
        	String message = "ChangeRequestType("+changeRequestTypeIndex.getId()+") with version='"+changeRequestTypeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return changeRequestType;
        
	
	}
	//断舍离
	public  void breakWithChangeRequestType(ChangeRequestType changeRequestType){
		
		if(changeRequestType == null){
			return;
		}
		changeRequestType.setPlatform(null);
		//getChangeRequestTypeList().remove();
	
	}
	
	public  boolean hasChangeRequestType(ChangeRequestType changeRequestType){
	
		return getChangeRequestTypeList().contains(changeRequestType);
  
	}
	
	public void copyChangeRequestTypeFrom(ChangeRequestType changeRequestType) {

		ChangeRequestType changeRequestTypeInList = findTheChangeRequestType(changeRequestType);
		ChangeRequestType newChangeRequestType = new ChangeRequestType();
		changeRequestTypeInList.copyTo(newChangeRequestType);
		newChangeRequestType.setVersion(0);//will trigger copy
		getChangeRequestTypeList().add(newChangeRequestType);
		addItemToFlexiableObject(COPIED_CHILD, newChangeRequestType);
	}
	
	public  ChangeRequestType findTheChangeRequestType(ChangeRequestType changeRequestType){
		
		int index =  getChangeRequestTypeList().indexOf(changeRequestType);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChangeRequestType("+changeRequestType.getId()+") with version='"+changeRequestType.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChangeRequestTypeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChangeRequestTypeList(){
		getChangeRequestTypeList().clear();
	}
	
	
	


	public  SmartList<ChangeRequest> getChangeRequestList(){
		if(this.mChangeRequestList == null){
			this.mChangeRequestList = new SmartList<ChangeRequest>();
			this.mChangeRequestList.setListInternalName (CHANGE_REQUEST_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mChangeRequestList;	
	}
	public  void setChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		for( ChangeRequest changeRequest:changeRequestList){
			changeRequest.setPlatform(this);
		}

		this.mChangeRequestList = changeRequestList;
		this.mChangeRequestList.setListInternalName (CHANGE_REQUEST_LIST );
		
	}
	
	public  void addChangeRequest(ChangeRequest changeRequest){
		changeRequest.setPlatform(this);
		getChangeRequestList().add(changeRequest);
	}
	public  void addChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		for( ChangeRequest changeRequest:changeRequestList){
			changeRequest.setPlatform(this);
		}
		getChangeRequestList().addAll(changeRequestList);
	}
	public  void mergeChangeRequestList(SmartList<ChangeRequest> changeRequestList){
		if(changeRequestList==null){
			return;
		}
		if(changeRequestList.isEmpty()){
			return;
		}
		addChangeRequestList( changeRequestList );
		
	}
	public  ChangeRequest removeChangeRequest(ChangeRequest changeRequestIndex){
		
		int index = getChangeRequestList().indexOf(changeRequestIndex);
        if(index < 0){
        	String message = "ChangeRequest("+changeRequestIndex.getId()+") with version='"+changeRequestIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ChangeRequest changeRequest = getChangeRequestList().get(index);        
        // changeRequest.clearPlatform(); //disconnect with Platform
        changeRequest.clearFromAll(); //disconnect with Platform
		
		boolean result = getChangeRequestList().planToRemove(changeRequest);
        if(!result){
        	String message = "ChangeRequest("+changeRequestIndex.getId()+") with version='"+changeRequestIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return changeRequest;
        
	
	}
	//断舍离
	public  void breakWithChangeRequest(ChangeRequest changeRequest){
		
		if(changeRequest == null){
			return;
		}
		changeRequest.setPlatform(null);
		//getChangeRequestList().remove();
	
	}
	
	public  boolean hasChangeRequest(ChangeRequest changeRequest){
	
		return getChangeRequestList().contains(changeRequest);
  
	}
	
	public void copyChangeRequestFrom(ChangeRequest changeRequest) {

		ChangeRequest changeRequestInList = findTheChangeRequest(changeRequest);
		ChangeRequest newChangeRequest = new ChangeRequest();
		changeRequestInList.copyTo(newChangeRequest);
		newChangeRequest.setVersion(0);//will trigger copy
		getChangeRequestList().add(newChangeRequest);
		addItemToFlexiableObject(COPIED_CHILD, newChangeRequest);
	}
	
	public  ChangeRequest findTheChangeRequest(ChangeRequest changeRequest){
		
		int index =  getChangeRequestList().indexOf(changeRequest);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ChangeRequest("+changeRequest.getId()+") with version='"+changeRequest.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getChangeRequestList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpChangeRequestList(){
		getChangeRequestList().clear();
	}
	
	
	


	public  SmartList<ExamStatus> getExamStatusList(){
		if(this.mExamStatusList == null){
			this.mExamStatusList = new SmartList<ExamStatus>();
			this.mExamStatusList.setListInternalName (EXAM_STATUS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mExamStatusList;	
	}
	public  void setExamStatusList(SmartList<ExamStatus> examStatusList){
		for( ExamStatus examStatus:examStatusList){
			examStatus.setPlatform(this);
		}

		this.mExamStatusList = examStatusList;
		this.mExamStatusList.setListInternalName (EXAM_STATUS_LIST );
		
	}
	
	public  void addExamStatus(ExamStatus examStatus){
		examStatus.setPlatform(this);
		getExamStatusList().add(examStatus);
	}
	public  void addExamStatusList(SmartList<ExamStatus> examStatusList){
		for( ExamStatus examStatus:examStatusList){
			examStatus.setPlatform(this);
		}
		getExamStatusList().addAll(examStatusList);
	}
	public  void mergeExamStatusList(SmartList<ExamStatus> examStatusList){
		if(examStatusList==null){
			return;
		}
		if(examStatusList.isEmpty()){
			return;
		}
		addExamStatusList( examStatusList );
		
	}
	public  ExamStatus removeExamStatus(ExamStatus examStatusIndex){
		
		int index = getExamStatusList().indexOf(examStatusIndex);
        if(index < 0){
        	String message = "ExamStatus("+examStatusIndex.getId()+") with version='"+examStatusIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ExamStatus examStatus = getExamStatusList().get(index);        
        // examStatus.clearPlatform(); //disconnect with Platform
        examStatus.clearFromAll(); //disconnect with Platform
		
		boolean result = getExamStatusList().planToRemove(examStatus);
        if(!result){
        	String message = "ExamStatus("+examStatusIndex.getId()+") with version='"+examStatusIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return examStatus;
        
	
	}
	//断舍离
	public  void breakWithExamStatus(ExamStatus examStatus){
		
		if(examStatus == null){
			return;
		}
		examStatus.setPlatform(null);
		//getExamStatusList().remove();
	
	}
	
	public  boolean hasExamStatus(ExamStatus examStatus){
	
		return getExamStatusList().contains(examStatus);
  
	}
	
	public void copyExamStatusFrom(ExamStatus examStatus) {

		ExamStatus examStatusInList = findTheExamStatus(examStatus);
		ExamStatus newExamStatus = new ExamStatus();
		examStatusInList.copyTo(newExamStatus);
		newExamStatus.setVersion(0);//will trigger copy
		getExamStatusList().add(newExamStatus);
		addItemToFlexiableObject(COPIED_CHILD, newExamStatus);
	}
	
	public  ExamStatus findTheExamStatus(ExamStatus examStatus){
		
		int index =  getExamStatusList().indexOf(examStatus);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ExamStatus("+examStatus.getId()+") with version='"+examStatus.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getExamStatusList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpExamStatusList(){
		getExamStatusList().clear();
	}
	
	
	


	public  SmartList<Question> getQuestionList(){
		if(this.mQuestionList == null){
			this.mQuestionList = new SmartList<Question>();
			this.mQuestionList.setListInternalName (QUESTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mQuestionList;	
	}
	public  void setQuestionList(SmartList<Question> questionList){
		for( Question question:questionList){
			question.setPlatform(this);
		}

		this.mQuestionList = questionList;
		this.mQuestionList.setListInternalName (QUESTION_LIST );
		
	}
	
	public  void addQuestion(Question question){
		question.setPlatform(this);
		getQuestionList().add(question);
	}
	public  void addQuestionList(SmartList<Question> questionList){
		for( Question question:questionList){
			question.setPlatform(this);
		}
		getQuestionList().addAll(questionList);
	}
	public  void mergeQuestionList(SmartList<Question> questionList){
		if(questionList==null){
			return;
		}
		if(questionList.isEmpty()){
			return;
		}
		addQuestionList( questionList );
		
	}
	public  Question removeQuestion(Question questionIndex){
		
		int index = getQuestionList().indexOf(questionIndex);
        if(index < 0){
        	String message = "Question("+questionIndex.getId()+") with version='"+questionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Question question = getQuestionList().get(index);        
        // question.clearPlatform(); //disconnect with Platform
        question.clearFromAll(); //disconnect with Platform
		
		boolean result = getQuestionList().planToRemove(question);
        if(!result){
        	String message = "Question("+questionIndex.getId()+") with version='"+questionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return question;
        
	
	}
	//断舍离
	public  void breakWithQuestion(Question question){
		
		if(question == null){
			return;
		}
		question.setPlatform(null);
		//getQuestionList().remove();
	
	}
	
	public  boolean hasQuestion(Question question){
	
		return getQuestionList().contains(question);
  
	}
	
	public void copyQuestionFrom(Question question) {

		Question questionInList = findTheQuestion(question);
		Question newQuestion = new Question();
		questionInList.copyTo(newQuestion);
		newQuestion.setVersion(0);//will trigger copy
		getQuestionList().add(newQuestion);
		addItemToFlexiableObject(COPIED_CHILD, newQuestion);
	}
	
	public  Question findTheQuestion(Question question){
		
		int index =  getQuestionList().indexOf(question);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Question("+question.getId()+") with version='"+question.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getQuestionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpQuestionList(){
		getQuestionList().clear();
	}
	
	
	


	public  SmartList<ExamRanking> getExamRankingList(){
		if(this.mExamRankingList == null){
			this.mExamRankingList = new SmartList<ExamRanking>();
			this.mExamRankingList.setListInternalName (EXAM_RANKING_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mExamRankingList;	
	}
	public  void setExamRankingList(SmartList<ExamRanking> examRankingList){
		for( ExamRanking examRanking:examRankingList){
			examRanking.setPlatform(this);
		}

		this.mExamRankingList = examRankingList;
		this.mExamRankingList.setListInternalName (EXAM_RANKING_LIST );
		
	}
	
	public  void addExamRanking(ExamRanking examRanking){
		examRanking.setPlatform(this);
		getExamRankingList().add(examRanking);
	}
	public  void addExamRankingList(SmartList<ExamRanking> examRankingList){
		for( ExamRanking examRanking:examRankingList){
			examRanking.setPlatform(this);
		}
		getExamRankingList().addAll(examRankingList);
	}
	public  void mergeExamRankingList(SmartList<ExamRanking> examRankingList){
		if(examRankingList==null){
			return;
		}
		if(examRankingList.isEmpty()){
			return;
		}
		addExamRankingList( examRankingList );
		
	}
	public  ExamRanking removeExamRanking(ExamRanking examRankingIndex){
		
		int index = getExamRankingList().indexOf(examRankingIndex);
        if(index < 0){
        	String message = "ExamRanking("+examRankingIndex.getId()+") with version='"+examRankingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ExamRanking examRanking = getExamRankingList().get(index);        
        // examRanking.clearPlatform(); //disconnect with Platform
        examRanking.clearFromAll(); //disconnect with Platform
		
		boolean result = getExamRankingList().planToRemove(examRanking);
        if(!result){
        	String message = "ExamRanking("+examRankingIndex.getId()+") with version='"+examRankingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return examRanking;
        
	
	}
	//断舍离
	public  void breakWithExamRanking(ExamRanking examRanking){
		
		if(examRanking == null){
			return;
		}
		examRanking.setPlatform(null);
		//getExamRankingList().remove();
	
	}
	
	public  boolean hasExamRanking(ExamRanking examRanking){
	
		return getExamRankingList().contains(examRanking);
  
	}
	
	public void copyExamRankingFrom(ExamRanking examRanking) {

		ExamRanking examRankingInList = findTheExamRanking(examRanking);
		ExamRanking newExamRanking = new ExamRanking();
		examRankingInList.copyTo(newExamRanking);
		newExamRanking.setVersion(0);//will trigger copy
		getExamRankingList().add(newExamRanking);
		addItemToFlexiableObject(COPIED_CHILD, newExamRanking);
	}
	
	public  ExamRanking findTheExamRanking(ExamRanking examRanking){
		
		int index =  getExamRankingList().indexOf(examRanking);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ExamRanking("+examRanking.getId()+") with version='"+examRanking.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getExamRankingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpExamRankingList(){
		getExamRankingList().clear();
	}
	
	
	


	public  SmartList<WechatUser> getWechatUserList(){
		if(this.mWechatUserList == null){
			this.mWechatUserList = new SmartList<WechatUser>();
			this.mWechatUserList.setListInternalName (WECHAT_USER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mWechatUserList;	
	}
	public  void setWechatUserList(SmartList<WechatUser> wechatUserList){
		for( WechatUser wechatUser:wechatUserList){
			wechatUser.setPlatform(this);
		}

		this.mWechatUserList = wechatUserList;
		this.mWechatUserList.setListInternalName (WECHAT_USER_LIST );
		
	}
	
	public  void addWechatUser(WechatUser wechatUser){
		wechatUser.setPlatform(this);
		getWechatUserList().add(wechatUser);
	}
	public  void addWechatUserList(SmartList<WechatUser> wechatUserList){
		for( WechatUser wechatUser:wechatUserList){
			wechatUser.setPlatform(this);
		}
		getWechatUserList().addAll(wechatUserList);
	}
	public  void mergeWechatUserList(SmartList<WechatUser> wechatUserList){
		if(wechatUserList==null){
			return;
		}
		if(wechatUserList.isEmpty()){
			return;
		}
		addWechatUserList( wechatUserList );
		
	}
	public  WechatUser removeWechatUser(WechatUser wechatUserIndex){
		
		int index = getWechatUserList().indexOf(wechatUserIndex);
        if(index < 0){
        	String message = "WechatUser("+wechatUserIndex.getId()+") with version='"+wechatUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        WechatUser wechatUser = getWechatUserList().get(index);        
        // wechatUser.clearPlatform(); //disconnect with Platform
        wechatUser.clearFromAll(); //disconnect with Platform
		
		boolean result = getWechatUserList().planToRemove(wechatUser);
        if(!result){
        	String message = "WechatUser("+wechatUserIndex.getId()+") with version='"+wechatUserIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return wechatUser;
        
	
	}
	//断舍离
	public  void breakWithWechatUser(WechatUser wechatUser){
		
		if(wechatUser == null){
			return;
		}
		wechatUser.setPlatform(null);
		//getWechatUserList().remove();
	
	}
	
	public  boolean hasWechatUser(WechatUser wechatUser){
	
		return getWechatUserList().contains(wechatUser);
  
	}
	
	public void copyWechatUserFrom(WechatUser wechatUser) {

		WechatUser wechatUserInList = findTheWechatUser(wechatUser);
		WechatUser newWechatUser = new WechatUser();
		wechatUserInList.copyTo(newWechatUser);
		newWechatUser.setVersion(0);//will trigger copy
		getWechatUserList().add(newWechatUser);
		addItemToFlexiableObject(COPIED_CHILD, newWechatUser);
	}
	
	public  WechatUser findTheWechatUser(WechatUser wechatUser){
		
		int index =  getWechatUserList().indexOf(wechatUser);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "WechatUser("+wechatUser.getId()+") with version='"+wechatUser.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getWechatUserList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWechatUserList(){
		getWechatUserList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getChangeRequestTypeList(), internalType);
		collectFromList(this, entityList, getChangeRequestList(), internalType);
		collectFromList(this, entityList, getExamStatusList(), internalType);
		collectFromList(this, entityList, getQuestionList(), internalType);
		collectFromList(this, entityList, getExamRankingList(), internalType);
		collectFromList(this, entityList, getWechatUserList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getChangeRequestTypeList());
		listOfList.add( getChangeRequestList());
		listOfList.add( getExamStatusList());
		listOfList.add( getQuestionList());
		listOfList.add( getExamRankingList());
		listOfList.add( getWechatUserList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CHANGE_REQUEST_TYPE_LIST, getChangeRequestTypeList());
		if(!getChangeRequestTypeList().isEmpty()){
			appendKeyValuePair(result, "changeRequestTypeCount", getChangeRequestTypeList().getTotalCount());
			appendKeyValuePair(result, "changeRequestTypeCurrentPageNumber", getChangeRequestTypeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CHANGE_REQUEST_LIST, getChangeRequestList());
		if(!getChangeRequestList().isEmpty()){
			appendKeyValuePair(result, "changeRequestCount", getChangeRequestList().getTotalCount());
			appendKeyValuePair(result, "changeRequestCurrentPageNumber", getChangeRequestList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EXAM_STATUS_LIST, getExamStatusList());
		if(!getExamStatusList().isEmpty()){
			appendKeyValuePair(result, "examStatusCount", getExamStatusList().getTotalCount());
			appendKeyValuePair(result, "examStatusCurrentPageNumber", getExamStatusList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, QUESTION_LIST, getQuestionList());
		if(!getQuestionList().isEmpty()){
			appendKeyValuePair(result, "questionCount", getQuestionList().getTotalCount());
			appendKeyValuePair(result, "questionCurrentPageNumber", getQuestionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EXAM_RANKING_LIST, getExamRankingList());
		if(!getExamRankingList().isEmpty()){
			appendKeyValuePair(result, "examRankingCount", getExamRankingList().getTotalCount());
			appendKeyValuePair(result, "examRankingCurrentPageNumber", getExamRankingList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WECHAT_USER_LIST, getWechatUserList());
		if(!getWechatUserList().isEmpty()){
			appendKeyValuePair(result, "wechatUserCount", getWechatUserList().getTotalCount());
			appendKeyValuePair(result, "wechatUserCurrentPageNumber", getWechatUserList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
		
			Platform dest =(Platform)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setChangeRequestTypeList(getChangeRequestTypeList());
			dest.setChangeRequestList(getChangeRequestList());
			dest.setExamStatusList(getExamStatusList());
			dest.setQuestionList(getQuestionList());
			dest.setExamRankingList(getExamRankingList());
			dest.setWechatUserList(getWechatUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergeChangeRequestTypeList(getChangeRequestTypeList());
			dest.mergeChangeRequestList(getChangeRequestList());
			dest.mergeExamStatusList(getExamStatusList());
			dest.mergeQuestionList(getQuestionList());
			dest.mergeExamRankingList(getExamRankingList());
			dest.mergeWechatUserList(getWechatUserList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Platform){
		
			
			Platform dest =(Platform)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Platform{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

