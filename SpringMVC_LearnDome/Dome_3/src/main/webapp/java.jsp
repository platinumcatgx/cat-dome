<%--
  Created by IntelliJ IDEA.
  User: Gx
  Date: 2020/4/2
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
    <script>
        // 页面加载，绑定单击事件
        $(function () {
            $("#btn").click(function () {
                // alert("hello btn");
                // 发送ajax请求
                $.ajax({
                    // 编写json格式，设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123","age":30}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });

            });
            $("#btn2").click(function () {
                $.ajax({
                    url: "user/testAjax2",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"hehe","password":"123","age":30}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                })
            })
        });

    </script>
</head>
<body>


<button id="btn">
    发送AJXS请求
</button>

<button id="btn2">
    发送AJXS请求
</button>


</body>
</html>
