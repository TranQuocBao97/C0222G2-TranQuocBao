<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h1>Delete Page</h1>
<a class="btn btn-primary" role="button" href="/product">Back to list product</a>

<table class="table table-hover">
    <tr>
        <td>Name</td>
        <td>${product.getName()}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${product.getPrice()}</td>
    </tr>
    <tr>
        <td>Information</td>
        <td>${product.getInformation()}</td>
    </tr>
    <tr>
        <td>Company</td>
        <td>${product.getCompany()}</td>
    </tr>
    <tr>
        <td></td>
        <%--            <td><input type="submit" value="Delete"></td>--%>
        <td>
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#myModal">Delete
            </button>
        </td>
    </tr>
</table>

<p>${mess}</p>
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Are You Sure To Delete This</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <!-- Modal body -->
            <form method="post">
                <div class="modal-body">
                    <table class="table table-hover">
                        <tr>
                            <td>Name</td>
                            <td>${product.getName()}</td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td>${product.getPrice()}</td>
                        </tr>
                        <tr>
                            <td>Information</td>
                            <td>${product.getInformation()}</td>
                        </tr>
                        <tr>
                            <td>Company</td>
                            <td>${product.getCompany()}</td>
                        </tr>
                    </table>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger" data-bs-dismiss="modal">Yes</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
