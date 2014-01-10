<%@ include file="/WEB-INF/jsps/include.jsp"%>

<div id="form">
	<form:form action="${contextPathWeb}/admin/runners/save" modelAttribute="runnerForm" method="POST">	
		<div id="label">Nick</div>:	<form:input path="nickname" /><br/>
		<font color="red"><form:errors path="nickname"/></font><br/>
		<div id="label">Name</div>:	<form:input path="name" /><br/>
		<font color="red"><form:errors path="name"/></font><br/>
		<div id="label">Surname</div>:	<form:input path="surname" /><br/>
		<font color="red"><form:errors path="surname"/></font><br/>
			
		<div id="operations">
			<input type="submit" value="Save"/>
			<div id="operations-link"><a href="${contextPathWeb}/admin/runners/index">Back</a></div>
		</div>			
		<form:hidden path="id" />
	</form:form>
</div>
