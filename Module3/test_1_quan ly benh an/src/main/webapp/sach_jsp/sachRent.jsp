<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <style>
        th {
            width: 50%;
        }
    </style>
</head>
<body>
<header></header>
<div class="text-center">
    <h1> Mượn sách </h1>
</div>

<div class="col-6 container mt-3">
    <form action="theMuonSach" method="post">
        <input type="hidden" name="action" value="addTheMuonSach">
        <input type="hidden" name="name" value="${name}">
        <table class="table table-bordered table-hover
table-striped align-items-center">
            <tr>
                <th>Mã mượn sách(MS-XXXX):</th>
                <td>
                    <input type="text" class="form-control" name="maMuonSach" value="${maMuonSach}">
                    <small style="color: crimson">${mapMess.idTheMuonSach}</small>
                </td>
            </tr>
            <tr>
                <th>Tên sách:</th>
                <td>
                    <input type="hidden" name="idSach" value="${idSach}">
                    <div style="margin-left: 10px">${name}
                    </div>
                    <small style="color: crimson">${mapMess.idSach}</small>
                </td>
            </tr>
            <tr>
                <th>Tên học sinh:</th>
                <td>

                    <select class="form-select" name="hocSinhId">
                        <c:forEach items="${hocSinhList}" var="hocSinh">
                            <option value="${hocSinh.id}">${hocSinh.name}</option>
                        </c:forEach>
                    </select>
                    <small style="color: crimson">${mapMess.idHocSinh}</small>
                </td>
            </tr>
            <tr>
                <th>Ngày mượn sách:</th>
                <td><input type="date" class="form-control" name="ngayMuonSach" value="${dateNow}"></td>

            </tr>
            <tr>
                <th>Ngày trả sách</th>
                <td><input type="date" class="form-control" name="ngayTraSach" value="${ngayTra}">
                    <small style="color: crimson">${mapMess.ngayTraSach}</small>
                </td>

            </tr>

            <tr class="text-center">
                <th>
                    <button type="submit" class="btn btn-secondary">Mượn sách</button>
                </th>
                <td><a href="sach" style="text-decoration: none">
                    Hủy
                </a>
                </td>
        </table>

        </tr>
    </form>
</div>

</body>
<script src="../jquery/jquery-3.6.0.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../includeHTML/jquery.includeHTML.js"></script>
<script>
    $(document).ready(function () {
        $('header').loadHTML('menu.html');
    })
</script>
</html>
</html>
