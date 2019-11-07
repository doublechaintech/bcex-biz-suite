
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty registeration}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A Registeration" style="color: green">${userContext.localeMap['registeration']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['registeration.id']}</span> ${registeration.id}</li>
<li><span>${userContext.localeMap['registeration.nick_name']}</span> ${registeration.nickName}</li>
<li><span>${userContext.localeMap['registeration.avarta']}</span> ${registeration.avarta}</li>

	
	</ul>
</div>



</c:if>


