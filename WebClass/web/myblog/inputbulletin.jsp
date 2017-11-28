<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-21
  Time: 오후 4:37
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
<link rel="stylesheet" href="../css/master.css">
<link rel="stylesheet" href="../css/inputbulletin.css">
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
<link rel='stylesheet' href='//cdn.jsdelivr.net/font-kopub/1.0/kopubdotum.css'>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script src="../js/indexController.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="navbarContent.jsp" %>


<%@ include file="modal.jsp"%>

<%@ include file="footer.jsp"%>

<div class="bulletincontainer">
    <form class="bulletinform" action="${contextPath}/write.do" method="post">
        <div style="margin-bottom: 10px;">
            <label for="bulletintitle" class="bulletinlabel">제목</label><br>
            <textarea name="title" id="bulletintitle" class="" cols="3" rows="1"></textarea>
        <%--<input type="text" id="bulletintitle">--%>
        </div>
        <br><br>
        <label for="bulletintext" class="bulletinlabel">내용</label><br>
        <textarea name="text" id="bulletintext" class="" cols="3" rows="1"></textarea>
         <br>
        <button type="submit" class="btn-outline-dark" id="bulletinbutton">글쓰기</button>

    </form>
</div>

<script>
    <%--$(document).ready(function() {--%>
        <%--$('#bulletinform').submit(function () {--%>
            <%--// Stop form from submitting normally--%>
            <%--event.preventDefault();--%>

            <%--var title = $('#bulletintitle').val();--%>
            <%--var text = $('#bulletintext').val();--%>
            <%--console.log("title : " + title + " text : " + text );--%>

            <%--$.post("/write.do", { "title" :  title, "text" :  text},--%>
                <%--function(data) {--%>
                    <%--console.log(data.msg);--%>
                    <%--if(data.msg == 'success') {--%>
                        <%--location.href = "${ contextPath }/list.do";--%>
                    <%--} else if(data.msg == 'error') {--%>
                        <%--var myModal = $('#myModal');--%>

                        <%--myModal.find('.modal-title').text('Write Error');--%>
                        <%--myModal.find('.modal-body').text('게시글 등록시 오류가 발생하였습니다.');--%>
                        <%--myModal.find('.modal-body').text(data.error);--%>
                        <%--myModal.modal();--%>
                    <%--}--%>
                <%--});--%>
        <%--});--%>
    <%--});--%>

</script>

</body>
</html>
