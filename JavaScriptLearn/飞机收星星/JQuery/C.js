window.onload = function (){

    $(".box-text>*").each(function (i) {
        $(this).css("animation-delay",`${i*0.1+0.1}s`)
    })
};

$(".btn").click(function () {
    $(".box1").hide();
    $(".box7").show();

    if (pd){
        $(".bgmusic")[0].play()
    }else {
        $(".bgmusic")[0].pause()
    }

    var pd = true
    var bt = document.querySelector(".bt")
    bt.onclick = function () {
        pd = !pd
        console.log(pd)
    }
    var game = document.querySelector(".game");
// 创建飞机
    var player = document.createElement("div");
    player.className = "fly";
    game.appendChild(player);
// 飞机移动
    var flymove = {
        w:false,
        d:false,
        s:false,
        a:false,
    };
    window.addEventListener("keydown",function (event) {
        if (event.keyCode == 38){
            flymove.w = true;
        }
        if (event.keyCode == 39){
            flymove.d = true;
        }
        if (event.keyCode == 40){
            flymove.s = true;
        }
        if (event.keyCode == 37){
            flymove.a = true;
        }
    });
    window.addEventListener("keyup",function (event) {
        if (event.keyCode == 38){
            flymove.w = false;
        }
        if (event.keyCode == 39){
            flymove.d = false;
        }
        if (event.keyCode == 40){
            flymove.s = false;
        }
        if (event.keyCode == 37){
            flymove.a = false;
        }
    });
    var dsq1 = setInterval(function () {
        var sd = 10;
        if (flymove.w){
            player.style.top = player.offsetTop - sd + "px"
            if (parseInt(player.style.top) < 0){
                player.style.top = "0px";
            }
        }
        if (flymove.s){
            player.style.top = player.offsetTop + sd + "px"
            if (parseInt(player.style.top) > 538){
                player.style.top = "538px";
            }
        }
        if (flymove.a){
            player.style.left = player.offsetLeft - sd + "px"
            player.classList.add("left")
            if (parseInt(player.style.left) < 0){
                player.style.left = "0px";
            }
        }else{
            player.classList.remove("left")
        }
        if (flymove.d){
            player.style.left = player.offsetLeft + sd + "px"
            player.classList.add("right")
            if (parseInt(player.style.left) >924){
                player.style.left = "924px";
            }
        }else {
            player.classList.remove("right")
        }
    },16);
// 创建鸟
//     黄鸟
    var yellowarr = [];
    function Niao1() {
        this.create = function () {
            this.niao1 = document.createElement("div");
            this.niao1.className = "brid-yellow";
            this.niao1.style.top = Math.floor(Math.random()*550) + "px";
            game.appendChild(this.niao1);
            yellowarr.push(this);
        };
        this.move = function () {
            this.niao1.style.left = this.niao1.offsetLeft - 5 + "px"
            if (parseInt(this.niao1.style.left) < -80){
                game.removeChild(this.niao1);
                yellowarr.splice(this.niao1,1);
            }
        }
    }
    var dsq2 = setInterval(function () {
        var niao1ss = new Niao1();
        niao1ss.create();
    },1500)
    // 红鸟
    var redarr = [];
    function Niao2() {
        this.create = function () {
            this.niao2 = document.createElement("div");
            this.niao2.className = "brid-red";
            this.niao2.style.top = Math.floor(Math.random()*550) + "px";
            game.appendChild(this.niao2);
            redarr.push(this);
        };
        this.move = function () {
            this.niao2.style.left = this.niao2.offsetLeft - 5 + "px"
            if (parseInt(this.niao2.style.left) < -80){
                game.removeChild(this.niao2);
                redarr.splice(this.niao2,1);
            }
        }
    }
    var dsq3 = setInterval(function () {
        var niao2ss = new Niao2();
        niao2ss.create();
    },3500)
    // 星星
    var xxarr = [];
    function Xx() {
        this.create = function () {
            this.xx = document.createElement("div");
            this.xx.className = "xxl";
            this.xx.style.left = Math.floor(Math.random()*980) + "px";
            game.appendChild(this.xx);
            xxarr.push(this);
        };
        this.move = function () {
            this.xx.style.top = this.xx.offsetTop + 5 + "px"
            if (parseInt(this.xx.style.top) > 620){
                game.removeChild(this.xx);
                xxarr.splice(this.xx,1);
            }
        }
    }
    var dsq4 = setInterval(function () {
        var xxss = new Xx();
        xxss.create();
    },1000)

    //油
    var youarr = [];
    function You() {
        this.create = function () {
            this.you = document.createElement("div");
            this.you.className = "youl";
            this.you.style.left = Math.floor(Math.random()*980) + "px";
            game.appendChild(this.you);
            youarr.push(this);
        };
        this.move = function () {
            this.you.style.top = this.you.offsetTop + 3 + "px"
            if (parseInt(this.you.style.top) > 620){
                game.removeChild(this.you);
                youarr.splice(this.you,1);
            }
        }
    }
    var dsq5 = setInterval(function () {
        var youss = new You();
        youss.create();
    },1500)

// 鸟移动
    var dsq6 = setInterval(function () {
        for (var i=0;i<yellowarr.length;i++){
            yellowarr[i].move();
            if ($(yellowarr[i].niao1).hasClass("dead")) {
                yellowarr[i].niao1.style.top = yellowarr[i].niao1.offsetTop + 10 + "px";
                if (parseInt(yellowarr[i].niao1.style.top) > 630) {
                    game.removeChild(yellowarr[i].niao1);
                    yellowarr.splice(i,1);
                }
            }
        }
        for (var i=0;i<xxarr.length;i++){
            xxarr[i].move();
        }
        for (var i=0;i<youarr.length;i++){
            youarr[i].move();
        }
        for (var i=0;i<redarr.length;i++){
            redarr[i].move();
            if ($(redarr[i].niao2).hasClass("dead")) {
                redarr[i].niao2.style.top = redarr[i].niao2.offsetTop + 10 + "px";
                if (parseInt(redarr[i].niao2.style.top) > 630) {
                    game.removeChild(redarr[i].niao2);
                    redarr.splice(i,1);
                }
            }
        }

        xxs.innerHTML = xx;
        if (youshu <= 0){
            youshu = 0
        }
        if (parseInt(youdiv.style.width) < 0){
            youdiv.style.width = 0 + "px"
        }
        if (youshu >= 30){
            youshu = 30
        }
        if (parseInt(youdiv.style.width) >= 120){
            youdiv.style.width = 120 + "px"
        }
        you.innerHTML = youshu;

    },16)
// 碰撞函数
    function Hit(w1,w2) {
        var l1 = w1.offsetLeft;
        var r1 = l1 + w1.offsetWidth;
        var t1 = w1.offsetTop;
        var b1 = t1 + w1.offsetHeight;

        var l2 = w2.offsetLeft;
        var r2 = l2 + w2.offsetWidth;
        var t2 = w2.offsetTop;
        var b2 = t2 + w2.offsetHeight;
        // 判断碰撞
        if (l1 > r2 || r1<l2 || t1> b2 || b1< t2){
            return false;
        } else {
            return  true;
        }
    }
    var dsq7 = setInterval(function () {
        // 红鸟和飞机
        for (var i = 0;i < redarr.length;i++){
            if (!redarr[i].niao2.classList.contains("dead")) {
                if (Hit(player,redarr[i].niao2)){
                    redarr[i].niao2.classList.add("dead")
                    youdiv.style.width = youdiv.offsetWidth - 40 + "px"
                    youshu = youshu - 10
                    you.innerHTML = youshu;
                    if (pd){
                        $(".hitmusic")[0].currentTime = 0
                        $(".hitmusic")[0].play()
                    }
                    // redarr[i].niao2.classList.remove("brid-red")
                }
            }
        }
        // 黄鸟和飞机
        for (var i = 0;i < yellowarr.length;i++){
            if (!yellowarr[i].niao1.classList.contains("dead")){
                if (Hit(player,yellowarr[i].niao1)){
                    yellowarr[i].niao1.classList.add("dead")
                    youdiv.style.width = youdiv.offsetWidth - 40 + "px"
                    youshu = youshu - 10
                    you.innerHTML = youshu;
                    if (pd){
                        $(".hitmusic")[0].currentTime = 0
                        $(".hitmusic")[0].play()
                    }
                }
            }
        }
        // 星星
        for (var i = 0;i < xxarr.length;i++){
            if (Hit(player,xxarr[i].xx)){
                // console.log($('.xximg'))
                // document.getElementsByClassName('xximg').classList.add("d")
                xx = xx + 1;
                game.removeChild(xxarr[i].xx)
                xxarr.splice(i,1)
               if (pd){
                   $(".starmusic")[0].currentTime = 0
                   $(".starmusic")[0].play()
               }
            }
        }
        //飞机和油
        for (var i = 0;i < youarr.length;i++){
            if (Hit(player,youarr[i].you)){
                youdiv.style.width = youdiv.offsetWidth + 40 + "px"
                youshu = youshu + 10
                game.removeChild(youarr[i].you)
                youarr.splice(i,1)
            }
        }


        // 当背景声音播放完毕时重新开始

       if (pd){
           if ($(".bgmusic"[0] == "pause")) {
               $(".bgmusic")[0].play()
           }
       }
       if (pd == false){
           $(".bgmusic")[0].pause()
       }
    },16)

    var xxs = document.querySelector(".xxs");
    var xx = 0;
    var time = document.querySelector(".times");
    var times = 0;
    var youdiv = document.querySelector(".youzi");
    var you = document.querySelector(".youshu");
    var youshu = 15;


    var dsq8 = setInterval(function () {
        times = times + 1;
        youshu = youshu - 1;
        time.innerHTML = times;
        you.innerHTML = youshu;
        youdiv.style.width = youdiv.offsetWidth - 4 + "px"

    }, 1000)

    var dsq9 = setInterval(function () {
        if(youshu <= 0){
            clearInterval(dsq1)
            clearInterval(dsq2)
            clearInterval(dsq3)
            clearInterval(dsq4)
            clearInterval(dsq5)
            clearInterval(dsq6)
            clearInterval(dsq7)
            clearInterval(dsq8)
            clearInterval(dsq9)
            $(".bgmusic")[0].pause()
            $(".box7").hide()
            $(".name").show()
        }
    },16)
    var tj = document.querySelector("#tijiao")
    var text = document.querySelector(".text")
    tj.onclick = function () {
        if (text.value != ''){
            $(".name").hide()
            $(".table").show()
        console.log(text.value)
        }else {
            alert("未填入内容")
        }
    }







});

