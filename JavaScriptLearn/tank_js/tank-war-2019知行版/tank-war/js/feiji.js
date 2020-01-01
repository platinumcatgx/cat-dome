
function Feiji() {
	var dir = D;
	var n = parseInt(Math.random()*4);
	dir = n == 0 ? L : dir;
	dir = n == 1 ? U : dir;
	dir = n == 2 ? R : dir;
	var src = "img/f" + n + dir + ".png";
	var x = 0, y = 0;
	if ( dir == L ) {		// 从右向左飞
		x = bu.width;
		y = parseInt(Math.random()*(bu.height-120)) + 50;
	} else if ( dir == R ){	// 从左向右飞
		x = -PLANESIZE;
		y = parseInt(Math.random()*(bu.height-120)) + 50;
	} else if ( dir == U ){	// 从下向上飞
		x = parseInt(Math.random()*(bu.width-90)) + 20;
		y = bu.height;
	} else if ( dir == D ){	// 从上向下飞
		x = parseInt(Math.random()*(bu.width-90)) + 20;
		y = -PLANESIZE;
	}
	var o = new Base(x, y, PLANESIZE,PLANESIZE, TYPE_FJ, src);
	o.speed = 7;
	o.dir = dir;
	o.left 	= dir == L;
	o.right = dir == R;
	o.up 	= dir == U;
	o.down 	= dir == D;
	o.out = false;
	o.siwang = function(){
		if ( !o.out ){
			bf("bomb2.wav");
			o.boom();
			jifen += 20;
		}
	}
	o.moveTimer = setInterval( function(){
		if ( stat == zt[2] || stat == zt[7] ) return;
		o.move();
		var n = parseInt(Math.random()*100);
		if ( n % 11 == 0 ){
			n = parseInt(Math.random()*100);
			if ( n % 7 == 0 ){ o.toudan(); bf("hongzha.wav");}
		}
	} , 30);
	o.toudan = function(){
		new Zhadan(o);// 投弹
	}
	return o;
}
