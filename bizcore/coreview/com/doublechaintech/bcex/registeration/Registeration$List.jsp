<%@ page import='java.util.*,com.doublechaintech.bcex.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty registerationList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['registeration']}! 
		 <a href="./${ownerBeanName}Manager/addRegisteration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty registerationList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("registerationList"); 
 	int totalCount = list.getTotalCount();
 	List pages = list.getPages();
 	pageContext.setAttribute("rowsPerPage",list.getRowsPerPage()); 
 	
 	pageContext.setAttribute("pages",pages); 
 	pageContext.setAttribute("totalCount",totalCount); 
 	//pageContext.setAttribute("accessible",list.isAccessible()); 
 	//the reason using scriptlet here is the el express is currently not able resolv common property from a subclass of list
%>
    
 	   
    <div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		<i class='fa fa-table'></i> ${userContext.localeMap['registeration']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addRegisteration/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'registerationList' eq action.actionGroup}">
		<a class="btn btn-${action.actionLevel} btn-sm" href="${action.managerBeanName}/${action.actionPath}">${userContext.localeMap[action.localeKey]}</a>
		</c:if>
	</c:forEach>
	</div><!--end of div class="btn-group" -->
	
		 
		 
		 
		 </div>
 </div>
    
    
<div class="table-responsive">


<c:set var="currentPageNumber" value="1"/>	



<nav aria-label="Page navigation example">
  <ul class="pagination">
<c:forEach var="page" items="${pages}"> 
<c:set var="classType" value=""/>
<c:if test='${page.selected}' >
<c:set var="classType" value="active"/>
<c:set var="currentPageNumber" value="${page.pageNumber}"/>
</c:if>


	<li class="page-item ${classType}">
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${registerationListName};${registerationListName}CurrentPage=${page.pageNumber};${registerationListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='registerationListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['registeration.id']}</th>
</c:if>
<c:if test="${param.referName ne 'nickName'}">
	<th>${userContext.localeMap['registeration.nick_name']}</th>
</c:if>
<c:if test="${param.referName ne 'avarta'}">
	<th>${userContext.localeMap['registeration.avarta']}</th>
</c:if>
<c:if test="${param.referName ne 'changeRequest'}">
	<th>${userContext.localeMap['registeration.change_request']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${registerationList}">
				<tr currentVersion='${item.version}' id="registeration-${item.id}" ><td><a class="link-action-removed" href="./registerationManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'nickName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nickName' storedCellValue='${item.nickName}' prefix='${ownerBeanName}Manager/updateRegisteration/${result.id}/${item.id}/'>${item.nickName}</td>
</c:if><c:if test="${param.referName ne 'avarta'}">	<td contenteditable='true' class='edit-value'  propertyToChange='avarta' storedCellValue='${item.avarta}' prefix='${ownerBeanName}Manager/updateRegisteration/${result.id}/${item.id}/'>${item.avarta}</td>
</c:if><c:if test="${param.referName ne 'changeRequest'}">
	<td class="select_candidate_td"
			data-candidate-method="./registerationManager/requestCandidateChangeRequest/${ownerBeanName}/${item.id}/"
			data-switch-method="./registerationManager/transferToAnotherChangeRequest/${item.id}/"
			data-link-template="./changeRequestManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.changeRequest}">
			<a href='./changeRequestManager/view/${item.changeRequest.id}/'>${item.changeRequest.displayName}</a>
			</c:if>
			<c:if test="${empty  item.changeRequest}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>

				<td>

				<a href='#${ownerBeanName}Manager/removeRegisteration/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyRegisterationFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


