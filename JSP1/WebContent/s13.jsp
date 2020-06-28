<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <jsp:useBean id="obj" class="p1.Test"></jsp:useBean>
	 Value is : <%=obj.cube(5) %>
</body>
</html>