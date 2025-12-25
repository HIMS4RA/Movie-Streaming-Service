<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie</title>
<link rel="stylesheet" href="../AdminDashStyles.css">
<link rel="stylesheet" href="InsertMovie.css">
</head>
<body>


<div class="container">
    <div class="main-content">
        <form id="movieForm" action="${pageContext.request.contextPath}/Admin/Movies/insertMovie" method="post" enctype="multipart/form-data">
            <h1 class="page-title">Add Movie</h1>
            
            <!-- Title field with validation for length -->
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required minlength="2" maxlength="100">

            <!-- Description with a minimum length -->
            <label for="description">Description:</label>
            <textarea id="description" name="description" required minlength="10" maxlength="500"></textarea>

            <!-- Genre with length validation -->
            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre" required minlength="2" maxlength="50">

            <!-- Release date -->
            <label for="releaseDate">Release Date:</label>
            <input type="date" id="releaseDate" name="releaseDate" required 
                   max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>">

            <!-- Image validation: Only allows image file types -->
            <label for="coverImage">Cover Image:</label>
            <input type="file" id="coverImage" name="coverImage" required accept="image/*">

            <!-- Video validation: Only allows video file types -->
            <label for="movieVideo">Movie Video:</label>
            <input type="file" id="movieVideo" name="movieVideo" required accept="video/*">

            <!-- Submit button -->
            <button type="button" id="submitBtn">Add Movie</button> <!-- Notice the type is "button" -->
        </form>
    </div>
</div>

<script>
    window.onload = function() {
        console.log("Page loaded, attaching event listener.");

        var form = document.getElementById('movieForm');
        var submitBtn = document.getElementById('submitBtn');

        submitBtn.onclick = function(event) {
            console.log("Submit button clicked, starting validation...");

            // Validation logic
            var title = document.getElementById("title").value;
            var description = document.getElementById("description").value;
            var genre = document.getElementById("genre").value;
            var releaseDate = document.getElementById("releaseDate").value;
            var coverImage = document.getElementById("coverImage").value;
            var movieVideo = document.getElementById("movieVideo").value;

            if (title.length < 2 || title.length > 45) {
                alert("Title should be between 2 and 45 characters.");
                return false;
            }
            if (description.length < 10 || description.length > 500) {
                alert("Description should be between 10 and 500 characters.");
                return false;
            }
            if (genre.length < 2 || genre.length > 45) {
                alert("Genre should be between 2 and 45 characters.");
                return false;
            }
           
            if (!coverImage) {
                alert("Please upload a cover image.");
                return false;
            }
            if (!movieVideo) {
                alert("Please upload a movie video.");
                return false;
            }

            alert("Submitted Successfully!");
            form.submit();
        };
    };
</script>

</body>
</html>
