
package com.doublechaintech.bcex.changerequest;

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
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.changerequesttype.ChangeRequestType;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.startexam.StartExam;
import com.doublechaintech.bcex.registeration.Registeration;

@JsonSerialize(using = ChangeRequestSerializer.class)
public class ChangeRequest extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String REMOTE_IP_PROPERTY             = "remoteIp"          ;
	public static final String REQUEST_TYPE_PROPERTY          = "requestType"       ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String REGISTERATION_LIST                       = "registerationList" ;
	public static final String START_EXAM_LIST                          = "startExamList"     ;
	public static final String ANSWER_QUESTION_LIST                     = "answerQuestionList";

	public static final String INTERNAL_TYPE="ChangeRequest";
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
	protected		String              	mRemoteIp           ;
	protected		ChangeRequestType   	mRequestType        ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Registeration>	mRegisterationList  ;
	protected		SmartList<StartExam>	mStartExamList      ;
	protected		SmartList<AnswerQuestion>	mAnswerQuestionList ;
	
		
	public 	ChangeRequest(){
		// lazy load for all the properties
	}
	public 	static ChangeRequest withId(String id){
		ChangeRequest changeRequest = new ChangeRequest();
		changeRequest.setId(id);
		changeRequest.setVersion(Integer.MAX_VALUE);
		return changeRequest;
	}
	public 	static ChangeRequest refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setRequestType( null );
		setPlatform( null );

		this.changed = true;
	}
	
	public 	ChangeRequest(String name, DateTime createTime, String remoteIp, ChangeRequestType requestType, Platform platform)
	{
		setName(name);
		setCreateTime(createTime);
		setRemoteIp(remoteIp);
		setRequestType(requestType);
		setPlatform(platform);

		this.mRegisterationList = new SmartList<Registeration>();
		this.mStartExamList = new SmartList<StartExam>();
		this.mAnswerQuestionList = new SmartList<AnswerQuestion>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(REMOTE_IP_PROPERTY.equals(property)){
			changeRemoteIpProperty(newValueExpr);
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
			
			
			
	protected void changeRemoteIpProperty(String newValueExpr){
		String oldValue = getRemoteIp();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemoteIp(newValue);
		this.onChangeProperty(REMOTE_IP_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(REMOTE_IP_PROPERTY.equals(property)){
			return getRemoteIp();
		}
		if(REQUEST_TYPE_PROPERTY.equals(property)){
			return getRequestType();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
		}
		if(REGISTERATION_LIST.equals(property)){
			List<BaseEntity> list = getRegisterationList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(START_EXAM_LIST.equals(property)){
			List<BaseEntity> list = getStartExamList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ANSWER_QUESTION_LIST.equals(property)){
			List<BaseEntity> list = getAnswerQuestionList().stream().map(item->item).collect(Collectors.toList());
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
	public ChangeRequest updateId(String id){
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
	public ChangeRequest updateName(String name){
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
	public ChangeRequest updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setRemoteIp(String remoteIp){
		this.mRemoteIp = trimString(remoteIp);;
	}
	public String getRemoteIp(){
		return this.mRemoteIp;
	}
	public ChangeRequest updateRemoteIp(String remoteIp){
		this.mRemoteIp = trimString(remoteIp);;
		this.changed = true;
		return this;
	}
	public void mergeRemoteIp(String remoteIp){
		if(remoteIp != null) { setRemoteIp(remoteIp);}
	}
	
	
	public void setRequestType(ChangeRequestType requestType){
		this.mRequestType = requestType;;
	}
	public ChangeRequestType getRequestType(){
		return this.mRequestType;
	}
	public ChangeRequest updateRequestType(ChangeRequestType requestType){
		this.mRequestType = requestType;;
		this.changed = true;
		return this;
	}
	public void mergeRequestType(ChangeRequestType requestType){
		if(requestType != null) { setRequestType(requestType);}
	}
	
	
	public void clearRequestType(){
		setRequestType ( null );
		this.changed = true;
	}
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public ChangeRequest updatePlatform(Platform platform){
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
	public ChangeRequest updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Registeration> getRegisterationList(){
		if(this.mRegisterationList == null){
			this.mRegisterationList = new SmartList<Registeration>();
			this.mRegisterationList.setListInternalName (REGISTERATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRegisterationList;	
	}
	public  void setRegisterationList(SmartList<Registeration> registerationList){
		for( Registeration registeration:registerationList){
			registeration.setChangeRequest(this);
		}

		this.mRegisterationList = registerationList;
		this.mRegisterationList.setListInternalName (REGISTERATION_LIST );
		
	}
	
	public  void addRegisteration(Registeration registeration){
		registeration.setChangeRequest(this);
		getRegisterationList().add(registeration);
	}
	public  void addRegisterationList(SmartList<Registeration> registerationList){
		for( Registeration registeration:registerationList){
			registeration.setChangeRequest(this);
		}
		getRegisterationList().addAll(registerationList);
	}
	public  void mergeRegisterationList(SmartList<Registeration> registerationList){
		if(registerationList==null){
			return;
		}
		if(registerationList.isEmpty()){
			return;
		}
		addRegisterationList( registerationList );
		
	}
	public  Registeration removeRegisteration(Registeration registerationIndex){
		
		int index = getRegisterationList().indexOf(registerationIndex);
        if(index < 0){
        	String message = "Registeration("+registerationIndex.getId()+") with version='"+registerationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Registeration registeration = getRegisterationList().get(index);        
        // registeration.clearChangeRequest(); //disconnect with ChangeRequest
        registeration.clearFromAll(); //disconnect with ChangeRequest
		
		boolean result = getRegisterationList().planToRemove(registeration);
        if(!result){
        	String message = "Registeration("+registerationIndex.getId()+") with version='"+registerationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return registeration;
        
	
	}
	//断舍离
	public  void breakWithRegisteration(Registeration registeration){
		
		if(registeration == null){
			return;
		}
		registeration.setChangeRequest(null);
		//getRegisterationList().remove();
	
	}
	
	public  boolean hasRegisteration(Registeration registeration){
	
		return getRegisterationList().contains(registeration);
  
	}
	
	public void copyRegisterationFrom(Registeration registeration) {

		Registeration registerationInList = findTheRegisteration(registeration);
		Registeration newRegisteration = new Registeration();
		registerationInList.copyTo(newRegisteration);
		newRegisteration.setVersion(0);//will trigger copy
		getRegisterationList().add(newRegisteration);
		addItemToFlexiableObject(COPIED_CHILD, newRegisteration);
	}
	
	public  Registeration findTheRegisteration(Registeration registeration){
		
		int index =  getRegisterationList().indexOf(registeration);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Registeration("+registeration.getId()+") with version='"+registeration.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRegisterationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRegisterationList(){
		getRegisterationList().clear();
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
			startExam.setChangeRequest(this);
		}

		this.mStartExamList = startExamList;
		this.mStartExamList.setListInternalName (START_EXAM_LIST );
		
	}
	
	public  void addStartExam(StartExam startExam){
		startExam.setChangeRequest(this);
		getStartExamList().add(startExam);
	}
	public  void addStartExamList(SmartList<StartExam> startExamList){
		for( StartExam startExam:startExamList){
			startExam.setChangeRequest(this);
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
        // startExam.clearChangeRequest(); //disconnect with ChangeRequest
        startExam.clearFromAll(); //disconnect with ChangeRequest
		
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
		startExam.setChangeRequest(null);
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
			answerQuestion.setChangeRequest(this);
		}

		this.mAnswerQuestionList = answerQuestionList;
		this.mAnswerQuestionList.setListInternalName (ANSWER_QUESTION_LIST );
		
	}
	
	public  void addAnswerQuestion(AnswerQuestion answerQuestion){
		answerQuestion.setChangeRequest(this);
		getAnswerQuestionList().add(answerQuestion);
	}
	public  void addAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		for( AnswerQuestion answerQuestion:answerQuestionList){
			answerQuestion.setChangeRequest(this);
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
        // answerQuestion.clearChangeRequest(); //disconnect with ChangeRequest
        answerQuestion.clearFromAll(); //disconnect with ChangeRequest
		
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
		answerQuestion.setChangeRequest(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getRequestType(), internalType);
		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRegisterationList(), internalType);
		collectFromList(this, entityList, getStartExamList(), internalType);
		collectFromList(this, entityList, getAnswerQuestionList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRegisterationList());
		listOfList.add( getStartExamList());
		listOfList.add( getAnswerQuestionList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, REMOTE_IP_PROPERTY, getRemoteIp());
		appendKeyValuePair(result, REQUEST_TYPE_PROPERTY, getRequestType());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, REGISTERATION_LIST, getRegisterationList());
		if(!getRegisterationList().isEmpty()){
			appendKeyValuePair(result, "registerationCount", getRegisterationList().getTotalCount());
			appendKeyValuePair(result, "registerationCurrentPageNumber", getRegisterationList().getCurrentPageNumber());
		}
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

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
		
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCreateTime(getCreateTime());
			dest.setRemoteIp(getRemoteIp());
			dest.setRequestType(getRequestType());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setRegisterationList(getRegisterationList());
			dest.setStartExamList(getStartExamList());
			dest.setAnswerQuestionList(getAnswerQuestionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
			
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeRemoteIp(getRemoteIp());
			dest.mergeRequestType(getRequestType());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeRegisterationList(getRegisterationList());
			dest.mergeStartExamList(getStartExamList());
			dest.mergeAnswerQuestionList(getAnswerQuestionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChangeRequest){
		
			
			ChangeRequest dest =(ChangeRequest)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeRemoteIp(getRemoteIp());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChangeRequest{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tremoteIp='"+getRemoteIp()+"';");
		if(getRequestType() != null ){
 			stringBuilder.append("\trequestType='ChangeRequestType("+getRequestType().getId()+")';");
 		}
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

