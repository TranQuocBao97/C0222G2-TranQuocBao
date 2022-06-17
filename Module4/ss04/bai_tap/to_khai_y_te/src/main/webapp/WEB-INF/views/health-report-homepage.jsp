<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style>
        div {
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="text-center">TỜ KHAI Y TẾ</h1>


    <form:form action="add-form" modelAttribute="healthReport" method="post">
        <div>
            <p>Họ và tên (ghi chữ IN HOA)<span style="color: red">(*)</span>:</p>
            <form:input path="name" class="form-control" required="required"/>
        </div>
        <div>
            <table style="width: 100%; padding: 20px">
                <tr>
                    <td>Năm sinh<span style="color: red">(*)</span></td>
                    <td>Giới tính<span style="color: red">(*)</span></td>
                    <td>Quốc tịch<span style="color: red">(*)</span></td>
                </tr>
                <tr>
                    <td>
                        <form:input type="date" path="birth" class="form-control" required="required"/>
                    </td>
                    <td>
                        <form:select path="gender" class="form-control" required="required">
                            <form:option value="Nam">Nam</form:option>
                            <form:option value="Nữ">Nữ</form:option>
                            <form:option value="Khác">Khác</form:option>
                        </form:select>
                    </td>
                    <td>
                        <form:select path="country" class="form-control" required="required">
                            <form:option value="Việt Nam">Việt Nam</form:option>
                            <form:option value="Mỹ">Mỹ</form:option>
                            <form:option value="Trung Quốc">Trung Quốc</form:option>
                        </form:select>
                    </td>
                </tr>

            </table>
        </div>
        <div>
            <div>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span style="color: red">(*)</span></div>
            <div>
                <form:input path="idCard" class="form-control" required="required"/>
            </div>
        </div>

        <div>
            <div>Thông tin đi lại<span style="color: red">(*)</span></div>
            <div>
                <form:radiobutton path="vehicleName" value="Tàu bay" required="required"/>Tàu bay
                <form:radiobutton path="vehicleName" value="Tàu thuyền" required="required"/>Tàu thuyền
                <form:radiobutton path="vehicleName" value="Ô tô" required="required"/>Ô tô
                <form:radiobutton path="vehicleName" required="required" onclick="getVehicleFunction()" id="enterVehicle"/>Khác(ghi rõ)<input id="vehicleName"/>
            </div>
        </div>

        <div>
            <div>
                <div>Số hiệu phương tiện:</div>
                <div>
                    <form:input path="vehicleId" class="form-control" />
                </div>
            </div>
            <div>
                <div>Số ghế:</div>
                <div>
                    <form:input path="vehicleInformation" class="form-control" />
                </div>
            </div>
        </div>
        <div>
            <table style="width: 100%">
                <tr>
                    <td>Ngày khởi hành<span style="color: red">(*)</span></td>
                    <td>Ngày kết thúc<span style="color: red">(*)</span></td>
                </tr>
                <tr>
                    <td><form:input type="date" path="dateStart" class="form-control" required="required"/></td>
                    <td><form:input type="date" path="dateEnd" class="form-control" required="required"/></td>

                </tr>
            </table>
        </div>
        <div>
            <div>Trong 14 ngày qua anh/chị có đi đến tỉnh/thành phố nào?<span style="color: red">(*)</span></div>
            <div>
                <form:input path="citiesLast14days" class="form-control" required="required"/>
            </div>
        </div>
        <div class="text-center">
        <button type="submit" class="btn btn-primary">Gửi tờ khai</button>
        </div>
    </form:form>

</div>


</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script>
    function getVehicleFunction() {
        let x = document.getElementById("vehicleName").value;
        document.getElementById("enterVehicle").innerHTML = x;
    }
</script>
</html>
