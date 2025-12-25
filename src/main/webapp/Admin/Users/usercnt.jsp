<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details - MovieDoJo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Admin/Users/usercnt.css"> <!-- Link to CSS file -->
</head>
<body>
<header>
    <a href="login.jsp">
        <div class="site-name">MovieDoJo</div>
    </a>
</header>

<div class="dashboard-container">
    <div class="sidebar">
        <ul>
            <li><a href="../../AdminDashCount"> Dashboard</a></li>
            <li><a href="../Movies/adminreadMovies">Movies</a></li>
            <li><a href="../Announcement/display"><i></i> Announcements</a></li>
            <li><a href="#">Users</a></li>
            <li><a href="../Feedback/read">Feedbacks</a></li>
            <li><a href="../Contact/readcont">Inquiries</a></li>
            
        </ul>
    </div>

    <div class="main-content">
        <h2>User Accounts &#128274;</h2>
           <div class="customer-count">
            <h3>Total Accounts: <span id="customerCount" class="count-number">${customerCount}</span></h3>
        </div>
        <div class="user-details">
            <table class="user-table">
                <thead>
                    <tr>
                    	<th>&#x1F194; ID</th> <!-- User emoji -->
                        <th>&#128100; Name</th> <!-- User emoji -->
                        <th>&#9993; Email</th> <!-- Email emoji -->
                        <th>&#128222; Phone</th> <!-- Phone emoji -->
                        <th>&#128273; Username</th> <!-- Key emoji for Username -->
                        <th>&#128274; Password</th> <!-- Lock emoji for Password -->
                        <th>Action &#127987;</th> <!-- Action for delete button -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="cus" items="${cusDetails}">
                        <tr>
                        	<td>${cus.id}</td>
                            <td>${cus.name}</td>
                            <td>${cus.email}</td>
                            <td>${cus.phone}</td>
                            <td>${cus.userName}</td>
                            <td>${cus.password}</td>
                            <td>
                                <c:url value="deleteuser.jsp" var="cusdelete">
                                    <c:param name="id" value="${cus.id}"/>
                                </c:url>
                                <a href="${cusdelete}">
                                    <button class="btn-delete">Delete</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

  <script>
    // Function to animate counting effect
    function animateCount(target) {
        const countDisplay = document.getElementById(target);
        let count = 0;
        const targetCount = parseInt(countDisplay.textContent);

        const increment = Math.ceil(targetCount / 100); // Change 100 to desired number of increments

        const interval = setInterval(() => {
            count += increment;
            if (count >= targetCount) {
                countDisplay.textContent = targetCount;
                clearInterval(interval);
            } else {
                countDisplay.textContent = count;
            }
        }, 50); // Adjust speed as needed
    }

    // Start the counting effect after the page loads
    window.onload = () => {
        animateCount("customerCount");
    };
</script>


</body>
</html>