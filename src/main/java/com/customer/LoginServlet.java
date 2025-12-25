package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String userName = request.getParameter("username"); // Input type's name in the login form
		String password = request.getParameter("password"); // Input type's name in the login form
		boolean isTrue;
		
		// Debugging output
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		
		isTrue = CustomerDButil.validate(userName, password);
		
		if (isTrue) {
			// Check if the logged-in user is the admin
			if ("admin".equals(userName) && "adminPassword".equals(password)) {
				// Redirect to admin page if the user is admin
				System.out.println("Redirecting to Admin Dashboard");
				response.sendRedirect(request.getContextPath() + "/AdminDashCount");
			} else {
				// For regular customers
				List<Customer> cusDetails = CustomerDButil.getCustomer(userName);
				request.setAttribute("cusDetails", cusDetails);
				
				HttpSession session = request.getSession();
				session.setAttribute("username", userName);
				
				RequestDispatcher dis = request.getRequestDispatcher("/homereadMovies");
				dis.forward(request, response);
			}
		} else {
			// If login fails
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
	}
}
