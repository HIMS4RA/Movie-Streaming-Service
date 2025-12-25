<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Announcements - MovieDojo</title>
    <link rel="stylesheet" type="text/css" href="announcedash.css"> <!-- Link to CSS file -->
</head>
<body>

<header>
    <a href="#">
        <div class="site-name">MovieDoJo</div>
    </a>
</header>

<div class="dashboard-container">
    <div class="sidebar">
        <ul>
           <li><a href="../../AdminDashCount"> Dashboard</a></li>
            <li><a href="../Movies/adminreadMovies"><i></i> Movies</a></li>
            <li><a href="#"><i></i> Announcements</a></li>
            <li><a href="../Users/displayuser">Users</a></li>
            <li><a href="../Feedback/read">Feedbacks</a></li>
            <li><a href="../Contact/readcont">Inquiries</a></li>
            
        </ul>
    </div>

    <div class="main-content">
        <h1>Announcements</h1>
        
        <!-- Button to create a new announcement -->
        <div class="create-announcement-container">
            <a href="insertannouce.jsp">
                <button class="btn-create-announcement">Create Announcement</button>
            </a>
        </div>

        <!-- Display announcements retrieved from the servlet -->
        <div class="announcement-details">
            <table class="announcement-table">
                <thead>
                    <tr>
                        <th>Id &#128258;</th>
                        <th>Date &#128197;</th>
                        <th>Category &#128194;</th>
                        <th>Title &#127991;</th>
                        <th>Content &#128221;</th>
                        <th>Action&#9881;</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ann" items="${annDetails}">
                        <tr>
                            <td>${ann.id}</td>
                            <td>${ann.date}</td>
                            <td>${ann.category}</td>
                            <td>${ann.title}</td>
                            <td>${ann.content}</td>
                            <td>
                                <c:url value="announceUpdate.jsp" var="annupdate">
                                    <c:param name="id" value="${ann.id}"/>
                                    <c:param name="date" value="${ann.date}"/>
                                    <c:param name="category" value="${ann.category}"/>
                                    <c:param name="title" value="${ann.title}"/>
                                    <c:param name="content" value="${ann.content}"/>
                                </c:url>
                                
                                <a href="${annupdate}">
                                    <button class="btn-update">Update</button>
                                </a>
                                
                                <c:url value="announceDelete.jsp" var="anndelete">
                                    <c:param name="id" value="${ann.id}"/>
                                    <c:param name="date" value="${ann.date}"/>
                                    <c:param name="category" value="${ann.category}"/>
                                    <c:param name="title" value="${ann.title}"/>
                                    <c:param name="content" value="${ann.content}"/>
                                </c:url>
                                
                                <a href="${anndelete}">
                                    <button class="btn-delete">Delete</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>

<script>
    function setCurrentTimestamp() {
        const now = new Date();
        const formattedDate = now.toISOString().slice(0, 19).replace('T', ' '); // Format to 'YYYY-MM-DD HH:MM:SS'
        document.getElementById("date").value = formattedDate; // Set value
    }
    window.onload = setCurrentTimestamp; // Call function on page load
</script>

</body>
</html>