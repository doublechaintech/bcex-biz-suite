
package com.doublechaintech.bcex.question;

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
import com.doublechaintech.bcex.answer.Answer;
import com.doublechaintech.bcex.platform.Platform;
import com.doublechaintech.bcex.answerquestion.AnswerQuestion;
import com.doublechaintech.bcex.useranswer.UserAnswer;

@JsonSerialize(using = QuestionSerializer.class)
public class Question extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TOPIC_PROPERTY                 = "topic"             ;
	public static final String LEVEL_PROPERTY                 = "level"             ;
	public static final String OPTION_A_PROPERTY              = "optionA"           ;
	public static final String OPTION_B_PROPERTY              = "optionB"           ;
	public static final String OPTION_C_PROPERTY              = "optionC"           ;
	public static final String OPTION_D_PROPERTY              = "optionD"           ;
	public static final String OPTION_E_PROPERTY              = "optionE"           ;
	public static final String RIGHT_ANSWER_PROPERTY          = "rightAnswer"       ;
	public static final String PLATFORM_PROPERTY              = "platform"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String ANSWER_QUESTION_LIST                     = "answerQuestionList";
	public static final String ANSWER_LIST                              = "answerList"        ;
	public static final String USER_ANSWER_LIST                         = "userAnswerList"    ;

	public static final String INTERNAL_TYPE="Question";
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
	protected		String              	mLevel              ;
	protected		String              	mOptionA            ;
	protected		String              	mOptionB            ;
	protected		String              	mOptionC            ;
	protected		String              	mOptionD            ;
	protected		String              	mOptionE            ;
	protected		String              	mRightAnswer        ;
	protected		Platform            	mPlatform           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<AnswerQuestion>	mAnswerQuestionList ;
	protected		SmartList<Answer>   	mAnswerList         ;
	protected		SmartList<UserAnswer>	mUserAnswerList     ;
	
		
	public 	Question(){
		// lazy load for all the properties
	}
	public 	static Question withId(String id){
		Question question = new Question();
		question.setId(id);
		question.setVersion(Integer.MAX_VALUE);
		return question;
	}
	public 	static Question refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPlatform( null );

		this.changed = true;
	}
	
	public 	Question(String topic, String level, String optionA, String optionB, String optionC, String optionD, String optionE, String rightAnswer, Platform platform)
	{
		setTopic(topic);
		setLevel(level);
		setOptionA(optionA);
		setOptionB(optionB);
		setOptionC(optionC);
		setOptionD(optionD);
		setOptionE(optionE);
		setRightAnswer(rightAnswer);
		setPlatform(platform);

		this.mAnswerQuestionList = new SmartList<AnswerQuestion>();
		this.mAnswerList = new SmartList<Answer>();
		this.mUserAnswerList = new SmartList<UserAnswer>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			changeTopicProperty(newValueExpr);
		}
		if(LEVEL_PROPERTY.equals(property)){
			changeLevelProperty(newValueExpr);
		}
		if(OPTION_A_PROPERTY.equals(property)){
			changeOptionAProperty(newValueExpr);
		}
		if(OPTION_B_PROPERTY.equals(property)){
			changeOptionBProperty(newValueExpr);
		}
		if(OPTION_C_PROPERTY.equals(property)){
			changeOptionCProperty(newValueExpr);
		}
		if(OPTION_D_PROPERTY.equals(property)){
			changeOptionDProperty(newValueExpr);
		}
		if(OPTION_E_PROPERTY.equals(property)){
			changeOptionEProperty(newValueExpr);
		}
		if(RIGHT_ANSWER_PROPERTY.equals(property)){
			changeRightAnswerProperty(newValueExpr);
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
			
			
			
	protected void changeLevelProperty(String newValueExpr){
		String oldValue = getLevel();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLevel(newValue);
		this.onChangeProperty(LEVEL_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOptionAProperty(String newValueExpr){
		String oldValue = getOptionA();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOptionA(newValue);
		this.onChangeProperty(OPTION_A_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOptionBProperty(String newValueExpr){
		String oldValue = getOptionB();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOptionB(newValue);
		this.onChangeProperty(OPTION_B_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOptionCProperty(String newValueExpr){
		String oldValue = getOptionC();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOptionC(newValue);
		this.onChangeProperty(OPTION_C_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOptionDProperty(String newValueExpr){
		String oldValue = getOptionD();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOptionD(newValue);
		this.onChangeProperty(OPTION_D_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeOptionEProperty(String newValueExpr){
		String oldValue = getOptionE();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOptionE(newValue);
		this.onChangeProperty(OPTION_E_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TOPIC_PROPERTY.equals(property)){
			return getTopic();
		}
		if(LEVEL_PROPERTY.equals(property)){
			return getLevel();
		}
		if(OPTION_A_PROPERTY.equals(property)){
			return getOptionA();
		}
		if(OPTION_B_PROPERTY.equals(property)){
			return getOptionB();
		}
		if(OPTION_C_PROPERTY.equals(property)){
			return getOptionC();
		}
		if(OPTION_D_PROPERTY.equals(property)){
			return getOptionD();
		}
		if(OPTION_E_PROPERTY.equals(property)){
			return getOptionE();
		}
		if(RIGHT_ANSWER_PROPERTY.equals(property)){
			return getRightAnswer();
		}
		if(PLATFORM_PROPERTY.equals(property)){
			return getPlatform();
		}
		if(ANSWER_QUESTION_LIST.equals(property)){
			List<BaseEntity> list = getAnswerQuestionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ANSWER_LIST.equals(property)){
			List<BaseEntity> list = getAnswerList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(USER_ANSWER_LIST.equals(property)){
			List<BaseEntity> list = getUserAnswerList().stream().map(item->item).collect(Collectors.toList());
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
	public Question updateId(String id){
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
	public Question updateTopic(String topic){
		this.mTopic = trimString(topic);;
		this.changed = true;
		return this;
	}
	public void mergeTopic(String topic){
		if(topic != null) { setTopic(topic);}
	}
	
	
	public void setLevel(String level){
		this.mLevel = trimString(level);;
	}
	public String getLevel(){
		return this.mLevel;
	}
	public Question updateLevel(String level){
		this.mLevel = trimString(level);;
		this.changed = true;
		return this;
	}
	public void mergeLevel(String level){
		if(level != null) { setLevel(level);}
	}
	
	
	public void setOptionA(String optionA){
		this.mOptionA = trimString(optionA);;
	}
	public String getOptionA(){
		return this.mOptionA;
	}
	public Question updateOptionA(String optionA){
		this.mOptionA = trimString(optionA);;
		this.changed = true;
		return this;
	}
	public void mergeOptionA(String optionA){
		if(optionA != null) { setOptionA(optionA);}
	}
	
	
	public void setOptionB(String optionB){
		this.mOptionB = trimString(optionB);;
	}
	public String getOptionB(){
		return this.mOptionB;
	}
	public Question updateOptionB(String optionB){
		this.mOptionB = trimString(optionB);;
		this.changed = true;
		return this;
	}
	public void mergeOptionB(String optionB){
		if(optionB != null) { setOptionB(optionB);}
	}
	
	
	public void setOptionC(String optionC){
		this.mOptionC = trimString(optionC);;
	}
	public String getOptionC(){
		return this.mOptionC;
	}
	public Question updateOptionC(String optionC){
		this.mOptionC = trimString(optionC);;
		this.changed = true;
		return this;
	}
	public void mergeOptionC(String optionC){
		if(optionC != null) { setOptionC(optionC);}
	}
	
	
	public void setOptionD(String optionD){
		this.mOptionD = trimString(optionD);;
	}
	public String getOptionD(){
		return this.mOptionD;
	}
	public Question updateOptionD(String optionD){
		this.mOptionD = trimString(optionD);;
		this.changed = true;
		return this;
	}
	public void mergeOptionD(String optionD){
		if(optionD != null) { setOptionD(optionD);}
	}
	
	
	public void setOptionE(String optionE){
		this.mOptionE = trimString(optionE);;
	}
	public String getOptionE(){
		return this.mOptionE;
	}
	public Question updateOptionE(String optionE){
		this.mOptionE = trimString(optionE);;
		this.changed = true;
		return this;
	}
	public void mergeOptionE(String optionE){
		if(optionE != null) { setOptionE(optionE);}
	}
	
	
	public void setRightAnswer(String rightAnswer){
		this.mRightAnswer = trimString(rightAnswer);;
	}
	public String getRightAnswer(){
		return this.mRightAnswer;
	}
	public Question updateRightAnswer(String rightAnswer){
		this.mRightAnswer = trimString(rightAnswer);;
		this.changed = true;
		return this;
	}
	public void mergeRightAnswer(String rightAnswer){
		if(rightAnswer != null) { setRightAnswer(rightAnswer);}
	}
	
	
	public void setPlatform(Platform platform){
		this.mPlatform = platform;;
	}
	public Platform getPlatform(){
		return this.mPlatform;
	}
	public Question updatePlatform(Platform platform){
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
	public Question updateVersion(int version){
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
			answerQuestion.setQuestion(this);
		}

		this.mAnswerQuestionList = answerQuestionList;
		this.mAnswerQuestionList.setListInternalName (ANSWER_QUESTION_LIST );
		
	}
	
	public  void addAnswerQuestion(AnswerQuestion answerQuestion){
		answerQuestion.setQuestion(this);
		getAnswerQuestionList().add(answerQuestion);
	}
	public  void addAnswerQuestionList(SmartList<AnswerQuestion> answerQuestionList){
		for( AnswerQuestion answerQuestion:answerQuestionList){
			answerQuestion.setQuestion(this);
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
        // answerQuestion.clearQuestion(); //disconnect with Question
        answerQuestion.clearFromAll(); //disconnect with Question
		
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
		answerQuestion.setQuestion(null);
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
	
	
	


	public  SmartList<Answer> getAnswerList(){
		if(this.mAnswerList == null){
			this.mAnswerList = new SmartList<Answer>();
			this.mAnswerList.setListInternalName (ANSWER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mAnswerList;	
	}
	public  void setAnswerList(SmartList<Answer> answerList){
		for( Answer answer:answerList){
			answer.setQuestion(this);
		}

		this.mAnswerList = answerList;
		this.mAnswerList.setListInternalName (ANSWER_LIST );
		
	}
	
	public  void addAnswer(Answer answer){
		answer.setQuestion(this);
		getAnswerList().add(answer);
	}
	public  void addAnswerList(SmartList<Answer> answerList){
		for( Answer answer:answerList){
			answer.setQuestion(this);
		}
		getAnswerList().addAll(answerList);
	}
	public  void mergeAnswerList(SmartList<Answer> answerList){
		if(answerList==null){
			return;
		}
		if(answerList.isEmpty()){
			return;
		}
		addAnswerList( answerList );
		
	}
	public  Answer removeAnswer(Answer answerIndex){
		
		int index = getAnswerList().indexOf(answerIndex);
        if(index < 0){
        	String message = "Answer("+answerIndex.getId()+") with version='"+answerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Answer answer = getAnswerList().get(index);        
        // answer.clearQuestion(); //disconnect with Question
        answer.clearFromAll(); //disconnect with Question
		
		boolean result = getAnswerList().planToRemove(answer);
        if(!result){
        	String message = "Answer("+answerIndex.getId()+") with version='"+answerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return answer;
        
	
	}
	//断舍离
	public  void breakWithAnswer(Answer answer){
		
		if(answer == null){
			return;
		}
		answer.setQuestion(null);
		//getAnswerList().remove();
	
	}
	
	public  boolean hasAnswer(Answer answer){
	
		return getAnswerList().contains(answer);
  
	}
	
	public void copyAnswerFrom(Answer answer) {

		Answer answerInList = findTheAnswer(answer);
		Answer newAnswer = new Answer();
		answerInList.copyTo(newAnswer);
		newAnswer.setVersion(0);//will trigger copy
		getAnswerList().add(newAnswer);
		addItemToFlexiableObject(COPIED_CHILD, newAnswer);
	}
	
	public  Answer findTheAnswer(Answer answer){
		
		int index =  getAnswerList().indexOf(answer);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Answer("+answer.getId()+") with version='"+answer.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getAnswerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpAnswerList(){
		getAnswerList().clear();
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
			userAnswer.setQuestion(this);
		}

		this.mUserAnswerList = userAnswerList;
		this.mUserAnswerList.setListInternalName (USER_ANSWER_LIST );
		
	}
	
	public  void addUserAnswer(UserAnswer userAnswer){
		userAnswer.setQuestion(this);
		getUserAnswerList().add(userAnswer);
	}
	public  void addUserAnswerList(SmartList<UserAnswer> userAnswerList){
		for( UserAnswer userAnswer:userAnswerList){
			userAnswer.setQuestion(this);
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
        // userAnswer.clearQuestion(); //disconnect with Question
        userAnswer.clearFromAll(); //disconnect with Question
		
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
		userAnswer.setQuestion(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPlatform(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getAnswerQuestionList(), internalType);
		collectFromList(this, entityList, getAnswerList(), internalType);
		collectFromList(this, entityList, getUserAnswerList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getAnswerQuestionList());
		listOfList.add( getAnswerList());
		listOfList.add( getUserAnswerList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TOPIC_PROPERTY, getTopic());
		appendKeyValuePair(result, LEVEL_PROPERTY, getLevel());
		appendKeyValuePair(result, OPTION_A_PROPERTY, getOptionA());
		appendKeyValuePair(result, OPTION_B_PROPERTY, getOptionB());
		appendKeyValuePair(result, OPTION_C_PROPERTY, getOptionC());
		appendKeyValuePair(result, OPTION_D_PROPERTY, getOptionD());
		appendKeyValuePair(result, OPTION_E_PROPERTY, getOptionE());
		appendKeyValuePair(result, RIGHT_ANSWER_PROPERTY, getRightAnswer());
		appendKeyValuePair(result, PLATFORM_PROPERTY, getPlatform());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, ANSWER_QUESTION_LIST, getAnswerQuestionList());
		if(!getAnswerQuestionList().isEmpty()){
			appendKeyValuePair(result, "answerQuestionCount", getAnswerQuestionList().getTotalCount());
			appendKeyValuePair(result, "answerQuestionCurrentPageNumber", getAnswerQuestionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ANSWER_LIST, getAnswerList());
		if(!getAnswerList().isEmpty()){
			appendKeyValuePair(result, "answerCount", getAnswerList().getTotalCount());
			appendKeyValuePair(result, "answerCurrentPageNumber", getAnswerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, USER_ANSWER_LIST, getUserAnswerList());
		if(!getUserAnswerList().isEmpty()){
			appendKeyValuePair(result, "userAnswerCount", getUserAnswerList().getTotalCount());
			appendKeyValuePair(result, "userAnswerCurrentPageNumber", getUserAnswerList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Question){
		
		
			Question dest =(Question)baseDest;
		
			dest.setId(getId());
			dest.setTopic(getTopic());
			dest.setLevel(getLevel());
			dest.setOptionA(getOptionA());
			dest.setOptionB(getOptionB());
			dest.setOptionC(getOptionC());
			dest.setOptionD(getOptionD());
			dest.setOptionE(getOptionE());
			dest.setRightAnswer(getRightAnswer());
			dest.setPlatform(getPlatform());
			dest.setVersion(getVersion());
			dest.setAnswerQuestionList(getAnswerQuestionList());
			dest.setAnswerList(getAnswerList());
			dest.setUserAnswerList(getUserAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Question){
		
			
			Question dest =(Question)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeLevel(getLevel());
			dest.mergeOptionA(getOptionA());
			dest.mergeOptionB(getOptionB());
			dest.mergeOptionC(getOptionC());
			dest.mergeOptionD(getOptionD());
			dest.mergeOptionE(getOptionE());
			dest.mergeRightAnswer(getRightAnswer());
			dest.mergePlatform(getPlatform());
			dest.mergeVersion(getVersion());
			dest.mergeAnswerQuestionList(getAnswerQuestionList());
			dest.mergeAnswerList(getAnswerList());
			dest.mergeUserAnswerList(getUserAnswerList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Question){
		
			
			Question dest =(Question)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTopic(getTopic());
			dest.mergeLevel(getLevel());
			dest.mergeOptionA(getOptionA());
			dest.mergeOptionB(getOptionB());
			dest.mergeOptionC(getOptionC());
			dest.mergeOptionD(getOptionD());
			dest.mergeOptionE(getOptionE());
			dest.mergeRightAnswer(getRightAnswer());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Question{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttopic='"+getTopic()+"';");
		stringBuilder.append("\tlevel='"+getLevel()+"';");
		stringBuilder.append("\toptionA='"+getOptionA()+"';");
		stringBuilder.append("\toptionB='"+getOptionB()+"';");
		stringBuilder.append("\toptionC='"+getOptionC()+"';");
		stringBuilder.append("\toptionD='"+getOptionD()+"';");
		stringBuilder.append("\toptionE='"+getOptionE()+"';");
		stringBuilder.append("\trightAnswer='"+getRightAnswer()+"';");
		if(getPlatform() != null ){
 			stringBuilder.append("\tplatform='Platform("+getPlatform().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

