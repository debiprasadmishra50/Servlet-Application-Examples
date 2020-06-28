<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Within S5.JSP</h1>
	City is : <%=config.getInitParameter("city") %> <br>
	State is : <%=application.getInitParameter("state") %> <br>
</body>
</html>