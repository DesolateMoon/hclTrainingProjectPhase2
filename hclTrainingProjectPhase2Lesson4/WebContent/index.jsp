<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Capture" method="get">
		Name: <input type="text" name="name" required> <br>
		Department: <input type="text" name="department" required> <br>
		Cost: <input type="text" name="cost" pattern=^[0-9]{1,10}(\.[0-9]{1,2})?$ required><br> 
		<input type="submit" value="submit">
	</form>

</body>
</html>