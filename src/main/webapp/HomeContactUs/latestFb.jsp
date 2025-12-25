<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.subscriber.Feedback" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="latestFb.css"> <!-- Link to external CSS -->
</head>
<body>
    <!-- Navigation bar, etc. -->
    
    <!-- Feedback section -->
    <section class="latest-feedbacks">
        <h2>Real Feedback, Real Experiences..</h2>
        
        <%
            @SuppressWarnings("unchecked")
            List<Feedback> feedbackList = (List<Feedback>) request.getAttribute("fbackDetails");
            if (feedbackList != null && !feedbackList.isEmpty()) {
        %>
            <ul class="feedback-list">
            <%
                for (Feedback feedback : feedbackList) {
            %>
                    <li>
                        <strong><%= feedback.getName() %>:</strong> 
                        <em><%= feedback.getEmail() %></em>
                        <p><%= feedback.getMessage() %></p>
                    </li>
            <%
                }
            %>
            </ul>
        <%
            } else {
        %>
            <p>No feedback available.</p>
        <%
            }
        %>
    </section>
</body>
</html>
