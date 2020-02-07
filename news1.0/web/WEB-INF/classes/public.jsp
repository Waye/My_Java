<%--
  Created by IntelliJ IDEA.
  User: weiyihu
  Date: 2017-05-31
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>public</title>
    <link rel="stylesheet" type="text/css" href="image/styles.css">
    <script type="text/javascript" src="js/function.js"></script>
</head>
<body>
<% out.print((String)request.getSession().getAttribute("post"));%>
<form method="post" action="/PublicServlet">
    <textarea name="post" cols="45" rows="1">comment here</textarea>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
