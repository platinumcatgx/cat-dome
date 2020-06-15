<%--
  Created by IntelliJ IDEA.
  User: Gx
  Date: 2020/4/2
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件传输</title>
</head>
<body>
<a href="msg/ok.jsp">msg/ok</a>
<br><br>
<br><br>
<br><br>


<form action="user/f1" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="file" />
    <input type="submit" value="提交" />
</form>
<br><br>
<form action="user/f2" method="post" enctype="multipart/form-data">
    选择文件: <input type="file" name="file" />
    <input type="submit" value="提交" />
</form>

<br><br>
<h3>跨服务器文件上传</h3>

<form action="user/f3" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="upload" /><br/>
    <input type="submit" value="上传" />
</form>

</body>
</html>
