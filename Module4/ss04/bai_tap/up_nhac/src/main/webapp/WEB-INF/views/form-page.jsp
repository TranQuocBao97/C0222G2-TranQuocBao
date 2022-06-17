
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add music</h1>
<form:form action="/music/add" modelAttribute="music" method="post">
<table>
    <tr>
        <td>Name song:</td>
        <td>
            <form:input path="name" required="required"/>
        </td>
    </tr>
    <tr>
        <td>Singer:</td>
        <td>
            <form:input path="singer" required="required"/>
        </td>
    </tr>
    <tr>
        <td>Link:</td>
        <td>
            <form:input path="link" required="required"/>
        </td>
    </tr>
    <tr>
        <td>
            <button type="submit">submit</button>
        </td>
        <td>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>
