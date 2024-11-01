<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7fa;
            margin: 0; /* Reset margin */
            padding: 0; /* Reset padding */
        }

        h1 {
            text-align: center;
            color: #343a40;
            margin: 20px 0;
        }

        h2 {
            color: #495057;
            margin-top: 30px;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
            text-align: center; /* Center align the heading */
        }

        .navbar {
            background-color: #4CAF50;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            position: sticky; /* Sticky navbar */
            top: 0; /* Fix to the top */
            z-index: 1000; /* Above other elements */
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

        .container {
            max-width: 1200px; /* Set max width */
            margin: 0 auto; /* Center container */
            padding: 20px; /* Add padding */
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #fff; /* White background for the table */
            border-radius: 8px; /* Rounded corners */
            overflow: hidden; /* Prevent overflow on rounded corners */
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
            display: inline; /* Keep forms inline */
            margin: 0; /* Reset margin */
        }

        label {
            margin-right: 10px;
            font-weight: bold;
        }

        input[type="text"], select {
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            width: 200px;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus, select:focus {
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

        .action-container h2 {
            margin: 0 0 20px 0; /* Adjust margin for h2 */
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
    <div class="navbar">
        <a href="${pageContext.request.contextPath}/courses">Courses</a>
        <a href="${pageContext.request.contextPath}/students">Students</a>
        <a href="${pageContext.request.contextPath}/attendance">Attendance</a>
        <a href="${pageContext.request.contextPath}/marks">Marks</a>
        <a href="${pageContext.request.contextPath}/fees">Fees</a>
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>	
    <div class="container">
        <h1>Course Management</h1>

        <table>
            <tr>
                <th>Course Name</th>
                <th>Course ID</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.courseid}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deletecourse" method="post">
                            <input type="hidden" name="courseid" value="${course.courseid}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="${pageContext.request.contextPath}/editcourse" method="post">
                            <input type="hidden" name="courseid" value="${course.courseid}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="action-container">
            <h2>Add New Course</h2>
            <form action="${pageContext.request.contextPath}/addcourse" method="post">
                <label for="CourseName">Course Name:</label>
                <input type="text" id="CourseName" name="CourseName" required>
                <label for="CourseId">Course ID:</label>
                <input type="text" id="CourseId" name="CourseId" required>
                <input type="submit" value="Add Course">
            </form>
        </div>
    </div>
</body>
</html>
