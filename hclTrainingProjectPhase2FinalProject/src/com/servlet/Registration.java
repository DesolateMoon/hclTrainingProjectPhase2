package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();

		com.model.User reg = new com.model.User(request.getParameter("name"),
												request.getParameter("password"),
												request.getParameter("email"));

		userService.registration(reg);
		
		HttpSession session = request.getSession();
		session.setAttribute("sesname", request.getParameter("name"));
		response.sendRedirect("registrationSuccess.jsp");
	}

}
