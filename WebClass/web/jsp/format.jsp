<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-27
  Time: 오전 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("price", 1000000);
%>

<c:set var="price" value="1000000"/>

${ price } <br>

<fmt:formatNumber value="${ price }" type="number"/> <br>
<fmt:formatNumber value="${ price }" type="percent"/> <br>
<fmt:formatNumber value="${ price }" type="currency"/> <br>

<c:set var="now" value="<%= new java.util.Date() %>"/>

<%--full, medium, short--%>

<fmt:formatDate value="${now}" type="date" dateStyle="full"/>
<fmt:formatDate value="${now}" type="time" timeStyle="medium"/>
<fmt:formatDate value="${now}" type="both" pattern="yyyy/MM/dd hh:mm:ss"/>

</body>
</html>
