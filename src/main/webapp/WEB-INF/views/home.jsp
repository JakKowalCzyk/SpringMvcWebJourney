<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<html>
<head>
    <title><spring:message code="welcome"/></title>
</head>
<body>
<div class="container"/>
    <h2><spring:message code="hello"/></h2>
    <form:form method="GET"/>
    <br/>
    <a href="user?register">register</a><br/>
    <a href="login">login</a><br/>



</div>
</body>
</html>