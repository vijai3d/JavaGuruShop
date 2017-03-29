<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <title>JSP page</title>
</head>
<body>

    <h1>Hello ${userOpt.firstName} ${userOpt.lastName} </h1>

    <div class ="container">
        <div class="row justify-content-center">
            <div class="col-8">
                <h2> Users</h2>
                    <table class="table table-hover table-sm">
                        <thead class="thead-inverse">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="tempUser" items="${users}">
                            <tr>
                                <td>${tempUser.firstName}</td>
                                <td>${tempUser.lastName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>
    </div>
</body>
</html>
