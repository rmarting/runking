<%@ include file="/WEB-INF/jsps/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:insertAttribute name="title" ignore="true" /> :: <spring:message code="company"/></title>
	<!-- TODO incluir Twitter Bootstrap -->
	
	<%-- Themes Resources --%>
	<link rel="stylesheet" href="${contextPath}/<spring:theme code="css"/>" type="text/css"/>
</head>
<body>
<span style="float: right">
	<a href="?lang=es">es</a> | <a href="?lang=en">en</a>
</span>
<span style="float: left">
    <a href="?theme=default">default</a> | 
 	<a href="?theme=black">black</a> | 
    <a href="?theme=blue">blue</a>
</span>

<table border="1" cellpadding="2" cellspacing="2" align="center">
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td height="250"><tiles:insertAttribute name="menu" /></td>
        <td width="350"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" /></td>
    </tr>
</table>
</body>
</html>