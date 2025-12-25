package com.subscriber;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackUpdate")
public class FeedbackUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FID=request.getParameter("FID");
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String MobileNo=request.getParameter("MobileNo");
		String Subject=request.getParameter("Subject");
		String Message=request.getParameter("Message");
		
		boolean isUpdated =false;
		try {
		isUpdated=FeedbackDBUtil.updatefeedback(FID, Name, Email, MobileNo, Subject, Message);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while updating the feedback.");
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
	        dis.forward(request, response);
	        return;
			
		}
		if(isUpdated) {
			
			List<Feedback>fbackDetails=FeedbackDBUtil.getFeedbackDetails(FID);
			request.setAttribute("fbackDetails", fbackDetails);
			
			RequestDispatcher dis1 = request.getRequestDispatcher("displayFeedback.jsp");
			dis1.forward(request, response);
		}
		else {
			List<Feedback>fbackDetails=FeedbackDBUtil.getFeedbackDetails(FID);
			request.setAttribute("fbackDetails", fbackDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("displayFeedback.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
