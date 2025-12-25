<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="flix.db.Movie" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel - Movie Details</title>
    <link rel="stylesheet" href="../AdminDashStyles.css">
    <link rel="stylesheet" href="AdminMovieStyles.css">
</head>
<body>

<div class="top-bar">
    <div class="brand">MovieDojo.</div>
    
    
</div>

<div class="container">
    <div class="sidebar">
        <ul class="menu">
             <li><a href="../../AdminDashCount"> Dashboard</a></li>
            <li><a href="#">Movies</a></li>
            <li><a href="../Announcement/display"><i></i> Announcements</a></li>
            <li><a href="../Users/displayuser">Users</a></li>
            <li><a href="../Feedback/read">Feedbacks</a></li>
            <li><a href="../Contact/readcont">Inquiries</a></li>
            
            
        </ul>
    </div>

    <div class="main-content">
        <button><a href="AddMovie.jsp">Add Movie</a></button>
          <br><br><br>
		<div class="table-container">
        <c:if test="${not empty movieDetails}">
            <table border="1" class="tb">
                <thead>
                    <tr>
                        <th>Movie ID</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Genre</th>
                        <th>Release Date</th>
                        <th>Image</th>
                        <th>Video</th>
                        <th>Action</th>
                      
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="movie" items="${movieDetails}">
                    
                    <c:set var="id" value="${movie.id}"/>
            		<c:set var="title" value="${movie.title}"/>
            		<c:set var="description" value="${movie.description}"/>
            		<c:set var="genre" value="${movie.genre}"/>
            		<c:set var="date" value="${movie.date}"/>
            		<c:set var="image" value="${movie.image}"/>
            		<c:set var="video" value="${movie.video}"/>
                        <tr>
                            <td>${movie.id}</td>
                            <td>${movie.title}</td>
                            <td>${movie.description}</td>
                            <td>${movie.genre}</td>
                            <td>${movie.date}</td>
                            <td><img src="media/${movie.image}" width="100" height="75"></td>
                            <td><video src="media/${movie.video}" width="150" height="150" controls></video></td>
                            
                            
                               <c:url value="UpdateMovie.jsp" var="movieupdate">
    	
    							<c:param name="id" value="${id}"/>
    							<c:param name="title" value="${title}"/>
    							<c:param name="description" value="${description}"/>
    							<c:param name="genre" value="${genre}"/>
    							<c:param name="date" value="${date}"/>
    							<c:param name="image" value="${image}"/>
    							<c:param name="video" value="${video}"/>
    	
    	
    							</c:url>
                            <!-- Update and Delete Buttons -->
                            <td>
                                <a href="${movieupdate}">
    							<input type="button" name="update" value="Update" class="btn-update">
    							</a>
                            <br>
                            
                            	 <c:url value="deleteMovie" var="moviedelete">
            						<c:param name="id" value="${id}"/>
       							 </c:url>
        							<a href="${moviedelete}">
            						<input class="btn-delete" type="button" name="delete" value="Delete" onclick="return confirm('Are you sure you want to delete this movie?');">
        							</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <c:if test="${empty movieDetails}">
            <p>No movie details found.</p>
        </c:if>
        
  
    </div>
    </div>
</div>

</body>
</html>
