
package com.doublechaintech.bcex.answerquestion;

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
import com.doublechaintech.bcex.changerequest.ChangeRequest;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

@JsonSerialize(using = AnswerQuestionSerializer.class)
public class AnswerQuestion extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NICK_NAME_PROPERTY             = "nickName"          ;
	public static final String USER_PROPERTY                  = "user"              ;
	public static final String USER_ANSWER_PROPERTY           = "userAnswer"        ;
	public static final String ANSWER_PROPERTY                = "answer"            ;
	public static final String CHANGE_REQUEST_PROPERTY        = "changeRequest"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="AnswerQuestion";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getNickName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mNickName           ;
	protected		WechatUser          	mUser               ;
	protected		UserAnswer          	mUserAnswer         ;
	protected		String              	mAnswer             ;
	protected		ChangeRequest       	mChangeRequest      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	AnswerQuestion(){
		// lazy load for all the properties
	}
	public 	static AnswerQuestion withId(String id){
		AnswerQuestion answerQuestion = new AnswerQuestion();
		answerQuestion.setId(id);
		answerQuestion.setVersion(Integer.MAX_VALUE);
		return answerQuestion;
	}
	public 	static AnswerQuestion refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setUser( null );
		setUserAnswer( null );
		setChangeRequest( null );

		this.changed = true;
	}
	
	public 	AnswerQuestion(String nickName, WechatUser user, UserAnswer userAnswer, String answer, ChangeRequest changeRequest)
	{
		setNickName(nickName);
		setUser(user);
		setUserAnswer(userAnswer);
		setAnswer(answer);
		setChangeRequest(changeRequest);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			changeNickNameProperty(newValueExpr);
		}
		if(ANSWER_PROPERTY.equals(property)){
			changeAnswerProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNickNameProperty(String newValueExpr){
		String oldValue = getNickName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNickName(newValue);
		this.onChangeProperty(NICK_NAME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeAnswerProperty(String newValueExpr){
		String oldValue = getAnswer();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAnswer(newValue);
		this.onChangeProperty(ANSWER_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			return getNickName();
		}
		if(USER_PROPERTY.equals(property)){
			return getUser();
		}
		if(USER_ANSWER_PROPERTY.equals(property)){
			return getUserAnswer();
		}
		if(ANSWER_PROPERTY.equals(property)){
			return getAnswer();
		}
		if(CHANGE_REQUEST_PROPERTY.equals(property)){
			return getChangeRequest();
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
	public AnswerQuestion updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setNickName(String nickName){
		this.mNickName = trimString(nickName);;
	}
	public String getNickName(){
		return this.mNickName;
	}
	public AnswerQuestion updateNickName(String nickName){
		this.mNickName = trimString(nickName);;
		this.changed = true;
		return this;
	}
	public void mergeNickName(String nickName){
		if(nickName != null) { setNickName(nickName);}
	}
	
	
	public void setUser(WechatUser user){
		this.mUser = user;;
	}
	public WechatUser getUser(){
		return this.mUser;
	}
	public AnswerQuestion updateUser(WechatUser user){
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
	
	public void setUserAnswer(UserAnswer userAnswer){
		this.mUserAnswer = userAnswer;;
	}
	public UserAnswer getUserAnswer(){
		return this.mUserAnswer;
	}
	public AnswerQuestion updateUserAnswer(UserAnswer userAnswer){
		this.mUserAnswer = userAnswer;;
		this.changed = true;
		return this;
	}
	public void mergeUserAnswer(UserAnswer userAnswer){
		if(userAnswer != null) { setUserAnswer(userAnswer);}
	}
	
	
	public void clearUserAnswer(){
		setUserAnswer ( null );
		this.changed = true;
	}
	
	public void setAnswer(String answer){
		this.mAnswer = trimString(answer);;
	}
	public String getAnswer(){
		return this.mAnswer;
	}
	public AnswerQuestion updateAnswer(String answer){
		this.mAnswer = trimString(answer);;
		this.changed = true;
		return this;
	}
	public void mergeAnswer(String answer){
		if(answer != null) { setAnswer(answer);}
	}
	
	
	public void setChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
	}
	public ChangeRequest getChangeRequest(){
		return this.mChangeRequest;
	}
	public AnswerQuestion updateChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
		this.changed = true;
		return this;
	}
	public void mergeChangeRequest(ChangeRequest changeRequest){
		if(changeRequest != null) { setChangeRequest(changeRequest);}
	}
	
	
	public void clearChangeRequest(){
		setChangeRequest ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public AnswerQuestion updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getUser(), internalType);
		addToEntityList(this, entityList, getUserAnswer(), internalType);
		addToEntityList(this, entityList, getChangeRequest(), internalType);

		
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
		appendKeyValuePair(result, NICK_NAME_PROPERTY, getNickName());
		appendKeyValuePair(result, USER_PROPERTY, getUser());
		appendKeyValuePair(result, USER_ANSWER_PROPERTY, getUserAnswer());
		appendKeyValuePair(result, ANSWER_PROPERTY, getAnswer());
		appendKeyValuePair(result, CHANGE_REQUEST_PROPERTY, getChangeRequest());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AnswerQuestion){
		
		
			AnswerQuestion dest =(AnswerQuestion)baseDest;
		
			dest.setId(getId());
			dest.setNickName(getNickName());
			dest.setUser(getUser());
			dest.setUserAnswer(getUserAnswer());
			dest.setAnswer(getAnswer());
			dest.setChangeRequest(getChangeRequest());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AnswerQuestion){
		
			
			AnswerQuestion dest =(AnswerQuestion)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeUser(getUser());
			dest.mergeUserAnswer(getUserAnswer());
			dest.mergeAnswer(getAnswer());
			dest.mergeChangeRequest(getChangeRequest());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof AnswerQuestion){
		
			
			AnswerQuestion dest =(AnswerQuestion)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeAnswer(getAnswer());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("AnswerQuestion{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tnickName='"+getNickName()+"';");
		if(getUser() != null ){
 			stringBuilder.append("\tuser='WechatUser("+getUser().getId()+")';");
 		}
		if(getUserAnswer() != null ){
 			stringBuilder.append("\tuserAnswer='UserAnswer("+getUserAnswer().getId()+")';");
 		}
		stringBuilder.append("\tanswer='"+getAnswer()+"';");
		if(getChangeRequest() != null ){
 			stringBuilder.append("\tchangeRequest='ChangeRequest("+getChangeRequest().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

