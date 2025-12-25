<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin Panel</title>
<link rel="stylesheet" href="Admin/AdminDashStyles.css">
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
            <li><a href="#"> Dashboard</a></li>
            <li><a href="Admin/Movies/adminreadMovies"><i></i> Movies</a></li>
            <li><a href="Admin/Announcement/display"><i></i> Announcements</a></li>
            <li><a href="Admin/Users/displayuser">Users</a></li>
            <li><a href="Admin/Feedback/read">Feedbacks</a></li>
            <li><a href="Admin/Contact/readcont">Inquiries</a></li>
        </ul>
    </div>
    <div class="main-content">
        <h1>Welcome to the Admin Panel</h1>
        <div class="count-boxes">
            <div class="count-box">
                <h2>Movies</h2>
                <p class="count" data-count="${movieCount}">${movieCount}</p> <!-- This should be dynamically fetched -->
            </div>
            <div class="count-box">
                <h2>Users</h2>
                <p class="count" data-count="${userCount}">${userCount}</p> <!-- This should be dynamically fetched -->
            </div>
            <div class="count-box">
                <h2>Announcements</h2>
                <p class="count" data-count="${ancCount}">${ancCount}</p>
            </div>
            <div class="count-box">
                <h2>Inquiries</h2>
                <p class="count" data-count="${inqCount}">0</p>
            </div>
            <div class="count-box">
                <h2>Feedbacks</h2>
                <p class="count" data-count="${feedCount}">0</p>
            </div>
        </div>
    </div>
</div>

<script>
    // Function to animate counting effect for each count element
    function animateCount() {
        const counts = document.querySelectorAll('.count');
        counts.forEach((countElement) => {
            let count = 0;
            const targetCount = parseInt(countElement.getAttribute('data-count'));
            const increment = Math.ceil(targetCount / 200); // Adjust the number of increments
            const interval = setInterval(() => {
                count += increment;
                if (count >= targetCount) {
                    countElement.textContent = targetCount;
                    clearInterval(interval);
                } else {
                    countElement.textContent = count;
                }
            }, 100); // Adjust the speed of the counting effect
        });
    }

    // Start the counting effect after the page loads
    window.onload = () => {
        animateCount();
    };
</script>

</body>
</html>
