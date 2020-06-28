<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Email : <%= session.getAttribute("email") %> <br>
	phone : <%= session.getAttribute("phone") %> <br>
	
	<%
		session.invalidate();
	%>
	<a href="s10.jsp">Click Here For s10.JSP</a>
</body>
</html>