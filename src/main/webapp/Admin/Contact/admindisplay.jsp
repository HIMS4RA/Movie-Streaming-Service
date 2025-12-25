<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="com.contactus.Customer" %>

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
     <div class="logout">
        <a href="./logout.jsp">Logout</a> <!-- Link to your logout servlet -->
    </div>
</div>

<div class="container">
    <div class="sidebar">
        <ul class="menu">
            <li><a href="../../AdminDashCount"> Dashboard</a></li>
            <li><a href="../Movies/adminreadMovies"><i></i> Movies</a></li>
            <li><a href="../Announcement/display"><i></i> Announcements</a></li>
            <li><a href="../Users/displayuser">Users</a></li>
            <li><a href="../Feedback/read">Feedbacks</a></li>
            <li><a href="#">Inquiries</a></li>
            
            
        </ul>
    </div>
    <div class="main-content">
       <div class="message-section">
    <h3>All Messages</h3>

    <%  
        @SuppressWarnings("unchecked")
        List<Customer> messageList = (List<Customer>) request.getAttribute("cusDetails");
        if (messageList != null && !messageList.isEmpty()) {
    %>
        <table class="feedback-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Subject</th>
                    <th>Message</th>
                    <th>Delete</th>
                   
                </tr>
            </thead>
            <tbody>
            <%
                for (Customer message : messageList) {
            %>
                <tr>
                    <td><%= message.getId() %></td>
                    <td><%= message.getSubject() %></td>
                    <td><%= message.getMessage() %></td>
                    <td>
                        <!-- Delete Button -->
                        <form action="addeletemsg" method="post">
                            <input type="hidden" name="id" value="<%= message.getId() %>">
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
        <p>No messages available.</p>
    <%
        }
    %>
</div>
        
    </div>
</div>



</body>
</html>
