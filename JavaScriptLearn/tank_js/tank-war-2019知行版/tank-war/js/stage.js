function Stage() {
	this.list = []; // 声明一个动态数组
}

Stage.prototype.add = function(o) {
	this.list.push(o); // 把o对象放进集合中
}

Stage.prototype.remove = function(o) {
	var i = this.list.indexOf(o); // 找一找o在不在list中
	if(i != -1) {
		this.list.splice(i, 1); // 从第i位移除1个
	}
}

Stage.prototype.render = function() {
	var list = this.list;

	function loop() {
		// 背景绘制
		drawBackground();
		huatishi();huashuoming();
		if ( stat != zt[0] ) {
			huaxinxi();	huajifen();	
			huafhdjs();	huaover();	huasj();  win();
		}
		list.forEach(function(a) { a.show(); });
		requestAnimationFrame(loop); // 延迟一定时间调用
	}

	loop();
}

function drawBackground() {
	var img = new Image();
	img.src = "img/ditudark.jpg";
	g.drawImage(img, 0, 0, bu.width, bu.height);
}

function Logo(x, y, w, h){
	var o = new Base(x, y, w, h, TYPE_TP, "img/bg1.gif");
	return o;
}
