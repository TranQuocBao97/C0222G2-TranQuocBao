<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Show Setting</h3>
<table>
    <tr>
        <th>Language</th>
        <td>${emailSetting.language}</td>
    </tr>
    <tr>
        <th>PageSize</th>
        <td>${emailSetting.pageSize}</td>
    </tr>
    <tr>
        <th>SpamFilter</th>
        <td>${emailSetting.spamFilter}</td>
    </tr>
    <tr>
        <th>Signature</th>
        <td>${emailSetting.signature}</td>
    </tr>

</table>
</body>
</html>
