<%@ include file="/WEB-INF/jsps/include.jsp"%>
	
<div id="head">
	<div id="head-column">Name</div>
	<div id="head-column">Surname</div>
	<div id="head-column">Operations</div>
</div>
<div id="rows">
	<c:forEach items="${list}" var="runner">
   		<div id="row-column"><c:out value="${runner.name}"/></div>
   		<div id="row-column"><c:out value="${runner.surname}"/></div>
   		<div id="row-column">
   			<a href="${contextPathWeb}/admin/runners/edit/${runner.id}"><spring:message code="label.edit"/></a> |
   			<a href="${contextPathWeb}/admin/runners/delete/${runner.id}"><spring:message code="label.delete"/></a>
   		</div>
   	</c:forEach>		
</div>
<div id="operations">
	<div id="operations-link"><a href="${contextPathWeb}/admin/runners/create"><spring:message code="label.add"/></a></div>
</div>	
