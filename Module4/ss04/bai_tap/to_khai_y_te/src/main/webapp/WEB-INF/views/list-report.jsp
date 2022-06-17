<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>${mess}</h1>
    <table>
<c:forEach items="${listHealthReport}" var="report" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>
                <a href="/report/detail?dateStart=${report.dateStart}">Detail</a>
            </td>
        </tr>
</c:forEach>
    </table>
    <div>
        <a href="/report/form">Back To Add Form</a>
    </div>
</div>
</body>
</html>
