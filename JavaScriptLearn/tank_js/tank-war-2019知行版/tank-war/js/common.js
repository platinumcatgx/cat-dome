var bu = document.createElement("canvas");
bu.style.position = "absolute";
bu.width = screen.width * 0.85;
bu.height = screen.height * 0.8;
bu.style.left = (screen.width-bu.width) / 2 + "px";
bu.style.border = "1px solid red";
document.body.appendChild(bu);

var g = bu.getContext("2d");	// 取得布的画笔

/**全局变量定义区 start**/
var TYPE_DR = "敌军";
var TYPE_WO = "我军";
var TYPE_FJ = "飞机";
var TYPE_MM = "美女";
var TYPE_QI = "墙块";
var TYPE_DJ = "道具";
var TYPE_DL = "地雷";
var TYPE_ZD = "炸弹";
var TYPE_MI = "子弹";
var TYPE_TP = "图片";
var INDEX = 0;			// 物体编号器
var U = "U",	D = "D",	L = "L",	R = "R";
var atk = [12, 17, 24, 33, 43];
var def = [0,  2,  5,   8, 10];
var WALLSIZE = 30;
var TANKSIZE = 40;
var PLANESIZE = 60;
var LEIWANGW = 40;
var LEIWANGH = 21;
var DJSIZE = 25;
var wallcount = 25;			// 墙数量
var tankcount = 20;			// 敌军初始数量
var z1	  = [4, 6, 8, 10, 12];
var z2 	  = [10,12,15,19, 22];
var jianmie = 0;			// 统计被击毙的敌军数量
var zt = ["未开始", "激战", "冰冻", "被冰冻", "失败", "胜利", "待复活", "暂停", "无敌"];
var stat = zt[0];
var yincang = false;		// 是否隐藏开始提示
var yincangTimer = null;	// 定时器控制隐藏变量
yincangTimer = setInterval( function(){ yincang = !yincang;} , 400);
var fhdjs = 9;				// 复活倒计时长
var fhdjsTimer = null;		// 复活倒计时的定时器
var overy = bu.height + 40;
var qarray = [];			// 定义一个动态数组存放家的墙
var oldstat	= stat;			// 当前状态被改前的保存者
var statTimer = null;		// 冰冻状态定时器
var sj = 5;					// 冰冻时长5秒
var fjTimer = null;			// 出现飞机的定时器
var pauseStat = null;		// 暂停前游戏当前状态
var jifen = 0;				// 打死坦克+10,精英+15,飞机+20
var winTimer = null;
/**全局变量定义区end**/