<%--
  Created by IntelliJ IDEA.
  User: LENOVO PC
  Date: 6/3/2022
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Title</title>
</head>

<body>

<form method="post">
    <div class="mb-3">
        <label class="form-label">Name</label>
        <input type="text" name="name" class="form-control" aria-describedby="emailHelp">
    </div>
    <select name="gender" >
        <option value="1">Nam</option>
        <option value="0">Nữ</option>
    </select>
    <div class="mb-3">
        <label class="form-label">Birthday</label>
        <input type="date" name="birthday" class="form-control" aria-describedby="emailHelp">
    </div>
    <select name="customerTypeId" >
        <c:forEach items="${customerTypeList}" var="item">
            <option value="${item.id}"> ${item.name} </option>
        </c:forEach>
    </select>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
