
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../table/Bootstrap-5-5.1.3/css/bootstrap.css">
    <link rel="stylesheet" href="../table/DataTables-1.12.1/css/dataTables.bootstrap5.css">
</head>
<body>

<header></header>

<table id="testTable" class="table table-bordered table-hover text-center table-warning align-items-center">
    <thead>
    <tr>
        <th>Đầu</th>
        <th>Đầu</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>Đít</td>
            <td>Đít</td>
        </tr>
    </tbody>
</table>


</body>
<script src="../table/jQuery-3.6.0/jquery-3.6.0.js"></script>
<script src="../table/DataTables-1.12.1/js/jquery.dataTables.js"></script>
<script src="../table/DataTables-1.12.1/js/dataTables.bootstrap5.js"></script>
<script src="../table/Bootstrap-5-5.1.3/js/bootstrap.bundle.js"></script>
<script>
    $(document).ready(function () {
        $('#testTable').dataTable({
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
