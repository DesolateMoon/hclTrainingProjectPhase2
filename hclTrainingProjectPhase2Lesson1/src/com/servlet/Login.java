package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		com.service.Login ls = new com.service.Login();
		com.model.Login login = new com.model.Login(request.getParameter("uname"), request.getParameter("pass"));

		if (ls.login(login)) {
			response.getWriter().print("Log in was successful!");
			HttpSession session = request.getSession();
			session.setAttribute("sessionName", request.getParameter("uname"));
			response.sendRedirect("Dashboard.jsp");
		} else {
			response.setContentType("text/html");
			response.getWriter().println("Log in was unsuccessful, please try again.<br><br>");
			response.getWriter().println("<a href=\"Login.html\">Log In</a><br>");
		}
	}

}
