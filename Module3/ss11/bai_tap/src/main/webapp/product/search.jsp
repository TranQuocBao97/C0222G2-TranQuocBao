<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2022
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<td><a href="/product" class="btn btn-primary" role="button" >Back to list product</a></td>
<table class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Information</th>
        <th>Company</th>
    </tr>
    <c:forEach items="${listProductSearch}" var="product">
    <tr>
        <td>${product.getId()}</td>
        <td>${product.getName()}</td>
        <td>${product.getPrice()}</td>
        <td>${product.getInformation()}</td>
        <td>${product.getCompany()}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
