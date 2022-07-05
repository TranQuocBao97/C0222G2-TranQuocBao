<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/6/2022
  Time: 08:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
    <label>Username</label>
    <input name="username" value="${usernameCookie}">
    <br>
    <label>Password</label>
    <input name="password" value="${passwordCookie}">
    <br>
    <input name="remember" type="checkbox">Remember Me<br>
    <button type="submit">Login</button>
</form>
</body>
</html>
