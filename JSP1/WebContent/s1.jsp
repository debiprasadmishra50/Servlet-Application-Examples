<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello hi
	<%!
		int x = 90;
		String getMessage()
		{
			return "Java is simple";
		}
	%>
	<h1>Using Scriptlet</h1>
	<%
		int a = 12;
		out.println("JSP is simple <br>");
		out.println("X is : "+x);
		out.println("<br>Message is : "+getMessage());
	%>
	<hr>
	<h1>Using Expression</h1>
	<br> X is : <%=x %>
	<br> Message is : <%=getMessage() %>
</body>
</html>