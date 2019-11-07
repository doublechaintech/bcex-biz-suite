
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty changeRequestType}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ChangeRequestType">${userContext.localeMap['change_request_type']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./changeRequestTypeManager/view/${changeRequestType.id}/"> ${changeRequestType.id}</a></li>
<li><span>${userContext.localeMap['change_request_type.name']}</span> ${changeRequestType.name}</li>
<li><span>${userContext.localeMap['change_request_type.code']}</span> ${changeRequestType.code}</li>
<li><span>${userContext.localeMap['change_request_type.icon']}</span> ${changeRequestType.icon}</li>
<li><span>${userContext.localeMap['change_request_type.display_order']}</span> ${changeRequestType.displayOrder}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




