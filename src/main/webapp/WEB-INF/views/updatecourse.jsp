<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Course</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7fa;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #343a40;
            margin: 20px 0;
        }
        form {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        label {
            margin-bottom: 10px;
            font-weight: bold;
            display: block;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus {
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
        .cancel {
            background-color: #dc3545;
            margin-left: 10px;
            padding: 10px 15px;
            border-radius: 4px;
            color: white;
            text-decoration: none;
            display: inline-block;
        }
        .cancel:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <h1>Update Course</h1>
    <form action="${pageContext.request.contextPath}/updatecourse" method="post">
        <input type="hidden" name="courseid" value="${courses.courseid}"> <!-- Hidden field for Course ID -->
        
        <label for="CourseName">Course Name:</label>
        <input type="text" id="CourseName" name="CourseName" value="${courses.name}" required>
        
        <label for="CourseId">Course ID:</label>
        <input type="text" id="CourseId" name="CourseId" value="${courses.courseid}" required readonly>
        
        <input type="submit" value="Update Course">
        <a href="${pageContext.request.contextPath}/courses" class="cancel">Cancel</a>
    </form>
</body>
</html>
