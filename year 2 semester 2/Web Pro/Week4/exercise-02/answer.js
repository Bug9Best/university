// ข้อ 2.1

function display(msg) {
    let div = document.getElementById('ex01-div')
    div.innerHTML = msg
}

function showConfirm(callback) {
    (confirm('Show Dialog.')) ? callback("ยืนยันจ้า", display) : callback("ไม่ดีกว่า", display);
}

// ข้อ 2.2
function start() {
    // hint: ส่ง callback function เข้าไปเป็น argument ของ setTimeout()
    let start = document.getElementById('start');
    let process = document.getElementById('process')
    let end = document.getElementById('end');

    start.innerHTML = 'Program started'
    setTimeout(() => {
        process.innerHTML = 'Hello World'
    }, 2000);

    setTimeout(() => {
        end.innerHTML = 'Program ended'
    }, 5000);
}

// ข้อ 2.3
function stopTime() {
    var minutes = document.getElementById('setMinute');
    var seconds = document.getElementById('setSecond');
    var times = document.getElementById('Time').value
    let flag = true

    if (flag) {
        let result = setInterval(() => {
            let min = Math.floor(times / 60);
            let sec = times % 60;

            (sec < 10) ? sec = '0' + sec : sec;
            (min < 10) ? min = '0' + min : min;

            minutes.innerHTML = min;
            seconds.innerHTML = sec;

            if (times > 0) {
                times--;
            } else {
                clearInterval(result);
            }
        }, 100);
        flag = false
    }
}