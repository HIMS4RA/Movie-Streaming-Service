<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - SllitFlix Theme</title>
    <link rel="stylesheet" type="text/css" href="jithyacss/login.css"> <!-- Link to CSS file -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;700&display=swap"> 
    
    <!-- Link to Google Fonts -->
    
</head>
<body>

    <header>
        <div class="site-name">MovieDojo</div>
    </header>

    <div class="login-container">
        <h1>Sign In</h1>
        <form action="log" method="post" class="login-form">
            
            <label for="username">Username &#128100;</label>
            <input type="text" id="username" name="username" placeholder="Enter your username" required>
            
            <label for="password">Password&#128274;</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>
            
            <h4>Don't have an Account?</h4>
			<a href="Register.jsp">Register</a>

            <input type="submit" name="submit" value="Login" class="btn-submit">
            
            

        </form>
        
    </div>

</body>
</html>