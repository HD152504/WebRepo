<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-21
  Time: 오후 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="../css/master.css">--%>
    <link rel="stylesheet" href="../css/weather.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    <script src="../js/indexControl.js"></script>
    <title>Title</title>
</head>
<body>

<%--<%@ include file="navbarContent.jsp" %>--%>

<%--<%@ include file="loginModal.jsp" %>--%>

<%--<%@ include file="signupModal.jsp" %>--%>

<%--<%@ include file="loginchkModal.jsp" %>--%>

<%--<%@ include file="signupchkModal.jsp" %>--%>

<%--<%@ include file="modal.jsp"%>--%>

<%--<%@ include file="footer.jsp"%>--%>

<script>
    console.log(${weather});
</script>

<div id="weatherimg">
    <div class="weathercontainer">

        <div class="wthhead">
            <p class="result">날씨 검색 결과</p>
        </div>
        <hr>
        <div style="" class="wthimgcon">

            <img src="../image/${weather.skyCode}.png" class="weatherimg" alt="test" width="80%" >
            <div class="wthresult">
                <p>${place}</p>
                <p>현재 온도 : ${weather.curTemp}</p>
                <p>최고 온도 : ${weather.maxTemp}</p>
                <p>최저 온도 : ${weather.minTemp}</p>
                <p>습도 : ${weather.humidity}</p>
                <p>날씨 : ${weather.skyCodeName}</p>
                <p>관측 시간 : ${time}</p>
            </div>

        </div>
        <hr>
        <div class="wthfooter">
            <button type="button" onclick="location.href='${contextPath}/myblog/index.jsp'" class="btn btn-outline-dark" style="margin-right: 3%;">홈</button>
            <button type="button" class="btn btn-outline-dark" onclick="history.back();">뒤로</button>
        </div>
    </div>
</div>


</body>


<script>

//    $(window).load(function() {
//        var width = $('.weatherimg').width();
//        $('.weatherimg').css('left', 'calc(50% - ' + width/2 + 'px)');
//    });

    $(function () {
        var width = $('.weatherimg').width();
        $('.weatherimg').css('left', 'calc(50% - ' + width/2 + 'px)');
    });

    $(window).resize(function () {
        var width = $('.weatherimg').width();
        $('.weatherimg').css('left', 'calc(50% - ' + width/2 + 'px)');
    });



</script>

</html>
