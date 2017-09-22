<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-09-22
  Time: 오후 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Integer cnt = (Integer)session.getAttribute("cnt");
    if (cnt == null) {
        out.println("최초 호출");
        cnt = 0;
    }
    session.setAttribute("cnt", ++cnt);
%>
<h1>cnt : <%= cnt %></h1>

<%= request.getHeader("Cookie") %>

</body>
</html>
