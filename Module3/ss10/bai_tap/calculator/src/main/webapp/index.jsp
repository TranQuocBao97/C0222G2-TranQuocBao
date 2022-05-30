<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/30/2022
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        table {
            border: solid 1px;
        }
    </style>
</head>
<body>
<h1>SIMPLE CALCULATOR</h1>
<form action="/calculator" method="get">
    <table border=1 class="table table-hover">
        <tr>
            <td>First operand:</td>
            <td><input type="number" name="firstNumber"></td>
        </tr>
        <tr>
            <td>Operator:</td>
            <td>
                <select name="operator">
                    <option value="1">add</option>
                    <option value="2">sub</option>
                    <option value="3">multi</option>
                    <option value="4">division</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Second operand: </td>
            <td><input type="number" name="secondNumber"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="calculate">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
