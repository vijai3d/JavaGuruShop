<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Vijai3D
  Date: 05.03.2017
  Time: 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .bg-footer {
        background-color: #2f2f2f;
        color: #ffffff;
    }
</style>
<footer class="container-fluid bg-footer text-center">
    <p>
        <%
            int startYear = 2017;
            String currentYear = new SimpleDateFormat("Y").format(new Date());
            if (Integer.valueOf(currentYear) == startYear) {
                out.print(currentYear + " ");
            } else {
                out.print(startYear + " - " + currentYear + " ");
            }
        %>
        JavaGuruShop.</p>
</footer>
