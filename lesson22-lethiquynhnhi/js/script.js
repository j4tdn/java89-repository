let nameImgs = ["blue", "green", "red", "violet", "yellow"];
let pathPopSound = "../sounds/pop.mp3";
let pathBackgroundSound = "../sounds/bg-music.mp3";
let time = 0;
var balloonCounter = 0;
let startTime = Date.now();
let ballonsContainer = document.querySelector(".ballons-container");
let balloonResult = document.querySelector(".ballons-result");
let overlay = document.querySelector(".overlay");
let btnYes = document.querySelector(".btn-yes");
let btnNo = document.querySelector(".btn-no");
let alertBallon = document.querySelector(".alert-ballon");
let alertFinish = document.querySelector(".alert-finish");
let soundPop = new Audio(pathPopSound);
function createBallons() {
   for(let i = 0; i < 102; i++){
       let balloon = createStypeForBalloon();
       ballonsContainer.appendChild(balloon);
       balloon.addEventListener('click', ()=>{
           balloonCounter++;
           soundPop.play();
           balloonResult.textContent = `You popped ${balloonCounter} ballons`;
           balloon.style.visibility = 'hidden';
       });
       let currentDate = Date.now();
       if(currentDate - startTime >= 100 && balloonCounter !== 100){
            overlay.style.display = 'block';
            alertBallon.style.visibility = 'visible';
            alertFinish.style.visibility = 'hidden';
            btnYesFunc();
            btnNoFunc();
            balloonCounter = 0;
       }
       if(currentDate - startTime <= 5 && balloonCounter === 100){
        overlay.style.display = 'block';
        alertBallon.style.visibility = 'hidden';
        alertFinish.style.visibility = 'visible';
       }
   }

}

function createStypeForBalloon(){
    let balloon = document.createElement("img");
    balloon.className = "balloon";
    balloon.src = "images/balloon-" + nameImgs[Math.floor(Math.random() * 4)] + ".png";
    let randomTime = Math.floor(Math.random() * 50) + 5;
    let margin = Math.floor(Math.random() * 200);
    balloon.style.animation = `float ${randomTime}s ease-in infinite`;
    balloon.style.margin = `${margin}px 0 0 ${margin}px`;
    return balloon;
}

function btnYesFunc(){
    btnYes.addEventListener('click', ()=>{
        console.log("bbbbbbbbb");
        overlay.style.display = 'none';
        createBallons();
    })
}

function btnNoFunc(){
    btnNo.addEventListener('click', ()=>{
        overlay.style.display = 'block';
        alertBallon.style.visibility = 'hidden';
        alertFinish.style.visibility = 'hidden';
    })
}
createBallons();

