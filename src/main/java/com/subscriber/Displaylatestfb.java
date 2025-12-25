package com.subscriber;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Displaylatestfb")
public class Displaylatestfb extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch the latest 4 feedbacks from the database
    	System.out.println("latest servlet called");
        List<Feedback> fbackDetails = FeedbackDBUtil.getLatestFeedbacks(4); // Fetch 4 feedbacks
        request.setAttribute("fbackDetails", fbackDetails);

        // Forward to home.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeContactUs/latestFb.jsp");
        dispatcher.forward(request, response);
    }
}

