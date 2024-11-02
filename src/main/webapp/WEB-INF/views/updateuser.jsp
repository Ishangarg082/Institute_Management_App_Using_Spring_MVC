<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update User</title>
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
         a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
            display: block;
            text-align: center;
            margin-top: 0px;
            padding: 10px;
            border: 2px solid #4CAF50;
            border-radius: 4px;
            transition: background-color 0.3s, color 0.3s;
        }
        a:hover {
            background-color: #4CAF50;
            color: white;
        }
        form {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            margin-right: 10px;
            font-weight: bold;
        }
        input[type="text"], input[type="password"], select {
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            width: calc(100% - 22px);
            transition: border-color 0.3s;
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
    </style>
</head>
<body>
    <h1>Update User</h1>

    <form action="${pageContext.request.contextPath}/updateuser" method="post">
        <input type="hidden" name="userid" value="${user.user_id}">

        <label for="username">User ID:</label>
        <input type="text" id="username" name="username" value="${user.user_id}" readonly required>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${user.name}" required>

        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass" value="${user.pass}" required>

        <label for="role">Role:</label>
        <select id="role" name="role" required>
            <option value="admin" ${user.role == 'admin' ? 'selected' : ''}>admin</option>
            <option value="teacher" ${user.role == 'teacher' ? 'selected' : ''}>teacher</option>
            <option value="support" ${user.role == 'support' ? 'selected' : ''}>support</option>
        </select>

        <input type="submit" value="Update User">
    </form>

    <div style="text-align: center; margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/students">Back </a>
    </div>
</body>
</html>
