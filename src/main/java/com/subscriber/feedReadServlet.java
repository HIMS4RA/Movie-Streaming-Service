package com.subscriber;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class feedReadServlet
 */
@WebServlet("/feedReadServlet")
public class feedReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get feedback list from database
        List<Feedback> fbackDetails = FeedbackDBUtil.getLastInsertedFeedback();

        // Set feedback list as request attribute
        request.setAttribute("fbackDetails", fbackDetails);

        // Forward to the feedback display JSP
        RequestDispatcher dis = request.getRequestDispatcher("HomeContactUs/displayFeedback.jsp");
        dis.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);  // Allow POST requests to also display feedback
	}
}
