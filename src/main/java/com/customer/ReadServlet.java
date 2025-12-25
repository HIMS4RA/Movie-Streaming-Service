package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet(name = "CustomerReadServlet", urlPatterns = { "/CustomerReadServlet" })
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		
		try {
			
			List<Customer> cusDetails = CustomerDButil.getCustomer(uname);
			request.setAttribute("cusDetails", cusDetails);
			
			 System.out.println("Fetched movie details:");
			 
			 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");
        dis.forward(request, response);
		
		
		
	}

	

}
