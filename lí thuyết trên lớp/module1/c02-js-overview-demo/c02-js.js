
function xacNhan() {
    let check = confirm("Bạn có chắc không?");
    document.write(check);
}


function hi() {
    let ten = document.getElementById("name").value ;

    document.getElementById("result1").innerText = "<h1> Xin chào " + ten + "</h1>";
    document.getElementById("result2").innerHTML = "<h1> Xin chào " + ten + "</h1>";

    // document.write("Xin chào " + ten);
    // console.log(ten);
}

// Break point
function hello() {
    let math = prompt("Nhập điểm toán: ");
    let physical = prompt("Nhập điểm lý: ");
    let chemistry = prompt("Nhập điểm hóa: ");
    document.write("<h1>" + math + "</h1>");
    document.write("<br>");
    document.write(physical);
    document.write("<br>");
    document.write(chemistry);
}
