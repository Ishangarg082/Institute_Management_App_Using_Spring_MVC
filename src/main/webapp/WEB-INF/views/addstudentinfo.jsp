<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Student</title>
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
    <h1>Add Student Student Information</h1>

    <form action="${pageContext.request.contextPath}/addstudentinfo" method="post">
    <label for="rollnumber">Roll Number:</label>
    <input type="text" name="rollnumber" value="${student.rollnumber}" readonly required>

    <label for="fee">Fee:</label>
    <input type="text" id="fee" name="fee" required>

    <label for="feestatus">Fee Status:</label>
    <select id="feestatus" name="feestatus" required>
        <option value="yes">yes</option>
        <option value="no">no</option>
    </select>

    <label for="courseid1">Course ID 1:</label>
    <input type="text" id="courseid1" name="courseid1" required>

    <label for="courseid2">Course ID 2:</label>
    <input type="text" id="courseid2" name="courseid2" required>

    <label for="courseid3">Course ID 3:</label>
    <input type="text" id="courseid3" name="courseid3" required>

    <label for="courseid4">Course ID 4:</label>
    <input type="text" id="courseid4" name="courseid4" required>

    <label for="courseid5">Course ID 5:</label>
    <input type="text" id="courseid5" name="courseid5" required>


    <input type="submit" value="Update Student">
</form>


    <div style="text-align: center; margin-top: 20px;">
        <a href="${pageContext.request.contextPath}/students">Back to Student List</a>
    </div>
</body>
</html>
