<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students</title>
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

        h2 {
            color: #495057;
            margin-top: 30px;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 10px;
            text-align: center;
        }

        .navbar {
            background-color: #4CAF50;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            position: sticky;
            top: 0;
            z-index: 1000;
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
            max-width: 1200px; 
            margin: 0 auto; 
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            background-color: #fff; 
            border-radius: 8px; 
            overflow: hidden; 
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

        .action-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 30px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1150px; 
            margin-left: auto;
            margin-right: auto;
        }

        form {
            width: 70%;
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 5px;
        }

        input[type="text"] {
            padding: 10px;
            margin-bottom: 10px; 
            border: 1px solid #ced4da;
            border-radius: 4px;
            width: 100%;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
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
        <h1>Student Management</h1>

        <table>
            <tr>
                <th>Student Name</th>
                <th>Student RollNumber</th>
                <th>Branch</th>
                <th>Action</th>
            </tr>
            <c:forEach var="Student" items="${Student}">
                <tr>
                    <td>${Student.name}</td>
                    <td>${Student.rollnumber}</td>
                    <td>${Student.branch}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/deletestudent" method="post" style="display:inline;">
                            <input type="hidden" name="rollnumber" value="${Student.rollnumber}">
                            <input type="submit" value="Delete">
                        </form>
                        <form action="${pageContext.request.contextPath}/editstudent" method="post" style="display:inline;">
                            <input type="hidden" name="rollnumber" value="${Student.rollnumber}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <div class="action-container">
            <h2>Add New Student</h2>
            <form action="${pageContext.request.contextPath}/addstudent" method="post">
                <label for="rollnumber">RollNumber:</label>
                <input type="text" id="rollnumber" name="rollnumber" required>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="age">Age:</label>
                <input type="text" id="age" name="age" required> 
                <label for="branch">Branch:</label>
                <input type="text" id="branch" name="branch" required>
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
                <label for="pass">Password:</label>
                <input type="text" id="pass" name="pass" required>
                <input type="submit" value="Add Student">
                
            </form>
        </div>
    </div>
</body>
</html>
