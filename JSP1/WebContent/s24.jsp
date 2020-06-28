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
	
	<sql:query var="rs" dataSource="${db }" >
		Select * from Student
	</sql:query>
	
	<table width="100%" border="2">
		<tr>
			<th>Roll</th>
			<th>Name</th>
			<th>Cgpa</th>
		</tr>
		
		<c:forEach var="table" items="${rs.rows }">
			<tr>
				<td> <c:out value="${table.roll }"></c:out> </td>
				<td> <c:out value="${table.name }"></c:out> </td>
				<td> <c:out value="${table.cgpa }"></c:out> </td>
			</tr>			
		</c:forEach>
	</table>
	
	
	
	
</body>
</html>