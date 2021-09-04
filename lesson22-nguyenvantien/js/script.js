var block = $("#block");
var positionY = document.getElementById("positionY")
var positionX = document.getElementById("positionX")
var size = document.getElementById("size")
var opacity = document.getElementById("opacity")
var hex = document.getElementById("hex")
var r = document.getElementById("r")
var g = document.getElementById("g")
var b = document.getElementById("b")
var a = document.getElementById("a")

$("#positionY").on("change", function() {
    marginTop = (parseInt(positionY.value,10) + 50)*2;
    console.log(marginTop)
    block.css("margin-top", `${marginTop}px`)
})

$("#positionX").on("change", function() {
    marginTop = (parseInt(positionX.value,10))*8;
    console.log(marginTop)
    block.css("margin-left", `${marginTop}px`)
})

$("#size").on("change", function() {
    resize = 4*size.value
    block.css("height", `${resize}px`)
    block.css("width", `${resize}px`)
})

$("#opacity").on("change", function() {
    opt = opacity.value/100;
    console.log(opt);
    block.css("opacity", `${opt}`)
})

$("#ok").on("click", function() {
    if($("#shape option:selected").text() == "Square"){
        block.css("border-radius", "0px")
        
    } else {
        radius = block.height();
        block.css("border-radius", `${radius}px`)
        console.log(positionY.value)
        console.log(radius)
    }
})

$("#hex").on("change", function() {
    let bgc = hex.value
    block.css("background-color", `#${bgc}`)
})

var setBgc = function () {
    rVal = r.value*2.55
    gVal = g.value*2.55
    bVal = b.value*2.55
    aVal = a.value/100
    block.css("background", `rgba(${rVal},${gVal}
                                    ,${bVal},${aVal})`)
    console.log(`${rVal},${gVal}
    ,${bVal},${aVal}`)
}

$("#r").on("change", setBgc)
$("#g").on("change", setBgc)
$("#b").on("change", setBgc)
$("#a").on("change", setBgc)

