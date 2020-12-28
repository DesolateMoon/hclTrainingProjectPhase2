package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Capture")
public class Capture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		double cost = Double.valueOf(request.getParameter("cost"));
		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>Capture Results</title>");
		out.println("<table border='1' width='60%'>");
		out.println("<tr>");
		out.println("<th>ID</th> <th>Name</th> <th>Department</th> <th>Cost</th> </tr>");
		out.println("<tr style='text-align:center'>");
		out.println("<td>1</td> <td>" + 
					name + "</td> <td>" + 
					department + "</td> <td>" + 
					cost + "</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href='index.jsp'>Go Back</a>");
		out.println("</body></html>");
	}

}