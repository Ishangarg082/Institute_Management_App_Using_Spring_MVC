<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Dashboard</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #e9ecef;
	margin: 0;
	padding: 20px;
}

h1 {
	text-align: center;
	color: #343a40;
	margin-bottom: 20px;
}

h2 {
	color: #495057;
	margin-top: 30px;
	border-bottom: 2px solid #4CAF50;
	padding-bottom: 10px;
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

form {
	margin: 10px 0;
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

label {
	margin-right: 10px;
	font-weight: bold;
}

input[type="text"], input[type="password"], select {
	padding: 10px;
	margin-right: 10px;
	border: 1px solid #ced4da;
	border-radius: 4px;
	width: 200px;
	transition: border-color 0.3s;
}

input[type="text"]:focus, input[type="password"]:focus, select:focus {
	border-color: #4CAF50;
	outline: none;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 15px;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.action-container {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 30px;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

a {
	text-decoration: none;
	color: #4CAF50;
	font-weight: bold;
	display: block;
	text-align: center;
	margin-top: 20px;
	padding: 10px;
	border: 2px solid #4CAF50;
	border-radius: 4px;
	transition: background-color 0.3s, color 0.3s;
}

a:hover {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h1>Admin Dashboard</h1>
	<h2>User Management</h2>

	<table>
		<tr>
			<th>User ID</th>
			<th>Password</th>
			<th>Role</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.user_id}</td>
				<td>${user.name}</td>
				<td>${user.role}</td>
				<td>
					<form action="${pageContext.request.contextPath}/deleteuser"
						method="post" style="display: inline;">
						<input type="hidden" name="userId" value="${user.user_id}">
						<input type="submit" value="Delete">
					</form>
					<form action="${pageContext.request.contextPath}/edituser"
						method="post" style="display: inline;">
						<input type="hidden" name="userId" value="${user.user_id}">
						<input type="submit" value="Update">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

	<div class="action-container">
		<h2>Add New User</h2>
		<form action="${pageContext.request.contextPath}/adduser"
			method="post">
			<label for="username">UserId:</label> <input type="text"
				id="username" name="username" required> <label for="name">Name:</label>
			<input type="text" id="name" name="name" required> <label
				for="pass">Password:</label> <input type="password" id="pass"
				name="pass" required> <label for="role">Role:</label> <select
				id="role" name="role" required>
				<option value="admin">admin</option>
				<option value="teacher">teacher</option>
				<option value="support">support</option>
			</select> <input type="submit" value="Add User">
		</form>

		<a href="${pageContext.request.contextPath}/logout">Logout</a>
	</div>
</body>
</html>
