package com.subscriber;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackRead")
public class FeedbackRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Feedback> fbackDetails = FeedbackDBUtil.getFeedbacks();
        request.setAttribute("fbackDetails", fbackDetails);
        RequestDispatcher dis = request.getRequestDispatcher("admindisplayfb.jsp");
        dis.forward(request, response);
	}

}
