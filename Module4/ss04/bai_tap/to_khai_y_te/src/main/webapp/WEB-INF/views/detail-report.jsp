
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Name</td>
        <td>${healthReport.name}</td>
    </tr>
    <tr>
        <td>birth</td>
        <td>${healthReport.birth}</td>
    </tr>
    <tr>
        <td>gender</td>
        <td>${healthReport.gender}</td>
    </tr>
    <tr>
        <td>country</td>
        <td>${healthReport.country}</td>
    </tr>
    <tr>
        <td>idCard</td>
        <td>${healthReport.idCard}</td>
    </tr>
    <tr>
        <td>vehicleName</td>
        <td>${healthReport.vehicleName}</td>
    </tr>
    <tr>
        <td>vehicleId</td>
        <td>${healthReport.vehicleId}</td>
    </tr>
    <tr>
        <td>vehicleInformation</td>
        <td>${healthReport.vehicleInformation}</td>
    </tr>
    <tr>
        <td>dateStart</td>
        <td>${healthReport.dateStart}</td>
    </tr>
    <tr>
        <td>dateEnd</td>
        <td>${healthReport.dateEnd}</td>
    </tr>
    <tr>
        <td>citiesLast14days</td>
        <td>${healthReport.citiesLast14days}</td>
    </tr>
<div>
    <a href="/report/list-from">back to list form</a>
</div>
</table>
</body>
</html>
