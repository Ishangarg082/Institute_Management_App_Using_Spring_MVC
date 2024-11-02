<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Marks Dashboard</title>
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

        table {
            width: 100%;
            margin: 20px auto;
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
        <h2>Search Marks</h2>
        <form action="${pageContext.request.contextPath}/searchMarksbyroll" method="post" style="display: flex; justify-content: center; margin-bottom: 20px;">
            <input type="text" name="rollnumber" placeholder="Enter Roll Number" required>
            <input type="submit" value="Search">
        </form>	
        <form action="${pageContext.request.contextPath}/searchMarksbycourse" method="post" style="display: flex; justify-content: center; margin-bottom: 20px;">
            <input type="text" name="courseid" placeholder="Enter Course ID" required>
            <input type="submit" value="Search">
        </form>

        <table>
            <tr>
                <th>Marks ID</th>
                <th>Roll Number</th>
                <th>Student Name</th>
                <th>Course ID</th>
                <th>Course Name</th>
                <th>Marks</th>
                <th>Action</th>
            </tr>
            <c:forEach var="mark" items="${mark}">
                <tr>
                    <td>${mark.marksid}</td>
                    <td>${mark.rollnumber}</td>
                    <td>${mark.studentname}</td>
                    <td>${mark.courseid}</td>
                    <td>${mark.coursename}</td>
                    <td>${mark.marks}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deleteMarks" method="post" style="display: inline;">
                            <input type="hidden" name="marksid" value="${mark.marksid}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="${pageContext.request.contextPath}/updateMarks" method="post" style="display: inline;">
                            <input type="hidden" name="marksid" value="${mark.marksid}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="action-container">
            <h2>Add New Marks</h2>
            <form action="${pageContext.request.contextPath}/addMarks" method="post">
                <label for="rollnumber">Roll Number:</label>
                <input type="text" id="rollnumber" name="rollnumber" required>
                <label for="courseid">Course ID:</label>
                <input type="text" id="courseid" name="courseid" required>
                <label for="marks">Marks:</label>
                <input type="text" id="marks" name="marks" required>
                <input type="submit" value="Add Marks">
            </form>
        </div>
    </div>
</body>
</html>
