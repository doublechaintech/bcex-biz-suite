package com.doublechaintech.bcex;

import com.doublechaintech.bcex.exam.Exam;
import com.doublechaintech.bcex.platform.PlatformDAO;
import com.doublechaintech.bcex.platform.PlatformJDBCTemplateDAO;
import com.doublechaintech.bcex.useranswer.UserAnswer;
import com.doublechaintech.bcex.wechatuser.WechatUser;

public class CustomBcexUserContextImpl extends BcexBizUserContextImpl{

	protected WechatUser currentUserInfo;
	protected String name;
	protected String avantar;
	protected String quizId;
	protected String answer;
	protected Exam exam;
	protected UserAnswer userAnswer;
	protected String userType;
	
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserAnswer getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswer userAnswer) {
		this.userAnswer = userAnswer;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public String getQuizId() {
		return quizId;
	}

	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvantar() {
		return avantar;
	}

	public void setAvantar(String avantar) {
		this.avantar = avantar;
	}

	public WechatUser getCurrentUserInfo() {
		return currentUserInfo;
	}

	public void setCurrentUserInfo(WechatUser currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

	public PlatformJDBCTemplateDAO dao() {
		return (PlatformJDBCTemplateDAO) this.getDAOGroup().getPlatformDAO();
	}

	
}

