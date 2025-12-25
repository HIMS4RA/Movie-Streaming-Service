<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Message</title>
<link rel="stylesheet" href="styles/Delete.css">

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

		<form action="Delete" method="post">
		
			CustomerID : <input type="text" name="id" value="<%= id %>" readonly><br>
			First Name : <input type="text" name="firstName" value="<%= firstName %>"readonly><br>
			Last Name : <input type="text" name="lastName" value="<%= lastName %>"readonly><br>
			Email : <input type="email" name="email" value="<%= email %>"readonly><br>
			Phone : <input type="text" name="phone" value="<%= phone %>"readonly><br>
			Subject : <input type="text" name="subject" value="<%= subject %>"readonly><br>
			Message : <input type="text" name="message" value="<%= message %>"readonly><br>
			
			<input type="submit" name="Delete" value="Delete"><br>		
		
		
		</form>


</body>
</html>