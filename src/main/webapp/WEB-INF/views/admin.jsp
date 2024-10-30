<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .navbar {
            background-color: #4CAF50;
            width: 100%;
            padding: 10px 0;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            position: fixed; /* Fixed position at the top */
            top: 0; /* Align to the top */
            z-index: 1000; /* Ensure it stays on top of other elements */
        }
        .navbar a {
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-weight: bold;
            transition: background-color 0.3s;
            display: inline-block; /* Align links horizontally */
        }
        .navbar a:hover {
            background-color: #45a049;
        }
        .login-container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
            margin-top: 70px; /* Space for fixed navbar */
        }
        h2 {
            margin-bottom: 20px;
            color: #343a40;
        }
        label {
            display: block;
            margin-bottom: 5px;
            text-align: left;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="password"] {
            width: 94%;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #4CAF50;
            outline: none;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }
        .error-message {
            color: red;
            margin-top: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/home">Home</a>
        <a href="${pageContext.request.contextPath}/studentlogin">Student Login</a>
        <a href="${pageContext.request.contextPath}/stafflogin">Staff Login</a>
        <a href="${pageContext.request.contextPath}/admin">Admin Login</a>
    </div>
    <div class="login-container">
        <h2>Admin Login</h2>
        <form action="${pageContext.request.contextPath}/adminconsole" method="post">
            <label for="userid">Username:</label>
            <input type="text" id="userid" name="userid" required>
            
            <label for="pass">Password:</label>
            <input type="password" id="pass" name="pass" required>
            
            <input type="submit" value="Login">
        </form>
        <div class="error-message">
            ${errormessage}
        </div>
    </div>
</body>
</html>
