
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty changeRequest}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A ChangeRequest">${userContext.localeMap['change_request']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./changeRequestManager/view/${changeRequest.id}/"> ${changeRequest.id}</a></li>
<li><span>${userContext.localeMap['change_request.name']}</span> ${changeRequest.name}</li>
<li><span>${userContext.localeMap['change_request.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${changeRequest.createTime}" /></li>
<li><span>${userContext.localeMap['change_request.remote_ip']}</span> ${changeRequest.remoteIp}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




