<%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 07.08.2021
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>login</h1>
<form action="/login" method="post">
    email: <input type="text" name="email">
    password: <input type="password" name="password">
    <input type="submit" value="login">
<%request.getSession().setAttribute("msg","wrong email or pssword");%>
</form>
</body>
</html>
