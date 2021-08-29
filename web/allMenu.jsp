<%@ page import="model.Menu" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 13.08.2021
  Time: 0:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%List<Menu> menu = (List<Menu>) request.getAttribute("menu");%>
<form action="/addMenu" method="get">
    <div>


        name:
        <textarea></textarea>


    </div>


</form>
</body>
</html>
