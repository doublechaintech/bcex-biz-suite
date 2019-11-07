
package com.doublechaintech.bcex.registration;

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

@JsonSerialize(using = RegistrationSerializer.class)
public class Registration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NICK_NAME_PROPERTY             = "nickName"          ;
	public static final String AVATAR_PROPERTY                = "avatar"            ;
	public static final String CHANGE_REQUEST_PROPERTY        = "changeRequest"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Registration";
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
	protected		String              	mAvatar             ;
	protected		ChangeRequest       	mChangeRequest      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Registration(){
		// lazy load for all the properties
	}
	public 	static Registration withId(String id){
		Registration registration = new Registration();
		registration.setId(id);
		registration.setVersion(Integer.MAX_VALUE);
		return registration;
	}
	public 	static Registration refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChangeRequest( null );

		this.changed = true;
	}
	
	public 	Registration(String nickName, String avatar, ChangeRequest changeRequest)
	{
		setNickName(nickName);
		setAvatar(avatar);
		setChangeRequest(changeRequest);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			changeNickNameProperty(newValueExpr);
		}
		if(AVATAR_PROPERTY.equals(property)){
			changeAvatarProperty(newValueExpr);
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
			
			
			
	protected void changeAvatarProperty(String newValueExpr){
		String oldValue = getAvatar();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAvatar(newValue);
		this.onChangeProperty(AVATAR_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			return getNickName();
		}
		if(AVATAR_PROPERTY.equals(property)){
			return getAvatar();
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
	public Registration updateId(String id){
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
	public Registration updateNickName(String nickName){
		this.mNickName = trimString(nickName);;
		this.changed = true;
		return this;
	}
	public void mergeNickName(String nickName){
		if(nickName != null) { setNickName(nickName);}
	}
	
	
	public void setAvatar(String avatar){
		this.mAvatar = trimString(encodeUrl(avatar));;
	}
	public String getAvatar(){
		return this.mAvatar;
	}
	public Registration updateAvatar(String avatar){
		this.mAvatar = trimString(encodeUrl(avatar));;
		this.changed = true;
		return this;
	}
	public void mergeAvatar(String avatar){
		if(avatar != null) { setAvatar(avatar);}
	}
	
	
	public void setChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
	}
	public ChangeRequest getChangeRequest(){
		return this.mChangeRequest;
	}
	public Registration updateChangeRequest(ChangeRequest changeRequest){
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
	public Registration updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

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
		appendKeyValuePair(result, AVATAR_PROPERTY, getAvatar());
		appendKeyValuePair(result, CHANGE_REQUEST_PROPERTY, getChangeRequest());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registration){
		
		
			Registration dest =(Registration)baseDest;
		
			dest.setId(getId());
			dest.setNickName(getNickName());
			dest.setAvatar(getAvatar());
			dest.setChangeRequest(getChangeRequest());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registration){
		
			
			Registration dest =(Registration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeAvatar(getAvatar());
			dest.mergeChangeRequest(getChangeRequest());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registration){
		
			
			Registration dest =(Registration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeAvatar(getAvatar());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Registration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tnickName='"+getNickName()+"';");
		stringBuilder.append("\tavatar='"+getAvatar()+"';");
		if(getChangeRequest() != null ){
 			stringBuilder.append("\tchangeRequest='ChangeRequest("+getChangeRequest().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

