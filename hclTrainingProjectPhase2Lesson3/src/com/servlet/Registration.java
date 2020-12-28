package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.utility.HibernateUtility;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		com.model.Product product = new com.model.Product(request.getParameter("name"), 
														  request.getParameter("department"), 
														  Double.valueOf(request.getParameter("cost")));

		try {
			Session session = HibernateUtility.getSession();
			Transaction tx = session.beginTransaction();
			session.save(product);
			tx.commit();
			System.out.println(("Product is registered."));
			
			out.println("<html><head>");
			out.println("<title>Product Detail</title>");
			out.println("<table border='1' width='60%'>");
			out.println("<tr>");
			out.println("<th>ID</th> <th>Name</th> <th>Department</th> <th>Cost</th> </tr>");
			out.println("<tr style='text-align:center'>");
			out.println("<td>" + product.getId() + 
						"</td> <td>" + product.getName() + 
						"</td> <td>" + product.getDepartment() + 
						"</td> <td>" + product.getCost()+ 
						"</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("<a href='index.html'>Go Back</a> <br>");
			out.println("</body></html>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
