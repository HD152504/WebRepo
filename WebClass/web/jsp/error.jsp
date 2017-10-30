<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-10-24
  Time: 오전 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!Doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Exception : <%=exception.getClass().getName()%></h1>
<h1>Message : <%=exception.getMessage()%></h1>

</body>
</html>
