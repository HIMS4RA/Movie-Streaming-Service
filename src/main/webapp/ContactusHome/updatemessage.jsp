<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Message</title>
    <link rel="stylesheet" href="styles/Update.css">
    <script>
        function validateUpdateForm() {
            var firstName = document.getElementById("firstName").value.trim();
            var lastName = document.getElementById("lastName").value.trim();
            var email = document.getElementById("email").value.trim();
            var phone = document.getElementById("phone").value.trim();
            var subject = document.getElementById("subject").value.trim();
            var message = document.getElementById("message").value.trim();

            // Check if the fields are empty
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

            // Validate first name and last name (must contain only letters)
            var namePattern = /^[A-Za-z]+$/;
            if (!namePattern.test(firstName)) {
                alert("First Name must contain only letters.");
                return false;
            }
            if (!namePattern.test(lastName)) {
                alert("Last Name must contain only letters.");
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
                if (!validateUpdateForm()) {
                    event.preventDefault(); // Prevent form submission if validation fails
                } else {
                	alert("Submitted Successfully!");
                }
            };
        };
    </script>
</head>
<body>

<%
    String id = request.getParameter("id");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String subject = request.getParameter("subject");
    String message = request.getParameter("message");
%>

<form action="Update" method="post">
    CustomerID : <input type="text" name="id" value="<%= id %>" readonly><br>
    First Name : <input type="text" id="firstName" name="firstName" value="<%= firstName %>"><br>
    Last Name : <input type="text" id="lastName" name="lastName" value="<%= lastName %>"><br>
    Email : <input type="email" id="email" name="email" value="<%= email %>"><br>
    Phone : <input type="text" id="phone" name="phone" value="<%= phone %>"><br>
    Subject : <input type="text" id="subject" name="subject" value="<%= subject %>"><br>
    Message : <input type="text" id="message" name="message" value="<%= message %>"><br>
    
    <input type="submit" name="submit" value="Update My Message"><br>       
</form>

</body>
</html>
