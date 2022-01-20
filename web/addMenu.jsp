<%@ page import="model.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 18.01.2022
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%List<User> user = (List<User>) request.getAttribute("user");%>

    <div>
        <h1>ADD MENU</h1>
        <form action="/addMenu" method="get">
            <h1>add Menu</h1>
            name<input type="text" name="name">
            description<input type="text" name="description">
            <input type="submit" name="addMenu">
        </form>
    </div>

</body>
</html>
