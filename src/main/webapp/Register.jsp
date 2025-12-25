<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="jithyacss/cregister.css"> <!-- Link to CSS file -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap"> <!-- Link to Google Fonts -->
  
</head>
<body>

<header>
        <div class="site-name">MovieDojo</div>
</header>

    <div class="register-container">
        <h1>Create Your Account&#127871;</h1>
        <form action="insert" method="post" class="register-form">
            
            <label for="name">Name&#128100;</label>
            <input type="text" id="name" name="name" placeholder="Enter your name" required>
            
            <label for="email">Email&#128231;</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="phone">Phone Number&#128222;</label>
            <input type="text" id="phone" name="phone" placeholder="Enter your phone number" required>

            <label for="uid">Username&#128100;</label>
            <input type="text" id="uid" name="uid" placeholder="Choose a username" required>

            <label for="psw">Password&#128274;</label>
            <input type="password" id="psw" name="psw" placeholder="Create a password" required><br>

            <input type="submit" name="submit" value="Register" class="btn-submit"><br>

        </form>
    </div>

</body>
</html>