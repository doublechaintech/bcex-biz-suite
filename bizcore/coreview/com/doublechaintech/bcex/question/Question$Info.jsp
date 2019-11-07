
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty question}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Question">${userContext.localeMap['question']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./questionManager/view/${question.id}/"> ${question.id}</a></li>
<li><span>${userContext.localeMap['question.topic']}</span> ${question.topic}</li>
<li><span>${userContext.localeMap['question.level']}</span> ${question.level}</li>
<li><span>${userContext.localeMap['question.option_a']}</span> ${question.optionA}</li>
<li><span>${userContext.localeMap['question.option_b']}</span> ${question.optionB}</li>
<li><span>${userContext.localeMap['question.option_c']}</span> ${question.optionC}</li>
<li><span>${userContext.localeMap['question.option_d']}</span> ${question.optionD}</li>
<li><span>${userContext.localeMap['question.option_e']}</span> ${question.optionE}</li>
<li><span>${userContext.localeMap['question.right_answer']}</span> ${question.rightAnswer}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




