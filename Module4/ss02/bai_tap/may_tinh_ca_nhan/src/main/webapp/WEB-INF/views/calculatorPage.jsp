
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator/do-math">
<input type="text" name="num1" value="${num1}">
<input type="text" name="num2" value="${num2}">
    <br>
    <br>
    <button type="submit" name="math" value="add">Add(+)</button>
    <button type="submit" name="math" value="sub">Sub(-)</button>
    <button type="submit" name="math" value="mul">Mul(x)</button>
    <button type="submit" name="math" value="div">Div(/)</button>
</form>
result : ${result}
</body>
</html>
