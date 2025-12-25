<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Announcements</title>
    <link rel="stylesheet" type="text/css" href="../../jithyacss/updatecus.css"> <!-- Link to your CSS file -->
</head>
<body>

<%
    String id = request.getParameter("id");
    String date = request.getParameter("date");
    String category = request.getParameter("category");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
    
%>
<h2>Delete Announcement&#128203;&#128260;</h2> <!-- Added title above the form -->
<form action="${pageContext.request.contextPath}/Admin/Announcement/deleteAnc" method="post">
    <table>
        <tr>
            <td>Announcement ID</td>
            <td><input type="text" name="id" value="<%= id %>" readonly></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><input type="text" name="date" value="<%= date%>" readonly></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="category" value="<%= category %>"readonly></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="<%= title %>"readonly></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><input type="text" name="content" value="<%= content %>"readonly></td>
        </tr>
        
    </table>
    
    <input type="submit" name="submit" value="delete">
</form>

</body>
</html>