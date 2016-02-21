<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<html>
<head>
    <title><spring:message code="welcome"/></title>
    <%--<jsp:include page="/WEB-INF/views/include/head-include.jsp" />--%>
</head>
<body>
<div class="container"/>
    <h2><spring:message code="featuredProducts"/></h2>
    <a href="cart">cart</a><br/>
    <form:form method="GET"/>
    <br/>
    <a href="user?register">register</a><br/>
    <a href="login">login</a><br/>

    <%--<h2> <spring:message code="categories"/> </h2>--%>
    <%--<c:forEach var="category" items="${allCategories}">--%>
        <%--<a href="categories/${category.id}"><c:out value="${category.name}"/></a> <br/>--%>
    <%--</c:forEach>--%>

</div>
</body>
</html>