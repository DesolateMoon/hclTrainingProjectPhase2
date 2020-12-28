package com.servlet;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String sql = "select id, name, department, cost from product where id=?";
		
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(id));
			ResultSet rs = pst.executeQuery();
			
			out.println("<html><head>");
			out.println("<title>Retrieve Results</title>");
			out.println("</head><body>");
			
			if(rs.next()) {
				out.println("<table border='1' width='60%'>");
				out.println("<tr>");
				out.println("<th>ID</th> <th>Name</th> <th>Department</th> <th>Cost</th> </tr>");
			
				int prodID = rs.getInt(1);
				String name = rs.getString(2);
				String department = rs.getString(3);
				double cost = rs.getDouble(4);
				
				out.println("<tr style='text-align:center'>");
				out.println("<td>" + prodID + 
							"</td> <td>" + name + 
							"</td> <td>" + department + 
							"</td> <td>" + cost + 
							"</td>");
				out.println("</tr>");
				out.println("</table>");

			} else {
				response.getWriter().append("ID was not found, please try again.");
				out.println("<br>");
			}
			
			out.println("<a href='index.html'>Go Back</a>");
			out.println("</body></html>");

			pst.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("Connection is closed.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
