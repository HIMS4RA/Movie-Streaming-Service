<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.contactus.Customer" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" href="styles/Display.css"> <!-- Adjusted path to CSS -->
    <link rel="stylesheet" type="text/css" href="../Homecss/navbarstyles.css"> <!-- Navbar CSS link -->
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

    <h1>Contact Message Details</h1>

    <%
    @SuppressWarnings("unchecked")
    List<Customer> cusDetails = (List<Customer>) request.getAttribute("cusDetails");

    if (cusDetails != null && !cusDetails.isEmpty()) {
        for (Customer message : cusDetails) {
    %>
        <table class="usermessage-table">
            <tr>
                <td class="key">ID</td>
                <td class="value"><%= message.getId() %></td>
            </tr>
            <tr>
                <td class="key">First Name</td>
                <td class="value"><%= message.getFirstName() %></td>
            </tr>
            <tr>
                <td class="key">Last Name</td>
                <td class="value"><%= message.getLastName() %></td>
            </tr>
            <tr>
                <td class="key">Email</td>
                <td class="value"><%= message.getEmail() %></td>
            </tr>
            <tr>
                <td class="key">Mobile Number</td>
                <td class="value"><%= message.getPhone() %></td>
            </tr>
            <tr>
                <td class="key">Subject</td>
                <td class="value"><%= message.getSubject() %></td>
            </tr>
            <tr>
                <td class="key">Message</td>
                <td class="value"><%= message.getMessage() %></td>
            </tr>
        </table>
        <br/>

        <form action="updatemessage.jsp" method="get">
            <input type="hidden" name="id" value="<%= message.getId() %>">
            <input type="hidden" name="firstName" value="<%= message.getFirstName() %>">
            <input type="hidden" name="lastName" value="<%= message.getLastName() %>">
            <input type="hidden" name="email" value="<%= message.getEmail() %>">
            <input type="hidden" name="phone" value="<%= message.getPhone() %>">
            <input type="hidden" name="subject" value="<%= message.getSubject() %>">
            <input type="hidden" name="message" value="<%= message.getMessage() %>">
            <input type="submit" name="update" value="Update" class="btn">
        </form>

        <form action="Delete.jsp" method="get">
            <input type="hidden" name="id" value="<%= message.getId() %>">
            <input type="hidden" name="firstName" value="<%= message.getFirstName() %>">
            <input type="hidden" name="lastName" value="<%= message.getLastName() %>">
            <input type="hidden" name="email" value="<%= message.getEmail() %>">
            <input type="hidden" name="phone" value="<%= message.getPhone() %>">
            <input type="hidden" name="subject" value="<%= message.getSubject() %>">
            <input type="hidden" name="message" value="<%= message.getMessage() %>">
            <input type="submit" name="delete" value="Delete" class="btn">
        </form>

    <%
        }
    } else {
    %>
        <p>No messages available.</p>
    <%
    }
    %>
</div>

<div class="footer">
    <p>&copy; 2024 MovieDojo. All rights reserved.</p>
</div>

</body>
</html>
