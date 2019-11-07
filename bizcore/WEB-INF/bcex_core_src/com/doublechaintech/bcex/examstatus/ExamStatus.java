
package com.doublechaintech.bcex.examstatus;

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
import com.doublechaintech.bcex.exam.Exam;

@JsonSerialize(using = ExamStatusSerializer.class)
public class ExamStatus extends BaseEntity implements  java.io.Serializable{

	public static final String STARTED = "STARTED";	// 考试中
	public static final String COMPLETED = "COMPLETED";	// 考试完成
	public static List<KeyValuePair> CODE_NAME_LIST;
	static {
		CODE_NAME_LIST = new ArrayList<>();

		CODE_NAME_LIST.add(new KeyValuePair(STARTED, "考试中"));
		CODE_NAME_LIST.add(new KeyValuePair(COMPLETED, "考试完成"));
	}
	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EXAM_LIST                                = "examList"          ;

	public static final String INTERNAL_TYPE="ExamStatus";
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
	protected		String              	mCode               ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Exam>     	mExamList           ;
	
		
	public 	ExamStatus(){
		// lazy load for all the properties
	}
	public 	static ExamStatus withId(String id){
		ExamStatus examStatus = new ExamStatus();
		examStatus.setId(id);
		examStatus.setVersion(Integer.MAX_VALUE);
		return examStatus;
	}
	public 	static ExamStatus refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	ExamStatus(String name, String code, Platform platform)
	{
		setName(name);
		setCode(code);
		setPlatform(platform);

		this.mExamList = new SmartList<Exam>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
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
			
			
			
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
		}
		if(EXAM_LIST.equals(property)){
			List<BaseEntity> list = getExamList().stream().map(item->item).collect(Collectors.toList());
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
	public ExamStatus updateId(String id){
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
	public ExamStatus updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public ExamStatus updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public ExamStatus updatePlatform(Platform platform){
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
	public ExamStatus updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			exam.setStatus(this);
		}

		this.mExamList = examList;
		this.mExamList.setListInternalName (EXAM_LIST );
		
	}
	
	public  void addExam(Exam exam){
		exam.setStatus(this);
		getExamList().add(exam);
	}
	public  void addExamList(SmartList<Exam> examList){
		for( Exam exam:examList){
			exam.setStatus(this);
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
        // exam.clearStatus(); //disconnect with Status
        exam.clearFromAll(); //disconnect with Status
		
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
		exam.setStatus(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getExamList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getExamList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EXAM_LIST, getExamList());
		if(!getExamList().isEmpty()){
			appendKeyValuePair(result, "examCount", getExamList().getTotalCount());
			appendKeyValuePair(result, "examCurrentPageNumber", getExamList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExamStatus){
		
		
			ExamStatus dest =(ExamStatus)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setCode(getCode());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setExamList(getExamList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExamStatus){
		
			
			ExamStatus dest =(ExamStatus)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeExamList(getExamList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ExamStatus){
		
			
			ExamStatus dest =(ExamStatus)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeCode(getCode());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ExamStatus{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

