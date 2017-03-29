<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSP page</title>
</head>
<body>

    <h1>Hello ${userOpt.firstName} ${userOpt.lastName} </h1>

<h2> Users</h2>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach var="tempUser" items="${users}">

        <tr>
            <td>${tempUser.firstName}</td>
            <td>${tempUser.lastName}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
