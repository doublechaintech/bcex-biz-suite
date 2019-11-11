
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty faultAnswer}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A FaultAnswer" style="color: green">${userContext.localeMap['fault_answer']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['fault_answer.id']}</span> ${faultAnswer.id}</li>
<li><span>${userContext.localeMap['fault_answer.topic']}</span> ${faultAnswer.topic}</li>
<li><span>${userContext.localeMap['fault_answer.your_answer']}</span> ${faultAnswer.yourAnswer}</li>
<li><span>${userContext.localeMap['fault_answer.right_answer']}</span> ${faultAnswer.rightAnswer}</li>
<li><span>${userContext.localeMap['fault_answer.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${faultAnswer.createTime}" /></li>
<li><span>${userContext.localeMap['fault_answer.fault_times']}</span> ${faultAnswer.faultTimes}</li>

	
	</ul>
</div>



</c:if>


