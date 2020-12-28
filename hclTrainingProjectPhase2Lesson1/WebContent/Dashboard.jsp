<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>
		Welcome, <%=session.getAttribute("sessionName")%>.
	</h1>
	<a href="Login.html">Log Out</a>
</body>
</html>