<%@ page import="org.dimigo.vo.UserVO" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-09-28
  Time: 오후 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        UserVO user = (UserVO) session.getAttribute("user");
    %>
<h1>id : <%=user.getId()%></h1>
<h1>name : <%=user.getName()%></h1>
<h1>nickname : <%=user.getNickname()%></h1>
</body>
</html>
