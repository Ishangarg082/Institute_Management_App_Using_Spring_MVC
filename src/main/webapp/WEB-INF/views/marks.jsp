<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .content {
        padding: 40px;
        max-width: 1400px;
        margin: auto;
    }
    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    h2 {
        color: #495057;
        margin-top: 30px;
        border-bottom: 2px solid #4CAF50;
        padding-bottom: 10px;
    }
    .user-details {
        background-color: #ffffff;
        border: 1px solid #dee2e6;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        margin-bottom: 20px;
    }
    table {
        width: 100%; /* Ensure the table takes full width */
        max-width: 100%; /* Set a maximum width */
        margin: 20px auto; /* Center the table */
        border-collapse: collapse;
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
        justify-content: center;
        gap: 10px;
    }
    input[type="text"], select {
        padding: 10px;
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
        min-width: 100px;
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
    <h1>Marks Dashboard</h1>

    <div class="content">
        <h2>Marks of Student</h2>
        <div class="user-details">
            <p><strong>Username:</strong> ${student.rollnumber}</p>
            <p><strong>Name:</strong> ${student.name}</p>
            <p><strong>Age:</strong> ${student.age}</p>
            <p><strong>Branch:</strong> ${student.branch}</p>
            <p><strong>Address:</strong> ${student.address}</p>
        </div>

        <table>
            <tr>
                <th>Marks ID</th>
                <th>Course ID</th>
                <th>Marks</th>
                <th>Action</th>
            </tr>
            <c:forEach var="courses" items="${courses}">
                <tr>
                    <td>${courses.courseid}</td>
                    <td>${courses.name}</td>
                    <td>coming soon</td>
                    <td>
                        <form action="deleteUser.jsp" method="post" style="display: inline;">
                            <input type="hidden" name="userId" value="${courses.courseid}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="updateUser.jsp" method="post" style="display: inline;">
                            <input type="hidden" name="userId" value="${courses.courseid}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="action-container">
            <h2>Add New Course</h2>
            <form action="addUser.jsp" method="post">
                <label for="CourseName">Course Name:</label>
                <input type="text" id="CourseName" name="CourseName" required>
                <label for="CourseId">Course ID:</label>
                <input type="text" id="CourseId" name="CourseId" required>
                <input type="submit" value="Add Course">
            </form>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </div>
    </div>
</body>
</html>
