package com.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/displayUCount")
public class displayUCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	PrintWriter out = response.getWriter();
	       
	        // Fetch announcement details
	        List<Customer> cusDetails = CustomerDButil.getCustomerD();
	        int customerCount = CustomerDButil.getCustomerCount(); // Get the customer count

	        if (cusDetails != null && !cusDetails.isEmpty()) {
	            request.setAttribute("cusDetails", cusDetails);
	            
	            request.setAttribute("customerCount", customerCount); // Set customer count
	            RequestDispatcher dis = request.getRequestDispatcher("usercnt.jsp");
	           dis.forward(request, response);
	        } else {
	            out.println("<script type='text/javascript'>");
	            out.println("alert('No User data found');");
	            out.println("location='unsuccess.jsp';");
	            out.println("</script>");
	        }
	    }
}
