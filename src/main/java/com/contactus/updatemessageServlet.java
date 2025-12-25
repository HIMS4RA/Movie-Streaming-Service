package com.contactus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatemessageServlet")
public class updatemessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		boolean isUpdated =false;
		try {
		isUpdated=CustomerDBUtill.updatemessage(id,firstName,lastName, email, phone, subject, message);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while updating the message.");
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return;
			
		}
		if(isUpdated) {
			
			List<Customer>cusDetails=CustomerDBUtill.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis1 = request.getRequestDispatcher("Display.jsp");
			dis1.forward(request, response);
		}
		else {
			List<Customer>cusDetails=CustomerDBUtill.getCustomerDetails(id);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("usermessage.jsp");
			dis.forward(request, response);
		}
		
		
	}

}