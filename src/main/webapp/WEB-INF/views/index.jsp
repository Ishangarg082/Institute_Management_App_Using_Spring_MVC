<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to My Institute Management App</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #343a40;
            margin-bottom: 20px;
        }
        p {
            font-size: 1.1em;
            line-height: 1.6;
            color: #555;
            margin: 15px 0;
        }
        .link-section {
            margin-top: 40px;
            text-align: center;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 12px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
            font-weight: bold;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }
        a:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }
        .footer {
            text-align: center;
            margin-top: 40px;
            font-size: 0.9em;
            color: #777;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to My Institute Management System</h1>
    <p>
        This application allows you to manage your institute efficiently. You can perform various operations such as creating, reading, updating, and deleting data with ease.
    </p>
    <p>
        Whether you're an admin or a user, our platform provides a user-friendly interface to facilitate all your database management needs.
    </p>

    <div class="link-section">
        <h2>Access Options</h2>
        <a href="${pageContext.request.contextPath}/admin">Admin</a>
        <a href="${pageContext.request.contextPath}/stafflogin">Staff Login</a>
        <a href="${pageContext.request.contextPath}/studentlogin">Student Login</a>
    </div>

    <div class="footer">
        &copy; 2024 My Institute Management App. All rights reserved.
    </div>
</div>
</body>
</html>
