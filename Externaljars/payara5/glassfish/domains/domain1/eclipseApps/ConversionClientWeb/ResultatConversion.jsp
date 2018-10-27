<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String init = request.getParameter("somme");
	String conversion = (String) (request.getAttribute("conversion")) ;

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Conversion</title>
</head>
<body>
<p><%=init %> = <%=conversion %></p>
</body>
</html>