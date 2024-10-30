<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Console</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #4CAF50;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
        }
        .navbar a:hover {
            background-color: #45a049;
        }
        .content {
            padding: 40px;
            max-width: 800px;
            margin: auto;
        }
        .user-details {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }
        .user-details:hover {
            transform: translateY(-5px);
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }
        p {
            font-size: 16px;
            margin: 10px 0;
            color: #555;
        }
        strong {
            color: #333;
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
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/courses">Courses</a>
        <a href="${pageContext.request.contextPath}/students">Students</a>
        <a href="${pageContext.request.contextPath}/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/marks">Marks</a>
        <a href="${pageContext.request.contextPath}/fees">Fees</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>

    <div class="content">
        <h2>User Details</h2>
        <div class="user-details">
            <p><strong>UserId:</strong> ${user.user_id}</p>
            <p><strong>Role:</strong> ${user.role}</p>
            <p><strong>Name:</strong> ${user.name}</p>
            <p><strong>Password:</strong> ${user.pass}</p>
        </div>
    </div>

</body>
</html>
