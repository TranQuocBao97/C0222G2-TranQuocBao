<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hello Spring!</h2>
    <form action="/sum" method="get">
        <div>
            Number 1:
            <input type="text" name="number1">
        </div>
        <div>
            Number 2:
            <input type="text" name="number2">
        </div>
        <div>
<%--            <input type="submit" value="Sum 2 num">--%>
            <button>Sum 2 num</button>
        </div>
    </form>

</body>
</html>
