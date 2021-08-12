var nameFileImgBalloons = ["balloon-blue.png","balloon-green.png","balloon-red.png","balloon-violet.png","balloon-yellow.png"];
var explodingSound = new Audio("../sounds/pop.mp3");

var playArea = document.getElementById("play-area");
var countPopedBalloons = 0;
var result = document.getElementById("result");
var popupLose = document.getElementById("popup-lose");
var popupWin = document.getElementById("popup-win");
function addBalloons (){
    countPopedBalloons = 0;
    result.innerHTML = `You poped ${countPopedBalloons} balloons`;
    let startTime = new Date();
    const loop = setInterval(()=>{
        playArea.appendChild(createBalloon());
        let duration =(new Date().getTime() - startTime.getTime()) / 60000;
        if (duration > 5){
            clearInterval(loop);
            playArea.innerHTML = "";
            if (countPopedBalloons < 100){
                document.getElementById("noticeLose").innerHTML = `You poped ${countPopedBalloons} balloons`
                popupLose.style.display = "block";
            } else {
                document.getElementById("noticeWin").innerHTML = `You poped ${countPopedBalloons} balloons`
                popupWin.style.display = "block";
            }
        }
    }, 1000);
}

function createBalloon (){
    let balloon = document.createElement("img");
    balloon.className = "balloon";
    balloon.src = "images/" + nameFileImgBalloons[Math.round(Math.random() * 4)];
    balloon.style.height = "160px";
    balloon.style.position = "absolute";
    balloon.style.left = `${Math.random() * 95}%`;
    balloon.style.bottom = "0px";
    balloon.addEventListener('click', ()=>{
        balloon.remove();
        explodingSound.play();
        countPopedBalloons++;
        result.innerHTML = `You poped ${countPopedBalloons} balloons`;
    });
    balloon.style.animation = `up ${Math.random() *2 + 5}s ease-in infinite`;
    return balloon;
}

addBalloons();