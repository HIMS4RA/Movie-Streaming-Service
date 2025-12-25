<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Announcements - MovieDojo</title>
    <link rel="stylesheet" type="text/css" href="insertannou.css"> <!-- Link to CSS file -->
    <script>
        function validateInputs() {
            const titleInput = document.getElementById("title");
            const categoryInput = document.getElementById("category");
            
            if (titleInput.value.length > 45) {
                alert("Title must be 45 characters or less.");
                titleInput.value = titleInput.value.slice(0, 45); // Truncate to 45 characters
                return false; // Prevent form submission
            }
            
            if (categoryInput.value.length > 30) {
                alert("Category must be 30 characters or less.");
                categoryInput.value = categoryInput.value.slice(0, 30); // Truncate to 30 characters
                return false; // Prevent form submission
            }
            
            return true; // Allow form submission
        }
    </script>
</head>
<body>

<header>
    <a href="#">
        <div class="site-name"></div>
    </a>
</header>

<!-- Inserting form for new announcement -->
<div class="announcement-container">
    <h2>Create Announcements&#128172; &#128226;</h2>
    <form action="${pageContext.request.contextPath}/Admin/Announcement/insertAnc" method="post" class="announcement-form" onsubmit="return validateInputs()">
        <label for="category">Category &#128450; :</label>
        <input type="text" id="category" name="category" placeholder="Enter the category" required>

        <label for="title">Title &#128221; :</label>
        <input type="text" id="title" name="title" placeholder="Enter the title" required>

        <label for="content">Content &#9997; :</label>
        <textarea id="content" name="content" placeholder="Enter the announcement content" required></textarea>

        <input type="submit" name="submit" value="Publish &#x1F680;" class="btn-submit">
    </form>
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
