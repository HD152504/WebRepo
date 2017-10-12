<%@ page import="org.dimigo.vo.UserVO" %><%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-12
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- navbar content -->
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand" href="index.jsp">My Blog</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample04">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="info.jsp">Info</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" onmouseover="mouseOn(this)" onmouseout="mouseOut(this)" href="Aboutme.jsp">About Me</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Etc</a>
                <div class="dropdown-menu" aria-labelledby="dropdown04">
                    <a class="dropdown-item" href="favorite.jsp">Favorite</a>
                    <a class="dropdown-item" href="Dream.jsp">Dream</a>
                    <a class="dropdown-item" href="bucketList.jsp">BucketList</a>
                </div>
            </li>
        </ul>
        <%
            UserVO user = (UserVO) session.getAttribute("user");
            if (user != null) {
        %>
        <ul class="navbar-nav flex-row ml-md-auto d-none d-md-flex">
            <li class="nav-item dropdown">
                <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <%= user.getName() %>님
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="bd-versions">
                    <form action="/bloglogout" method="post">
                        <button type="submit" class="dropdown-item">Sign out</button>
                    </form>
                    <div class="dropdown-divider"></div>
                    <button type="button" class="dropdown-item">Action1</button>
                    <button type="button" class="dropdown-item">Action2</button>

                </div>
            </li>
        </ul>
        <%
        } else {
        %>
        <form id="navForm" class="form-inline my-2 my-lg-0">
            <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#signInModal" id="loginB" type="button">Sign In</button>
            <button class="btn btn-outline-light my-2 my-sm-0" data-toggle="modal" data-target="#signUpModal" id="signUpB" type="button">Sign Up</button>
        </form>
        <%
            }
        %>
    </div>
</nav>

