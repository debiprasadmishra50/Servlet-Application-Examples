<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="s" value="${'Hello' }"></c:set>
	
	Length of String : <c:out value="${fn:length(s) }"></c:out> <br>
	<c:if test="${fn:startsWith(s,'H') }">
		<c:out value="${'Yes Started with H' }"></c:out>
	</c:if>
	
	<br>
		
	<c:choose>
		<c:when test="${fn:endsWith(s,'E') }">
			<c:out value="${'YEs Ended with E' }"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="${'Not Ended with E' }"></c:out>
		</c:otherwise>
	</c:choose>
</body>
</html>