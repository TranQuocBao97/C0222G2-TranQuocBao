<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
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

<div>
    <c:if test="${checkAdded == true}">
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
    </c:if>
    <c:if test="${checkAdded == false}">
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


<div class="container mt-1">
    <div class="container text-center align-items-center p-3 text-white"
         style="background: #869d9a; border-radius: 20px">
        <h2>Add new customer</h2>
    </div>
    <div class="mt-1">
        <form action="customer?action=add" method="post">
            <table class="table table-bordered table-hover text-center table-success">
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" class="form-control" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Birthday</td>
                    <td>
                        <input type="text" class="form-control" name="birthday">
                    </td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <select class="form-select" name="gender"style="width: 20%">
                            <option value="1">Nam</option>
                            <option value="0">Nữ</option>
                        </select>
<%--                        <input type="text" class="form-control" name="gender">--%>
                    </td>
                </tr>
                <tr>
                    <td>IdCard</td>
                    <td>
                        <input type="text" class="form-control" name="idCard">
                    </td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td>
                        <input type="text" class="form-control" name="phone">
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <input type="text" class="form-control" name="email">
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>
                        <input type="text" class="form-control" name="address">
                    </td>
                </tr>
                <tr>
                    <td>Type</td>
                    <td>
                        <select name="type" class="form-select" style="width: 20%">
                            <option value="1">Diamond</option>
                            <option value="2">Platinum</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
<%--                        <input type="text" class="form-control" name="type">--%>
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
<script>
    $(function() {
        $('#trueModal').modal('show');
    });
    $(function() {
        $('#falseModal').modal('show');
    });
</script>
</html>
