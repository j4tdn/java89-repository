var square = document.getElementById("square");
var posX = document.getElementById("postionX");
var posY = document.getElementById("postionY");
var size = document.getElementById("size");
var opacity = document.getElementById("opacity");
var select = document.getElementById("select");
var color = document.getElementById("color");
var r = document.getElementById("r");
var g = document.getElementById("g");
var b = document.getElementById("b");
var a = document.getElementById("a");

posY.onchange = () => {
    square.style.top = posY.value + "px";
}

posX.onchange = () => {
     square.style.left = posX.value + "px";
}
square.style.height = controlSize.value + "px";
square.style.width = controlSize.value + "px";

size.onchange = () => {
    square.style.height = square.height * size.value + "px";
    square.style.width = square.width * size.value + "px";
}

opacity.onchange = () => {
    square.style.opacity = opacity.value;
}

select.onchange = () => {
    if(select.value==="circle") {
        square.style.borderRadius="50%";
    }else if(select.value==="rhombus") {
        square.style.msTransform = "rotate(90deg)";
        square.style.transform = "rotate(90deg)";
    }else {
        square.style.borderRadius="0";
    }
}

color.onchange = () => {
    square.style.backgroundColor = "#" + color.value;
}

r.onchange = () => {
    square.style.backgroundColor = `rgba(${r.value},${g.value},${b.value},${a.value})`;
}

g.onchange = () => {
    square.style.backgroundColor = `rgba(${r.value},${g.value},${b.value},${a.value})`;

b.onchange = () => {
    square.style.backgroundColor = `rgba(${r.value},${g.value},${b.value},${a.value})`;
}

a.onchange = () => {
    square.style.backgroundColor = `rgba(${r.value},${g.value},${b.value},${a.value})`;
}