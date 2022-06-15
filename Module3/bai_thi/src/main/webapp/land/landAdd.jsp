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

<table class="table table-bordered table-hover text-center table-warning container">
    <form action="land" method="post">
        <input type="hidden" name="action" value="create">
    <tr>
        <th>Mã mặt bằng:</th>
        <td>
            <input type="text" class="form-control" name="idLand">
        </td>
    </tr>
    <tr>
        <th>Diện tích:</th>
        <td>
            <input type="number" class="form-control" name="area">
        </td>
    </tr>
    <tr>
        <th>Trạng thái:</th>
        <td>
            <select name="statusId">
                <c:forEach items="${statusList}" var="status">
                    <option value="${status.statusId}"> ${status.statusName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th>Tầng:</th>
        <td>
            <select name="floorNumber">
                <c:forEach items="${floorList}" var="floor">
                    <option value="${floor.floorId}"> ${floor.floorNumber}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th>Loại văn phòng:</th>
        <td>
            <select name="typeId">
                <c:forEach items="${typeList}" var="type">
                    <option value="${type.typeId}"> ${type.typeName}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th>Mô tả chi tiết:</th>
        <td>
            <input type="text" class="form-control" name="information">
        </td>
    </tr>
    <tr>
        <th>Giá cho thuê</th>
        <td>
            <input type="number" class="form-control" name="price"> VND
        </td>
    </tr>
    <tr>
        <th>Ngày bắt đầu</th>
        <td>
            <input type="date" class="form-control" name="dateStart">
        </td>
    </tr>
    <tr>
        <th>Ngày kết thúc</th>
        <td>
            <input type="date" class="form-control" name="dateEnd">
        </td>
    </tr>
    <tr>
        <th>
                <input type="hidden" name="action" value="create">
                <button type="submit">Lưu</button>
        </th>
        <td>
            <form action="land">
                <button type="submit">Hủy</button>
            </form>
        </td>
    </tr>
    </form>
</table>



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
