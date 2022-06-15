<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../boostrap/Bootstrap-5-5.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="../boostrap/DataTables-1.12.1/css/dataTables.bootstrap5.css">
</head>
<body>

<header></header>


<div style="margin-top: 30px ">
    <form action="land">
        <input type="hidden" name="action" value="create">
    <button type="submit" class="btn btn-secondary">
        <h1>Create</h1>
    </button>
    </form>
</div>

<div id="searchArea">
    <form
            class="row container-fluid align-items-end"
            action=""
            method="post"
    >
        <input type="hidden" name="" value="">
        <div class="col-2">
            <div>
                Search 1:
            </div>
            <input type="text" class="form-control form-control-dark" placeholder="Search..."
                   aria-label="Search" name="" value="">
        </div>
        <div class="col-2">
            <div>
                Search 2:
            </div>
            <input type="text" class="form-control form-control-dark" placeholder="Search..."
                   aria-label="Search" name="" value="">
        </div>
        <div class="col-1">
            <button class="btn btn-outline-primary text-black" type="submit">
                Search
            </button>
        </div>
    </form>
</div>
</div>




<main>
    <table id="modelListTable" class="table table-striped table-bordered table-hover text-center table-secondary align-items-center">
        <thead>
        <tr>
            <th>Mã MB</th>
            <th>Diện tích</th>
            <th>Trạng Thái</th>
            <th>Tầng</th>
            <th>Loại Văn Phòng</th>
            <th>Giá cho thuê</th>
            <th>Ngày bắt đầu</th>
            <th>Ngày kết thúc</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${landList}" var="land">
        <tr>
            <td>${land.id}</td>
            <td>${land.area}</td>
            <td>
                <c:forEach items="${statusList}" var="status">
                    <c:if test="${land.statusId == status.statusId }">
                        ${status.statusName}
                    </c:if>
                </c:forEach>
            </td>
            <td>${land.floorNumber}</td>
            <td>
                <c:forEach items="${typeList}" var="type">
                    <c:if test="${land.typeId == type.typeId }">
                        ${type.typeName}
                    </c:if>
                </c:forEach>
            </td>
            <td>${land.price}</td>
            <td>${land.dateStart}</td>
            <td>${land.dateEnd}</td>
            <td style="text-align: center">
                <button>Xóa</button>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>



</body>
<script src="../boostrap/jQuery-3.6.0/jquery-3.6.0.js"></script>
<script src="../boostrap/DataTables-1.12.1/js/jquery.dataTables.js"></script>
<script src="../boostrap/DataTables-1.12.1/js/dataTables.bootstrap5.js"></script>
<script src="../boostrap/Bootstrap-5-5.1.3/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#modelListTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script src="../boostrap/includeHTML/jquery.includeHTML.js"></script>
<script>
    $(document).ready(function () {
        $('header').loadHTML('menu.html');
    })
</script>
</html>
