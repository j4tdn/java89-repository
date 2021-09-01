var count = 0;
var scores = 0;
var images = ['balloon-blue.png',
                'balloon-green.png',
                'balloon-red.png',
                'balloon-violet.png',
                'balloon-yellow.png']
                
var intervalOut = setInterval(() => {
    let time = Math.floor(Math.random() * 15) + 10;
    let index = Math.floor(Math.random() * 5);
    let left = Math.floor(Math.random() * $(window).width());
    let element = document.createElement("div");
    element.id = count;
    element.classList.add('ball');
    element.style.animationDuration = `${time}s`;
    element.style.backgroundImage = `url("../images/${images[index]}")`;
    element.style.marginLeft = `${left}px`;
    element.addEventListener('click', function() {
        $(this).hide();
        scores++;
        $("#scores").text(`You popped ${scores} balloons`);
        console.log($("#scores").text())
        let audio = document.createElement("audio");
        audio.autoplay = true;
        audio.src = "../sounds/pop.mp3";
        this.appendChild(audio);
    })
    var intervalIn = setInterval(() => {
        var countBall = 0;
        let elements = document.getElementsByClassName("ball");
        for (let index = 0; index < elements.length; index++) {
            if(elements[index].getBoundingClientRect().top<-200){
                countBall++;
            }
            if(countBall == 5){
                let end = document.getElementById("end");
                end.classList.remove("hide");
                end.classList.add("show");
                let divEnd = document.createElement("div");
                divEnd.id = "result";
                // let text = document.createTextNode(`You popped ${scores} balloons`);
                // divEnd.appendChild(text);
                $("#result").text(`You popped ${scores} balloons`)
                divEnd.classList.add("form-text")
                document.getElementById("final-scores").appendChild(divEnd);
                clearInterval(intervalIn);
                clearInterval(intervalOut);
            }
            
        }
    }, 1000);
    document.getElementById("main").appendChild(element);
    count++;
}, 2000);

$("#yes").on("click", function() {
    location.reload();
})

$("#no").on("click", function() {
    location.reload();
})



