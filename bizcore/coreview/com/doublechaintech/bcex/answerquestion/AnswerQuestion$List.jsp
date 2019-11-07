<%@ page import='java.util.*,com.doublechaintech.bcex.*'%>
<%@ page language="java" contentType="text/plain; charset=utf-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sky" tagdir="/tags"%>
<fmt:setLocale value="zh_CN"/>
<c:set var="ignoreListAccessControl" value="${true}"/>


<c:if test="${ empty answerQuestionList}" >
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		 ${userContext.localeMap['@not_found']}${userContext.localeMap['answer_question']}! 
		 <a href="./${ownerBeanName}Manager/addAnswerQuestion/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 
		 
		 </div>
	</div>

</c:if>




	

 <c:if test="${not empty answerQuestionList}" >
    
    
<%

 	SmartList list=(SmartList)request.getAttribute("answerQuestionList"); 
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
		<i class='fa fa-table'></i> ${userContext.localeMap['answer_question']}(${totalCount})
		<a href="./${ownerBeanName}Manager/addAnswerQuestion/${result.id}/"><i class="fa fa-plus-square" aria-hidden="true"></i></a>
		 
		 		 	<div class="btn-group" role="group" aria-label="Button group with nested dropdown">		
	<c:forEach var="action" items="${result.actionList}">
		<c:if test="${'answerQuestionList' eq action.actionGroup}">
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
		<a href='#${ownerBeanName}Manager/load${ownerClassName}/${result.id}/${answerQuestionListName};${answerQuestionListName}CurrentPage=${page.pageNumber};${answerQuestionListName}RowsPerPage=${rowsPerPage}/' 
			class='page-link page-action '>${page.title}</a>
	</li>
</c:forEach>
 </ul>
</nav>


   


	<table class="table table-striped" pageToken='answerQuestionListCurrentPage=${currentPageNumber}'>
		<thead><tr>
		<c:if test="${param.referName ne 'id'}">
	<th>${userContext.localeMap['answer_question.id']}</th>
</c:if>
<c:if test="${param.referName ne 'nickName'}">
	<th>${userContext.localeMap['answer_question.nick_name']}</th>
</c:if>
<c:if test="${param.referName ne 'user'}">
	<th>${userContext.localeMap['answer_question.user']}</th>
</c:if>
<c:if test="${param.referName ne 'question'}">
	<th>${userContext.localeMap['answer_question.question']}</th>
</c:if>
<c:if test="${param.referName ne 'answer'}">
	<th>${userContext.localeMap['answer_question.answer']}</th>
</c:if>
<c:if test="${param.referName ne 'changeRequest'}">
	<th>${userContext.localeMap['answer_question.change_request']}</th>
</c:if>
<th>${userContext.localeMap['@action']}</th>
		</tr></thead>
		<tbody>
			
			<c:forEach var="item" items="${answerQuestionList}">
				<tr currentVersion='${item.version}' id="answerQuestion-${item.id}" ><td><a class="link-action-removed" href="./answerQuestionManager/view/${item.id}/"> ${item.id}</a></td>
<c:if test="${param.referName ne 'nickName'}">	<td contenteditable='true' class='edit-value'  propertyToChange='nickName' storedCellValue='${item.nickName}' prefix='${ownerBeanName}Manager/updateAnswerQuestion/${result.id}/${item.id}/'>${item.nickName}</td>
</c:if><c:if test="${param.referName ne 'user'}">
	<td class="select_candidate_td"
			data-candidate-method="./answerQuestionManager/requestCandidateUser/${ownerBeanName}/${item.id}/"
			data-switch-method="./answerQuestionManager/transferToAnotherUser/${item.id}/"
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
<c:if test="${param.referName ne 'question'}">
	<td class="select_candidate_td"
			data-candidate-method="./answerQuestionManager/requestCandidateQuestion/${ownerBeanName}/${item.id}/"
			data-switch-method="./answerQuestionManager/transferToAnotherQuestion/${item.id}/"
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
<c:if test="${param.referName ne 'answer'}">	<td contenteditable='true' class='edit-value'  propertyToChange='answer' storedCellValue='${item.answer}' prefix='${ownerBeanName}Manager/updateAnswerQuestion/${result.id}/${item.id}/'>${item.answer}</td>
</c:if><c:if test="${param.referName ne 'changeRequest'}">
	<td class="select_candidate_td"
			data-candidate-method="./answerQuestionManager/requestCandidateChangeRequest/${ownerBeanName}/${item.id}/"
			data-switch-method="./answerQuestionManager/transferToAnotherChangeRequest/${item.id}/"
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

				<a href='#${ownerBeanName}Manager/removeAnswerQuestion/${result.id}/${item.id}/' class='delete-action btn btn-danger btn-xs'><i class="fa fa-trash-o fa-lg"></i> ${userContext.localeMap['@delete']}</a>
				<a href='#${ownerBeanName}Manager/copyAnswerQuestionFrom/${result.id}/${item.id}/' class='copy-action btn btn-success btn-xs'><i class="fa fa-files-o fa-lg"></i> ${userContext.localeMap['@copy']} </a>

				</td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>	
	

</div></c:if>


