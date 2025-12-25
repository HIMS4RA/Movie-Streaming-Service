package com.contactus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/adminContactDelete")
public class adminContactDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("delete servlet");
		
		String Id=request.getParameter("id");
		
		System.out.println("delete id "+ Id);
		
		boolean isDeleted =false;
		try {
		isDeleted=CustomerDBUtill.admindelete(Id);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while deleting the message.");
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return;
			
		}
        if(isDeleted) {
			
        	System.out.println("record deleted");
        	response.sendRedirect("readcont");
		}
        else {
			
        	System.out.println("error deletion");
			request.setAttribute("errorMessage", "Message could not be deleted.");
			
			RequestDispatcher dis = request.getRequestDispatcher("admindisplay.jsp");
			dis.forward(request, response);
		}
		
		
	}
	
	
	

}
