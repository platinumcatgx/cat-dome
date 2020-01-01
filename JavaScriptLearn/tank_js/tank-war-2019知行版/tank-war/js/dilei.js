
function Dilei() {
	var x = wo.x + (wo.w - DJSIZE)/2;
	var y = wo.y + (wo.h - DJSIZE)/2;
	var o = new Base(x, y, DJSIZE, DJSIZE, TYPE_DL, "img/x10.gif");
	o.n = 10;	// 表示地雷
	return o;
}
