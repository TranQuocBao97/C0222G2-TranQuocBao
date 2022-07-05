<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/27/2022
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/sum" method="get">
    Number 1 <input type="number" name="numberOne"><br>
    Number 2 <input type="number" name="numberTwo"><br>
    <button type="submit">Calculator</button>
  </form>
  <h2>Kết quả là: ${temp}</h2>
  </body>
</html>
