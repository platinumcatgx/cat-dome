
function Tank ( x,y, type, src, speed, gong, fang ){
	var o = new Base(x, y, TANKSIZE, TANKSIZE, type, src);
	o.speed = speed;
	o.gong = gong;
	o.fang = fang;
	o.moveTimer = setInterval( function(){o.move();} , 30);
	o.toLeft = function(){
		o.left = true;
		o.right = false;  o.up = false;  o.down = false;
		o.dir = L;
		o.huantu();
	}
	o.stopLeft = function(){
		o.left = false;
	}
	o.toRight = function(){
		o.right = true;
		o.left = false;  o.up = false;  o.down = false;
		o.dir = R;
		o.huantu();
	}
	o.stopRight = function(){
		o.right = false;
	}
	o.toUp = function(){
		o.up = true;
		o.left = false;  o.right = false;  o.down = false;
		o.dir = U;
		o.huantu();
	}
	o.stopUp = function(){
		o.up = false;
	}
	o.toDown = function(){
		o.down = true;
		o.left = false;  o.up = false;  o.right = false;
		o.dir = D;
		o.huantu();
	}
	o.stopDown = function(){
		o.down = false;
	}
	o.huantu = function(){
		o.src = "img/" + o.pname + o.dir + ".gif";
	}
	
	o.fire = function(){
		if ( stat == zt[0] || o.hp <= 0 ){
			return;
		}
		var m = new Missile(o);
	}
	
	o.tisu = function(){
		o.speed ++;
		o.speed = o.speed > 7 ? 7 : o.speed;
		bf("prop.wav");
	}
	o.shenggong = function(){
		o.gong ++;
		o.gong = o.gong > 4 ? 4 : o.gong;
	}
	o.shengfang = function(){
		o.fang ++;
		o.fang = o.fang > 4 ? 4 : o.fang;
	}
	return o;
}

function Enemy(x, y) {
	var o = new Tank(x, y, TYPE_DR, "img/tankD.gif", 3, 0, 0);
	o.pname = "tank";
	o.dir = D;
	var n = parseInt(Math.random()*100);
	o.hero = n % 5 == 0;
	if ( o.hero ){
		o.pname = "d";
		o.speed = 4;
		o.gong = 2;
		o.fang = 2;
	}
	o.src = "img/" + o.pname + o.dir + ".gif";// 英雄坦克图不一样
	o.siwang = function(){
		bf("bomb2.wav");
		jianmie ++;		// 死的数量+1
		tankcount --;	// 活着的数量减1
		jifen += 10;
		if ( o.hero ) jifen += 5;
		if ( tankcount == 0 ){
			stat = zt[5];
			bf("winend.wav");
			clearInterval(fjTimer);
			for ( var i = 0; i < st.list.length; i ++ ){
				if ( st.list[i].type == TYPE_QI ) {
					st.list[i].die();	i --;
				}
			}
			var i = 0;
			mm.src = "img/p" + i + ".gif";
			winTimer = setInterval(function(){
				i++;
				if ( i == 12 ) i = 0;
				mm.src = "img/p" + i + ".gif";
				if ( mm.w <= bu.width*0.35 ){
					mm.w = mm.w * 1.11;
					mm.h = mm.h * 1.1;
					mm.x = (bu.width - mm.w)/2 - 50;
					mm.y = bu.height - mm.h;
				}
			}, 240);
		}
		o.boom();		// 爆炸特效
	}
	
	o.ctrlTimer = setInterval( function(){
		if ( stat == zt[0] || stat == zt[7] || stat == zt[2] ) return;
		var n = parseInt(Math.random()*100);// 0-99
		if ( n % 19 == 0 ) {
			n = parseInt(Math.random()*4);	// 0-3
			if ( n == 0 ){
				o.toLeft();
			} else if ( n == 1 ){
				o.toUp();
			} else if ( n == 2 ){
				o.toRight();
			} else if ( n == 3 ){
				o.toDown();
			}
		}
		n = parseInt(Math.random()*100);
		if ( n % 17 == 0 ) {
			o.fire();
		}
	}, 30);
	
	o.eat = function(e) {	// 敌军吃道具
		
		e.die();
		if ( e.n == 0 ){
			o.tisu();
		} else if ( e.n == 1 ){	// 多出3-5个敌军
			createNewEnemy(5);
		} else if ( e.n == 2 ){	// 冰冻正方
			sj = 5;	
			if ( stat == zt[1] ) {
				pauseStat = zt[3];
				changeStat(zt[3]);
				bf("stop.wav");
			}
		} else if ( e.n == 3 ){
			o.shenggong();
		} else if ( e.n == 4 ){
			o.shengfang();
		} else if ( e.n == 5 ){
			xiufangzi(-30);
		} else if ( e.n == 6 ){
			o.gaixue(30);
		} else if ( e.n == 7 ){
			var k = parseInt(Math.random()*36) + 60;
			o.gaixue(-k);
			bf("zeg.wav");
		} else if ( e.n == 8 ){
			createNewEnemy(3);
		} else if ( e.n == 9 ){
			createNewEnemy(3);
		}
	
}
	
	return o;
}

