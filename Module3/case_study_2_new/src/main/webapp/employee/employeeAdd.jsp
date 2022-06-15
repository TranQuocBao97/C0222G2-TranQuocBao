<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
    <style>
        small {
            position: absolute;
            margin-top: -30px;
        }
    </style>
</head>
<body>
<div>
    <header></header>
</div>

<div>

    <c:if test="${checkAdded == true}">
        Thêm mới thành công
    </c:if>
    <c:if test="${checkAdded == false}">
        Thêm mới thất bại
    </c:if>

</div>

<div class="container mt-1">
    <div class="container text-center align-items-center p-3 text-white"
         style="background: #c4a664; border-radius: 20px">
        <h2>Add New Employee</h2>
    </div>
    <div class="mt-1">
        <form action="employee?action=add" method="post">
            <table class="table table-bordered table-hover text-center table-warning">
                <tr>
                    <td>Employee Name</td>
                    <td>
                        <input type="text" class="form-control" name="name" value="${employee.name}">
                        <small style="color: crimson">${messMap.name}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee Birthday</td>
                    <td>
                        <input type="date" class="form-control" name="birthday" value="${employee.birthday}">
                        <small style="color: crimson">${messMap.birthday}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee IdCard</td>
                    <td>
                        <input type="text" class="form-control" name="idCard" value="${employee.idCard}">
                        <small style="color: crimson">${messMap.idCard}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee Salary</td>
                    <td>
                        <input type="number" class="form-control" name="salary" value="${employee.salary}">
                        <small style="color: crimson">${messMap.salary}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee Phone</td>
                    <td>
                        <input type="text" class="form-control" name="phone" value="${employee.phone}">
                        <small style="color: crimson">${messMap.phone}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee Email</td>
                    <td>
                        <input type="text" class="form-control" name="email" value="${employee.email}">
                        <small style="color: crimson">${messMap.email}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employee Address</td>
                    <td>
                        <input type="text" class="form-control" name="address" value="${employee.address}">
                        <small style="color: crimson"></small>
                        <small style="color: crimson">${messMap.address}</small>
                    </td>
                </tr>
                <tr>
                    <td>Employer Position</td>
                    <td>
                        <select class="form-select" name="position">
                            <c:forEach items="${employeePositionList}" var="temp">
                                <option value="${temp.positionId}">${temp.name}</option>
                            </c:forEach>
                        </select>
                        <small style="color: crimson">${messMap.position}</small>
                    </td>
                </tr>
                <tr>
                    <td>Education Degree</td>
                    <td>
                        <select class="form-select" name="educationDegree">
                            <c:forEach items="${educationDegreeList}" var="temp">
                                <option value="${temp.educationDegreeId}">${temp.educationDegreeName}</option>
                            </c:forEach>
                        </select>
                        <small style="color: crimson">${messMap.education}</small>
                    </td>
                </tr>
                <tr>
                    <td>Division</td>
                    <td>
                        <select class="form-select" name="division">
                            <c:forEach items="${divisionList}" var="temp">
                                <option value="${temp.divisionId}">${temp.divisionName}</option>
                            </c:forEach>
                        </select>
                        <small style="color: crimson">${messMap.division}</small>
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
<script src="../includeHTML/jquery.includeHTML.js"></script>
<script>
    $(document).ready(function () {
        $('header').loadHTML('menu.html');
    })
</script>
</html>
