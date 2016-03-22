<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DK
  Date: 2016-03-22
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update your journey</title>
</head>
<body>
<div class="container">
    <h2>Update your journey</h2>
    <table>
        <tr>
            <td width="150">Name</td>
            <td width="50"></td>
        </tr>
        <c:forEach items="${journeyList}" var="city">
            <tr>
                <td><c:out value="${city.city}"/><input type="hidden" name="name"></td>
                <%--<form action="/addJourney" method="post">--%>
                    <%--<input type="hidden" name="name" value="${city.city}"/>--%>
                    <%--<td><input type="submit" value="Delete"/></td>--%>
                <%--</form>--%>
            </tr>
        </c:forEach>
    </table>
    <%--<h3><div class="form-group form">--%>
        <%--<form action='/addJourneySomeones' method="post">--%>
            <%--<div>--%>
                <%--<label>Add your own city:</label>--%>
                <%--<input type="text" id="cityId" name="cityId" placeholder="city name" class="form-control"/>--%>
            <%--</div>--%>
            <%--<button id="addCityButton" class="form-control">Add</button>--%>
        <%--</form></div></h3>--%>
    <h4><a href="/user/userPanel">Save</a> </h4>
</div>
</body>
</html>
