<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="Homecss/moviePage.css">
</head>
<body>

<div class="movie-detail">
    <video src="Admin/Movies/media/${movieDetails.video}" controls></video>
    
    <div class="movie-info">
        <img class="movie-image" src="Admin/Movies/media/${movieDetails.image}" alt="${movieDetails.title}" />
        
        <div class="movie-description">
            <h2>${movieDetails.title}</h2>
            <p>${movieDetails.description}</p>
            <p>Genre: ${movieDetails.genre}</p>
            <p>Release Date: ${movieDetails.date}</p>
        </div>
    </div>
</div>
</body>
</html>