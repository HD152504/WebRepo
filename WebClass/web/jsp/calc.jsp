<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-09-19
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<form>
    <input type="number" name="num" min="1" required>
    <button type="submit">계산</button>
</form>
<%

    String a = request.getParameter("num");

    if (a != null) {
        int num = Integer.parseInt(request.getParameter("num"));

        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }

//        if (sum != 0) {
//            out.print("<h1>1 ~ " + num + "까지의 합은 " + sum + "입니다.");
//        }

    if (sum != 0) {
%>
<h1>1 ~ <%= num %>까지의 합은 <%= sum %>입니다.</h1>
<%
        }
    }

    // 현재 일시 구하기
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");

%>

현재 일시는 <%= sdf.format(new Date()) %>






</body>
</html>
