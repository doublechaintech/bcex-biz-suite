
package com.doublechaintech.bcex.wechatuser;

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
import com.doublechaintech.bcex.wechatlogininfo.WechatLoginInfo;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.exam.Exam;

@JsonSerialize(using = WechatUserSerializer.class)
public class WechatUser extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String AVARTA_PROPERTY                = "avarta"            ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String USER_TYPE_PROPERTY             = "userType"          ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String START_EXAM_LIST                          = "startExamList"     ;
	public static final String ANSWER_QUESTION_LIST                     = "answerQuestionList";
	public static final String WECHAT_LOGIN_INFO_LIST                   = "wechatLoginInfoList";
	public static final String EXAM_LIST                                = "examList"          ;
	public static final String FAULT_ANSWER_LIST                        = "faultAnswerList"   ;

	public static final String INTERNAL_TYPE="WechatUser";
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
	protected		String              	mAvarta             ;
	protected		DateTime            	mCreateTime         ;
	protected		String              	mUserType           ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<StartExam>	mStartExamList      ;
	protected		SmartList<AnswerQuestion>	mAnswerQuestionList ;
	protected		SmartList<WechatLoginInfo>	mWechatLoginInfoList;
	protected		SmartList<Exam>     	mExamList           ;
	protected		SmartList<FaultAnswer>	mFaultAnswerList    ;
	
		
	public 	WechatUser(){
		// lazy load for all the properties
	}
	public 	static WechatUser withId(String id){
		WechatUser wechatUser = new WechatUser();
		wechatUser.setId(id);
		wechatUser.setVersion(Integer.MAX_VALUE);
		return wechatUser;
	}
	public 	static WechatUser refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	WechatUser(String name, String avarta, DateTime createTime, String userType, Platform platform)
	{
		setName(name);
		setAvarta(avarta);
		setCreateTime(createTime);
		setUserType(userType);
		setPlatform(platform);

		this.mStartExamList = new SmartList<StartExam>();
		this.mAnswerQuestionList = new SmartList<AnswerQuestion>();
		this.mWechatLoginInfoList = new SmartList<WechatLoginInfo>();
		this.mExamList = new SmartList<Exam>();
		this.mFaultAnswerList = new SmartList<FaultAnswer>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(AVARTA_PROPERTY.equals(property)){
			changeAvartaProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(USER_TYPE_PROPERTY.equals(property)){
			changeUserTypeProperty(newValueExpr);
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
			
			
			
	protected void changeAvartaProperty(String newValueExpr){
		String oldValue = getAvarta();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAvarta(newValue);
		this.onChangeProperty(AVARTA_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeUserTypeProperty(String newValueExpr){
		String oldValue = getUserType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserType(newValue);
		this.onChangeProperty(USER_TYPE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(AVARTA_PROPERTY.equals(property)){
			return getAvarta();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(USER_TYPE_PROPERTY.equals(property)){
			return getUserType();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
		}
		if(START_EXAM_LIST.equals(property)){
			List<BaseEntity> list = getStartExamList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ANSWER_QUESTION_LIST.equals(property)){
			List<BaseEntity> list = getAnswerQuestionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WECHAT_LOGIN_INFO_LIST.equals(property)){
			List<BaseEntity> list = getWechatLoginInfoList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EXAM_LIST.equals(property)){
			List<BaseEntity> list = getExamList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(FAULT_ANSWER_LIST.equals(property)){
			List<BaseEntity> list = getFaultAnswerList().stream().map(item->item).collect(Collectors.toList());
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
	public WechatUser updateId(String id){
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
	public WechatUser updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setAvarta(String avarta){
		this.mAvarta = trimString(encodeUrl(avarta));;
	}
	public String getAvarta(){
		return this.mAvarta;
	}
	public WechatUser updateAvarta(String avarta){
		this.mAvarta = trimString(encodeUrl(avarta));;
		this.changed = true;
		return this;
	}
	public void mergeAvarta(String avarta){
		if(avarta != null) { setAvarta(avarta);}
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public WechatUser updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setUserType(String userType){
		this.mUserType = trimString(userType);;
	}
	public String getUserType(){
		return this.mUserType;
	}
	public WechatUser updateUserType(String userType){
		this.mUserType = trimString(userType);;
		this.changed = true;
		return this;
	}
	public void mergeUserType(String userType){
		if(userType != null) { setUserType(userType);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public WechatUser updatePlatform(Platform platform){
		this.mPlatform = platform;;
		this.changed = true;
		return this;
	}
	public void mergePlatform(Platform platform){
		if(platform != null) { setPlatform(platform);}
	}
	
	
	public void clearPlatform(){
		setPlatform ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public WechatUser updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<StartExam> getStartExamList(){
		if(this.mStartExamList == null){
			this.mStartExamList = new SmartList<StartExam>();
			this.mStartExamList.setListInternalName (START_EXAM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mStartExamList;	
	}
	public  void setStartExamList(SmartList<StartExam> startExamList){
		for( StartExam startExam:startExamList){
			startExam.setUser(this);
		}

		this.mStartExamList = startExamList;
		this.mStartExamList.setListInternalName (START_EXAM_LIST );
		
	}
	
	public  void addStartExam(StartExam startExam){
		startExam.setUser(this);
		getStartExamList().add(startExam);
	}
	public  void addStartExamList(SmartList<StartExam> startExamList){
		for( StartExam startExam:startExamList){
			startExam.setUser(this);
		}
		getStartExamList().addAll(startExamList);
	}
	public  void mergeStartExamList(SmartList<StartExam> startExamList){
		if(startExamList==null){
			return;
		}
		if(startExamList.isEmpty()){
			return;
		}
		addStartExamList( startExamList );
		
	}
	public  StartExam removeStartExam(StartExam startExamIndex){
		
		int index = getStartExamList().indexOf(startExamIndex);
        if(index < 0){
        	String message = "StartExam("+startExamIndex.getId()+") with version='"+startExamIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        StartExam startExam = getStartExamList().get(index);        
        // startExam.clearUser(); //disconnect with User
        startExam.clearFromAll(); //disconnect with User
		
		boolean result = getStartExamList().planToRemove(startExam);
        if(!result){
        	String message = "StartExam("+startExamIndex.getId()+") with version='"+startExamIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return startExam;
        
	
	}
	//断舍离
	public  void breakWithStartExam(StartExam startExam){
		
		if(startExam == null){
			return;
		}
		startExam.setUser(null);
		//getStartExamList().remove();
	
	}
	
	public  boolean hasStartExam(StartExam startExam){
	
		return getStartExamList().contains(startExam);
  
	}
	
	public void copyStartExamFrom(StartExam startExam) {

		StartExam startExamInList = findTheStartExam(startExam);
		StartExam newStartExam = new StartExam();
		startExamInList.copyTo(newStartExam);
		newStartExam.setVersion(0);//will trigger copy
		getStartExamList().add(newStartExam);
		addItemToFlexiableObject(COPIED_CHILD, newStartExam);
	}
	
	public  StartExam findTheStartExam(StartExam startExam){
		
		int index =  getStartExamList().indexOf(startExam);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "StartExam("+startExam.getId()+") with version='"+startExam.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getStartExamList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpStartExamList(){
		getStartExamList().clear();
	}
	
	
	


	public  SmartList<AnswerQuestion> getAnswerQuestionList(){
		if(this.mAnswerQuestionList == null){
			this.mAnswerQuestionList = new SmartList<AnswerQuestion>();
			this.mAnswerQuestionList.setListInternalName (ANSWER_QUESTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAnswerQuestionList;	
	}
	public  void setAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		for( AnswerQuestion answerQuestion:answerQuestionList){
			answerQuestion.setUser(this);
		}

		this.mAnswerQuestionList = answerQuestionList;
		this.mAnswerQuestionList.setListInternalName (ANSWER_QUESTION_LIST );
		
	}
	
	public  void addAnswerQuestion(AnswerQuestion answerQuestion){
		answerQuestion.setUser(this);
		getAnswerQuestionList().add(answerQuestion);
	}
	public  void addAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		for( AnswerQuestion answerQuestion:answerQuestionList){
			answerQuestion.setUser(this);
		}
		getAnswerQuestionList().addAll(answerQuestionList);
	}
	public  void mergeAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		if(answerQuestionList==null){
			return;
		}
		if(answerQuestionList.isEmpty()){
			return;
		}
		addAnswerQuestionList( answerQuestionList );
		
	}
	public  AnswerQuestion removeAnswerQuestion(AnswerQuestion answerQuestionIndex){
		
		int index = getAnswerQuestionList().indexOf(answerQuestionIndex);
        if(index < 0){
        	String message = "AnswerQuestion("+answerQuestionIndex.getId()+") with version='"+answerQuestionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AnswerQuestion answerQuestion = getAnswerQuestionList().get(index);        
        // answerQuestion.clearUser(); //disconnect with User
        answerQuestion.clearFromAll(); //disconnect with User
		
		boolean result = getAnswerQuestionList().planToRemove(answerQuestion);
        if(!result){
        	String message = "AnswerQuestion("+answerQuestionIndex.getId()+") with version='"+answerQuestionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return answerQuestion;
        
	
	}
	//断舍离
	public  void breakWithAnswerQuestion(AnswerQuestion answerQuestion){
		
		if(answerQuestion == null){
			return;
		}
		answerQuestion.setUser(null);
		//getAnswerQuestionList().remove();
	
	}
	
	public  boolean hasAnswerQuestion(AnswerQuestion answerQuestion){
	
		return getAnswerQuestionList().contains(answerQuestion);
  
	}
	
	public void copyAnswerQuestionFrom(AnswerQuestion answerQuestion) {

		AnswerQuestion answerQuestionInList = findTheAnswerQuestion(answerQuestion);
		AnswerQuestion newAnswerQuestion = new AnswerQuestion();
		answerQuestionInList.copyTo(newAnswerQuestion);
		newAnswerQuestion.setVersion(0);//will trigger copy
		getAnswerQuestionList().add(newAnswerQuestion);
		addItemToFlexiableObject(COPIED_CHILD, newAnswerQuestion);
	}
	
	public  AnswerQuestion findTheAnswerQuestion(AnswerQuestion answerQuestion){
		
		int index =  getAnswerQuestionList().indexOf(answerQuestion);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AnswerQuestion("+answerQuestion.getId()+") with version='"+answerQuestion.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAnswerQuestionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAnswerQuestionList(){
		getAnswerQuestionList().clear();
	}
	
	
	


	public  SmartList<WechatLoginInfo> getWechatLoginInfoList(){
		if(this.mWechatLoginInfoList == null){
			this.mWechatLoginInfoList = new SmartList<WechatLoginInfo>();
			this.mWechatLoginInfoList.setListInternalName (WECHAT_LOGIN_INFO_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mWechatLoginInfoList;	
	}
	public  void setWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList){
		for( WechatLoginInfo wechatLoginInfo:wechatLoginInfoList){
			wechatLoginInfo.setWechatUser(this);
		}

		this.mWechatLoginInfoList = wechatLoginInfoList;
		this.mWechatLoginInfoList.setListInternalName (WECHAT_LOGIN_INFO_LIST );
		
	}
	
	public  void addWechatLoginInfo(WechatLoginInfo wechatLoginInfo){
		wechatLoginInfo.setWechatUser(this);
		getWechatLoginInfoList().add(wechatLoginInfo);
	}
	public  void addWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList){
		for( WechatLoginInfo wechatLoginInfo:wechatLoginInfoList){
			wechatLoginInfo.setWechatUser(this);
		}
		getWechatLoginInfoList().addAll(wechatLoginInfoList);
	}
	public  void mergeWechatLoginInfoList(SmartList<WechatLoginInfo> wechatLoginInfoList){
		if(wechatLoginInfoList==null){
			return;
		}
		if(wechatLoginInfoList.isEmpty()){
			return;
		}
		addWechatLoginInfoList( wechatLoginInfoList );
		
	}
	public  WechatLoginInfo removeWechatLoginInfo(WechatLoginInfo wechatLoginInfoIndex){
		
		int index = getWechatLoginInfoList().indexOf(wechatLoginInfoIndex);
        if(index < 0){
        	String message = "WechatLoginInfo("+wechatLoginInfoIndex.getId()+") with version='"+wechatLoginInfoIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        WechatLoginInfo wechatLoginInfo = getWechatLoginInfoList().get(index);        
        // wechatLoginInfo.clearWechatUser(); //disconnect with WechatUser
        wechatLoginInfo.clearFromAll(); //disconnect with WechatUser
		
		boolean result = getWechatLoginInfoList().planToRemove(wechatLoginInfo);
        if(!result){
        	String message = "WechatLoginInfo("+wechatLoginInfoIndex.getId()+") with version='"+wechatLoginInfoIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return wechatLoginInfo;
        
	
	}
	//断舍离
	public  void breakWithWechatLoginInfo(WechatLoginInfo wechatLoginInfo){
		
		if(wechatLoginInfo == null){
			return;
		}
		wechatLoginInfo.setWechatUser(null);
		//getWechatLoginInfoList().remove();
	
	}
	
	public  boolean hasWechatLoginInfo(WechatLoginInfo wechatLoginInfo){
	
		return getWechatLoginInfoList().contains(wechatLoginInfo);
  
	}
	
	public void copyWechatLoginInfoFrom(WechatLoginInfo wechatLoginInfo) {

		WechatLoginInfo wechatLoginInfoInList = findTheWechatLoginInfo(wechatLoginInfo);
		WechatLoginInfo newWechatLoginInfo = new WechatLoginInfo();
		wechatLoginInfoInList.copyTo(newWechatLoginInfo);
		newWechatLoginInfo.setVersion(0);//will trigger copy
		getWechatLoginInfoList().add(newWechatLoginInfo);
		addItemToFlexiableObject(COPIED_CHILD, newWechatLoginInfo);
	}
	
	public  WechatLoginInfo findTheWechatLoginInfo(WechatLoginInfo wechatLoginInfo){
		
		int index =  getWechatLoginInfoList().indexOf(wechatLoginInfo);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "WechatLoginInfo("+wechatLoginInfo.getId()+") with version='"+wechatLoginInfo.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getWechatLoginInfoList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWechatLoginInfoList(){
		getWechatLoginInfoList().clear();
	}
	
	
	


	public  SmartList<Exam> getExamList(){
		if(this.mExamList == null){
			this.mExamList = new SmartList<Exam>();
			this.mExamList.setListInternalName (EXAM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mExamList;	
	}
	public  void setExamList(SmartList<Exam> examList){
		for( Exam exam:examList){
			exam.setUser(this);
		}

		this.mExamList = examList;
		this.mExamList.setListInternalName (EXAM_LIST );
		
	}
	
	public  void addExam(Exam exam){
		exam.setUser(this);
		getExamList().add(exam);
	}
	public  void addExamList(SmartList<Exam> examList){
		for( Exam exam:examList){
			exam.setUser(this);
		}
		getExamList().addAll(examList);
	}
	public  void mergeExamList(SmartList<Exam> examList){
		if(examList==null){
			return;
		}
		if(examList.isEmpty()){
			return;
		}
		addExamList( examList );
		
	}
	public  Exam removeExam(Exam examIndex){
		
		int index = getExamList().indexOf(examIndex);
        if(index < 0){
        	String message = "Exam("+examIndex.getId()+") with version='"+examIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Exam exam = getExamList().get(index);        
        // exam.clearUser(); //disconnect with User
        exam.clearFromAll(); //disconnect with User
		
		boolean result = getExamList().planToRemove(exam);
        if(!result){
        	String message = "Exam("+examIndex.getId()+") with version='"+examIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return exam;
        
	
	}
	//断舍离
	public  void breakWithExam(Exam exam){
		
		if(exam == null){
			return;
		}
		exam.setUser(null);
		//getExamList().remove();
	
	}
	
	public  boolean hasExam(Exam exam){
	
		return getExamList().contains(exam);
  
	}
	
	public void copyExamFrom(Exam exam) {

		Exam examInList = findTheExam(exam);
		Exam newExam = new Exam();
		examInList.copyTo(newExam);
		newExam.setVersion(0);//will trigger copy
		getExamList().add(newExam);
		addItemToFlexiableObject(COPIED_CHILD, newExam);
	}
	
	public  Exam findTheExam(Exam exam){
		
		int index =  getExamList().indexOf(exam);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Exam("+exam.getId()+") with version='"+exam.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getExamList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpExamList(){
		getExamList().clear();
	}
	
	
	


	public  SmartList<FaultAnswer> getFaultAnswerList(){
		if(this.mFaultAnswerList == null){
			this.mFaultAnswerList = new SmartList<FaultAnswer>();
			this.mFaultAnswerList.setListInternalName (FAULT_ANSWER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mFaultAnswerList;	
	}
	public  void setFaultAnswerList(SmartList<FaultAnswer> faultAnswerList){
		for( FaultAnswer faultAnswer:faultAnswerList){
			faultAnswer.setUser(this);
		}

		this.mFaultAnswerList = faultAnswerList;
		this.mFaultAnswerList.setListInternalName (FAULT_ANSWER_LIST );
		
	}
	
	public  void addFaultAnswer(FaultAnswer faultAnswer){
		faultAnswer.setUser(this);
		getFaultAnswerList().add(faultAnswer);
	}
	public  void addFaultAnswerList(SmartList<FaultAnswer> faultAnswerList){
		for( FaultAnswer faultAnswer:faultAnswerList){
			faultAnswer.setUser(this);
		}
		getFaultAnswerList().addAll(faultAnswerList);
	}
	public  void mergeFaultAnswerList(SmartList<FaultAnswer> faultAnswerList){
		if(faultAnswerList==null){
			return;
		}
		if(faultAnswerList.isEmpty()){
			return;
		}
		addFaultAnswerList( faultAnswerList );
		
	}
	public  FaultAnswer removeFaultAnswer(FaultAnswer faultAnswerIndex){
		
		int index = getFaultAnswerList().indexOf(faultAnswerIndex);
        if(index < 0){
        	String message = "FaultAnswer("+faultAnswerIndex.getId()+") with version='"+faultAnswerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        FaultAnswer faultAnswer = getFaultAnswerList().get(index);        
        // faultAnswer.clearUser(); //disconnect with User
        faultAnswer.clearFromAll(); //disconnect with User
		
		boolean result = getFaultAnswerList().planToRemove(faultAnswer);
        if(!result){
        	String message = "FaultAnswer("+faultAnswerIndex.getId()+") with version='"+faultAnswerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return faultAnswer;
        
	
	}
	//断舍离
	public  void breakWithFaultAnswer(FaultAnswer faultAnswer){
		
		if(faultAnswer == null){
			return;
		}
		faultAnswer.setUser(null);
		//getFaultAnswerList().remove();
	
	}
	
	public  boolean hasFaultAnswer(FaultAnswer faultAnswer){
	
		return getFaultAnswerList().contains(faultAnswer);
  
	}
	
	public void copyFaultAnswerFrom(FaultAnswer faultAnswer) {

		FaultAnswer faultAnswerInList = findTheFaultAnswer(faultAnswer);
		FaultAnswer newFaultAnswer = new FaultAnswer();
		faultAnswerInList.copyTo(newFaultAnswer);
		newFaultAnswer.setVersion(0);//will trigger copy
		getFaultAnswerList().add(newFaultAnswer);
		addItemToFlexiableObject(COPIED_CHILD, newFaultAnswer);
	}
	
	public  FaultAnswer findTheFaultAnswer(FaultAnswer faultAnswer){
		
		int index =  getFaultAnswerList().indexOf(faultAnswer);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "FaultAnswer("+faultAnswer.getId()+") with version='"+faultAnswer.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getFaultAnswerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpFaultAnswerList(){
		getFaultAnswerList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getStartExamList(), internalType);
		collectFromList(this, entityList, getAnswerQuestionList(), internalType);
		collectFromList(this, entityList, getWechatLoginInfoList(), internalType);
		collectFromList(this, entityList, getExamList(), internalType);
		collectFromList(this, entityList, getFaultAnswerList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getStartExamList());
		listOfList.add( getAnswerQuestionList());
		listOfList.add( getWechatLoginInfoList());
		listOfList.add( getExamList());
		listOfList.add( getFaultAnswerList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, AVARTA_PROPERTY, getAvarta());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, USER_TYPE_PROPERTY, getUserType());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, START_EXAM_LIST, getStartExamList());
		if(!getStartExamList().isEmpty()){
			appendKeyValuePair(result, "startExamCount", getStartExamList().getTotalCount());
			appendKeyValuePair(result, "startExamCurrentPageNumber", getStartExamList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ANSWER_QUESTION_LIST, getAnswerQuestionList());
		if(!getAnswerQuestionList().isEmpty()){
			appendKeyValuePair(result, "answerQuestionCount", getAnswerQuestionList().getTotalCount());
			appendKeyValuePair(result, "answerQuestionCurrentPageNumber", getAnswerQuestionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WECHAT_LOGIN_INFO_LIST, getWechatLoginInfoList());
		if(!getWechatLoginInfoList().isEmpty()){
			appendKeyValuePair(result, "wechatLoginInfoCount", getWechatLoginInfoList().getTotalCount());
			appendKeyValuePair(result, "wechatLoginInfoCurrentPageNumber", getWechatLoginInfoList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EXAM_LIST, getExamList());
		if(!getExamList().isEmpty()){
			appendKeyValuePair(result, "examCount", getExamList().getTotalCount());
			appendKeyValuePair(result, "examCurrentPageNumber", getExamList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FAULT_ANSWER_LIST, getFaultAnswerList());
		if(!getFaultAnswerList().isEmpty()){
			appendKeyValuePair(result, "faultAnswerCount", getFaultAnswerList().getTotalCount());
			appendKeyValuePair(result, "faultAnswerCurrentPageNumber", getFaultAnswerList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatUser){
		
		
			WechatUser dest =(WechatUser)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setAvarta(getAvarta());
			dest.setCreateTime(getCreateTime());
			dest.setUserType(getUserType());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setStartExamList(getStartExamList());
			dest.setAnswerQuestionList(getAnswerQuestionList());
			dest.setWechatLoginInfoList(getWechatLoginInfoList());
			dest.setExamList(getExamList());
			dest.setFaultAnswerList(getFaultAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatUser){
		
			
			WechatUser dest =(WechatUser)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAvarta(getAvarta());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeUserType(getUserType());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeStartExamList(getStartExamList());
			dest.mergeAnswerQuestionList(getAnswerQuestionList());
			dest.mergeWechatLoginInfoList(getWechatLoginInfoList());
			dest.mergeExamList(getExamList());
			dest.mergeFaultAnswerList(getFaultAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatUser){
		
			
			WechatUser dest =(WechatUser)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeAvarta(getAvarta());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeUserType(getUserType());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("WechatUser{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tavarta='"+getAvarta()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tuserType='"+getUserType()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

