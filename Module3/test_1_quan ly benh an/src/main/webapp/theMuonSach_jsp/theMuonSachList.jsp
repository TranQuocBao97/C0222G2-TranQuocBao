<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
</head>
<body>
<header></header>

<div>
<search>
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
        <div class="col-3">
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
</search>


<table id="theMuonSachListTable" class="table table-bordered table-hover text-center table-warning align-items-center">
    <thead>
    <tr>
        <th>Mã mượn sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Tên học sinh</th>
        <th>Lớp</th>
        <th>Ngày mượn</th>
        <th>Ngày trả</th>
        <th style="text-align: center">
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${theMuonSachList}" var="theMuonSach">
        <tr>
            <td>${theMuonSach.id}</td>
            <c:forEach items="${sachList}" var="sach">
                <c:if test="${theMuonSach.sachId == sach.id}">
                    <td>${sach.name}</td>
                    <td>${sach.writer}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${hocSinhList}" var="hocSinh">
                <c:if test="${theMuonSach.hocSinhId == hocSinh.id}">
                    <td>${hocSinh.name}</td>
                    <td>${hocSinh.lop}</td>
                </c:if>
            </c:forEach>
            <td>${theMuonSach.dateStart}</td>
            <td>${theMuonSach.dateEnd}</td>
            <td style="text-align: center">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    Trả sách
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Xác nhận trả sách</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn trả sách ${sach.name}
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <form action="theMuonSach" method="post">
                                    <input type="hidden" name="action" value="traSach">
                                    <input type="hidden" name="sachId" value="${sach.id}">
                                    <button type="button" class="btn btn-secondary" type="submit">Yes</button>
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

</body>
<script src="../jquery/jquery-3.6.0.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script>
    $(document).ready(function () {
        $('#theMuonSachListTable').dataTable({
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
