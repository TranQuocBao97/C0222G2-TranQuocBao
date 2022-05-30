<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/30/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>$Title$</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    table, tr, th, td {
      border: solid 1px;
    }
    img {
      width: auto;
      height: 100%;
    }
  </style>
</head>
<body>

<h1>Danh Sách Khách Hàng</h1>

<table class="table">
  <tr>
    <th>Tên</th>
    <th>Ngày Sinh</th>
    <th>Địa Chỉ</th>
    <th>Ảnh</th>
  </tr>
  <c:forEach items="${list}" var="temp">
    <tr>
      <td>${temp.name}</td>
      <td>${temp.birthday}</td>
      <td>${temp.address}</td>
      <td><img src="${temp.picUrl}"></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
