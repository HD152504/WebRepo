
function greeting(nation) {
    console.log("greeting start");
    if (nation == 'k') {
        document.getElementById("result").innerHTML = '안녕하세요';
    }
    else if (nation == 'a') {
        document.getElementById("result").innerHTML = 'Hello!';
    }
    else if (nation == 'c') {
        document.getElementById("result").innerHTML = '你好';
    }
    console.log("greeting end");
}


