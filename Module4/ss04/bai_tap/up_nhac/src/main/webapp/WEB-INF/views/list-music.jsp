<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Music</h1>
<div>${mess}</div>
<c:forEach items="${listMusic}" var="music" varStatus="loop">
    <div>
        <span>${loop.count} :</span>
        <a href="/music/detail/${music.id}">${music.name}</a>
    </div>
</c:forEach>
<div>
    <a href="/music/form">back add form</a>
</div>
</body>
</html>
