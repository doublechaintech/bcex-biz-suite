<%@ page import='java.util.*,com.doublechaintech.bcex.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty faultAnswerList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['fault_answer']}! 
		 <a href="./${ownerBeanName}Manager/addFaultAnswer/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty faultAnswerList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("faultAnswerList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['fault_answer']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addFaultAnswer/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'faultAnswerList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${faultAnswerListName};${faultAnswerListName}CurrentPage=${page.pageNumber};${faultAnswerListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='faultAnswerListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['fault_answer.id']}</th>
</c:if>
<c:if test="${param.referName ne 'topic'}">
	<th>${userContext.localeMap['fault_answer.topic']}</th>
</c:if>
<c:if test="${param.referName ne 'yourAnswer'}">
	<th>${userContext.localeMap['fault_answer.your_answer']}</th>
</c:if>
<c:if test="${param.referName ne 'rightAnswer'}">
	<th>${userContext.localeMap['fault_answer.right_answer']}</th>
</c:if>
<c:if test="${param.referName ne 'createTime'}">
	<th>${userContext.localeMap['fault_answer.create_time']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['fault_answer.user']}</th>
</c:if>
<c:if test="${param.referName ne 'exam'}">
	<th>${userContext.localeMap['fault_answer.exam']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${faultAnswerList}">
				<tr currentVersion='${item.version}' id="faultAnswer-${item.id}" ><td><a class="link-action-removed" href="./faultAnswerManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'topic'}">	<td contenteditable='true' class='edit-value'  propertyToChange='topic' storedCellValue='${item.topic}' prefix='${ownerBeanName}Manager/updateFaultAnswer/${result.id}/${item.id}/'>${item.topic}</td>
</c:if><c:if test="${param.referName ne 'yourAnswer'}">	<td contenteditable='true' class='edit-value'  propertyToChange='yourAnswer' storedCellValue='${item.yourAnswer}' prefix='${ownerBeanName}Manager/updateFaultAnswer/${result.id}/${item.id}/'>${item.yourAnswer}</td>
</c:if><c:if test="${param.referName ne 'rightAnswer'}">	<td contenteditable='true' class='edit-value'  propertyToChange='rightAnswer' storedCellValue='${item.rightAnswer}' prefix='${ownerBeanName}Manager/updateFaultAnswer/${result.id}/${item.id}/'>${item.rightAnswer}</td>
</c:if><c:if test="${param.referName ne 'createTime'}">	<td contenteditable='true' class='edit-value'  propertyToChange='createTime' storedCellValue='${item.createTime}' prefix='${ownerBeanName}Manager/updateFaultAnswer/${result.id}/${item.id}/'><fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${item.createTime}" /></td>
</c:if><c:if test="${param.referName ne 'user'}">
	<td class="select_candidate_td"
			data-candidate-method="./faultAnswerManager/requestCandidateUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./faultAnswerManager/transferToAnotherUser/${item.id}/"
			data-link-template="./wechatUserManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.user}">
			<a href='./wechatUserManager/view/${item.user.id}/'>${item.user.displayName}</a>
			</c:if>
			<c:if test="${empty  item.user}">
			<a href='#'></a>
			</c:if>
			<button class="btn btn-link candidate-action">...</button>
		</span>
		<div class="candidate_span" style="display:none;">
			<input type="text" data-provide="typeahead" class="input-sm form-control candidate-filter-input" autocomplete="off" />
		</div>
	</td>
</c:if>
<c:if test="${param.referName ne 'exam'}">
	<td class="select_candidate_td"
			data-candidate-method="./faultAnswerManager/requestCandidateExam/${ownerBeanName}/${item.id}/"
			data-switch-method="./faultAnswerManager/transferToAnotherExam/${item.id}/"
			data-link-template="./examManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.exam}">
			<a href='./examManager/view/${item.exam.id}/'>${item.exam.displayName}</a>
			</c:if>
			<c:if test="${empty  item.exam}">
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

				<a href='#${ownerBeanName}Manager/removeFaultAnswer/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyFaultAnswerFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


