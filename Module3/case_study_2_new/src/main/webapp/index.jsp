<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Furama control web</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap_5_file/css/bootstrap.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.css">
    <link rel="stylesheet" href="css/cssForFurama.css">
</head>
<body>


<header></header>

<main>

</main>
<footer>

</footer>


</body>
<script src="jquery/jquery-3.6.0.min.js"></script>
<script src="datatables/js/jquery.dataTables.js"></script>
<script src="datatables/js/dataTables.bootstrap5.js"></script>
<script src="bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="script/scriptForCustomer.js"></script>
<script src="includeHTML/jquery.includeHTML.js"></script>
<script>
    $(document).ready(function (){
        $('header').loadHTML('menu.html');
    })
</script>
</html>
