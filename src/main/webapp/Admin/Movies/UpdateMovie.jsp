<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Movie</title>
<link rel="stylesheet" href="../AdminDashStyles.css"> 
<link rel="stylesheet" href="InsertMovie.css">
<script>
    function validateForm() {
        var title = document.getElementById("title").value;
        var description = document.getElementById("description").value;
        var genre = document.getElementById("genre").value;
        var releaseDate = document.getElementById("releaseDate").value;
        var coverImage = document.getElementById("coverImage").value;
        var movieVideo = document.getElementById("movieVideo").value;
        var retainImage = document.getElementById("retainImage").checked;
        var retainVideo = document.getElementById("retainVideo").checked;

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
        if (releaseDate === "") {
            alert("Please enter a valid release date.");
            return false;
        }
        // Validate image upload only if not retaining current image
        if (!retainImage && !coverImage) {
            alert("Please upload a cover image or check 'Retain current image'.");
            return false;
        }
        // Validate video upload only if not retaining current video
        if (!retainVideo && !movieVideo) {
            alert("Please upload a movie video or check 'Retain current video'.");
            return false;
        }

        return true; // Allow form submission if all validations pass
    }

    window.onload = function() {
        var submitBtn = document.getElementById("submitBtn");

        submitBtn.onclick = function(event) {
            console.log("Submit button clicked, starting validation...");
            // Perform validation
            if (validateForm()) {
            	alert("Submitted Successfully!");
                document.getElementById("movieForm").submit();  // Submit the form if validation passes
            }
        };
    };
</script>
</head>
<body>


<div class="container">
    <div class="main-content">
    <%
        String id = request.getParameter("id");
        String title  = request.getParameter("title");
        String description  = request.getParameter("description");
        String genre  = request.getParameter("genre");
        String date  = request.getParameter("date");
        String image = request.getParameter("image");
        String video = request.getParameter("video");
    %>
        
        <form id="movieForm" action="${pageContext.request.contextPath}/Admin/Movies/updateMovie" method="post" enctype="multipart/form-data">
            <h1 class="page-title">Update Movie</h1>
            
            <label for="title">ID:</label>
            <input type="text" id="id" name="id" value="<%=id%>" readonly>
            
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%=title%>">

            <label for="description">Description:</label>
            <textarea id="description" name="description"><%=description%></textarea>

            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre" value="<%=genre%>">

            <label for="releaseDate">Release Date:</label>
            <input type="date" id="releaseDate" name="releaseDate" value="<%=date%>" required max="<%= new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>">


            <label for="coverImage">Cover Image:</label>
            <img src="media/<%= image %>" width="200" height="150">
            <input type="file" id="coverImage" name="coverImage">
            <input type="checkbox" id="retainImage" name="retainImage" checked> Retain current image
            <br><br>

            <label for="movieVideo">Movie Video:</label>
            <video src="media/<%= video %>" width="200" height="150" controls></video>
            <input type="file" id="movieVideo" name="movieVideo">
            <input type="checkbox" id="retainVideo" name="retainVideo" checked> Retain current video
            <br><br>
            
            <button type="button" id="submitBtn">Update Movie</button> <!-- Changed to type="button" -->
        </form>
    </div>
</div>

</body>
</html>
