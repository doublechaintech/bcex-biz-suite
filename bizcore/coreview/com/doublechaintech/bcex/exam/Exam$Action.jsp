
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty exam}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Exam" style="color: green">${userContext.localeMap['exam']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['exam.id']}</span> ${exam.id}</li>
<li><span>${userContext.localeMap['exam.name']}</span> ${exam.name}</li>
<li><span>${userContext.localeMap['exam.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${exam.createTime}" /></li>
<li><span>${userContext.localeMap['exam.score']}</span> ${exam.score}</li>

	
	</ul>
</div>



</c:if>


