<%-- 
    Document   : course-register
    Created on : 23 Apr, 2023, 6:37:54 PM
    Author     : manicharanreddy
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Courses available to register</h1>
        <c:choose>
            <c:when test="${not empty availableCourses}">
                <form action="register.htm" method="post">
                    <select name="courseId">
                        <c:forEach items="${availableCourses}" var="course">
                            <option value="${course.courseId}">${course.courseName}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Register">
                </form>
            </c:when>
            <c:otherwise>
                <p>No available courses to register.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
