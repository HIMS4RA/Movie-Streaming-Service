package com.subscriber;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackDelete")
public class FeedbackDelete extends HttpServlet {
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
			RequestDispatcher dis1 = request.getRequestDispatcher("feedbackInsert.jsp");
			dis1.forward(request, response);
		}
        else {
			
			request.setAttribute("errorMessage", "Feedback could not be deleted.");
			
			RequestDispatcher dis = request.getRequestDispatcher("displayFeedback.jsp");
			dis.forward(request, response);
		}
	}

}
