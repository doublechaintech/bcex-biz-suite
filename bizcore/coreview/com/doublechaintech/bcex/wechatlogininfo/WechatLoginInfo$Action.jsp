
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${not empty wechatLoginInfo}">

<div class="col-xs-12 col-ms-4 col-md-3 action-section" >
	<b title="A WechatLoginInfo" style="color: green">${userContext.localeMap['wechat_login_info']}</b>
	<hr/>
	<ul>
	
	
	<li><span>${userContext.localeMap['wechat_login_info.id']}</span> ${wechatLoginInfo.id}</li>
<li><span>${userContext.localeMap['wechat_login_info.app_id']}</span> ${wechatLoginInfo.appId}</li>
<li><span>${userContext.localeMap['wechat_login_info.open_id']}</span> ${wechatLoginInfo.openId}</li>
<li><span>${userContext.localeMap['wechat_login_info.session_key']}</span> ${wechatLoginInfo.sessionKey}</li>
<li><span>${userContext.localeMap['wechat_login_info.last_update_time']}</span> <fmt:formatDate pattern="yyyy-MM-dd" value="${wechatLoginInfo.lastUpdateTime}" /></li>

	
	</ul>
</div>



</c:if>


