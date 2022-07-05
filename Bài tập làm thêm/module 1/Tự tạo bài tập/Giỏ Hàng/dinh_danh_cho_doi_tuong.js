creatRandomId()

function creatRandomId() {
    let getIdByTime = '' + Math.random().toString().substr(2, 15) + '_' + String(new Date().getTime());
    console.log(getIdByTime)
}