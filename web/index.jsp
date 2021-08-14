<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Northstreet Restaurant">
    <meta name="author" content="A.K.">

    <title>Restaurant Northstreet</title>


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <!-- Custom Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Leckerli+One" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="style.css" type="text/css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="js/jquery-3.6.0.min.js"></script>

</head>
<style>

    html, body {
        overflow-x: hidden;
        font-family: 'Lato', sans-serif;
        width: 100%;

    }

    a {
        text-decoration: none;
    }

    ul {
        list-style-type: none;
    }

    a:hover,
    a:focus {
        text-decoration: none;
    }


    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
        text-transform: none;
        font-weight: 600;
        font-family: 'Lato', sans-serif;
        text-align: center;
    }

    hr {
        border-color: #ffc266;
        border-width: 5px;
        max-width: 100%;
    }


    .container-h1 {
        font-family: 'Lora', serif;
        text-align: center;
        font-size: 50px;
        font-weight: 700;
        margin: 50px auto;
        color: #333;
        font-family: 'Ubuntu', sans-serif;

    }

    .btn {
        color: #fff;
        background-color: #182c39;
        margin: 20px auto;
        border-radius: 0;
        font-weight: 500;
        display: table;
        padding: 10px;


    }

    .btn:hover{
        color: #182c39;
        background-color: transparent;
        border: 1px solid #182c39;
    }


    .hr-h3s {
        border: 3px solid #E94B3C;
        width: 70px;
        margin: 0 auto 35px auto;
    }


    textarea {
        resize: none;
    }

    section {
        align-items: center;
        padding: 50px 60px;

    }
    .bg-section h2 {
        font-family: 'Montserrat', sans-serif;
        text-transform: none;
        color: #ffc266;
        background-color: #182c39;
        margin: 50px 0;
        padding: 25px 20px;
        border-radius: 50px;
    }

    .slideanim {
        visibility: hidden;
    }

    .slide {
        animation-name: slide;
        -webkit-animation-name: slide;
        -moz-animation-name: slide;
        animation-duration: 1.5s;
        -webkit-animation-duration: 1.5s;
        -moz-animation-duration: 1.5s;
        visibility: visible;

    }
    @keyframes slide {
        0% {
            opacity: 0;
            transform: translateX(50%);
        }

        100% {
            opacity: 1;
            transform: translateX(0%);
        }
    }

    @-webkit-keyframes slide {
        0% {
            opacity: 0;
            -webkit-transform: translateX(50%);
            transform: translateX(50%);
        }

        100% {
            opacity: 1;
            -webkit-transform: translateX(0%);
            transform: translateX(0%);
        }
    }


    /*  ******* Header + Navigation ******* */

    .navbar {
        background-color: #182c39;
        border-color: rgb(51, 17, 0);
        border-color: rgba(51, 17, 0, 0.2);
        font-family: ;
        font-weight: 700;
        padding: 15px 0;
        transition: padding .5s;
    }

    .navbar .navbar-brand {
        color: #fff;
        font-family: 'Leckerli One', cursive;
        font-weight: 500;
        text-transform: none;
        font-size: 25px;
        padding-left: 15px;
        text-shadow: black 0.3em 0.3em 0.3em;
    }

    .navbar .navbar-brand:hover,
    .navbar .navbar-brand:focus {
        color: #ffc266;
        transition: color 1s;
    }

    .navbar .navbar-nav {
        padding-right: 50px;
    }

    .navbar .navbar-nav > li > a {
        text-transform: uppercase;
        font-weight: 600;
        font-size: 14px;
        color: #fff;
        margin: auto 5px;
        font-family: 'Lato', sans-serif;
        text-shadow: #222 0.3em 0.3em 0.3em;
    }

    .navbar .navbar-nav > li > a:hover,
    .navbar .navbar-nav > li > a:focus:hover {
        color: #ffc266;
        transition: color 1s;
    }


    .navbar .navbar-nav > li.active > a:hover,
    .navbar .navbar-nav > li.active > a:focus:hover {
        background-color: transparent;
    }

    .navbar.scrolled {
        box-shadow: 0 3px 3px rgba(0,0,0,0.1);
        padding: 5px 0;
        opacity: 0.9;
    }

    .jumbotron {
        margin-bottom: 0px;
        background-image: url('https://res.cloudinary.com/dbte0ueti/image/upload/v1536951689/new/jumbotron.jpg');
        background-position: 0% 25%;
        background-size: cover;
        background-repeat: no-repeat;
        color: white;
        text-shadow: black 0.3em 0.3em 0.3em;
        height: 700px;
    }


    .jumbotron .header-content-inner {
        font-weight: 700;
        text-transform: none;
        margin-bottom: 0;
        margin: 200px;
        font-family: 'Roboto', sans-serif;
    }

    .jumbotron h1 {
        font-size: 45px;
    }

    .jumbotron h3 {
        font-size: 25px;
    }


</style>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">


<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
    <a class="navbar-brand" href="#">Restaurant Northstreet</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a href="login.jsp">login</a>
            </li>
            <li class="nav-item">
                <a href="allMenu.jsp">menu</a>
            </li>
            <li class="nav-item">
                <a href="register.jsp">  register</a>
            </li>
            <li class="nav-item">
                <a href="bookATable.jsp">  bookATable</a>
            </li>
        </ul>
    </div>
</nav>

<div class="jumbotron">
    <div class="container-fluid">
        <div class="header-content-inner">
            <h1>Welcome to Northstreet restaurant</h1>
            <h3>We are proud of our long history of making delicious meals, warm and
                friendly atmosphere and professional staff.</h3>
        </div>
    </div>
</div>



<script src="script.js"></script>

<script>
    /* Navbar scroll */
    $(function(){

        var nav = $('.navbar'),
            doc = $(document),
            win = $(window);

        win.scroll(function() {

            if (doc.scrollTop() > 80) {
                nav.addClass('scrolled');
            } else {
                nav.removeClass('scrolled');
            }

        });

        win.scroll();

    });


    /* ***** Btn More-Less ***** */
    $("#more").click(function(){
        var $this = $(this);
        $this.toggleClass('more');
        if($this.hasClass('more')){
            $this.text('More');
        } else {
            $this.text('Less');
        }
    });




    /* ***** Slideanim  ***** */
    $(window).scroll(function() {
        $(".slideanim").each(function(){
            var pos = $(this).offset().top;

            var winTop = $(window).scrollTop();
            if (pos < winTop + 600) {
                $(this).addClass("slide");
            }
        });
    });




    /* ***** Smooth Scrolling  ***** */
    $(document).ready(function(){
        $(".navbar a, #service a").on('click', function(event) {

            if (this.hash !== "") {
                event.preventDefault();
                var hash = this.hash;

                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 900, function(){

                    window.location.hash = hash;
                });
            }
        });


        /* ***** Scroll to Top ***** */
        $(window).scroll(function() {
            if ($(this).scrollTop() >= 300) {
                $('.to-top').fadeIn(200);
            } else {
                $('.to-top').fadeOut(200);
            }
        });
        $('.to-top').click(function() {
            $('.body,html').animate({
                scrollTop : 0
            }, 500);
        });

    })

</script>


</body>


</html>
