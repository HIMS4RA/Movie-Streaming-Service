package com.contactus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContactReadServlet")
public class ContactReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get msgs list from database
        List<Customer> cusDetails = CustomerDBUtill.getLastInsertedMessage();

        // Set message list as request attribute
        request.setAttribute("cusDetails", cusDetails);

        
        RequestDispatcher dis = request.getRequestDispatcher("ContactusHome/Display.jsp");
        dis.forward(request, response);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);  // Allow POST requests to also display feedback
	}
	

}
