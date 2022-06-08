<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
    <style>
        #editTable .modal-dialog {
            width: 100%;
            max-width: none;
            height: auto;
            margin: 0;
        }
    </style>
</head>
<body>

<div>
    <header></header>
</div>


<div align="center" class="mt-1">
    <div class="row container-fluid align-items-center p-3 text-white"
         style="background: #c4a664; border-radius: 20px">
        <div class="col-12">
            <h2>List of Employee</h2>
        </div>
    </div>
    <div class="row p-3">
        <form class="row container-fluid align-items-end" action="employee" method="post">
            <input type="hidden" name="action" value="search">
            <div class="col-2">
                <input type="text" class="form-control form-control-dark" placeholder="Search by id..."
                       aria-label="Search" name="searchId">
            </div>
            <div class="col-3">
                <input type="text" class="form-control form-control-dark" placeholder="Search by name..."
                       aria-label="Search" name="searchName">
            </div>
            <div class="col-3">
                <select class="form-select" name="searchPosition">
                    <option selected value="">None</option>
                    <c:forEach items="${employeePositionList}" var="position">
                            <option value="${position.positionId}">${position.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-3">
                <select class="form-select" name="searchDivision">
                    <option selected value="">None</option>
                    <c:forEach items="${divisionList}" var="division">
                            <option value="${division.divisionId}">${division.divisionName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-1">
                <button class="btn btn-outline-primary text-black" type="submit">
                    Search
                </button>
            </div>
        </form>
    </div>


    <table id="employeeListTable" class="table table-bordered table-hover text-center table-warning align-items-center">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Id Card</th>
            <th>Salary</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Position</th>
            <th>Education</th>
            <th>Division</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.birthday}</td>
                <td>${employee.idCard}</td>
                <td>
                    <fmt:formatNumber pattern="#,###.##" value="${employee.salary}"/>
                </td>
                <td>${employee.phone}</td>
                <td>${employee.email}</td>
                <td>${employee.address}</td>
                <td>${employee.positionName}</td>
                <td>${employee.educationName}</td>
                <td>${employee.divisionName}</td>
                    <%--BEGIN EDIT BUTTON AREA--%>
                <td id="editTable">
                    <button class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#editEmployeeModal${employee.id}">
                        Edit
                    </button>
                        <%--BEGIN EDIT MODAL--%>
                    <div class="modal fade" id="editEmployeeModal${employee.id}" style="top: 20%">
                        <div class="modal-dialog w-100 modal-xl overflow-hidden" style="width: 100%">
                            <form action="employee" method="post">
                                <input type="hidden" name="action" value="edit">
                                <div class="modal-content">
                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Edit form</h4>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <table class="table table-bordered table-hover text-center table-success align-items-center">
                                            <tr>
                                                <th>Id</th>
                                                <th>Name</th>
                                                <th>Birthday</th>
                                                <th>Id Card</th>
                                                <th>Salary</th>
                                                <th>Phone</th>
                                                <th>Email</th>
                                                <th>Address</th>
                                                <th>Position</th>
                                                <th>Education</th>
                                                <th>Division</th>
                                            </tr>
                                            <tr>
                                                <td style="width: 5%">
                                                    <input class="form-control" type="hidden" name="id"
                                                           value="${employee.id}">
                                                        ${employee.id}
                                                </td>
                                                <td><input class="form-control" type="text" name="name"
                                                           value="${employee.name}"></td>
                                                <td><input class="form-control" type="text" name="birthday"
                                                           value="${employee.birthday}">
                                                </td>
                                                <td><input class="form-control" type="text" name="idCard"
                                                           value="${employee.idCard}"></td>
                                                <td>
                                                    <input class="form-control" type="text" name="salary"
                                                           value="<fmt:formatNumber pattern="#" value="${employee.salary}"/>">
                                                </td>
                                                <td><input class="form-control" type="text" name="phone"
                                                           value="${employee.phone}"></td>
                                                <td><input class="form-control" type="text" name="email"
                                                           value="${employee.email}"></td>
                                                <td><input class="form-control" type="text" name="address"
                                                           value="${employee.address}"></td>
                                                <td>
                                                    <select class="form-select" name="position">
                                                        <c:forEach items="${employeePositionList}" var="position">
                                                            <c:if test="${position.name == employee.positionName}">
                                                                <option selected
                                                                        value="${position.positionId}">${position.name}</option>
                                                            </c:if>
                                                            <c:if test="${position.name != employee.positionName}">
                                                                <option value="${position.positionId}">${position.name}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td>
                                                    <select class="form-select" name="education">
                                                        <c:forEach items="${educationDegreeList}" var="education">
                                                            <c:if test="${education.educationDegreeName == employee.educationName}">
                                                                <option selected
                                                                        value="${education.educationDegreeId}">${education.educationDegreeName}</option>
                                                            </c:if>
                                                            <c:if test="${education.educationDegreeName != employee.educationName}">
                                                                <option value="${education.educationDegreeId}">${education.educationDegreeName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td>
                                                    <select class="form-select" name="division">
                                                        <c:forEach items="${divisionList}" var="division">
                                                            <c:if test="${division.divisionName == employee.divisionName}">
                                                                <option selected
                                                                        value="${division.divisionId}">${division.divisionName}</option>
                                                            </c:if>
                                                            <c:if test="${division.divisionName != employee.divisionName}">
                                                                <option value="${division.divisionId}">${division.divisionName}</option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </tr>

                                        </table>
                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">
                                            No
                                        </button>
                                        <button type="submit" class="btn btn-danger d-flex flex-row-reverse"
                                                data-bs-dismiss="modal">
                                            Yes
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                        <%--END EDIT MODAL--%>
                </td>
                    <%--END EDIT BUTTON AREA--%>


                    <%--BEGIN DELETE BUTTON AREA--%>
                <td>
                    <button class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#deleteEmployeeModal${employee.id}">
                        Delete
                    </button>
                        <%--begin delete modal--%>
                    <div class="modal fade" id="deleteEmployeeModal${employee.id}" style="top: 20%">
                        <div class="modal-dialog modal-xl overflow-hidden">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Are you sure to delete this?</h4>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <table class="table table-bordered table-hover text-center table-success">
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Birthday</th>
                                            <th>Id Card</th>
                                            <th>Salary</th>
                                            <th>Phone</th>
                                            <th>Email</th>
                                            <th>Address</th>
                                            <th>Position</th>
                                            <th>Education</th>
                                            <th>Division</th>
                                        </tr>
                                        <tr>
                                            <td>${employee.id}</td>
                                            <td>${employee.name}</td>
                                            <td>${employee.birthday}</td>
                                            <td>${employee.idCard}</td>
                                            <td>
                                                <fmt:formatNumber pattern="#,##0" value="${employee.salary}"/>
                                            </td>
                                            <td>${employee.phone}</td>
                                            <td>${employee.email}</td>
                                            <td>${employee.address}</td>
                                            <td>${employee.positionName}</td>
                                            <td>${employee.educationName}</td>
                                            <td>${employee.divisionName}</td>
                                        </tr>
                                    </table>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">
                                        No
                                    </button>
                                    <form action="employee" method="post">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="${employee.id}">
                                        <button type="submit" class="btn btn-danger d-flex flex-row-reverse"
                                                data-bs-dismiss="modal">
                                            Yes
                                        </button>
                                    </form>
                                </div>

                            </div>
                        </div>
                    </div>
                        <%--end delete modal--%>
                </td>
                    <%--END DETELE BUTTON AREA--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<%-- begin Modal check delete--%>
<div>
    <c:if test="${checkDelete == true}">
        <div class="modal fade" id="trueModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Success</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        Xóa thành công
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${checkDelete == false}">
        <div class="modal fade" id="falseModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">False</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        Xóa thất bại
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<%--end modal check delete--%>

<%-- begin Modal check edit--%>
<div>
    <c:if test="${checkEdit == true}">
        <div class="modal fade" id="trueModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Success</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        Sửa thành công
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${checkEdit == false}">
        <div class="modal fade" id="falseModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">False</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        Sửa thất bại
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<%--end modal check edit--%>


<%-- begin Modal added status--%>
<div>
    <c:if test="${messMap.mess == 'true'}">
        <div class="modal fade" id="trueModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Success</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <!-- Modal body -->
                    <div class="modal-body">
                        Thêm mới thành công
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${messMap.mess == 'false'}">
        <div class="modal fade" id="falseModal" style="top: 20%">
            <div class="modal-dialog overflow-hidden">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">False</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        Thêm mới thất bại
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</div>
<%--end modal added status--%>


</body>
<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../script/scriptForCustomer.js"></script>
<script>
    $(document).ready(function () {
        $('#employeeListTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script src="../includeHTML/jquery.includeHTML.js"></script>
<script>
    $(document).ready(function () {
        $('header').loadHTML('menu.html');
    })
</script>
<script>
    $(function () {
        $('#trueModal').modal('show');
    });
    $(function () {
        $('#falseModal').modal('show');
    });
</script>
</html>
