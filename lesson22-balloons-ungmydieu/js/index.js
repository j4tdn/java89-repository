var balloon_list = [
  "balloon-blue.png",
  "balloon-green.png",
  "balloon-red.png",
  "balloon-violet.png",
  "balloon-yellow.png",
];
var popSound = new Audio("./sounds/pop.mp3");
var countBallonPopped = 0;
var preCountIncre = countBallonPopped;
var countOutClick = 0;

var playArea = document.getElementById("play_area");
var result = document.getElementById("result");
var lose_popup = document.getElementById("lose_popup");
var win_popup = document.getElementById("win_popup");

var lose_result = document.getElementById("lose_result");
var loop = setInterval(() => {
  let balloon = createBallon();
  playArea.appendChild(balloon);
}, 1000); 

function playAgain(ans) {
  if (ans === "yes") {
    addBallon();
    clearInterval(loop); 
    window.clearInterval(loop);   
  
    lose_popup.style.display = "none";
    playArea.style.background = 'transparent';
  } else {
    window.close();
  }
}

function checkClick() {  
  if (preCountIncre === countBallonPopped) {
    countOutClick++;
  } else if (preCountIncre < countBallonPopped) {
    preCountIncre = countBallonPopped;
  }

  if (countOutClick >= 5) {
    lose_popup.style.display = "block";
    playArea.style.background = '#00000036';
    clearInterval(loop);
    window.clearInterval(loop);
  }

  if (countBallonPopped >= 10) {
    win_popup.style.display = "block";
    playArea.style.background = '#00000036';
    clearInterval(loop);
    window.clearInterval(loop);
  }
}

function addBallon() {
  countBallonPopped = 0;
  countOutClick = 0;
  preCountIncre = countBallonPopped;

  result.innerHTML = `You popped ${countBallonPopped} balloons`;  
}

 

function createBallon() {
  let balloon = document.createElement("img");
  balloon.src =
    "images/" +
    balloon_list[Math.round(Math.random() * (balloon_list.length - 1))];
  balloon.className = "balloon";
  balloon.style.height = "160px";
  balloon.style.width = "80px";

  balloon.style.position = "absolute";
  balloon.style.bottom = "0px";
  balloon.style.left = `${Math.random() * 95}%`;
  balloon.addEventListener("click", () => {
    balloon.remove();
    popSound.play();
    countBallonPopped++;
    console.log("countBallonPopped" + countBallonPopped);
    result.innerHTML = `You popped ${countBallonPopped} balloons`;
  });
  balloon.style.animation = `up ${Math.random() * 5 + 15}s ease-in infinite`;
  return balloon;
}

addBallon();
