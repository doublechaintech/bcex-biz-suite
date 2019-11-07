
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty userAnswer}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A UserAnswer">${userContext.localeMap['user_answer']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./userAnswerManager/view/${userAnswer.id}/"> ${userAnswer.id}</a></li>
<li><span>${userContext.localeMap['user_answer.topic']}</span> ${userAnswer.topic}</li>
<li><span>${userContext.localeMap['user_answer.user_select']}</span> ${userAnswer.userSelect}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




