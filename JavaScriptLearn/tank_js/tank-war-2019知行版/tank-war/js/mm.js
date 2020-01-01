
function Meimei(x, y, w, h) {
	var o = new Base(x, y, w, h, TYPE_MM, "img/p1.gif");
	o.fang = 3;
	o.siwang = function(){
		o.boom();		// 爆炸特效
		stat = zt[4];
		wo.fuhuo = 0;	// 没收复活机会
		wo.die();		// 都死了
	}
	return o;
}
