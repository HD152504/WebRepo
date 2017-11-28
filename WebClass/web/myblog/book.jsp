<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-28
  Time: 오전 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
<html>
<head>
    <title>Title</title>
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
    <style>
        .footer {
            position: fixed;
            bottom: 0;
            width: 100%;
            /* Set the fixed height of the footer here */
            height: 60px;
            line-height: 60px; /* Vertically center the text there */
            background-color: #f5f5f5;
            /*margin: 60px 0;*/
        }
    </style>
</head>
<body style="overflow: auto !important;">
<%@ include file="navbarContent.jsp" %>

<%@ include file="loginModal.jsp" %>

<%@ include file="signupModal.jsp" %>

<%@ include file="loginchkModal.jsp" %>

<%@ include file="signupchkModal.jsp" %>

<%@ include file="modal.jsp"%>

<%@ include file="footer.jsp"%>

<table class="table" width="70%">
    <thead class="thead-light">
    <tr>
        <th scope="col">책 제목</th>
        <th scope="col">저자</th>
        <th scope="col">이미지</th>
        <th scope="col">가격</th>
        <th scope="col">책 정보 링크</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${ book != null }">
        <c:forEach var="booklist" items="${ book }" varStatus="index">
            <tr>
                <td>${ booklist.title }</td>
                <td>${ booklist.author }</td>
                <td><img src="${ booklist.image }" style="width: 80%;"/></td>
                <td>${ booklist.price }</td>
                <td><a href="${ booklist.link }" target="_blank">책 정보</a></td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${ book == null }">
        <tr>
            <td colspan="5">데이터가 없습니다.</td>
        </tr>
    </c:if>
    </tbody>
</table>

</body>
</html>
