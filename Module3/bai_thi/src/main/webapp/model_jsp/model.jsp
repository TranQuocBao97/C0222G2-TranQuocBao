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


<div>
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
        <th>1</th>
        <th>2</th>
        <th>3</th>
        <th>4</th>
        <th style="text-align: center"></th>
        <th style="text-align: center"></th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>a</td>
        <td>b</td>
        <td>c</td>
        <td>d</td>
        <td style="text-align: center"></td>
        <td style="text-align: center"></td>
    </tr>
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
