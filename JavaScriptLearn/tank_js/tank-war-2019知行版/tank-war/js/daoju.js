
function Daoju(tk) {
	var x = tk.x + (tk.w - DJSIZE)/2;
	var y = tk.y + (tk.h - DJSIZE)/2;
	var n = parseInt(Math.random()*10);
	//n = 2;
	var o = new Base(x, y, DJSIZE, DJSIZE, TYPE_DJ, "img/x" + n + ".gif");
	o.n = n;	//  道具区别在此
	return o;
}
