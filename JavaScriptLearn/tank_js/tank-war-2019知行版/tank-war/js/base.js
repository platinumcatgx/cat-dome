function Base(x, y, w, h, type, src) {
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
	this.type = type;
	this.src = src;
	this.hp = 100; // 生命值
	this.index = INDEX++;
	this.speed = 3;
	this.dir = U; // U D L R
	this.gong = 0; // 设置攻击的等级
	this.fang = 0; // 设置防御的等级
	this.left = false;
	this.right = false;
	this.up = false;
	this.down = false;

	var me = this;
	this.show = function() {
		var img = new Image();
		img.src = me.src;
		g.drawImage(img, me.x, me.y, me.w, me.h);
		if ( stat != zt[5])
			me.blood();
	}

	this.move = function() {
		if ( stat == zt[0] || stat == zt[7] ) return;
		if ( me.type == TYPE_DR && stat == zt[2] ) return;
		if ( me.type == TYPE_FJ && stat == zt[2] ) return;
		if ( me.type == TYPE_WO && stat == zt[3] ) return;
		var ox = me.x,
			oy = me.y;
		if(me.left) {
			me.x -= me.speed;
		} else if(me.right) {
			me.x += me.speed;
		} else if(me.up) {
			me.y -= me.speed;
		} else if(me.down) {
			me.y += me.speed;
		}
		if(checkOut(me)) {
			if ( me.type == TYPE_MI ){
				me.die();
			} else if ( me.type == TYPE_FJ ){ // 飞机出界
				if ( me.x > bu.width + 10 || me.x < -(PLANESIZE+10)
				  || me.y > bu.height +10 || me.y < -(PLANESIZE+10)){
				  	me.out = true;
				  	me.die();
				}
			} else {
				me.x = ox;
				me.y = oy; // 恢复旧坐标
			}
		} 
		var r = hit(me);
		if ( r.hit ){
			// 要知道是哪一种物体发生了碰撞
			if ( me.type == TYPE_DR || me.type == TYPE_WO ) {
				if ( r.o.type == TYPE_DJ ) {
					me.eat(r.o);// 吃道具
				} else if ( r.o.type == TYPE_DL ){
					var k = parseInt(Math.random()*20) + 80;
					me.gaixue(-k);
					bf("bomb2.wav");
					r.o.die();
				} else {
					me.x = ox;
					me.y = oy; // 恢复旧坐标
				}
			} else if ( me.type == TYPE_MI ) {
				r.o.gaixue( -(me.gong-def[r.o.fang]));
				me.die();
				if ( r.o.type == TYPE_QI ) {
					bf("di.wav");
				} else if ( r.o.type == TYPE_WO ) {
					bf("hits.wav");
				} else if ( r.o.type == TYPE_MM ) {
					bf("hitcmd.wav");
					bf("hithe.wav");
				}
			}
		}
	}

	this.die = function() {
		me.hp = 0;
		st.remove(me);
		clearInterval(me.moveTimer);
		clearInterval(me.ctrlTimer);
		me.siwang();
	}

	this.boom = function() {
		var bm = new Boom(me);
	}

	this.gaixue = function(n) {
		me.hp += n;
		me.hp = me.hp > 100 ? 100 : me.hp;
		if(me.hp <= 0) {
			me.die();
		}
	}
	
	this.blood = function() {
		if ( me.type == TYPE_DR || me.type == TYPE_WO 
		  || me.type == TYPE_FJ || me.type == TYPE_QI 
		  || me.type == TYPE_MM ){
			if ( me.hp > 80 ) {
				g.fillStyle = "springgreen";				
			} else if ( me.hp > 60 ){
				g.fillStyle = "yellow";
			} else if ( me.hp > 40 ){
				g.fillStyle = "orange";
			} else {
				g.fillStyle = "red";
			}
			g.fillRect(me.x, me.y - 5, me.hp / 100 * me.w, 5);
		}
	}

	this.fire = function() {} // 开火行为
	this.eat = function(e) {} // 吃道具行为
	this.shenggong = function() {}
	this.shengfang = function() {}
	this.huantu = function() {}
	this.toudan = function() {}
	this.siwang = function() {} // 每个对象的死亡方法
	
	st.add(this);	// 创建成功就放进集合
}