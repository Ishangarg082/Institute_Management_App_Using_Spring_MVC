<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<script type="text/javascript">
    if (window.history && window.history.pushState) {
        window.history.pushState(null, null, window.location.href);
        window.onpopstate = function () {
            window.history.pushState(null, null, window.location.href);
        };
    }
</script>
<title>User Console</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #eaeef2;
	margin: 0;
	padding: 0;
	color: #333;
}

.content {
	padding: 40px;
	max-width: 800px;
	margin: auto;
}

.user-details {
	background-color: #ffffff;
	padding: 30px;
	border-radius: 12px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
	transition: transform 0.3s;
	margin-bottom: 20px;
}

.user-details:hover {
	transform: translateY(-5px);
}

h2 {
	color: #4CAF50;
	margin-bottom: 20px;
	text-align: center;
	font-size: 28px;
}

p {
	font-size: 16px;
	margin: 10px 0;
	color: #555;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px;
	border: 1px solid #dee2e6;
	text-align: left;
}

th {
	background-color: #4CAF50;
	color: white;
}

tr:nth-child(even) {
	background-color: #f8f9fa;
}

tr:hover {
	background-color: #d1e7dd;
}

.logout-container {
	display: flex;
	justify-content: center;
	margin-top: 30px;
}

a {
	width: 200px;
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 12px;
	border-radius: 5px;
	font-size: 16px;
	text-align: center;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s;
	text-decoration: none;
}

a:hover {
	background-color: #45a049;
	transform: translateY(-2px);
}

footer {
	text-align: center;
	margin-top: 40px;
	font-size: 14px;
	color: #777;
}
</style>
</head>
<body>

	<div class="content">
		<h2>Student Details</h2>
		<div class="user-details">
			<p>
				<strong>Username:</strong> ${student.rollnumber}
			</p>
			<p>
				<strong>Name:</strong> ${student.name}
			</p>
			<p>
				<strong>Age:</strong> ${student.age}
			</p>
			<p>
				<strong>Branch:</strong> ${student.branch}
			</p>
			<p>
				<strong>Address:</strong> ${student.address}
			</p>
		</div>
	</div>

	<div class="content">
		<h2>Course Details</h2>
		<div class="user-details">
			<table>
				<tr>
					<th>Course ID</th>
					<th>Course Name</th>
					<th>Marks</th>
					<th>Attendance</th>
				</tr>
				<c:forEach var="courseData" items="${courseData}">
					<tr>
						<td>${courseData.courseid}</td>
						<td>${courseData.coursename}</td>
						<td>${courseData.marks}</td>
						<td>${courseData.totalpresent}/${courseData.totalclasses}</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<h2>Fee Status</h2>
		<div class="user-details" style="background-color: #ffffff;">
			<p>
				<strong>Fees:</strong> ${fee.fees}
			</p>
			<p>
				<strong>Paid:</strong> ${fee.paid}
			</p>
			<p style="color: #856404;">
				<strong>Reminder:</strong> ${feemessage}
			</p>
		</div>
	</div>

	<div class="logout-container">
		<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>

	<footer>
		<p>&copy; 2024 Your Institution. All rights reserved.</p>
	</footer>

</body>
</html>
