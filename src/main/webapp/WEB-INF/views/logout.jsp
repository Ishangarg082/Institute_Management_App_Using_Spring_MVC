<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logout Successful</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            display: flex;
            flex-direction: column; /* Stack elements vertically */
            justify-content: center;
            align-items: center;
            height: 100vh; /* Full viewport height */
            margin: 0;
            text-align: center;
        }
        .logout-container {
            background-color: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
            width: 350px;
            margin-bottom: 20px; /* Add space between the container and footer */
        }
        h2 {
            color: #4CAF50;
            margin-bottom: 20px;
            font-size: 1.6em;
        }
        p {
            margin-bottom: 25px;
            color: #555;
            font-size: 1.1em;
        }
        a {
            display: inline-block;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            padding: 12px 20px;
            border-radius: 5px;
            transition: background-color 0.3s, transform 0.2s;
            font-weight: bold;
        }
        a:hover {
            background-color: #45a049;
            transform: translateY(-2px);
        }
        .footer {
            margin-top: 30px;
            font-size: 0.9em;
            color: #777;
        }
    </style>
</head>
<body>
    <div class="logout-container">
        <h2>Logout Successful</h2>
        <p>You have been successfully logged out.</p>
        <a href="${pageContext.request.contextPath}/home">Return to Home</a>
    </div>
    <div class="footer">
        &copy; 2024 My Application. All rights reserved.
    </div>
</body>
</html>
