<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 17/06/2022
  Time: 02:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="/layout :: head">
</head>
<body>
<h3>Product Management</h3>
<p>
    <a th:href="@{/product/create}">
        Add new product
    </a>
</p>
<table id = "products">
    <thead>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Image</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="product : ${products}">
        <td th:text="${product.name}"></td>
        <td th:text="${product.description}"></td>
        <td><img width="100" height="100" th:src="@{'/image/' + ${product.image}}" alt=""></td>
    </tr>
    </tbody>
</table>
<footer th:replace="/layout :: footer"></footer>
</body>
</html>
