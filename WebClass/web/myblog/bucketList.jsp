<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-12
  Time: 오후 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Blog</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/master.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script src="../js/indexControl.js"></script>
</head>
<body>

<%@ include file="navbarContent.jsp" %>

<%@ include file="loginModal.jsp" %>

<%@ include file="signupModal.jsp" %>

<%@ include file="loginchkModal.jsp" %>

<%@ include file="signupchkModal.jsp" %>

<%@ include file="modal.jsp"%>

<!--콘텐츠-->

<div class="jumbotron" id="bucket">
    <h2 class="display-2">My BucketList</h2>
    <!--Carousel-->

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="../image/Uyuni.jpg" alt="First slide">
                <div class="carousel-caption d-none d-md-block">
                    <h3>First</h3>
                    <p>Uyuni Salt Dessert</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../image/traintravel.jpeg" alt="Second slide">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Second</h3>
                    <p>Train Travel!</p>
                </div>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../image/Festival.jpeg" alt="Third slide">
                <div class="carousel-caption d-none d-md-block">
                    <h3>Third</h3>
                    <p>I want to play during one Semester!!</p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <!--<div class="jumbodiv">-->
    <!--<h1 class="display-3">Hello, world!</h1>-->
    <!--<p class="lead">This is a webpage, which is made by noodleKim.</p>-->
    <!--<hr class="my-4">-->
    <!--<p>It uses utility classes for typography and spacing to space content out within the larger container.</p>-->

    <!--</div>-->
</div>



<footer class="footer">
    <div class="container">
        <span class="text-muted">Copyright 2017 by Noodle김</span>
    </div>
</footer>

</body>
</html>
