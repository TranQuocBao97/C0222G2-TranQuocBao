<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
</head>
<body>
<%--<div>--%>
<%--    <a href="furama">back to home page</a>--%>
<%--</div>--%>
<div>
    <c:if test="${checkAddService == true}">
        Thêm mới thành công
    </c:if>
    <c:if test="${checkAddService == false}">
        Thêm mới thất bại
    </c:if>
</div>


<div class="container mt-1">
    <div class="container text-center align-items-center p-3 text-white"
         style="background: #869d9a; border-radius: 20px">
        <h2>Add New Service</h2>
    </div>
    <div class="mt-1">
        <form action="service?action=add" method="post">
            <table class="table table-bordered table-hover text-center table-success">
                <tr>
                    <td>Service Name</td>
                    <td>
                        <input type="text" class="form-control" name="nameService">
                    </td>
                </tr>
                <tr>
                    <td>Service area</td>
                    <td>
                        <input type="text" class="form-control" name="area">
                    </td>
                </tr>
                <tr>
                    <td>Service cost</td>
                    <td>
                        <input type="text" class="form-control" name="cost">
                    </td>
                </tr>
                <tr>
                    <td>Service max people</td>
                    <td>
                        <input type="text" class="form-control" name="maxPeople">
                    </td>
                </tr>
                <tr>
                    <td>Standard room</td>
                    <td>
                        <input type="text" class="form-control" name="standardRoom">
                    </td>
                </tr>
                <tr>
                    <td>Description other convenience</td>
                    <td>
                        <input type="text" class="form-control" name="description">
                    </td>
                </tr>
                <tr>
                    <td>Pool area</td>
                    <td>
                        <input type="text" class="form-control" name="poolArea">
                    </td>
                </tr>
                <tr>
                    <td>Number of floors</td>
                    <td>
                        <input type="text" class="form-control" name="numberFloor">
                    </td>
                </tr>
                <tr>
                    <td>Rent type id</td>
                    <td>
                        <select class="form-select" name="rentTypeId">
                            <c:forEach items="${rentTypeList}" var="rentType">
                                <option value="${rentType.rentTypeId}">${rentType.rentTypeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Service type id</td>
                    <td>
                        <select class="form-select" name="serviceTypeId">
                            <c:forEach items="${serviceTypeList}" var="serviceType">
                                <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" class="btn btn btn-outline-success btn-lg btn-block" style="width: 100%">
                            Add
                        </button>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
</div>



</body>
<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../script/scriptForCustomer.js"></script>
</html>
