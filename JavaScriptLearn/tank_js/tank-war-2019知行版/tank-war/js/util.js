function checkOut(o) {
	return o.x < 0 || o.y < 0 || o.x > bu.width - o.w || o.y > bu.height - o.h;
}

function initWall() {
	var x = (bu.width - wallcount * WALLSIZE) / 2;
	var y = 160;
	for(var i = 0; i < wallcount; i++) {
		var o = new Wall(x, y);
		x += WALLSIZE;
	}
}

function initHome(){
	var x = mm.x - WALLSIZE - 2;
	var y = mm.y - WALLSIZE - 5;
	var o = null;
	o = new Wall(x, y);	o.fang = 2;	x += WALLSIZE;	qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;		x += WALLSIZE;	qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;		o.w += 4;
	x += WALLSIZE + 4;		qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;		x += WALLSIZE;	qarray.push(o);
	/*********上面是前4块***下面这是第2排的2块****/
	x = mm.x - WALLSIZE - 2;	y += WALLSIZE;
	o = new Wall(x, y);	o.fang = 2;	 x += WALLSIZE*3+4; qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;	 x += WALLSIZE;	qarray.push(o);
	/*********上面这是第2排的2块，下面是第3排的2块****/
	x = mm.x - WALLSIZE - 2;	y += WALLSIZE;
	o = new Wall(x, y);	o.fang = 2;	 x += WALLSIZE*3+4; qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;	 x += WALLSIZE;	qarray.push(o);
	
	x = mm.x - WALLSIZE - 2;	y += WALLSIZE;
	o = new Wall(x, y);	o.fang = 2;		o.h += 11;
	x += WALLSIZE*3+4; qarray.push(o);
	o = new Wall(x, y);	o.fang = 2;		o.h += 11;
	x += WALLSIZE;	qarray.push(o);
}

function initEnemy() {
	var x = (bu.width - tankcount * (TANKSIZE + 5)) / 2;
	var y = 90;
	for(var i = 0; i < tankcount; i++) {
		var o = new Enemy(x, y);
		x += TANKSIZE + 5;
	}
}

function huaxinxi() {
	var x = 20,
		y = 30;
	g.fillStyle = "#fff";
	g.font = "14px 微软雅黑";
	g.fillText("敌军数量: " + tankcount, x, y);
	x += 100;
	g.fillText("歼灭数量: " + jianmie, x, y);
	x += 120;
	g.fillText("生命值: " + wo.hp, x, y);
	x += 100;
	g.fillText("复活次数: " + wo.fuhuo, x, y);
	x += 100;
	g.fillText("攻: " + wo.gong, x, y);
	x += 70;
	g.fillText("防: " + wo.fang, x, y);
	x += 70;
	g.fillText("移动速度: " + wo.speed, x, y);
	x += 100;
	g.fillText("可用地雷: " + wo.dilei, x, y);
	x += 150;
	g.fillText("游戏状态: " + stat, x, y);
	x += 100;
}
function huajifen() {
	var x = 20,
		y = 80;
	g.fillStyle = "#00FFFF";
	g.font = "24px 微软雅黑";
	g.fillText("积分: " + jifen, x, y);
}
function huashuoming() {
	var x = 50,
		y = 280;
	g.fillStyle = "#FF6666";
	g.font = "18px 微软雅黑";
	g.fillText("空格开炮，B 埋雷，P 暂停，R 复活，A 大招(失血3)", x, y);
}
function huatishi() {
	if ( yincang ) return;
	var x = (bu.width - 560) / 2,
		y = (bu.height - 200) / 2;
	g.fillStyle = "#fff";
	g.font = "60px 黑体";
	g.fillText("请按【Y】键开始游戏", x, y);
}

function huaover() {
	if ( stat != zt[4] ) return;
	var x = (bu.width - 400) / 2;
	g.fillStyle = "red";
	g.font = "80px Consolas";
	g.fillText("Game Over", x, overy);
}

function win() {
	if ( stat != zt[5] ) return;
	var x = (bu.width - 800) / 2;
	g.fillStyle = "#00ff88";
	g.font = "90px 楷体";
	g.fillText("大吉大利 今晚吃鸡", x, bu.height/2+50);
}

function gameover(){
	clearInterval(fjTimer);
	bf("lost.wav");
	stat = zt[4];	// 游戏结束
	fhdjsTimer = setInterval( function(){
		overy -= 15;
		if ( overy <= bu.height / 2 ) {
			clearInterval(fhdjsTimer);
		}
	} , 50);
}

function huafhdjs() {
	if ( stat != zt[6] ) return;
	var x = (bu.width - 200) / 2,
		y = bu.height / 2 + 150;
	g.fillStyle = "orangered";
	g.font = "300px 微软雅黑";
	g.fillText(fhdjs, x, y);
}

function huasj() {
	if ( stat != zt[2] && stat != zt[3] && stat != zt[7] ) return;
	var x = (bu.width - 70) / 2,
		y = bu.height / 2 + 200;
	g.fillStyle = stat == zt[2] ? "lightgreen" : "red";
	g.font = "100px 黑体";
	if ( pauseStat == zt[2] || pauseStat == zt[3] )
		g.fillText(sj, x, y);
}

