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
        #editCustomerModal .modal-dialog {
            width: 100%;
            max-width: none;
            height: auto;
            margin: 0;
        }

        #editCustomerModal input {

        }
    </style>
</head>
<body>
<header>
    <div id="header-bar-first" class="p-3">
        <div class="d-flex flex-wrap align-items-center justify-content-between">
            <div>
                <a href="furama"><img src="../img/logo.png" alt="logo"></a>
            </div>
            <div class="text-end my-2 my-lg-0">
                <button type="button" class="btn btn-outline-primary">Login</button>
            </div>
        </div>
    </div>
    <div id="header-bar-second" class="p-3 bg-secondary text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="furama" class="nav-link px-2 text-white">Home</a></li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Employee
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <button class="dropdown-item" onclick="listEmployee()" type="submit">List employee
                                </button>
                            </li>
                            <li><a class="dropdown-item" href="">Add new employee</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Customer
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="dropdown-item" href="customer">List customer</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="customer?action=add">Add new customer</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Service
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="">List service</a></li>
                            <li><a class="dropdown-item" href="">Add new service</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Contract
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="">List contract</a></li>
                            <li><a class="dropdown-item" href="">Add new contract</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>


<div align="center" class="mt-1">
    <div class="row container-fluid align-items-center p-3 text-white"
         style="background: #869d9a; border-radius: 20px">
        <div class="col-8">
            <h2>List of Customer</h2>
        </div>
        <div class="col-4">
            <form class="row container-fluid align-items-end" action="customer" method="post">
                <input type="hidden" name="action" value="search">
                <div class="col-9">
                    <input type="text" class="form-control form-control-dark" placeholder="Search by name..."
                           aria-label="Search" name="name">
                </div>
                <div class="col-3">
                    <button class="btn btn-outline-light text-black" type="submit" style="background: white">
                        Search
                    </button>
                </div>
            </form>
        </div>
    </div>

    <table id="customerListTable"
           class="table table-bordered table-hover text-center table-success align-items-center">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Birthday</th>
            <th scope="col">Gender</th>
            <th scope="col">IdCard</th>
            <th scope="col">Phone</th>
            <th scope="col">Email</th>
            <th scope="col">Address</th>
            <th scope="col">Type</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${listCustomer}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>
                    <c:if test="${customer.gender == 1}">
                        Nam
                    </c:if>
                    <c:if test="${customer.gender == 0}">
                        Nữ
                    </c:if>
                </td>
                <td>${customer.idCard}</td>
                <td>${customer.phone}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <c:if test="${customer.typeId == 1}">
                        Diamond
                    </c:if>
                    <c:if test="${customer.typeId == 2}">
                        Platinum
                    </c:if>
                    <c:if test="${customer.typeId == 3}">
                        Gold
                    </c:if>
                    <c:if test="${customer.typeId == 4}">
                        Silver
                    </c:if>
                    <c:if test="${customer.typeId == 5}">
                        Member
                    </c:if>
                </td>

                <td>
                    <form action="/customer">
                        <input type="hidden" name="action" value="edit">
                        <input type="hidden" name="id" value="${customer.id}">
                        <button type="submit" class="btn btn-primary">Edit</button>
                    </form>
                </td>


                <td>
                    <button class="btn btn-primary" data-bs-toggle="modal"
                            data-bs-target="#deleteCustomerModal${customer.id}">
                        Delete
                    </button>


                    <div class="modal fade" id="deleteCustomerModal${customer.id}" style="top: 20%">
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
                                            <th scope="col">Id</th>
                                            <th scope="col">Name</th>
                                            <th scope="col">Birthday</th>
                                            <th scope="col">Gender</th>
                                            <th scope="col">IdCard</th>
                                            <th scope="col">Phone</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Address</th>
                                            <th scope="col">Type</th>
                                        </tr>
                                        <tr>
                                            <td>${customer.id}</td>
                                            <td>${customer.name}</td>
                                            <td>${customer.birthday}</td>
                                            <td>
                                                <c:if test="${customer.gender == 1}">
                                                    Nam
                                                </c:if>
                                                <c:if test="${customer.gender == 0}">
                                                    Nữ
                                                </c:if>
                                            </td>
                                            <td>${customer.idCard}</td>
                                            <td>${customer.phone}</td>
                                            <td>${customer.email}</td>
                                            <td>${customer.address}</td>
                                            <td>${customer.typeId}</td>
                                        </tr>
                                    </table>
                                </div>

                                <!-- Modal footer -->
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">No
                                    </button>
                                    <form action="customer" method="post">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="id" value="${customer.id}">
                                        <button type="submit" class="btn btn-danger d-flex flex-row-reverse"
                                                data-bs-dismiss="modal">Yes
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>


        </c:forEach>
        </tbody>
    </table>
