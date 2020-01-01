var imgs = ["img/1.jpg", "img/2.jpg", "img/3.jpg", "img/4.jpg"]
var i = 0

function time() {
	var lbt = document.getElementById("lbt2")
	if (i == 4) i = 0
	lbt.src = "img/" + i + ".jpg"
	i++
}
setInterval(time, 2000)


function dw(str) {
	var input = document.getElementById(str)
	input.style.backgroundColor = "#c8caa0"

	switch (str) {
		case 'name':
			t(str, "支持数字,字母,下划线", "#3487FF")
			break;
		case 'pass':
			t(str, "支持数字,字母,下划线,长度为6位", "#3487FF")
			break;
		case 'pass2':
			t(str, "重复你的密码", "#3487FF")
			break;
		case 'zname':
			t(str, "输入你真实的姓名", "#3487FF")
			break;
		case 'nc':
			t(str, "输入合法的昵称", "#3487FF")
			break;
		case 'dh':
			t(str, "输入以13,15,18,16开头的有效手机号,长度11位", "#3487FF")
			break;
		case 'yx':
			t(str, "真实有效的邮箱", "#3487FF")
			break;
	}
}

function dw2(str) {
	var in_ = document.getElementById(str)
	in_.style.backgroundColor = "#FFFFFF"

	switch (str) {
		case 'name':
			t(str, "通信证不能为空", "red")
			break;
		case 'pass':
			t(str, "密码不能为空", "red")
			break;
		case 'pass2':
			t(str, "密码不能为空", "red")
			break;
		case 'zname':
			t(str, "真实姓名不能为空", "red")
			break;
		case 'nc':
			t(str, "昵称不能为空", "red")
			break;
		case 'dh':
			t(str, "电话不能为空", "red")
			break;
		case 'yx':
			t(str, "邮箱不能为空", "red")
			break;
	}
}

function t(id, str, color) {
	if (document.getElementById(id).value.length == 0) {
		var name_info = document.getElementById(id + "_info").innerHTML =
			"<font color='" + color + "' size='1' style='float: left;margin-left: 114px;'>" + str + "</fon>";
	} else if (document.getElementById(id).value.length > 0) {
		var name_info = document.getElementById(id + "_info").innerHTML =
			"<font color='#199d33' size='1' style='float: left;margin-left: 114px;'>" + "完成" + "</fon>";
	}
}

function tj() {
	var name_yz = false
	var name = document.getElementById("name").value
	if (name.search(/^[\w_]{3,16}$/)) name_yz = true

	var pass_yz = false
	var pass = document.getElementById("pass").value
	if (pass.search(/[a-zA-Z0-9_]{6}/)) pass_yz = true

	var pass2_yz = false
	var pass2 = document.getElementById("pass2").value
	if (pass.search(/[a-zA-Z0-9_]{6}/) && pass == pass2) pass_yz = true

	var xb1_yz = false
	var xb2_yz = false
	var xb = ""
	var xb1 = document.getElementsByName("xb")
	// console.log(xb)
	// console.log(xb1[0].checked)
	if (xb1[0].checked) {
		xb1_yz = true
		xb = "男"
	} else if (xb1[0].checked) {
		xb2_yz = true
		xb = "女"
	}

	var zname_yz = false
	var zname = document.getElementById("zname").value
	if (zname.search(/^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/)) zname_yz = true

	var nc_yz = false
	var nc = document.getElementById("nc").value
	if (nc.search(/^[\u4e00-\u9fa5a-zA-Z0-9_]+$/)) nc_yz = true

	var dh_yz = false
	var dh = document.getElementById("dh").value
	if (dh.search(/^1[3|5|8][0-9]{9}$/)) dh_yz == true

	var yx_yz = false
	var yx = document.getElementById("yx").value
	if (yx.search(/^\w+((.\w+)|(-\w+))@[A-Za-z0-9]+((.|-)[A-Za-z0-9]+).[A-Za-z0-9]+$/)) yx_yz = true
	console.log(name_yz == 0)
	console.log(pass_yz == 0)
	console.log(pass2_yz == 0)
	console.log(xb1_yz == true || xb2_yz == true)
	console.log(zname_yz == 0)
	console.log(nc_yz == 0)
	console.log(dh_yz == 0)
	console.log(yx_yz == 0)
	if (name_yz == 0 && pass_yz == 0 && pass2_yz == 0 && (xb1_yz == true || xb2_yz == true) && zname_yz == 0 && nc_yz == 0 &&
		dh_yz == 0 && yx_yz == 0) {
		alert("注册成功")
		return;
	}
	alert("信息是否有效?")

}
