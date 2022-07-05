<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 5/31/2022
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 style="color: red">Chào mừng, <%=request.getSession().getAttribute("usernameSession")%></h2>
<form method="post">
    <label>Code student</label>
    <input type="text" name="codeStudent"><br>
    <p style="color: red">${errors.get('codeStudent')}</p>
    <label>Name student</label>
    <input type="text" name="nameStudent"><br>
    <p style="color: red">${errors.get('nameStudent')}</p>
    <label>Point</label>
    <input type="text" name="point"><br>
    <label>Gender</label>
    <input type="text" name="gender"><br>
    <button type="submit">Create</button>
</form>
</body>
</html>
