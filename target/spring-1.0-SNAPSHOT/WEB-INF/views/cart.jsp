<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Cities</title>
</head>
<body>
<div class="container">
    <h2>All cities</h2>
    <table>
        <tr>
            <td width="50">Id</td>
            <td width="150">Name</td>
        </tr>
        <c:forEach items="${cities}" var="city">
            <tr>
                <td><c:out value="${city.id}"/></td>
                <td><c:out value="${city.name}"/></td>
            </tr>
        </c:forEach>
    </table>
        <%--<input type="submit" value="Place Order"/>--%>
    </form>

</div>
</body>
</html>