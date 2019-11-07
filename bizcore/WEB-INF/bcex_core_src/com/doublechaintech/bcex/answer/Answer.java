
package com.doublechaintech.bcex.answer;

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
import com.doublechaintech.bcex.question.Question;

@JsonSerialize(using = AnswerSerializer.class)
public class Answer extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String QUESTION_PROPERTY              = "question"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="Answer";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		String              	mComment            ;
	protected		Question            	mQuestion           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	Answer(){
		// lazy load for all the properties
	}
	public 	static Answer withId(String id){
		Answer answer = new Answer();
		answer.setId(id);
		answer.setVersion(Integer.MAX_VALUE);
		return answer;
	}
	public 	static Answer refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setQuestion( null );

		this.changed = true;
	}
	
	public 	Answer(String title, String comment, Question question)
	{
		setTitle(title);
		setComment(comment);
		setQuestion(question);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCommentProperty(String newValueExpr){
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComment(newValue);
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(COMMENT_PROPERTY.equals(property)){
			return getComment();
		}
		if(QUESTION_PROPERTY.equals(property)){
			return getQuestion();
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
	public Answer updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Answer updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	public Answer updateComment(String comment){
		this.mComment = trimString(comment);;
		this.changed = true;
		return this;
	}
	public void mergeComment(String comment){
		if(comment != null) { setComment(comment);}
	}
	
	
	public void setQuestion(Question question){
		this.mQuestion = question;;
	}
	public Question getQuestion(){
		return this.mQuestion;
	}
	public Answer updateQuestion(Question question){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Answer updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getQuestion(), internalType);

		
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
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
		appendKeyValuePair(result, QUESTION_PROPERTY, getQuestion());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Answer){
		
		
			Answer dest =(Answer)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setComment(getComment());
			dest.setQuestion(getQuestion());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Answer){
		
			
			Answer dest =(Answer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeComment(getComment());
			dest.mergeQuestion(getQuestion());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Answer){
		
			
			Answer dest =(Answer)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeComment(getComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Answer{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\tcomment='"+getComment()+"';");
		if(getQuestion() != null ){
 			stringBuilder.append("\tquestion='Question("+getQuestion().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

