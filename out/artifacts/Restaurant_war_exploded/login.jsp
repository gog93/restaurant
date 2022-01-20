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
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <title>Title</title>
</head>

<body>

<form action="/login" method="get">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login via site</h3>
                    </div>
                    <div class="panel-body">
                        <form accept-charset="UTF-8" role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="yourmail@example.com" name="email"
                                           type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password"
                                           value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                    </label>
                                </div>
                                <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                            </fieldset>
                        </form>
                        <hr/>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