function Wojun(x, y){
	var o = new Tank(x, y, TYPE_WO, "img/wU.gif", 3, 0, 0);
	o.fuhuo = 3;	// 默认3次复活机会
	o.dilei = 2;	// 默认出厂2颗地雷可用
	
	o.pname = "w";
	o.dir = U;
	o.gong = 0;
	o.ctrl = function(c){
		if ( stat == zt[0] && c != 89 ) {
			return;
		} else if ( c == 89 && stat == zt[0]){
			l1.die();	l2.die();
			bf("kaipao.wav");
			stat = zt[1];
			logo.die();						// 清除logo
			yincang = true;
			clearInterval(yincangTimer);	// 清除文字
			fjTimer = setInterval( function(){
				if ( stat == zt[7] ) return;
				var n = parseInt(Math.random()*100);
				if ( n % 3 == 0 ){
					new Feiji();
				}
			} , 1000);
			return;
		}
		if ( c == 80 && stat != zt[4] && stat != zt[5] && stat != zt[6] && stat != zt[7]){
			pauseStat = stat;
			stat = zt[7];
			wo.left = false;	wo.right = false;
			wo.up = false;		wo.down = false;
		} else if ( c == 80 && stat == zt[7] ){	// 恢复游戏
			stat = pauseStat;
		}
		if ( stat == zt[7] ) return;
		if ( c == 37 ) {
			o.toLeft();
		} else if ( c == 39 ){
			o.toRight();
		} else if ( c == 38 ){
			o.toUp();
		} else if ( c == 40 ){
			o.toDown();
		}
	}
	
	o.mailei = function(){
		if ( wo.dilei <= 0 ) return;
		wo.dilei --;
		new Dilei();
		bf("letsmove.wav");
	}
	
	o.unctrl = function(c){
		if ( stat == zt[7] ) return;
		if ( c == 32 && o.hp > 0 && stat != zt[5] && stat != zt[3] ){
			o.fire();	bf("attack.mp3");
		} else if ( c == 82 && stat == zt[6] ){
			o.relife();
		} else if ( c == 66 ) {
			if ( stat == zt[1] || stat == zt[2] || stat == zt[8]){
				o.mailei();
			}
		}
		if ( c == 65 && wo.hp > 3 && stat != zt[5]){
			wo.fadazhao();
		}
		if ( c == 37 ) {
			o.stopLeft();
		} else if ( c == 39 ){
			o.stopRight();
		} else if ( c == 38 ){
			o.stopUp();
		} else if ( c == 40 ){
			o.stopDown();
		}
	}
	
	o.fadazhao = function (){
		if ( stat == zt[0] || o.hp <= 0 || stat == zt[3] || stat == zt[6]){
			return;
		}
		var temp = o.dir;
		o.dir = L;
		new MissileBig(o);
		o.dir = U;
		new MissileBig(o);
		o.dir = R;
		new MissileBig(o);
		o.dir = D;
		new MissileBig(o);
		o.hp -= 3;
		o.dir = temp;
	}
	
	o.relife = function(){
		o.hp = 100;		o.speed = 3;	o.gong = 0;
		o.fang = 0;		o.dilei = 2;	o.fuhuo --;
		
		checkHit(o);
		
		st.add(o);	sj = 5;
		stat = stat == zt[5] ? stat : zt[1];
		fhdjs = 9;		clearInterval(fhdjsTimer);
		o.moveTimer = setInterval( function(){o.move();} , 30);
	}
	
	o.eat = function(e){
		e.die();
		if ( stat == zt[5]) return;
		if ( e.n == 0 ){			// 齿轮
			o.tisu();
		} else if ( e.n == 1 ) {	// 奖命1条
			o.fuhuo ++;
			o.fuhuo = o.fuhuo > 6 ? 6 : o.fuhuo;
			bf("prop.mp3");
		} else if ( e.n == 2 ) {	// 冰冻
			sj = 5;
			if ( stat == zt[1] || stat == zt[8] ) {
				pauseStat = zt[2];
				changeStat(zt[2]);
				bf("daxiao.wav");
			}
		} else if ( e.n == 3 ) {	// 升攻
			o.shenggong();
			bf("prop.wav");
		} else if ( e.n == 4 ) {	// 升防
			o.shengfang();
			bf("prop.wav");
		} else if ( e.n == 5 ) {	// 修复家
			xiufangzi(30);
			bf("yongbao.wav");
		} else if ( e.n == 6 ) {	// 加血
			o.gaixue(30);
			bf("daxiao.wav");
		} else if ( e.n == 7 ) {	// 失血
			var k = parseInt(Math.random()*36) + 60;
			o.gaixue(-k);
			bf("bomb1.wav");
		} else if ( e.n == 8 ) {	// 美女加血
			mm.gaixue(30);
			bf("bready.wav");
		} else if ( e.n == 9 ) {	// 加地雷
			wo.dilei += 2;
			wo.dilei = wo.dilei > 10 ? 10 : wo.dilei;
			bf("blei.wav");
		}
	}
	
	o.siwang = function(){
		bf("die.wav");
		o.boom();		// 爆炸特效
		if ( stat == zt[5] ) return;
		stat = o.fuhuo > 0 && stat != zt[4] ? zt[6] : zt[4];	// 状态切换
		if ( stat == zt[6] ) {
			fhdjsTimer = setInterval( function(){
				fhdjs --;
				if ( fhdjs == 0 ){
					clearInterval(fhdjsTimer);
					o.fuhuo = 0;	o.dilei = 0;
					gameover();
				}
			} , 1100);
		} else {
			gameover();
		}
	}
	return o;
}
