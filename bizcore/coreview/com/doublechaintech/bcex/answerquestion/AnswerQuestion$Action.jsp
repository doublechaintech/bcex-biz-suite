
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty answerQuestion}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A AnswerQuestion" style="color: green">${userContext.localeMap['answer_question']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['answer_question.id']}</span> ${answerQuestion.id}</li>
<li><span>${userContext.localeMap['answer_question.nick_name']}</span> ${answerQuestion.nickName}</li>
<li><span>${userContext.localeMap['answer_question.answer']}</span> ${answerQuestion.answer}</li>

	
	</ul>
</div>



</c:if>


