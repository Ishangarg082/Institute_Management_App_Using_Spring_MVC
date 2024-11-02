<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fees Management</title>
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
        .navbar {
            background-color: #4CAF50;
            overflow: hidden;
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
            background-color: #fff;
            border-radius: 8px;
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
        .action-container {
            display: flex;
            justify-content: center;
            margin-top: 30px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        input[type="text"], select, input[type="submit"] {
            padding: 10px;
            margin: 10px 5px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            width: 200px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
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
    
    <div class="container">
        <h1>Fee Management</h1>

        <div class="action-container">
            <form action="${pageContext.request.contextPath}/feebyroll" method="POST">
                <input type="text" name="rollnumber" placeholder="Search by Roll Number" required>
                <input type="submit" value="Search">
            </form>
            <form action="${pageContext.request.contextPath}/feebystatus" method="POST">
                <select name="status">
                    <option value="">Select Status</option>
                    <option value="yes">Paid</option>
                    <option value="no">Unpaid</option>
                </select>
                <input type="submit" value="Filter">
            </form>
        </div>

        <table>
            <tr>
                <th>Roll Number</th>
                <th>Name</th>
                <th>Branch</th>
                <th>Fee</th>
                <th>Status</th>
            </tr>
            <c:forEach var="fees" items="${fees}">
                <tr>
                    <td>${fees.rollnumber}</td>
                    <td>${fees.name}</td>
                    <td>${fees.branch}</td>
                    <td>${fees.fees}</td>
                    <td>${fees.paid}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
