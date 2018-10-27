<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Exception erreurDeCreationCompte = (Exception) request.getAttribute("erreur");	
	String nomClient = request.getParameter("nom");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création de compte</title>
</head>
<body>
	<h1> Résultat de demande de création de compte </h1>
	<h2>
		<% if (erreurDeCreationCompte == null) { %>
			<span style="color: red;"> Compte créé pour <%= nomClient %> </span> !
		<%}	else { %>
			Le compte <span style="color: red;">  n'a pas été créé !!! </span>
		<%} %>
	</h2>
</body>
</html>