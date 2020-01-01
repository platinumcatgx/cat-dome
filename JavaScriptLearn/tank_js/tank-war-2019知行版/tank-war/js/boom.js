function Boom(dieObj) {
	var o = new Base(dieObj.x, dieObj.y, dieObj.w, dieObj.h, TYPE_TP, "img/b0.gif");
	o.i = 0;
	o.bzTimer = setInterval(function() {
		o.i++;
		o.src = "img/b" + o.i + ".gif";
		if(o.i > 7) {
			clearInterval(o.bzTimer);
			o.die();
			if ( dieObj.type != TYPE_ZD ) {
				new Daoju(o);// 爆炸结束时，出现道具
			}
		}
	}, 100);
	return o;
}