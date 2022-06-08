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
<header>
    <div id="header-bar-first" class="p-3">
        <div class="d-flex flex-wrap align-items-center justify-content-between">
            <div>
                <a href="furama"><img src="img/logo.png" alt="logo"></a>
            </div>
            <div class="text-end my-2 my-lg-0">
                <button type="button" class="btn btn-outline-primary">Login</button>
            </div>
        </div>
    </div>
    <div id="header-bar-second" class="p-3 bg-secondary text-white">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="furama" class="nav-link px-2 text-white">Home</a></li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Employee
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <button class="dropdown-item" onclick="listEmployee()" type="submit">List employee
                                </button>
                            </li>
                            <li><a class="dropdown-item" href="">Add new employee</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Customer
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="dropdown-item" href="customer">List customer</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="customer?action=add">Add new customer</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Service
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="">List service</a></li>
                            <li><a class="dropdown-item" href="service?action=add">Add new service</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            Contract
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="">List contract</a></li>
                            <li><a class="dropdown-item" href="">Add new contract</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>




<main class="container-fluid mt-2">
    <div style="background: #e5e5e5;height: 730px;width: 100%">
    </div>
</main>

<footer>

</footer>


</body>
<script src="jquery/jquery-3.6.0.min.js"></script>
<script src="datatables/js/jquery.dataTables.js"></script>
<script src="datatables/js/dataTables.bootstrap5.js"></script>
<script src="bootstrap_5_file/js/bootstrap.bundle.js"></script>
<script src="script/scriptForCustomer.js"></script>
</html>
