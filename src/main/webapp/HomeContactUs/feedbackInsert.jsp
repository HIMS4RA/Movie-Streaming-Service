<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feedback Form</title>
    <link rel="stylesheet" href="style.css"> <!-- Adjusted path to external CSS -->
    <link rel="stylesheet" type="text/css" href="../Homecss/navbarstyles.css"> <!-- Link to navbar CSS -->
    <script>
        function validateFeedbackForm() {
            var name = document.getElementById("Name").value.trim();
            var email = document.getElementById("Email").value.trim();
            var mobileNo = document.getElementById("MobileNo").value.trim();
            var subject = document.getElementById("Subject").value.trim();
            var message = document.getElementById("Message").value.trim();

            // Check if the fields are empty
            if (name === "") {
                alert("Name is required.");
                return false;
            }
            if (email === "") {
                alert("Email is required.");
                return false;
            }
            if (mobileNo === "") {
                alert("Mobile Number is required.");
                return false;
            }
            if (subject === "") {
                alert("Subject is required.");
                return false;
            }
            if (message === "") {
                alert("Message is required.");
                return false;
            }

            // Validate name (must contain only letters and spaces)
            var namePattern = /^[A-Za-z\s]+$/;
            if (!namePattern.test(name)) {
                alert("Name must contain only letters and spaces.");
                return false;
            }

            // Validate email format
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }

            // Validate mobile number (must be 10 digits)
            if (!/^\d{10}$/.test(mobileNo)) {
                alert("Mobile number must be exactly 10 digits.");
                return false;
            }

            return true; // Allow form submission if all validations pass
        }

        window.onload = function() {
            var submitBtn = document.querySelector("button[type='submit']");
            submitBtn.onclick = function(event) {
                console.log("Submit button clicked, starting validation...");
                // Perform validation
                if (!validateFeedbackForm()) {
                    event.preventDefault(); // Prevent form submission if validation fails
                } else {
                	alert("Submitted Successfully!");
                }
            };
        };
    </script>
</head>
<body>

<!-- Navigation Bar -->
<nav class="navbar">
    <div class="logo">
        <h5>MovieDojo.</h5>
    </div>
    <ul>
        <li><a href="../homereadMovies">Home</a></li>
        <li><a href="../CustomerReadServlet?username=<%= java.net.URLEncoder.encode((String)session.getAttribute("username"), "UTF-8") %>">Account</a></li>
        <li><a href="../Ancread">Announcements</a></li>
        <li><a href="../HomeContactUs/feedbackInsert.jsp">Reviews</a></li>
        <li><a href="../ContactusHome/contactus.jsp">Contact Us</a></li>
        <li><a href="../logout.jsp">Logout</a></li>
    </ul>
</nav>

<!-- Feedback Form Section -->
<section class="latest-feedbacks">
    <c:import url="/displaylatestfb" />
</section>

<h1>Speak Up! Your Experience Makes Us Better..</h1>

<div class="container1">
    <form action="insert" method="post">
        <div class="title">
            <h1>FEEDBACK FORM</h1><br>
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="Name" placeholder="Enter name" name="Name" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="Email" placeholder="Enter email" name="Email" required>
        </div>
        <div class="form-group">
            <label for="mobile">Mobile No</label>
            <input type="text" class="form-control" id="MobileNo" placeholder="Enter mobile number" name="MobileNo" required>
        </div>
        <div class="form-group">
            <label for="subject">Subject</label>
            <input type="text" class="form-control" id="Subject" placeholder="Enter subject" name="Subject" required>
        </div>
        <div class="form-group">
            <label for="message">Message:</label>
            <input type="text" class="form-control" id="Message" placeholder="Enter message" name="Message" required>
        </div>
        <div class="submit">
            <button type="submit" class="btn" name="submit" value="insert">Submit</button>
        </div>
    </form>
</div>

</body>
</html>
