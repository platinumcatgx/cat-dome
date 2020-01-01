
function Missile(tk){
	var x = tk.x,		y = tk.y;
	if ( tk.dir == U ){
		x += tk.w / 2 - 2; 	y -= 17;
	} else if ( tk.dir == R ){
		x += tk.w + 2; 	y += tk.h / 2 - 2;
	} else if ( tk.dir == L ){
		x -= 14; 			y += tk.h / 2 - 3;
	} else if ( tk.dir == D ){
		x += tk.w / 2 - 3; 	y += tk.h - 1;
	}
	
	if ( tk.dir == D ) {
		if ( tk.gong == 0 ){
			x += 1;
		} else if ( tk.gong == 3 ){
			x -= 2;
		} else if ( tk.gong == 4 ){
			x -= 3;
		}
	} else if ( tk.dir == U ) {
		if ( tk.gong == 1 ){
			x -= 1;
		} else if ( tk.gong == 2 ){
			x -= 2;
		} else if ( tk.gong == 3 ){
			x -= 3;  y -= 3;
		} else if ( tk.gong == 4 ){
			x -= 4;  y -= 8;
		}
	} else if ( tk.dir == L ) {
		if ( tk.gong == 3 ){
			x -= 5;  y -= 1;
		} else if ( tk.gong == 4 ){
			y -= 2;	x -= 10;
		}
	} else if ( tk.dir == R ) {
		if ( tk.gong == 2 ){
			y -= 1;
		} else if ( tk.gong == 3 ){
			y -= 2;
		} else if ( tk.gong == 4 ){
			y -= 4;
		}
	}
	
	var w = 0, h = 0;
	w = tk.dir == U || tk.dir == D ? z1[tk.gong] : z2[tk.gong];
	h = tk.dir == U || tk.dir == D ? z2[tk.gong] : z1[tk.gong];
	var o = new Base(x, y, w, h, TYPE_MI, "img/m" + tk.gong + tk.dir + ".png");
	o.dir = tk.dir;
	o.gong = atk[tk.gong];	// 伤害点数
	o.tank = tk;			// 发射者
	o.left  = tk.dir == L;
	o.right = tk.dir == R;
	o.up 	= tk.dir == U;
	o.down  = tk.dir == D;
	o.speed = 15;
	o.moveTimer = setInterval( function() { o.move();} , 30);
	return o;
}


function MissileBig(tk){
	var x = tk.x,		y = tk.y;
	if ( tk.dir == U ){
		x += tk.w / 2 - 2; 	y -= 17;
	} else if ( tk.dir == R ){
		x += tk.w + 2; 	y += tk.h / 2 - 2;
	} else if ( tk.dir == L ){
		x -= 14; 			y += tk.h / 2 - 3;
	} else if ( tk.dir == D ){
		x += tk.w / 2 - 3; 	y += tk.h - 1;
	}
	
	if ( tk.dir == D ) {
		if ( tk.gong == 0 ){
			x += 1;
		} else if ( tk.gong == 3 ){
			x -= 2;
		} else if ( tk.gong == 4 ){
			x -= 3;
		}
	} else if ( tk.dir == U ) {
		if ( tk.gong == 1 ){
			x -= 1;
		} else if ( tk.gong == 2 ){
			x -= 2;
		} else if ( tk.gong == 3 ){
			x -= 3;  y -= 3;
		} else if ( tk.gong == 4 ){
			x -= 4;  y -= 8;
		}
	} else if ( tk.dir == L ) {
		if ( tk.gong == 3 ){
			x -= 5;  y -= 1;
		} else if ( tk.gong == 4 ){
			y -= 2;	x -= 10;
		}
	} else if ( tk.dir == R ) {
		if ( tk.gong == 2 ){
			y -= 1;
		} else if ( tk.gong == 3 ){
			y -= 2;
		} else if ( tk.gong == 4 ){
			y -= 4;
		}
	}
	
	var w = 0, h = 0;
	w = tk.dir == U || tk.dir == D ? z1[4] : z2[4];
	h = tk.dir == U || tk.dir == D ? z2[4] : z1[4];
	var o = new Base(x, y, w, h, TYPE_MI, "img/m4" + tk.dir + ".png");
	o.dir = tk.dir;
	o.gong = 101;			// 伤害点数
	o.tank = tk;			// 发射者
	o.left  = tk.dir == L;
	o.right = tk.dir == R;
	o.up 	= tk.dir == U;
	o.down  = tk.dir == D;
	o.speed = 15;
	o.moveTimer = setInterval( function() { o.move();} , 20);
	return o;
}
