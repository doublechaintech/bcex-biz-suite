
package com.doublechaintech.bcex.wechatlogininfo;

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

@JsonSerialize(using = WechatLoginInfoSerializer.class)
public class WechatLoginInfo extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WECHAT_USER_PROPERTY           = "wechatUser"        ;
	public static final String APP_ID_PROPERTY                = "appId"             ;
	public static final String OPEN_ID_PROPERTY               = "openId"            ;
	public static final String SESSION_KEY_PROPERTY           = "sessionKey"        ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="WechatLoginInfo";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getAppId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		WechatUser          	mWechatUser         ;
	protected		String              	mAppId              ;
	protected		String              	mOpenId             ;
	protected		String              	mSessionKey         ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	WechatLoginInfo(){
		// lazy load for all the properties
	}
	public 	static WechatLoginInfo withId(String id){
		WechatLoginInfo wechatLoginInfo = new WechatLoginInfo();
		wechatLoginInfo.setId(id);
		wechatLoginInfo.setVersion(Integer.MAX_VALUE);
		return wechatLoginInfo;
	}
	public 	static WechatLoginInfo refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setWechatUser( null );

		this.changed = true;
	}
	
	public 	WechatLoginInfo(WechatUser wechatUser, String appId, String openId, String sessionKey, DateTime lastUpdateTime)
	{
		setWechatUser(wechatUser);
		setAppId(appId);
		setOpenId(openId);
		setSessionKey(sessionKey);
		setLastUpdateTime(lastUpdateTime);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(APP_ID_PROPERTY.equals(property)){
			changeAppIdProperty(newValueExpr);
		}
		if(OPEN_ID_PROPERTY.equals(property)){
			changeOpenIdProperty(newValueExpr);
		}
		if(SESSION_KEY_PROPERTY.equals(property)){
			changeSessionKeyProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeAppIdProperty(String newValueExpr){
		String oldValue = getAppId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppId(newValue);
		this.onChangeProperty(APP_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOpenIdProperty(String newValueExpr){
		String oldValue = getOpenId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOpenId(newValue);
		this.onChangeProperty(OPEN_ID_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeSessionKeyProperty(String newValueExpr){
		String oldValue = getSessionKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSessionKey(newValue);
		this.onChangeProperty(SESSION_KEY_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(WECHAT_USER_PROPERTY.equals(property)){
			return getWechatUser();
		}
		if(APP_ID_PROPERTY.equals(property)){
			return getAppId();
		}
		if(OPEN_ID_PROPERTY.equals(property)){
			return getOpenId();
		}
		if(SESSION_KEY_PROPERTY.equals(property)){
			return getSessionKey();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
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
	public WechatLoginInfo updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setWechatUser(WechatUser wechatUser){
		this.mWechatUser = wechatUser;;
	}
	public WechatUser getWechatUser(){
		return this.mWechatUser;
	}
	public WechatLoginInfo updateWechatUser(WechatUser wechatUser){
		this.mWechatUser = wechatUser;;
		this.changed = true;
		return this;
	}
	public void mergeWechatUser(WechatUser wechatUser){
		if(wechatUser != null) { setWechatUser(wechatUser);}
	}
	
	
	public void clearWechatUser(){
		setWechatUser ( null );
		this.changed = true;
	}
	
	public void setAppId(String appId){
		this.mAppId = trimString(appId);;
	}
	public String getAppId(){
		return this.mAppId;
	}
	public WechatLoginInfo updateAppId(String appId){
		this.mAppId = trimString(appId);;
		this.changed = true;
		return this;
	}
	public void mergeAppId(String appId){
		if(appId != null) { setAppId(appId);}
	}
	
	
	public void clearAppId(){
		setAppId ( null );
		this.changed = true;
	}
	
	public void setOpenId(String openId){
		this.mOpenId = trimString(openId);;
	}
	public String getOpenId(){
		return this.mOpenId;
	}
	public WechatLoginInfo updateOpenId(String openId){
		this.mOpenId = trimString(openId);;
		this.changed = true;
		return this;
	}
	public void mergeOpenId(String openId){
		if(openId != null) { setOpenId(openId);}
	}
	
	
	public void clearOpenId(){
		setOpenId ( null );
		this.changed = true;
	}
	
	public void setSessionKey(String sessionKey){
		this.mSessionKey = trimString(sessionKey);;
	}
	public String getSessionKey(){
		return this.mSessionKey;
	}
	public WechatLoginInfo updateSessionKey(String sessionKey){
		this.mSessionKey = trimString(sessionKey);;
		this.changed = true;
		return this;
	}
	public void mergeSessionKey(String sessionKey){
		if(sessionKey != null) { setSessionKey(sessionKey);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public WechatLoginInfo updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public WechatLoginInfo updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getWechatUser(), internalType);

		
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
		appendKeyValuePair(result, WECHAT_USER_PROPERTY, getWechatUser());
		appendKeyValuePair(result, APP_ID_PROPERTY, getAppId());
		appendKeyValuePair(result, OPEN_ID_PROPERTY, getOpenId());
		appendKeyValuePair(result, SESSION_KEY_PROPERTY, getSessionKey());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatLoginInfo){
		
		
			WechatLoginInfo dest =(WechatLoginInfo)baseDest;
		
			dest.setId(getId());
			dest.setWechatUser(getWechatUser());
			dest.setAppId(getAppId());
			dest.setOpenId(getOpenId());
			dest.setSessionKey(getSessionKey());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatLoginInfo){
		
			
			WechatLoginInfo dest =(WechatLoginInfo)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWechatUser(getWechatUser());
			dest.mergeAppId(getAppId());
			dest.mergeOpenId(getOpenId());
			dest.mergeSessionKey(getSessionKey());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatLoginInfo){
		
			
			WechatLoginInfo dest =(WechatLoginInfo)baseDest;
		
			dest.mergeId(getId());
			dest.mergeAppId(getAppId());
			dest.mergeOpenId(getOpenId());
			dest.mergeSessionKey(getSessionKey());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("WechatLoginInfo{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getWechatUser() != null ){
 			stringBuilder.append("\twechatUser='WechatUser("+getWechatUser().getId()+")';");
 		}
		stringBuilder.append("\tappId='"+getAppId()+"';");
		stringBuilder.append("\topenId='"+getOpenId()+"';");
		stringBuilder.append("\tsessionKey='"+getSessionKey()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

