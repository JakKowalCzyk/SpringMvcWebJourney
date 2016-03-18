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
    <div style="float:right;margin-top: auto">
        <a href="logout">Logout</a><br/>
    </div>
</div>
<br/>
<br/>
<h2>Welcome to your profile</h2>
<form action="/user/userPanel" method="post">
    <button id="addButton" class="form-control">Add new journey</button>
    <%--<a href="/addJourney" >Add new journey</a>--%>
</form>
<h3>
    See / delete journey nr:
    <table>
        <tr>
            <td width="50">Id</td>
            <td width="50"></td>
            <td width="50"></td>
        </tr>
        <tr>
            <c:forEach items="${numberList}" var="number">
        <tr>
            <td><c:out value="${number}"/><input type="hidden" name="id"></td>
            <%--<form action="/showJourney" method="post">--%>
        <form action="/userPanel" method="post">
            <input type="hidden" name="number" value="${number}"/>
            <td><input type="submit" value="See"/></td>
        </form>
        <form action="/userPanelRemove" method="post">
            <input type="hidden" name="number" value="${number}"/>
            <td><input type="submit" value="Remove"/></td>
        </form>
            <%--</form>--%>
        </tr>
        </c:forEach>
        </tr>
    </table>
</h3>
</body>
</html>
