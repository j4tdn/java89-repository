let square = document.querySelector(".square");
let slideRangeY = document.getElementById("slide-range-y");
let slideRangeX= document.getElementById("slide-range-x");
let slideRangeS= document.getElementById("slide-range-s");
let slideRangeO= document.getElementById("slide-range-o");
let selectionShape = document.querySelector(".selection-shape");
let btn = document.querySelector(".ok");
let backgroundShape = document.getElementById("background-shape");
let hash = document.querySelector(".hash");
let slideRangeR = document.getElementById("slide-range-r");
let slideRangeG = document.getElementById("slide-range-g");
let slideRangeB = document.getElementById("slide-range-b");
let slideRangeA = document.getElementById("slide-range-a");

const SQUARE = "Square";
const CYCLE = "Cycle";
const RHOMBUS = "RhomBus";

slideRangeY.addEventListener("input", function(event){
let value = event.target.value;
square.style.top = `${value/2}px`;
});

slideRangeX.addEventListener("input", function(event){
    let value = event.target.value;
    square.style.left = `${value/2}px`;
});

slideRangeS.addEventListener("input", function(event){
    let value = event.target.value;
    square.style.transform = `scale(${value})`;
});

slideRangeO.addEventListener("input", function(event){
    let value = event.target.value;
    square.style.opacity = `${value}`;
});

selectionShape.addEventListener('input', (event) => {
    let shape = event.target.value;
    btn.addEventListener("click",()=>{
        switch(shape){
            case SQUARE:
                square.className = `${SQUARE.toLowerCase()}`;
                break;
    
            case CYCLE:
                square.className = `${CYCLE.toLowerCase()}`;
                break;

            case RHOMBUS:
                square.className = `${RHOMBUS.toLowerCase()}`;
                break;
        }
    })
});

let hashValue = hash.textContent;
backgroundShape.addEventListener('keypress',(event)=>{
    let value = backgroundShape.value;
    if(event.which === 13){
        square.style.background = `${hashValue}${value}`;
    }
})
let stringBackgroundColor = getComputedStyle(square).backgroundColor;
let start = stringBackgroundColor.indexOf("(",0);
let end = stringBackgroundColor.lastIndexOf(")");
let subStringBackgroundColor = stringBackgroundColor.substring(start + 1, end);
let arrayColor = subStringBackgroundColor.split(", ");

slideRangeR.value = arrayColor[0];
slideRangeG.value = arrayColor[1];
slideRangeB.value = arrayColor[2];

let r = arrayColor[0];
let g = arrayColor[1];
let b = arrayColor[2];
let a = slideRangeA.value;

slideRangeR.addEventListener('input',(event)=>{
    r = event.target.value;
    square.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
})

slideRangeG.addEventListener('input',(event)=>{
    g = event.target.value;
    square.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
})

slideRangeB.addEventListener('input',(event)=>{
    b = event.target.value;
    square.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
})

slideRangeA.addEventListener('input',(event)=>{
    a = event.target.value;
    square.style.backgroundColor = `rgba(${r},${g},${b},${a})`;
})
