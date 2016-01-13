<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: DK
  Date: 2016-01-13
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel</title>
</head>
<body>
<div class="container">
    <div style="float:right;margin-top: -30px">
        <c:choose>
            <c:when test="${empty loggedInUser.name}">
                <a href="logout">Logout</a>
            </c:when>
            <c:otherwise>
                Hello ${loggedInUser.name}! &nbsp;
                <a href="/logout">Logout</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<h2>Welcome to your profile</h2>
</body>
</html>
