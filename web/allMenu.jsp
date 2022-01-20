<%@ page import="model.Menu" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 20.01.2022
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%List<Menu> menus = (List<Menu>) request.getAttribute("menu");%>

    <table border="1">
        <tr>
            <th>name</th>
            <th>surname</th>
        </tr>
        <% for (Menu menu : menus) {%>
        <tr>
            <td><%=menu.getName()%>
            </td>
            <td><%=menu.getDescription()%>
            </td>
        </tr>
        <%}%>

</table>

</body>
</html>
