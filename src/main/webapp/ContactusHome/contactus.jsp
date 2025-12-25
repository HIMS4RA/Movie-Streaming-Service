<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Us - MovieDojo</title>
    <link rel="stylesheet" href="styles/contactForm.css"> 
    <link rel="stylesheet" type="text/css" href="../Homecss/navbarstyles.css"> 
    <script>
        function validateForm() {
            var firstName = document.getElementById("firstName").value.trim();
            var lastName = document.getElementById("lastName").value.trim();
            var email = document.getElementById("email").value.trim();
            var phone = document.getElementById("phone").value.trim();
            var subject = document.getElementById("subject").value.trim();
            var message = document.getElementById("message").value.trim();

       
            if (firstName === "") {
                alert("First Name is required.");
                return false;
            }
            if (lastName === "") {
                alert("Last Name is required.");
                return false;
            }
            if (email === "") {
                alert("Email is required.");
                return false;
            }
            if (message === "") {
                alert("Message is required.");
                return false;
            }

            // Validate first and last name (must contain letters only)
            var namePattern = /^[a-zA-Z]+$/;
            if (!namePattern.test(firstName)) {
                alert("First Name can only contain letters.");
                return false;
            }
            if (!namePattern.test(lastName)) {
                alert("Last Name can only contain letters.");
                return false;
            }

            // Validate email format
            var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailPattern.test(email)) {
                alert("Please enter a valid email address.");
                return false;
            }

            // Validate phone number (must be 10 digits)
            if (phone) {
                if (!/^\d{10}$/.test(phone)) {
                    alert("Phone number must be exactly 10 digits.");
                    return false;
                }
            }

            return true; // Allow form submission if all validations pass
        }

        window.onload = function() {
            var submitBtn = document.querySelector("input[type='submit']");
            submitBtn.onclick = function(event) {
                console.log("Submit button clicked, starting validation...");
                // Perform validation
                if (!validateForm()) {
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

<!-- Contact Form Section -->
<div class="container">
    <h1>Get in Touch with Us</h1>
    <div class="form-section">
        <h2>Send Us a Message</h2>
        <form action="insert" method="post">
            <div class="form-row">
                <div>
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" placeholder="First Name" required>
                </div>
                <div>
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" placeholder="Last Name" required>
                </div>
            </div>

            <div class="form-row">
                <div>
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" placeholder="Your Email" required>
                </div>
                <div>
                    <label for="phone">Phone</label>
                    <input type="text" id="phone" name="phone" placeholder="Your Phone Number">
                </div>
            </div>

            <label for="subject">Subject</label>
            <input type="text" id="subject" name="subject" placeholder="Subject">

            <label for="message">Message</label>
            <textarea id="message" name="message" rows="4" placeholder="Tell us your thoughts or ask us anything!" required></textarea>

            <input type="submit" value="Send Message">
        </form>
    </div>

    <div class="contact-section">
        <h2>Contact Information</h2>
        <p>If you're looking for help with your account, suggestions, or need assistance, we're here to help!</p>
        <p><strong>Phone:</strong> 011 2 492 492</p>
        <p><strong>Email:</strong> <a href="mailto:support@moviedojo.com">support@moviedojo.com</a></p>

        <h2>Follow Us</h2>
        <p>
            <a href="#">Facebook</a> | <a href="#">Instagram</a> | <a href="#">Twitter</a>
        </p>
    </div>
</div>

</body>
</html>
