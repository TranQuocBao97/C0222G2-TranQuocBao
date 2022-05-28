<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2022
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>$Title$</title>
    <style>
        table {
            border: solid 1px black;
        }
    </style>
</head>
<body>
<div><p>Product Discount Calculator</p></div>
<form method="get" action="/ServletProductDiscountCalculator">
    <table>
        <tr>
            <td><label for="description">Product Description: </label></td>
            <td><input type="text" id="description" name="product_description"></td>
        </tr>
        <tr>
            <td><label for="price">List Price: </label></td>
            <td><input type="number" id="price" name="product_price"></td>
        </tr>
        <tr>
            <td><label for="discount">Discount Percent: </label></td>
            <td><input type="number" id="discount" name="product_discount"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="calculator"></td>
        </tr>
    </table>
</form>
</body>
</html>
