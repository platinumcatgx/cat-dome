function mysubmit() {
	var name = document.getElementById("name").value;
	if (name.length == 0) {
		var name_info = document.getElementById("name_info").innerHTML = "<font color='red' size='1'>用户名为空</fon>";
	}
}
