<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.subscriber.Feedback" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Feedback</title>
    <link rel="stylesheet" href="displayfeedback.css"> <!-- Link to external CSS for styling -->
    <link rel="stylesheet" type="text/css" href="../Homecss/navbarstyles.css"> <!-- Link to navbar CSS -->
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar">
    <div class="logo">
        <h5>MovieDojo.</h5>
    </div>
    <ul>
        <li><a href="../homereadMovies">Home</a></li>
        <li><a href="../CustomerReadServlet?username=<%= java.net.URLEncoder.encode((String)session.getAttribute("username"), "UTF-8") %>">Account</a></li>
        <li><a href="../Ancread">Announcements</a></li>
        <li><a href="../HomeContactUs/feedbackInsert.jsp">Reviews</a></li>
        <li><a href="../ContactusHome/contactus.jsp">Contact Us</a></li>
        <li><a href="../logout.jsp">Logout</a></li>
    </ul>
</nav>

<div class="container">
    <h1>Feedback Details</h1>

    <%
    @SuppressWarnings("unchecked")
    List<Feedback> fbackDetails = (List<Feedback>) request.getAttribute("fbackDetails");
    if (fbackDetails != null && !fbackDetails.isEmpty()) {
        for (Feedback feedback : fbackDetails) {
    %>
        <table class="feedback-table">
            <tr>
                <td class="key">FID</td>
                <td class="value"><%= feedback.getFID() %></td>
            </tr>
            <tr>
                <td class="key">Name</td>
                <td class="value"><%= feedback.getName() %></td>
            </tr>
            <tr>
                <td class="key">Email</td>
                <td class="value"><%= feedback.getEmail() %></td>
            </tr>
            <tr>
                <td class="key">Mobile Number</td>
                <td class="value"><%= feedback.getMobileNo() %></td>
            </tr>
            <tr>
                <td class="key">Subject</td>
                <td class="value"><%= feedback.getSubject() %></td>
            </tr>
            <tr>
                <td class="key">Message</td>
                <td class="value"><%= feedback.getMessage() %></td>
            </tr>
        </table>
        <br/>

        <!-- Update button -->
        <form action="updateFeedback.jsp" method="get">
            <input type="hidden" name="FID" value="<%= feedback.getFID() %>">
            <input type="hidden" name="Name" value="<%= feedback.getName() %>">
            <input type="hidden" name="Email" value="<%= feedback.getEmail() %>">
            <input type="hidden" name="MobileNo" value="<%= feedback.getMobileNo() %>">
            <input type="hidden" name="Subject" value="<%= feedback.getSubject() %>">
            <input type="hidden" name="Message" value="<%= feedback.getMessage() %>">
            <input type="submit" name="update" value="Update" class="btn">
        </form>
        <br>
        
        <form action="deleteFeedback.jsp" method="get">
            <input type="hidden" name="FID" value="<%= feedback.getFID() %>">
            <input type="hidden" name="Name" value="<%= feedback.getName() %>">
            <input type="hidden" name="Email" value="<%= feedback.getEmail() %>">
            <input type="hidden" name="MobileNo" value="<%= feedback.getMobileNo() %>">
            <input type="hidden" name="Subject" value="<%= feedback.getSubject() %>">
            <input type="hidden" name="Message" value="<%= feedback.getMessage() %>">
            <input type="submit" name="delete" value="Delete" class="btn">
        </form>
        <br>
    <%
        }
    } else {
    %>   
        <p>No feedback available.</p>
    <%
    }
    %>
</div>
</body>
</html>
