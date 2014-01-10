<%@ page session="false" %>
<%-- JSTL --%>
<%@ taglib prefix="c" 		uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 	uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- Spring Tags Libs --%>
<%@ taglib prefix="form" 	uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" 	uri="http://www.springframework.org/tags" %>
<%-- Apache Tiles --%>
<%@ taglib prefix="tiles"	uri="http://tiles.apache.org/tags-tiles" %>

<%-- Global Variables --%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="contextPathWeb" value="${pageContext.request.contextPath}/web" />
