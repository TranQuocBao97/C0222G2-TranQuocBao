<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2022
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Display Product</h1>
<a href="/product" class="btn btn-primary" role="button" >Back to list product</a>
<table class="table table-hover">
    <tr>
        <td>id</td>
        <td>${product.getId()}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${product.getPrice()}</td>
    </tr>
    <tr>
        <td>Information</td>
        <td>${product.getInformation()}</td>
    </tr>
    <tr>
        <td>Company</td>
        <td>${product.getCompany()}</td>
    </tr>
</table>
</body>
</html>
