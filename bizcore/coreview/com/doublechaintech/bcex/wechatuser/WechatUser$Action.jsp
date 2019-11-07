
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatUser}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A WechatUser" style="color: green">${userContext.localeMap['wechat_user']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['wechat_user.id']}</span> ${wechatUser.id}</li>
<li><span>${userContext.localeMap['wechat_user.name']}</span> ${wechatUser.name}</li>
<li><span>${userContext.localeMap['wechat_user.avarta']}</span> ${wechatUser.avarta}</li>
<li><span>${userContext.localeMap['wechat_user.create_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatUser.createTime}" /></li>

	
	</ul>
</div>



</c:if>


