<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Customer Details</title>
    <link rel="stylesheet" type="text/css" href="jithyacss/updatecus.css"> <!-- Link to your CSS file -->
</head>
<body>

<%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
%>
<h2>Update user details&#128203;&#128260;</h2> <!-- Added title above the form -->
<form action="Update" method="post">
    <table>
        <tr>
            <td>Customer ID</td>
            <td><input type="text" name="id" value="<%= id %>" readonly></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<%= name %>"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="<%= email %>"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="<%= phone %>"></td>
        </tr>
        <tr>
            <td>User Name</td>
            <td><input type="text" name="userName" value="<%= userName %>"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value="<%= password %>"></td>
        </tr>
    </table>
    
    <input type="submit" name="submit" value="Update">
</form>

</body>
</html>