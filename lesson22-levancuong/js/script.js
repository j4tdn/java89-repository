var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
var pos_x= document.getElementById("pos_x");
var position_x = document.getElementById("positionX");
var size = document.getElementById("size");
var sizeVal= document.getElementById("sizeVal");
var opacity = document.getElementById("opacity");
var opacityVal= document.getElementById("opacityVal");
var select = document.getElementById("select");
var selectVal= document.getElementById("selectVal");
var color = document.getElementById("color");
var colorVal= document.getElementById("colorVal")
var r = document.getElementById("r");
var g = document.getElementById("g");
var b = document.getElementById("b");
var a = document.getElementById("a");

output.innerHTML = slider.value;
pos_x.innerHTML = position_x.value;
sizeVal.innerHTML=size.value;
opacityVal.innerHTML=opacity.value;
selectVal.innerHTML=select.value;
colorVal.innerHTML=color.value;

var square= document.getElementById("sq");
slider.oninput = function()
{
  output.innerHTML = this.value;
  square.style.top=slider.value+"px";
}

position_x.oninput= () => {
  pos_x.innerHTML = position_x.value;
  square.style.left=position_x.value+"px";
}

size.oninput= () => {
  sizeVal.innerHTML=size.value;
  square.style.transform=`scale(${size.value})`
}

opacity.oninput= () => {
  opacityVal.innerHTML=opacity.value;
  square.style.opacity=opacity.value;
}

select.onchange= () => {
  selectVal.innerHTML=select.value;
  if(select.value==="circle") {
    square.style.borderRadius="50%";
  }else {
    if(select.value==="rhombus") {
      square.style.msTransform = "rotate(90deg)";
      square.style.transform = "rotate(90deg)";
    }else {
      square.style.borderRadius="0";
    }
  }
}

color.oninput= () => {
  colorVal.innerHTML=color.value;
  square.style.background='#'+color.value;
}

r.oninput= () => {
  square.style.background=`rgba(${r.value},${g.value},${b.value},${a.value})`;
}
g.oninput= () => {
  square.style.background=`rgba(${r.value},${g.value},${b.value},${a.value})`;
}
b.oninput= () => {
  square.style.background=`rgba(${r.value},${g.value},${b.value},${a.value})`;
}
a.oninput= () => {
  square.style.background=`rgba(${r.value},${g.value},${b.value},${a.value})`;
}