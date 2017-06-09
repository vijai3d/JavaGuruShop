<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true"%>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/font-awesome.min.css">
    <style>

        .nb-error {
            margin: 0 auto;
            text-align: center;
            max-width: 480px;
            padding: 60px 30px;
        }

        .nb-error .error-code {
            color: #2d353c;
            font-size: 96px;
            line-height: 100px;
        }

        .nb-error .error-desc {
            font-size: 12px;
            color: #647788;
        }
        .nb-error .input-group{
            margin: 30px 0;
        }
    </style>
</head>
<body>
<div class="nb-error">
    <div class="error-code"><%=response.getStatus() %></div>
    <% if(response.getStatus() == 404){ %>
    <h3 class="font-bold">We couldn't find the page..</h3>
    <%}else if  (response.getStatus() == 500) {%>
    <h3 class="font-bold">Internal Server error, please contact administrator...</h3>
<%} else {%>
    <h3 class="font-bold">Something strange is going here...</h3>
    <% } %>
    <div class="error-desc">
        <div class="input-group">
            <input type="text" placeholder="Try with a search" class="form-control">
            <span class="input-group-btn">
               <button type="button" class="btn btn-default">
                  <em class="fa fa-search"></em>
               </button>
            </span>
        </div>
        <ul class="list-inline text-center text-sm">
            <li class="list-inline-item"><a href="/index" class="text-muted">Start again</a>
            </li>
            <li class="list-inline-item"><a href="/login" class="text-muted">Login</a>
            </li>
            <li class="list-inline-item"><a href="/signup" class="text-muted">Register</a>
            </li>
        </ul>
        <div class="text-center">
            <span>JavaGuruShop?</span>
            <span>2016</span>
            <span>-</span>
            <span><fmt:formatDate value="${date}" pattern="yyyy" /></span>
        </div>
    </div>
</div>
</body>
</html>
