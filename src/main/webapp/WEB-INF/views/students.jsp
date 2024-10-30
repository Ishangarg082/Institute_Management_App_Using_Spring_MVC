<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Courses</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            margin: 0px;
            padding: 0px;
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
    <h1>Admin Dashboard</h1>
    <h2>User Management</h2>

    <table>
        <tr>
            <th>Course Name</th>
            <th>Course Id</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="courses" items="${courses}">
        <tr>
            <td>${courses.courseid}</td>
            <td>${courses.name}</td>
            <td>
                <form action="deleteUser.jsp" method="post" style="display:inline;">
                    <input type="hidden" name="userId" value="${course.courseid}">
                    <input type="submit" value="Delete">
                </form>
                <form action="deleteUser.jsp" method="post" style="display:inline;">
                    <input type="hidden" name="userId" value="${course.courseid}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

    <div class="action-container">
        <h2>Add New Course</h2>
        <form action="addUser.jsp" method="post">
            <label for="Course Name">CourseName:</label>
            <input type="text" id="CouseName" name="CourseName" required>
            <label for="CourseId">CourseId:</label>
            <input type="text" id="CourseId" name="CourseId" required>
         
            <input type="submit" value="Add Course">
        </form>

        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </div>
</body>
</html>
