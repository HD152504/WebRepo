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
<link rel="stylesheet" href="../css/bulletin.css">
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
<body style="background-image: none;">
<%@ include file="navbarContent.jsp" %>

<%@ include file="loginModal.jsp" %>

<%@ include file="signupModal.jsp" %>

<%@ include file="loginchkModal.jsp" %>

<%@ include file="signupchkModal.jsp" %>

<%@ include file="modal.jsp"%>

<%@ include file="footer.jsp"%>

<table class="table" width="60%">
    <thead class="thead-light">
    <tr>
        <th scope="col">#</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">내용</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>

    <c:if test="${ list != null }">
        <c:forEach var="varlist" items="${ list }" varStatus="status">
            <tr>
                <td>${ status.count }</td>
                <td>${ varlist.title }</td>
                <td>${ varlist.author  }</td>
                <td>${ varlist.text }</td>
                <td>${ varlist.date }</td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
<button class="btn-outline-dark" onclick="location.href='${contextPath}/myblog/inputbulletin.jsp';" style="padding: 0.5% 2%; float: right; margin-right: 2%; border-radius: 3px;">글쓰기</button>
</body>
</html>