function hit(o){
	var r = new Object();
	r.hit = false;
	var list = st.list;
	for ( var i = 0; i < list.length; i ++){
		var e = list[i];
		if ( o.index == e.index ) 	continue;	// 跳过自己
		if ( e.type == TYPE_TP )	continue;	// 跳过图片
		if ( o.type == TYPE_MI && o.tank.type == e.type ) continue;
		if ( e.type == TYPE_DJ && o.type == TYPE_MI ) continue;
		if ( o.type == TYPE_WO && e.type == TYPE_DL ) continue;
		if ( o.type == TYPE_MI && e.type == TYPE_DL ) continue;
		if ( o.type == TYPE_MI && e.type == TYPE_MI 
		  && o.tank.type == e.tank.type ) continue;
		if ( o.type == TYPE_MI && o.tank.type == TYPE_DR 
		  && e.type == TYPE_FJ )	continue;
		if ( o.type == TYPE_MI && e.type == TYPE_ZD ) continue;
		if ( o.type == TYPE_WO && e.type == TYPE_ZD ) continue;
		if ( o.type == TYPE_DR && e.type == TYPE_ZD ) continue;
		if ( o.type == TYPE_WO && e.type == TYPE_FJ ) continue;
		if ( o.type == TYPE_DR && e.type == TYPE_FJ ) continue;
		
		if ( hitForRectangle(o, e) ) {
			r.hit = true;
			r.o = e;
			return r;
		}
	}
	return r;
}

/**
 * 矩形物体碰撞检验
 * @param {Object} o1
 * @param {Object} o2
 */
function hitForRectangle(o1, o2) {
	if(o1.x < o2.x) {
		if(o2.x - o1.x <= o1.w) {
			if(o1.y < o2.y) {
				return o2.y - o1.y <= o1.h;
			} else if(o1.y > o2.y) {
				return o1.y - o2.y <= o2.h;
			} else
				return o1.y == o2.y;
		}
	} else if(o1.x > o2.x) {
		if(o1.x - o2.x <= o2.w) {
			if(o1.y < o2.y) {
				return o2.y - o1.y <= o1.h;
			} else if(o1.y > o2.y) {
				return o1.y - o2.y <= o2.h;
			} else
				return o1.y == o2.y;
		}
	} else {
		if(o1.y < o2.y) {
			return o2.y - o1.y <= o1.h;
		} else if(o1.y > o2.y) {
			return o1.y - o2.y <= o2.h;
		} else
			return o1.y == o2.y;
	}
	return false;
}

function checkHit(o){
	var q = 3;
	if ( o.x >= bu.width / 2) {
		q = -q;
	}
	var r = hit(o);
	while ( r.hit ) {
		o.x += q;
		if ( o.x <= 0 || o.x >= bu.width-o.w ){
			q = -q;
		}
		r = hit(o);
	}
}

function xiufangzi(n){
	if ( n > 0 ){
		for ( var i = 0; i < qarray.length; i ++){
			var q = qarray[i];
			if ( q.hp <= 0 ){
				st.add(q);
			}
			q.gaixue(n);
		}
	} else {
		for ( var i = 0; i < qarray.length; i ++){
			var q = qarray[i];
			q.gaixue(n);
		}
	}
}

function changeStat(s){
	oldstat = stat;			// 保存冰冻前的状态
	stat = s;
	statTimer = setInterval( function(){
		if ( stat == zt[7] ) return;
		sj --;
		if ( sj == 0 ){
			clearInterval(statTimer);
			sj = 5;
			stat = stat == zt[4] || stat == zt[5] 
				|| stat == zt[6] ? stat : oldstat;
		}
	} , 1000);
}

function createNewEnemy(n){
	if ( stat == zt[4] || tankcount >= 25 ) return;
	for ( var i = 0; i < n; i ++){
		var tp = new Object();
		tp.x = parseInt(Math.random()*(bu.width-200)) + 100;
		tp.y = parseInt(Math.random()*(bu.height-200)) + 50;
		tp.w = TANKSIZE;	tp.h = TANKSIZE;
		tp.type = TYPE_DR;	tp.index = -99;
		var r = hit(tp);	// 检查碰撞
		while ( r.hit ){
			tp.x = parseInt(Math.random()*(bu.width-200)) + 100;
			tp.y = parseInt(Math.random()*(bu.height-200)) + 50;
			r = hit(tp);
		}
		var o = new Enemy(tp.x,  tp.y);
		tankcount ++;
	}
	bf("newenemy.wav");
}

function bf(src){
	var au = new Audio();
	au.src = "sounds/" + src;
	au.play();
}

addEventListener("keydown", function() {
	var c = event.keyCode; // 获得按键的ascii
	wo.ctrl(c);
});

addEventListener("keyup", function() {
	var c = event.keyCode; // 获得按键的ascii
	wo.unctrl(c);
});