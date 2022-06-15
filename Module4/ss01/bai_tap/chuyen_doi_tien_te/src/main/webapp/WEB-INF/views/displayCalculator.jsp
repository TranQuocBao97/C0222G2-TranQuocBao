<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/UsdToVnd">
<table style="border: solid 1px">
    <caption>USD TO VND</caption>
    <tr>
        <th>USD </th>
        <td>
            <input type="text" name="usd" value="${usd}">
        </td>
    </tr>
    <tr>
        <th>VND</th>
        <td>
            <div>${vnd} Vnđ</div>
        </td>
    </tr>
    <tr>
        <th></th>
        <td>
            <button>Check</button>
        </td>
    </tr>
</table>
</form>



</body>
</html>
