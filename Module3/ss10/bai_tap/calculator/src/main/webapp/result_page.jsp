<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/30/2022
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>
        <c:if test="${cantDivision == 0}">
            Result: ${lastResult}
        </c:if>
        <c:if test="${cantDivision == 1}">
            Cant division by zero
        </c:if>
    </h1>
</div>
</body>
</html>
