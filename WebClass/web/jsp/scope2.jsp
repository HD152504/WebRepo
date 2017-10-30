<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-23
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Scope2</h1>

<form action="/scope" method="post">
    <input type="text" name="id">
    <input type="hidden" name="pwd" value="test">
    <button type="submit">전송</button>
</form>
<%--<%--%>
    <%--if(request.getParameter("id") != null) {--%>
<%--%>--%>

<h1>id : <%=request.getParameter("id")%></h1>
<h1>pwd : <%=request.getParameter("pwd")%></h1>
<h1>request scope : <%=request.getAttribute("key")%></h1>
<h1>session scope : <%=session.getAttribute("key")%></h1>
<h1>application scope : <%=application.getAttribute("key")%></h1>

<%--<%--%>
<%--    }--%>
<%--%>--%>

<hr>

<form action="jsp/scope2.jsp" method="post">
    <button type="submit">전송</button>
</form>

</body>
</html>
