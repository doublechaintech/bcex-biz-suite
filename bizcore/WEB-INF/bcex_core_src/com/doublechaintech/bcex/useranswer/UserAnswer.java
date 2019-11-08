
package com.doublechaintech.bcex.useranswer;

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
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.question.Question;
import com.doublechaintech.bcex.exam.Exam;

@JsonSerialize(using = UserAnswerSerializer.class)
public class UserAnswer extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TOPIC_PROPERTY                 = "topic"             ;
	public static final String USER_SELECT_PROPERTY           = "userSelect"        ;
	public static final String QUESTION_PROPERTY              = "question"          ;
	public static final String EXAM_PROPERTY                  = "exam"              ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ANSWER_QUESTION_LIST                     = "answerQuestionList";

	public static final String INTERNAL_TYPE="UserAnswer";
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
	protected		String              	mUserSelect         ;
	protected		Question            	mQuestion           ;
	protected		Exam                	mExam               ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AnswerQuestion>	mAnswerQuestionList ;
	
		
	public 	UserAnswer(){
		// lazy load for all the properties
	}
	public 	static UserAnswer withId(String id){
		UserAnswer userAnswer = new UserAnswer();
		userAnswer.setId(id);
		userAnswer.setVersion(Integer.MAX_VALUE);
		return userAnswer;
	}
	public 	static UserAnswer refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setQuestion( null );
		setExam( null );

		this.changed = true;
	}
	
	public 	UserAnswer(String topic, String userSelect, Question question, Exam exam)
	{
		setTopic(topic);
		setUserSelect(userSelect);
		setQuestion(question);
		setExam(exam);

		this.mAnswerQuestionList = new SmartList<AnswerQuestion>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			changeTopicProperty(newValueExpr);
		}
		if(USER_SELECT_PROPERTY.equals(property)){
			changeUserSelectProperty(newValueExpr);
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
			
			
			
	protected void changeUserSelectProperty(String newValueExpr){
		String oldValue = getUserSelect();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserSelect(newValue);
		this.onChangeProperty(USER_SELECT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			return getTopic();
		}
		if(USER_SELECT_PROPERTY.equals(property)){
			return getUserSelect();
		}
		if(QUESTION_PROPERTY.equals(property)){
			return getQuestion();
		}
		if(EXAM_PROPERTY.equals(property)){
			return getExam();
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
	public UserAnswer updateId(String id){
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
	public UserAnswer updateTopic(String topic){
		this.mTopic = trimString(topic);;
		this.changed = true;
		return this;
	}
	public void mergeTopic(String topic){
		if(topic != null) { setTopic(topic);}
	}
	
	
	public void setUserSelect(String userSelect){
		this.mUserSelect = trimString(userSelect);;
	}
	public String getUserSelect(){
		return this.mUserSelect;
	}
	public UserAnswer updateUserSelect(String userSelect){
		this.mUserSelect = trimString(userSelect);;
		this.changed = true;
		return this;
	}
	public void mergeUserSelect(String userSelect){
		if(userSelect != null) { setUserSelect(userSelect);}
	}
	
	
	public void setQuestion(Question question){
		this.mQuestion = question;;
	}
	public Question getQuestion(){
		return this.mQuestion;
	}
	public UserAnswer updateQuestion(Question question){
		this.mQuestion = question;;
		this.changed = true;
		return this;
	}
	public void mergeQuestion(Question question){
		if(question != null) { setQuestion(question);}
	}
	
	
	public void clearQuestion(){
		setQuestion ( null );
		this.changed = true;
	}
	
	public void setExam(Exam exam){
		this.mExam = exam;;
	}
	public Exam getExam(){
		return this.mExam;
	}
	public UserAnswer updateExam(Exam exam){
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
	public UserAnswer updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			answerQuestion.setUserAnswer(this);
		}

		this.mAnswerQuestionList = answerQuestionList;
		this.mAnswerQuestionList.setListInternalName (ANSWER_QUESTION_LIST );
		
	}
	
	public  void addAnswerQuestion(AnswerQuestion answerQuestion){
		answerQuestion.setUserAnswer(this);
		getAnswerQuestionList().add(answerQuestion);
	}
	public  void addAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		for( AnswerQuestion answerQuestion:answerQuestionList){
			answerQuestion.setUserAnswer(this);
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
        // answerQuestion.clearUserAnswer(); //disconnect with UserAnswer
        answerQuestion.clearFromAll(); //disconnect with UserAnswer
		
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
		answerQuestion.setUserAnswer(null);
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

		addToEntityList(this, entityList, getQuestion(), internalType);
		addToEntityList(this, entityList, getExam(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAnswerQuestionList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAnswerQuestionList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TOPIC_PROPERTY, getTopic());
		appendKeyValuePair(result, USER_SELECT_PROPERTY, getUserSelect());
		appendKeyValuePair(result, QUESTION_PROPERTY, getQuestion());
		appendKeyValuePair(result, EXAM_PROPERTY, getExam());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ANSWER_QUESTION_LIST, getAnswerQuestionList());
		if(!getAnswerQuestionList().isEmpty()){
			appendKeyValuePair(result, "answerQuestionCount", getAnswerQuestionList().getTotalCount());
			appendKeyValuePair(result, "answerQuestionCurrentPageNumber", getAnswerQuestionList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAnswer){
		
		
			UserAnswer dest =(UserAnswer)baseDest;
		
			dest.setId(getId());
			dest.setTopic(getTopic());
			dest.setUserSelect(getUserSelect());
			dest.setQuestion(getQuestion());
			dest.setExam(getExam());
			dest.setVersion(getVersion());
			dest.setAnswerQuestionList(getAnswerQuestionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAnswer){
		
			
			UserAnswer dest =(UserAnswer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeUserSelect(getUserSelect());
			dest.mergeQuestion(getQuestion());
			dest.mergeExam(getExam());
			dest.mergeVersion(getVersion());
			dest.mergeAnswerQuestionList(getAnswerQuestionList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof UserAnswer){
		
			
			UserAnswer dest =(UserAnswer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeUserSelect(getUserSelect());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserAnswer{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttopic='"+getTopic()+"';");
		stringBuilder.append("\tuserSelect='"+getUserSelect()+"';");
		if(getQuestion() != null ){
 			stringBuilder.append("\tquestion='Question("+getQuestion().getId()+")';");
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

