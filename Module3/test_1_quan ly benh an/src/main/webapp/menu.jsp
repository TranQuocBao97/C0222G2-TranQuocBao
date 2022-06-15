<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<header id="header" >
    <div id="header-bar-first" class="p-3">
        <div class="d-flex flex-wrap align-items-center justify-content-between">
            <div>
                <a href=""><img src="" alt="logo"></a>
            </div>
            <div class="text-end my-2 my-lg-0">
                <button type="button" class="btn btn-outline-primary">Login</button>
            </div>
        </div>
    </div>
    <div id="header-bar-second" class="p-3 bg-secondary text-white">
        <div class="container" >
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="" class="nav-link px-2 text-white">Home</a></li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            1
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="dropdown-item" href="">1.1</a>
                            </li>
                            <li><a class="dropdown-item" href="?action=add">1.2</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            2
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <a class="dropdown-item" href="">2.1</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="?action=add">2.2</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            3
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="service">3.1</a></li>
                            <li><a class="dropdown-item" href="service?action=add">3.2</a></li>
                        </ul>
                    </li>
                    <li>
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">
                            4
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="contract" >4.1</a></li>
                            <li><a class="dropdown-item" href="contract?action=add" >4.2</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</header>
</body>
</html>
