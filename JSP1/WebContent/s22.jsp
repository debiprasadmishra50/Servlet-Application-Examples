<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="db" driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="sipusipu18"/>
	
	<sql:update dataSource="${db }">
		Insert into Student values (1000, 'Raja' ,7.8)	
	</sql:update>
	<sql:update dataSource="${db }">
		Insert into Student values (1001, 'Rani' ,8.8)	
	</sql:update>
	
	<sql:transaction dataSource="${db }">
		<sql:update>
			Insert into Student values (1002, 'Mani', 9.8)
		</sql:update>
		<sql:update>
			Insert into Student values (1003, 'Kani', 1.8)
		</sql:update>
		<sql:update>
			Insert into Student values (1004, 'Jani', 2.8)
		</sql:update>		
	</sql:transaction>
	
	
	
	
	
</body>
</html>