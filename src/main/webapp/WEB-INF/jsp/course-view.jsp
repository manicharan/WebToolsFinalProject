<%-- 
    Document   : course-view
    Created on : 9 Apr, 2023, 9:54:12 PM
    Author     : manicharanreddy
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty requestScope.allcourses}">
                <h1>All Available Courses</h1>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Num of Credits</th>
                    </tr>
                    <c:forEach items="${requestScope.allcourses}" var="course">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                            <td>${course.creditHours}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:when test="${not empty requestScope.registeredCourses}">
                <h1>My Courses</h1>
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Num of Credits</th>
                    </tr>
                    <c:forEach items="${requestScope.registeredCourses}" var="course">
                        <tr>
                            <td>${course.courseId}</td>
                            <td>${course.courseName}</td>
                            <td>${course.creditHours}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <p>No available courses to view.</p>
            </c:otherwise>
        </c:choose>

    </body>
</html>
