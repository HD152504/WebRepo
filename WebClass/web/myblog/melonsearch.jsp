<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-22
  Time: 오후 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<%--<link rel="stylesheet" href="../css/master.css">--%>
<link rel="stylesheet" href="../css/melonsearch.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script src="../js/indexControl.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<div class="melonsearch">
<form action="/melon.do" id="melonform" method="post">

    <button type="button" style="width: 10%;" onclick="location.href = '${contextPath}/myblog/index.jsp';" class="btn btn-outline-dark searchbtn" id="homebutton">홈</button>

    <div style="margin-top: 15%; margin-left: 20%; padding: 5%;">
    <select id="class" class="custom-select" name="chartchoice" style="width: 50%;">

        <option value="" selected>선택</option>
        <option value="1">실시간 차트</option>
        <%--<option value="2">일간 차트</option>--%>


    </select>
        <br><br><br><br>
        <div style="float: right; margin-right: 55%; width: 10%">
    <button type="submit" style="width: 150%;" class="btn btn-outline-dark searchbtn">검색</button>
        </div>
    </div>

</div>
</form>
</div>

<script>
    $(function () {
        var width = $('#homebutton').width();
        $('#homebutton').css('left', 'calc(30% - ' + width/2 + 'px)');
    });

    $(window).resize(function () {
        var width = $('#homebutton').width();
        $('#homebutton').css('left', 'calc(30% - ' + width/2 + 'px)');
    });
</script>
</body>
</html>
