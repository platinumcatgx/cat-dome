function Wall(x, y) {
	// 理解为Wall函数继承Base函数
	var o = new Base(x, y, WALLSIZE, WALLSIZE, TYPE_QI, "img/qiang.gif");

	return o;
}