<%@page import="java.util.Date"%>
<%-- <%@page contentType="application/msword; charset=ISO-8859-1" %> --%>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<%@page info="AboutUs page" %>
<%@page errorPage="s15.jsp" %> <%--if some error occurs go to that page --%>

Today : <%=new Date() %>
<hr>

Page Info : <%=getServletInfo() %>
<hr>

value : <%=10/0 %>





