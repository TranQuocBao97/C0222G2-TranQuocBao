firstLine = new Array(3);
firstLine[0]="images/1.png";
firstLine[1]="images/11.png";
firstLine[2]="images/21.png";
secondLine = new Array(3);
secondLine[0]="images/2.png";
secondLine[1]="images/12.png";
secondLine[2]="images/22.png";
thirdLine = new Array(3);
thirdLine[0]="images/3.png";
thirdLine[1]="images/13.png";
thirdLine[2]="images/23.png";
fourthLine = new Array(3);
fourthLine[0]="images/4.png";
fourthLine[1]="images/14.png";
fourthLine[2]="images/24.png";
//click thay đổi hình
function change1() {
    let check = document.getElementById("line1");
    switch (check.getAttribute("src")) {
        case firstLine[0]:
            check.src = firstLine[1];
            break;
        case firstLine[1]:
            check.src = firstLine[2];
            break;
        case firstLine[2]:
            check.src = firstLine[0];
            break;
    }
    checkcolor();
}

function change2() {
    let check = document.getElementById("line2");
    switch (check.getAttribute("src")) {
        case secondLine[0]:
            check.src = secondLine[1];
            break;
        case secondLine[1]:
            check.src = secondLine[2];
            break;
        case secondLine[2]:
            check.src = secondLine[0];
            break;
    }
    checkcolor();
}

function change3() {
    let check = document.getElementById("line3");
    switch (check.getAttribute("src")) {
        case thirdLine[0]:
            check.src = thirdLine[1];
            break;
        case thirdLine[1]:
            check.src = thirdLine[2];
            break;
        case thirdLine[2]:
            check.src = thirdLine[0];
            break;
    }
    checkcolor();
}

function change4() {
    let check = document.getElementById("line4");
    switch (check.getAttribute("src")) {
        case fourthLine[0]:
            check.src = fourthLine[1];
            break;
        case fourthLine[1]:
            check.src = fourthLine[2];
            break;
        case fourthLine[2]:
            check.src = fourthLine[0];
            break;
    }
    checkcolor();
}


//kiểm tra 4 hình cùng xuất hiện
function checkcolor()
{
    let confirm1 = document.getElementById('line1')
    let confirm2 = document.getElementById('line2')
    let confirm3 = document.getElementById('line3')
    let confirm4 = document.getElementById('line4')
    let check1 = confirm1.getAttribute('src')
    let check2 = confirm2.getAttribute('src')
    let check3 = confirm3.getAttribute('src')
    let check4 = confirm4.getAttribute('src')
    if ((check1 === firstLine[0]) &&
        (check2 === secondLine[0]) &&
        (check3 === thirdLine[0]) &&
        (check4 === fourthLine[0]))
    {

        document.getElementById('table').style.border='solid';
        document.getElementById('table').style.borderColor = 'red';
    }
    else if ((check1 === firstLine[1]) &&
            (check2 === secondLine[1]) &&
            (check3 === thirdLine[1]) &&
            (check4 === fourthLine[1]))
    {
        document.getElementById('table').style.border='solid';
        document.getElementById('table').style.borderColor = 'red';
    }
    else if ((check1 === firstLine[2]) &&
            (check2 === secondLine[2]) &&
            (check3 === thirdLine[2]) &&
            (check4 === fourthLine[2]))
    {
        document.getElementById('table').style.border='solid';
        document.getElementById('table').style.borderColor = 'red';
    }
    else
        {
            document.getElementById('table').style.border='none';
        }
}
//đặt random
let random1 = Math.floor(Math.random()*3);
document.getElementById('line1').src=firstLine[random1];
let random2 = Math.floor(Math.random()*3);
document.getElementById('line2').src=secondLine[random2];
let random3 = Math.floor(Math.random()*3);
document.getElementById('line3').src=thirdLine[random3];
let random4 = Math.floor(Math.random()*3);
document.getElementById('line4').src=fourthLine[random4];



