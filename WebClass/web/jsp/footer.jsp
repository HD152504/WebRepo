<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-09-21
  Time: 오후 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" %>
<%@ page import = "java.util.Calendar" %>
<%
    Calendar c = Calendar.getInstance();
%>
<footer class="footer">
    <div class="container">
        <span class="text-muted">&copy; <%= c.get(Calendar.YEAR) %> mycompany.com</span>
    </div>
</footer>

