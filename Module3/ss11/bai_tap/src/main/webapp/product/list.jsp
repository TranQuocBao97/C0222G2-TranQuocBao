
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
<h1>List Product</h1>
<a class="btn btn-primary" href="/product?action=create" role="button">Create new product</a>
<table border="1" class="table table-hover">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Information</th>
        <th>Company</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${listProduct}" var="product">
        <tr>
            <td>${product.id}</td>
            <td><a href="/product?action=display&id=${product.getId()}">${product.name}</a></td>
            <td>${product.price}</td>
            <td>${product.information}</td>
            <td>${product.company}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<form action="/product?action=search" method="post">
<table class="table table-hover">
        <tr>Search by name</tr>
        <tr><input type="text" name="search"></tr>
        <tr><input type="submit" value="Search"></tr>
</table>
</form>
</body>
</html>
