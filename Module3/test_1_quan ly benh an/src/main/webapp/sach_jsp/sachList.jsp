<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
</head>
<body>

<jsp:include page="../menu.jsp"/>
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
        <div class="col-3">
            <div>
                Search 3:
            </div>
            <select class="form-select" name="">
                <option selected value="">None</option>
            </select>
        </div>
        <div class="col-3">
            <div>
                Search 4:
            </div>
            <select class="form-select" name="">
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
</search>


<table id="sachTable" class="table table-bordered table-hover
table-striped align-items-center">
    <thead>
    <tr>
        <th>Mã sách</th>
        <th>Tên sách</th>
        <th>Tác giả</th>
        <th>Mô Tả</th>
        <th style="text-align: center">Số Lượng</th>
        <th style="text-align: center"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sachList}" var="sach">
        <tr>
            <td>${sach.id}</td>
            <td>${sach.name}</td>
            <td>${sach.writer}</td>
            <td>${sach.information}</td>
            <td style="text-align: center">${sach.number}</td>
            <td style="text-align: center">
                <form action="theMuonSach">
                    <input type="hidden" name="action" value="addTheMuonSach">
                    <input type="hidden" name="id" value="${sach.id}">
                    <input type="hidden" name="name" value="${sach.name}">
                    <button type="submit" class="btn btn-outline-secondary">
                        Mượn
                    </button>
                </form>
            </td>
        </tr>


        <!-- Modal -->
        <c:if test="${sach.number < 1 && mess == 'het'}">
            <!-- Modal -->
            <div class="modal fade" id="soLuongModal" style="top: 20%">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-center">Lỗi</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                           Sách "${sach.name}" đã hết!
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>


    </c:forEach>
    </tbody>
</table>


</body>
<script src="../jquery/jquery-3.6.0.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script>
    $(document).ready(function () {
        $('#sachTable').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
<script src="../includeHTML/jquery.includeHTML.js"></script>

<script>
    $(function () {
        $('#soLuongModal').modal('show');
    });
</script>
</html>
