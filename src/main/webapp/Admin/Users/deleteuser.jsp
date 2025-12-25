<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
    <link rel="stylesheet" type="text/css" href="deletecus.css"> <!-- Link to your CSS file -->
</head>
<body>

    <%
    String id = request.getParameter("id");
   
    
    %>
    
    <div class="container">
        <h1>Delete This User Account Permanently&#10071;</h1>
        <form action="${pageContext.request.contextPath}/Admin/Users/deleteuser" method="post" class="customer-form">
            <table>
                <tr>
                    <td>Customer ID</td>
                    <td><input type="text" name="id" value="<%= id %>" readonly></td>
                </tr>
               
            </table>
            <input type="submit" name="submit" value="delete" class="btn-delete">
        </form>
    </div>

</body>
</html>