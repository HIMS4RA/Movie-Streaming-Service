<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.subscriber.Feedback" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Panel</title>
<link rel="stylesheet" href="../AdminDashStyles.css">
<link rel="stylesheet" href="admindisplayfb.css">
</head>
<body>

<div class="top-bar">
    <div class="brand">MovieDojo.</div>
     
</div>

<div class="container">
    <div class="sidebar">
        <ul class="menu">
            <li><a href="../../AdminDashCount"> Dashboard</a></li>
            <li><a href="../Movies/adminreadMovies"><i></i> Movies</a></li>
            <li><a href="../Announcement/display"><i></i> Announcements</a></li>
            <li><a href="../Users/displayuser">Users</a></li>
            <li><a href="#">Feedbacks</a></li>
            <li><a href="../Contact/readcont">Inquiries</a></li>
            
             
        </ul>
    </div>
    <div class="main-content">
        <div class="feedback-section">
    <h3>All Feedbacks</h3>

    <%  
        @SuppressWarnings("unchecked")
        List<Feedback> feedbackList = (List<Feedback>) request.getAttribute("fbackDetails");
        if (feedbackList != null && !feedbackList.isEmpty()) {
    %>
        <table class="feedback-table">
            <thead>
                <tr>
                    <th>FID</th>
                    <th>Subject</th>
                    <th>Message</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
            <%
                for (Feedback feedback : feedbackList) {
            %>
                <tr>
                    <td><%= feedback.getFID() %></td>
                    <td><%= feedback.getSubject() %></td>
                    <td><%= feedback.getMessage() %></td>
                    <td>
                        <!-- Delete Button -->
                        <form action="addeletefb" method="post">
                            <input type="hidden" name="FID" value="<%= feedback.getFID() %>">
                            <button type="submit" class="btn">Delete</button>
                        </form>
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    <%
        } else {
    %>
        <p>No feedback available.</p>
    <%
        }
    %>
</div>

        
       
    </div>
</div>



</body>
</html>
