<%--
  Created by IntelliJ IDEA.
  User: Gx
  Date: 2020/3/31
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="background-color: #303c3f;" >
    <a href="index2.jsp">index2</a>
    <a href="index3.jsp">index3</a>
    <a href="index4.jsp">index4</a>
</div>

<div style="background-color: aquamarine">
    <a href="user/t1?username=java">t1</a>

    <form action="user/t2" method="post">
        <%--传递Javabean类型普通属性--%>
        <p>username</p>
        <input type="text" username="username"/>
        <p>age</p>
        <input type="text" username="age"/>

        <%--引用类型--%>
        <p>User2引用</p>
        <p>user2.username</p>
        <input type="text" username="user2.username">
        <p>user2.age</p>
        <input type="text" username="user2.age">

        <%--传递集合类型属性--%>
        <p>集合类型</p>
        <p>list[0]</p>
        <input type="text" username="list[0]"/><br/>

        <p>MAP集合</p>
        <p>map['kayName'].username</p>
        <input type="text" username="map['kayName'].username"/>
        <p>map['kayName'].age</p>
        <input type="text" username="map['kayName'].age"/>

        <input type="submit" value="t2">
    </form>

    ///////////////////////////////////

    <form action="user/t3" method="post">
        <input type="text" username="date"/>
        <input type="submit" value="提交"/>
    </form>


</div>

</body>
</html>
