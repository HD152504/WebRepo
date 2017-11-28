<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-21
  Time: 오후 10:37
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
    <link rel="stylesheet" href="../css/master.css">
    <link rel="stylesheet" href="../css/inputbulletin.css">
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

<%@ include file="navbarContent.jsp" %>

<%@ include file="loginModal.jsp" %>

<%@ include file="signupModal.jsp" %>

<%@ include file="loginchkModal.jsp" %>

<%@ include file="signupchkModal.jsp" %>

<%@ include file="modal.jsp"%>

<%@ include file="footer.jsp"%>
<div class="bulletincontainer">
<%--<div class="">--%>
<form class="form-control mr-sm-2" action="/weather.do" id="weatherForm" method="post">
        <div class="modal-header">
            <h4>날씨 검색</h4>
        </div>
        <div class="form-group" style="margin-top: 20px;">
            <label for="inputCity" class="loginlabel">시, 도</label><br>
            <input type="text" class="myinputD" id="inputCity" name="inputCity" placeholder="시, 도" required>
        </div>

        <div class="form-group">
            <label for="inputGu" class="loginlabel">군, 구</label><br>
            <input type="text" class="myinputD" id="inputGu" name="inputGu" placeholder="군, 구" required>
        </div>

        <div class="form-group">
            <label for="inputeup" class="loginlabel">읍, 면, 동</label><br>
            <input type="text" class="myinputD" id="inputEup" name="inputEup" placeholder="읍, 면, 동" required>
        </div>

        <div class="modal-footer">
            <button type="submit" class="btn btn-outline-dark">검색</button>
            <button type="button" class="btn btn-outline-dark" onclick="history.back();">뒤로</button>
        </div>

</form>
</div>
<c:if test="${error != null}">
    <script>
        <%-- 로그인이 실패한 경우 처리 추가 --%>
        var myModal = $('#myModal');
        myModal.find('.modal-title').text('Error');
        myModal.find('.modal-body').text('${error}');
        myModal.modal();
    </script>
</c:if>
</body>

</html>
