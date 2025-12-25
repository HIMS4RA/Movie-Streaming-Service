<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Announcements</title>
    <link rel="stylesheet" type="text/css" href="jithyacss/announePage.css"> <!-- Link to CSS file -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="Homecss/navbarstyles.css"> 
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar">
	<div class="logo">
        <h5>MovieDojo.</h5>
    </div>
    <ul>
        <li><a href="homereadMovies">Home</a></li>
        <li><a href="CustomerReadServlet?username=<%= java.net.URLEncoder.encode((String)session.getAttribute("username"), "UTF-8") %>">Account</a></li>
        <li><a href="Ancread">Announcements</a></li>
        <li><a href="HomeContactUs/feedbackInsert.jsp">Reviews</a></li>
        <li><a href="ContactusHome/contactus.jsp">Contact Us</a></li>
        <li><a href="logout.jsp">Logout</a></li>
    </ul>
</nav>

<!-- Title -->
<h1 class="announcement-title">Announcements</h1>

<div class="announcement-details">
    <c:forEach var="ann" items="${annDetails}">
        <!-- Determine card theme based on category -->
        <c:set var="cardClass" value="card-default" />
        <c:choose>
            <c:when test="${ann.date == 'Success'}">
                <c:set var="cardClass" value="card-success" />
            </c:when>
            <c:when test="${ann.category == 'Success'}">
                <c:set var="cardClass" value="card-success" />
            </c:when>
            <c:when test="${ann.category == 'Warning'}">
                <c:set var="cardClass" value="card-warning" />
            </c:when>
            <c:when test="${ann.category == 'Promotion'}">
                <c:set var="cardClass" value="card-promo" />
            </c:when>
        </c:choose>

        <div class="announcement-info ${cardClass}">
            <button class="card-close">&times;</button>
            <h3>${ann.date}</h3>
            <p><strong>Category:</strong> ${ann.category}</p>
            <p><strong>Title:</strong> ${ann.title}</p>
            <p><strong>Content:</strong> ${ann.content}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
