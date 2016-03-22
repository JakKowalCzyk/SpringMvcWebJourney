<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
         <%--pageEncoding="ISO-8859-1"%>--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DK
  Date: 2016-01-14
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<div class="container">
    <h2>Add Cities to your journey</h2>
    <table>
        <tr>
            <td width="50">Id</td>
            <td width="150">Name</td>
            <td width="50"></td>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td><c:out value="${city.id}"/><input type="hidden" name="id"></td>
                <td><c:out value="${city.name}"/><input type="hidden" name="name"></td>
                <form action="/addJourney" method="post">
                    <input type="hidden" name="name" value="${city.name}"/>
                    <td><input type="submit" value="Add"/></td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <h3><div class="form-group form">
        <form action='/addJourneySomeones' method="post">
            <div>
                <label>Add your own city:</label>
                <input type="text" id="cityId" name="cityId" placeholder="city name" class="form-control"/>
            </div>
            <button id="addCityButton" class="form-control">Add</button>
        </form></div></h3>
    <h4><a href="/user/userPanel">Save</a> </h4>
</div>
</body>
</html>
