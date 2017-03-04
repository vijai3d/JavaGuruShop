<%--
  Created by IntelliJ IDEA.
  User: Vijai3D
  Date: 04.03.2017
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<label>Hello: </label>
<span>${customer.custName} ${customer.custLastName}</span>
<form action="" method="get">
    <input type="hidden" name="action" value="start">

    <input type="submit" value="Return">
</form>
</body>
</html>
