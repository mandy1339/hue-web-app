// document.body.style.color = "purple";


// ON-OFF SECTION
document.getElementById('on').addEventListener('click', goToTurnOn)
document.getElementById('off').addEventListener('click', goToTurnOff)

function goToTurnOn() {
    window.location.href = 'turn-on'
}

function goToTurnOff() {
    window.location.href = 'turn-off'
}





// COLOR
document.getElementById('red').addEventListener('click', goToSetRed)
document.getElementById('yellow').addEventListener('click', goToSetYellow)
document.getElementById('green').addEventListener('click', goToSetGreen)
document.getElementById('blue').addEventListener('click', goToSetBlue)
document.getElementById('pink').addEventListener('click', goToSetPink)
document.getElementById('white').addEventListener('click', goToSetWhite)

function goToSetRed() {
    window.location.href = 'set-red'
}

function goToSetYellow() {
    window.location.href = 'set-yellow'
}
function goToSetGreen() {
    window.location.href = 'set-green'
}

function goToSetBlue() {
    window.location.href = 'set-blue'
}
function goToSetPink() {
    window.location.href = 'set-pink'
}

function goToSetWhite() {
    window.location.href = 'set-white'
}





// RAINBOW
document.getElementById('30').addEventListener('click', goTo30)
document.getElementById('60').addEventListener('click', goTo60)
document.getElementById('kill').addEventListener('click', goToKill)

function goTo30() {
    window.location.href = 'cycle-30-sec'
}

function goTo60() {
    window.location.href = 'cycle-1-min'
}
function goToKill() {
    window.location.href = 'kill-cycle'
}






// BRIGHTNESS
document.getElementById('0').addEventListener('click', goTo0)
document.getElementById('25').addEventListener('click', goTo25)
document.getElementById('50').addEventListener('click', goTo50)
document.getElementById('75').addEventListener('click', goTo75)
// document.getElementById('100').addEventListener('click', goTo100)
$('#100').on('click', goTo100); //WITH JQUERY


function goTo0() {
    window.location.href = 'set-bri-0'
}

function goTo25() {
    window.location.href = 'set-bri-25'
}
function goTo50() {
    window.location.href = 'set-bri-50'
}

function goTo75() {
    window.location.href = 'set-bri-75'
}
function goTo100() {
    window.location.href = 'set-bri-100'
}

