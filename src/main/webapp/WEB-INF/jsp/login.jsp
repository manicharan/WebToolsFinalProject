<%-- 
    Document   : login
    Created on : 2 Apr, 2023, 6:20:48 PM
    Author     : manicharanreddy
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h1 style="text-align: center;">Welcome to Canvas</h1>
    <hr><br>
    <form:form modelAttribute="user" method="POST" style="text-align: center;">
        Email: <form:input type="text" name="userName" path="email" /><br>
        <form:errors path="email" style="color: red;" /> <br>
        Password: <form:input type="password" name="password" path="password" /><br>
        <form:errors path="password" style="color: red;" /> <br>
        <input type="submit" value="Login"  /><br><br>
        New User? <a href="signup.htm">Sign up here!</a>
    </form:form>
</body>
</html>
