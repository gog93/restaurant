<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <title></title>
</head>
<body>
<a href="bookATable.jsp">bookATable</a>
<form action="/logout" method="get">
    <a href="/">logOut</a>
</form>

<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
            </div>

            <div class="modal-body">
                <p>You are about to delete one track, this procedure is irreversible.</p>
                <p>Do you want to proceed?</p>
                <p class="debug-url"></p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
        <table class="table table-striped custab">
            <thead>
            <a href="/bookATable" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new BookATable</a>
            <tr>
                <th>1</th>
                <th>number</th>
                <th class="text-center">date</th>
            </tr>
            </thead>

            <c:forEach var="bookATable" items="${requestScope.get('bookATables')}">

                <tr>
                    <td><c:out value="${bookATable.number()}"/>
                    </td>
                    <td><c:out value="${bookATable.date}"/>
                    </td>
                    <td><a href="/updateBookATable=<c:out value="${bookATable.id}" />">Update</a> |
                        <a href="#"
                           data-href="/deleteBookAtable=<c:out value="${bookATable.id}" />"
                           data-toggle="modal"
                           data-target="#confirm-delete">Delete</a></td>
                </tr>

            </c:forEach>

        </table>
    </div>
</div>

<script>
    $('#confirm-delete').on('show.bs.modal', function (e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
        $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
    });
</script>
</body>
</html>
