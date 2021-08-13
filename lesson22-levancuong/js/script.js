var balloonImages = [
  "balloon-blue.png",
  "balloon-green.png",
  "balloon-red.png",
  "balloon-violet.png",
  "balloon-yellow.png",
];
var container = document.getElementById("container");
var title = document.getElementById("title");
var notify_win = document.getElementById("notify_win");
var count = 0;
var x = document.getElementById("myAudio");
console.dir(x);
x.loop = true;
x.autoplay = true;
function addBalloons() {
  setInterval(() => {
    container.appendChild(createBalloon());
    if (count === 100) {
      notify_win.style.display = "flex";
    }
  }, 1000);
}
function createBalloon() {
  let balloon = document.createElement("img");
  balloon.className = "item";
  balloon.src = "images/" + balloonImages[Math.round(Math.random() * 4)];
  balloon.style.left = Math.random() * 1280 + "px";
  balloon.addEventListener("click", () => {
    new Audio("../sounds/pop.mp3").play();
    balloon.remove();
    title.textContent = `You have ${++count} score`;
  });
  return balloon;
}

addBalloons();
