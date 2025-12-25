<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
    <link rel="stylesheet" type="text/css" href="jithyacss/deletecus.css"> <!-- Link to your CSS file -->
</head>
<body>

    <%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String userName = request.getParameter("userName");
    %>
    
    <div class="container">
        <h1>Delete your Account&#10060;</h1>
        <form action="delete" method="post" class="customer-form">
            <table>
                <tr>
                    <td>Customer ID</td>
                    <td><input type="text" name="id" value="<%= id %>" readonly></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="<%= name %>" readonly></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%= email %>" readonly></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" value="<%= phone %>" readonly></td>
                </tr>
                <tr>
                    <td>User Name</td>
                    <td><input type="text" name="userName" value="<%= userName %>" readonly></td>
                </tr>
            </table>
            <input type="submit" name="submit" value="delete" class="btn-delete">
        </form>
    </div>

</body>
</html>