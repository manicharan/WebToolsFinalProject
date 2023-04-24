<%--
    Document   : signup
    Created on : 23 Apr, 2023, 6:00:00 PM
    Author     : manicharanreddy
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Signup Page</title>
</head>
<body>
    <h1 style="text-align: center;">Signup for Canvas</h1>
    <hr><br>
    <form:form modelAttribute="user" method="POST" action="signup.htm" style="text-align: center;">
        First Name: <form:input type="text" name="firstName" path="firstName" /><br>
        <form:errors path="firstName" style="color: red;" /> <br>
        Last Name: <form:input type="text" name="lastName" path="lastName" /><br>
        <form:errors path="lastName" style="color: red;" /> <br>
        Email: <form:input type="text" name="email" path="email" /><br>
        <form:errors path="email" style="color: red;" /> <br>
        Password: <form:input type="password" name="password" path="password" /><br>
        <form:errors path="password" style="color: red;" /> <br>
        <input type="submit" value="Signup"  /><br><br>
        Already have an account? <a href="login.htm">Login here!</a>
    </form:form>
</body>
</html>
