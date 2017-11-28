<%@ page import="org.dimigo.vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-12
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
<!-- navbar content -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand"  href="${ contextPath }/myblog/index.jsp">IWA Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample04">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="${ contextPath }/myblog/info.jsp">Info</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="${ contextPath }/list.do">Bulletin Board</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="${ contextPath }/myblog/weathersearch.jsp">Weather</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="${ contextPath }/myblog/melonsearch.jsp">Melon Chart</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Etc</a>
                <div class="dropdown-menu" aria-labelledby="dropdown04">
                    <a class="dropdown-item" href="${ contextPath }/myblog/moviesearch.jsp">Movie Search</a>
                    <a class="dropdown-item" href="${ contextPath }/myblog/booksearch.jsp">Book Search</a>
                    <%--<a class="dropdown-item" href="${ contextPath }/myblog/mymenu.jsp">Third</a>--%>
                </div>
            </li>
        </ul>

        <c:if test="${ user != null}">

        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <li class="nav-item dropdown">
                <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    ${user.name}님
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
                    <form action="/logout.do" method="post">
                        <button type="submit" class="dropdown-item">Sign out</button>
                    </form>
                    <%--<div class="dropdown-divider"></div>--%>
                    <%--<button type="button" class="dropdown-item">Action1</button>--%>
                    <%--<button type="button" class="dropdown-item">Action2</button>--%>

                </div>
            </li>
        </ul>
        </c:if>
        <c:if test="${ empty user }">
            <script>
//                location.reload();
            </script>
        <form id="navForm" class="form-inline my-2 my-lg-0">
            <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#signInModal" id="loginB" type="button">Sign In</button>
            <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#signUpModal" id="signUpB" type="button">Sign Up</button>
        </form>
        </c:if>
    </div>
</nav>

