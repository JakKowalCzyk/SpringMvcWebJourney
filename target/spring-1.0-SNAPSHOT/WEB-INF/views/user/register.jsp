<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DK
  Date: 2016-01-13
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form name="input" method="post" action="user">
        Username: <input type="text" name="name"><br/>
        Password: <input type="password" name="password"><br/>
        Email: <input type="text" name="email"><br/>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
