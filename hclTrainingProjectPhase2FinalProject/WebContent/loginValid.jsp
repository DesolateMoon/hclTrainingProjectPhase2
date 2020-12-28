<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ page language="java" import="java.sql.*"%>
	<%@ page language="java" import="javax.servlet.http.HttpSession"%>
	<%
		String searchName = request.getParameter("name");
		String searchPassword = request.getParameter("password");
		String sql = "select name, password from user";
		try {
			Class.forName("org.h2.Driver");
			Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			boolean userFound = false;
			
			while (rs.next()) {
				String name = rs.getString(1);
				String email = rs.getString(2);
				if (searchName.equals(name) && searchPassword.equals(email)) {
					response.getWriter().println("Login Successful");
					userFound = true;
					
					session.setAttribute("sesname", name);
					response.sendRedirect("loginSuccess.jsp");
				}
			}
			if (!userFound) {
				response.getWriter().println("Name and Password do not match our records.");
				out.println("<br> <a href='login.html'>Go Back</a> <br>");
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</body>
</html>