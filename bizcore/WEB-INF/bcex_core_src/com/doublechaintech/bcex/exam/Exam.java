
package com.doublechaintech.bcex.exam;

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
import com.doublechaintech.bcex.faultanswer.FaultAnswer;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

@JsonSerialize(using = ExamSerializer.class)
public class Exam extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String STATUS_PROPERTY                = "status"            ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String SCORE_PROPERTY                 = "score"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_ANSWER_LIST                         = "userAnswerList"    ;
	public static final String FAULT_ANSWER_LIST                        = "faultAnswerList"   ;

	public static final String INTERNAL_TYPE="Exam";
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
	protected		DateTime            	mCreateTime         ;
	protected		ExamStatus          	mStatus             ;
	protected		WechatUser          	mUser               ;
	protected		int                 	mScore              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserAnswer>	mUserAnswerList     ;
	protected		SmartList<FaultAnswer>	mFaultAnswerList    ;
	
		
	public 	Exam(){
		// lazy load for all the properties
	}
	public 	static Exam withId(String id){
		Exam exam = new Exam();
		exam.setId(id);
		exam.setVersion(Integer.MAX_VALUE);
		return exam;
	}
	public 	static Exam refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setStatus( null );
		setUser( null );

		this.changed = true;
	}
	
	public 	Exam(String name, DateTime createTime, ExamStatus status, WechatUser user, int score)
	{
		setName(name);
		setCreateTime(createTime);
		setStatus(status);
		setUser(user);
		setScore(score);

		this.mUserAnswerList = new SmartList<UserAnswer>();
		this.mFaultAnswerList = new SmartList<FaultAnswer>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(SCORE_PROPERTY.equals(property)){
			changeScoreProperty(newValueExpr);
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
			
			
			
	protected void changeScoreProperty(String newValueExpr){
		int oldValue = getScore();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateScore(newValue);
		this.onChangeProperty(SCORE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(STATUS_PROPERTY.equals(property)){
			return getStatus();
		}
		if(USER_PROPERTY.equals(property)){
			return getUser();
		}
		if(SCORE_PROPERTY.equals(property)){
			return getScore();
		}
		if(USER_ANSWER_LIST.equals(property)){
			List<BaseEntity> list = getUserAnswerList().stream().map(item->item).collect(Collectors.toList());
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
	public Exam updateId(String id){
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
	public Exam updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public Exam updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setStatus(ExamStatus status){
		this.mStatus = status;;
	}
	public ExamStatus getStatus(){
		return this.mStatus;
	}
	public Exam updateStatus(ExamStatus status){
		this.mStatus = status;;
		this.changed = true;
		return this;
	}
	public void mergeStatus(ExamStatus status){
		if(status != null) { setStatus(status);}
	}
	
	
	public void clearStatus(){
		setStatus ( null );
		this.changed = true;
	}
	
	public void setUser(WechatUser user){
		this.mUser = user;;
	}
	public WechatUser getUser(){
		return this.mUser;
	}
	public Exam updateUser(WechatUser user){
		this.mUser = user;;
		this.changed = true;
		return this;
	}
	public void mergeUser(WechatUser user){
		if(user != null) { setUser(user);}
	}
	
	
	public void clearUser(){
		setUser ( null );
		this.changed = true;
	}
	
	public void setScore(int score){
		this.mScore = score;;
	}
	public int getScore(){
		return this.mScore;
	}
	public Exam updateScore(int score){
		this.mScore = score;;
		this.changed = true;
		return this;
	}
	public void mergeScore(int score){
		setScore(score);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Exam updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<UserAnswer> getUserAnswerList(){
		if(this.mUserAnswerList == null){
			this.mUserAnswerList = new SmartList<UserAnswer>();
			this.mUserAnswerList.setListInternalName (USER_ANSWER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserAnswerList;	
	}
	public  void setUserAnswerList(SmartList<UserAnswer> userAnswerList){
		for( UserAnswer userAnswer:userAnswerList){
			userAnswer.setExam(this);
		}

		this.mUserAnswerList = userAnswerList;
		this.mUserAnswerList.setListInternalName (USER_ANSWER_LIST );
		
	}
	
	public  void addUserAnswer(UserAnswer userAnswer){
		userAnswer.setExam(this);
		getUserAnswerList().add(userAnswer);
	}
	public  void addUserAnswerList(SmartList<UserAnswer> userAnswerList){
		for( UserAnswer userAnswer:userAnswerList){
			userAnswer.setExam(this);
		}
		getUserAnswerList().addAll(userAnswerList);
	}
	public  void mergeUserAnswerList(SmartList<UserAnswer> userAnswerList){
		if(userAnswerList==null){
			return;
		}
		if(userAnswerList.isEmpty()){
			return;
		}
		addUserAnswerList( userAnswerList );
		
	}
	public  UserAnswer removeUserAnswer(UserAnswer userAnswerIndex){
		
		int index = getUserAnswerList().indexOf(userAnswerIndex);
        if(index < 0){
        	String message = "UserAnswer("+userAnswerIndex.getId()+") with version='"+userAnswerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserAnswer userAnswer = getUserAnswerList().get(index);        
        // userAnswer.clearExam(); //disconnect with Exam
        userAnswer.clearFromAll(); //disconnect with Exam
		
		boolean result = getUserAnswerList().planToRemove(userAnswer);
        if(!result){
        	String message = "UserAnswer("+userAnswerIndex.getId()+") with version='"+userAnswerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userAnswer;
        
	
	}
	//断舍离
	public  void breakWithUserAnswer(UserAnswer userAnswer){
		
		if(userAnswer == null){
			return;
		}
		userAnswer.setExam(null);
		//getUserAnswerList().remove();
	
	}
	
	public  boolean hasUserAnswer(UserAnswer userAnswer){
	
		return getUserAnswerList().contains(userAnswer);
  
	}
	
	public void copyUserAnswerFrom(UserAnswer userAnswer) {

		UserAnswer userAnswerInList = findTheUserAnswer(userAnswer);
		UserAnswer newUserAnswer = new UserAnswer();
		userAnswerInList.copyTo(newUserAnswer);
		newUserAnswer.setVersion(0);//will trigger copy
		getUserAnswerList().add(newUserAnswer);
		addItemToFlexiableObject(COPIED_CHILD, newUserAnswer);
	}
	
	public  UserAnswer findTheUserAnswer(UserAnswer userAnswer){
		
		int index =  getUserAnswerList().indexOf(userAnswer);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserAnswer("+userAnswer.getId()+") with version='"+userAnswer.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserAnswerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserAnswerList(){
		getUserAnswerList().clear();
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
			faultAnswer.setExam(this);
		}

		this.mFaultAnswerList = faultAnswerList;
		this.mFaultAnswerList.setListInternalName (FAULT_ANSWER_LIST );
		
	}
	
	public  void addFaultAnswer(FaultAnswer faultAnswer){
		faultAnswer.setExam(this);
		getFaultAnswerList().add(faultAnswer);
	}
	public  void addFaultAnswerList(SmartList<FaultAnswer> faultAnswerList){
		for( FaultAnswer faultAnswer:faultAnswerList){
			faultAnswer.setExam(this);
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
        // faultAnswer.clearExam(); //disconnect with Exam
        faultAnswer.clearFromAll(); //disconnect with Exam
		
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
		faultAnswer.setExam(null);
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

		addToEntityList(this, entityList, getStatus(), internalType);
		addToEntityList(this, entityList, getUser(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserAnswerList(), internalType);
		collectFromList(this, entityList, getFaultAnswerList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserAnswerList());
		listOfList.add( getFaultAnswerList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, STATUS_PROPERTY, getStatus());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, SCORE_PROPERTY, getScore());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_ANSWER_LIST, getUserAnswerList());
		if(!getUserAnswerList().isEmpty()){
			appendKeyValuePair(result, "userAnswerCount", getUserAnswerList().getTotalCount());
			appendKeyValuePair(result, "userAnswerCurrentPageNumber", getUserAnswerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, FAULT_ANSWER_LIST, getFaultAnswerList());
		if(!getFaultAnswerList().isEmpty()){
			appendKeyValuePair(result, "faultAnswerCount", getFaultAnswerList().getTotalCount());
			appendKeyValuePair(result, "faultAnswerCurrentPageNumber", getFaultAnswerList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Exam){
		
		
			Exam dest =(Exam)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCreateTime(getCreateTime());
			dest.setStatus(getStatus());
			dest.setUser(getUser());
			dest.setScore(getScore());
			dest.setVersion(getVersion());
			dest.setUserAnswerList(getUserAnswerList());
			dest.setFaultAnswerList(getFaultAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Exam){
		
			
			Exam dest =(Exam)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeStatus(getStatus());
			dest.mergeUser(getUser());
			dest.mergeScore(getScore());
			dest.mergeVersion(getVersion());
			dest.mergeUserAnswerList(getUserAnswerList());
			dest.mergeFaultAnswerList(getFaultAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Exam){
		
			
			Exam dest =(Exam)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeScore(getScore());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Exam{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		if(getStatus() != null ){
 			stringBuilder.append("\tstatus='ExamStatus("+getStatus().getId()+")';");
 		}
		if(getUser() != null ){
 			stringBuilder.append("\tuser='WechatUser("+getUser().getId()+")';");
 		}
		stringBuilder.append("\tscore='"+getScore()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseScore(int incScore){
		updateScore(this.mScore +  incScore);
	}
	public void decreaseScore(int decScore){
		updateScore(this.mScore - decScore);
	}
	

}

