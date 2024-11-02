<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Student</title>
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
            margin-top: 10px;
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
        input[type="text"], input[type="number"], textarea, select {
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
    <h1>Update Student Information</h1>

    <form action="${pageContext.request.contextPath}/updatestudent" method="post">
    	<label for="rollnumber">RollNumber:</label>
        <input type="text" name="rollnumber" value="${student.rollnumber}" readonly required>
		
		
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${student.name}" required>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" value="${student.age}" required>

        <label for="branch">Branch:</label>
        <input type="text" id="branch" name="branch" value="${student.branch}" required>

        <label for="address">Address:</label>
        <textarea id="address" name="address" required>${student.address}</textarea>
        
         <label for="pass">Password:</label>
        <input type="Password" id="pass" name="pass" value="${student.pass}" required>

        <input type="submit" value="Update Student">
    </form>

    <div style="text-align: center; margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/students">Back to Student List</a>
    </div>
</body>
</html>
