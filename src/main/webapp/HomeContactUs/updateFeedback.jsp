<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Feedbacks</title>
    <link rel="stylesheet" href="updatedeletefb.css"> <!-- Link to external CSS -->
    <script>
        function validateUpdateForm() {
            var name = document.getElementsByName("Name")[0].value.trim();
            var email = document.getElementsByName("Email")[0].value.trim();
            var mobileNo = document.getElementsByName("MobileNo")[0].value.trim();
            var subject = document.getElementsByName("Subject")[0].value.trim();
            var message = document.getElementsByName("Message")[0].value.trim();

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
            var submitBtn = document.querySelector("input[type='submit']");
            submitBtn.onclick = function(event) {
                // Perform validation
                if (!validateUpdateForm()) {
                    event.preventDefault(); // Prevent form submission if validation fails
                } else {
                    alert("Submitted Successfully!"); // Updated message on successful validation
                }
            };
        };
    </script>
</head>
<body>

<%
   String FID = request.getParameter("FID");
   String Name = request.getParameter("Name");
   String Email = request.getParameter("Email");
   String MobileNo = request.getParameter("MobileNo");
   String Subject = request.getParameter("Subject");
   String Message = request.getParameter("Message");
%>

<div class="container1">
<h1>Update Feedback</h1>
<form action="update" method="post" onsubmit="return validateUpdateForm();">
    <table>
    <tr>
        <td>Feedback ID</td>
        <td><input type="number" class="inputbar" name="FID" value="<%=FID %>" readonly></td>
    </tr>
    <tr>
        <td>Name</td> 
        <td><input type="text" class="inputbar" name="Name" value="<%=Name %>"></td>
    </tr>
    <tr>
        <td>Email</td> 
        <td><input type="email" class="inputbar" name="Email" value="<%=Email %>"></td>
    </tr>
    <tr>
        <td>Mobile</td>
        <td><input type="text" class="inputbar" name="MobileNo" value="<%=MobileNo %>"></td>
    </tr>
    <tr>    
        <td>Subject</td>
        <td><input type="text" class="inputbar" name="Subject" value="<%=Subject %>"></td>
    </tr>
    <tr>
        <td>Message</td>
        <td><input type="text" class="inputbar" name="Message" value="<%=Message %>"></td>
    </tr>
    </table>
    <div class="submit">
        <input type="submit" class="btn" name="update" value="Update">
    </div>
</form>
</div>

</body>
</html>
