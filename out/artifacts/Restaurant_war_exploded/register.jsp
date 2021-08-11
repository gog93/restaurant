<%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 07.08.2021
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>register</h1>
<form action="/register" method="post">
    name: <input type="text" name="name">
    surname: <input type="text" name="surname">
    email: <input type="text" name="email">
    password: <input type="password" name="password">
    <input type="submit" value="register">
</form>
</body>
</html>
