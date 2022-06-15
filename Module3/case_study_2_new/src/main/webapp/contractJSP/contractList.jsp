<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
</head>
<body>

<div>
    <header></header>
</div>
<div align="center" class="mt-1">
    <div class="row container-fluid align-items-center p-3 text-white"
         style="background: #c4a664; border-radius: 20px">
        <div class="col-12">
            <h2>List of Contract</h2>
        </div>
    </div>
    <div class="row p-3">
        <form class="row container-fluid align-items-end" action="/contract" method="post">
            <input type="hidden" name="action" value="search">
            <div class="col-1">
                <div>Search Id:</div>
                <input type="number" class="form-control form-control-dark" placeholder="Search by id..."
                       aria-label="Search" name="searchId" value="">
            </div>
            <div class="col-2">
                <div>Date start from:</div>
                <input type="date" class="form-control form-control-dark" placeholder="Search from date..."
                       aria-label="Search" name="searchName" value="">
            </div>
            <div class="col-2">
                <div>To date start:</div>
                <input type="date" class="form-control form-control-dark" placeholder="Search to date..."
                       aria-label="Search" name="searchName" value="">
            </div>
            <div class="col-2">
                <div>Search Employee:</div>
                <select class="form-select" name="searchPosition">
                    <option selected value="">None</option>
                </select>
            </div>
            <div class="col-2">
                <div>Search Customer:</div>
                <select class="form-select" name="searchDivision">
                    <option selected value="">None</option>
                </select>
            </div>
            <div class="col-2">
                <div>Search Service:</div>
                <select class="form-select" name="searchDivision">
                    <option selected value="">None</option>
                </select>
            </div>
            <div class="col-1">
                <button class="btn btn-outline-primary text-black" type="submit">
                    Search
                </button>
            </div>
        </form>
    </div>
    <table id="contractListTable" class="table table-bordered table-hover text-center table-warning align-items-center">
        <thead>
        <tr>
            <th>Id</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Deposit (VNĐ)</th>
            <th>Employee</th>
            <th>Customer</th>
            <th>Service</th>
            <th>Total Price</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contractList}" var="contract">
            <tr>
                <td>${contract.id}</td>
                <td>${contract.startDate}</td>
                <td>${contract.endDate}</td>
                <td>${contract.deposit}</td>

                <td style="text-align: left">
                    <c:forEach items="${employeeList}" var="employee">
                        <c:if test="${employee.id == contract.employeeId}">
                            <a href="" data-bs-toggle="modal" data-bs-target="#employeeModal${employee.id}">
                                    ${employee.name}
                            </a>
                            <!-- Modal -->
                            <div class="modal fade" id="employeeModal${employee.id}" style="top: 20%">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">Employee Id : ${employee.id}</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <table class="table table-bordered">
                                               <tr>
                                                   <th>Name</th>
                                                   <td>${employee.name}</td>
                                               </tr>
                                                <tr>
                                                    <th>Phone</th>
                                                    <td>${employee.phone}</td>
                                                </tr>
                                                <tr>
                                                    <th>Position</th>
                                                    <td>${employee.positionName}</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </c:if>
                    </c:forEach>
                </td>

                <td></td>
                <td></td>
                <td>
                    <c:forEach items="${totalPriceList}" var="totalPrice">
                        <c:if test="${totalPrice.contractId == contract.id}">
                            <fmt:formatNumber pattern="#,###.##" value="${totalPrice.totalPrice}"/>
                        </c:if>
                    </c:forEach>
                </td>
                <td>
                    <button>Edit</button>
                </td>
                <td>
                    <button>Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>

</body>
<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../script/scriptForCustomer.js"></script>
<script>
    $(document).ready(function () {
        $('#contractListTable').dataTable({
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
</html>