</div>


<%--Modal delete customer--%>
<div>
    <c:if test="${checkDeleteCustomer == true}">
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
    <c:if test="${checkDeleteCustomer == false}">
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


<%--modal edit customer--%>
<div>
    <c:if test="${checkEditCustomer == true}">
        <div class="modal fade" id="trueEditModal" style="top: 20%">
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
    <c:if test="${checkEditCustomer == false}">
        <div class="modal fade" id="falseEditModal" style="top: 20%">
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


<c:forEach var="customer" items="${listCustomer}">
    <c:if test="${customer.id == idEdit}">
        <div class="modal fade" id="editCustomerModal" style="top: 20%">
            <div class="modal-dialog w-100 modal-xl overflow-hidden" style="width: 100%">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Edit menu:</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <table class="table table-bordered table-hover text-center table-success">
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Name</th>
                                <th scope="col">Birthday</th>
                                <th scope="col">Gender</th>
                                <th scope="col">IdCard</th>
                                <th scope="col">Phone</th>
                                <th scope="col">Email</th>
                                <th scope="col">Address</th>
                                <th scope="col">Type</th>
                                <th>Confirm</th>
                            </tr>
                            <form class="input-group" action="customer" method="post">
                                <tr>
                                    <input type="hidden" name="action" value="edit">
                                    <input type="hidden" name="id" value="${customer.id}">
                                    <td>${customer.id}</td>
                                    <td><input class="form-control" name="name" type="text" value="${customer.name}"></td>
                                    <td><input class="form-control" name="birthday" type="text" value="${customer.birthday}"></td>
                                    <td>
                                        <select class="form-select" name="gender">
                                            <option value=${customer.gender}>
                                                <c:if test="${customer.gender == 1}">
                                                    Nam
                                                </c:if>
                                                <c:if test="${customer.gender == 0}">
                                                    Nữ
                                                </c:if>
                                            </option>
                                            <option value="1">Nam</option>
                                            <option value="0">Nữ</option>
                                        </select>
                                    </td>
                                    <td><input class="form-control" name="idCard" type="text" value="${customer.idCard}"></td>
                                    <td><input class="form-control" name="phone" type="text" value="${customer.phone}"></td>
                                    <td><input class="form-control" name="email" type="text" value="${customer.email}"></td>
                                    <td><input class="form-control" name="address" type="text" value="${customer.address}"></td>
                                    <td>
                                        <select class="form-select" name="typeId">
                                            <option value=${customer.typeId}>
                                                <c:if test="${customer.typeId == 1}">
                                                    Diamond
                                                </c:if>
                                                <c:if test="${customer.typeId == 2}">
                                                    Platinum
                                                </c:if>
                                                <c:if test="${customer.typeId == 3}">
                                                    Gold
                                                </c:if>
                                                <c:if test="${customer.typeId == 4}">
                                                    Silver
                                                </c:if>
                                                <c:if test="${customer.typeId == 5}">
                                                    Member
                                                </c:if>
                                            </option>
                                            <option value="1">Diamond</option>
                                            <option value="2">Platinum</option>
                                            <option value="3">Gold</option>
                                            <option value="4">Silver</option>
                                            <option value="5">Member</option>
<%--                                        <input class="form-control" name="typeId" type="number" value="${customer.typeId}">--%>
                                    </td>
                                    <td><button type="submit" class="btn btn-danger">Save edit</button></td>
                                </tr>
                            </form>
                        </table>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">No
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </c:if>
</c:forEach>


</body>
<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../script/scriptForCustomer.js"></script>
<script>
    $(document).ready(function () {
        $('#customerListTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
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
<script>
    $(function () {
        $('#trueEditModal').modal('show');
    });
    $(function () {
        $('#falseEditModal').modal('show');
    });
</script>
<script>
    $(function () {
        $('#editCustomerModal').modal('show');
    });
</script>
</html>