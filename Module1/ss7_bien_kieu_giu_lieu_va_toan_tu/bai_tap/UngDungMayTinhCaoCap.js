function clearScreen() {
    document.getElementById("outPut").innerHTML="0";
}
function percent() {
    let percentVar = document.getElementById("outPut").innerHTML;
    percentVar=eval(percentVar);
    percentVar=percentVar/100;
    document.getElementById("outPut").innerHTML=percentVar;
}
function removeZero() {
    let zeroVar=document.getElementById("outPut").innerHTML;
    if (zeroVar==0){
        zeroVar="";
        document.getElementById("outPut").innerHTML=zeroVar;
    }

}
function screenShow(screenValue) {
    removeZero();
    let zero = document.getElementById("outPut").value;
    document.getElementById("outPut").innerHTML += screenValue;

 }

function result() {
    let resultValue = document.getElementById("outPut").innerHTML;
    let resultFinal = eval(resultValue);
    document.getElementById("outPut").innerHTML=resultFinal;
}
