
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty changeRequestType}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A ChangeRequestType" style="color: green">${userContext.localeMap['change_request_type']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['change_request_type.id']}</span> ${changeRequestType.id}</li>
<li><span>${userContext.localeMap['change_request_type.name']}</span> ${changeRequestType.name}</li>
<li><span>${userContext.localeMap['change_request_type.code']}</span> ${changeRequestType.code}</li>
<li><span>${userContext.localeMap['change_request_type.icon']}</span> ${changeRequestType.icon}</li>
<li><span>${userContext.localeMap['change_request_type.display_order']}</span> ${changeRequestType.displayOrder}</li>

	
	</ul>
</div>



</c:if>


