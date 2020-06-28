<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		session.setAttribute("email", "a@gmail.com");
		session.setAttribute("phone", "8989898989");
	%>
	<a href="s8.jsp">Click Here For s8.JSP</a>
</body>
</html>