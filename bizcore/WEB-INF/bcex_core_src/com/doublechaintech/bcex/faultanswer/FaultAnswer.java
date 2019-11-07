
package com.doublechaintech.bcex.faultanswer;

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
import com.doublechaintech.bcex.wechatuser.WechatUser;
import com.doublechaintech.bcex.exam.Exam;

@JsonSerialize(using = FaultAnswerSerializer.class)
public class FaultAnswer extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TOPIC_PROPERTY                 = "topic"             ;
	public static final String YOUR_ANSWER_PROPERTY           = "yourAnswer"        ;
	public static final String RIGHT_ANSWER_PROPERTY          = "rightAnswer"       ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String EXAM_PROPERTY                  = "exam"              ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="FaultAnswer";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTopic();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTopic              ;
	protected		String              	mYourAnswer         ;
	protected		String              	mRightAnswer        ;
	protected		DateTime            	mCreateTime         ;
	protected		WechatUser          	mUser               ;
	protected		Exam                	mExam               ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	FaultAnswer(){
		// lazy load for all the properties
	}
	public 	static FaultAnswer withId(String id){
		FaultAnswer faultAnswer = new FaultAnswer();
		faultAnswer.setId(id);
		faultAnswer.setVersion(Integer.MAX_VALUE);
		return faultAnswer;
	}
	public 	static FaultAnswer refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setExam( null );

		this.changed = true;
	}
	
	public 	FaultAnswer(String topic, String yourAnswer, String rightAnswer, DateTime createTime, WechatUser user, Exam exam)
	{
		setTopic(topic);
		setYourAnswer(yourAnswer);
		setRightAnswer(rightAnswer);
		setCreateTime(createTime);
		setUser(user);
		setExam(exam);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			changeTopicProperty(newValueExpr);
		}
		if(YOUR_ANSWER_PROPERTY.equals(property)){
			changeYourAnswerProperty(newValueExpr);
		}
		if(RIGHT_ANSWER_PROPERTY.equals(property)){
			changeRightAnswerProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTopicProperty(String newValueExpr){
		String oldValue = getTopic();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTopic(newValue);
		this.onChangeProperty(TOPIC_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeYourAnswerProperty(String newValueExpr){
		String oldValue = getYourAnswer();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateYourAnswer(newValue);
		this.onChangeProperty(YOUR_ANSWER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeRightAnswerProperty(String newValueExpr){
		String oldValue = getRightAnswer();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRightAnswer(newValue);
		this.onChangeProperty(RIGHT_ANSWER_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			return getTopic();
		}
		if(YOUR_ANSWER_PROPERTY.equals(property)){
			return getYourAnswer();
		}
		if(RIGHT_ANSWER_PROPERTY.equals(property)){
			return getRightAnswer();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(USER_PROPERTY.equals(property)){
			return getUser();
		}
		if(EXAM_PROPERTY.equals(property)){
			return getExam();
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
	public FaultAnswer updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTopic(String topic){
		this.mTopic = trimString(topic);;
	}
	public String getTopic(){
		return this.mTopic;
	}
	public FaultAnswer updateTopic(String topic){
		this.mTopic = trimString(topic);;
		this.changed = true;
		return this;
	}
	public void mergeTopic(String topic){
		if(topic != null) { setTopic(topic);}
	}
	
	
	public void setYourAnswer(String yourAnswer){
		this.mYourAnswer = trimString(yourAnswer);;
	}
	public String getYourAnswer(){
		return this.mYourAnswer;
	}
	public FaultAnswer updateYourAnswer(String yourAnswer){
		this.mYourAnswer = trimString(yourAnswer);;
		this.changed = true;
		return this;
	}
	public void mergeYourAnswer(String yourAnswer){
		if(yourAnswer != null) { setYourAnswer(yourAnswer);}
	}
	
	
	public void setRightAnswer(String rightAnswer){
		this.mRightAnswer = trimString(rightAnswer);;
	}
	public String getRightAnswer(){
		return this.mRightAnswer;
	}
	public FaultAnswer updateRightAnswer(String rightAnswer){
		this.mRightAnswer = trimString(rightAnswer);;
		this.changed = true;
		return this;
	}
	public void mergeRightAnswer(String rightAnswer){
		if(rightAnswer != null) { setRightAnswer(rightAnswer);}
	}
	
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public FaultAnswer updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setUser(WechatUser user){
		this.mUser = user;;
	}
	public WechatUser getUser(){
		return this.mUser;
	}
	public FaultAnswer updateUser(WechatUser user){
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
	
	public void setExam(Exam exam){
		this.mExam = exam;;
	}
	public Exam getExam(){
		return this.mExam;
	}
	public FaultAnswer updateExam(Exam exam){
		this.mExam = exam;;
		this.changed = true;
		return this;
	}
	public void mergeExam(Exam exam){
		if(exam != null) { setExam(exam);}
	}
	
	
	public void clearExam(){
		setExam ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public FaultAnswer updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUser(), internalType);
		addToEntityList(this, entityList, getExam(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TOPIC_PROPERTY, getTopic());
		appendKeyValuePair(result, YOUR_ANSWER_PROPERTY, getYourAnswer());
		appendKeyValuePair(result, RIGHT_ANSWER_PROPERTY, getRightAnswer());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, EXAM_PROPERTY, getExam());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FaultAnswer){
		
		
			FaultAnswer dest =(FaultAnswer)baseDest;
		
			dest.setId(getId());
			dest.setTopic(getTopic());
			dest.setYourAnswer(getYourAnswer());
			dest.setRightAnswer(getRightAnswer());
			dest.setCreateTime(getCreateTime());
			dest.setUser(getUser());
			dest.setExam(getExam());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FaultAnswer){
		
			
			FaultAnswer dest =(FaultAnswer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeYourAnswer(getYourAnswer());
			dest.mergeRightAnswer(getRightAnswer());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeUser(getUser());
			dest.mergeExam(getExam());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof FaultAnswer){
		
			
			FaultAnswer dest =(FaultAnswer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeYourAnswer(getYourAnswer());
			dest.mergeRightAnswer(getRightAnswer());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("FaultAnswer{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttopic='"+getTopic()+"';");
		stringBuilder.append("\tyourAnswer='"+getYourAnswer()+"';");
		stringBuilder.append("\trightAnswer='"+getRightAnswer()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='WechatUser("+getUser().getId()+")';");
 		}
		if(getExam() != null ){
 			stringBuilder.append("\texam='Exam("+getExam().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

