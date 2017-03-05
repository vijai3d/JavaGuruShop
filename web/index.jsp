<%--
  Created by IntelliJ IDEA.
  User: Vijai3D
  Date: 04.03.2017
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JavaGuru Home</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
        integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
          integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

  <jsp:include page="/includes/header.jsp"/>

</head>
<body>




<form action="test" method="get">
  <input type="hidden" name="action" value="add">
  <div class="form-group">
    <label for=""></label>
    <input type="text" class="form-control" name="inputName" value="${inputName}" id="" aria-describedby="helpId" placeholder="">
    <small id="" class="form-text text-muted">Enter customer Name</small>
    <label for=""></label>
    <input type="text" class="form-control" name="inputLastName" value="${inputLastName}" id="" aria-describedby="helpId" placeholder="">
    <small id="" class="form-text text-muted">Enter customer Last Name</small>
  </div>
  <input name=""  class="btn btn-primary|secondary|success|info|warning|danger" type="submit" value="Submit">
</form>

<jsp:include page="/includes/footer.jsp"/>
</body>
</html>
