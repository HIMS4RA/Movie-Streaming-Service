<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
     
       
    <title>MovieDojo Home</title>
    <link rel="stylesheet" href="Homecss/HomePage.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <script>
    // Function to filter movies based on search input
    function filterMovies() {
        // Get the search query
        let query = document.getElementById('searchQuery').value.toLowerCase();
        
        // Get all movie cards
        let movies = document.querySelectorAll('.movie-card');

        // Loop through all the movies and display/hide based on search query
        movies.forEach(movie => {
            let title = movie.querySelector('h3').textContent.toLowerCase();
            
            if (title.includes(query)) {
                movie.style.display = "block";  // Show matching movie
            } else {
                movie.style.display = "none";   // Hide non-matching movie
            }
        });
    }
</script>
</head>
<body>
    <!-- Hero Section -->
    <header class="hero-section">
        <nav class="navbar">
        
       
          
            <ul>
            <!-- Add your logo here -->
                <li><a href="#movies">Movies</a></li>
               <li><a href="CustomerReadServlet?username=<%= java.net.URLEncoder.encode(username, "UTF-8") %>">Account</a></li>
                <li><a href="Ancread">Announcements</a></li>
                <li><a href="HomeContactUs/feedbackInsert.jsp">Reviews</a></li>
                <li><a href="ContactusHome/contactus.jsp">Contact Us</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
        <div class="hero-content">
        <img src="Homecss/logo3.png" alt="MovieDojo Logo" class="hero-logo">
             
      		
        </div>
    </header>

    <!-- Movies Section -->
   
    <section id="movies" class="section movies-section">
        <h2>Movies</h2>
          <!-- Search Bar -->
        <form id="searchForm" onsubmit="return false;" class="search-bar">
    <input type="text" id="searchQuery" placeholder="Search movies..." onkeyup="filterMovies()" required>
    <button type="button">Search</button>
</form>
        <div class="content-grid">
            <!-- Loop through the movie details -->
            <c:forEach var="movie" items="${movieDetails}">
                <div class="movie-card">
                 <a href="homeMovieRead?id=${movie.id}">
                    <img src="Admin/Movies/media/${movie.image}" alt="${movie.title}" class="movie-image" />
                    <h3>${movie.title}</h3>
                   <!--  ${movie.description}</p>--> 
                    <p>Genre: ${movie.genre}</p>
                    <p>Release Date: ${movie.date}</p>
                   </a>
                </div>
            </c:forEach>
        </div>
    </section>

   
   

    <!-- Footer -->
    <!-- Footer -->
<footer>
    <div class="footer-content">
        <div class="footer-section about">
            <h3>About MovieDojo</h3>
            <p>MovieDojo offers the latest movies and TV shows for streaming. Join us for an unmatched entertainment experience.</p>
        </div>

        <div class="footer-section quick-links">
            <h3>Quick Links</h3>
            <ul>
                <li><a href="#movies">Movies</a></li>
                <li><a href="Ancread">Announcements</a></li>
                <li><a href="HomeContactUs/feedbackInsert.jsp">Reviews</a></li>
                <li><a href="ContactusHome/contactus.jsp">Contact Us</a></li>
            </ul>
        </div>

        <div class="footer-section contact">
            <h3>Contact Us</h3>
            <p>Email: support@moviedojo.com</p>
            <p>Phone: +1 234 567 890</p>
        </div>

      <div class="footer-section social">
    		<h3>Follow Us</h3>
    		<a href="#" class="fab fa-facebook-f" aria-label="Facebook"></a>
   		 	<a href="#" class="fab fa-twitter" aria-label="Twitter"></a>
    		<a href="#" class="fab fa-instagram" aria-label="Instagram"></a>
	</div>

    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 MovieDojo. All rights reserved.</p>
    </div>
</footer>

</body>
</html>
