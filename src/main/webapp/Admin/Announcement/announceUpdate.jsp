<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Announcements</title>
    <link rel="stylesheet" type="text/css" href="../../jithyacss/updatecus.css"> <!-- Link to your CSS file -->
    <script>
        function validateInputs() {
            const titleInput = document.getElementsByName("title")[0];
            const categoryInput = document.getElementsByName("category")[0];
            
            if (titleInput.value.length > 45) {
                alert("Title must be 45 characters or less.");
                titleInput.value = titleInput.value.slice(0, 45); // Truncate to 45 characters
                return false; // Prevent form submission
            }
            
            if (categoryInput.value.length > 30) {
                alert("Category must be 30 characters or less.");
                categoryInput.value = categoryInput.value.slice(0, 30); // Truncate to 30 characters
                return false; // Prevent form submission
            }
            
            return true; // Allow form submission
        }
    </script>
</head>
<body>

<%
    String id = request.getParameter("id");
    String date = request.getParameter("date");
    String category = request.getParameter("category");
    String title = request.getParameter("title");
    String content = request.getParameter("content");
%>
<h2>Update Announcement&#128203;&#128260;</h2> <!-- Added title above the form -->
<form action="${pageContext.request.contextPath}/Admin/Announcement/updateAnc" method="post" onsubmit="return validateInputs()">
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
            <td><input type="text" name="category" value="<%= category %>"></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="<%= title %>"></td>
        </tr>
        <tr>
            <td>Content</td>
            <td><input type="text" name="content" value="<%= content %>"></td>
        </tr>
    </table>
    
    <input type="submit" name="submit" value="Update">
</form>

</body>
</html>
