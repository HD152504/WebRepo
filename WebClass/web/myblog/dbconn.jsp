<%--
  Created by IntelliJ IDEA.
  User: lg
  Date: 2017-11-13
  Time: 오후 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JDBC Connection</h1>
<%
    Connection connection = null;
    Statement statement = null;

    try {
        String url = "jdbc:mysql://localhost:3306/iwadb";

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, "root", "root");
        statement = connection.createStatement();
        out.println("DataBase successfully opened.");


    } catch (Exception e) {
        out.println(e.getMessage());
    } finally {
        if(statement != null) statement.close();
        if(connection != null) connection.close();

    }

%>



</body>
</html>
