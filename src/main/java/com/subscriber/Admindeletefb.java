package com.subscriber;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Admindeletefb")
public class Admindeletefb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		String FID=request.getParameter("FID");
		
		boolean isDeleted =false;
		try {
		isDeleted=FeedbackDBUtil.deletefeedback(FID);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while deleting the feedback.");
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return;
			
		}
        if(isDeleted) {
			/*RequestDispatcher dis1 = request.getRequestDispatcher("admindisplayfb.jsp");
			dis1.forward(request, response);*/
        	response.sendRedirect("read");
		}
        else {
			
			request.setAttribute("errorMessage", "Feedback could not be deleted.");
			
			RequestDispatcher dis = request.getRequestDispatcher("admindisplayfb.jsp");
			dis.forward(request, response);
		}
	}

}
