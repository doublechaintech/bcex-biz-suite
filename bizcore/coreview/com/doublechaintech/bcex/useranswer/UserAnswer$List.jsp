<%@ page import='java.util.*,com.doublechaintech.bcex.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty userAnswerList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['user_answer']}! 
		 <a href="./${ownerBeanName}Manager/addUserAnswer/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty userAnswerList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("userAnswerList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['user_answer']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addUserAnswer/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'userAnswerList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${userAnswerListName};${userAnswerListName}CurrentPage=${page.pageNumber};${userAnswerListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='userAnswerListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['user_answer.id']}</th>
</c:if>
<c:if test="${param.referName ne 'topic'}">
	<th>${userContext.localeMap['user_answer.topic']}</th>
</c:if>
<c:if test="${param.referName ne 'userSelect'}">
	<th>${userContext.localeMap['user_answer.user_select']}</th>
</c:if>
<c:if test="${param.referName ne 'question'}">
	<th>${userContext.localeMap['user_answer.question']}</th>
</c:if>
<c:if test="${param.referName ne 'exam'}">
	<th>${userContext.localeMap['user_answer.exam']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${userAnswerList}">
				<tr currentVersion='${item.version}' id="userAnswer-${item.id}" ><td><a class="link-action-removed" href="./userAnswerManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'topic'}">	<td contenteditable='true' class='edit-value'  propertyToChange='topic' storedCellValue='${item.topic}' prefix='${ownerBeanName}Manager/updateUserAnswer/${result.id}/${item.id}/'>${item.topic}</td>
</c:if><c:if test="${param.referName ne 'userSelect'}">	<td contenteditable='true' class='edit-value'  propertyToChange='userSelect' storedCellValue='${item.userSelect}' prefix='${ownerBeanName}Manager/updateUserAnswer/${result.id}/${item.id}/'>${item.userSelect}</td>
</c:if><c:if test="${param.referName ne 'question'}">
	<td class="select_candidate_td"
			data-candidate-method="./userAnswerManager/requestCandidateQuestion/${ownerBeanName}/${item.id}/"
			data-switch-method="./userAnswerManager/transferToAnotherQuestion/${item.id}/"
			data-link-template="./questionManager/view/${'$'}{ID}/">
		<span class="display_span">
			<c:if test="${not empty  item.question}">
			<a href='./questionManager/view/${item.question.id}/'>${item.question.displayName}</a>
			</c:if>
			<c:if test="${empty  item.question}">
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
			data-candidate-method="./userAnswerManager/requestCandidateExam/${ownerBeanName}/${item.id}/"
			data-switch-method="./userAnswerManager/transferToAnotherExam/${item.id}/"
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

				<a href='#${ownerBeanName}Manager/removeUserAnswer/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyUserAnswerFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


