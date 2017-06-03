
<jsp:include page="../../includes/header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach var="customers" items="${customerList}">

<table class="table table-striped">
    <tbody>
        <tr>
            <td>${customers.name}</td>
            <td>${customers.email}</td>
            <td>${customers.country}</td>
        </tr>
    </tbody>
</table>
</c:forEach>