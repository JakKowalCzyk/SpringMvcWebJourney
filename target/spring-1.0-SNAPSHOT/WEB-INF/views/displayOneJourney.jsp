<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DK
  Date: 2016-03-15
  Time: 09:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <table>
        <tr>
            <td width="150">Name</td>
        </tr>
        <c:forEach items="${journeyList}" var="journ">
            <tr>
                <td><c:out value="${journ.city}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
