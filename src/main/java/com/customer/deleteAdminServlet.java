package com.customer;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteAdminServlet")
public class deleteAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the customer ID from the request
        String id = request.getParameter("id");
        

        if (id == null || id.trim().isEmpty()) {
            // Handle invalid or missing ID
            request.setAttribute("errorMessage", "Invalid customer ID.");
            RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
            dis.forward(request, response);
            return;
        }

        boolean isDeleted = false;

        // Try deleting the customer and handle any exceptions
        try {
            isDeleted = CustomerDButil.deleteCustomer(id); // Deletion method
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            request.setAttribute("errorMessage", "An error occurred while deleting the customer.");
            RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
            dis.forward(request, response);
            return; // Exit the method after forwarding
        }

        // If the deletion was successful, fetch updated customer details and forward to the user dashboard
        if (isDeleted) {
           
        	response.sendRedirect(request.getContextPath() + "/Admin/Users/displayuser");
            } else {
               
            	List<Customer> cusDetails = CustomerDButil.getAllCustomers(); // Assuming this fetches all customers
                request.setAttribute("cusDetails", cusDetails);
                RequestDispatcher dis = request.getRequestDispatcher("unsuccess.jsp");
                dis.forward(request, response);
            }
        
    
        }
    
}