<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #e9ecef;
            margin: 0px;
            padding: 20px;
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
        input[type="text"], input[type="date"], select {
            padding: 10px;
            margin-right: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            width: 200px;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus, input[type="date"]:focus, select:focus {
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
            margin-top: 0px;
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
    <h1>Attendance Dashboard</h1>
    
    <!-- Search Form -->
    <div style="text-align: center; margin-bottom: 20px;">
        <h2>Search Attendance Records</h2>
        <form action="${pageContext.request.contextPath}/searchattbyroll" method="post">
            <label for="rollnumber">Roll Number:</label>
            <input type="text" id="rollnumber" name="rollnumber" placeholder="Enter Roll Number">
            <input type="submit" value="Search">
        </form>
        
        <form action="${pageContext.request.contextPath}/searchattbycourse" method="post">
            <label for="courseid">Course ID:</label>
            <input type="text" id="courseid" name="courseid" placeholder="Enter Course ID">
            <input type="submit" value="Search">
        </form>
    </div>

    <h2>Attendance Records</h2>

    <table>
        <tr>
            <th>Roll Number</th>
            <th>Course ID</th>
            <th>Date</th>
            <th>Attendance</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="attendance" items="${attendance}">
        <tr>
            <td>${attendance.rollnumber}</td>
            <td>${attendance.courseid}</td>
            <td>${attendance.date}</td>
            <td>${attendance.attendance}</td>
            <td>
                <form action="${pageContext.request.contextPath}/deleteAttendance" method="post" style="display:inline;">
                    <input type="hidden" name="rollNumber" value="${attendance.rollnumber}">
                    <input type="hidden" name="courseId" value="${attendance.courseid}">
                    <input type="hidden" name="date" value="${attendance.date}">
                    <input type="submit" value="Delete">
                </form>
                <form action="${pageContext.request.contextPath}/updateAttendance" method="post" style="display:inline;">
                    <input type="hidden" name="rollNumber" value="${attendance.rollnumber}">
                    <input type="hidden" name="courseId" value="${attendance.courseid}">
                    <input type="hidden" name="date" value="${attendance.date}">
                    <label for="status-${attendance.rollnumber}">Status:</label>
                    <select name="status" id="status-${attendance.rollnumber}">
                        <option value="Present" ${attendance.attendance == 'Present' ? 'selected' : ''}>Present</option>
                        <option value="Absent" ${attendance.attendance == 'Absent' ? 'selected' : ''}>Absent</option>
                    </select>
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
        </c:forEach>
    </table>

    <div class="action-container">
        <h2>Add New Attendance</h2>
        <form action="${pageContext.request.contextPath}/addattendance" method="post">
            <label for="rollNumber">Roll Number:</label>
            <input type="text" id="rollNumber" name="rollNumber" required>
            <label for="courseId">Course ID:</label>
            <input type="text" id="courseId" name="courseId" required>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>
            <label for="status">Status:</label>
            <select name="status" id="status">
                <option value="Present">Present</option>
                <option value="Absent">Absent</option>
            </select>
            <input type="submit" value="Add Attendance">
        </form>
    </div>

 
</body>
</html>
