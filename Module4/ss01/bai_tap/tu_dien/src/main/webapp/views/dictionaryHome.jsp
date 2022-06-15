<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="dictionaryHomePage">
    <table>
        <caption>Từ điển Anh-Việt</caption>
        <tr>
            <td>Nhập từ tiếng anh</td>
            <td>
                <input type="text" name="english" value="${english}">
            </td>
            <td>
                <button>check</button>
            </td>
        </tr>
    </table>
</form>


<div> Kết quả: ${vietNam}</div>

</body>
</html>
