<%--
  Created by IntelliJ IDEA.
  User: LENOVO PC
  Date: 6/3/2022
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.css">
</head>
<body>
<a href="/customer?action=create">Create</a>
<table class="table" id="myTable">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Name</th>
        <th scope="col">Gender</th>
        <th scope="col">BirthDay</th>
        <th scope="col">Customer Type</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="item">
        <tr>
            <td scope="row"> ${item.id}</td>
            <td scope="row"> ${item.name}</td>
            <td scope="row">
                <c:if test="${item.gender == 1}">
                    Nam
                </c:if>
                <c:if test="${item.gender == 0}">
                    Nữ
                </c:if>
            </td>
            <td scope="row"> ${item.birthday}</td>
            <td scope="row"> ${item.customerTypeId}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#myTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    } )
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
