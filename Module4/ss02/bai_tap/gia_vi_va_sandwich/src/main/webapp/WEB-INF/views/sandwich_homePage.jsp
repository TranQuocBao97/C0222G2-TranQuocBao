<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SANDWICH CONDIMENTS</h1>
<form action="/sandwich/save">
    <input type="checkbox" value="tomato" name="condiment">Tomato
    <input type="checkbox" value="salad" name="condiment">Salad
    <input type="checkbox" value="mustard" name="condiment">Mustard
    <input type="checkbox" value="sauce" name="condiment">Sauce
    <button type="submit">check out</button>
</form>
<br>
<div>order is : <c:forEach items="${condiment}" var="item">
    ${item}
</c:forEach></div>
</body>
</html>
