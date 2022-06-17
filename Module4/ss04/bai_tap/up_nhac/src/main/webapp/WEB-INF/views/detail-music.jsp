<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Detail Music</h1>
<table>
    <tr>
        <td>id</td>
        <td>${music.id}</td>
    </tr>
    <tr>
        <td>name</td>
        <td>${music.name}</td>
    </tr>
    <tr>
        <td>singer</td>
        <td>${music.singer}</td>
    </tr>
    <tr>
        <td>link</td>
        <td>
            <a href="${music.link}">link music</a>
        </td>
    </tr>
    <tr>
        <td>
            <a href="/music/list">back to list</a>
        </td>
        <td></td>
    </tr>
</table>
</body>
</html>
