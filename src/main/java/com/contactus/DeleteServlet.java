package com.contactus;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String id=request.getParameter("id");
		
    	System.out.println("Delete servelet");
    	
		boolean isDeleted =false;
		try {
			
		isDeleted=CustomerDBUtill.deleteMessage(id);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while deleting the message.");
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return;
			
		}
        if(isDeleted) {
			RequestDispatcher dis1 = request.getRequestDispatcher("contactus.jsp");
			dis1.forward(request, response);
		}
        else {
			
			request.setAttribute("errorMessage", "Message could not be deleted.");
			
			RequestDispatcher dis = request.getRequestDispatcher("Display.jsp");
			dis.forward(request, response);
		}
    }
} 

