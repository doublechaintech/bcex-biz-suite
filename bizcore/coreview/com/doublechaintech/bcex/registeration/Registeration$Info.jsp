
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty registeration}">
<div class="col-xs-12 col-ms-6 col-md-4 section">
	
	<div class="inner-section">
	
	<b title="A Registeration">${userContext.localeMap['registeration']} ${referName}</b><a href="#"><i class="fa fa-refresh" aria-hidden="true"></i></a>
	<hr/>
	<ul>
	
	
	<li><span>ID</span><a class="link-action-removed" href="./registerationManager/view/${registeration.id}/"> ${registeration.id}</a></li>
<li><span>${userContext.localeMap['registeration.nick_name']}</span> ${registeration.nickName}</li>
<li><span>${userContext.localeMap['registeration.avarta']}</span> ${registeration.avarta}</li>

	
	</ul>
	
	</div><!-- end of inner-section -->
	
</div>

</c:if>




