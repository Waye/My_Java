<%--
  Created by IntelliJ IDEA.
  User: weiyihu
  Date: 2017-05-31
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="image/styles.css">
    <script type="text/javascript" src="js/function.js"></script>
</head>
<h3>Register, let's do it!!</h3>
<%
    //获取提示信息
    String info = (String)request.getAttribute("info");
    //如果提示信息不为空则，则输出提示信息
    if(info != null){
        out.println(info);
    }
%>
<body>
<form action="RegisterServlet" method="post" onsubmit="return fun(this)">
    username:<input type="text" name="username" size="25" >
    <br>
    password:<input type="password" name="password" size="25">
    <br>
    sex:<br>
    <input type="radio" name="sex" value="male" checked="checked">male
    <input type="radio" name="sex" value="female" >female
    <br>
    email:<input type="text" name="email" size="25" >
    <br>
    <input type="submit" value="submit">
    <input type="reset" value="reset">
    <input type="button" value="login" onclick="location.href='login.jsp'">
</form>
</body>
</html>
