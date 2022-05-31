<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2022
  Time: 10:43 AM
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
<h1>Create New Product Page</h1>
<a class="btn btn-primary" role="button" href="/product">Back to list product</a>
<form method="post">
    <table class="table table-hover">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>Information</td>
            <td><input type="text" name="information"></td>
        </tr>
        <tr>
            <td>Company</td>
            <td><input type="text" name="company"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </table>
</form>
<p>${mess}</p>
</body>
</html>
