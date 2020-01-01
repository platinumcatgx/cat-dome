
function Zhadan(f){
	var x = f.x;
	var y = f.y;
	var src = "img/daodan" + f.dir + ".png";
	var w = f.dir == L || f.dir == R ? LEIWANGW : LEIWANGH;
	var h = f.dir == L || f.dir == R ? LEIWANGH : LEIWANGW;
	if ( f.dir == L ){
		x += f.w - 10; 			y += (f.h - h) / 2;
	} else if ( f.dir == R ){
		x -= w + 10; 			y += (f.h - h) / 2;
	} else if ( f.dir == U ){
		x += (f.w - w) / 2; 	y += f.h - 10;
	} else if ( f.dir == D ){
		x += (f.w - w) / 2; 	y -= h + 10;
	}
	var o = new Base(x, y, w, h, TYPE_ZD, src);
	o.resize = 0;
	o.moveTimer = setInterval(function(){
		if ( stat == zt[7] ) return;
		o.w = o.w * 0.9;	o.h = o.h * 0.9;
		o.resize ++;
		if ( o.resize >= 12 ){
			o.die();
		}
	} ,100);
	
	o.siwang = function(){
		o.w = 50; o.h = 50;	o.x -= 20;	o.y -= 20;
		o.shanghai();
		o.boom();
		bf("zhahui.wav");
	}
	o.shanghai = function(){
		var list = st.list;
		for ( var i = 0; i < list.length; i ++){
			var e = list[i];
			if ( hitForRectangle(o, e) ){
				var n = parseInt(Math.random()*36) + 60; 
				e.gaixue(-n);
			}
		}
	}
	return o;
}


function ZhadanBig(x, y){
	var src = "img/daodanU.png";
	var w = 150;
	var h = 230;
	var o = new Base(x, y, w, h, TYPE_ZD, src);
	o.resize = 0;
	o.siwang = function(){
		o.boom();
		bf("zhahui.wav");
	}
	return o;
}
