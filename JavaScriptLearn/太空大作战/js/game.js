$(function(){
    $(".button").click(function () {
        $(".box2").hide();
        $(".box3").show();
        $("#background")[0].play();
        var bd = false;

        var zuantin = document.querySelector(".zuantin");
        //暂停所有动画
        zuantin.addEventListener("click",function(){
            bd = !bd;
            if (bd){
                $("#background")[0].pause();
                zuantin.src = "./ps/ps6.png";
            }else {
                $("#background")[0].play();
                zuantin.src = "./ps/ps5.png";
            }
            var o = $("*");
                if(bd) {
                    // console.log(o);
                    o.css("animationPlayState",  "paused")
                }else{
                    o.css("animationPlayState",  "running")
                }


        } );

        window.score = 0;
        window.times = 0;
        window.nls = 30;
        window.shijian = document.querySelector(".sj");
        window.fs = document.querySelector(".fs");
        window.nltime = document.querySelector(".nlz");
        var zuosy = document.querySelector(".zuosy");
        window.zsy = false;
        //控制字体大小
        var jia = document.querySelector(".jia");
        shijian.style.fontSize = "20px";
        fs.style.fontSize = "20px";
        nltime.style.fontSize = "20px";
        var jian = document.querySelector(".jian");

        jia.addEventListener('click',function () {
            console.log(shijian, shijian.style.fontSize)
            shijian.style.fontSize = parseInt(shijian.style.fontSize) + 1 + "px";
            fs.style.fontSize = parseInt(fs.style.fontSize) + 1 + "px";
            nltime.style.fontSize = parseInt(nltime.style.fontSize) + 1 + "px";
        });
        jian.addEventListener('click',function () {
            console.log(shijian, shijian.style.fontSize)
            shijian.style.fontSize = parseInt(shijian.style.fontSize) - 1 + "px";
            fs.style.fontSize = parseInt(fs.style.fontSize) - 1 + "px";
            nltime.style.fontSize = parseInt(nltime.style.fontSize) - 1 + "px";
        });
        zuosy.addEventListener('click',function () {
            zsy = !zsy;
            if (zsy == true){
                zuosy.src = "./ps/sy1.png";
            } else{
                zuosy.src = "./ps/sy.png";
            }
        });

        // var bgsy = document.querySelector("#background");
        // if (zsy == true){
        //     bgsy.currentTime = 0;
        //     bgsy.pause();
        // }else{
        //     bgsy.currentTime = 0;
        //     bgsy.play();
        // }







        var game = document.querySelector(".box3");
        //使火箭出现在页面
        var hj = document.createElement("div");
        hj.className = "hj";
        game.appendChild(hj);
        var fx = {
            w:false,
            a:false,
            s:false,
            d:false,
        }
        //使火箭移动
        window.addEventListener("keydown", function(event){
            if (event.keyCode == 38){
                fx.w = true;
            }
            if (event.keyCode == 39){
                fx.d = true;
            }
            if (event.keyCode == 40){
                fx.s = true;
            }
            if (event.keyCode == 37){
                fx.a = true;
            }
        })
        window.addEventListener("keyup", function(event){
            if (event.keyCode == 38){
                fx.w = false;
            }
            if (event.keyCode == 39){
                fx.d = false;
            }
            if (event.keyCode == 40){
                fx.s = false;
            }
            if (event.keyCode == 37){
                fx.a = false;
            }
        })

            setInterval(function () {
                if (!bd){
                if (fx.w){
                    hj.style.top = hj.offsetTop - 10 + "px";
                    if (parseInt(hj.style.top) < 60) {
                        hj.style.top = "60px";
                    }
                }
                if (fx.s){
                    hj.style.top = hj.offsetTop + 10 + "px";
                    if (parseInt(hj.style.top) > 690) {
                        hj.style.top = "690px";
                    }
                }
                if (fx.a){
                    hj.style.left = hj.offsetLeft - 10 + "px";
                    if (parseInt(hj.style.left) < 0) {
                        hj.style.left = "0px";
                    }
                }
                if (fx.d){
                    hj.style.left = hj.offsetLeft + 10 + "px";
                    if (parseInt(hj.style.left) > 940) {
                        hj.style.left = "940px";
                    }
                }
                }
            },16);





        //生成子弹
        var zdarr = [];
        // window.zdarr.removeZd = function (zd) {
        //     game.removeChild(zd);
        //     zdarr.splice(zdarr.indexOf(zd), 1)
        // };
        function Zd(){
            this.create = function(){
                this.zd = document.createElement("div");
                this.zd.className = "zd";
                this.zd.style.left = hj.offsetLeft + 40 + "px";
                this.zd.style.top = hj.offsetTop + 40 + "px";
                game.appendChild(this.zd);
                zdarr.push(this);
            }
            this.move = function () {
                this.zd.style.left = this.zd.offsetLeft + 10 + "px";
                if (parseInt(this.zd.style.left) > 1080){
                    game.removeChild(this.zd);
                    zdarr.splice(this.zd,1);
                }
            }
        }
        window.addEventListener("keydown", function (event) {
            if(!bd && nls > 0){
                if (event.keyCode == 32){
                    var zds = new Zd();
                    zds.create();
                    var  zdsy = document.querySelector("#zdsy");
                    zdsy.currentTime = 0;
                    zdsy.play();
                    if (zsy == true){
                        zdsy.currentTime = 0;
                        zdsy.pause();
                    }else{
                        zdsy.currentTime = 0;
                        zdsy.play();
                    }
                }
            }
        })
        //生成敌人
        var drarr = [];
        function Dr(){
            this.create = function(){
                this.dr = document.createElement("div");
                this.dr.className = "dr";
                // this.dr.style.left = hj.offsetLeft + 40 + "px";
                this.dr.style.top = Math.floor(Math.random()*600) + 60 + "px";
                game.appendChild(this.dr);
                drarr.push(this);
            }
            this.move = function () {
                this.dr.style.left = this.dr.offsetLeft - 5 + "px";
                if (parseInt(this.dr.style.left) < -80){
                    game.removeChild(this.dr);
                    drarr.splice(this.dr,1);
                }
            }
        }
        setInterval(function () {
            if(!bd && nls > 0){
                var drss = new Dr();
                drss.create();
                var drzdss = new Drzd();
                drzdss.create()
            }
        },3000)
        setInterval(function () {
            if (!bd) {
                for (var i = 0; i < drarr.length; i++){
                    drarr[i].move();
                }
            }

        },25)
        //生成友军
        var ffarr = [];
        function Ff(){
            this.create = function(){
                this.ff = document.createElement("div");
                this.ff.className = "ff";
                // this.dr.style.left = hj.offsetLeft + 40 + "px";
                this.ff.style.top = Math.floor(Math.random()*600) + 60 + "px";
                game.appendChild(this.ff);
                ffarr.push(this);
            }
            this.move = function () {
                this.ff.style.left = this.ff.offsetLeft - 6 + "px";
                if (parseInt(this.ff.style.left) < -80){
                    game.removeChild(this.ff);
                    ffarr.splice(this.ff,1);
                }
            }
        }
        setInterval(function () {
            if (!bd && nls > 0){
                var ffss = new Ff();
                ffss.create();
            }
        },2000)
        // setInterval(function () {
        //
        // },25)
        //生成陨石
        var ysarr = [];
        function Ys(){
            this.create = function(){
                this.ys = document.createElement("div");
                this.ys.className = "ys";
                // this.dr.style.left = hj.offsetLeft + 40 + "px";
                this.ys.style.top = Math.floor(Math.random()*600) + 60 + "px";
                game.appendChild(this.ys);
                ysarr.push(this);
            }
            this.move = function () {
                this.ys.style.left = this.ys.offsetLeft - 5 + "px";
                if (parseInt(this.ys.style.left) < -80){
                    game.removeChild(this.ys);
                    ysarr.splice(this.ys,1);
                }
            }
        }
        setInterval(function () {
            if (!bd && nls > 0){
                var ysss = new Ys();
                ysss.create();
            }
        },4000)
        //生成敌人子弹(生成敌人子弹和生成敌人在一个定时器)
        window.drzdarr = [];
        function Drzd(){
            this.create = function(){
                this.drzd = document.createElement("div");
                this.drzd.className = "drzd";
                for (var i=0;i<drarr.length;i++) {
                    this.drzd.style.left = drarr[i].dr.offsetLeft + "px";
                    this.drzd.style.top = drarr[i].dr.offsetTop + "px";
                }
                game.appendChild(this.drzd);
                drzdarr.push(this);
            }
            this.move = function(){
                this.drzd.style.left = this.drzd.offsetLeft - 10 + "px";
                if(parseInt(this.drzd.style.left) < -30){
                    game.removeChild(this.drzd);
                    drzdarr.splice(this.drzd,1);
                }
            }
        }

        //生成能量
        var nlarr = [];
        function Nl(){
            this.create = function(){
                this.nl = document.createElement("div");
                this.nl.className = "nl";
                // this.dr.style.left = hj.offsetLeft + 40 + "px";
                this.nl.style.left = Math.floor(Math.random()*1000) + "px";
                game.appendChild(this.nl);
                nlarr.push(this);
            }
            this.move = function () {
                this.nl.style.top = this.nl.offsetTop + 5 + "px";
                if (parseInt(this.nl.style.top) > 780){
                    game.removeChild(this.nl);
                    nlarr.splice(this.nl,1);
                }
            }
        }
        setInterval(function () {
            if (!bd && nls > 0){
                var nlss = new Nl();
                nlss.create();
            }
        },2000)
        setInterval(function () {
            if(!bd){
                //判断是否暂停动画移动
                for (var i = 0; i < nlarr.length; i++){
                    nlarr[i].move();
                }
                for (var i=0;i<drzdarr.length;i++){
                    drzdarr[i].move();
                }
                for (var i = 0; i < ysarr.length; i++){
                    ysarr[i].move();
                }
                for (var i = 0; i < ffarr.length; i++){
                    ffarr[i].move();
                }
                for (var i = 0; i < zdarr.length; i++){
                    zdarr[i].move();
                }
            }

        },16);
        //碰撞函数
       function Hit(obj1,obj2){
            var t1 = obj1.offsetTop;
            var b1 = t1 + obj1.offsetHeight;
            var l1 = obj1.offsetLeft;
            var r1 = l1 + obj1.offsetWidth;

            var t2 = obj2.offsetTop;
            var b2 = t2 + obj2.offsetHeight;
            var l2 = obj2.offsetLeft;
            var r2 = l2 + obj2.offsetWidth;
            if(t1>b2 || b1<t2 || l1>r2 || r1<l2){
                return false;
            }else {
                return true;
            }
        }
        //判断碰撞
        setInterval(function(){

            for (var i=0;i<ffarr.length;i++){
                if (Hit(hj,ffarr[i].ff)){
                    var  pzsy = document.querySelector("#pzsy");
                    pzsy.currentTime = 0;
                    pzsy.play();
                    if (zsy == true){
                        pzsy.currentTime = 0;
                        pzsy.pause();
                    }else{
                        pzsy.currentTime = 0;
                        pzsy.play();
                    }
                    game.removeChild(ffarr[i].ff);
                    ffarr.splice(i,1);
                    nls = nls - 10;
                    nltime.style.width = nltime.offsetWidth - 40 + "px";
                }
            }
            // console.log(zsy)
            for (var i=0;i<drarr.length;i++){
                if (Hit(hj,drarr[i].dr)){
                    var  pzsy = document.querySelector("#pzsy");
                    pzsy.currentTime = 0;
                    pzsy.play();
                    if (zsy == true){
                        pzsy.currentTime = 0;
                        pzsy.pause();
                    }else{
                        pzsy.currentTime = 0;
                        pzsy.play();
                    }
                    game.removeChild(drarr[i].dr);
                    drarr.splice(i,1);
                    nls = nls - 10;
                    nltime.style.width = nltime.offsetWidth - 40 + "px";
                }
            }
            for (var i=0;i<ysarr.length;i++){
                if (Hit(hj,ysarr[i].ys)){
                    var  pzsy = document.querySelector("#pzsy");
                    pzsy.currentTime = 0;
                    pzsy.play();
                    if (zsy == true){
                        pzsy.currentTime = 0;
                        pzsy.pause();
                    }else{
                        pzsy.currentTime = 0;
                        pzsy.play();
                    }
                    game.removeChild(ysarr[i].ys);
                    ysarr.splice(i,1);
                    nls = nls - 10;
                    nltime.style.width = nltime.offsetWidth - 40 + "px";
                }
            }
            for (var i=0;i<nlarr.length;i++){
                if (Hit(hj,nlarr[i].nl)){
                    var  nlsy = document.querySelector("#nlsy");
                    nlsy.currentTime = 0;
                    nlsy.play();
                    if (zsy == true){
                        nlsy.currentTime = 0;
                        nlsy.pause();
                    }else{
                        nlsy.currentTime = 0;
                        nlsy.play();
                    }
                    game.removeChild(nlarr[i].nl);
                    nlarr.splice(i,1);
                    nls = nls + 10;
                    nltime.style.width = nltime.offsetWidth + 40 + "px";
                }
            }
            for (var i=0;i<drzdarr.length;i++){
                if(Hit(drzdarr[i].drzd,hj)){
                    var  zdmhsy = document.querySelector("#zdhmsy");
                    zdmhsy.currentTime = 0;
                    zdmhsy.play();
                    if (zsy == true){
                        zdmhsy.currentTime = 0;
                        zdmhsy.pause();
                    }else{
                        zdmhsy.currentTime = 0;
                        zdmhsy.play();
                    }
                    game.removeChild(drzdarr[i].drzd);
                    drzdarr.splice(i,1);
                    nls = nls - 10;
                    nltime.style.width = nltime.offsetWidth - 40 + "px";
                }
            }

            for(var i=0;i<zdarr.length;i++){
                for (var j=0;j<drarr.length;j++){
                    if(Hit(zdarr[i].zd,drarr[j].dr)){
                        var  zdmhsy = document.querySelector("#zdhmsy");
                        zdmhsy.currentTime = 0;
                        zdmhsy.play();
                        if (zsy == true){
                            zdmhsy.currentTime = 0;
                            zdmhsy.pause();
                        }else{
                            zdmhsy.currentTime = 0;
                            zdmhsy.play();
                        }
                        game.removeChild(zdarr[i].zd);
                        game.removeChild(drarr[j].dr);
                        zdarr.splice(i,1);
                        drarr.splice(j,1);
                        score = score + 10;
                        fs.innerHTML = score;
                    }
                }
            }
            for(var i=0;i<zdarr.length;i++){
                for (var j=0;j<ffarr.length;j++){
                    if(Hit(zdarr[i].zd,ffarr[j].ff)){
                        var  zdmhsy = document.querySelector("#zdhmsy");
                        zdmhsy.currentTime = 0;
                        zdmhsy.play();
                        if (zsy == true){
                            zdmhsy.currentTime = 0;
                            zdmhsy.pause();
                        }else{
                            zdmhsy.currentTime = 0;
                            zdmhsy.play();
                        }
                        game.removeChild(zdarr[i].zd);
                        game.removeChild(ffarr[j].ff);
                        zdarr.splice(i,1);
                        ffarr.splice(j,1);
                        score = score - 10;
                        fs.innerHTML = score;
                        return;
                    }
                }
            }
            for(var i=0;i<zdarr.length;i++){
                // console.log("   i   "+i)
                for (var j=0;j<ysarr.length;j++){
                    // console.log("  j  " + j)
                    if(Hit(zdarr[i].zd,ysarr[j].ys)){
                        if(ysarr[j].ys.style.opacity != 0.8 && ysarr[j].ys.style.opacity != 0.5){
                            var  zdmhsy = document.querySelector("#zdhmsy");
                            zdmhsy.currentTime = 0;
                            zdmhsy.play();
                            if (zsy == true){
                                zdmhsy.currentTime = 0;
                                zdmhsy.pause();
                            }else{
                                zdmhsy.currentTime = 0;
                                zdmhsy.play();
                            }
                            ysarr[j].ys.style.opacity = "0.8";
                            game.removeChild(zdarr[i].zd);
                            zdarr.splice(i,1);
                            return
                        }else if(ysarr[j].ys.style.opacity != 0.5){
                            var  zdmhsy = document.querySelector("#zdhmsy");
                            zdmhsy.currentTime = 0;
                            zdmhsy.play();
                            if (zsy == true){
                                zdmhsy.currentTime = 0;
                                zdmhsy.pause();
                            }else{
                                zdmhsy.currentTime = 0;
                                zdmhsy.play();
                            }
                            ysarr[j].ys.style.opacity = "0.5";
                            game.removeChild(zdarr[i].zd);
                            zdarr.splice(i,1);
                            return
                        }else{
                            var  zdmhsy = document.querySelector("#zdhmsy");
                            zdmhsy.currentTime = 0;
                            zdmhsy.play();
                            if (zsy == true){
                                zdmhsy.currentTime = 0;
                                zdmhsy.pause();
                            }else{
                                zdmhsy.currentTime = 0;
                                zdmhsy.play();
                            }
                            game.removeChild(ysarr[j].ys);
                            game.removeChild(zdarr[i].zd);
                            zdarr.splice(i,1);
                            ysarr.splice(j,1);
                            score = score + 10;
                            fs.innerHTML = score;
                            return;
                        }
                    }
                }
            }
        },16)


        //时间
        setInterval(function(){
            if(!bd){
                times = times + 1;
                nls = nls - 1;
                shijian.innerHTML = times;
                nltime.innerHTML = nls;
                nltime.style.width = nltime.offsetWidth - 4 + "px";
            }
        },1000);
        var ccc = setInterval(function () {
            if (parseInt(nltime.style.width) > 120 || nls > 30){
                nltime.style.width = "120px";
                nls = 30;
            }
            if(nls <= 0){
                $(".box3").hide();
                $(".box5").show();
                $("#background")[0].pause();

            }
        },16)
        var bt = document.querySelector(".bt");
        bt.addEventListener("click", function(){
            $(".box5").hide();
            $(".box6").show();
            clearInterval(ccc);
        })



























    })
})