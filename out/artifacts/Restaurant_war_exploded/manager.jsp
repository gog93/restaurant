<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Menu" %>
<%@ page import="model.BookATable" %><%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 08.08.2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<li class="nav-item">
    <a href="addMenu.jsp"> addMenu</a>
</li>

<form action="/logout" method="get">
    <a href="/">logOut</a>
</form>

<%List<User> user = (List<User>) request.getAttribute("user");%>
<%List<BookATable> bookATable = (List<BookATable>) request.getAttribute("bookATable");%>

<div>
    <div>
        <h1>ADD MENU</h1>
        <form action="/addMenu" method="post">
            <h1>add Menu</h1>
            name<input type="text" name="name">
            description<input type="text" name="description">
            <input type="submit" name="addMenu">
        </form>
    </div>
    <div>ALL USERS<BR>
        <table border="1">
            <tr>
                <th>name</th>
                <th>surname</th>
            </tr>
            <% for (User users : user) {%>
            <tr>
                <td><%=users.getName()%>
                </td>
                <td><%=users.getSurname()%>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
    <br>

    <div>BOOKATABLE<br>
        <table border="1">
            <tr>
                <th>number</th>
                <th>date</th>
                <th>userId</th>
            </tr>
            <% for (BookATable bookATables : bookATable) {%>
            <tr>
                <td><%=bookATables.getNumber()%>
                </td>
                <td><%=bookATables.getDate()%>
                </td>
                <td><%=bookATables.getUser()%>
                </td>
            </tr>
            <%}%>
        </table>
    </div>


</div>

</body>
</html>
