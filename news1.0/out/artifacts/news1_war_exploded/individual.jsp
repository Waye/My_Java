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
    <title>individual</title>
    <link rel="stylesheet" type="text/css" href="image/styles.css">
</head>
<body>
<form method="post" action="IndividualServlet">
        <textarea name="post" cols="45" rows="5">post a news, just a try!!</textarea>
        <br>
        <input type="submit" value="submit">
</form>
<form method="post" action="ExitServlet">
    <input type="submit" value="sign out" name="button">
    <input type="submit" value="delete account" name="button">
</form>

</body>
</html>

