<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/30/2022
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        tr,th,td {
            border: solid 1px black;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Your search</th>
        <th>result</th>
    </tr>
    <tr>
        <td>${search}</td>
        <td>${resultWord}</td>
    <tr>
</table>
</body>
</html>
