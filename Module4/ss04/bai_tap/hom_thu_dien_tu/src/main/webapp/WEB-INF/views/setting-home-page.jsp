<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Setting</h2>
<form:form method="POST" action="saveSetting" modelAttribute="EmailSetting">
<table>
    <tr>
        <th>Language :</th>
        <td>
            <form:select path="language">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
        </td>
    </tr>
    <tr>
        <th>Page size:</th>
        <td>
            Show :
            <form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select>
            email per page
        </td>
    </tr>
    <tr>
        <th>Spam filter:</th>
        <td>
            <form:checkbox path="spamFilter" value="enable"/> Enable spams filter
        </td>
    </tr>
    <tr>
        <th>Signature: </th>
        <td>
            <form:textarea path="signature" rows="5" cols="30"/>
        </td>
    </tr>
    <tr>
        <th>
            <button type="submit">Update</button>
        </th>
        <td>
            <button disabled>
                Cancel</button>
        </td>
    </tr>
</table>
</form:form>
</body>
</html>
