var shape = document.querySelector('#shape');

function changePosY(event) {
  shape.style.top = event.target.value + 'px';
}

function changePosX(event) {
  shape.style.left = event.target.value + 'px';
}

function changeSize(event) {
  shape.style.transform = `scale(${event.target.value})`;
}

function changeOpacity(event) {
  shape.style.opacity = event.target.value;
}

function changeShape() {
  let shapeType = document.getElementById('shape-type').value;
  if (shapeType == "circle") {
    shape.style.borderRadius = '50%';
    shape.style.transform = "rotate(0deg)";
  } else if (shapeType == "square") {
    shape.style.borderRadius = '0';  
    shape.style.transform = "rotate(0deg)";
  } else if (shapeType === "rhombus") {
    shape.style.borderRadius = '0';
    shape.style.transform = "rotate(45deg)";
  }
}

function changeHexColor(event) {
  event.preventDefault();
  let hexColor = document.getElementById('hex-color').value;
  shape.style.backgroundColor = `#${hexColor}`;
}

var redColor = document.getElementById('red');
var greenColor = document.getElementById('green');
var blueColor = document.getElementById('blue');
var alpha = document.getElementById('alpha');

function changeRed(event) {
  shape.style.backgroundColor = `rgba(${event.target.value}, ${greenColor.value}, ${blueColor.value}, ${alpha.value})`;
}

function changeGreen(event) {
  shape.style.backgroundColor = `rgba(${redColor.value}, ${event.target.value}, ${blueColor.value}, ${alpha.value})`;
}

function changeBlue(event) {
  shape.style.backgroundColor = `rgba(${redColor.value}, ${greenColor.value}, ${event.target.value}, ${alpha.value})`;
}

function changeAlpha(event) {
  shape.style.backgroundColor = `rgba(${redColor.value}, ${greenColor.value}, ${blueColor.value}, ${event.target.value})`;
}
