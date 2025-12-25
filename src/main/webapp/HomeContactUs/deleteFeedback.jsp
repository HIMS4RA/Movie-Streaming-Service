<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Feedback</title>
<link rel="stylesheet" href="updatedeletefb.css">
</head>
<body>
<%
   String FID=request.getParameter("FID");
   String Name=request.getParameter("Name");
   String Email=request.getParameter("Email");
   String MobileNo=request.getParameter("MobileNo");
   String Subject=request.getParameter("Subject");
   String Message=request.getParameter("Message");
   
%>

<div class="container1">
<h1>Delete Feedback</h1>
<form action="delete" method="post" >
    <table>
    <tr>
    <td>Feedback ID</td>
    <td><input type="number" class="inputbar" name="FID" value="<%=FID %>" readonly></td>
    </tr>
    <tr>
    <td>Name</td> 
    <td><input type="text" class="inputbar"name="Name" value="<%=Name %>" readonly></td>
    </tr>
    <tr>
    <td>Email</td> 
    <td><input type="email" class="inputbar" name="Email" value="<%=Email %>" readonly></td>
    </tr>
    <tr>
    <td>Mobile</td>
    <td><input type="text" class="inputbar" name="MobileNo" value="<%=MobileNo %>" readonly></td>
    </tr>
    <tr>    
    <td>Subject</td>
    <td><input type="text" class="inputbar" name="Subject" value="<%=Subject %>" readonly></td>
    </tr>
    <tr>
    <td>Message</td>
    <td><input type="text" class="inputbar" name="Message" value="<%=Message %>" readonly></td>
    </tr>
    </table>
    <div class="submit">
    <input type="submit" class="btn" name="delete" value="Delete">
    </div>
</form>
</div>

</body>
</html>