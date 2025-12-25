<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page session="true" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        // Redirect to login page if the user is not logged in
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - SllitFlix Theme</title>
    <link rel="stylesheet" type="text/css" href="./jithyacss/userdash.css">
    <link rel="stylesheet" type="text/css" href="Homecss/HomePage.css"> <!-- Link to CSS file -->
</head>
<body>

    

    <div class="dashboard-container">
    
    	<nav class="navbar">
            <ul>
                <li><a href="#movies">Movies</a></li>
               <li><a href="CustomerReadServlet?username=<%= java.net.URLEncoder.encode(username, "UTF-8") %>">Account</a></li>
                <li><a href="#trending">Trending</a></li>
                <li><a href="#reviews">Reviews</a></li>
                <li><a href="contact.html">Contact Us</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
      

        <div class="main-content">
            <h1>Welcome to your Cinemahall&#x1F37F;</h1>
	
		
			 <div class="form-container">
            <!-- User Details Form (Similar to the structure of the image) -->
            <div class="user-details">
                <c:forEach var="cus" items="${cusDetails}">
                    <c:set var="id" value="${cus.id }"/>
                    <c:set var="name" value="${cus.name }"/>
                    <c:set var="email" value="${cus.email }"/>
                    <c:set var="phone" value="${cus.phone }"/>
                    <c:set var="userName" value="${cus.userName }"/>
                    <c:set var="password" value="${cus.password }"/>

                    <div class="user-info">
                        <label for="name">Name:</label>
                        <input type="text" id="name" value="${cus.name}" readonly>

                        <label for="email">Email:</label>
                        <input type="text" id="email" value="${cus.email}" readonly>

                        <label for="phone">Phone Number:</label>
                        <input type="text" id="phone" value="${cus.phone}" readonly>

                        <label for="userName">Username:</label>
                        <input type="text" id="userName" value="${cus.userName}" readonly>

                        <label for="password">Password:</label>
                        <input type="text" id="password" value="${cus.password}" readonly>
                    </div>
                </c:forEach>
            </div>
            

            <!-- Update and Delete buttons -->
            <div class="action-buttons">
                <c:url value="HomeUserProfile/updatecustomer.jsp" var="cusupdate">
                    <c:param name="id" value="${id}"/>
                    <c:param name="name" value="${name}"/>
                    <c:param name="email" value="${email}"/>
                    <c:param name="phone" value="${phone}"/>
                    <c:param name="userName" value="${userName}"/>
                    <c:param name="password" value="${password}"/>
                </c:url>
                
                <a href="${cusupdate}">
                    <button class="btn-update">Update</button>
                </a>
                
                <c:url value="deletecustomer.jsp" var="cusdelete">
                    <c:param name="id" value="${id}"/>
                    <c:param name="name" value="${name}"/>
                    <c:param name="email" value="${email}"/>
                    <c:param name="phone" value="${phone}"/>
                    <c:param name="userName" value="${userName}"/>
                    <c:param name="password" value="${password}"/>
                </c:url>
                
                <a href="${cusdelete}">
                    <button class="btn-delete">Delete</button>
                </a>
            </div>
        </div>
        </div>
    </div>

</body>
</html>