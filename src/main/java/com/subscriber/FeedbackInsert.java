package com.subscriber;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FeedbackInsert")
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String MobileNo=request.getParameter("MobileNo");
		String Subject=request.getParameter("Subject");
		String Message=request.getParameter("Message");
		
		
		boolean isInserted=FeedbackDBUtil.insertfeedback(Name, Email, MobileNo, Subject, Message);
		
		if(isInserted) {
			RequestDispatcher dis = request.getRequestDispatcher("/ReaderServlet");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
			dis.forward(request, response);
		}
		
		
		
	}

}
