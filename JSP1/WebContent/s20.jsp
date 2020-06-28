<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${'Hello Welcome to JSTL' }"></c:out>
	
	<c:set var="x" value="1000"></c:set>
	<br>
	
	X = <c:out value="${x }"></c:out>
	<br>
	
	<c:remove var="x"/>
	<br>
	
	<c:set var="mark" value="50"></c:set>
	<c:if test="${mark > 30 }">
		<c:out value="${'Yes Pass' }"></c:out>
	</c:if>
	<br>
	
	<c:choose>
		<c:when test="${mark > 60 }">
			<c:out value="${'Yes First' }"></c:out>
		</c:when>
		<c:otherwise>
			<c:out value="${'Just Pass' }"></c:out>
		</c:otherwise>
	</c:choose>
	
	<br>
	
	<c:forEach var="i" begin="10" step="2" end="15">
		<c:out value="${i }"></c:out>
	</c:forEach>
	
</body>
</html>