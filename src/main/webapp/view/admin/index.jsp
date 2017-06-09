<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="sidebar.jsp"/>

<div class="col-8">
    <div class="card">
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
    </div>
</div>
</div>
</body>