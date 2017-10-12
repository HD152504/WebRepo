<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-12
  Time: 오후 12:22
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
    <link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
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

<footer class="footer">
    <div class="container">
        <span class="text-muted">Copyright 2017 by Noodle김</span>
    </div>
</footer>

<!-- 콘텐츠 -->

<div class="jumbotron">
    <div class="jumbodiv">
        <h1 class="display-3">My Dream!</h1>
        <p class="lead">Living with Happy</p>
        <hr class="my-4">
        <p class="dreamText">Until now, I don't have something to be.<br>So I'm now trying best to get good grade.<br>And Also I want to eat many delicious food.</p>

    </div>
</div>


</body>
</html>