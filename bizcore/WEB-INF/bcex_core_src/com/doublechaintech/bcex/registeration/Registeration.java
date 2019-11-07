
package com.doublechaintech.bcex.registeration;

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

@JsonSerialize(using = RegisterationSerializer.class)
public class Registeration extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NICK_NAME_PROPERTY             = "nickName"          ;
	public static final String AVARTA_PROPERTY                = "avarta"            ;
	public static final String CHANGE_REQUEST_PROPERTY        = "changeRequest"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Registeration";
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
	protected		String              	mAvarta             ;
	protected		ChangeRequest       	mChangeRequest      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Registeration(){
		// lazy load for all the properties
	}
	public 	static Registeration withId(String id){
		Registeration registeration = new Registeration();
		registeration.setId(id);
		registeration.setVersion(Integer.MAX_VALUE);
		return registeration;
	}
	public 	static Registeration refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChangeRequest( null );

		this.changed = true;
	}
	
	public 	Registeration(String nickName, String avarta, ChangeRequest changeRequest)
	{
		setNickName(nickName);
		setAvarta(avarta);
		setChangeRequest(changeRequest);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			changeNickNameProperty(newValueExpr);
		}
		if(AVARTA_PROPERTY.equals(property)){
			changeAvartaProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NICK_NAME_PROPERTY.equals(property)){
			return getNickName();
		}
		if(AVARTA_PROPERTY.equals(property)){
			return getAvarta();
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
	public Registeration updateId(String id){
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
	public Registeration updateNickName(String nickName){
		this.mNickName = trimString(nickName);;
		this.changed = true;
		return this;
	}
	public void mergeNickName(String nickName){
		if(nickName != null) { setNickName(nickName);}
	}
	
	
	public void setAvarta(String avarta){
		this.mAvarta = trimString(encodeUrl(avarta));;
	}
	public String getAvarta(){
		return this.mAvarta;
	}
	public Registeration updateAvarta(String avarta){
		this.mAvarta = trimString(encodeUrl(avarta));;
		this.changed = true;
		return this;
	}
	public void mergeAvarta(String avarta){
		if(avarta != null) { setAvarta(avarta);}
	}
	
	
	public void setChangeRequest(ChangeRequest changeRequest){
		this.mChangeRequest = changeRequest;;
	}
	public ChangeRequest getChangeRequest(){
		return this.mChangeRequest;
	}
	public Registeration updateChangeRequest(ChangeRequest changeRequest){
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
	public Registeration updateVersion(int version){
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
		appendKeyValuePair(result, AVARTA_PROPERTY, getAvarta());
		appendKeyValuePair(result, CHANGE_REQUEST_PROPERTY, getChangeRequest());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registeration){
		
		
			Registeration dest =(Registeration)baseDest;
		
			dest.setId(getId());
			dest.setNickName(getNickName());
			dest.setAvarta(getAvarta());
			dest.setChangeRequest(getChangeRequest());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registeration){
		
			
			Registeration dest =(Registeration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeAvarta(getAvarta());
			dest.mergeChangeRequest(getChangeRequest());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Registeration){
		
			
			Registeration dest =(Registeration)baseDest;
		
			dest.mergeId(getId());
			dest.mergeNickName(getNickName());
			dest.mergeAvarta(getAvarta());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Registeration{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tnickName='"+getNickName()+"';");
		stringBuilder.append("\tavarta='"+getAvarta()+"';");
		if(getChangeRequest() != null ){
 			stringBuilder.append("\tchangeRequest='ChangeRequest("+getChangeRequest().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

