
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="../css/cssForFurama.css">
    <style>
        #editTable .modal-dialog {
            width: 100%;
            max-width: none;
            height: auto;
            margin: 0;
        }
    </style>
</head>
<body>
<div>
    <header></header>
</div>

<div align="center" class="mt-1">
    <div class="row container-fluid align-items-center p-3 text-white"
         style="background: #c4a664; border-radius: 20px">
        <div class="col-8">
            <h2>List of Service</h2>
        </div>
        <div class="col-4">
            <form class="row container-fluid align-items-end" action="" method="post">
                <input type="hidden" name="action" value="search">
                <div class="col-9">
                    <input type="text" class="form-control form-control-dark" placeholder="Search..."
                           aria-label="Search" name="search">
                </div>
                <div class="col-3">
                    <button class="btn btn-outline-light text-black" type="submit" style="background: white">
                        Search
                    </button>
                </div>
            </form>
        </div>
    </div>




</div>
</body>
<script src="../jquery/jquery-3.6.0.min.js"></script>
<script src="../datatables/js/jquery.dataTables.js"></script>
<script src="../datatables/js/dataTables.bootstrap5.js"></script>
<script src="../bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="../script/scriptForCustomer.js"></script>
<script>
    $(document).ready(function () {
        $('#employeeListTable').dataTable({
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
<script>
    $(function () {
        $('#trueModal').modal('show');
    });
    $(function () {
        $('#falseModal').modal('show');
    });
</script>
</html>
